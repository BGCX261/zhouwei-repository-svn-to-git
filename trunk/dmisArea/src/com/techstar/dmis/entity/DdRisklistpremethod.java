package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 电网风险预案
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdRisklistpremethod implements Serializable {
    
	public DdRisklistpremethod() {
    }
    		 private byte[] friskcontent;//附件内容
					 private String sys_fille;//填写人
					 private String sys_filldept;//填写单位
					 private java.sql.Timestamp sys_filltime;//填写时间
					 private int sys_isvalid;//是否有效字段
					 private String sys_dataowner;//数据所属单位
					 private String fpremethodid;//预案编号
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.DdRepairrisklist zddrisklistpremethod1;
	    		
   /**
     * getters and setters
     */
           public void setFriskcontent(byte[] friskcontent){
        this.friskcontent=friskcontent;
    }
	   public byte[] getFriskcontent(){
      return friskcontent;
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
           public void setFpremethodid(String fpremethodid){
        this.fpremethodid=fpremethodid;
    }
	   public String getFpremethodid(){
      return fpremethodid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZddrisklistpremethod1(com.techstar.dmis.entity.DdRepairrisklist zddrisklistpremethod1){
        this.zddrisklistpremethod1=zddrisklistpremethod1;
    }
	   public com.techstar.dmis.entity.DdRepairrisklist getZddrisklistpremethod1(){
      return zddrisklistpremethod1;
    }
      
  

}