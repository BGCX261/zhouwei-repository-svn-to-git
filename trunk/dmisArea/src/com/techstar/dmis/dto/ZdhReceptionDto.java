package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 基改建工程自动化设备验收投运
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ZdhReceptionDto  implements Serializable {
    
	public ZdhReceptionDto() {
    }
	     private String fstatus; //流转状态
          private String fstationname; //变电站名称
	      private String fsystemname; //系统名称
	      private java.sql.Date freceptiondate; //验收日期
	      private String feqpremark; //设备说明
	      private byte[] freceptiongraph; //竣工图
	      private byte[] freceptionreport; //验收报告
	      private byte[] fsequence; //序位表
	      private byte[] ftranrec; //传动记录
	      private String fremark; //备注
	      private String fstationid; //变电站ID
	      private String freceptionno; //申请单编号
	      private String fruneqoremark; //投运设备说明
	      private java.sql.Date fapplyrundate; //申请投运时间
	      private java.sql.Date fapproverundate; //批准投运时间
	      private java.sql.Date frundate; //实际投运时间
	      private String fexcutestatus; //执行情况
	      private String localapprover1; //投运批准人
	      private String centeropinion1; //自动化处意见
	      private String centeropinion2; //运维中心意见
	      private byte[] runeqpcontent; //投运设备内容
	      private String sys_fille; //填写人
	      private String sys_filldept; //填写单位
	      private java.sql.Timestamp sys_filltime; //填写时间
	      private int sys_isvalid; //是否有效字段
	      private String sys_dataowner; //数据所属单位
	      private String fsystemtype; //系统类型
	      private String fapplicationid; //申请验收编号
	      private int version; //数据库版本控制
	      private java.util.Collection fzdhreceptioneqprel1; //申请验收编号
		 

  	
	
   /**
		 * @return the fstatus
		 */
		public String getFstatus() {
			return fstatus;
		}
		/**
		 * @param fstatus the fstatus to set
		 */
		public void setFstatus(String fstatus) {
			this.fstatus = fstatus;
		}
/**
     * getters and setters
     */
           public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
           public void setFsystemname(String fsystemname){
        this.fsystemname=fsystemname;
    }
	   public String getFsystemname(){
      return fsystemname;
    }
           public void setFreceptiondate(java.sql.Date freceptiondate){
        this.freceptiondate=freceptiondate;
    }
	   public java.sql.Date getFreceptiondate(){
      return freceptiondate;
    }
           public void setFeqpremark(String feqpremark){
        this.feqpremark=feqpremark;
    }
	   public String getFeqpremark(){
      return feqpremark;
    }
           public void setFreceptiongraph(byte[] freceptiongraph){
        this.freceptiongraph=freceptiongraph;
    }
	   public byte[] getFreceptiongraph(){
      return freceptiongraph;
    }
           public void setFreceptionreport(byte[] freceptionreport){
        this.freceptionreport=freceptionreport;
    }
	   public byte[] getFreceptionreport(){
      return freceptionreport;
    }
           public void setFsequence(byte[] fsequence){
        this.fsequence=fsequence;
    }
	   public byte[] getFsequence(){
      return fsequence;
    }
           public void setFtranrec(byte[] ftranrec){
        this.ftranrec=ftranrec;
    }
	   public byte[] getFtranrec(){
      return ftranrec;
    }
           public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
    }
           public void setFstationid(String fstationid){
        this.fstationid=fstationid;
    }
	   public String getFstationid(){
      return fstationid;
    }
           public void setFreceptionno(String freceptionno){
        this.freceptionno=freceptionno;
    }
	   public String getFreceptionno(){
      return freceptionno;
    }
           public void setFruneqoremark(String fruneqoremark){
        this.fruneqoremark=fruneqoremark;
    }
	   public String getFruneqoremark(){
      return fruneqoremark;
    }
           public void setFapplyrundate(java.sql.Date fapplyrundate){
        this.fapplyrundate=fapplyrundate;
    }
	   public java.sql.Date getFapplyrundate(){
      return fapplyrundate;
    }
           public void setFapproverundate(java.sql.Date fapproverundate){
        this.fapproverundate=fapproverundate;
    }
	   public java.sql.Date getFapproverundate(){
      return fapproverundate;
    }
           public void setFrundate(java.sql.Date frundate){
        this.frundate=frundate;
    }
	   public java.sql.Date getFrundate(){
      return frundate;
    }
           public void setFexcutestatus(String fexcutestatus){
        this.fexcutestatus=fexcutestatus;
    }
	   public String getFexcutestatus(){
      return fexcutestatus;
    }
           public void setLocalapprover1(String localapprover1){
        this.localapprover1=localapprover1;
    }
	   public String getLocalapprover1(){
      return localapprover1;
    }
           public void setCenteropinion1(String centeropinion1){
        this.centeropinion1=centeropinion1;
    }
	   public String getCenteropinion1(){
      return centeropinion1;
    }
           public void setCenteropinion2(String centeropinion2){
        this.centeropinion2=centeropinion2;
    }
	   public String getCenteropinion2(){
      return centeropinion2;
    }
           public void setRuneqpcontent(byte[] runeqpcontent){
        this.runeqpcontent=runeqpcontent;
    }
	   public byte[] getRuneqpcontent(){
      return runeqpcontent;
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
           public void setFsystemtype(String fsystemtype){
        this.fsystemtype=fsystemtype;
    }
	   public String getFsystemtype(){
      return fsystemtype;
    }
           public void setFapplicationid(String fapplicationid){
        this.fapplicationid=fapplicationid;
    }
	   public String getFapplicationid(){
      return fapplicationid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setFzdhreceptioneqprel1(java.util.Collection fzdhreceptioneqprel1){
        this.fzdhreceptioneqprel1=fzdhreceptioneqprel1;
    }
	   public java.util.Collection getFzdhreceptioneqprel1(){
      return fzdhreceptioneqprel1;
    }
      
  

}