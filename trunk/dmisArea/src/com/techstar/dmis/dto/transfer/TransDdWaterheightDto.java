package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 水电运行(水位)记录
 * This classe is based on ValueObject Pattern
 */
public class TransDdWaterheightDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDdWaterheightDto() {
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
          private String trans_zddwaterheight2; //电厂名ID
          private String trans_zddwaterheight3; //当前班志编号
    	 
	
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
             public void setTrans_zddwaterheight2(String trans_zddwaterheight2){
        this.trans_zddwaterheight2=trans_zddwaterheight2;
    }
	   public String getTrans_zddwaterheight2(){
      return trans_zddwaterheight2;
    }
             public void setTrans_zddwaterheight3(String trans_zddwaterheight3){
        this.trans_zddwaterheight3=trans_zddwaterheight3;
    }
	   public String getTrans_zddwaterheight3(){
      return trans_zddwaterheight3;
    }
       
  

}