package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 遥测合格率
 * This classe is based on ValueObject Pattern
 */
public class TransZdhEligiblermrateDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransZdhEligiblermrateDto() {
    }
	
          private java.sql.Date reportsdate; //报表日期
          private int remotemeasureamount; //遥测数据总数
          private int failuredatanoamount; //不合格数据个数
          private int eligiblerate; //遥测数据合格率(%)
          private String remarks; //备注
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String fid; //记录编号
          private int version; //数据库版本控制
          private String trans_zzdheligiblermrate1; //交接班记录编号
    	 
	
   /**
     * getters and setters
     */
            public void setReportsdate(java.sql.Date reportsdate){
        this.reportsdate=reportsdate;
    }
	   public java.sql.Date getReportsdate(){
      return reportsdate;
    }
             public void setRemotemeasureamount(int remotemeasureamount){
        this.remotemeasureamount=remotemeasureamount;
    }
	   public int getRemotemeasureamount(){
      return remotemeasureamount;
    }
             public void setFailuredatanoamount(int failuredatanoamount){
        this.failuredatanoamount=failuredatanoamount;
    }
	   public int getFailuredatanoamount(){
      return failuredatanoamount;
    }
             public void setEligiblerate(int eligiblerate){
        this.eligiblerate=eligiblerate;
    }
	   public int getEligiblerate(){
      return eligiblerate;
    }
             public void setRemarks(String remarks){
        this.remarks=remarks;
    }
	   public String getRemarks(){
      return remarks;
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
             public void setTrans_zzdheligiblermrate1(String trans_zzdheligiblermrate1){
        this.trans_zzdheligiblermrate1=trans_zzdheligiblermrate1;
    }
	   public String getTrans_zzdheligiblermrate1(){
      return trans_zzdheligiblermrate1;
    }
       
  

}