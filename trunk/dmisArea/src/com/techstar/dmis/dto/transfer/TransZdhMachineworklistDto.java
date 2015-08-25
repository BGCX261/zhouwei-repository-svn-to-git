package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 机房工作
 * This classe is based on ValueObject Pattern
 */
public class TransZdhMachineworklistDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransZdhMachineworklistDto() {
    }
	
          private java.sql.Date workingtime; //工作时间
          private String content; //纪事内容
          private String workingsources; //工作来源
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String jobcategory; //工作类型
          private String fexcutestatus; //完成状态
          private String jobid; //工作编号
          private int version; //数据库版本控制
          private String trans_zzdhmachineworklist1; //交接班记录编号
    	 
	
   /**
     * getters and setters
     */
            public void setWorkingtime(java.sql.Date workingtime){
        this.workingtime=workingtime;
    }
	   public java.sql.Date getWorkingtime(){
      return workingtime;
    }
             public void setContent(String content){
        this.content=content;
    }
	   public String getContent(){
      return content;
    }
             public void setWorkingsources(String workingsources){
        this.workingsources=workingsources;
    }
	   public String getWorkingsources(){
      return workingsources;
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
             public void setJobcategory(String jobcategory){
        this.jobcategory=jobcategory;
    }
	   public String getJobcategory(){
      return jobcategory;
    }
             public void setFexcutestatus(String fexcutestatus){
        this.fexcutestatus=fexcutestatus;
    }
	   public String getFexcutestatus(){
      return fexcutestatus;
    }
             public void setJobid(String jobid){
        this.jobid=jobid;
    }
	   public String getJobid(){
      return jobid;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setTrans_zzdhmachineworklist1(String trans_zzdhmachineworklist1){
        this.trans_zzdhmachineworklist1=trans_zzdhmachineworklist1;
    }
	   public String getTrans_zzdhmachineworklist1(){
      return trans_zzdhmachineworklist1;
    }
       
  

}