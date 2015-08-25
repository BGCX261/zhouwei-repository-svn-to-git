package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 服务器
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaSever implements Serializable {
    
	public ParaSever() {
    }
    		 private String fos;//操作系统
					 private String fver;//版本
					 private int fmainfrequent;//主频(GHZ)
					 private int fmemory;//内存(G)
					 private int fharddiskcapa;//硬盘容量(G)
					 private String fother;//其他
					 private String feqpid;//设备ID
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.EtsEquipment zparasever2;
	    		
   /**
     * getters and setters
     */
           public void setFos(String fos){
        this.fos=fos;
    }
	   public String getFos(){
      return fos;
    }
           public void setFver(String fver){
        this.fver=fver;
    }
	   public String getFver(){
      return fver;
    }
           public void setFmainfrequent(int fmainfrequent){
        this.fmainfrequent=fmainfrequent;
    }
	   public int getFmainfrequent(){
      return fmainfrequent;
    }
           public void setFmemory(int fmemory){
        this.fmemory=fmemory;
    }
	   public int getFmemory(){
      return fmemory;
    }
           public void setFharddiskcapa(int fharddiskcapa){
        this.fharddiskcapa=fharddiskcapa;
    }
	   public int getFharddiskcapa(){
      return fharddiskcapa;
    }
           public void setFother(String fother){
        this.fother=fother;
    }
	   public String getFother(){
      return fother;
    }
           public void setFeqpid(String feqpid){
        this.feqpid=feqpid;
    }
	   public String getFeqpid(){
      return feqpid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZparasever2(com.techstar.dmis.entity.EtsEquipment zparasever2){
        this.zparasever2=zparasever2;
    }
	   public com.techstar.dmis.entity.EtsEquipment getZparasever2(){
      return zparasever2;
    }
      
  

}