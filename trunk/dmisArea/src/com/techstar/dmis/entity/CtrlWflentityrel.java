package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 工作流业务实体关系表
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class CtrlWflentityrel implements Serializable {
    
	public CtrlWflentityrel() {
    }
    		 private String entityname;//实体名称
					 private String entityid;//业务ID
					 private String taskid;//任务ID
					 private String frelid;//关系ID
					 private int version;//数据库版本控制
				
   /**
     * getters and setters
     */
           public void setEntityname(String entityname){
        this.entityname=entityname;
    }
	   public String getEntityname(){
      return entityname;
    }
           public void setEntityid(String entityid){
        this.entityid=entityid;
    }
	   public String getEntityid(){
      return entityid;
    }
           public void setTaskid(String taskid){
        this.taskid=taskid;
    }
	   public String getTaskid(){
      return taskid;
    }
           public void setFrelid(String frelid){
        this.frelid=frelid;
    }
	   public String getFrelid(){
      return frelid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
      
  

}