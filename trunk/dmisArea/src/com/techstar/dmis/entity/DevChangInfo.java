package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 设备变更信息
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DevChangInfo implements Serializable {
    
	public DevChangInfo() {
    }
    		 private String feqpid;//设备ID
					 private java.sql.Date fchangedate;//变动时间
					 private String fupdateuser;//变动人
					 private String fchangecontent;//变动内容
					 private String fbfchgcnt;//变动前内容
					 private String fchgtype;//变动类型
					 private String fremark;//备注
					 private String fid;//ID
					 private int version;//数据库版本控制
				
   /**
     * getters and setters
     */
           public void setFeqpid(String feqpid){
        this.feqpid=feqpid;
    }
	   public String getFeqpid(){
      return feqpid;
    }
           public void setFchangedate(java.sql.Date fchangedate){
        this.fchangedate=fchangedate;
    }
	   public java.sql.Date getFchangedate(){
      return fchangedate;
    }
           public void setFupdateuser(String fupdateuser){
        this.fupdateuser=fupdateuser;
    }
	   public String getFupdateuser(){
      return fupdateuser;
    }
           public void setFchangecontent(String fchangecontent){
        this.fchangecontent=fchangecontent;
    }
	   public String getFchangecontent(){
      return fchangecontent;
    }
           public void setFbfchgcnt(String fbfchgcnt){
        this.fbfchgcnt=fbfchgcnt;
    }
	   public String getFbfchgcnt(){
      return fbfchgcnt;
    }
           public void setFchgtype(String fchgtype){
        this.fchgtype=fchgtype;
    }
	   public String getFchgtype(){
      return fchgtype;
    }
           public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
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