package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 报表结果
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class RepRepresultDto  implements Serializable {
    
	public RepRepresultDto() {
    }
	
          private String treeid; //分类ID
	      private String fname; //名称
	      private String ftitle; //报表标题
	      private int freportyear; //报表年度
	      private String freportunit; //填报单位
	      private String frawdata; //原始报表结果数据
	      private String fotherinfo; //其他信息
	      private String fdescription; //描述
	      private int frepmonth; //报表月份
	      private int frepseason; //报表季度
	      private java.sql.Date frepday; //报表日期
	      private String sys_fille; //填写人
	      private String sys_filldept; //填写单位
	      private java.sql.Timestamp sys_filltime; //填写时间
	      private int sys_isvalid; //是否有效字段
	      private String sys_dataowner; //数据所属单位
	      private String frepresultid; //报表结果ID
	      private int version; //数据库版本控制
	      private java.util.Collection freptree2result2; //报表结果ID
	      private com.techstar.dmis.dto.RepReptemplateDto zreprepresult1; //报表模板ID
	      private com.techstar.dmis.dto.RepResdataDto zreprepresult2; //HTML报表结果
		 

  	
	
   /**
     * getters and setters
     */
           public void setTreeid(String treeid){
        this.treeid=treeid;
    }
	   public String getTreeid(){
      return treeid;
    }
           public void setFname(String fname){
        this.fname=fname;
    }
	   public String getFname(){
      return fname;
    }
           public void setFtitle(String ftitle){
        this.ftitle=ftitle;
    }
	   public String getFtitle(){
      return ftitle;
    }
           public void setFreportyear(int freportyear){
        this.freportyear=freportyear;
    }
	   public int getFreportyear(){
      return freportyear;
    }
           public void setFreportunit(String freportunit){
        this.freportunit=freportunit;
    }
	   public String getFreportunit(){
      return freportunit;
    }
           public void setFrawdata(String frawdata){
        this.frawdata=frawdata;
    }
	   public String getFrawdata(){
      return frawdata;
    }
           public void setFotherinfo(String fotherinfo){
        this.fotherinfo=fotherinfo;
    }
	   public String getFotherinfo(){
      return fotherinfo;
    }
           public void setFdescription(String fdescription){
        this.fdescription=fdescription;
    }
	   public String getFdescription(){
      return fdescription;
    }
           public void setFrepmonth(int frepmonth){
        this.frepmonth=frepmonth;
    }
	   public int getFrepmonth(){
      return frepmonth;
    }
           public void setFrepseason(int frepseason){
        this.frepseason=frepseason;
    }
	   public int getFrepseason(){
      return frepseason;
    }
           public void setFrepday(java.sql.Date frepday){
        this.frepday=frepday;
    }
	   public java.sql.Date getFrepday(){
      return frepday;
    }
           public void setSys_fille(String sys_fille){
        this.sys_fille=sys_fille;
    }
	   public String getSys_fille(){
      return sys_fille;
    }
           public void setSys_filldept(String sys_filldept){
        this.sys_filldept=sys_filldept;
    }
	   public String getSys_filldept(){
      return sys_filldept;
    }
           public void setSys_filltime(java.sql.Timestamp sys_filltime){
        this.sys_filltime=sys_filltime;
    }
	   public java.sql.Timestamp getSys_filltime(){
      return sys_filltime;
    }
           public void setSys_isvalid(int sys_isvalid){
        this.sys_isvalid=sys_isvalid;
    }
	   public int getSys_isvalid(){
      return sys_isvalid;
    }
           public void setSys_dataowner(String sys_dataowner){
        this.sys_dataowner=sys_dataowner;
    }
	   public String getSys_dataowner(){
      return sys_dataowner;
    }
           public void setFrepresultid(String frepresultid){
        this.frepresultid=frepresultid;
    }
	   public String getFrepresultid(){
      return frepresultid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setFreptree2result2(java.util.Collection freptree2result2){
        this.freptree2result2=freptree2result2;
    }
	   public java.util.Collection getFreptree2result2(){
      return freptree2result2;
    }
           public void setZreprepresult1(com.techstar.dmis.dto.RepReptemplateDto zreprepresult1){
        this.zreprepresult1=zreprepresult1;
    }
	   public com.techstar.dmis.dto.RepReptemplateDto getZreprepresult1(){
      return zreprepresult1;
    }
           public void setZreprepresult2(com.techstar.dmis.dto.RepResdataDto zreprepresult2){
        this.zreprepresult2=zreprepresult2;
    }
	   public com.techstar.dmis.dto.RepResdataDto getZreprepresult2(){
      return zreprepresult2;
    }
      
  

}