package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 低频减载投入通知
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class FsLfeqpruninform implements Serializable {
    
	public FsLfeqpruninform() {
    }
    		 private java.sql.Date frundate;//投入日期
					 private String fstationid;//厂站编号
					 private String fstationname;//投入厂站
					 private String frunmark;//投运说明
					 private String finformer;//通知人
					 private byte[] fprocess;//执行程序
					 private String fremark;//备注
					 private String lfruninformno;//投入通知书编号
					 private String sys_fille;//填写人
					 private String sys_filldept;//填写单位
					 private java.sql.Timestamp sys_filltime;//填写时间
					 private int sys_isvalid;//是否有效字段
					 private String sys_dataowner;//数据所属单位
					 private String lfeqpruninformid;//保护投入通知书编号
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.FsLfeqpfixinform zfslfeqpruninform2;
	    		
   /**
     * getters and setters
     */
           public void setFrundate(java.sql.Date frundate){
        this.frundate=frundate;
    }
	   public java.sql.Date getFrundate(){
      return frundate;
    }
           public void setFstationid(String fstationid){
        this.fstationid=fstationid;
    }
	   public String getFstationid(){
      return fstationid;
    }
           public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
           public void setFrunmark(String frunmark){
        this.frunmark=frunmark;
    }
	   public String getFrunmark(){
      return frunmark;
    }
           public void setFinformer(String finformer){
        this.finformer=finformer;
    }
	   public String getFinformer(){
      return finformer;
    }
           public void setFprocess(byte[] fprocess){
        this.fprocess=fprocess;
    }
	   public byte[] getFprocess(){
      return fprocess;
    }
           public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
    }
           public void setLfruninformno(String lfruninformno){
        this.lfruninformno=lfruninformno;
    }
	   public String getLfruninformno(){
      return lfruninformno;
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
           public void setLfeqpruninformid(String lfeqpruninformid){
        this.lfeqpruninformid=lfeqpruninformid;
    }
	   public String getLfeqpruninformid(){
      return lfeqpruninformid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZfslfeqpruninform2(com.techstar.dmis.entity.FsLfeqpfixinform zfslfeqpruninform2){
        this.zfslfeqpruninform2=zfslfeqpruninform2;
    }
	   public com.techstar.dmis.entity.FsLfeqpfixinform getZfslfeqpruninform2(){
      return zfslfeqpruninform2;
    }
      
  

}