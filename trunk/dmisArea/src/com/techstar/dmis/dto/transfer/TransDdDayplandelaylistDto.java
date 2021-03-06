package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 日计划延期记录
 * This classe is based on ValueObject Pattern
 */
public class TransDdDayplandelaylistDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDdDayplandelaylistDto() {
    }
	
          private String fdelayapplyer; //延期申请人
          private String fdelayapprover; //延期批准人
          private java.sql.Timestamp fdelaystoptime; //工作延期结束时间
          private String fdelayreason; //延期原因
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String fid; //延迟序号
          private int version; //数据库版本控制
          private String trans_zdddayplandelaylist1; //日计划编号
    	 
	
   /**
     * getters and setters
     */
            public void setFdelayapplyer(String fdelayapplyer){
        this.fdelayapplyer=fdelayapplyer;
    }
	   public String getFdelayapplyer(){
      return fdelayapplyer;
    }
             public void setFdelayapprover(String fdelayapprover){
        this.fdelayapprover=fdelayapprover;
    }
	   public String getFdelayapprover(){
      return fdelayapprover;
    }
             public void setFdelaystoptime(java.sql.Timestamp fdelaystoptime){
        this.fdelaystoptime=fdelaystoptime;
    }
	   public java.sql.Timestamp getFdelaystoptime(){
      return fdelaystoptime;
    }
             public void setFdelayreason(String fdelayreason){
        this.fdelayreason=fdelayreason;
    }
	   public String getFdelayreason(){
      return fdelayreason;
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
             public void setTrans_zdddayplandelaylist1(String trans_zdddayplandelaylist1){
        this.trans_zdddayplandelaylist1=trans_zdddayplandelaylist1;
    }
	   public String getTrans_zdddayplandelaylist1(){
      return trans_zdddayplandelaylist1;
    }
       
  

}