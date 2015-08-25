package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 拉路限电记录
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdCutofflist implements Serializable {
    
	public DdCutofflist() {
    }
    		 private java.sql.Date fsuspdate;//拉路日期
					 private java.sql.Timestamp fsusptime;//拉路时间
					 private String fgiveorderunit;//下令单位
					 private String fgiver;//下令人姓名
					 private java.sql.Date fgiveordertime;//下令时间
					 private String floadunit;//接令单位
					 private String faccepter;//接令人
					 private String fsummitter;//交令人
					 private java.sql.Timestamp fsummitordertime;//交令时间
					 private int fload;//限电负荷( MW)
					 private int fregionloadbefore;//拉路前地区负荷(MW)
					 private int fregionloadafter;//拉路后地区负荷(MW)
					 private int frealload;//实际拉路负荷
					 private int frealno;//实际拉路数
					 private java.sql.Timestamp frecoverytime;//恢复时间
					 private int frecoveryload;//恢复负荷(MW)
					 private String frecoverygiver;//恢复下令人
					 private java.sql.Timestamp fgiverecoverytime;//恢复下令时间
					 private String faccepterrecorery;//恢复接令人
					 private String fsummiterrecorery;//恢复交令人
					 private java.sql.Date fsummiterecorerytime;//恢复交令时间
					 private String floadunitid;//接令单位ID
					 private String ffatherid;//父ID
					 private String sys_fille;//填写人
					 private String sys_filldept;//填写单位
					 private java.sql.Timestamp sys_filltime;//填写时间
					 private int sys_isvalid;//是否有效字段
					 private String sys_dataowner;//数据所属单位
					 private String fordertype;//拉路性质
					 private String fid;//拉路限电记录ID
					 private int version;//数据库版本控制
					 private java.util.Collection fddcutoffdetaillist1;
	    		
   /**
     * getters and setters
     */
           public void setFsuspdate(java.sql.Date fsuspdate){
        this.fsuspdate=fsuspdate;
    }
	   public java.sql.Date getFsuspdate(){
      return fsuspdate;
    }
           public void setFsusptime(java.sql.Timestamp fsusptime){
        this.fsusptime=fsusptime;
    }
	   public java.sql.Timestamp getFsusptime(){
      return fsusptime;
    }
           public void setFgiveorderunit(String fgiveorderunit){
        this.fgiveorderunit=fgiveorderunit;
    }
	   public String getFgiveorderunit(){
      return fgiveorderunit;
    }
           public void setFgiver(String fgiver){
        this.fgiver=fgiver;
    }
	   public String getFgiver(){
      return fgiver;
    }
           public void setFgiveordertime(java.sql.Date fgiveordertime){
        this.fgiveordertime=fgiveordertime;
    }
	   public java.sql.Date getFgiveordertime(){
      return fgiveordertime;
    }
           public void setFloadunit(String floadunit){
        this.floadunit=floadunit;
    }
	   public String getFloadunit(){
      return floadunit;
    }
           public void setFaccepter(String faccepter){
        this.faccepter=faccepter;
    }
	   public String getFaccepter(){
      return faccepter;
    }
           public void setFsummitter(String fsummitter){
        this.fsummitter=fsummitter;
    }
	   public String getFsummitter(){
      return fsummitter;
    }
           public void setFsummitordertime(java.sql.Timestamp fsummitordertime){
        this.fsummitordertime=fsummitordertime;
    }
	   public java.sql.Timestamp getFsummitordertime(){
      return fsummitordertime;
    }
           public void setFload(int fload){
        this.fload=fload;
    }
	   public int getFload(){
      return fload;
    }
           public void setFregionloadbefore(int fregionloadbefore){
        this.fregionloadbefore=fregionloadbefore;
    }
	   public int getFregionloadbefore(){
      return fregionloadbefore;
    }
           public void setFregionloadafter(int fregionloadafter){
        this.fregionloadafter=fregionloadafter;
    }
	   public int getFregionloadafter(){
      return fregionloadafter;
    }
           public void setFrealload(int frealload){
        this.frealload=frealload;
    }
	   public int getFrealload(){
      return frealload;
    }
           public void setFrealno(int frealno){
        this.frealno=frealno;
    }
	   public int getFrealno(){
      return frealno;
    }
           public void setFrecoverytime(java.sql.Timestamp frecoverytime){
        this.frecoverytime=frecoverytime;
    }
	   public java.sql.Timestamp getFrecoverytime(){
      return frecoverytime;
    }
           public void setFrecoveryload(int frecoveryload){
        this.frecoveryload=frecoveryload;
    }
	   public int getFrecoveryload(){
      return frecoveryload;
    }
           public void setFrecoverygiver(String frecoverygiver){
        this.frecoverygiver=frecoverygiver;
    }
	   public String getFrecoverygiver(){
      return frecoverygiver;
    }
           public void setFgiverecoverytime(java.sql.Timestamp fgiverecoverytime){
        this.fgiverecoverytime=fgiverecoverytime;
    }
	   public java.sql.Timestamp getFgiverecoverytime(){
      return fgiverecoverytime;
    }
           public void setFaccepterrecorery(String faccepterrecorery){
        this.faccepterrecorery=faccepterrecorery;
    }
	   public String getFaccepterrecorery(){
      return faccepterrecorery;
    }
           public void setFsummiterrecorery(String fsummiterrecorery){
        this.fsummiterrecorery=fsummiterrecorery;
    }
	   public String getFsummiterrecorery(){
      return fsummiterrecorery;
    }
           public void setFsummiterecorerytime(java.sql.Date fsummiterecorerytime){
        this.fsummiterecorerytime=fsummiterecorerytime;
    }
	   public java.sql.Date getFsummiterecorerytime(){
      return fsummiterecorerytime;
    }
           public void setFloadunitid(String floadunitid){
        this.floadunitid=floadunitid;
    }
	   public String getFloadunitid(){
      return floadunitid;
    }
           public void setFfatherid(String ffatherid){
        this.ffatherid=ffatherid;
    }
	   public String getFfatherid(){
      return ffatherid;
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
           public void setFordertype(String fordertype){
        this.fordertype=fordertype;
    }
	   public String getFordertype(){
      return fordertype;
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
           public void setFddcutoffdetaillist1(java.util.Collection fddcutoffdetaillist1){
        this.fddcutoffdetaillist1=fddcutoffdetaillist1;
    }
	   public java.util.Collection getFddcutoffdetaillist1(){
      return fddcutoffdetaillist1;
    }
      
  

}