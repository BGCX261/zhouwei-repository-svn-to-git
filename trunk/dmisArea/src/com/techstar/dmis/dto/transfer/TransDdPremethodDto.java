package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 电网预案
 * This classe is based on ValueObject Pattern
 */
public class TransDdPremethodDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDdPremethodDto() {
    }
	
              private String src; //预案来源
          private String premethodtype; //预案类型
          private String premethodname; //预案名称
          private String content1; //内容1
          private String content2; //内容2
          private String content3; //内容3
          private String fstatus; //状态
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String fpremethodid; //预案编号
          private int version; //数据库版本控制
          private String trans_zddpremethod5; //月计划编号
          private String trans_zddpremethod4; //保电源单编号
    	 
	
   /**
     * getters and setters
     */
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
             public void setTrans_zddpremethod5(String trans_zddpremethod5){
        this.trans_zddpremethod5=trans_zddpremethod5;
    }
	   public String getTrans_zddpremethod5(){
      return trans_zddpremethod5;
    }
             public void setTrans_zddpremethod4(String trans_zddpremethod4){
        this.trans_zddpremethod4=trans_zddpremethod4;
    }
	   public String getTrans_zddpremethod4(){
      return trans_zddpremethod4;
    }
       
  

}