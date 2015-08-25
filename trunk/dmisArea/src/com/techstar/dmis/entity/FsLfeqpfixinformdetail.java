package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 低频减载定值通知明细
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class FsLfeqpfixinformdetail implements Serializable {
    
	public FsLfeqpfixinformdetail() {
    }
    		 private String fswitchno;//开关号
					 private String flinename;//路名
					 private String fbusno;//母线号
					 private int ffrequency;//频率
					 private int factiontime;//动作时间
					 private java.sql.Date fmodifydate;//变更日期
					 private String ffixtype;//类别
					 private String fremark;//备注
					 private String freceiver;//受令人
					 private java.sql.Date freceivetime;//受令时间
					 private String fanswer;//交令人
					 private java.sql.Date fanswertime;//交令时间
					 private String fixinformdetailid;//定值明细编号
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.FsLfparalist zfslfeqpfixinformdetail5;
	    			 private com.techstar.dmis.entity.FsLfeqpfixinform zfslfeqpfixinformdetail1;
	    			 private com.techstar.dmis.entity.StdLfround zfslfeqpfixinformdetail2;
	    		
   /**
     * getters and setters
     */
           public void setFswitchno(String fswitchno){
        this.fswitchno=fswitchno;
    }
	   public String getFswitchno(){
      return fswitchno;
    }
           public void setFlinename(String flinename){
        this.flinename=flinename;
    }
	   public String getFlinename(){
      return flinename;
    }
           public void setFbusno(String fbusno){
        this.fbusno=fbusno;
    }
	   public String getFbusno(){
      return fbusno;
    }
           public void setFfrequency(int ffrequency){
        this.ffrequency=ffrequency;
    }
	   public int getFfrequency(){
      return ffrequency;
    }
           public void setFactiontime(int factiontime){
        this.factiontime=factiontime;
    }
	   public int getFactiontime(){
      return factiontime;
    }
           public void setFmodifydate(java.sql.Date fmodifydate){
        this.fmodifydate=fmodifydate;
    }
	   public java.sql.Date getFmodifydate(){
      return fmodifydate;
    }
           public void setFfixtype(String ffixtype){
        this.ffixtype=ffixtype;
    }
	   public String getFfixtype(){
      return ffixtype;
    }
           public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
    }
           public void setFreceiver(String freceiver){
        this.freceiver=freceiver;
    }
	   public String getFreceiver(){
      return freceiver;
    }
           public void setFreceivetime(java.sql.Date freceivetime){
        this.freceivetime=freceivetime;
    }
	   public java.sql.Date getFreceivetime(){
      return freceivetime;
    }
           public void setFanswer(String fanswer){
        this.fanswer=fanswer;
    }
	   public String getFanswer(){
      return fanswer;
    }
           public void setFanswertime(java.sql.Date fanswertime){
        this.fanswertime=fanswertime;
    }
	   public java.sql.Date getFanswertime(){
      return fanswertime;
    }
           public void setFixinformdetailid(String fixinformdetailid){
        this.fixinformdetailid=fixinformdetailid;
    }
	   public String getFixinformdetailid(){
      return fixinformdetailid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZfslfeqpfixinformdetail5(com.techstar.dmis.entity.FsLfparalist zfslfeqpfixinformdetail5){
        this.zfslfeqpfixinformdetail5=zfslfeqpfixinformdetail5;
    }
	   public com.techstar.dmis.entity.FsLfparalist getZfslfeqpfixinformdetail5(){
      return zfslfeqpfixinformdetail5;
    }
           public void setZfslfeqpfixinformdetail1(com.techstar.dmis.entity.FsLfeqpfixinform zfslfeqpfixinformdetail1){
        this.zfslfeqpfixinformdetail1=zfslfeqpfixinformdetail1;
    }
	   public com.techstar.dmis.entity.FsLfeqpfixinform getZfslfeqpfixinformdetail1(){
      return zfslfeqpfixinformdetail1;
    }
           public void setZfslfeqpfixinformdetail2(com.techstar.dmis.entity.StdLfround zfslfeqpfixinformdetail2){
        this.zfslfeqpfixinformdetail2=zfslfeqpfixinformdetail2;
    }
	   public com.techstar.dmis.entity.StdLfround getZfslfeqpfixinformdetail2(){
      return zfslfeqpfixinformdetail2;
    }
      
  

}