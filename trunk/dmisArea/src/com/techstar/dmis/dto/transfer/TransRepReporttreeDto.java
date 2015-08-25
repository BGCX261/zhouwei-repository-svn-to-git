package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 报表树分类
 * This classe is based on ValueObject Pattern
 */
public class TransRepReporttreeDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransRepReporttreeDto() {
    }
	
          private String f_name; //分类名称
          private String f_parenttreeid; //父节点ID
          private String f_description; //描述
          private String f_treeid; //报表分类ID
          private int version; //数据库版本控制
          private java.util.Collection freptree2result1; //报表分类ID
    	 
	
   /**
     * getters and setters
     */
            public void setF_name(String f_name){
        this.f_name=f_name;
    }
	   public String getF_name(){
      return f_name;
    }
             public void setF_parenttreeid(String f_parenttreeid){
        this.f_parenttreeid=f_parenttreeid;
    }
	   public String getF_parenttreeid(){
      return f_parenttreeid;
    }
             public void setF_description(String f_description){
        this.f_description=f_description;
    }
	   public String getF_description(){
      return f_description;
    }
             public void setF_treeid(String f_treeid){
        this.f_treeid=f_treeid;
    }
	   public String getF_treeid(){
      return f_treeid;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setFreptree2result1(java.util.Collection freptree2result1){
        this.freptree2result1=freptree2result1;
    }
	   public java.util.Collection getFreptree2result1(){
      return freptree2result1;
    }
       
  

}