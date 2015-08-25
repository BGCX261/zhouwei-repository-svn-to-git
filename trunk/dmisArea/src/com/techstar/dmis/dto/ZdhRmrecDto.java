package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 遥测数据修改记录
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ZdhRmrecDto  implements Serializable {
    
	public ZdhRmrecDto() {
    }
	
          private String fstationname; //变电站名称
	      private String switchno; //开关号
	      private String changeexplanationo; //数据变化说明
	      private int modificationdatano; //修改遥测数据量
	      private String modificationreason; //修改原因
	      private java.sql.Date modificationdate; //数据修改日期
	      private String remarks; //备注
	      private String sys_fille; //填写人
	      private String sys_filldept; //填写单位
	      private java.sql.Timestamp sys_filltime; //填写时间
	      private int sys_isvalid; //是否有效字段
	      private String sys_dataowner; //数据所属单位
	      private String recordno; //记录编号
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.ZdhAutoondutylogDto zzdhrmrec1; //交接班记录编号
	      private com.techstar.dmis.dto.StdStationDto zzdhrmrec4; //厂站编号
	      private com.techstar.dmis.dto.ZdhCharalterrecordDto zzdhrmrec2; //系统图修改编号
		 

  	
	
   /**
     * getters and setters
     */
           public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
           public void setSwitchno(String switchno){
        this.switchno=switchno;
    }
	   public String getSwitchno(){
      return switchno;
    }
           public void setChangeexplanationo(String changeexplanationo){
        this.changeexplanationo=changeexplanationo;
    }
	   public String getChangeexplanationo(){
      return changeexplanationo;
    }
           public void setModificationdatano(int modificationdatano){
        this.modificationdatano=modificationdatano;
    }
	   public int getModificationdatano(){
      return modificationdatano;
    }
           public void setModificationreason(String modificationreason){
        this.modificationreason=modificationreason;
    }
	   public String getModificationreason(){
      return modificationreason;
    }
           public void setModificationdate(java.sql.Date modificationdate){
        this.modificationdate=modificationdate;
    }
	   public java.sql.Date getModificationdate(){
      return modificationdate;
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
           public void setRecordno(String recordno){
        this.recordno=recordno;
    }
	   public String getRecordno(){
      return recordno;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZzdhrmrec1(com.techstar.dmis.dto.ZdhAutoondutylogDto zzdhrmrec1){
        this.zzdhrmrec1=zzdhrmrec1;
    }
	   public com.techstar.dmis.dto.ZdhAutoondutylogDto getZzdhrmrec1(){
      return zzdhrmrec1;
    }
           public void setZzdhrmrec4(com.techstar.dmis.dto.StdStationDto zzdhrmrec4){
        this.zzdhrmrec4=zzdhrmrec4;
    }
	   public com.techstar.dmis.dto.StdStationDto getZzdhrmrec4(){
      return zzdhrmrec4;
    }
           public void setZzdhrmrec2(com.techstar.dmis.dto.ZdhCharalterrecordDto zzdhrmrec2){
        this.zzdhrmrec2=zzdhrmrec2;
    }
	   public com.techstar.dmis.dto.ZdhCharalterrecordDto getZzdhrmrec2(){
      return zzdhrmrec2;
    }
      
  

}