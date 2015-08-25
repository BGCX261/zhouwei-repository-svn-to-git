package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 拉路限电明细
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdCutoffdetaillist implements Serializable {
    
	public DdCutoffdetaillist() {
    }
    		 private String fstationname;//厂站名
					 private String fswitchno;//开关号
					 private java.sql.Timestamp fdraggedtime;//拉下时间
					 private String fbusbarno;//母线号
					 private String froad;//路名
					 private int fdraggedload;//拉下负荷
					 private int flosselectricity;//损失电量
					 private java.sql.Timestamp frecoverytime;//恢复时间
					 private String fdraggedgiver;//拉下下令人
					 private java.sql.Timestamp fdraggedgivetime;//拉下下令时间
					 private String fdraggedaccepter;//拉下接令人
					 private String fdraggedsummiter;//拉下交令人
					 private java.sql.Timestamp fdraggedsummittime;//拉下交令时间
					 private String frecoverygiver;//恢复下令人
					 private java.sql.Timestamp frecoverygivetime;//恢复下令时间
					 private String frecoveryaccepter;//恢复接令人
					 private String frecoverysummiter;//恢复交令人
					 private java.sql.Timestamp frecoverysummitedt;//恢复交令时间
					 private int frecoveryload;//恢复负荷(MW)
					 private String fremark;//备注
					 private String flineid;//线路名I
					 private int fcutoffno;//拉限序号
					 private String sys_fille;//填写人
					 private String sys_filldept;//填写单位
					 private java.sql.Timestamp sys_filltime;//填写时间
					 private int sys_isvalid;//是否有效字段
					 private String sys_dataowner;//数据所属单位
					 private String fdetailid;//拉路限电记录明细ID
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.DdCutofflist zddcutoffdetaillist1;
	    		
   /**
     * getters and setters
     */
           public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
           public void setFswitchno(String fswitchno){
        this.fswitchno=fswitchno;
    }
	   public String getFswitchno(){
      return fswitchno;
    }
           public void setFdraggedtime(java.sql.Timestamp fdraggedtime){
        this.fdraggedtime=fdraggedtime;
    }
	   public java.sql.Timestamp getFdraggedtime(){
      return fdraggedtime;
    }
           public void setFbusbarno(String fbusbarno){
        this.fbusbarno=fbusbarno;
    }
	   public String getFbusbarno(){
      return fbusbarno;
    }
           public void setFroad(String froad){
        this.froad=froad;
    }
	   public String getFroad(){
      return froad;
    }
           public void setFdraggedload(int fdraggedload){
        this.fdraggedload=fdraggedload;
    }
	   public int getFdraggedload(){
      return fdraggedload;
    }
           public void setFlosselectricity(int flosselectricity){
        this.flosselectricity=flosselectricity;
    }
	   public int getFlosselectricity(){
      return flosselectricity;
    }
           public void setFrecoverytime(java.sql.Timestamp frecoverytime){
        this.frecoverytime=frecoverytime;
    }
	   public java.sql.Timestamp getFrecoverytime(){
      return frecoverytime;
    }
           public void setFdraggedgiver(String fdraggedgiver){
        this.fdraggedgiver=fdraggedgiver;
    }
	   public String getFdraggedgiver(){
      return fdraggedgiver;
    }
           public void setFdraggedgivetime(java.sql.Timestamp fdraggedgivetime){
        this.fdraggedgivetime=fdraggedgivetime;
    }
	   public java.sql.Timestamp getFdraggedgivetime(){
      return fdraggedgivetime;
    }
           public void setFdraggedaccepter(String fdraggedaccepter){
        this.fdraggedaccepter=fdraggedaccepter;
    }
	   public String getFdraggedaccepter(){
      return fdraggedaccepter;
    }
           public void setFdraggedsummiter(String fdraggedsummiter){
        this.fdraggedsummiter=fdraggedsummiter;
    }
	   public String getFdraggedsummiter(){
      return fdraggedsummiter;
    }
           public void setFdraggedsummittime(java.sql.Timestamp fdraggedsummittime){
        this.fdraggedsummittime=fdraggedsummittime;
    }
	   public java.sql.Timestamp getFdraggedsummittime(){
      return fdraggedsummittime;
    }
           public void setFrecoverygiver(String frecoverygiver){
        this.frecoverygiver=frecoverygiver;
    }
	   public String getFrecoverygiver(){
      return frecoverygiver;
    }
           public void setFrecoverygivetime(java.sql.Timestamp frecoverygivetime){
        this.frecoverygivetime=frecoverygivetime;
    }
	   public java.sql.Timestamp getFrecoverygivetime(){
      return frecoverygivetime;
    }
           public void setFrecoveryaccepter(String frecoveryaccepter){
        this.frecoveryaccepter=frecoveryaccepter;
    }
	   public String getFrecoveryaccepter(){
      return frecoveryaccepter;
    }
           public void setFrecoverysummiter(String frecoverysummiter){
        this.frecoverysummiter=frecoverysummiter;
    }
	   public String getFrecoverysummiter(){
      return frecoverysummiter;
    }
           public void setFrecoverysummitedt(java.sql.Timestamp frecoverysummitedt){
        this.frecoverysummitedt=frecoverysummitedt;
    }
	   public java.sql.Timestamp getFrecoverysummitedt(){
      return frecoverysummitedt;
    }
           public void setFrecoveryload(int frecoveryload){
        this.frecoveryload=frecoveryload;
    }
	   public int getFrecoveryload(){
      return frecoveryload;
    }
           public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
    }
           public void setFlineid(String flineid){
        this.flineid=flineid;
    }
	   public String getFlineid(){
      return flineid;
    }
           public void setFcutoffno(int fcutoffno){
        this.fcutoffno=fcutoffno;
    }
	   public int getFcutoffno(){
      return fcutoffno;
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
           public void setFdetailid(String fdetailid){
        this.fdetailid=fdetailid;
    }
	   public String getFdetailid(){
      return fdetailid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZddcutoffdetaillist1(com.techstar.dmis.entity.DdCutofflist zddcutoffdetaillist1){
        this.zddcutoffdetaillist1=zddcutoffdetaillist1;
    }
	   public com.techstar.dmis.entity.DdCutofflist getZddcutoffdetaillist1(){
      return zddcutoffdetaillist1;
    }
      
  

}