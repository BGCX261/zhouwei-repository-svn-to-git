package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 水电运行(水位)记录
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdWaterheightDto  implements Serializable {
    
	public DdWaterheightDto() {
    }
	
          private java.sql.Date flogdate; //记录日期
	      private String fpowerplant; //电厂名
	      private int fwaterlevel; //水位(米)
	      private String sys_fille; //填写人
	      private String sys_filldept; //填写单位
	      private java.sql.Timestamp sys_filltime; //填写时间
	      private int sys_isvalid; //是否有效字段
	      private String sys_dataowner; //数据所属单位
	      private String fwaterleveltime; //时间
	      private String fid; //记录编号
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.StdStationDto zddwaterheight2=new StdStationDto(); //电厂名ID
	      private com.techstar.dmis.dto.DdClassondutylogDto zddwaterheight3; //当前班志编号
		 

  	
	
   /**
     * getters and setters
     */
           public void setFlogdate(java.sql.Date flogdate){
        this.flogdate=flogdate;
    }
	   public java.sql.Date getFlogdate(){
      return flogdate;
    }
           public void setFpowerplant(String fpowerplant){
        this.fpowerplant=fpowerplant;
    }
	   public String getFpowerplant(){
      return fpowerplant;
    }
           public void setFwaterlevel(int fwaterlevel){
        this.fwaterlevel=fwaterlevel;
    }
	   public int getFwaterlevel(){
      return fwaterlevel;
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
           public void setFwaterleveltime(String fwaterleveltime){
        this.fwaterleveltime=fwaterleveltime;
    }
	   public String getFwaterleveltime(){
      return fwaterleveltime;
    }
           public void setFid(String fid){
        this.fid=fid;
    }
	   public String getFid(){
      return fid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZddwaterheight2(com.techstar.dmis.dto.StdStationDto zddwaterheight2){
        this.zddwaterheight2=zddwaterheight2;
    }
	   public com.techstar.dmis.dto.StdStationDto getZddwaterheight2(){
      return zddwaterheight2;
    }
           public void setZddwaterheight3(com.techstar.dmis.dto.DdClassondutylogDto zddwaterheight3){
        this.zddwaterheight3=zddwaterheight3;
    }
	   public com.techstar.dmis.dto.DdClassondutylogDto getZddwaterheight3(){
      return zddwaterheight3;
    }
      
  

}