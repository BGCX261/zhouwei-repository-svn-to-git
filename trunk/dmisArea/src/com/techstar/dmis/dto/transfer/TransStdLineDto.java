package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 线路
 * This classe is based on ValueObject Pattern
 */
public class TransStdLineDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransStdLineDto() {
    }
	
          private String stationno; //起始变电站编号
          private String linename; //线路名称
          private String manageunit; //管理单位
          private String voltagelevel; //电压等级
          private String stationendno; //结束变电站编号
          private String switchno; //起始开关号
          private String owner; //产权
          private String scheduleunit; //调度单位
          private String linetype; //线路类型
          private String isconnectline; //是否联络线
          private int displayno; //显示序号
          private String manageunitno; //管理单位编号
          private String id; //线路编号
          private int version; //数据库版本控制
    	 
	
   /**
     * getters and setters
     */
            public void setStationno(String stationno){
        this.stationno=stationno;
    }
	   public String getStationno(){
      return stationno;
    }
             public void setLinename(String linename){
        this.linename=linename;
    }
	   public String getLinename(){
      return linename;
    }
             public void setManageunit(String manageunit){
        this.manageunit=manageunit;
    }
	   public String getManageunit(){
      return manageunit;
    }
             public void setVoltagelevel(String voltagelevel){
        this.voltagelevel=voltagelevel;
    }
	   public String getVoltagelevel(){
      return voltagelevel;
    }
             public void setStationendno(String stationendno){
        this.stationendno=stationendno;
    }
	   public String getStationendno(){
      return stationendno;
    }
             public void setSwitchno(String switchno){
        this.switchno=switchno;
    }
	   public String getSwitchno(){
      return switchno;
    }
             public void setOwner(String owner){
        this.owner=owner;
    }
	   public String getOwner(){
      return owner;
    }
             public void setScheduleunit(String scheduleunit){
        this.scheduleunit=scheduleunit;
    }
	   public String getScheduleunit(){
      return scheduleunit;
    }
             public void setLinetype(String linetype){
        this.linetype=linetype;
    }
	   public String getLinetype(){
      return linetype;
    }
             public void setIsconnectline(String isconnectline){
        this.isconnectline=isconnectline;
    }
	   public String getIsconnectline(){
      return isconnectline;
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
       
  

}