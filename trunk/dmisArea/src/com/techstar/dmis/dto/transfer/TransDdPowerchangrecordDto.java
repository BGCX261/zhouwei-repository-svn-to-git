package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 电网运行方式调整记录
 * This classe is based on ValueObject Pattern
 */
public class TransDdPowerchangrecordDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDdPowerchangrecordDto() {
    }
	
          private String fstationname; //厂站
          private String fadjustreason; //调整原因
          private String fadjustcontent; //调整内容
          private java.sql.Timestamp fsendcmdtime; //下令时间
          private String fsendcmder; //下令人
          private String freccmder; //受令人
          private java.sql.Timestamp frestoretime; //恢复时间
          private String fressendcmder; //恢复下令人
          private String fresreccmder; //恢复受令人
          private String fwriteinlog; //是否写入日志
          private String fwriteinwglog; //是否写入班志
          private String fsrcno; //来源记录编号
          private String flogtype; //分类
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String fid; //方式变更执行记录编号
          private int version; //数据库版本控制
          private String trans_zddpowerchangrecord4; //当前日志编号
          private String trans_zddpowerchangrecord6; //厂站ID
    	 
	
   /**
     * getters and setters
     */
            public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
             public void setFadjustreason(String fadjustreason){
        this.fadjustreason=fadjustreason;
    }
	   public String getFadjustreason(){
      return fadjustreason;
    }
             public void setFadjustcontent(String fadjustcontent){
        this.fadjustcontent=fadjustcontent;
    }
	   public String getFadjustcontent(){
      return fadjustcontent;
    }
             public void setFsendcmdtime(java.sql.Timestamp fsendcmdtime){
        this.fsendcmdtime=fsendcmdtime;
    }
	   public java.sql.Timestamp getFsendcmdtime(){
      return fsendcmdtime;
    }
             public void setFsendcmder(String fsendcmder){
        this.fsendcmder=fsendcmder;
    }
	   public String getFsendcmder(){
      return fsendcmder;
    }
             public void setFreccmder(String freccmder){
        this.freccmder=freccmder;
    }
	   public String getFreccmder(){
      return freccmder;
    }
             public void setFrestoretime(java.sql.Timestamp frestoretime){
        this.frestoretime=frestoretime;
    }
	   public java.sql.Timestamp getFrestoretime(){
      return frestoretime;
    }
             public void setFressendcmder(String fressendcmder){
        this.fressendcmder=fressendcmder;
    }
	   public String getFressendcmder(){
      return fressendcmder;
    }
             public void setFresreccmder(String fresreccmder){
        this.fresreccmder=fresreccmder;
    }
	   public String getFresreccmder(){
      return fresreccmder;
    }
             public void setFwriteinlog(String fwriteinlog){
        this.fwriteinlog=fwriteinlog;
    }
	   public String getFwriteinlog(){
      return fwriteinlog;
    }
             public void setFwriteinwglog(String fwriteinwglog){
        this.fwriteinwglog=fwriteinwglog;
    }
	   public String getFwriteinwglog(){
      return fwriteinwglog;
    }
             public void setFsrcno(String fsrcno){
        this.fsrcno=fsrcno;
    }
	   public String getFsrcno(){
      return fsrcno;
    }
             public void setFlogtype(String flogtype){
        this.flogtype=flogtype;
    }
	   public String getFlogtype(){
      return flogtype;
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
             public void setTrans_zddpowerchangrecord4(String trans_zddpowerchangrecord4){
        this.trans_zddpowerchangrecord4=trans_zddpowerchangrecord4;
    }
	   public String getTrans_zddpowerchangrecord4(){
      return trans_zddpowerchangrecord4;
    }
             public void setTrans_zddpowerchangrecord6(String trans_zddpowerchangrecord6){
        this.trans_zddpowerchangrecord6=trans_zddpowerchangrecord6;
    }
	   public String getTrans_zddpowerchangrecord6(){
      return trans_zddpowerchangrecord6;
    }
       
  

}