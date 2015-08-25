package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 方式变更明细表
 * This classe is based on ValueObject Pattern
 */
public class TransDdfsModechangelistDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDdfsModechangelistDto() {
    }
	
          private String fstationname; //变电站
          private String currentmode; //当前方式
          private String fstationid; //变电站ID
          private String aftermode; //变更后方式
          private String srctype; //来源分类
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String fid; //序号
          private int version; //数据库版本控制
          private String trans_zddfsmodechangelist4; //日计划来源编号
          private String trans_zddfsmodechangelist5; //来源编号
    	 
	
   /**
     * getters and setters
     */
            public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
             public void setCurrentmode(String currentmode){
        this.currentmode=currentmode;
    }
	   public String getCurrentmode(){
      return currentmode;
    }
             public void setFstationid(String fstationid){
        this.fstationid=fstationid;
    }
	   public String getFstationid(){
      return fstationid;
    }
             public void setAftermode(String aftermode){
        this.aftermode=aftermode;
    }
	   public String getAftermode(){
      return aftermode;
    }
             public void setSrctype(String srctype){
        this.srctype=srctype;
    }
	   public String getSrctype(){
      return srctype;
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
             public void setTrans_zddfsmodechangelist4(String trans_zddfsmodechangelist4){
        this.trans_zddfsmodechangelist4=trans_zddfsmodechangelist4;
    }
	   public String getTrans_zddfsmodechangelist4(){
      return trans_zddfsmodechangelist4;
    }
             public void setTrans_zddfsmodechangelist5(String trans_zddfsmodechangelist5){
        this.trans_zddfsmodechangelist5=trans_zddfsmodechangelist5;
    }
	   public String getTrans_zddfsmodechangelist5(){
      return trans_zddfsmodechangelist5;
    }
       
  

}