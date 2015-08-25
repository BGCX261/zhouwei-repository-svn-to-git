package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 电压合格率月报数据明细
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class FsVemonthrepdetailDto  implements Serializable {
    
	public FsVemonthrepdetailDto() {
    }
	
          private String fstationname; //厂站名称
	      private String busvoltage; //母线电压等级
	      private int rate; //合格率
	      private int maxvoltage; //最高电压
	      private int minvoltage; //最低电压
	      private int upnum; //超上限次数
	      private int downnum; //超下限次数
	      private int differencenum; //超偏差次数
	      private String sys_fille; //填写人
	      private String sys_filldept; //填写单位
	      private java.sql.Timestamp sys_filltime; //填写时间
	      private int sys_isvalid; //是否有效字段
	      private String sys_dataowner; //数据所属单位
	      private String reportdetailid; //电压合格率报表明细序号
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.FsVemonthrepDto zfsvemonthrepdetail1; //报表编号
		 

  	
	
   /**
     * getters and setters
     */
           public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
           public void setBusvoltage(String busvoltage){
        this.busvoltage=busvoltage;
    }
	   public String getBusvoltage(){
      return busvoltage;
    }
           public void setRate(int rate){
        this.rate=rate;
    }
	   public int getRate(){
      return rate;
    }
           public void setMaxvoltage(int maxvoltage){
        this.maxvoltage=maxvoltage;
    }
	   public int getMaxvoltage(){
      return maxvoltage;
    }
           public void setMinvoltage(int minvoltage){
        this.minvoltage=minvoltage;
    }
	   public int getMinvoltage(){
      return minvoltage;
    }
           public void setUpnum(int upnum){
        this.upnum=upnum;
    }
	   public int getUpnum(){
      return upnum;
    }
           public void setDownnum(int downnum){
        this.downnum=downnum;
    }
	   public int getDownnum(){
      return downnum;
    }
           public void setDifferencenum(int differencenum){
        this.differencenum=differencenum;
    }
	   public int getDifferencenum(){
      return differencenum;
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
           public void setReportdetailid(String reportdetailid){
        this.reportdetailid=reportdetailid;
    }
	   public String getReportdetailid(){
      return reportdetailid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZfsvemonthrepdetail1(com.techstar.dmis.dto.FsVemonthrepDto zfsvemonthrepdetail1){
        this.zfsvemonthrepdetail1=zfsvemonthrepdetail1;
    }
	   public com.techstar.dmis.dto.FsVemonthrepDto getZfsvemonthrepdetail1(){
      return zfsvemonthrepdetail1;
    }
      
  

}