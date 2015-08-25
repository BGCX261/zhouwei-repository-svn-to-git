package com.techstar.framework.service.messaging.message;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.server.UID;
import java.text.*;
import java.util.Date;

/**
 * 
 * @author yangjun
 * 
 */
public class Util {

	private static final DateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private Util() {
	}

	public static String generateTraceNumber() {
		String traceNumber = null;
		try {
			String hostIp = InetAddress.getLocalHost().getHostAddress();
			UID uid = new UID();
			StringBuffer sb = new StringBuffer();
			sb.append(uid.toString());
			sb.append("@");
			sb.append(hostIp);
			traceNumber = sb.toString();
		} catch (UnknownHostException ex) {
			throw new RuntimeException(
					"\u4E0D\u80FD\u521B\u5EFA\u6D88\u606F\u5E8F\u5217\u53F7",
					ex);
		}
		return traceNumber;
	}

	public static String generateTimeStamp() {
		Date now = new Date();
		return dateFormat.format(now);
	}

	public static Date parseTimeStamp(String timeStamp) {
		try {
			return dateFormat.parse(timeStamp);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String getMapQueueName(String from, String to) {
		
		
		
		return "";
	}

}
