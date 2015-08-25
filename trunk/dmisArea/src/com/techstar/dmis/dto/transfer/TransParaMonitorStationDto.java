package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 集控站系统
 * This classe is based on ValueObject Pattern
 */
public class TransParaMonitorStationDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransParaMonitorStationDto() {
    }
	
          private String fosver; //操作系统版本
          private String fappver; //应用软件版本号
          private String feqpid; //设备ID
          private int version; //数据库版本控制
          private String trans_zparamonitorstation2; //设备ID
    	 
	
   /**
     * getters and setters
     */
            public void setFosver(String fosver){
        this.fosver=fosver;
    }
	   public String getFosver(){
      return fosver;
    }
             public void setFappver(String fappver){
        this.fappver=fappver;
    }
	   public String getFappver(){
      return fappver;
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
             public void setTrans_zparamonitorstation2(String trans_zparamonitorstation2){
        this.trans_zparamonitorstation2=trans_zparamonitorstation2;
    }
	   public String getTrans_zparamonitorstation2(){
      return trans_zparamonitorstation2;
    }
       
  

}