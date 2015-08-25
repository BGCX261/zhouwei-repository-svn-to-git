package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 设备层次规则
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class EQPLevelReg implements Serializable {
    
	public EQPLevelReg() {
    }
    		 private String fviewangleid;//视角ID
					 private String fregulationname;//名称
					 private String fparentregid;//父规则ID
					 private String freleqpclass;//关联设备分类
					 private String fremark;//规则描述
					 private String fparaid;//公共参清单ID
					 private String fid;//规则ID
					 private int version;//数据库版本控制
				
   /**
     * getters and setters
     */
           public void setFviewangleid(String fviewangleid){
        this.fviewangleid=fviewangleid;
    }
	   public String getFviewangleid(){
      return fviewangleid;
    }
           public void setFregulationname(String fregulationname){
        this.fregulationname=fregulationname;
    }
	   public String getFregulationname(){
      return fregulationname;
    }
           public void setFparentregid(String fparentregid){
        this.fparentregid=fparentregid;
    }
	   public String getFparentregid(){
      return fparentregid;
    }
           public void setFreleqpclass(String freleqpclass){
        this.freleqpclass=freleqpclass;
    }
	   public String getFreleqpclass(){
      return freleqpclass;
    }
           public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
    }
           public void setFparaid(String fparaid){
        this.fparaid=fparaid;
    }
	   public String getFparaid(){
      return fparaid;
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