package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 设备重载记录
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdHloadrecordDto  implements Serializable {
    
	public DdHloadrecordDto() {
    }
	
          private java.sql.Date flogdate; //记录日期
	      private String fstationname; //重载设备厂站
	      private String fdevclass; //重载设备类型
	      private String fdevname; //重载设备名称
	      private String flinename; //路名
	      private int ffixcurrent; //额定电流(A)
	      private int fmaxloadcur; //最大负荷电流(A)
	      private java.sql.Timestamp fstarttime; //开始时间
	      private java.sql.Timestamp fendtime; //结束时间
	      private int fkeeptime; //累计重载时间(分钟)
	      private int fhighestloadrate; //最高负载率(%)
	      private int ftemperature; //温度(℃)
	      private String fremark; //说明
	      private String fiswritelog; //是否写入日志
	      private String fiswriteinwglog; //是否写入班志
	      private String fstationid; //重载设备厂站ID
	      private String flineid; //路名ID
	      private String sys_fille; //填写人
	      private String sys_filldept; //填写单位
	      private java.sql.Timestamp sys_filltime; //填写时间
	      private int sys_isvalid; //是否有效字段
	      private String sys_dataowner; //数据所属单位
	      private String fadopmeasure; //采取措施
	      private String fid; //记录ID
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.DdClassondutylogDto zddhloadrecord4; //当前班志编号
	      private com.techstar.dmis.dto.EtsEquipmentDto zddhloadrecord6; //重载设备ID
		 

  	
	
   /**
     * getters and setters
     */
           public void setFlogdate(java.sql.Date flogdate){
        this.flogdate=flogdate;
    }
	   public java.sql.Date getFlogdate(){
      return flogdate;
    }
           public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
           public void setFdevclass(String fdevclass){
        this.fdevclass=fdevclass;
    }
	   public String getFdevclass(){
      return fdevclass;
    }
           public void setFdevname(String fdevname){
        this.fdevname=fdevname;
    }
	   public String getFdevname(){
      return fdevname;
    }
           public void setFlinename(String flinename){
        this.flinename=flinename;
    }
	   public String getFlinename(){
      return flinename;
    }
           public void setFfixcurrent(int ffixcurrent){
        this.ffixcurrent=ffixcurrent;
    }
	   public int getFfixcurrent(){
      return ffixcurrent;
    }
           public void setFmaxloadcur(int fmaxloadcur){
        this.fmaxloadcur=fmaxloadcur;
    }
	   public int getFmaxloadcur(){
      return fmaxloadcur;
    }
           public void setFstarttime(java.sql.Timestamp fstarttime){
        this.fstarttime=fstarttime;
    }
	   public java.sql.Timestamp getFstarttime(){
      return fstarttime;
    }
           public void setFendtime(java.sql.Timestamp fendtime){
        this.fendtime=fendtime;
    }
	   public java.sql.Timestamp getFendtime(){
      return fendtime;
    }
           public void setFkeeptime(int fkeeptime){
        this.fkeeptime=fkeeptime;
    }
	   public int getFkeeptime(){
      return fkeeptime;
    }
           public void setFhighestloadrate(int fhighestloadrate){
        this.fhighestloadrate=fhighestloadrate;
    }
	   public int getFhighestloadrate(){
      return fhighestloadrate;
    }
           public void setFtemperature(int ftemperature){
        this.ftemperature=ftemperature;
    }
	   public int getFtemperature(){
      return ftemperature;
    }
           public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
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
           public void setFstationid(String fstationid){
        this.fstationid=fstationid;
    }
	   public String getFstationid(){
      return fstationid;
    }
           public void setFlineid(String flineid){
        this.flineid=flineid;
    }
	   public String getFlineid(){
      return flineid;
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
           public void setFadopmeasure(String fadopmeasure){
        this.fadopmeasure=fadopmeasure;
    }
	   public String getFadopmeasure(){
      return fadopmeasure;
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
           public void setZddhloadrecord4(com.techstar.dmis.dto.DdClassondutylogDto zddhloadrecord4){
        this.zddhloadrecord4=zddhloadrecord4;
    }
	   public com.techstar.dmis.dto.DdClassondutylogDto getZddhloadrecord4(){
      return zddhloadrecord4;
    }
           public void setZddhloadrecord6(com.techstar.dmis.dto.EtsEquipmentDto zddhloadrecord6){
        this.zddhloadrecord6=zddhloadrecord6;
    }
	   public com.techstar.dmis.dto.EtsEquipmentDto getZddhloadrecord6(){
      return zddhloadrecord6;
    }
      
  

}