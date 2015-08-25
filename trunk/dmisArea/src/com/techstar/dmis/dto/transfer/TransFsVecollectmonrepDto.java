package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 电压合格率月报汇总
 * This classe is based on ValueObject Pattern
 */
public class TransFsVecollectmonrepDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransFsVecollectmonrepDto() {
    }
	
          private int reportmonth; //报表年度
          private int reportyear; //报表月份
              private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String reportid; //报表序号
          private int version; //数据库版本控制
          private java.util.Collection ffsvecmrepdetail1; //报表序号
    	 
	
   /**
     * getters and setters
     */
            public void setReportmonth(int reportmonth){
        this.reportmonth=reportmonth;
    }
	   public int getReportmonth(){
      return reportmonth;
    }
             public void setReportyear(int reportyear){
        this.reportyear=reportyear;
    }
	   public int getReportyear(){
      return reportyear;
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
             public void setReportid(String reportid){
        this.reportid=reportid;
    }
	   public String getReportid(){
      return reportid;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setFfsvecmrepdetail1(java.util.Collection ffsvecmrepdetail1){
        this.ffsvecmrepdetail1=ffsvecmrepdetail1;
    }
	   public java.util.Collection getFfsvecmrepdetail1(){
      return ffsvecmrepdetail1;
    }
       
  

}