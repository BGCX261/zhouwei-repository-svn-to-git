package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 所有设备公用参数
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class EtsEquipment implements Serializable {
    
	public EtsEquipment() {
    }
    		 private String fstorelocation;//设备存放地点
					 private String fstationname;//变电站
					 private String fscheduleno;//调度号
					 private String fdevsequence;//设备编号
					 private String fdevclassname;//设备名称
					 private String fdevicetype;//类型
					 private String fdevicemodel;//设备型号
					 private String fschedulerange;//调度范围
					 private String fdevfac;//生产厂家
					 private String fmadecountry;//制造国家
					 private String fleavefacno;//出厂编号
					 private java.sql.Date fleavefacdate;//出厂日期
					 private java.sql.Date finstalldate;//安装日期
					 private java.sql.Date frunningdate;//投运日期
					 private String fdevicestatus;//设备状态
					 private String fdevicelevel;//定级
					 private String fratedvoltage;//额定电压
					 private String foperatingvoltage;//运行电压
					 private String fneutralvoltage;//中性点电压
					 private String frecycled;//是否报废
					 private java.sql.Date fstopdate;//退运日期
					 private String foperatingunit;//运行单位
					 private String fmaintainunit;//维护单位
					 private java.sql.Date fupdatetime;//更新日期
					 private String fisdelete;//是否删除
					 private String fstationid;//变电站ID
					 private String fdevbuyfac;//购货厂家
					 private int foverhaullife;//大修周期(月)
					 private int fminoverhaullife;//小修周期
					 private int ftmprepairlife;//修试、试验周期
					 private int fcompareversion;//对比版本号
					 private String fbayname;//所属间隔名称
					 private String fbelstatype;//所属厂站类型
					 private String sys_fille;//填写人
					 private String sys_filldept;//填写单位
					 private java.sql.Timestamp sys_filltime;//填写时间
					 private int sys_isvalid;//是否有效字段
					 private String sys_dataowner;//数据所属单位
					 private String fvoltagelevel;//电压等级
					 private String feqpid;//设备ID
					 private int version;//数据库版本控制
					 private java.util.Collection fddhloadrecord6;
	    			 private java.util.Collection fzdhworkbill4;
	    			 private java.util.Collection feqpattachment2;
	    			 private com.techstar.dmis.entity.StdManufacturer zetsequipment3;
	    			 private com.techstar.dmis.entity.StdUnit zetsequipment5;
	    			 private com.techstar.dmis.entity.StdUnit zetsequipment6;
	    			 private com.techstar.dmis.entity.StdManufacturer zetsequipment4;
	    			 private com.techstar.dmis.entity.EQPType zetsequipment7;
	    			 private com.techstar.dmis.entity.Mbay zetsequipment2;
	    		
   /**
     * getters and setters
     */
           public void setFstorelocation(String fstorelocation){
        this.fstorelocation=fstorelocation;
    }
	   public String getFstorelocation(){
      return fstorelocation;
    }
           public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
           public void setFscheduleno(String fscheduleno){
        this.fscheduleno=fscheduleno;
    }
	   public String getFscheduleno(){
      return fscheduleno;
    }
           public void setFdevsequence(String fdevsequence){
        this.fdevsequence=fdevsequence;
    }
	   public String getFdevsequence(){
      return fdevsequence;
    }
           public void setFdevclassname(String fdevclassname){
        this.fdevclassname=fdevclassname;
    }
	   public String getFdevclassname(){
      return fdevclassname;
    }
           public void setFdevicetype(String fdevicetype){
        this.fdevicetype=fdevicetype;
    }
	   public String getFdevicetype(){
      return fdevicetype;
    }
           public void setFdevicemodel(String fdevicemodel){
        this.fdevicemodel=fdevicemodel;
    }
	   public String getFdevicemodel(){
      return fdevicemodel;
    }
           public void setFschedulerange(String fschedulerange){
        this.fschedulerange=fschedulerange;
    }
	   public String getFschedulerange(){
      return fschedulerange;
    }
           public void setFdevfac(String fdevfac){
        this.fdevfac=fdevfac;
    }
	   public String getFdevfac(){
      return fdevfac;
    }
           public void setFmadecountry(String fmadecountry){
        this.fmadecountry=fmadecountry;
    }
	   public String getFmadecountry(){
      return fmadecountry;
    }
           public void setFleavefacno(String fleavefacno){
        this.fleavefacno=fleavefacno;
    }
	   public String getFleavefacno(){
      return fleavefacno;
    }
           public void setFleavefacdate(java.sql.Date fleavefacdate){
        this.fleavefacdate=fleavefacdate;
    }
	   public java.sql.Date getFleavefacdate(){
      return fleavefacdate;
    }
           public void setFinstalldate(java.sql.Date finstalldate){
        this.finstalldate=finstalldate;
    }
	   public java.sql.Date getFinstalldate(){
      return finstalldate;
    }
           public void setFrunningdate(java.sql.Date frunningdate){
        this.frunningdate=frunningdate;
    }
	   public java.sql.Date getFrunningdate(){
      return frunningdate;
    }
           public void setFdevicestatus(String fdevicestatus){
        this.fdevicestatus=fdevicestatus;
    }
	   public String getFdevicestatus(){
      return fdevicestatus;
    }
           public void setFdevicelevel(String fdevicelevel){
        this.fdevicelevel=fdevicelevel;
    }
	   public String getFdevicelevel(){
      return fdevicelevel;
    }
           public void setFratedvoltage(String fratedvoltage){
        this.fratedvoltage=fratedvoltage;
    }
	   public String getFratedvoltage(){
      return fratedvoltage;
    }
           public void setFoperatingvoltage(String foperatingvoltage){
        this.foperatingvoltage=foperatingvoltage;
    }
	   public String getFoperatingvoltage(){
      return foperatingvoltage;
    }
           public void setFneutralvoltage(String fneutralvoltage){
        this.fneutralvoltage=fneutralvoltage;
    }
	   public String getFneutralvoltage(){
      return fneutralvoltage;
    }
           public void setFrecycled(String frecycled){
        this.frecycled=frecycled;
    }
	   public String getFrecycled(){
      return frecycled;
    }
           public void setFstopdate(java.sql.Date fstopdate){
        this.fstopdate=fstopdate;
    }
	   public java.sql.Date getFstopdate(){
      return fstopdate;
    }
           public void setFoperatingunit(String foperatingunit){
        this.foperatingunit=foperatingunit;
    }
	   public String getFoperatingunit(){
      return foperatingunit;
    }
           public void setFmaintainunit(String fmaintainunit){
        this.fmaintainunit=fmaintainunit;
    }
	   public String getFmaintainunit(){
      return fmaintainunit;
    }
           public void setFupdatetime(java.sql.Date fupdatetime){
        this.fupdatetime=fupdatetime;
    }
	   public java.sql.Date getFupdatetime(){
      return fupdatetime;
    }
           public void setFisdelete(String fisdelete){
        this.fisdelete=fisdelete;
    }
	   public String getFisdelete(){
      return fisdelete;
    }
           public void setFstationid(String fstationid){
        this.fstationid=fstationid;
    }
	   public String getFstationid(){
      return fstationid;
    }
           public void setFdevbuyfac(String fdevbuyfac){
        this.fdevbuyfac=fdevbuyfac;
    }
	   public String getFdevbuyfac(){
      return fdevbuyfac;
    }
           public void setFoverhaullife(int foverhaullife){
        this.foverhaullife=foverhaullife;
    }
	   public int getFoverhaullife(){
      return foverhaullife;
    }
           public void setFminoverhaullife(int fminoverhaullife){
        this.fminoverhaullife=fminoverhaullife;
    }
	   public int getFminoverhaullife(){
      return fminoverhaullife;
    }
           public void setFtmprepairlife(int ftmprepairlife){
        this.ftmprepairlife=ftmprepairlife;
    }
	   public int getFtmprepairlife(){
      return ftmprepairlife;
    }
           public void setFcompareversion(int fcompareversion){
        this.fcompareversion=fcompareversion;
    }
	   public int getFcompareversion(){
      return fcompareversion;
    }
           public void setFbayname(String fbayname){
        this.fbayname=fbayname;
    }
	   public String getFbayname(){
      return fbayname;
    }
           public void setFbelstatype(String fbelstatype){
        this.fbelstatype=fbelstatype;
    }
	   public String getFbelstatype(){
      return fbelstatype;
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
           public void setFvoltagelevel(String fvoltagelevel){
        this.fvoltagelevel=fvoltagelevel;
    }
	   public String getFvoltagelevel(){
      return fvoltagelevel;
    }
           public void setFeqpid(String feqpid){
        this.feqpid=feqpid;
    }
	   public String getFeqpid(){
      return feqpid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setFddhloadrecord6(java.util.Collection fddhloadrecord6){
        this.fddhloadrecord6=fddhloadrecord6;
    }
	   public java.util.Collection getFddhloadrecord6(){
      return fddhloadrecord6;
    }
           public void setFzdhworkbill4(java.util.Collection fzdhworkbill4){
        this.fzdhworkbill4=fzdhworkbill4;
    }
	   public java.util.Collection getFzdhworkbill4(){
      return fzdhworkbill4;
    }
           public void setFeqpattachment2(java.util.Collection feqpattachment2){
        this.feqpattachment2=feqpattachment2;
    }
	   public java.util.Collection getFeqpattachment2(){
      return feqpattachment2;
    }
           public void setZetsequipment3(com.techstar.dmis.entity.StdManufacturer zetsequipment3){
        this.zetsequipment3=zetsequipment3;
    }
	   public com.techstar.dmis.entity.StdManufacturer getZetsequipment3(){
      return zetsequipment3;
    }
           public void setZetsequipment5(com.techstar.dmis.entity.StdUnit zetsequipment5){
        this.zetsequipment5=zetsequipment5;
    }
	   public com.techstar.dmis.entity.StdUnit getZetsequipment5(){
      return zetsequipment5;
    }
           public void setZetsequipment6(com.techstar.dmis.entity.StdUnit zetsequipment6){
        this.zetsequipment6=zetsequipment6;
    }
	   public com.techstar.dmis.entity.StdUnit getZetsequipment6(){
      return zetsequipment6;
    }
           public void setZetsequipment4(com.techstar.dmis.entity.StdManufacturer zetsequipment4){
        this.zetsequipment4=zetsequipment4;
    }
	   public com.techstar.dmis.entity.StdManufacturer getZetsequipment4(){
      return zetsequipment4;
    }
           public void setZetsequipment7(com.techstar.dmis.entity.EQPType zetsequipment7){
        this.zetsequipment7=zetsequipment7;
    }
	   public com.techstar.dmis.entity.EQPType getZetsequipment7(){
      return zetsequipment7;
    }
           public void setZetsequipment2(com.techstar.dmis.entity.Mbay zetsequipment2){
        this.zetsequipment2=zetsequipment2;
    }
	   public com.techstar.dmis.entity.Mbay getZetsequipment2(){
      return zetsequipment2;
    }
      
  

}