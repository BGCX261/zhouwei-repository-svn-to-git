package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 工作票
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ZdhWorkbill implements Serializable {
    
	public ZdhWorkbill() {
    }	
	private String workingbillno;//机房工作票编号
	 private String applicationunit;//申请单位
	 private java.sql.Timestamp applicantedtime;//申请时间
	 private String applicants;//申请人
	 private int applicantsnum;//工作人数
	 private String workingcharge;//工作负责人
	 private java.sql.Date worktime;//工作时间
	 private String workcontent;//工作内容
	 private String relativesystem;//相关系统
	 private String relativeequipment;//相关设备
	 private String dangerouspoint;//危险点分析及措施
	 private byte[] safetyremarks;//注意事项及安全措施
	 private String remarks;//备注
	 private String workingbilltype;//工作票类型
	 private String workingbillreason;//故障原因
	 private String workingbillresponsdept;//责任单位
	 private byte[] analysereport;//故障分析报告
	 private String reason;//不合格原因
	 private java.sql.Timestamp workbegintime;//工作实际开始时间
	 private String passchecker;//合格情况核查人
	 private java.sql.Date passchecktime;//合格核查时间
	 private String fapprover;//审核人
	 private String fallower;//许可人
	 private String sys_fille;//填写人
	 private String sys_filldept;//填写单位
	 private java.sql.Timestamp sys_filltime;//填写时间
	 private int sys_isvalid;//是否有效字段
	 private String sys_dataowner;//数据所属单位
	 private String fexcutestatus;//执行情况
	 private String fstatus;//流转状态
	 private String ispassed;//是否合格
	 private String workbillid;//工作票内部编号
	 private int version;//数据库版本控制
	 private com.techstar.dmis.entity.ZdhAutoondutylog zzdhworkbill2;
	 private com.techstar.dmis.entity.EtsEquipment zzdhworkbill4;
	    		
   /**
     * getters and setters
     */
           public void setWorkingbillno(String workingbillno){
        this.workingbillno=workingbillno;
    }
	   public String getWorkingbillno(){
      return workingbillno;
    }
           public void setApplicationunit(String applicationunit){
        this.applicationunit=applicationunit;
    }
	   public String getApplicationunit(){
      return applicationunit;
    }
           public void setApplicantedtime(java.sql.Timestamp applicantedtime){
        this.applicantedtime=applicantedtime;
    }
	   public java.sql.Timestamp getApplicantedtime(){
      return applicantedtime;
    }
           public void setApplicants(String applicants){
        this.applicants=applicants;
    }
	   public String getApplicants(){
      return applicants;
    }
           public void setApplicantsnum(int applicantsnum){
        this.applicantsnum=applicantsnum;
    }
	   public int getApplicantsnum(){
      return applicantsnum;
    }
           public void setWorkingcharge(String workingcharge){
        this.workingcharge=workingcharge;
    }
	   public String getWorkingcharge(){
      return workingcharge;
    }
           public void setWorktime(java.sql.Date worktime){
        this.worktime=worktime;
    }
	   public java.sql.Date getWorktime(){
      return worktime;
    }
           public void setWorkcontent(String workcontent){
        this.workcontent=workcontent;
    }
	   public String getWorkcontent(){
      return workcontent;
    }
           public void setRelativesystem(String relativesystem){
        this.relativesystem=relativesystem;
    }
	   public String getRelativesystem(){
      return relativesystem;
    }
           public void setRelativeequipment(String relativeequipment){
        this.relativeequipment=relativeequipment;
    }
	   public String getRelativeequipment(){
      return relativeequipment;
    }
           public void setDangerouspoint(String dangerouspoint){
        this.dangerouspoint=dangerouspoint;
    }
	   public String getDangerouspoint(){
      return dangerouspoint;
    }
           public void setSafetyremarks(byte[] safetyremarks){
        this.safetyremarks=safetyremarks;
    }
	   public byte[] getSafetyremarks(){
      return safetyremarks;
    }
           public void setRemarks(String remarks){
        this.remarks=remarks;
    }
	   public String getRemarks(){
      return remarks;
    }
           public void setWorkingbilltype(String workingbilltype){
        this.workingbilltype=workingbilltype;
    }
	   public String getWorkingbilltype(){
      return workingbilltype;
    }
           public void setWorkingbillreason(String workingbillreason){
        this.workingbillreason=workingbillreason;
    }
	   public String getWorkingbillreason(){
      return workingbillreason;
    }
           public void setWorkingbillresponsdept(String workingbillresponsdept){
        this.workingbillresponsdept=workingbillresponsdept;
    }
	   public String getWorkingbillresponsdept(){
      return workingbillresponsdept;
    }
           public void setAnalysereport(byte[] analysereport){
        this.analysereport=analysereport;
    }
	   public byte[] getAnalysereport(){
      return analysereport;
    }
           public void setReason(String reason){
        this.reason=reason;
    }
	   public String getReason(){
      return reason;
    }
           public void setWorkbegintime(java.sql.Timestamp workbegintime){
        this.workbegintime=workbegintime;
    }
	   public java.sql.Timestamp getWorkbegintime(){
      return workbegintime;
    }
           public void setPasschecker(String passchecker){
        this.passchecker=passchecker;
    }
	   public String getPasschecker(){
      return passchecker;
    }
           public void setPasschecktime(java.sql.Date passchecktime){
        this.passchecktime=passchecktime;
    }
	   public java.sql.Date getPasschecktime(){
      return passchecktime;
    }
           public void setFapprover(String fapprover){
        this.fapprover=fapprover;
    }
	   public String getFapprover(){
      return fapprover;
    }
           public void setFallower(String fallower){
        this.fallower=fallower;
    }
	   public String getFallower(){
      return fallower;
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
           public void setFexcutestatus(String fexcutestatus){
        this.fexcutestatus=fexcutestatus;
    }
	   public String getFexcutestatus(){
      return fexcutestatus;
    }
	
           public String getFstatus() {
		return fstatus;
	}
	public void setFstatus(String fstatus) {
		this.fstatus = fstatus;
	}
		public void setIspassed(String ispassed){
        this.ispassed=ispassed;
    }
	   public String getIspassed(){
      return ispassed;
    }
           public void setWorkbillid(String workbillid){
        this.workbillid=workbillid;
    }
	   public String getWorkbillid(){
      return workbillid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           
    public com.techstar.dmis.entity.ZdhAutoondutylog getZzdhworkbill2() {
    	
		return zzdhworkbill2;
	}
	public void setZzdhworkbill2(com.techstar.dmis.entity.ZdhAutoondutylog zzdhworkbill2) {
		
		this.zzdhworkbill2 = zzdhworkbill2;
	}
	public void setZzdhworkbill4(com.techstar.dmis.entity.EtsEquipment zzdhworkbill4){
        this.zzdhworkbill4=zzdhworkbill4;
    }
	   public com.techstar.dmis.entity.EtsEquipment getZzdhworkbill4(){
      return zzdhworkbill4;
    }
	
  

}