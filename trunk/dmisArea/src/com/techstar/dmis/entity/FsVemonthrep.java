package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 电压合格率月报表
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class FsVemonthrep implements Serializable {
    
	public FsVemonthrep() {
    }
    		 private int fyear;//年度
					 private int fmonth;//月度
					 private byte[] monthanalyse;//分析
					 private String sys_fille;//填写人
					 private String sys_filldept;//填写单位
					 private java.sql.Timestamp sys_filltime;//填写时间
					 private int sys_isvalid;//是否有效字段
					 private String sys_dataowner;//数据所属单位
					 private String repmonthid;//月报表编号
					 private int version;//数据库版本控制
					 private java.util.Collection ffsvemonthrepdetail1;
	    		
   /**
     * getters and setters
     */
           public void setFyear(int fyear){
        this.fyear=fyear;
    }
	   public int getFyear(){
      return fyear;
    }
           public void setFmonth(int fmonth){
        this.fmonth=fmonth;
    }
	   public int getFmonth(){
      return fmonth;
    }
           public void setMonthanalyse(byte[] monthanalyse){
        this.monthanalyse=monthanalyse;
    }
	   public byte[] getMonthanalyse(){
      return monthanalyse;
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
           public void setRepmonthid(String repmonthid){
        this.repmonthid=repmonthid;
    }
	   public String getRepmonthid(){
      return repmonthid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setFfsvemonthrepdetail1(java.util.Collection ffsvemonthrepdetail1){
        this.ffsvemonthrepdetail1=ffsvemonthrepdetail1;
    }
	   public java.util.Collection getFfsvemonthrepdetail1(){
      return ffsvemonthrepdetail1;
    }
      
  

}