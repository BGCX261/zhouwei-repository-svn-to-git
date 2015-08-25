package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 检修任务明细
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdRepairdetail implements Serializable {
    
	public DdRepairdetail() {
    }
    		 private String fstationname;//变电站
					 private String fstationid;//变电站ID
					 private String feqpid;//设备ID
					 private String fworktype;//工作性质
					 private String feqpclass;//设备类型
					 private String fscheduleno;//调度号
					 private String flinename;//线路名称
					 private java.sql.Timestamp fcutpowerstarttime;//停电开始时间
					 private java.sql.Date fcutpowerendtime;//停电结束时间
					 private java.sql.Date fworkstarttime;//工作开始时间
					 private java.sql.Date fapworkendtime;//工作结束时间
					 private String fid;//检修记录ID
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.DdMoutageplan zddrepairdetail1;
	    			 private com.techstar.dmis.entity.DdDoutageplan zddrepairdetail2;
	    			 private com.techstar.dmis.entity.DdWoutageplan zddrepairdetail3;
	    		
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
           public void setFeqpid(String feqpid){
        this.feqpid=feqpid;
    }
	   public String getFeqpid(){
      return feqpid;
    }
           public void setFworktype(String fworktype){
        this.fworktype=fworktype;
    }
	   public String getFworktype(){
      return fworktype;
    }
           public void setFeqpclass(String feqpclass){
        this.feqpclass=feqpclass;
    }
	   public String getFeqpclass(){
      return feqpclass;
    }
           public void setFscheduleno(String fscheduleno){
        this.fscheduleno=fscheduleno;
    }
	   public String getFscheduleno(){
      return fscheduleno;
    }
           public void setFlinename(String flinename){
        this.flinename=flinename;
    }
	   public String getFlinename(){
      return flinename;
    }
           public void setFcutpowerstarttime(java.sql.Timestamp fcutpowerstarttime){
        this.fcutpowerstarttime=fcutpowerstarttime;
    }
	   public java.sql.Timestamp getFcutpowerstarttime(){
      return fcutpowerstarttime;
    }
           public void setFcutpowerendtime(java.sql.Date fcutpowerendtime){
        this.fcutpowerendtime=fcutpowerendtime;
    }
	   public java.sql.Date getFcutpowerendtime(){
      return fcutpowerendtime;
    }
           public void setFworkstarttime(java.sql.Date fworkstarttime){
        this.fworkstarttime=fworkstarttime;
    }
	   public java.sql.Date getFworkstarttime(){
      return fworkstarttime;
    }
           public void setFapworkendtime(java.sql.Date fapworkendtime){
        this.fapworkendtime=fapworkendtime;
    }
	   public java.sql.Date getFapworkendtime(){
      return fapworkendtime;
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
           public void setZddrepairdetail1(com.techstar.dmis.entity.DdMoutageplan zddrepairdetail1){
        this.zddrepairdetail1=zddrepairdetail1;
    }
	   public com.techstar.dmis.entity.DdMoutageplan getZddrepairdetail1(){
      return zddrepairdetail1;
    }
           public void setZddrepairdetail2(com.techstar.dmis.entity.DdDoutageplan zddrepairdetail2){
        this.zddrepairdetail2=zddrepairdetail2;
    }
	   public com.techstar.dmis.entity.DdDoutageplan getZddrepairdetail2(){
      return zddrepairdetail2;
    }
           public void setZddrepairdetail3(com.techstar.dmis.entity.DdWoutageplan zddrepairdetail3){
        this.zddrepairdetail3=zddrepairdetail3;
    }
	   public com.techstar.dmis.entity.DdWoutageplan getZddrepairdetail3(){
      return zddrepairdetail3;
    }
      
  

}