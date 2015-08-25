package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 旬停电计划
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdWoutageplanDto  implements Serializable {
    
	public DdWoutageplanDto() {
    }
	
          private String fstationname; //变电站
	      private String flinename; //线路名
	      private String fworkcontent; //工作内容
	      private String foutagearea; //停电范围
	      private String fdispatchrange; //调度范围
	      private java.sql.Timestamp fstarttime; //预计工作起始时间
	      private java.sql.Timestamp fendtime; //预计工作结束时间
	      private String fapplyunit; //申请单位
	      private String fapplicant; //申请人
	      private java.sql.Timestamp fapplytime; //申请时间
	      private String fstatus; //计划状态
	      private String fplansourcetype; //计划来源类型
	      private String fremark; //备注
	      private String fstationid; //变电站ID
	      private String flinenameid; //线路名ID
	      private String fapplyunitid; //申请单位ID
	      private String funfinishreasonid; //未完成id
	      private String fwoutageplanno; //正式编号
	      private String sys_fille; //填写人
	      private String sys_filldept; //填写单位
	      private java.sql.Timestamp sys_filltime; //填写时间
	      private int sys_isvalid; //是否有效字段
	      private String sys_dataowner; //数据所属单位
	      private String fvoltage; //电压等级
	      private String fexcutestatus; //执行状态
	      private String funfinishreason; //未完成原因
	      private String fplantype; //计划类型
	      private String fwplanno; //旬计划编号
	      private int version; //数据库版本控制
	      private java.util.Collection fddrepairdetail3; //旬计划编号
	      private java.util.Collection fddplanuserrel3; //旬计划编号
	      private com.techstar.dmis.dto.DdMoutageplanDto zddwoutageplan5; //计划来源编号
		 

  	
	
   /**
     * getters and setters
     */
           public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
           public void setFlinename(String flinename){
        this.flinename=flinename;
    }
	   public String getFlinename(){
      return flinename;
    }
           public void setFworkcontent(String fworkcontent){
        this.fworkcontent=fworkcontent;
    }
	   public String getFworkcontent(){
      return fworkcontent;
    }
           public void setFoutagearea(String foutagearea){
        this.foutagearea=foutagearea;
    }
	   public String getFoutagearea(){
      return foutagearea;
    }
           public void setFdispatchrange(String fdispatchrange){
        this.fdispatchrange=fdispatchrange;
    }
	   public String getFdispatchrange(){
      return fdispatchrange;
    }
           public void setFstarttime(java.sql.Timestamp fstarttime){
        this.fstarttime=fstarttime;
    }
	   public java.sql.Timestamp getFstarttime(){
      return fstarttime;
    }
           public void setFendtime(java.sql.Timestamp fendtime){
        this.fendtime=fendtime;
    }
	   public java.sql.Timestamp getFendtime(){
      return fendtime;
    }
           public void setFapplyunit(String fapplyunit){
        this.fapplyunit=fapplyunit;
    }
	   public String getFapplyunit(){
      return fapplyunit;
    }
           public void setFapplicant(String fapplicant){
        this.fapplicant=fapplicant;
    }
	   public String getFapplicant(){
      return fapplicant;
    }
           public void setFapplytime(java.sql.Timestamp fapplytime){
        this.fapplytime=fapplytime;
    }
	   public java.sql.Timestamp getFapplytime(){
      return fapplytime;
    }
           public void setFstatus(String fstatus){
        this.fstatus=fstatus;
    }
	   public String getFstatus(){
      return fstatus;
    }
           public void setFplansourcetype(String fplansourcetype){
        this.fplansourcetype=fplansourcetype;
    }
	   public String getFplansourcetype(){
      return fplansourcetype;
    }
           public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
    }
           public void setFstationid(String fstationid){
        this.fstationid=fstationid;
    }
	   public String getFstationid(){
      return fstationid;
    }
           public void setFlinenameid(String flinenameid){
        this.flinenameid=flinenameid;
    }
	   public String getFlinenameid(){
      return flinenameid;
    }
           public void setFapplyunitid(String fapplyunitid){
        this.fapplyunitid=fapplyunitid;
    }
	   public String getFapplyunitid(){
      return fapplyunitid;
    }
           public void setFunfinishreasonid(String funfinishreasonid){
        this.funfinishreasonid=funfinishreasonid;
    }
	   public String getFunfinishreasonid(){
      return funfinishreasonid;
    }
           public void setFwoutageplanno(String fwoutageplanno){
        this.fwoutageplanno=fwoutageplanno;
    }
	   public String getFwoutageplanno(){
      return fwoutageplanno;
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
           public void setFvoltage(String fvoltage){
        this.fvoltage=fvoltage;
    }
	   public String getFvoltage(){
      return fvoltage;
    }
           public void setFexcutestatus(String fexcutestatus){
        this.fexcutestatus=fexcutestatus;
    }
	   public String getFexcutestatus(){
      return fexcutestatus;
    }
           public void setFunfinishreason(String funfinishreason){
        this.funfinishreason=funfinishreason;
    }
	   public String getFunfinishreason(){
      return funfinishreason;
    }
           public void setFplantype(String fplantype){
        this.fplantype=fplantype;
    }
	   public String getFplantype(){
      return fplantype;
    }
           public void setFwplanno(String fwplanno){
        this.fwplanno=fwplanno;
    }
	   public String getFwplanno(){
      return fwplanno;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setFddrepairdetail3(java.util.Collection fddrepairdetail3){
        this.fddrepairdetail3=fddrepairdetail3;
    }
	   public java.util.Collection getFddrepairdetail3(){
      return fddrepairdetail3;
    }
           public void setFddplanuserrel3(java.util.Collection fddplanuserrel3){
        this.fddplanuserrel3=fddplanuserrel3;
    }
	   public java.util.Collection getFddplanuserrel3(){
      return fddplanuserrel3;
    }
           public void setZddwoutageplan5(com.techstar.dmis.dto.DdMoutageplanDto zddwoutageplan5){
        this.zddwoutageplan5=zddwoutageplan5;
    }
	   public com.techstar.dmis.dto.DdMoutageplanDto getZddwoutageplan5(){
      return zddwoutageplan5;
    }
      
  

}