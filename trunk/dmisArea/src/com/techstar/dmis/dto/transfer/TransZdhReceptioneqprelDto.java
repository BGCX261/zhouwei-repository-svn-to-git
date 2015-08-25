package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 基改建工程自动化设备投运清单
 * This classe is based on ValueObject Pattern
 */
public class TransZdhReceptioneqprelDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransZdhReceptioneqprelDto() {
    }
	
              private String receptioneqprelid; //关系iD
          private int version; //数据库版本控制
          private String trans_zzdhreceptioneqprel1; //申请验收编号
          private String trans_zzdhreceptioneqprel2; //设备id
    	 
	
   /**
     * getters and setters
     */
                 public void setReceptioneqprelid(String receptioneqprelid){
        this.receptioneqprelid=receptioneqprelid;
    }
	   public String getReceptioneqprelid(){
      return receptioneqprelid;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setTrans_zzdhreceptioneqprel1(String trans_zzdhreceptioneqprel1){
        this.trans_zzdhreceptioneqprel1=trans_zzdhreceptioneqprel1;
    }
	   public String getTrans_zzdhreceptioneqprel1(){
      return trans_zzdhreceptioneqprel1;
    }
             public void setTrans_zzdhreceptioneqprel2(String trans_zzdhreceptioneqprel2){
        this.trans_zzdhreceptioneqprel2=trans_zzdhreceptioneqprel2;
    }
	   public String getTrans_zzdhreceptioneqprel2(){
      return trans_zzdhreceptioneqprel2;
    }
       
  

}