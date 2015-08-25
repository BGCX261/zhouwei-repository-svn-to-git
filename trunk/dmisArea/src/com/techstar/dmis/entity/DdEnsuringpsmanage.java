package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 政治保电管理
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdEnsuringpsmanage implements Serializable {
    
	public DdEnsuringpsmanage() {
    }
    		 private String fensuringps;//保电任务
					 private java.sql.Timestamp fensuringpsstime;//保电开始时间
					 private java.sql.Timestamp fensuringpsetime;//保电结束时间
					 private String fensuringpsarea;//保电地点
					 private String fstationname;//保电变电站
					 private String ftransmissionunit;//发送单位
					 private String fexcutestatus;//执行情况
					 private byte[] fcommunication;//来文名称
					 private byte[] fmeasarule;//措施和制度
					 private byte[] fadditonal;//反事故预案
					 private String fstatus;//流转状态
					 private String fno;//保电单编号
					 private String fstationid;//变电站ID
					 private String users;//保电用户
					 private String sys_fille;//填写人
					 private String sys_filldept;//填写单位
					 private java.sql.Timestamp sys_filltime;//填写时间
					 private int sys_isvalid;//是否有效字段
					 private String sys_dataowner;//数据所属单位
					 private String fid;//保电源单编号
					 private int version;//数据库版本控制
					 private java.util.Collection fddpremethod4;
	    		
   /**
     * getters and setters
     */
           public void setFensuringps(String fensuringps){
        this.fensuringps=fensuringps;
    }
	   public String getFensuringps(){
      return fensuringps;
    }
           public void setFensuringpsstime(java.sql.Timestamp fensuringpsstime){
        this.fensuringpsstime=fensuringpsstime;
    }
	   public java.sql.Timestamp getFensuringpsstime(){
      return fensuringpsstime;
    }
           public void setFensuringpsetime(java.sql.Timestamp fensuringpsetime){
        this.fensuringpsetime=fensuringpsetime;
    }
	   public java.sql.Timestamp getFensuringpsetime(){
      return fensuringpsetime;
    }
           public void setFensuringpsarea(String fensuringpsarea){
        this.fensuringpsarea=fensuringpsarea;
    }
	   public String getFensuringpsarea(){
      return fensuringpsarea;
    }
           public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
           public void setFtransmissionunit(String ftransmissionunit){
        this.ftransmissionunit=ftransmissionunit;
    }
	   public String getFtransmissionunit(){
      return ftransmissionunit;
    }
           public void setFexcutestatus(String fexcutestatus){
        this.fexcutestatus=fexcutestatus;
    }
	   public String getFexcutestatus(){
      return fexcutestatus;
    }
           public void setFcommunication(byte[] fcommunication){
        this.fcommunication=fcommunication;
    }
	   public byte[] getFcommunication(){
      return fcommunication;
    }
           public void setFmeasarule(byte[] fmeasarule){
        this.fmeasarule=fmeasarule;
    }
	   public byte[] getFmeasarule(){
      return fmeasarule;
    }
           public void setFadditonal(byte[] fadditonal){
        this.fadditonal=fadditonal;
    }
	   public byte[] getFadditonal(){
      return fadditonal;
    }
           public void setFstatus(String fstatus){
        this.fstatus=fstatus;
    }
	   public String getFstatus(){
      return fstatus;
    }
           public void setFno(String fno){
        this.fno=fno;
    }
	   public String getFno(){
      return fno;
    }
           public void setFstationid(String fstationid){
        this.fstationid=fstationid;
    }
	   public String getFstationid(){
      return fstationid;
    }
           public void setUsers(String users){
        this.users=users;
    }
	   public String getUsers(){
      return users;
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
           public void setFddpremethod4(java.util.Collection fddpremethod4){
        this.fddpremethod4=fddpremethod4;
    }
	   public java.util.Collection getFddpremethod4(){
      return fddpremethod4;
    }
      
  

}