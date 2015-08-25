package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 传动记录
 * This classe is based on ValueObject Pattern
 */
public class TransZdhTransrecordDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransZdhTransrecordDto() {
    }
	
          private String fstationname; //厂站
          private String transreason; //传动原因
          private String transpeople; //传动人
          private java.sql.Date transdate; //传动日期
          private String transunit; //传动单位
          private String explanation; //传动内容说明
          private String sourcetaskno; //任务来源编号
              private String transrecordno; //传动记录正式编号
          private String fexcutestatus; //传动执行情况
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String tasksource; //任务来源
          private String transrecordid; //传动记录编号
          private int version; //数据库版本控制
          private String trans_zzdhtransrecord1; //厂站编号
          private String trans_zzdhtransrecord3; //交接班记录编号
    	 
	
   /**
     * getters and setters
     */
            public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
             public void setTransreason(String transreason){
        this.transreason=transreason;
    }
	   public String getTransreason(){
      return transreason;
    }
             public void setTranspeople(String transpeople){
        this.transpeople=transpeople;
    }
	   public String getTranspeople(){
      return transpeople;
    }
             public void setTransdate(java.sql.Date transdate){
        this.transdate=transdate;
    }
	   public java.sql.Date getTransdate(){
      return transdate;
    }
             public void setTransunit(String transunit){
        this.transunit=transunit;
    }
	   public String getTransunit(){
      return transunit;
    }
             public void setExplanation(String explanation){
        this.explanation=explanation;
    }
	   public String getExplanation(){
      return explanation;
    }
             public void setSourcetaskno(String sourcetaskno){
        this.sourcetaskno=sourcetaskno;
    }
	   public String getSourcetaskno(){
      return sourcetaskno;
    }
                  public void setTransrecordno(String transrecordno){
        this.transrecordno=transrecordno;
    }
	   public String getTransrecordno(){
      return transrecordno;
    }
             public void setFexcutestatus(String fexcutestatus){
        this.fexcutestatus=fexcutestatus;
    }
	   public String getFexcutestatus(){
      return fexcutestatus;
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
             public void setTasksource(String tasksource){
        this.tasksource=tasksource;
    }
	   public String getTasksource(){
      return tasksource;
    }
             public void setTransrecordid(String transrecordid){
        this.transrecordid=transrecordid;
    }
	   public String getTransrecordid(){
      return transrecordid;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setTrans_zzdhtransrecord1(String trans_zzdhtransrecord1){
        this.trans_zzdhtransrecord1=trans_zzdhtransrecord1;
    }
	   public String getTrans_zzdhtransrecord1(){
      return trans_zzdhtransrecord1;
    }
             public void setTrans_zzdhtransrecord3(String trans_zzdhtransrecord3){
        this.trans_zzdhtransrecord3=trans_zzdhtransrecord3;
    }
	   public String getTrans_zzdhtransrecord3(){
      return trans_zzdhtransrecord3;
    }
       
  

}