package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 遥测数据修改记录
 * This classe is based on ValueObject Pattern
 */
public class TransZdhRmrecDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransZdhRmrecDto() {
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
          private String trans_zzdhrmrec1; //交接班记录编号
          private String trans_zzdhrmrec4; //厂站编号
          private String trans_zzdhrmrec2; //系统图修改编号
    	 
	
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
             public void setTrans_zzdhrmrec1(String trans_zzdhrmrec1){
        this.trans_zzdhrmrec1=trans_zzdhrmrec1;
    }
	   public String getTrans_zzdhrmrec1(){
      return trans_zzdhrmrec1;
    }
             public void setTrans_zzdhrmrec4(String trans_zzdhrmrec4){
        this.trans_zzdhrmrec4=trans_zzdhrmrec4;
    }
	   public String getTrans_zzdhrmrec4(){
      return trans_zzdhrmrec4;
    }
             public void setTrans_zzdhrmrec2(String trans_zzdhrmrec2){
        this.trans_zzdhrmrec2=trans_zzdhrmrec2;
    }
	   public String getTrans_zzdhrmrec2(){
      return trans_zzdhrmrec2;
    }
       
  

}