package com.techstar.framework.service.messaging.message;

/**
 * 
 * @author yangjun
 *
 */
public class ContentType

{

    public static ContentType SP01A = new ContentType("SP01A", "1.0", "http://WSSP/SP01A", "\u7533\u62A5\u8BF7\u6C42");
//    public static ContentType SP02A = new ContentType("SP02A", "1.0", "http://WSSP/SP02A", "\u8865\u9F50\u8865\u6B63\u53CD\u9988");
//    public static ContentType SP03A = new ContentType("SP03A", "1.0", "http://WSSP/SP03A", "\u4E2D\u6B62\u5BA1\u6279\u53CD\u9988");
//    public static ContentType SP04B = new ContentType("SP04B", "1.0", "http://WSSP/SP04B", "\u53D7\u7406\u901A\u77E5\u4E66");
//    public static ContentType SP05B = new ContentType("SP05B", "1.0", "http://WSSP/SP05B", "\u4E0D\u53D7\u7406\u901A\u77E5\u4E66");
//    public static ContentType SP06B = new ContentType("SP06B", "1.0", "http://WSSP/SP06B", "\u8865\u9F50\u8865\u6B63\u901A\u77E5\u4E66");
//    public static ContentType SP07B = new ContentType("SP07B", "1.0", "http://WSSP/SP07B", "\u4E2D\u6B62\u5BA1\u6279\u901A\u77E5\u4E66");
//    public static ContentType SP08B = new ContentType("SP08B", "1.0", "http://WSSP/SP08B", "\u544A\u77E5\u901A\u77E5\u4E66");
//    public static ContentType SP09B = new ContentType("SP09B", "1.0", "http://WSSP/SP09B", "\u529E\u7ED3\u901A\u77E5\u4E66");
//    public static ContentType SP10B = new ContentType("SP10B", "1.0", "http://WSSP/SP10B", "\u65E0\u6548\u7533\u62A5\u901A\u77E5\u4E66");
//    public static ContentType SP11B = new ContentType("SP11B", "1.0", "http://WSSP/SP11B", "\u8D85\u65F6\u7533\u62A5\u901A\u77E5\u4E66");
//    public static ContentType SP12B = new ContentType("SP12B", "1.0", "http://WSSP/SP12B", "\u5185\u90E8\u73AF\u8282\u529E\u7406\u60C5\u51B5\u901A\u77E5\u4E66");
//    public static ContentType SP13A = new ContentType("SP13A", "1.0", "http://WSSP/SP13A", "\u5BA1\u6279\u7ED3\u679C\u5907\u6848");
//    public static ContentType SP14B = new ContentType("SP14B", "1.0", "http://WSSP/SP14B", "\u7F51\u4E0B\u7533\u62A5");
//    public static ContentType SP15A = new ContentType("SP15A", "1.0", "http://WSSP/SP15A", "\u4E92\u8054\u7533\u62A5\u8BF7\u6C42");
//    public static ContentType SP16B = new ContentType("SP16B", "1.0", "http://WSSP/SP16B", "\u4E92\u8054\u529E\u7ED3\u901A\u77E5\u4E66");
    
   // public static final ContentType SP01A = null;
	private final String code;
    private final String version;
    private final String uri;
    private final String describe;

    public static boolean support(String code, String version)
    {
    	return true;
       // return SP01A.equals(code, version) || SP02A.equals(code, version) || SP03A.equals(code, version) || SP04B.equals(code, version) || SP05B.equals(code, version) || SP06B.equals(code, version) || SP07B.equals(code, version) || SP08B.equals(code, version) || SP09B.equals(code, version) || SP10B.equals(code, version) || SP11B.equals(code, version) || SP12B.equals(code, version) || SP13A.equals(code, version) || SP14B.equals(code, version) || SP15A.equals(code, version) || SP16B.equals(code, version);
    }

    protected ContentType(String code, String version, String uri, String describe)
    {
        this.code = code;
        this.version = version;
        this.uri = uri;
        this.describe = describe;
    }

    public String getCode()
    {
        return code;
    }

    public String getVersion()
    {
        return version;
    }

    public String getUri()
    {
        return uri;
    }

    protected boolean equals(String code, String version)
    {
        return this.code.equals(code) && this.version.equals(version);
    }

}

