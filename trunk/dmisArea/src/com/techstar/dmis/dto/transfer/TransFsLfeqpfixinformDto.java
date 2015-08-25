package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 低频减载定值通知单
 * This classe is based on ValueObject Pattern
 */
public class TransFsLfeqpfixinformDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransFsLfeqpfixinformDto() {
    }
	
          private String fstationname; //厂站
          private String fstationid; //厂站编号
          private String lffixinformno; //定值通知正式编号
          private String eqpid; //低周装置编号
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String fixinformid; //定值通知单编号
          private int version; //数据库版本控制
          private java.util.Collection ffslfeqpfixinformdetail1; //定值通知单编号
    	 
	
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
             public void setLffixinformno(String lffixinformno){
        this.lffixinformno=lffixinformno;
    }
	   public String getLffixinformno(){
      return lffixinformno;
    }
             public void setEqpid(String eqpid){
        this.eqpid=eqpid;
    }
	   public String getEqpid(){
      return eqpid;
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
             public void setFixinformid(String fixinformid){
        this.fixinformid=fixinformid;
    }
	   public String getFixinformid(){
      return fixinformid;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setFfslfeqpfixinformdetail1(java.util.Collection ffslfeqpfixinformdetail1){
        this.ffslfeqpfixinformdetail1=ffslfeqpfixinformdetail1;
    }
	   public java.util.Collection getFfslfeqpfixinformdetail1(){
      return ffslfeqpfixinformdetail1;
    }
       
  

}