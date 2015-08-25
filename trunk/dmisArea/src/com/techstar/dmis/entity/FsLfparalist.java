package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 低频减载装置参数的属性清单
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class FsLfparalist implements Serializable {
    
	public FsLfparalist() {
    }
    		 private String fstationname;//厂站名
					 private String fstationid;//厂站编号
					 private int fvoltage;//厂站电压等级
					 private String ftransformerno;//变压器
					 private String fbusno;//母线号
					 private String fswitchno;//开关号
					 private String flinename;//线路名称
					 private String fpowerowner;//低频线路电源所属
					 private String fownedunit;//低频所辖单位
					 private String ffrequency;//动作频率
					 private int factiontime;//动作时间
					 private java.sql.Date fruntime;//投入日期
					 private int flockoutvalue;//电流闭锁值
					 private java.sql.Date flinegenerationdate;//线路发电日期
					 private int fcoefficient;//系数
					 private String fremark;//备注
					 private String eqpid;//对应保护装置ID
					 private String fdevfac;//厂家
					 private String fmodel;//型号
					 private String fmodeltype;//型式
					 private String fuowner;//线路所属用户
					 private String sys_fille;//填写人
					 private String sys_filldept;//填写单位
					 private java.sql.Timestamp sys_filltime;//填写时间
					 private int sys_isvalid;//是否有效字段
					 private String sys_dataowner;//数据所属单位
					 private String fsmallarea;//所属小地区
					 private String frunstatus;//低频投入状态
					 private String flinevoltage;//线路电压等级(kV)
					 private String flinesno;//低周线路资料编号
					 private int version;//数据库版本控制
					 private java.util.Collection ffsloaddatalist1;
	    			 private com.techstar.dmis.entity.StdLfround zfslfparalist3;
	    		
   /**
     * getters and setters
     */
           public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
           public void setFstationid(String fstationid){
        this.fstationid=fstationid;
    }
	   public String getFstationid(){
      return fstationid;
    }
           public void setFvoltage(int fvoltage){
        this.fvoltage=fvoltage;
    }
	   public int getFvoltage(){
      return fvoltage;
    }
           public void setFtransformerno(String ftransformerno){
        this.ftransformerno=ftransformerno;
    }
	   public String getFtransformerno(){
      return ftransformerno;
    }
           public void setFbusno(String fbusno){
        this.fbusno=fbusno;
    }
	   public String getFbusno(){
      return fbusno;
    }
           public void setFswitchno(String fswitchno){
        this.fswitchno=fswitchno;
    }
	   public String getFswitchno(){
      return fswitchno;
    }
           public void setFlinename(String flinename){
        this.flinename=flinename;
    }
	   public String getFlinename(){
      return flinename;
    }
           public void setFpowerowner(String fpowerowner){
        this.fpowerowner=fpowerowner;
    }
	   public String getFpowerowner(){
      return fpowerowner;
    }
           public void setFownedunit(String fownedunit){
        this.fownedunit=fownedunit;
    }
	   public String getFownedunit(){
      return fownedunit;
    }
           public void setFfrequency(String ffrequency){
        this.ffrequency=ffrequency;
    }
	   public String getFfrequency(){
      return ffrequency;
    }
           public void setFactiontime(int factiontime){
        this.factiontime=factiontime;
    }
	   public int getFactiontime(){
      return factiontime;
    }
           public void setFruntime(java.sql.Date fruntime){
        this.fruntime=fruntime;
    }
	   public java.sql.Date getFruntime(){
      return fruntime;
    }
           public void setFlockoutvalue(int flockoutvalue){
        this.flockoutvalue=flockoutvalue;
    }
	   public int getFlockoutvalue(){
      return flockoutvalue;
    }
           public void setFlinegenerationdate(java.sql.Date flinegenerationdate){
        this.flinegenerationdate=flinegenerationdate;
    }
	   public java.sql.Date getFlinegenerationdate(){
      return flinegenerationdate;
    }
           public void setFcoefficient(int fcoefficient){
        this.fcoefficient=fcoefficient;
    }
	   public int getFcoefficient(){
      return fcoefficient;
    }
           public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
    }
           public void setEqpid(String eqpid){
        this.eqpid=eqpid;
    }
	   public String getEqpid(){
      return eqpid;
    }
           public void setFdevfac(String fdevfac){
        this.fdevfac=fdevfac;
    }
	   public String getFdevfac(){
      return fdevfac;
    }
           public void setFmodel(String fmodel){
        this.fmodel=fmodel;
    }
	   public String getFmodel(){
      return fmodel;
    }
           public void setFmodeltype(String fmodeltype){
        this.fmodeltype=fmodeltype;
    }
	   public String getFmodeltype(){
      return fmodeltype;
    }
           public void setFuowner(String fuowner){
        this.fuowner=fuowner;
    }
	   public String getFuowner(){
      return fuowner;
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
           public void setFsmallarea(String fsmallarea){
        this.fsmallarea=fsmallarea;
    }
	   public String getFsmallarea(){
      return fsmallarea;
    }
           public void setFrunstatus(String frunstatus){
        this.frunstatus=frunstatus;
    }
	   public String getFrunstatus(){
      return frunstatus;
    }
           public void setFlinevoltage(String flinevoltage){
        this.flinevoltage=flinevoltage;
    }
	   public String getFlinevoltage(){
      return flinevoltage;
    }
           public void setFlinesno(String flinesno){
        this.flinesno=flinesno;
    }
	   public String getFlinesno(){
      return flinesno;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setFfsloaddatalist1(java.util.Collection ffsloaddatalist1){
        this.ffsloaddatalist1=ffsloaddatalist1;
    }
	   public java.util.Collection getFfsloaddatalist1(){
      return ffsloaddatalist1;
    }
           public void setZfslfparalist3(com.techstar.dmis.entity.StdLfround zfslfparalist3){
        this.zfslfparalist3=zfslfparalist3;
    }
	   public com.techstar.dmis.entity.StdLfround getZfslfparalist3(){
      return zfslfparalist3;
    }
      
  

}