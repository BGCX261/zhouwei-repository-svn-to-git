package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 停复役申请
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ZdhSrapplication implements Serializable {
    
	public ZdhSrapplication() {
    }
    		 private String fstationid;//厂站编号
					 private String fstationname;//设备所属厂站名称
					 private String feqpclasstype;//设备类型
					 private String feqpclassname;//停复役设备名称
					 private String fmaintenancerange;//停役检修内容及影响范围
					 private java.sql.Timestamp fapplicationstarttime;//申请停役开始时间
					 private java.sql.Timestamp fapplicationendime;//申请停役结束时间
					 private java.sql.Timestamp fapprovalstarttime;//批准停役开始时间
					 private java.sql.Timestamp fapprovalendtime;//批准停役结束时间
					 private java.sql.Timestamp frealstarttime;//实际停役开始时间
					 private java.sql.Timestamp frealendtime;//实际停役结束时间
					 private String fremarks;//备注
					 private String fapplicationtype;//申请单类型
					 private byte[] fannexexplanation;//附件
					 private String fexcutestatus;//执行情况
					 private String fstatus;//流转状态
					 private int fkeeptime;//停役时长(分钟)
					 private String fapplicationono;//申请单正式编号
					 private String flocalopinion;//属地公司领导意见
					 private String fcenteropinion2;//中心自动化处意见
					 private String flocalopinion2;//属地调度意见
					 private String fcenteropinion1;//中心主管主任意见
					 private String fcenteropinion3;//运维中心意见
					 private String sys_fille;//填写人
					 private String sys_filldept;//填写单位
					 private java.sql.Timestamp sys_filltime;//填写时间
					 private int sys_isvalid;//是否有效字段
					 private String sys_dataowner;//数据所属单位
					 private String fattribute;//停役性质
					 private String fisstop;//是否停通道
					 private String fapplicationno;//申请单编号
					 private int version;//数据库版本控制
					 private java.util.Collection fzdhsrappeqprel1;
					 private String feqpcontent;//设备id  逗号隔开的多个id
   /**
     * getters and setters
     */
           public void setFstationid(String fstationid){
        this.fstationid=fstationid;
    }
	   public String getFstationid(){
      return fstationid;
    }
           public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
           public void setFeqpclasstype(String feqpclasstype){
        this.feqpclasstype=feqpclasstype;
    }
	   public String getFeqpclasstype(){
      return feqpclasstype;
    }
           public void setFeqpclassname(String feqpclassname){
        this.feqpclassname=feqpclassname;
    }
	   public String getFeqpclassname(){
      return feqpclassname;
    }
           public void setFmaintenancerange(String fmaintenancerange){
        this.fmaintenancerange=fmaintenancerange;
    }
	   public String getFmaintenancerange(){
      return fmaintenancerange;
    }
           public void setFapplicationstarttime(java.sql.Timestamp fapplicationstarttime){
        this.fapplicationstarttime=fapplicationstarttime;
    }
	   public java.sql.Timestamp getFapplicationstarttime(){
      return fapplicationstarttime;
    }
           public void setFapplicationendime(java.sql.Timestamp fapplicationendime){
        this.fapplicationendime=fapplicationendime;
    }
	   public java.sql.Timestamp getFapplicationendime(){
      return fapplicationendime;
    }
           public void setFapprovalstarttime(java.sql.Timestamp fapprovalstarttime){
        this.fapprovalstarttime=fapprovalstarttime;
    }
	   public java.sql.Timestamp getFapprovalstarttime(){
      return fapprovalstarttime;
    }
           public void setFapprovalendtime(java.sql.Timestamp fapprovalendtime){
        this.fapprovalendtime=fapprovalendtime;
    }
	   public java.sql.Timestamp getFapprovalendtime(){
      return fapprovalendtime;
    }
           public void setFrealstarttime(java.sql.Timestamp frealstarttime){
        this.frealstarttime=frealstarttime;
    }
	   public java.sql.Timestamp getFrealstarttime(){
      return frealstarttime;
    }
           public void setFrealendtime(java.sql.Timestamp frealendtime){
        this.frealendtime=frealendtime;
    }
	   public java.sql.Timestamp getFrealendtime(){
      return frealendtime;
    }
           public void setFremarks(String fremarks){
        this.fremarks=fremarks;
    }
	   public String getFremarks(){
      return fremarks;
    }
           public void setFapplicationtype(String fapplicationtype){
        this.fapplicationtype=fapplicationtype;
    }
	   public String getFapplicationtype(){
      return fapplicationtype;
    }
           public void setFannexexplanation(byte[] fannexexplanation){
        this.fannexexplanation=fannexexplanation;
    }
	   public byte[] getFannexexplanation(){
      return fannexexplanation;
    }
           public void setFexcutestatus(String fexcutestatus){
        this.fexcutestatus=fexcutestatus;
    }
	   public String getFexcutestatus(){
      return fexcutestatus;
    }
           public void setFstatus(String fstatus){
        this.fstatus=fstatus;
    }
	   public String getFstatus(){
      return fstatus;
    }
           public void setFkeeptime(int fkeeptime){
        this.fkeeptime=fkeeptime;
    }
	   public int getFkeeptime(){
      return fkeeptime;
    }
           public void setFapplicationono(String fapplicationono){
        this.fapplicationono=fapplicationono;
    }
	   public String getFapplicationono(){
      return fapplicationono;
    }
           public void setFlocalopinion(String flocalopinion){
        this.flocalopinion=flocalopinion;
    }
	   public String getFlocalopinion(){
      return flocalopinion;
    }
           public void setFcenteropinion2(String fcenteropinion2){
        this.fcenteropinion2=fcenteropinion2;
    }
	   public String getFcenteropinion2(){
      return fcenteropinion2;
    }
           public void setFlocalopinion2(String flocalopinion2){
        this.flocalopinion2=flocalopinion2;
    }
	   public String getFlocalopinion2(){
      return flocalopinion2;
    }
           public void setFcenteropinion1(String fcenteropinion1){
        this.fcenteropinion1=fcenteropinion1;
    }
	   public String getFcenteropinion1(){
      return fcenteropinion1;
    }
           public void setFcenteropinion3(String fcenteropinion3){
        this.fcenteropinion3=fcenteropinion3;
    }
	   public String getFcenteropinion3(){
      return fcenteropinion3;
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
           public void setFattribute(String fattribute){
        this.fattribute=fattribute;
    }
	   public String getFattribute(){
      return fattribute;
    }
           public void setFisstop(String fisstop){
        this.fisstop=fisstop;
    }
	   public String getFisstop(){
      return fisstop;
    }
           public void setFapplicationno(String fapplicationno){
        this.fapplicationno=fapplicationno;
    }
	   public String getFapplicationno(){
      return fapplicationno;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setFzdhsrappeqprel1(java.util.Collection fzdhsrappeqprel1){
        this.fzdhsrappeqprel1=fzdhsrappeqprel1;
    }
	   public java.util.Collection getFzdhsrappeqprel1(){
      return fzdhsrappeqprel1;
    }
	public String getFeqpcontent() {
		return feqpcontent;
	}
	public void setFeqpcontent(String feqpcontent) {
		this.feqpcontent = feqpcontent;
	}
      
    

}