package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 自投停用记录
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdSasusprecordDto  implements Serializable {
    
	public DdSasusprecordDto() {
    }
	
          private String fstationname; //设备所在的变电站(开闭站)
	      private String fsuspswitchno; //停自投开关号
	      private int fratedcurrent; //额定电流(A)
	      private int fncurrent; //N-2后电流(A)
	      private int fnloadrate; //N-2后负载率%
	      private java.sql.Timestamp fsusptime; //停用时间
	      private java.sql.Timestamp frestoretime; //恢复时间
	      private int fkeeptime; //时长
	      private String fstationid; //设备所在的变电站ID
	      private String sys_fille; //填写人
	      private String sys_filldept; //填写单位
	      private java.sql.Timestamp sys_filltime; //填写时间
	      private int sys_isvalid; //是否有效字段
	      private String sys_dataowner; //数据所属单位
	      private String fsuspreason; //停自投原因
	      private String fiswritelog; //是否写入日志
	      private String fiswriteinwglog; //是否写入班志
	      private String fid; //自投停用记录ID
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.EtsEquipmentDto zddsasusprecord2; //自投设备ID
	      private com.techstar.dmis.dto.DdClassondutylogDto zddsasusprecord3; //当前班志编号
		 

  	
	
   /**
     * getters and setters
     */
           public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
           public void setFsuspswitchno(String fsuspswitchno){
        this.fsuspswitchno=fsuspswitchno;
    }
	   public String getFsuspswitchno(){
      return fsuspswitchno;
    }
           public void setFratedcurrent(int fratedcurrent){
        this.fratedcurrent=fratedcurrent;
    }
	   public int getFratedcurrent(){
      return fratedcurrent;
    }
           public void setFncurrent(int fncurrent){
        this.fncurrent=fncurrent;
    }
	   public int getFncurrent(){
      return fncurrent;
    }
           public void setFnloadrate(int fnloadrate){
        this.fnloadrate=fnloadrate;
    }
	   public int getFnloadrate(){
      return fnloadrate;
    }
           public void setFsusptime(java.sql.Timestamp fsusptime){
        this.fsusptime=fsusptime;
    }
	   public java.sql.Timestamp getFsusptime(){
      return fsusptime;
    }
           public void setFrestoretime(java.sql.Timestamp frestoretime){
        this.frestoretime=frestoretime;
    }
	   public java.sql.Timestamp getFrestoretime(){
      return frestoretime;
    }
           public void setFkeeptime(int fkeeptime){
        this.fkeeptime=fkeeptime;
    }
	   public int getFkeeptime(){
      return fkeeptime;
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
           public void setFsuspreason(String fsuspreason){
        this.fsuspreason=fsuspreason;
    }
	   public String getFsuspreason(){
      return fsuspreason;
    }
           public void setFiswritelog(String fiswritelog){
        this.fiswritelog=fiswritelog;
    }
	   public String getFiswritelog(){
      return fiswritelog;
    }
           public void setFiswriteinwglog(String fiswriteinwglog){
        this.fiswriteinwglog=fiswriteinwglog;
    }
	   public String getFiswriteinwglog(){
      return fiswriteinwglog;
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
           public void setZddsasusprecord2(com.techstar.dmis.dto.EtsEquipmentDto zddsasusprecord2){
        this.zddsasusprecord2=zddsasusprecord2;
    }
	   public com.techstar.dmis.dto.EtsEquipmentDto getZddsasusprecord2(){
      return zddsasusprecord2;
    }
           public void setZddsasusprecord3(com.techstar.dmis.dto.DdClassondutylogDto zddsasusprecord3){
        this.zddsasusprecord3=zddsasusprecord3;
    }
	   public com.techstar.dmis.dto.DdClassondutylogDto getZddsasusprecord3(){
      return zddsasusprecord3;
    }
      
  

}