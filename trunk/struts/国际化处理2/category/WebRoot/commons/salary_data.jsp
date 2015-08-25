<% java.util.List presidents = new java.util.ArrayList(); %>
<% for(int i=0;i<100;i++){%>
<%java.util.Map president = new java.util.HashMap();
       president.put("NAME", "LIMING");
	    president.put("BASE", 1500);
	    president.put("JIANG", 200.23);
	    president.put("OTHER", 107.23);

	    presidents.add(president);

	    president = new java.util.HashMap();
	    president.put("NAME", "ZHANGJING");
	    president.put("BASE", 1500);
	    president.put("JIANG", 200.23);
	    president.put("OTHER", 107.23);
	    presidents.add(president);

	    president = new java.util.HashMap();
	    president.put("NAME", "WANGWU");
	    president.put("BASE", 18000);
	    president.put("JIANG", 200.23);
	    president.put("OTHER", 107.23);
	    presidents.add(president);

	     president = new java.util.HashMap();
	     president.put("NAME", "ZHAOLIU");
	     president.put("BASE", 500);
		    president.put("JIANG", 200.23);
		    president.put("OTHER", 107.23);
	    presidents.add(president);

	    president = new java.util.HashMap();
	    president.put("NAME", "TOM");
	    president.put("BASE", 1900);
	    president.put("JIANG", 200.23);
	    president.put("OTHER", 107.23);
	    presidents.add(president);

	    president = new java.util.HashMap();
	    president.put("NAME", "JANNY");
	    president.put("BASE", 2100);
	    president.put("JIANG", 200.23);
	    president.put("OTHER", 107.23);
	    presidents.add(president);

	   president = new java.util.HashMap();
	   president.put("NAME", "JIE");
	   president.put("BASE", 100);
	    president.put("JIANG", 200.23);
	    president.put("OTHER", 107.23);
	    presidents.add(president);

	     president = new java.util.HashMap();
	     president.put("NAME", "HONG");
	     president.put("BASE", 1200);
		    president.put("JIANG", 200.23);
		    president.put("OTHER", 107.23);
	    presidents.add(president);

	     president = new java.util.HashMap();
	     president.put("NAME", "HAO");
	     president.put("BASE", 1600);
		    president.put("JIANG", 200.23);
		    president.put("OTHER", 107.23);
	    presidents.add(president);

}%>
	    <% request.setAttribute("recordList", presidents); %>

