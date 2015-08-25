package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 日计划执行
 * This classe is based on ValueObject Pattern
 */
public class TransDdDayplanexcutelistDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDdDayplanexcutelistDto() {
    }
	
          private String fsendcmder; //下令人
          private String freccmder; //接令人
          private java.sql.Timestamp fsendcmdtime; //下令时间
          private String freturnner; //交令人
          private java.sql.Timestamp freturntime; //交令时间
          private String fspresponser; //停发电负责人
          private String faccepter; //收令人
          private String fexcutedept; //执行单位
          private String fexcuteremark; //说明
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String fid; //序号
          private int version; //数据库版本控制
          private String trans_zdddayplanexcutelist1; //日计划编号
    	 
	
   /**
     * getters and setters
     */
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
             public void setFreturnner(String freturnner){
        this.freturnner=freturnner;
    }
	   public String getFreturnner(){
      return freturnner;
    }
             public void setFreturntime(java.sql.Timestamp freturntime){
        this.freturntime=freturntime;
    }
	   public java.sql.Timestamp getFreturntime(){
      return freturntime;
    }
             public void setFspresponser(String fspresponser){
        this.fspresponser=fspresponser;
    }
	   public String getFspresponser(){
      return fspresponser;
    }
             public void setFaccepter(String faccepter){
        this.faccepter=faccepter;
    }
	   public String getFaccepter(){
      return faccepter;
    }
             public void setFexcutedept(String fexcutedept){
        this.fexcutedept=fexcutedept;
    }
	   public String getFexcutedept(){
      return fexcutedept;
    }
             public void setFexcuteremark(String fexcuteremark){
        this.fexcuteremark=fexcuteremark;
    }
	   public String getFexcuteremark(){
      return fexcuteremark;
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
             public void setTrans_zdddayplanexcutelist1(String trans_zdddayplanexcutelist1){
        this.trans_zdddayplanexcutelist1=trans_zdddayplanexcutelist1;
    }
	   public String getTrans_zdddayplanexcutelist1(){
      return trans_zdddayplanexcutelist1;
    }
       
  

}