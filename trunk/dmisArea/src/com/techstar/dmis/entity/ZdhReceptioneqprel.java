package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 基改建工程自动化设备投运清单
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ZdhReceptioneqprel implements Serializable {
    
	public ZdhReceptioneqprel() {
    }
    		 private byte[] feqpcontent;//设备信息
					 private String receptioneqprelid;//关系iD
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.ZdhReception zzdhreceptioneqprel1;
	    			
	    		
   /**
     * getters and setters
     */
           public void setFeqpcontent(byte[] feqpcontent){
        this.feqpcontent=feqpcontent;
    }
	   public byte[] getFeqpcontent(){
      return feqpcontent;
    }
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
           public void setZzdhreceptioneqprel1(com.techstar.dmis.entity.ZdhReception zzdhreceptioneqprel1){
        this.zzdhreceptioneqprel1=zzdhreceptioneqprel1;
    }
	   public com.techstar.dmis.entity.ZdhReception getZzdhreceptioneqprel1(){
      return zzdhreceptioneqprel1;
    }

  

}