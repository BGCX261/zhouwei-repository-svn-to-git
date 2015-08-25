package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 调度运行纪事
 * This classe is based on ValueObject Pattern
 */
public class TransDdOperationnotebookDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDdOperationnotebookDto() {
    }
	
          private java.sql.Timestamp focurtime; //发生时间
          private String foperlog; //运行记事
          private String fwritetype; //填写分类
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String fiswritelog; //是否写入日志
          private String fiswriteincurlog; //是否写入班志
          private String fid; //运行纪事编号
          private int version; //数据库版本控制
          private String trans_zddoperationnotebook4; //当前班志编号
          private String trans_zddoperationnotebook5; //当前日志编号
    	 
	
   /**
     * getters and setters
     */
            public void setFocurtime(java.sql.Timestamp focurtime){
        this.focurtime=focurtime;
    }
	   public java.sql.Timestamp getFocurtime(){
      return focurtime;
    }
             public void setFoperlog(String foperlog){
        this.foperlog=foperlog;
    }
	   public String getFoperlog(){
      return foperlog;
    }
             public void setFwritetype(String fwritetype){
        this.fwritetype=fwritetype;
    }
	   public String getFwritetype(){
      return fwritetype;
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
             public void setFiswritelog(String fiswritelog){
        this.fiswritelog=fiswritelog;
    }
	   public String getFiswritelog(){
      return fiswritelog;
    }
             public void setFiswriteincurlog(String fiswriteincurlog){
        this.fiswriteincurlog=fiswriteincurlog;
    }
	   public String getFiswriteincurlog(){
      return fiswriteincurlog;
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
             public void setTrans_zddoperationnotebook4(String trans_zddoperationnotebook4){
        this.trans_zddoperationnotebook4=trans_zddoperationnotebook4;
    }
	   public String getTrans_zddoperationnotebook4(){
      return trans_zddoperationnotebook4;
    }
             public void setTrans_zddoperationnotebook5(String trans_zddoperationnotebook5){
        this.trans_zddoperationnotebook5=trans_zddoperationnotebook5;
    }
	   public String getTrans_zddoperationnotebook5(){
      return trans_zddoperationnotebook5;
    }
       
  

}