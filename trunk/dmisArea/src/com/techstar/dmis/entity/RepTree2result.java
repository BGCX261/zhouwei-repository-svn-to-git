package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 报表树分类和报表数据关系
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class RepTree2result implements Serializable {
    
	public RepTree2result() {
    }
    		 private String f_relationid;//关系ID
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.RepReporttree zreptree2result1;
	    			 private com.techstar.dmis.entity.RepRepresult zreptree2result2;
	    		
   /**
     * getters and setters
     */
           public void setF_relationid(String f_relationid){
        this.f_relationid=f_relationid;
    }
	   public String getF_relationid(){
      return f_relationid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZreptree2result1(com.techstar.dmis.entity.RepReporttree zreptree2result1){
        this.zreptree2result1=zreptree2result1;
    }
	   public com.techstar.dmis.entity.RepReporttree getZreptree2result1(){
      return zreptree2result1;
    }
           public void setZreptree2result2(com.techstar.dmis.entity.RepRepresult zreptree2result2){
        this.zreptree2result2=zreptree2result2;
    }
	   public com.techstar.dmis.entity.RepRepresult getZreptree2result2(){
      return zreptree2result2;
    }
      
  

}