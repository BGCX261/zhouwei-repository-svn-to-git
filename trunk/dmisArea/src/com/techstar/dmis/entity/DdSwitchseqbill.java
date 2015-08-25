package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 调度操作票
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdSwitchseqbill implements Serializable {
    
	public DdSwitchseqbill() {
    }
    		 private String fmanualno;//执行编号
					 private java.sql.Date fdate;//操作日期
					 private String fmission;//操作任务
					 private String fremark;//备注
					 private String fexcutestatus;//执行情况
					 private String fistypicalbill;//是否典型票
					 private String fbillsource;//操作票任务来源类型
					 private String fsrcbillno;//来源记录编号
					 private String fstatus;//流转状态
					 private String fstationname;//变电站名称
					 private int fvoltage;//电压等级
					 private String flinename;//线路名称
					 private String feqpid;//设备名称id
					 private String ftaskname;//任务名称
					 private String ispassed;//是否合格
					 private String reason;//不合格原因
					 private String passedchecker;//合格情况检查人
					 private java.sql.Timestamp passchecktime;//合格情况检查时间
					 private int fstepcounts;//操作步骤数
					 private String fstopreason;//操作终止原因
					 private String sys_fille;//填写人
					 private String sys_filldept;//填写单位
					 private java.sql.Timestamp sys_filltime;//填写时间
					 private int sys_isvalid;//是否有效字段
					 private String sys_dataowner;//数据所属单位
					 private String foperate;//操作名称
					 private String fcomputerno;//操作票计算机编号
					 private int version;//数据库版本控制
					 private java.util.Collection fddseqbilldetail1;
	    		
   /**
     * getters and setters
     */
           public void setFmanualno(String fmanualno){
        this.fmanualno=fmanualno;
    }
	   public String getFmanualno(){
      return fmanualno;
    }
           public void setFdate(java.sql.Date fdate){
        this.fdate=fdate;
    }
	   public java.sql.Date getFdate(){
      return fdate;
    }
           public void setFmission(String fmission){
        this.fmission=fmission;
    }
	   public String getFmission(){
      return fmission;
    }
           public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
    }
           public void setFexcutestatus(String fexcutestatus){
        this.fexcutestatus=fexcutestatus;
    }
	   public String getFexcutestatus(){
      return fexcutestatus;
    }
           public void setFistypicalbill(String fistypicalbill){
        this.fistypicalbill=fistypicalbill;
    }
	   public String getFistypicalbill(){
      return fistypicalbill;
    }
           public void setFbillsource(String fbillsource){
        this.fbillsource=fbillsource;
    }
	   public String getFbillsource(){
      return fbillsource;
    }
           public void setFsrcbillno(String fsrcbillno){
        this.fsrcbillno=fsrcbillno;
    }
	   public String getFsrcbillno(){
      return fsrcbillno;
    }
           public void setFstatus(String fstatus){
        this.fstatus=fstatus;
    }
	   public String getFstatus(){
      return fstatus;
    }
           public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
           public void setFvoltage(int fvoltage){
        this.fvoltage=fvoltage;
    }
	   public int getFvoltage(){
      return fvoltage;
    }
           public void setFlinename(String flinename){
        this.flinename=flinename;
    }
	   public String getFlinename(){
      return flinename;
    }
           public void setFeqpid(String feqpid){
        this.feqpid=feqpid;
    }
	   public String getFeqpid(){
      return feqpid;
    }
           public void setFtaskname(String ftaskname){
        this.ftaskname=ftaskname;
    }
	   public String getFtaskname(){
      return ftaskname;
    }
           public void setIspassed(String ispassed){
        this.ispassed=ispassed;
    }
	   public String getIspassed(){
      return ispassed;
    }
           public void setReason(String reason){
        this.reason=reason;
    }
	   public String getReason(){
      return reason;
    }
           public void setPassedchecker(String passedchecker){
        this.passedchecker=passedchecker;
    }
	   public String getPassedchecker(){
      return passedchecker;
    }
           public void setPasschecktime(java.sql.Timestamp passchecktime){
        this.passchecktime=passchecktime;
    }
	   public java.sql.Timestamp getPasschecktime(){
      return passchecktime;
    }
           public void setFstepcounts(int fstepcounts){
        this.fstepcounts=fstepcounts;
    }
	   public int getFstepcounts(){
      return fstepcounts;
    }
           public void setFstopreason(String fstopreason){
        this.fstopreason=fstopreason;
    }
	   public String getFstopreason(){
      return fstopreason;
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
           public void setFoperate(String foperate){
        this.foperate=foperate;
    }
	   public String getFoperate(){
      return foperate;
    }
           public void setFcomputerno(String fcomputerno){
        this.fcomputerno=fcomputerno;
    }
	   public String getFcomputerno(){
      return fcomputerno;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setFddseqbilldetail1(java.util.Collection fddseqbilldetail1){
        this.fddseqbilldetail1=fddseqbilldetail1;
    }
	   public java.util.Collection getFddseqbilldetail1(){
      return fddseqbilldetail1;
    }
      
  

}