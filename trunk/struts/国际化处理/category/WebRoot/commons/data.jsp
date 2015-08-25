<% java.util.List presidents = new java.util.ArrayList(); %>
<% for(int i=0;i<100;i++){%>
<%java.util.Map president = new java.util.HashMap();
	    president.put("NAME", "George Washington");
	    president.put("MEMO", "sdfsdsdsd1");
	    president.put("DEP", "1");
	    president.put("SEX", "1");
	    president.put("BORN", "2007-01-30 11:43:12");
	    president.put("ADD", "dssdsdsd");
	    president.put("PHONE", "12345678");
	    president.put("MEM", "1");
	    president.put("QUALI", "1");
	    president.put("MAIL", "1@1.COM");
	    president.put("OTHER", "111111111");

	    presidents.add(president);

	    president = new java.util.HashMap();
	    president.put("NAME", "George Washington2");
	    president.put("MEMO", "sdfsdsdsd2");
	    president.put("DEP", "2");
	    president.put("SEX", "0");
	    president.put("BORN", "2007-02-30 11:43:12");
	    president.put("ADD", "dssdsdsd2");
	    president.put("PHONE", "22345678");
	    president.put("MEM", "0");
	    president.put("QUALI", "2");
	    president.put("MAIL", "2@1.COM");
	    president.put("OTHER", "1122222222221111111");
	    presidents.add(president);

	    president = new java.util.HashMap();
	    president.put("NAME", "George Washington3");
	    president.put("MEMO", "sdfsdsdsd3");
	    president.put("DEP", "3");
	    president.put("SEX", "0");
	    president.put("BORN", "2007-03-30 11:43:12");
	    president.put("ADD", "dssdsdsd3");
	    president.put("PHONE", "32345678");
	    president.put("MEM", "1");
	    president.put("QUALI", "1");
	    president.put("MAIL", "3@1.COM");
	    president.put("OTHER", "33333333333333");
	    presidents.add(president);

	     president = new java.util.HashMap();
	    president.put("NAME", "George Washington4");
	    president.put("MEMO", "sdfsdsdsd4");
	    president.put("DEP", "1");
	    president.put("SEX", "1");
	    president.put("BORN", "2007-01-30 11:43:12");
	    president.put("ADD", "dssdsdsd");
	    president.put("PHONE", "12345678");
	    president.put("MEM", "1");
	    president.put("QUALI", "1");
	    president.put("MAIL", "4@1.COM");
	    president.put("OTHER", "111111111");
	    presidents.add(president);

	    president = new java.util.HashMap();
	    president.put("NAME", "George Washington5");
	    president.put("MEMO", "sdfsdsdsd");
	    president.put("DEP", "1");
	    president.put("SEX", "1");
	    president.put("BORN", "2007-01-30 11:43:12");
	    president.put("ADD", "dssdsdsd");
	    president.put("PHONE", "12345678");
	    president.put("MEM", "1");
	    president.put("QUALI", "1");
	    president.put("MAIL", "5@1.COM");
	    president.put("OTHER", "555555555555");
	    presidents.add(president);

	    president = new java.util.HashMap();
	    president.put("NAME", "George Washington6");
	    president.put("MEMO", "sdfsdsdsd");
	    president.put("DEP", "1");
	    president.put("SEX", "1");
	    president.put("BORN", "2007-01-30 11:43:12");
	    president.put("ADD", "dssdsdsd");
	    president.put("PHONE", "12345678");
	    president.put("MEM", "1");
	    president.put("QUALI", "1");
	    president.put("MAIL", "6@1.COM");
	    president.put("OTHER", "1666666661");
	    presidents.add(president);

	   president = new java.util.HashMap();
	    president.put("NAME", "George Washington7");
	    president.put("MEMO", "sdfsdsdsd");
	    president.put("DEP", "1");
	    president.put("SEX", "1");
	    president.put("BORN", "2007-01-30 11:43:12");
	    president.put("ADD", "dssdsdsd");
	    president.put("PHONE", "12345678");
	    president.put("MEM", "1");
	    president.put("QUALI", "1");
	    president.put("MAIL", "7@1.COM");
	    president.put("OTHER", "111111111");
	    presidents.add(president);

	     president = new java.util.HashMap();
	    president.put("NAME", "George Washington8");
	    president.put("MEMO", "sdfsdsdsd");
	    president.put("DEP", "1");
	    president.put("SEX", "1");
	    president.put("BORN", "2007-01-30 11:43:12");
	    president.put("ADD", "dssdsdsd");
	    president.put("PHONE", "12345678");
	    president.put("MEM", "1");
	    president.put("QUALI", "1");
	    president.put("MAIL", "8@1.COM");
	    president.put("OTHER", "111111111");
	    presidents.add(president);

	     president = new java.util.HashMap();
	    president.put("NAME", "George Washington9");
	    president.put("MEMO", "sdfsdsdsd");
	    president.put("DEP", "1");
	    president.put("SEX", "1");
	    president.put("BORN", "2007-01-30 11:43:12");
	    president.put("ADD", "dssdsdsd");
	    president.put("PHONE", "12345678");
	    president.put("MEM", "1");
	    president.put("QUALI", "1");
	    president.put("MAIL", "9@1.COM");
	    president.put("OTHER", "111111111");
	    presidents.add(president);

}%>
	    <% request.setAttribute("recordList", presidents); %>

