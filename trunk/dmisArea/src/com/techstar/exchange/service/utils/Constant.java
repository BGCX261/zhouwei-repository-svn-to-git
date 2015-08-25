package com.techstar.exchange.service.utils;

/**
 * 地区代码
 * 
 * @author caojian Apr 13, 2007
 * 
 */
public class Constant {
	// 市局
	public static final String SJ = "sj";

	// 海淀
	public static final String HD = "hd";

	// 朝阳
	public static final String SY = "sy";

	// 东城
	public static final String DC = "dc";

	// 西城
	public static final String XC = "xc";

	// 崇文
	public static final String CW = "cw";

	// 宣武
	public static final String XW = "xw";
	
	
	//add by xiongcf
	/**消息类型: 通知 1**/
	public static final String MESSAGETYPE_NOTIFY="1";
	/**消息类型: 公告 2**/
	public static final String MESSAGETYPE_BULLETIN="2";
	/**消息类型: 业务 3**/
	public static final String MESSAGETYPE_BUSSINESS="3";
	/**附件前缀: 通知通告类*/
	public static final String PREFIX_MSG="notifymsg";
	/**附件前缀: 接收方集合信息*/
	public static final String PREFIX_PERSON="recvinfo";
}
