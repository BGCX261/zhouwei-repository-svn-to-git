package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 保护设备缺陷
 * This classe is based on ValueObject Pattern
 */
public class TransBhFaultlistDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransBhFaultlistDto() {
    }
	
          private String fstationname; //厂站名称
          private String fdispatchname; //调度命名
          private String fhandleresult; //处理情况
          private java.sql.Date foccurredtime; //缺陷发生时间
          private java.sql.Date frestoretime; //缺陷消除时间
          private int fcontinuetime; //缺陷累计时间
          private String feqpid; //关联设备编号
          private String dataowner; //数据归属
          private String fstates; //缺陷状态
          private String fstationid; //厂站ID
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String fstaticreason; //缺陷原因
          private String ffaultgrade; //性质
          private String ffaultno; //缺陷记录编号
          private int version; //数据库版本控制
    	 
	
   /**
     * getters and setters
     */
            public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
             public void setFdispatchname(String fdispatchname){
        this.fdispatchname=fdispatchname;
    }
	   public String getFdispatchname(){
      return fdispatchname;
    }
             public void setFhandleresult(String fhandleresult){
        this.fhandleresult=fhandleresult;
    }
	   public String getFhandleresult(){
      return fhandleresult;
    }
             public void setFoccurredtime(java.sql.Date foccurredtime){
        this.foccurredtime=foccurredtime;
    }
	   public java.sql.Date getFoccurredtime(){
      return foccurredtime;
    }
             public void setFrestoretime(java.sql.Date frestoretime){
        this.frestoretime=frestoretime;
    }
	   public java.sql.Date getFrestoretime(){
      return frestoretime;
    }
             public void setFcontinuetime(int fcontinuetime){
        this.fcontinuetime=fcontinuetime;
    }
	   public int getFcontinuetime(){
      return fcontinuetime;
    }
             public void setFeqpid(String feqpid){
        this.feqpid=feqpid;
    }
	   public String getFeqpid(){
      return feqpid;
    }
             public void setDataowner(String dataowner){
        this.dataowner=dataowner;
    }
	   public String getDataowner(){
      return dataowner;
    }
             public void setFstates(String fstates){
        this.fstates=fstates;
    }
	   public String getFstates(){
      return fstates;
    }
             public void setFstationid(String fstationid){
        this.fstationid=fstationid;
    }
	   public String getFstationid(){
      return fstationid;
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
             public void setFstaticreason(String fstaticreason){
        this.fstaticreason=fstaticreason;
    }
	   public String getFstaticreason(){
      return fstaticreason;
    }
             public void setFfaultgrade(String ffaultgrade){
        this.ffaultgrade=ffaultgrade;
    }
	   public String getFfaultgrade(){
      return ffaultgrade;
    }
             public void setFfaultno(String ffaultno){
        this.ffaultno=ffaultno;
    }
	   public String getFfaultno(){
      return ffaultno;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
       
  

}