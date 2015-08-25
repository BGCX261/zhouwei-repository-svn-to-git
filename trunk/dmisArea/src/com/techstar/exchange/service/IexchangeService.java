package com.techstar.exchange.service;

import java.util.List;

import com.techstar.exchange.dto.control.ControlDto;
import com.techstar.exchange.dto.control.QueryDto;

/**
 * 数据交换服务对外接口
 * 
 * @author caojian Apr 3, 2007
 * modify by xiongcf 2007-4-19
 */
public interface IexchangeService {

	/**
	 * 发送业务消息	 * @param control
	 *            控制信息Dto
	 * @param bussinessDto
	 *            业务信息Dto
	 * @throws Exception
	 */
	public void sendMessage(ControlDto control, Object bussinessDto)
			throws Exception;
	
	
	
	
	/**
	 * 根据配置文件中接收与发送队列循环接收esb消息
	 * @param from 发送方编码
	 * @param to 接收方编码
	 * @throws Exception
	 */
	public void recvMessage() throws Exception;
	
	
	/**
	 * 发送通知或公告消息
	 * @param control 控制信息Dto
	 * @param message 消息内容
	 * @throws Exception
	 */
	public void sendMessage(ControlDto control, String message)throws Exception; 
	
	/**
	 * 接收通知或公告消息
	 * @param querydto 查询条件对象
	 * @param type 类型1-通知 2-公告
	 * @return 返回字符串集合
	 * @throws Exception
	 */
	public List recvMessage(QueryDto querydto,String type) throws Exception;
	
	
	/**
	 * 接收业务消息
	 * @param querydto 查询条件对象
	 * @return 返回的集合中存放的是满足查询条件的控制Dto、业务对象Dto
	 * @throws Exception
	 */
	public List recvMessage(QueryDto querydto) throws Exception;

}
