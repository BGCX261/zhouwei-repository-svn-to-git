package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for VQC设备
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaVQC implements Serializable {
    
	public ParaVQC() {
    }
    		 private String fissoftware;//VQC实现形式
					 private String fisvolrgltruning;//调压功能是否运行
					 private String fosver;//操作系统版本
					 private String fappver;//应用软件版本号
					 private String feqpid;//设备ID
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.EtsEquipment zparavqc2;
	    		
   /**
     * getters and setters
     */
           public void setFissoftware(String fissoftware){
        this.fissoftware=fissoftware;
    }
	   public String getFissoftware(){
      return fissoftware;
    }
           public void setFisvolrgltruning(String fisvolrgltruning){
        this.fisvolrgltruning=fisvolrgltruning;
    }
	   public String getFisvolrgltruning(){
      return fisvolrgltruning;
    }
           public void setFosver(String fosver){
        this.fosver=fosver;
    }
	   public String getFosver(){
      return fosver;
    }
           public void setFappver(String fappver){
        this.fappver=fappver;
    }
	   public String getFappver(){
      return fappver;
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
           public void setZparavqc2(com.techstar.dmis.entity.EtsEquipment zparavqc2){
        this.zparavqc2=zparavqc2;
    }
	   public com.techstar.dmis.entity.EtsEquipment getZparavqc2(){
      return zparavqc2;
    }
      
  

}