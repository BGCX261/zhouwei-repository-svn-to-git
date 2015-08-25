package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 电能量远方终端
 * This classe is based on ValueObject Pattern
 */
public class TransParaEngTermDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransParaEngTermDto() {
    }
	
          private String fremark; //备注
          private String fid; //主键标示
          private int version; //数据库版本控制
          private String trans_zparaengterm1; //主键标示
    	 
	
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
             public void setTrans_zparaengterm1(String trans_zparaengterm1){
        this.trans_zparaengterm1=trans_zparaengterm1;
    }
	   public String getTrans_zparaengterm1(){
      return trans_zparaengterm1;
    }
       
  

}