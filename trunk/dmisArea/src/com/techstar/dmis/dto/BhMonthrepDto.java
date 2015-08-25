package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 保护月报（国网）
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class BhMonthrepDto  implements Serializable {
    
	public BhMonthrepDto() {
    }
	
          private int reportmonth; //报表年度
	      private int reportyear; //报表月份
	      private java.sql.Date reporttime; //上报时间
	      private String reporter; //上报人
	      private String fstatus; //状态
	      private String isvalid; //有效否
	      private int actionnum; //动作总次数
	      private int nactionnum; //不正确动作次数
	      private int actionrate; //正确动作率
	      private String workinformation; //专业工作信息
	      private String sys_fille; //填写人
	      private String sys_filldept; //填写单位
	      private java.sql.Timestamp sys_filltime; //填写时间
	      private int sys_isvalid; //是否有效字段
	      private String sys_dataowner; //数据所属单位
	      private String reportid; //报表序号
	      private int version; //数据库版本控制
		 

  	
	
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
           public void setReporttime(java.sql.Date reporttime){
        this.reporttime=reporttime;
    }
	   public java.sql.Date getReporttime(){
      return reporttime;
    }
           public void setReporter(String reporter){
        this.reporter=reporter;
    }
	   public String getReporter(){
      return reporter;
    }
           public void setFstatus(String fstatus){
        this.fstatus=fstatus;
    }
	   public String getFstatus(){
      return fstatus;
    }
           public void setIsvalid(String isvalid){
        this.isvalid=isvalid;
    }
	   public String getIsvalid(){
      return isvalid;
    }
           public void setActionnum(int actionnum){
        this.actionnum=actionnum;
    }
	   public int getActionnum(){
      return actionnum;
    }
           public void setNactionnum(int nactionnum){
        this.nactionnum=nactionnum;
    }
	   public int getNactionnum(){
      return nactionnum;
    }
           public void setActionrate(int actionrate){
        this.actionrate=actionrate;
    }
	   public int getActionrate(){
      return actionrate;
    }
           public void setWorkinformation(String workinformation){
        this.workinformation=workinformation;
    }
	   public String getWorkinformation(){
      return workinformation;
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
      
  

}