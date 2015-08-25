package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 保护动作记录
 * This classe is based on ValueObject Pattern
 */
public class TransBhActionrecordDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransBhActionrecordDto() {
    }
	
          private String eqpid; //保护装置编号
          private String fstationname; //厂站名称
          private String fstationid; //变电站编号
          private String dispatchno; //调度命名
          private java.sql.Date actiontime; //发生时间
          private int actionevaluatetimes; //保护装置动作评价次数
          private int faultrecordertimes; //故障录波器录波次数
          private int faultrecordergoodtimes; //故障录波器完好次数
          private String faulteqp; //故障设备
              private int actionkeeptimes; //保护动作时间
          private int faultkeeptimes; //故障持续时间
          private String switchmodel; //开关型号
          private String remarks; //备注
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String actionevaluate; //保护装置动作评价
          private String reclosuremode; //重合闸方式
          private String isreclosure; //重合闸是否动作
          private String linereclosure; //线路是否重合成功
          private String protectionrecordid; //保护动作记录
          private int version; //数据库版本控制
          private String trans_zbhactionrecord3; //责任部门ID
          private String trans_zbhactionrecord4; //不正确动作原因iD
          private String trans_zbhactionrecord6; //故障类型ID
          private String trans_zbhactionrecord10; //故障记录编号
    	 
	
   /**
     * getters and setters
     */
            public void setEqpid(String eqpid){
        this.eqpid=eqpid;
    }
	   public String getEqpid(){
      return eqpid;
    }
             public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
             public void setFstationid(String fstationid){
        this.fstationid=fstationid;
    }
	   public String getFstationid(){
      return fstationid;
    }
             public void setDispatchno(String dispatchno){
        this.dispatchno=dispatchno;
    }
	   public String getDispatchno(){
      return dispatchno;
    }
             public void setActiontime(java.sql.Date actiontime){
        this.actiontime=actiontime;
    }
	   public java.sql.Date getActiontime(){
      return actiontime;
    }
             public void setActionevaluatetimes(int actionevaluatetimes){
        this.actionevaluatetimes=actionevaluatetimes;
    }
	   public int getActionevaluatetimes(){
      return actionevaluatetimes;
    }
             public void setFaultrecordertimes(int faultrecordertimes){
        this.faultrecordertimes=faultrecordertimes;
    }
	   public int getFaultrecordertimes(){
      return faultrecordertimes;
    }
             public void setFaultrecordergoodtimes(int faultrecordergoodtimes){
        this.faultrecordergoodtimes=faultrecordergoodtimes;
    }
	   public int getFaultrecordergoodtimes(){
      return faultrecordergoodtimes;
    }
             public void setFaulteqp(String faulteqp){
        this.faulteqp=faulteqp;
    }
	   public String getFaulteqp(){
      return faulteqp;
    }
                  public void setActionkeeptimes(int actionkeeptimes){
        this.actionkeeptimes=actionkeeptimes;
    }
	   public int getActionkeeptimes(){
      return actionkeeptimes;
    }
             public void setFaultkeeptimes(int faultkeeptimes){
        this.faultkeeptimes=faultkeeptimes;
    }
	   public int getFaultkeeptimes(){
      return faultkeeptimes;
    }
             public void setSwitchmodel(String switchmodel){
        this.switchmodel=switchmodel;
    }
	   public String getSwitchmodel(){
      return switchmodel;
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
             public void setActionevaluate(String actionevaluate){
        this.actionevaluate=actionevaluate;
    }
	   public String getActionevaluate(){
      return actionevaluate;
    }
             public void setReclosuremode(String reclosuremode){
        this.reclosuremode=reclosuremode;
    }
	   public String getReclosuremode(){
      return reclosuremode;
    }
             public void setIsreclosure(String isreclosure){
        this.isreclosure=isreclosure;
    }
	   public String getIsreclosure(){
      return isreclosure;
    }
             public void setLinereclosure(String linereclosure){
        this.linereclosure=linereclosure;
    }
	   public String getLinereclosure(){
      return linereclosure;
    }
             public void setProtectionrecordid(String protectionrecordid){
        this.protectionrecordid=protectionrecordid;
    }
	   public String getProtectionrecordid(){
      return protectionrecordid;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setTrans_zbhactionrecord3(String trans_zbhactionrecord3){
        this.trans_zbhactionrecord3=trans_zbhactionrecord3;
    }
	   public String getTrans_zbhactionrecord3(){
      return trans_zbhactionrecord3;
    }
             public void setTrans_zbhactionrecord4(String trans_zbhactionrecord4){
        this.trans_zbhactionrecord4=trans_zbhactionrecord4;
    }
	   public String getTrans_zbhactionrecord4(){
      return trans_zbhactionrecord4;
    }
             public void setTrans_zbhactionrecord6(String trans_zbhactionrecord6){
        this.trans_zbhactionrecord6=trans_zbhactionrecord6;
    }
	   public String getTrans_zbhactionrecord6(){
      return trans_zbhactionrecord6;
    }
             public void setTrans_zbhactionrecord10(String trans_zbhactionrecord10){
        this.trans_zbhactionrecord10=trans_zbhactionrecord10;
    }
	   public String getTrans_zbhactionrecord10(){
      return trans_zbhactionrecord10;
    }
       
  

}