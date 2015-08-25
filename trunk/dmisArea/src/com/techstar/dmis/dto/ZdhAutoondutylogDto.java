package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 自动化值班日志
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ZdhAutoondutylogDto  implements Serializable {
    
	public ZdhAutoondutylogDto() {
    }
	
          private java.sql.Date logdate; //日志日期
	      //private java.sql.Date successiontime; //接班时间
          java.sql.Timestamp successiontime; //接班时间
	      //private java.sql.Date handovertime; //交班时间
          java.sql.Timestamp handovertime; //交班时间
	      private String attendant2; //值班人
	      private String successor2; //接班人
	      private int upstemperature; //UPS电源室温度
	      private int machinehalltemperature; //机房温度
	      private String machinehallhealth; //机房卫生
	      private String morningreportsystem; //早汇报系统是否正常
	      private String remarks; //备注
	      private String sys_fille; //填写人
	      private String sys_filldept; //填写单位
	      private java.sql.Timestamp sys_filltime; //填写时间
	      private int sys_isvalid; //是否有效字段
	      private String sys_dataowner; //数据所属单位
	      private String ondutyno; //交接班记录编号
	      private int version; //数据库版本控制
	      private java.util.Collection fzdhworkbill2; //交接班记录编号
	      private java.util.Collection fzdhmachineworklist1; //交接班记录编号
	      private java.util.Collection fzdhrmrec1; //交接班记录编号
	      private java.util.Collection fzdhrsrecord2; //交接班记录编号
	      private java.util.Collection fzdhcharalterrecord2; //交接班记录编号
	      private java.util.Collection fzdhfaultlist7; //交接班记录编号
	      private java.util.Collection fzdhtransrecord3; //交接班记录编号
	      private java.util.Collection fzdhopexaminelist5; //交接班记录编号
		 

  	
	
   /**
     * getters and setters
     */
           public void setLogdate(java.sql.Date logdate){
        this.logdate=logdate;
    }
	   public java.sql.Date getLogdate(){
      return logdate;
    }
          
           public java.sql.Timestamp getHandovertime() {
		return handovertime;
	}
	public void setHandovertime(java.sql.Timestamp handovertime) {
		this.handovertime = handovertime;
	}
	public java.sql.Timestamp getSuccessiontime() {
		return successiontime;
	}
	public void setSuccessiontime(java.sql.Timestamp successiontime) {
		this.successiontime = successiontime;
	}
		public void setAttendant2(String attendant2){
        this.attendant2=attendant2;
    }
	   public String getAttendant2(){
      return attendant2;
    }
           public void setSuccessor2(String successor2){
        this.successor2=successor2;
    }
	   public String getSuccessor2(){
      return successor2;
    }
           public void setUpstemperature(int upstemperature){
        this.upstemperature=upstemperature;
    }
	   public int getUpstemperature(){
      return upstemperature;
    }
           public void setMachinehalltemperature(int machinehalltemperature){
        this.machinehalltemperature=machinehalltemperature;
    }
	   public int getMachinehalltemperature(){
      return machinehalltemperature;
    }
           public void setMachinehallhealth(String machinehallhealth){
        this.machinehallhealth=machinehallhealth;
    }
	   public String getMachinehallhealth(){
      return machinehallhealth;
    }
           public void setMorningreportsystem(String morningreportsystem){
        this.morningreportsystem=morningreportsystem;
    }
	   public String getMorningreportsystem(){
      return morningreportsystem;
    }
           public void setRemarks(String remarks){
        this.remarks=remarks;
    }
	   public String getRemarks(){
      return remarks;
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
           public void setOndutyno(String ondutyno){
        this.ondutyno=ondutyno;
    }
	   public String getOndutyno(){
      return ondutyno;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setFzdhworkbill2(java.util.Collection fzdhworkbill2){
        this.fzdhworkbill2=fzdhworkbill2;
    }
	   public java.util.Collection getFzdhworkbill2(){
      return fzdhworkbill2;
    }
           public void setFzdhmachineworklist1(java.util.Collection fzdhmachineworklist1){
        this.fzdhmachineworklist1=fzdhmachineworklist1;
    }
	   public java.util.Collection getFzdhmachineworklist1(){
      return fzdhmachineworklist1;
    }
           public void setFzdhrmrec1(java.util.Collection fzdhrmrec1){
        this.fzdhrmrec1=fzdhrmrec1;
    }
	   public java.util.Collection getFzdhrmrec1(){
      return fzdhrmrec1;
    }
           public void setFzdhrsrecord2(java.util.Collection fzdhrsrecord2){
        this.fzdhrsrecord2=fzdhrsrecord2;
    }
	   public java.util.Collection getFzdhrsrecord2(){
      return fzdhrsrecord2;
    }
           public void setFzdhcharalterrecord2(java.util.Collection fzdhcharalterrecord2){
        this.fzdhcharalterrecord2=fzdhcharalterrecord2;
    }
	   public java.util.Collection getFzdhcharalterrecord2(){
      return fzdhcharalterrecord2;
    }
           public void setFzdhfaultlist7(java.util.Collection fzdhfaultlist7){
        this.fzdhfaultlist7=fzdhfaultlist7;
    }
	   public java.util.Collection getFzdhfaultlist7(){
      return fzdhfaultlist7;
    }
           public void setFzdhtransrecord3(java.util.Collection fzdhtransrecord3){
        this.fzdhtransrecord3=fzdhtransrecord3;
    }
	   public java.util.Collection getFzdhtransrecord3(){
      return fzdhtransrecord3;
    }
           public void setFzdhopexaminelist5(java.util.Collection fzdhopexaminelist5){
        this.fzdhopexaminelist5=fzdhopexaminelist5;
    }
	   public java.util.Collection getFzdhopexaminelist5(){
      return fzdhopexaminelist5;
    }
      
  

}