package com.hitb.ldap;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import com.hitb.dsss.persistent.Aa_factbaspati_synBean;
import netscape.ldap.LDAPAttribute;
import netscape.ldap.LDAPAttributeSet;
import netscape.ldap.LDAPConnection;
import netscape.ldap.LDAPEntry;
import netscape.ldap.LDAPException;
import netscape.ldap.LDAPModification;
import netscape.ldap.LDAPModificationSet;
import netscape.ldap.LDAPSearchResults;

public class HitbLdap {

	private int status = -1;

	private Aa_factbaspati_synBean bean = null;

	private String MY_HOST = null;

	private String MGR_DN = null;

	private String MGR_PW = null;

	private int MY_PORT;

	private String MY_FILTER = null;

	private String MY_SEARCHBASE = null;

	private LDAPSearchResults res = null;

	private CompositeConfiguration config = null;

	private LDAPConnection ld = null;

	public void doLdap(Object object) {

		if (object instanceof Aa_factbaspati_synBean) {

			ld = new LDAPConnection();
			bean = (Aa_factbaspati_synBean) object;
			loadProperties();
			search();
			//
			if (res == null) {
				new HitbLdapException("LDAPSearchResults is null")
						.printStackTrace();
				return;
			} else {

				switch (status) {
				case -1:
					new HitbLdapException("ldap search error")
							.printStackTrace();
					break;
				case 0:
					add();
					break;
				case 1:
					modif();
					break;
				default:
					new HitbLdapException("LDAPSearchResults !=1")
							.printStackTrace();
					break;
				}

			}

		} else {
			new HitbLdapException(
					"this object not instance of Aa_factbaspati_synBean class")
					.printStackTrace();
			return;
		}

	}

	private void search() {

		// String org_id = bean.getAd_org_id().toString();
		String factid = bean.getFactid();
		//
		MY_FILTER = "uid=" + factid;
		int i = 0;
		//
		try {
			ld.connect(MY_HOST, MY_PORT);
			res = ld.search(MY_SEARCHBASE, LDAPConnection.SCOPE_SUB, MY_FILTER,
					null, false);
			while (res.hasMoreElements()) {
				while (res.hasMoreElements()) {
					res.nextElement();
					i++;
				}
			}
			this.status = i;
			ld.disconnect();
			return;
		} catch (LDAPException e) {
			e.printStackTrace();
			return;
		}

	}

	private void loadProperties() {

		config = new CompositeConfiguration();
		try {
			config.addConfiguration(new PropertiesConfiguration(
					"ldap.properties"));

		} catch (ConfigurationException e) {
			e.printStackTrace();
			return;
		}
		MY_HOST = config.getString("MY_HOST");
		MY_PORT = config.getInt("MY_PORT");
		//
		String temp = config.getList("MY_SEARCHBASE").toString();
		MY_SEARCHBASE = (String) temp.subSequence(1, temp.length() - 1);
		//
		temp = config.getList("MGR_DN").toString();
		//
		MGR_DN = (String) temp.subSequence(1, temp.length() - 1);
		MGR_PW = config.getString("MGR_PW");

	}

	private void add() {

		LDAPAttributeSet attrs = new LDAPAttributeSet();

		String objclass[] = { "top", "factbaspati" };

		attrs.add(new LDAPAttribute("objectclass", objclass));

		attrs.add(new LDAPAttribute("UPDATED", bean.getUpdated().toString()));
		attrs
				.add(new LDAPAttribute("UPDATEDBY", bean.getUpdatedby()
						.toString()));

		attrs
				.add(new LDAPAttribute("CLIENT", bean.getAd_client_id()
						.toString()));

		attrs.add(new LDAPAttribute("CONTACTPHONE", bean.getContactphone()));
		attrs.add(new LDAPAttribute("CREATED", bean.getCreated().toString()));
		attrs.add(new LDAPAttribute("CURFACTID", bean.getCurfactid()));

		attrs.add(new LDAPAttribute("FACTZJID", bean.getAa_fact_zj_id()
				.toString()));
		//
		attrs.add(new LDAPAttribute("FACTZYID", bean.getAa_fact_zy_id()
				.toString()));

		attrs.add(new LDAPAttribute("FACTHJID", bean.getAa_fact_hj_id()
				.toString()));

		attrs.add(new LDAPAttribute("FACTHZID", bean.getAa_fact_hz_id()
				.toString()));

		attrs.add(new LDAPAttribute("ORG", bean.getAd_org_id().toString()));

		attrs.add(new LDAPAttribute("PCARDNO", bean.getPcardno()));
		attrs.add(new LDAPAttribute("ISACTIVE", bean.getIsactive()));

		attrs.add(new LDAPAttribute("STATUS", bean.getStatus().toString()));
		attrs.add(new LDAPAttribute("PATINAME", bean.getPatiname()));
		attrs.add(new LDAPAttribute("SEX ", bean.getSex().toString()));
		attrs.add(new LDAPAttribute("BIRTHDAY", bean.getBirthday().toString()));
		attrs.add(new LDAPAttribute("INHABITADDR", bean.getInhabitaddr()));

		attrs.add(new LDAPAttribute("POSTCODE", bean.getPostcode()));

		attrs.add(new LDAPAttribute("CARDNO", bean.getCardno()));

		attrs.add(new LDAPAttribute("HISNUM", bean.getHisnum()));
		attrs.add(new LDAPAttribute("INSID", bean.getInsid()));

		attrs.add(new LDAPAttribute("FACTMZID", bean.getAa_fact_mz_id()
				.toString()));

		attrs.add(new LDAPAttribute("FACTID", bean.getFactid()));

		String dn = "uid=" + bean.getFactid() + "," + MY_SEARCHBASE;

		LDAPEntry myEntry = new LDAPEntry(dn, attrs);

		try {

			ld.connect(MY_HOST, MY_PORT);
			ld.authenticate(MGR_DN, MGR_PW);
			ld.add(myEntry);
			ld.disconnect();

		} catch (LDAPException e) {
			e.printStackTrace();
		}

	}

	private void modif() {

		LDAPModificationSet attrs = new LDAPModificationSet();
		//
		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("UPDATED", bean
				.getUpdated().toString()));
		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("UPDATEDBY", bean
				.getUpdatedby().toString()));

		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("CLIENT", bean
				.getAd_client_id().toString()));

		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("CONTACTPHONE",
				bean.getContactphone()));
		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("CREATED", bean
				.getCreated().toString()));
		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("CURFACTID", bean
				.getCurfactid()));

		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("FACTZJID", bean
				.getAa_fact_zj_id().toString()));

		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("FACTZYID", bean
				.getAa_fact_zy_id().toString()));

		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("FACTHJID", bean
				.getAa_fact_hj_id().toString()));

		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("FACTHZID", bean
				.getAa_fact_hz_id().toString()));

		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("ORG", bean
				.getAd_org_id().toString()));

		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("PCARDNO", bean
				.getPcardno()));
		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("ISACTIVE", bean
				.getIsactive()));

		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("STATUS", bean
				.getStatus().toString()));
		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("PATINAME", bean
				.getPatiname()));
		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("SEX ", bean
				.getSex().toString()));
		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("BIRTHDAY", bean
				.getBirthday().toString()));
		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("INHABITADDR",
				bean.getInhabitaddr()));

		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("POSTCODE", bean
				.getPostcode()));

		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("CARDNO", bean
				.getCardno()));

		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("HISNUM", bean
				.getHisnum()));
		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("INSID", bean
				.getInsid()));

		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("FACTMZID", bean
				.getAa_fact_mz_id().toString()));

		attrs.add(LDAPModification.REPLACE, new LDAPAttribute("FACTID", bean
				.getFactid()));

		String dn = "uid=" + bean.getFactid() + "," + MY_SEARCHBASE;

		try {
			ld.connect(MY_HOST, MY_PORT);
			ld.authenticate(MGR_DN, MGR_PW);
			ld.modify(dn, attrs);
			ld.disconnect();
		} catch (LDAPException e) {
			e.printStackTrace();
		}
	}

}
