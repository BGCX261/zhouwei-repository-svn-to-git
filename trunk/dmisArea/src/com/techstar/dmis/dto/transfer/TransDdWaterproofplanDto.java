package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 水电运行(计划放水)记录
 * This classe is based on ValueObject Pattern
 */
public class TransDdWaterproofplanDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDdWaterproofplanDto() {
    }
	
          private String fapplyuser; //申请人
          private String fapplyunit; //申请单位
          private java.sql.Timestamp fapplycnt; //放水时间
          private int fwaterquantity; //水量(个)
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String fwriteinlog; //是否写入日志
          private String fwriteinwglog; //是否写入班志
          private String fid; //记录编号
          private int version; //数据库版本控制
          private String trans_zddwaterproofplan2; //当前班志编号
    	 
	
   /**
     * getters and setters
     */
            public void setFapplyuser(String fapplyuser){
        this.fapplyuser=fapplyuser;
    }
	   public String getFapplyuser(){
      return fapplyuser;
    }
             public void setFapplyunit(String fapplyunit){
        this.fapplyunit=fapplyunit;
    }
	   public String getFapplyunit(){
      return fapplyunit;
    }
             public void setFapplycnt(java.sql.Timestamp fapplycnt){
        this.fapplycnt=fapplycnt;
    }
	   public java.sql.Timestamp getFapplycnt(){
      return fapplycnt;
    }
             public void setFwaterquantity(int fwaterquantity){
        this.fwaterquantity=fwaterquantity;
    }
	   public int getFwaterquantity(){
      return fwaterquantity;
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
             public void setTrans_zddwaterproofplan2(String trans_zddwaterproofplan2){
        this.trans_zddwaterproofplan2=trans_zddwaterproofplan2;
    }
	   public String getTrans_zddwaterproofplan2(){
      return trans_zddwaterproofplan2;
    }
       
  

}