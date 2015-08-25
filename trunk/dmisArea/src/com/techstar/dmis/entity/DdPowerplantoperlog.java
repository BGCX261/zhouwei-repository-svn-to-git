package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 火电厂运行记录
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdPowerplantoperlog implements Serializable {
    
	public DdPowerplantoperlog() {
    }
    		 private java.sql.Date flogdate;//记录日期
					 private String flogtime;//时间
					 private String fpowerplantname;//发电厂名
					 private String fboilerno;//锅炉(机组)编号
					 private String fplanity;//计划性
					 private String freason;//原因
					 private String fdutydirector;//值长
					 private String sys_fille;//填写人
					 private String sys_filldept;//填写单位
					 private java.sql.Timestamp sys_filltime;//填写时间
					 private int sys_isvalid;//是否有效字段
					 private String sys_dataowner;//数据所属单位
					 private String fgeneratorstatus;//机组状态
					 private String fwriteinlog;//是否写入日志
					 private String fwriteinwglog;//是否写入班志
					 private String fid;//记录编号
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.DdClassondutylog zddpowerplantoperlog4;
	    		
   /**
     * getters and setters
     */
           public void setFlogdate(java.sql.Date flogdate){
        this.flogdate=flogdate;
    }
	   public java.sql.Date getFlogdate(){
      return flogdate;
    }
           public void setFlogtime(String flogtime){
        this.flogtime=flogtime;
    }
	   public String getFlogtime(){
      return flogtime;
    }
           public void setFpowerplantname(String fpowerplantname){
        this.fpowerplantname=fpowerplantname;
    }
	   public String getFpowerplantname(){
      return fpowerplantname;
    }
           public void setFboilerno(String fboilerno){
        this.fboilerno=fboilerno;
    }
	   public String getFboilerno(){
      return fboilerno;
    }
           public void setFplanity(String fplanity){
        this.fplanity=fplanity;
    }
	   public String getFplanity(){
      return fplanity;
    }
           public void setFreason(String freason){
        this.freason=freason;
    }
	   public String getFreason(){
      return freason;
    }
           public void setFdutydirector(String fdutydirector){
        this.fdutydirector=fdutydirector;
    }
	   public String getFdutydirector(){
      return fdutydirector;
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
           public void setFgeneratorstatus(String fgeneratorstatus){
        this.fgeneratorstatus=fgeneratorstatus;
    }
	   public String getFgeneratorstatus(){
      return fgeneratorstatus;
    }
           public void setFwriteinlog(String fwriteinlog){
        this.fwriteinlog=fwriteinlog;
    }
	   public String getFwriteinlog(){
      return fwriteinlog;
    }
           public void setFwriteinwglog(String fwriteinwglog){
        this.fwriteinwglog=fwriteinwglog;
    }
	   public String getFwriteinwglog(){
      return fwriteinwglog;
    }
           public void setFid(String fid){
        this.fid=fid;
    }
	   public String getFid(){
      return fid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZddpowerplantoperlog4(com.techstar.dmis.entity.DdClassondutylog zddpowerplantoperlog4){
        this.zddpowerplantoperlog4=zddpowerplantoperlog4;
    }
	   public com.techstar.dmis.entity.DdClassondutylog getZddpowerplantoperlog4(){
      return zddpowerplantoperlog4;
    }
      
  

}