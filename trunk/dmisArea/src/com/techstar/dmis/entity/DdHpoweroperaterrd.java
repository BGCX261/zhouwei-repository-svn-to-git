package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 电厂运行(下令操作)记录
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdHpoweroperaterrd implements Serializable {
    
	public DdHpoweroperaterrd() {
    }
    		 private String fplant;//电厂名
					 private String fsendcmder;//下令人
					 private String freccmder;//受令人
					 private java.sql.Timestamp fsendcmdtime;//下令时间
					 private int fsendcmdwaterlevel;//下令水位(米)
					 private int fsendcmdgenerating;//下令发电量(W)
					 private int fsendcmdoutflow;//下令放水量(个)
					 private String fsummiter;//交令人
					 private int freccmdwaterlevel;//交令水位
					 private int freccmdgenerating;//交令发电量(W)
					 private int freccmdoutflow;//交令放水量
					 private java.sql.Timestamp fsummittime;//交令时间
					 private String fwriteinlog;//是否写入日志
					 private String fwriteinwglog;//是否写入班志
					 private String sys_fille;//填写人
					 private String sys_filldept;//填写单位
					 private java.sql.Timestamp sys_filltime;//填写时间
					 private int sys_isvalid;//是否有效字段
					 private String sys_dataowner;//数据所属单位
					 private String fordertype;//命令类型
					 private String fid;//记录编号
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.DdClassondutylog zddhpoweroperaterrd5;
	    			 private com.techstar.dmis.entity.StdStation zddhpoweroperaterrd2;
	    		
   /**
     * getters and setters
     */
           public void setFplant(String fplant){
        this.fplant=fplant;
    }
	   public String getFplant(){
      return fplant;
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
           public void setFsendcmdtime(java.sql.Timestamp fsendcmdtime){
        this.fsendcmdtime=fsendcmdtime;
    }
	   public java.sql.Timestamp getFsendcmdtime(){
      return fsendcmdtime;
    }
           public void setFsendcmdwaterlevel(int fsendcmdwaterlevel){
        this.fsendcmdwaterlevel=fsendcmdwaterlevel;
    }
	   public int getFsendcmdwaterlevel(){
      return fsendcmdwaterlevel;
    }
           public void setFsendcmdgenerating(int fsendcmdgenerating){
        this.fsendcmdgenerating=fsendcmdgenerating;
    }
	   public int getFsendcmdgenerating(){
      return fsendcmdgenerating;
    }
           public void setFsendcmdoutflow(int fsendcmdoutflow){
        this.fsendcmdoutflow=fsendcmdoutflow;
    }
	   public int getFsendcmdoutflow(){
      return fsendcmdoutflow;
    }
           public void setFsummiter(String fsummiter){
        this.fsummiter=fsummiter;
    }
	   public String getFsummiter(){
      return fsummiter;
    }
           public void setFreccmdwaterlevel(int freccmdwaterlevel){
        this.freccmdwaterlevel=freccmdwaterlevel;
    }
	   public int getFreccmdwaterlevel(){
      return freccmdwaterlevel;
    }
           public void setFreccmdgenerating(int freccmdgenerating){
        this.freccmdgenerating=freccmdgenerating;
    }
	   public int getFreccmdgenerating(){
      return freccmdgenerating;
    }
           public void setFreccmdoutflow(int freccmdoutflow){
        this.freccmdoutflow=freccmdoutflow;
    }
	   public int getFreccmdoutflow(){
      return freccmdoutflow;
    }
           public void setFsummittime(java.sql.Timestamp fsummittime){
        this.fsummittime=fsummittime;
    }
	   public java.sql.Timestamp getFsummittime(){
      return fsummittime;
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
           public void setFordertype(String fordertype){
        this.fordertype=fordertype;
    }
	   public String getFordertype(){
      return fordertype;
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
           public void setZddhpoweroperaterrd5(com.techstar.dmis.entity.DdClassondutylog zddhpoweroperaterrd5){
        this.zddhpoweroperaterrd5=zddhpoweroperaterrd5;
    }
	   public com.techstar.dmis.entity.DdClassondutylog getZddhpoweroperaterrd5(){
      return zddhpoweroperaterrd5;
    }
           public void setZddhpoweroperaterrd2(com.techstar.dmis.entity.StdStation zddhpoweroperaterrd2){
        this.zddhpoweroperaterrd2=zddhpoweroperaterrd2;
    }
	   public com.techstar.dmis.entity.StdStation getZddhpoweroperaterrd2(){
      return zddhpoweroperaterrd2;
    }
      
  

}