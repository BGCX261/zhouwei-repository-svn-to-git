package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 间隔和间隔组合关联
 * This classe is based on ValueObject Pattern
 */
public class TransMBay2GroupRoleDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransMBay2GroupRoleDto() {
    }
	
          private String fid; //主键标示
          private int version; //数据库版本控制
          private String trans_zmbay2grouprole2; //间隔id
          private String trans_zmbay2grouprole3; //间隔组合id
    	 
	
   /**
     * getters and setters
     */
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
             public void setTrans_zmbay2grouprole2(String trans_zmbay2grouprole2){
        this.trans_zmbay2grouprole2=trans_zmbay2grouprole2;
    }
	   public String getTrans_zmbay2grouprole2(){
      return trans_zmbay2grouprole2;
    }
             public void setTrans_zmbay2grouprole3(String trans_zmbay2grouprole3){
        this.trans_zmbay2grouprole3=trans_zmbay2grouprole3;
    }
	   public String getTrans_zmbay2grouprole3(){
      return trans_zmbay2grouprole3;
    }
       
  

}