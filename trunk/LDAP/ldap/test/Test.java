package test;

import java.util.Date;

import com.hitb.dsss.persistent.Aa_factbaspati_synBean;
import com.hitb.ldap.HitbLdap;

public class Test {

	public static void main(String[] args) {

		Aa_factbaspati_synBean bean = new Aa_factbaspati_synBean();
		Long.valueOf("1");
		bean.setAa_fact_hj_id(Long.valueOf("1"));
		bean.setAa_fact_hz_id(Long.valueOf("1"));
		bean.setAa_fact_jz_id(Long.valueOf("1"));
		bean.setAa_fact_mz_id(Long.valueOf("1"));
		bean.setAa_fact_zj_id(Long.valueOf("1"));
		bean.setAa_factbaspati_syn_id(Long.valueOf("1"));
		bean.setAd_client_id(Long.valueOf("1"));
		bean.setAd_org_id(Long.valueOf("12"));
		bean.setAddress("beijing");
		bean.setBirthday(new Date());
		bean.setCard_create_bt("zhouwei");
		bean.setCard_query("query");
		bean.setCardno("010");
		bean.setContactphone("");
		bean.setCreated(new Date());
		bean.setCreatedby(Long.valueOf("1"));
		bean.setCurfactid("9100");
		bean.setFactid("130");
		bean.setHisnum("001");
		bean.setInhabitaddr("zhou");
		bean.setInsid("ok");
		bean.setIsactive("Y");
		bean.setPatiente("zhouwie");
		bean.setPatiname("ak48");
		bean.setPcardno("1000");
		bean.setPostcode("100089");
		bean.setSex(Long.valueOf("1"));
		bean.setStatus(Long.valueOf("1"));
		bean.setTransnum("ok");
		bean.setUpdated(new Date());
		bean.setUpdatedby(Long.valueOf("1"));
		// bean.setVersion(Long.valueOf("1"));
		bean.setAa_fact_zy_id(Long.valueOf("1"));

		HitbLdap ldap = new HitbLdap();
		System.out.println(System.currentTimeMillis());
		ldap.doLdap(bean);
		System.out.println(System.currentTimeMillis());

	}

}
