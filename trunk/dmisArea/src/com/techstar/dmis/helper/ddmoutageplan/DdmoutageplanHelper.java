package com.techstar.dmis.helper.ddmoutageplan;

public class DdmoutageplanHelper {

	/**
	 * 获得主键
	 * 
	 * @param str
	 * @return
	 */
	public static String getKey(String str) {
		if (str == null || str.trim().length() == 0)
			return null;
		else {
			try {
				return str.substring(str.indexOf("fmonthplanno^") + 13, str
						.indexOf("@@@fworkcontent^"));
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * 
	 * 获得版本号
	 * 
	 * 
	 * @param str
	 * @return
	 */
	public static String getVersion(String str) {
		if (str == null || str.trim().length() == 0)
			return null;
		else {
			try {
				return str.substring(str.indexOf("version^") + 8, str.length());
			} catch (Exception e) {
				return null;
			}
		}
	}

	public static String pageDisposeNull(Object str) {
		return str == null ? "" : str.toString();
	}
}
