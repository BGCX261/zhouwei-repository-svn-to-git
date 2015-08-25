package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 绯荤粺瀛楀吀瑙嗗浘
 * This classe is based on ValueObject Pattern
 */
public class TransVZdSystemdicDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransVZdSystemdicDto() {
    }
	
          private String systemdicid; //绯荤粺瀛楀吀涓婚敭
          private String name; //鍚嶇О
          private String fatherid; //鐖剁紪鍙�
          private String typeid; //绫诲瀷缂栧彿
          private String typename; //绫诲瀷鍚嶇О
          private String viewid; //瑙嗗浘涓婚敭
    	 
	
   /**
     * getters and setters
     */
            public void setSystemdicid(String systemdicid){
        this.systemdicid=systemdicid;
    }
	   public String getSystemdicid(){
      return systemdicid;
    }
             public void setName(String name){
        this.name=name;
    }
	   public String getName(){
      return name;
    }
             public void setFatherid(String fatherid){
        this.fatherid=fatherid;
    }
	   public String getFatherid(){
      return fatherid;
    }
             public void setTypeid(String typeid){
        this.typeid=typeid;
    }
	   public String getTypeid(){
      return typeid;
    }
             public void setTypename(String typename){
        this.typename=typename;
    }
	   public String getTypename(){
      return typename;
    }
             public void setViewid(String viewid){
        this.viewid=viewid;
    }
	   public String getViewid(){
      return viewid;
    }
       
  

}