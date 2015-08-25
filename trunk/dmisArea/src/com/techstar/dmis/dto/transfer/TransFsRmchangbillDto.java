package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 方式变更单
 * This classe is based on ValueObject Pattern
 */
public class TransFsRmchangbillDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransFsRmchangbillDto() {
    }
	
          private String fstationname; //厂站名
          private String fstationid; //厂站编号
          private String fchangetype; //申请类型
          private String fchangename; //方式变更名称
          private java.sql.Date fchangetime; //方式变更时间
          private String fpotentialhazard; //安全隐患
          private java.sql.Date frnormaltime; //恢复正常方式时间
          private int fkeeptime; //变更持续时间(分)
          private String fremark; //变更备注
          private String frelchangebillno; //关联变更单编号
          private String fattribute; //性质
          private String fstatus; //流转状态
          private String rmchangbillno; //正式编号
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String fvoltage; //电压等级(kV)
          private String fchangereason; //方式变更原因
          private String fchangeperformance; //执行状态
          private String fisrenormal; //是否需恢复方式
          private String fchangno; //变更单编号
          private int version; //数据库版本控制
          private java.util.Collection fddfsmodechangelist5; //变更单编号
    	 
	
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
             public void setFchangetype(String fchangetype){
        this.fchangetype=fchangetype;
    }
	   public String getFchangetype(){
      return fchangetype;
    }
             public void setFchangename(String fchangename){
        this.fchangename=fchangename;
    }
	   public String getFchangename(){
      return fchangename;
    }
             public void setFchangetime(java.sql.Date fchangetime){
        this.fchangetime=fchangetime;
    }
	   public java.sql.Date getFchangetime(){
      return fchangetime;
    }
             public void setFpotentialhazard(String fpotentialhazard){
        this.fpotentialhazard=fpotentialhazard;
    }
	   public String getFpotentialhazard(){
      return fpotentialhazard;
    }
             public void setFrnormaltime(java.sql.Date frnormaltime){
        this.frnormaltime=frnormaltime;
    }
	   public java.sql.Date getFrnormaltime(){
      return frnormaltime;
    }
             public void setFkeeptime(int fkeeptime){
        this.fkeeptime=fkeeptime;
    }
	   public int getFkeeptime(){
      return fkeeptime;
    }
             public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
    }
             public void setFrelchangebillno(String frelchangebillno){
        this.frelchangebillno=frelchangebillno;
    }
	   public String getFrelchangebillno(){
      return frelchangebillno;
    }
             public void setFattribute(String fattribute){
        this.fattribute=fattribute;
    }
	   public String getFattribute(){
      return fattribute;
    }
             public void setFstatus(String fstatus){
        this.fstatus=fstatus;
    }
	   public String getFstatus(){
      return fstatus;
    }
             public void setRmchangbillno(String rmchangbillno){
        this.rmchangbillno=rmchangbillno;
    }
	   public String getRmchangbillno(){
      return rmchangbillno;
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
             public void setFchangereason(String fchangereason){
        this.fchangereason=fchangereason;
    }
	   public String getFchangereason(){
      return fchangereason;
    }
             public void setFchangeperformance(String fchangeperformance){
        this.fchangeperformance=fchangeperformance;
    }
	   public String getFchangeperformance(){
      return fchangeperformance;
    }
             public void setFisrenormal(String fisrenormal){
        this.fisrenormal=fisrenormal;
    }
	   public String getFisrenormal(){
      return fisrenormal;
    }
             public void setFchangno(String fchangno){
        this.fchangno=fchangno;
    }
	   public String getFchangno(){
      return fchangno;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setFddfsmodechangelist5(java.util.Collection fddfsmodechangelist5){
        this.fddfsmodechangelist5=fddfsmodechangelist5;
    }
	   public java.util.Collection getFddfsmodechangelist5(){
      return fddfsmodechangelist5;
    }
       
  

}