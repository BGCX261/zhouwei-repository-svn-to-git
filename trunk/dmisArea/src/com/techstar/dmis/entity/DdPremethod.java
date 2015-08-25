package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 电网预案
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdPremethod implements Serializable {
    
	public DdPremethod() {
    }
    		 private byte[] fpremethodcontent;//预案内容
					 private String src;//预案来源
					 private String premethodtype;//预案类型
					 private String premethodname;//预案名称
					 private String content1;//内容1
					 private String content2;//内容2
					 private String content3;//内容3
					 private String fstatus;//状态
					 private String fexcutestatus;//执行状态
					 private String f_appendixtype;//附件类型
					 private String sys_fille;//填写人
					 private String sys_filldept;//填写单位
					 private java.sql.Timestamp sys_filltime;//填写时间
					 private int sys_isvalid;//是否有效字段
					 private String sys_dataowner;//数据所属单位
					 private String fpremethodid;//预案编号
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.DdMoutageplan zddpremethod5;
	    			 private com.techstar.dmis.entity.DdEnsuringpsmanage zddpremethod4;
	    		
   /**
     * getters and setters
     */
           public void setFpremethodcontent(byte[] fpremethodcontent){
        this.fpremethodcontent=fpremethodcontent;
    }
	   public byte[] getFpremethodcontent(){
      return fpremethodcontent;
    }
           public void setSrc(String src){
        this.src=src;
    }
	   public String getSrc(){
      return src;
    }
           public void setPremethodtype(String premethodtype){
        this.premethodtype=premethodtype;
    }
	   public String getPremethodtype(){
      return premethodtype;
    }
           public void setPremethodname(String premethodname){
        this.premethodname=premethodname;
    }
	   public String getPremethodname(){
      return premethodname;
    }
           public void setContent1(String content1){
        this.content1=content1;
    }
	   public String getContent1(){
      return content1;
    }
           public void setContent2(String content2){
        this.content2=content2;
    }
	   public String getContent2(){
      return content2;
    }
           public void setContent3(String content3){
        this.content3=content3;
    }
	   public String getContent3(){
      return content3;
    }
           public void setFstatus(String fstatus){
        this.fstatus=fstatus;
    }
	   public String getFstatus(){
      return fstatus;
    }
           public void setFexcutestatus(String fexcutestatus){
        this.fexcutestatus=fexcutestatus;
    }
	   public String getFexcutestatus(){
      return fexcutestatus;
    }
           public void setF_appendixtype(String f_appendixtype){
        this.f_appendixtype=f_appendixtype;
    }
	   public String getF_appendixtype(){
      return f_appendixtype;
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
           public void setFpremethodid(String fpremethodid){
        this.fpremethodid=fpremethodid;
    }
	   public String getFpremethodid(){
      return fpremethodid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZddpremethod5(com.techstar.dmis.entity.DdMoutageplan zddpremethod5){
        this.zddpremethod5=zddpremethod5;
    }
	   public com.techstar.dmis.entity.DdMoutageplan getZddpremethod5(){
      return zddpremethod5;
    }
           public void setZddpremethod4(com.techstar.dmis.entity.DdEnsuringpsmanage zddpremethod4){
        this.zddpremethod4=zddpremethod4;
    }
	   public com.techstar.dmis.entity.DdEnsuringpsmanage getZddpremethod4(){
      return zddpremethod4;
    }
      
  

}