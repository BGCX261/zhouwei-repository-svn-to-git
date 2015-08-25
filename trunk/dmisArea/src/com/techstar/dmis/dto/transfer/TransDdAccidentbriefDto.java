package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 故障简报
 * This classe is based on ValueObject Pattern
 */
public class TransDdAccidentbriefDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDdAccidentbriefDto() {
    }
	
          private String faccidentname; //事故名称
          private java.sql.Date faccidenttime; //故障发生时间
          private String fdispatcher; //值班调度员
          private String freportedpeople; //上报人
          private java.sql.Date freportdate; //上报时间
          private String freporter; //报知人
          private String fnotifiedunit; //通知有关单位
          private String fnotifyoffice; //通知本单位处室人员
          private String freportleadership; //汇报领导
          private java.sql.Date frecoverytime; //故障恢复时间
          private String ffaultequipmemt; //故障设备
          private String fdispatchno; //设备调度号
          private String fline; //线路名称
          private int flesspower; //少送电度
          private String fweather; //天气
          private String fremark; //备注
          private java.sql.Date ftopdispreporttime; //上级调度确认上报时间
          private int fovercurrenttime; //过流次数
          private int fiftimes; //速断次数
          private int fothertimes; //其他次数
          private String freporthandle; //现场报告及处理情况
          private String flineid; //线路名称ID
          private String ffaultequipmemtid; //故障设备ID
          private String accidentno; //故障票正式编号
          private String fstationname; //变电站名称
          private String fstationid; //变电站编号
          private String accidentreason; //故障原因
          private String checker; //合格情况检查人
          private java.sql.Timestamp checktime; //合格检查时间
          private String checkinfo; //检查情况
          private String unsatisfyreason; //不合格原因
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String fresult; //处理结果
          private String fvoltage; //故障电压等级
          private String fimpact; //故障影响
          private String fwhethercompleted; //故障简报是否填完
          private String fcontrol; //试发情况
          private String fgrounding; //接地情况
          private String faccidentid; //故障编号
          private int version; //数据库版本控制
          private java.util.Collection fbhactionrecord10; //故障编号
          private java.util.Collection fddaccidentbriefprocess1; //故障编号
          private String trans_zddaccidentbrief1; //故障原因ID
    	 
	
   /**
     * getters and setters
     */
            public void setFaccidentname(String faccidentname){
        this.faccidentname=faccidentname;
    }
	   public String getFaccidentname(){
      return faccidentname;
    }
             public void setFaccidenttime(java.sql.Date faccidenttime){
        this.faccidenttime=faccidenttime;
    }
	   public java.sql.Date getFaccidenttime(){
      return faccidenttime;
    }
             public void setFdispatcher(String fdispatcher){
        this.fdispatcher=fdispatcher;
    }
	   public String getFdispatcher(){
      return fdispatcher;
    }
             public void setFreportedpeople(String freportedpeople){
        this.freportedpeople=freportedpeople;
    }
	   public String getFreportedpeople(){
      return freportedpeople;
    }
             public void setFreportdate(java.sql.Date freportdate){
        this.freportdate=freportdate;
    }
	   public java.sql.Date getFreportdate(){
      return freportdate;
    }
             public void setFreporter(String freporter){
        this.freporter=freporter;
    }
	   public String getFreporter(){
      return freporter;
    }
             public void setFnotifiedunit(String fnotifiedunit){
        this.fnotifiedunit=fnotifiedunit;
    }
	   public String getFnotifiedunit(){
      return fnotifiedunit;
    }
             public void setFnotifyoffice(String fnotifyoffice){
        this.fnotifyoffice=fnotifyoffice;
    }
	   public String getFnotifyoffice(){
      return fnotifyoffice;
    }
             public void setFreportleadership(String freportleadership){
        this.freportleadership=freportleadership;
    }
	   public String getFreportleadership(){
      return freportleadership;
    }
             public void setFrecoverytime(java.sql.Date frecoverytime){
        this.frecoverytime=frecoverytime;
    }
	   public java.sql.Date getFrecoverytime(){
      return frecoverytime;
    }
             public void setFfaultequipmemt(String ffaultequipmemt){
        this.ffaultequipmemt=ffaultequipmemt;
    }
	   public String getFfaultequipmemt(){
      return ffaultequipmemt;
    }
             public void setFdispatchno(String fdispatchno){
        this.fdispatchno=fdispatchno;
    }
	   public String getFdispatchno(){
      return fdispatchno;
    }
             public void setFline(String fline){
        this.fline=fline;
    }
	   public String getFline(){
      return fline;
    }
             public void setFlesspower(int flesspower){
        this.flesspower=flesspower;
    }
	   public int getFlesspower(){
      return flesspower;
    }
             public void setFweather(String fweather){
        this.fweather=fweather;
    }
	   public String getFweather(){
      return fweather;
    }
             public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
    }
             public void setFtopdispreporttime(java.sql.Date ftopdispreporttime){
        this.ftopdispreporttime=ftopdispreporttime;
    }
	   public java.sql.Date getFtopdispreporttime(){
      return ftopdispreporttime;
    }
             public void setFovercurrenttime(int fovercurrenttime){
        this.fovercurrenttime=fovercurrenttime;
    }
	   public int getFovercurrenttime(){
      return fovercurrenttime;
    }
             public void setFiftimes(int fiftimes){
        this.fiftimes=fiftimes;
    }
	   public int getFiftimes(){
      return fiftimes;
    }
             public void setFothertimes(int fothertimes){
        this.fothertimes=fothertimes;
    }
	   public int getFothertimes(){
      return fothertimes;
    }
             public void setFreporthandle(String freporthandle){
        this.freporthandle=freporthandle;
    }
	   public String getFreporthandle(){
      return freporthandle;
    }
             public void setFlineid(String flineid){
        this.flineid=flineid;
    }
	   public String getFlineid(){
      return flineid;
    }
             public void setFfaultequipmemtid(String ffaultequipmemtid){
        this.ffaultequipmemtid=ffaultequipmemtid;
    }
	   public String getFfaultequipmemtid(){
      return ffaultequipmemtid;
    }
             public void setAccidentno(String accidentno){
        this.accidentno=accidentno;
    }
	   public String getAccidentno(){
      return accidentno;
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
             public void setAccidentreason(String accidentreason){
        this.accidentreason=accidentreason;
    }
	   public String getAccidentreason(){
      return accidentreason;
    }
             public void setChecker(String checker){
        this.checker=checker;
    }
	   public String getChecker(){
      return checker;
    }
             public void setChecktime(java.sql.Timestamp checktime){
        this.checktime=checktime;
    }
	   public java.sql.Timestamp getChecktime(){
      return checktime;
    }
             public void setCheckinfo(String checkinfo){
        this.checkinfo=checkinfo;
    }
	   public String getCheckinfo(){
      return checkinfo;
    }
             public void setUnsatisfyreason(String unsatisfyreason){
        this.unsatisfyreason=unsatisfyreason;
    }
	   public String getUnsatisfyreason(){
      return unsatisfyreason;
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
             public void setFresult(String fresult){
        this.fresult=fresult;
    }
	   public String getFresult(){
      return fresult;
    }
             public void setFvoltage(String fvoltage){
        this.fvoltage=fvoltage;
    }
	   public String getFvoltage(){
      return fvoltage;
    }
             public void setFimpact(String fimpact){
        this.fimpact=fimpact;
    }
	   public String getFimpact(){
      return fimpact;
    }
             public void setFwhethercompleted(String fwhethercompleted){
        this.fwhethercompleted=fwhethercompleted;
    }
	   public String getFwhethercompleted(){
      return fwhethercompleted;
    }
             public void setFcontrol(String fcontrol){
        this.fcontrol=fcontrol;
    }
	   public String getFcontrol(){
      return fcontrol;
    }
             public void setFgrounding(String fgrounding){
        this.fgrounding=fgrounding;
    }
	   public String getFgrounding(){
      return fgrounding;
    }
             public void setFaccidentid(String faccidentid){
        this.faccidentid=faccidentid;
    }
	   public String getFaccidentid(){
      return faccidentid;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setFbhactionrecord10(java.util.Collection fbhactionrecord10){
        this.fbhactionrecord10=fbhactionrecord10;
    }
	   public java.util.Collection getFbhactionrecord10(){
      return fbhactionrecord10;
    }
             public void setFddaccidentbriefprocess1(java.util.Collection fddaccidentbriefprocess1){
        this.fddaccidentbriefprocess1=fddaccidentbriefprocess1;
    }
	   public java.util.Collection getFddaccidentbriefprocess1(){
      return fddaccidentbriefprocess1;
    }
             public void setTrans_zddaccidentbrief1(String trans_zddaccidentbrief1){
        this.trans_zddaccidentbrief1=trans_zddaccidentbrief1;
    }
	   public String getTrans_zddaccidentbrief1(){
      return trans_zddaccidentbrief1;
    }
       
  

}