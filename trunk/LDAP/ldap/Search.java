import netscape.ldap.*;
import java.util.*;

import javax.naming.directory.SearchControls;

public class Search {
	public static void main(String[] args) throws LDAPReferralException {
		LDAPConnection ld = null;
		int status = -1;

		int i = 0;
		try {
			ld = new LDAPConnection();
			/* Connect to server */
			String MY_HOST = "192.168.0.150";
			int MY_PORT = 389;
			// ld.connect(MY_HOST, MY_PORT);
			//
			// String[] myAttrs = { "CLIENT" };
			/* search for all entries with surname of Jensen */
			String MY_FILTER = "uid=0000000000002103";// "sn=Administrator"
			// //uid=ychen,ou=human
			// resources,dc=.
			// uid=admin,ou=administrators,ou=topologymanagement,o=netscaperoot
			String MY_SEARCHBASE1 = "cn=Directory Manager";
			String MY_SEARCHBASE = "ou=10810,ou=chaoyang,dc=health,dc=com";// o=NetscapeRoot
			// String MY_FILTER = "sn=*³Â*";s
			// "sn=Administrator"
			// String MY_SEARCHBASE1 =
			// "uid=admin,ou=administrators,ou=topologymanagement,o=netscaperoot";
			// String MY_SEARCHBASE = "tid=New,ou=human resources,dc=.";//
			// o=NetscapeRoot

			// LDAPSearchConstraints cons = ld.getSearchConstraints();
			// cons.setReferrals( true );
			ld.connect(MY_HOST, MY_PORT);
			// ld.bind(3,MY_SEARCHBASE1, "123456");

//			ld.setOption(LDAPv2.SIZELIMIT, new Integer(-1));

			LDAPSearchResults res = ld.search("ou=10810, ou=chaoyang, dc=health, dc=com",
					LDAPConnection.SCOPE_SUB, MY_FILTER, null, false);

			System.out.println(res.getCount());

			while (res.hasMoreElements()) {
				/* Next directory entry */

				LDAPEntry findEntry = (LDAPEntry) res.nextElement();

				i++;

				// LDAPEntry findEntry = (LDAPEntry) res.nextElement();
				System.out.println(findEntry.getDN());
				/* Get the attributes of the entry */
				LDAPAttributeSet findAttrs = findEntry.getAttributeSet();
				Enumeration enumAttrs = findAttrs.getAttributes();
				System.out.println("\tAttributes: ");
				/* Loop on attributes */
				while (enumAttrs.hasMoreElements()) {
					LDAPAttribute anAttr = (LDAPAttribute) enumAttrs
							.nextElement();
					String attrName = anAttr.getName();
					System.out.println("\t\t" + attrName);
					/* Loop on values for this attribute */

					Enumeration enumVals = anAttr.getStringValues();
					if (enumVals != null) {
						while (enumVals.hasMoreElements()) {
							String aVal = (String) enumVals.nextElement();
							System.out.println("\t\t\t" + aVal);
						}
					}
				}
			}
			status = 0;
		} catch (LDAPException e) {
			System.out.println("Error: " + e.toString());
		}
		/* Done, so disconnect */
		if ((ld != null) && ld.isConnected()) {
			try {
				ld.disconnect();
			} catch (LDAPException e) {
				System.out.println("Error: " + e.toString());
			}
		}
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + i);
		System.exit(status);
	}
}
