package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 调度操作票明细
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdSeqbilldetailDto  implements Serializable {
    
	public DdSeqbilldetailDto() {
    }
	
          private int fserialno; //操作序号
	      private String fstationname; //站名
	      private String fcontent; //操作内容
	      private int fstep; //操作步骤数
	      private String fgiver; //下令人
	      private String faccepter; //受令人
	      private java.sql.Timestamp fgivetime; //下令时间
	      private String fsummiter; //交令人
	      private java.sql.Timestamp fsummittime; //交令时间
	      private String sys_fille; //填写人
	      private String sys_filldept; //填写单位
	      private java.sql.Timestamp sys_filltime; //填写时间
	      private int sys_isvalid; //是否有效字段
	      private String sys_dataowner; //数据所属单位
	      private String fstepstatus; //执行状态
	      private String foperationstepno; //操作票步骤编号
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.DdSwitchseqbillDto zddseqbilldetail1 = new DdSwitchseqbillDto(); //操作票计算机编号
		 

  	
	
   /**
     * getters and setters
     */
           public void setFserialno(int fserialno){
        this.fserialno=fserialno;
    }
	   public int getFserialno(){
      return fserialno;
    }
           public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
           public void setFcontent(String fcontent){
        this.fcontent=fcontent;
    }
	   public String getFcontent(){
      return fcontent;
    }
           public void setFstep(int fstep){
        this.fstep=fstep;
    }
	   public int getFstep(){
      return fstep;
    }
           public void setFgiver(String fgiver){
        this.fgiver=fgiver;
    }
	   public String getFgiver(){
      return fgiver;
    }
           public void setFaccepter(String faccepter){
        this.faccepter=faccepter;
    }
	   public String getFaccepter(){
      return faccepter;
    }
           public void setFgivetime(java.sql.Timestamp fgivetime){
        this.fgivetime=fgivetime;
    }
	   public java.sql.Timestamp getFgivetime(){
      return fgivetime;
    }
           public void setFsummiter(String fsummiter){
        this.fsummiter=fsummiter;
    }
	   public String getFsummiter(){
      return fsummiter;
    }
           public void setFsummittime(java.sql.Timestamp fsummittime){
        this.fsummittime=fsummittime;
    }
	   public java.sql.Timestamp getFsummittime(){
      return fsummittime;
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
           public void setFstepstatus(String fstepstatus){
        this.fstepstatus=fstepstatus;
    }
	   public String getFstepstatus(){
      return fstepstatus;
    }
           public void setFoperationstepno(String foperationstepno){
        this.foperationstepno=foperationstepno;
    }
	   public String getFoperationstepno(){
      return foperationstepno;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZddseqbilldetail1(com.techstar.dmis.dto.DdSwitchseqbillDto zddseqbilldetail1){
        this.zddseqbilldetail1=zddseqbilldetail1;
    }
	   public com.techstar.dmis.dto.DdSwitchseqbillDto getZddseqbilldetail1(){
      return zddseqbilldetail1;
    }
      
  

}