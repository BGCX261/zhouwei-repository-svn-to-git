package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 日计划核查表
 * This classe is based on ValueObject Pattern
 */
public class TransZdhOpexaminelistDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransZdhOpexaminelistDto() {
    }
	
          private String begincheck; //开始工作核查
          private String finishcheck; //完成情况核查
          private String finishchecker; //完成核查人
          private String beginchecker; //开始核查人
          private java.sql.Date beginchecktime; //开始工作核查时间
          private java.sql.Date finishchecktime; //完成核查时间
          private String eondutylogno; //结束核查日志号
          private java.sql.Timestamp fapplystime; //工作开始时间
          private java.sql.Timestamp fapplyetime; //工作结束时间
          private String fworkcontent; //工作内容
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String examinationid; //核查记录编号
          private int version; //数据库版本控制
          private String trans_zzdhopexaminelist5; //交接班记录编号
          private String trans_zzdhopexaminelist6; //计划编号
    	 
	
   /**
     * getters and setters
     */
            public void setBegincheck(String begincheck){
        this.begincheck=begincheck;
    }
	   public String getBegincheck(){
      return begincheck;
    }
             public void setFinishcheck(String finishcheck){
        this.finishcheck=finishcheck;
    }
	   public String getFinishcheck(){
      return finishcheck;
    }
             public void setFinishchecker(String finishchecker){
        this.finishchecker=finishchecker;
    }
	   public String getFinishchecker(){
      return finishchecker;
    }
             public void setBeginchecker(String beginchecker){
        this.beginchecker=beginchecker;
    }
	   public String getBeginchecker(){
      return beginchecker;
    }
             public void setBeginchecktime(java.sql.Date beginchecktime){
        this.beginchecktime=beginchecktime;
    }
	   public java.sql.Date getBeginchecktime(){
      return beginchecktime;
    }
             public void setFinishchecktime(java.sql.Date finishchecktime){
        this.finishchecktime=finishchecktime;
    }
	   public java.sql.Date getFinishchecktime(){
      return finishchecktime;
    }
             public void setEondutylogno(String eondutylogno){
        this.eondutylogno=eondutylogno;
    }
	   public String getEondutylogno(){
      return eondutylogno;
    }
             public void setFapplystime(java.sql.Timestamp fapplystime){
        this.fapplystime=fapplystime;
    }
	   public java.sql.Timestamp getFapplystime(){
      return fapplystime;
    }
             public void setFapplyetime(java.sql.Timestamp fapplyetime){
        this.fapplyetime=fapplyetime;
    }
	   public java.sql.Timestamp getFapplyetime(){
      return fapplyetime;
    }
             public void setFworkcontent(String fworkcontent){
        this.fworkcontent=fworkcontent;
    }
	   public String getFworkcontent(){
      return fworkcontent;
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
             public void setExaminationid(String examinationid){
        this.examinationid=examinationid;
    }
	   public String getExaminationid(){
      return examinationid;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setTrans_zzdhopexaminelist5(String trans_zzdhopexaminelist5){
        this.trans_zzdhopexaminelist5=trans_zzdhopexaminelist5;
    }
	   public String getTrans_zzdhopexaminelist5(){
      return trans_zzdhopexaminelist5;
    }
             public void setTrans_zzdhopexaminelist6(String trans_zzdhopexaminelist6){
        this.trans_zzdhopexaminelist6=trans_zzdhopexaminelist6;
    }
	   public String getTrans_zzdhopexaminelist6(){
      return trans_zzdhopexaminelist6;
    }
       
  

}