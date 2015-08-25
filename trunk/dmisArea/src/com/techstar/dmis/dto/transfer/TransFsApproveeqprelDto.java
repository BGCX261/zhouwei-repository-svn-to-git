package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 发电批准书设备关系表
 * This classe is based on ValueObject Pattern
 */
public class TransFsApproveeqprelDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransFsApproveeqprelDto() {
    }
	
          private String feqpid; //设备内部编号
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String fappeqprelid; //批准书设备关系ID
          private int version; //数据库版本控制
          private String trans_zfsapproveeqprel1; //批准书内部编号
    	 
	
   /**
     * getters and setters
     */
            public void setFeqpid(String feqpid){
        this.feqpid=feqpid;
    }
	   public String getFeqpid(){
      return feqpid;
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
             public void setFappeqprelid(String fappeqprelid){
        this.fappeqprelid=fappeqprelid;
    }
	   public String getFappeqprelid(){
      return fappeqprelid;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setTrans_zfsapproveeqprel1(String trans_zfsapproveeqprel1){
        this.trans_zfsapproveeqprel1=trans_zfsapproveeqprel1;
    }
	   public String getTrans_zfsapproveeqprel1(){
      return trans_zfsapproveeqprel1;
    }
       
  

}