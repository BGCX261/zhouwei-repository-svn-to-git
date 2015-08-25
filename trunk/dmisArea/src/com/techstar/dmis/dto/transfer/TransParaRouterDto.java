package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 路由器
 * This classe is based on ValueObject Pattern
 */
public class TransParaRouterDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransParaRouterDto() {
    }
	
          private String fremark; //备注
          private String fid; //主键标示
          private int version; //数据库版本控制
          private String trans_zpararouter1; //主键标示
    	 
	
   /**
     * getters and setters
     */
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
             public void setTrans_zpararouter1(String trans_zpararouter1){
        this.trans_zpararouter1=trans_zpararouter1;
    }
	   public String getTrans_zpararouter1(){
      return trans_zpararouter1;
    }
       
  

}