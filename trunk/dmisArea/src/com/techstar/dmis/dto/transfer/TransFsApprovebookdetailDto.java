package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 发电批准书执行明细
 * This classe is based on ValueObject Pattern
 */
public class TransFsApprovebookdetailDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransFsApprovebookdetailDto() {
    }
	
          private int sequenceno; //顺序号
          private java.sql.Date excutetime; //执行时间
          private String excuter; //执行人
          private String excutesituation; //执行情况
          private String remark; //执行内容
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String fapprovexcuteno; //批准书执行编号
          private int version; //数据库版本控制
          private String trans_zfsapprovebookdetail1; //批准书内部编号
    	 
	
   /**
     * getters and setters
     */
            public void setSequenceno(int sequenceno){
        this.sequenceno=sequenceno;
    }
	   public int getSequenceno(){
      return sequenceno;
    }
             public void setExcutetime(java.sql.Date excutetime){
        this.excutetime=excutetime;
    }
	   public java.sql.Date getExcutetime(){
      return excutetime;
    }
             public void setExcuter(String excuter){
        this.excuter=excuter;
    }
	   public String getExcuter(){
      return excuter;
    }
             public void setExcutesituation(String excutesituation){
        this.excutesituation=excutesituation;
    }
	   public String getExcutesituation(){
      return excutesituation;
    }
             public void setRemark(String remark){
        this.remark=remark;
    }
	   public String getRemark(){
      return remark;
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
             public void setFapprovexcuteno(String fapprovexcuteno){
        this.fapprovexcuteno=fapprovexcuteno;
    }
	   public String getFapprovexcuteno(){
      return fapprovexcuteno;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setTrans_zfsapprovebookdetail1(String trans_zfsapprovebookdetail1){
        this.trans_zfsapprovebookdetail1=trans_zfsapprovebookdetail1;
    }
	   public String getTrans_zfsapprovebookdetail1(){
      return trans_zfsapprovebookdetail1;
    }
       
  

}