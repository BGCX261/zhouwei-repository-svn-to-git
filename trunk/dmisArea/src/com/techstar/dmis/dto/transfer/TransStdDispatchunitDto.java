package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 调度机构
 * This classe is based on ValueObject Pattern
 */
public class TransStdDispatchunitDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransStdDispatchunitDto() {
    }
	
          private String unitname; //调度机构名称
          private String unitarea; //城近郊
          private String unitshortname; //调度简称
          private String scheduleunit; //调度类型
          private int displayno; //显示序号
          private String iscanedit; //是否允许编辑
          private String maintenanceunitid; //单位对应编号(Ldap)
          private String id; //调度机构编号
          private int version; //数据库版本控制
    	 
	
   /**
     * getters and setters
     */
            public void setUnitname(String unitname){
        this.unitname=unitname;
    }
	   public String getUnitname(){
      return unitname;
    }
             public void setUnitarea(String unitarea){
        this.unitarea=unitarea;
    }
	   public String getUnitarea(){
      return unitarea;
    }
             public void setUnitshortname(String unitshortname){
        this.unitshortname=unitshortname;
    }
	   public String getUnitshortname(){
      return unitshortname;
    }
             public void setScheduleunit(String scheduleunit){
        this.scheduleunit=scheduleunit;
    }
	   public String getScheduleunit(){
      return scheduleunit;
    }
             public void setDisplayno(int displayno){
        this.displayno=displayno;
    }
	   public int getDisplayno(){
      return displayno;
    }
             public void setIscanedit(String iscanedit){
        this.iscanedit=iscanedit;
    }
	   public String getIscanedit(){
      return iscanedit;
    }
             public void setMaintenanceunitid(String maintenanceunitid){
        this.maintenanceunitid=maintenanceunitid;
    }
	   public String getMaintenanceunitid(){
      return maintenanceunitid;
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