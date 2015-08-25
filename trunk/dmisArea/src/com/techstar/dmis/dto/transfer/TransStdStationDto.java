package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 厂站
 * This classe is based on ValueObject Pattern
 */
public class TransStdStationDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransStdStationDto() {
    }
	
          private String stationname; //变电站名称
          private String manageunit; //管理单位
          private String issubstation; //变电站/开闭站/刀闸室/电厂/主站
          private String stationowner; //产权
          private String schedulerange; //调度权限
          private String scheduledispartch; //调度划分
          private int displayno; //显示序号
          private String manageunitno; //管理单位编号
          private String maintenanceunitname; //运行维护班组
          private String maintenanceunitid; //权限组织机构ID
          private String fstationcode; //厂站编号
          private String voltagelevel; //电压等级
          private String id; //变电站编号
          private int version; //数据库版本控制
          private java.util.Collection fzdhtransrecord1; //变电站编号
          private java.util.Collection fddhpoweroperaterrd2; //变电站编号
          private java.util.Collection fddwaterheight2; //变电站编号
          private java.util.Collection fbhasregulate2; //变电站编号
          private java.util.Collection fddpowerchangrecord6; //变电站编号
          private java.util.Collection fzdhrmrec4; //变电站编号
    	 
	
   /**
     * getters and setters
     */
            public void setStationname(String stationname){
        this.stationname=stationname;
    }
	   public String getStationname(){
      return stationname;
    }
             public void setManageunit(String manageunit){
        this.manageunit=manageunit;
    }
	   public String getManageunit(){
      return manageunit;
    }
             public void setIssubstation(String issubstation){
        this.issubstation=issubstation;
    }
	   public String getIssubstation(){
      return issubstation;
    }
             public void setStationowner(String stationowner){
        this.stationowner=stationowner;
    }
	   public String getStationowner(){
      return stationowner;
    }
             public void setSchedulerange(String schedulerange){
        this.schedulerange=schedulerange;
    }
	   public String getSchedulerange(){
      return schedulerange;
    }
             public void setScheduledispartch(String scheduledispartch){
        this.scheduledispartch=scheduledispartch;
    }
	   public String getScheduledispartch(){
      return scheduledispartch;
    }
             public void setDisplayno(int displayno){
        this.displayno=displayno;
    }
	   public int getDisplayno(){
      return displayno;
    }
             public void setManageunitno(String manageunitno){
        this.manageunitno=manageunitno;
    }
	   public String getManageunitno(){
      return manageunitno;
    }
             public void setMaintenanceunitname(String maintenanceunitname){
        this.maintenanceunitname=maintenanceunitname;
    }
	   public String getMaintenanceunitname(){
      return maintenanceunitname;
    }
             public void setMaintenanceunitid(String maintenanceunitid){
        this.maintenanceunitid=maintenanceunitid;
    }
	   public String getMaintenanceunitid(){
      return maintenanceunitid;
    }
             public void setFstationcode(String fstationcode){
        this.fstationcode=fstationcode;
    }
	   public String getFstationcode(){
      return fstationcode;
    }
             public void setVoltagelevel(String voltagelevel){
        this.voltagelevel=voltagelevel;
    }
	   public String getVoltagelevel(){
      return voltagelevel;
    }
             public void setId(String id){
        this.id=id;
    }
	   public String getId(){
      return id;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setFzdhtransrecord1(java.util.Collection fzdhtransrecord1){
        this.fzdhtransrecord1=fzdhtransrecord1;
    }
	   public java.util.Collection getFzdhtransrecord1(){
      return fzdhtransrecord1;
    }
             public void setFddhpoweroperaterrd2(java.util.Collection fddhpoweroperaterrd2){
        this.fddhpoweroperaterrd2=fddhpoweroperaterrd2;
    }
	   public java.util.Collection getFddhpoweroperaterrd2(){
      return fddhpoweroperaterrd2;
    }
             public void setFddwaterheight2(java.util.Collection fddwaterheight2){
        this.fddwaterheight2=fddwaterheight2;
    }
	   public java.util.Collection getFddwaterheight2(){
      return fddwaterheight2;
    }
             public void setFbhasregulate2(java.util.Collection fbhasregulate2){
        this.fbhasregulate2=fbhasregulate2;
    }
	   public java.util.Collection getFbhasregulate2(){
      return fbhasregulate2;
    }
             public void setFddpowerchangrecord6(java.util.Collection fddpowerchangrecord6){
        this.fddpowerchangrecord6=fddpowerchangrecord6;
    }
	   public java.util.Collection getFddpowerchangrecord6(){
      return fddpowerchangrecord6;
    }
             public void setFzdhrmrec4(java.util.Collection fzdhrmrec4){
        this.fzdhrmrec4=fzdhrmrec4;
    }
	   public java.util.Collection getFzdhrmrec4(){
      return fzdhrmrec4;
    }
       
  

}