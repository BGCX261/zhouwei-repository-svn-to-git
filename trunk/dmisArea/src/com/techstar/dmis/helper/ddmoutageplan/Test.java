package com.techstar.dmis.helper.ddmoutageplan;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "fmonthplanno^BB2AB0DFFFFC4402613DD893A2CDF0@@@fworkcontent^@@@foutagearea^@@@fdispatchrange^@@@fstarttime^@@@fendtime^@@@sys_dataowner^@@@monthplantype^@@@fexcutestatus^@@@fvoltage^uyuyu@@@version^0";

		System.out.println(DdmoutageplanHelper.getKey(str));
		System.out.println("OTHER:" + DdmoutageplanHelper.getVersion(str));
	}

}
