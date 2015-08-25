package com.techstar.exchange.transfers.message;

public class ContentType {

	public static ContentType EX_DD_DayOnDutyLog_001 = new ContentType(
			"EX_DD_DayOnDutyLog_001", "1.0", "TransSubDto", "示例");


	private final String code;

	private final String version;

	private final String className;

	private final String describe;

	public static boolean support(String code, String version) {
		return true;
	}

	protected ContentType(String code, String version, String className,
			String describe) {
		this.code = code;
		this.version = version;
		this.className = className;
		this.describe = describe;
	}

	public String getCode() {
		return code;
	}

	public String getVersion() {
		return version;
	}

	public String getClassName() {
		return className;
	}

	public String getDescribe() {
		return describe;
	}

	protected boolean equals(String code, String version) {
		return this.code.equals(code) && this.version.equals(version);
	}

}
