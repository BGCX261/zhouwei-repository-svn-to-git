package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 序位表
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ZdhSequencetable implements Serializable {
    
	public ZdhSequencetable() {
    }
    		 private String fstationid;//变电站编号
					 private String fstationname;//厂站名称
					 private int fserialno;//序号
					 private String fname;//标识
					 private String fstatus;//状态
					 private String sys_fille;//填写人
					 private String sys_filldept;//填写单位
					 private java.sql.Timestamp sys_filltime;//填写时间
					 private int sys_isvalid;//是否有效字段
					 private String sys_dataowner;//数据所属单位
					 private String fsequenceno;//编号
					 private int version;//数据库版本控制
				
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
           public void setFserialno(int fserialno){
        this.fserialno=fserialno;
    }
	   public int getFserialno(){
      return fserialno;
    }
           public void setFname(String fname){
        this.fname=fname;
    }
	   public String getFname(){
      return fname;
    }
           public void setFstatus(String fstatus){
        this.fstatus=fstatus;
    }
	   public String getFstatus(){
      return fstatus;
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
           public void setFsequenceno(String fsequenceno){
        this.fsequenceno=fsequenceno;
    }
	   public String getFsequenceno(){
      return fsequenceno;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
      
  

}