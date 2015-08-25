package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 设备实体关系表
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class EQPEntRelationDto  implements Serializable {
    
	public EQPEntRelationDto() {
    }
	
          private String fviewangleid; //视角ID
	      private String fentid; //ID
	      private String fparentid; //父ID
	      private String fentname; //名称
	      private String fiseqp; //是否设备
	      private String fisvitruleqp; //是否虚设备
	      private String fid; //关系ID
	      private int version; //数据库版本控制
		 

  	
	
   /**
     * getters and setters
     */
           public void setFviewangleid(String fviewangleid){
        this.fviewangleid=fviewangleid;
    }
	   public String getFviewangleid(){
      return fviewangleid;
    }
           public void setFentid(String fentid){
        this.fentid=fentid;
    }
	   public String getFentid(){
      return fentid;
    }
           public void setFparentid(String fparentid){
        this.fparentid=fparentid;
    }
	   public String getFparentid(){
      return fparentid;
    }
           public void setFentname(String fentname){
        this.fentname=fentname;
    }
	   public String getFentname(){
      return fentname;
    }
           public void setFiseqp(String fiseqp){
        this.fiseqp=fiseqp;
    }
	   public String getFiseqp(){
      return fiseqp;
    }
           public void setFisvitruleqp(String fisvitruleqp){
        this.fisvitruleqp=fisvitruleqp;
    }
	   public String getFisvitruleqp(){
      return fisvitruleqp;
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
      
  

}