package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 保护辅助设备台帐
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaAuxProtect implements Serializable {
    
	public ParaAuxProtect() {
    }
    		 private String ffaultrecorderno;//设备录波器编号(调度命名)
					 private String fanalog;//模拟量
					 private String fswitch;//开关量
					 private String fisinuse;//是否运行
					 private String fmaterialcodify;//设备物资编码
					 private String fremark;//备注
					 private String feqpid;//设备ID
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.EtsEquipment zparaauxprotect2;
	    		
   /**
     * getters and setters
     */
           public void setFfaultrecorderno(String ffaultrecorderno){
        this.ffaultrecorderno=ffaultrecorderno;
    }
	   public String getFfaultrecorderno(){
      return ffaultrecorderno;
    }
           public void setFanalog(String fanalog){
        this.fanalog=fanalog;
    }
	   public String getFanalog(){
      return fanalog;
    }
           public void setFswitch(String fswitch){
        this.fswitch=fswitch;
    }
	   public String getFswitch(){
      return fswitch;
    }
           public void setFisinuse(String fisinuse){
        this.fisinuse=fisinuse;
    }
	   public String getFisinuse(){
      return fisinuse;
    }
           public void setFmaterialcodify(String fmaterialcodify){
        this.fmaterialcodify=fmaterialcodify;
    }
	   public String getFmaterialcodify(){
      return fmaterialcodify;
    }
           public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
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
           public void setZparaauxprotect2(com.techstar.dmis.entity.EtsEquipment zparaauxprotect2){
        this.zparaauxprotect2=zparaauxprotect2;
    }
	   public com.techstar.dmis.entity.EtsEquipment getZparaauxprotect2(){
      return zparaauxprotect2;
    }
      
  

}