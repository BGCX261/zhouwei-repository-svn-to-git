package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 遥信记录
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ZdhRsrecordDto  implements Serializable {
    
	public ZdhRsrecordDto() {
    }
	
          private int righttimes; //应动作次数
	      private int correcttimes; //正确动作次数
	      private String actionnote; //动作说明
	      private java.sql.Timestamp accidenttime; //故障时间
	      private String accidentname; //故障名称
	      private String sys_fille; //填写人
	      private String sys_filldept; //填写单位
	      private java.sql.Timestamp sys_filltime; //填写时间
	      private int sys_isvalid; //是否有效字段
	      private String sys_dataowner; //数据所属单位
	      private String recordid; //记录编号
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.DdAccidentbriefDto zzdhrsrecord1; //关联故障编号
	      private com.techstar.dmis.dto.ZdhAutoondutylogDto zzdhrsrecord2; //交接班记录编号
		 

  	
	
   /**
     * getters and setters
     */
           public void setRighttimes(int righttimes){
        this.righttimes=righttimes;
    }
	   public int getRighttimes(){
      return righttimes;
    }
           public void setCorrecttimes(int correcttimes){
        this.correcttimes=correcttimes;
    }
	   public int getCorrecttimes(){
      return correcttimes;
    }
           public void setActionnote(String actionnote){
        this.actionnote=actionnote;
    }
	   public String getActionnote(){
      return actionnote;
    }
           public void setAccidenttime(java.sql.Timestamp accidenttime){
        this.accidenttime=accidenttime;
    }
	   public java.sql.Timestamp getAccidenttime(){
      return accidenttime;
    }
           public void setAccidentname(String accidentname){
        this.accidentname=accidentname;
    }
	   public String getAccidentname(){
      return accidentname;
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
           public void setRecordid(String recordid){
        this.recordid=recordid;
    }
	   public String getRecordid(){
      return recordid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZzdhrsrecord1(com.techstar.dmis.dto.DdAccidentbriefDto zzdhrsrecord1){
        this.zzdhrsrecord1=zzdhrsrecord1;
    }
	   public com.techstar.dmis.dto.DdAccidentbriefDto getZzdhrsrecord1(){
      return zzdhrsrecord1;
    }
           public void setZzdhrsrecord2(com.techstar.dmis.dto.ZdhAutoondutylogDto zzdhrsrecord2){
        this.zzdhrsrecord2=zzdhrsrecord2;
    }
	   public com.techstar.dmis.dto.ZdhAutoondutylogDto getZzdhrsrecord2(){
      return zzdhrsrecord2;
    }
      
  

}