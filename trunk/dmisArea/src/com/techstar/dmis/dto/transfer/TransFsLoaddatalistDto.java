package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 低频装置负荷数据表的属性清单
 * This classe is based on ValueObject Pattern
 */
public class TransFsLoaddatalistDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransFsLoaddatalistDto() {
    }
	
          private java.sql.Date facquisitiondate; //数据采集日期
          private int fobservedvalue; //实测
          private int factualvalue; //有效
          private int fpvalue; //有功
          private int fmpvalue; //方案值
          private String fstatus; //低频投入状态
          private String froundno; //低频定值轮次
          private String fmeasure; //测量时间
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String floaddatano; //数据编号
          private int version; //数据库版本控制
          private String trans_zfsloaddatalist1; //线路资料编号
    	 
	
   /**
     * getters and setters
     */
            public void setFacquisitiondate(java.sql.Date facquisitiondate){
        this.facquisitiondate=facquisitiondate;
    }
	   public java.sql.Date getFacquisitiondate(){
      return facquisitiondate;
    }
             public void setFobservedvalue(int fobservedvalue){
        this.fobservedvalue=fobservedvalue;
    }
	   public int getFobservedvalue(){
      return fobservedvalue;
    }
             public void setFactualvalue(int factualvalue){
        this.factualvalue=factualvalue;
    }
	   public int getFactualvalue(){
      return factualvalue;
    }
             public void setFpvalue(int fpvalue){
        this.fpvalue=fpvalue;
    }
	   public int getFpvalue(){
      return fpvalue;
    }
             public void setFmpvalue(int fmpvalue){
        this.fmpvalue=fmpvalue;
    }
	   public int getFmpvalue(){
      return fmpvalue;
    }
             public void setFstatus(String fstatus){
        this.fstatus=fstatus;
    }
	   public String getFstatus(){
      return fstatus;
    }
             public void setFroundno(String froundno){
        this.froundno=froundno;
    }
	   public String getFroundno(){
      return froundno;
    }
             public void setFmeasure(String fmeasure){
        this.fmeasure=fmeasure;
    }
	   public String getFmeasure(){
      return fmeasure;
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
             public void setFloaddatano(String floaddatano){
        this.floaddatano=floaddatano;
    }
	   public String getFloaddatano(){
      return floaddatano;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setTrans_zfsloaddatalist1(String trans_zfsloaddatalist1){
        this.trans_zfsloaddatalist1=trans_zfsloaddatalist1;
    }
	   public String getTrans_zfsloaddatalist1(){
      return trans_zfsloaddatalist1;
    }
       
  

}