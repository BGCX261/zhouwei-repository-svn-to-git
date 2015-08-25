package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 地区实时负荷数据的属性清单
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class FsArealoaddatalist implements Serializable {
    
	public FsArealoaddatalist() {
    }
    		 private java.sql.Date facquisitiontime;//采集日期
					 private String fregion;//地区名称
					 private int ffourload;//4点负荷
					 private int ftenload;//10点负荷
					 private int fovernightload;//前夜负荷
					 private String sys_fille;//填写人
					 private String sys_filldept;//填写单位
					 private java.sql.Timestamp sys_filltime;//填写时间
					 private int sys_isvalid;//是否有效字段
					 private String sys_dataowner;//数据所属单位
					 private String floaddatano;//数据编号
					 private int version;//数据库版本控制
				
   /**
     * getters and setters
     */
           public void setFacquisitiontime(java.sql.Date facquisitiontime){
        this.facquisitiontime=facquisitiontime;
    }
	   public java.sql.Date getFacquisitiontime(){
      return facquisitiontime;
    }
           public void setFregion(String fregion){
        this.fregion=fregion;
    }
	   public String getFregion(){
      return fregion;
    }
           public void setFfourload(int ffourload){
        this.ffourload=ffourload;
    }
	   public int getFfourload(){
      return ffourload;
    }
           public void setFtenload(int ftenload){
        this.ftenload=ftenload;
    }
	   public int getFtenload(){
      return ftenload;
    }
           public void setFovernightload(int fovernightload){
        this.fovernightload=fovernightload;
    }
	   public int getFovernightload(){
      return fovernightload;
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
           public void setFloaddatano(String floaddatano){
        this.floaddatano=floaddatano;
    }
	   public String getFloaddatano(){
      return floaddatano;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
      
  

}