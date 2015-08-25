/** 
 * @{#} Synchronizer.java Create on 2008-7-28 下午02:24:19   
 *   
 * Copyright (c) 2006- by CE.   
 */   
package com.sitechasia.webx.core.cache.synchronize;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jgroups.Address;
import org.jgroups.Channel;
import org.jgroups.ChannelException;
import org.jgroups.ChannelListener;
import org.jgroups.ExtendedReceiverAdapter;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.util.Util;

import com.sitechasia.webx.core.cache.ICacheProvider;

/**
 * 域对象事件同步器
 * 
 * @author MarkDong
 * @version 1.0   
 * @see  
 */
public class Synchronizer extends ExtendedReceiverAdapter implements ChannelListener {
	private Log logger = LogFactory.getLog(this.getClass());
	private Integer randomNum;	//随机数，用于屏蔽自身的消息
	
	private ICacheProvider webxCacheProvider;
	private Channel channel;		//通信信道
	private String propertyFile;	//配置文件名称
	private boolean initialized = false;	//初始化是否成功
	
	private String groupName = "WEBX_CACHE_CHANNEL";
	
	public void setWebxCacheProvider(ICacheProvider webxCacheProvider) {
		this.webxCacheProvider = webxCacheProvider;
	}

	public void setPropertyFile(String propertyFile) {
		this.propertyFile = propertyFile;
	}

	/**
	 * 设置集群信道名称
	 * 
	 * @param groupName 信道名称
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}



	/**
	 * 初始化通信信道
	 */
	public void init() {
		try {
			channel = new JChannel(propertyFile);
	        channel.setOpt(Channel.AUTO_RECONNECT, Boolean.TRUE);
	        channel.setReceiver(this);
	        channel.addChannelListener(this);
			channel.connect(groupName);
			Random rand = new Random(System.currentTimeMillis());
			randomNum = rand.nextInt();
	        initialized = true;
		} catch (ChannelException e) {
			logger.error("域对象事件监听器初始化失败", e);
		}
	}
	
	

	@Override
	public void receive(Message msg) {
        byte[] buf=msg.getRawBuffer();
        if(buf == null) {
            logger.warn("收到空消息");
            return;
        }
        
        try {
			DomainObjectEvent event = (DomainObjectEvent)Util.streamableFromByteBuffer(DomainObjectEvent.class, buf, msg.getOffset(), msg.getLength());
			if(randomNum.equals(event.getRandomNum())) return;	//屏蔽自身发送的消息
			
	        logger.debug("收到同步消息" + event);
			if(webxCacheProvider == null) return;
			if(event.getSimple()) {
				webxCacheProvider.onChange(event.getEntityClass());
			} else {
				webxCacheProvider.onChange(event.getEntityClass(), event.getProperty(), event.getValue());
			}
			
		} catch (Exception e) {
			logger.error("域对象消息处理失败", e);
		}
	}



	public void send(DomainObjectEvent event) {
		//初始化不成功
		if(!initialized)
			return;
		event.setRandomNum(randomNum);
		byte[] buf;
		try {
			buf = Util.streamableToByteBuffer(event);
			Message msg = new Message(null, null, buf);
			channel.send(msg);
		} catch (Exception e) {
			logger.error("发送域对象消息发生错误", e);
		}
		logger.debug("发送消息" + event);
	}
	
	//以下为信道状态监控回调函数
	public void channelClosed(Channel channel) {
		logger.warn("信道已经关闭");
	}

	public void channelConnected(Channel channel) {
		logger.debug("信道以连通");
		
	}

	public void channelDisconnected(Channel channel) {
		logger.debug("信道失去连接");
	}

	public void channelReconnected(Address addr) {
		logger.debug("信道重新建立连接");
		
	}

	public void channelShunned() {
		//FIXME: 不知道怎么翻译
		logger.warn("信道回避");
	}

}
