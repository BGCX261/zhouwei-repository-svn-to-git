package webx.struts.config;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] d = WebxPropertyMessageResourcesUtil.getFilesPath(
				"classpath*:modules/**/i18n/*.properties", "en_US");
		System.out.println(d.length);
	}

}
