package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 发电批准书附件数据表
 * This classe is based on ValueObject Pattern
 */
public class TransFsAllappendixDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransFsAllappendixDto() {
    }
	
          private String f_entityname; //相关表名
          private String f_note; //附件信息说明
              private String type; //附件类型
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String f_id; //附件编号
          private int version; //数据库版本控制
          private String trans_zfsallappendix1; //相关记录编号
    	 
	
   /**
     * getters and setters
     */
            public void setF_entityname(String f_entityname){
        this.f_entityname=f_entityname;
    }
	   public String getF_entityname(){
      return f_entityname;
    }
             public void setF_note(String f_note){
        this.f_note=f_note;
    }
	   public String getF_note(){
      return f_note;
    }
                  public void setType(String type){
        this.type=type;
    }
	   public String getType(){
      return type;
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
             public void setF_id(String f_id){
        this.f_id=f_id;
    }
	   public String getF_id(){
      return f_id;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setTrans_zfsallappendix1(String trans_zfsallappendix1){
        this.trans_zfsallappendix1=trans_zfsallappendix1;
    }
	   public String getTrans_zfsallappendix1(){
      return trans_zfsallappendix1;
    }
       
  

}