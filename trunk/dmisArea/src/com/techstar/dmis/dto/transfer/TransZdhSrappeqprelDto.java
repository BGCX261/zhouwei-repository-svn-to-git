package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 停复役申请与设备关系
 * This classe is based on ValueObject Pattern
 */
public class TransZdhSrappeqprelDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransZdhSrappeqprelDto() {
    }
	
          private String eqpid; //设备ID
          private String fid; //申请设备关系ID
          private int version; //数据库版本控制
          private String trans_zzdhsrappeqprel1; //申请表编号
    	 
	
   /**
     * getters and setters
     */
            public void setEqpid(String eqpid){
        this.eqpid=eqpid;
    }
	   public String getEqpid(){
      return eqpid;
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
             public void setTrans_zzdhsrappeqprel1(String trans_zzdhsrappeqprel1){
        this.trans_zzdhsrappeqprel1=trans_zzdhsrappeqprel1;
    }
	   public String getTrans_zzdhsrappeqprel1(){
      return trans_zzdhsrappeqprel1;
    }
       
  

}