package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 报表模版
 * This classe is based on ValueObject Pattern
 */
public class TransRepReptemplateDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransRepReptemplateDto() {
    }
	
          private String f_treeid; //分类ID
          private String f_applicationid; //应用系统
          private String f_name; //名称
          private String freporttype; //报表类型
          private String f_otherinfo; //其他信息
          private String f_description; //描述
          private String f_reptmplid; //报表模板ID
          private int version; //数据库版本控制
          private java.util.Collection freprepresult1; //报表模板ID
          private String trans_zrepreptemplate1; //报表模板内容
    	 
	
   /**
     * getters and setters
     */
            public void setF_treeid(String f_treeid){
        this.f_treeid=f_treeid;
    }
	   public String getF_treeid(){
      return f_treeid;
    }
             public void setF_applicationid(String f_applicationid){
        this.f_applicationid=f_applicationid;
    }
	   public String getF_applicationid(){
      return f_applicationid;
    }
             public void setF_name(String f_name){
        this.f_name=f_name;
    }
	   public String getF_name(){
      return f_name;
    }
             public void setFreporttype(String freporttype){
        this.freporttype=freporttype;
    }
	   public String getFreporttype(){
      return freporttype;
    }
             public void setF_otherinfo(String f_otherinfo){
        this.f_otherinfo=f_otherinfo;
    }
	   public String getF_otherinfo(){
      return f_otherinfo;
    }
             public void setF_description(String f_description){
        this.f_description=f_description;
    }
	   public String getF_description(){
      return f_description;
    }
             public void setF_reptmplid(String f_reptmplid){
        this.f_reptmplid=f_reptmplid;
    }
	   public String getF_reptmplid(){
      return f_reptmplid;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setFreprepresult1(java.util.Collection freprepresult1){
        this.freprepresult1=freprepresult1;
    }
	   public java.util.Collection getFreprepresult1(){
      return freprepresult1;
    }
             public void setTrans_zrepreptemplate1(String trans_zrepreptemplate1){
        this.trans_zrepreptemplate1=trans_zrepreptemplate1;
    }
	   public String getTrans_zrepreptemplate1(){
      return trans_zrepreptemplate1;
    }
       
  

}