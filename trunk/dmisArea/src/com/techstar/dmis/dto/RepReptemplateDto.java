package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 报表模版
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class RepReptemplateDto  implements Serializable {
    
	public RepReptemplateDto() {
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
	      private com.techstar.dmis.dto.RepResdataDto zrepreptemplate1; //报表模板内容
		 

  	
	
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
           public void setZrepreptemplate1(com.techstar.dmis.dto.RepResdataDto zrepreptemplate1){
        this.zrepreptemplate1=zrepreptemplate1;
    }
	   public com.techstar.dmis.dto.RepResdataDto getZrepreptemplate1(){
      return zrepreptemplate1;
    }
      
  

}