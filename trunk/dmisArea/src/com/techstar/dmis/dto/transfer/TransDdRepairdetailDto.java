package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 检修任务明细
 * This classe is based on ValueObject Pattern
 */
public class TransDdRepairdetailDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDdRepairdetailDto() {
    }
	
          private String fstationname; //变电站
          private String fstationid; //变电站ID
          private String feqpid; //设备ID
          private String fworktype; //工作性质
          private String feqpclass; //设备类型
          private String fscheduleno; //调度号
          private String flinename; //线路名称
          private java.sql.Timestamp fcutpowerstarttime; //停电开始时间
          private java.sql.Date fcutpowerendtime; //停电结束时间
          private java.sql.Date fworkstarttime; //工作开始时间
          private java.sql.Date fapworkendtime; //工作结束时间
          private String fid; //检修记录ID
          private int version; //数据库版本控制
          private String trans_zddrepairdetail1; //月计划编号
          private String trans_zddrepairdetail2; //日计划编号
          private String trans_zddrepairdetail3; //旬计划编号
    	 
	
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
             public void setTrans_zddrepairdetail1(String trans_zddrepairdetail1){
        this.trans_zddrepairdetail1=trans_zddrepairdetail1;
    }
	   public String getTrans_zddrepairdetail1(){
      return trans_zddrepairdetail1;
    }
             public void setTrans_zddrepairdetail2(String trans_zddrepairdetail2){
        this.trans_zddrepairdetail2=trans_zddrepairdetail2;
    }
	   public String getTrans_zddrepairdetail2(){
      return trans_zddrepairdetail2;
    }
             public void setTrans_zddrepairdetail3(String trans_zddrepairdetail3){
        this.trans_zddrepairdetail3=trans_zddrepairdetail3;
    }
	   public String getTrans_zddrepairdetail3(){
      return trans_zddrepairdetail3;
    }
       
  

}