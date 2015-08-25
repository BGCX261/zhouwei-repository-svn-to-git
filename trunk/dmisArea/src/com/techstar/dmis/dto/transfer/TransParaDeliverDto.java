package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 变送器
 * This classe is based on ValueObject Pattern
 */
public class TransParaDeliverDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransParaDeliverDto() {
    }
	
          private String fvolinputpara; //电压输入参数
          private String fvoloutputpara; //电压输出参数
          private String fcurinputpara; //电流输入参数
          private String fcuroutputpara; //电流输出参数
          private String feqpid; //设备ID
          private int version; //数据库版本控制
          private String trans_zparadeliver2; //设备ID
    	 
	
   /**
     * getters and setters
     */
            public void setFvolinputpara(String fvolinputpara){
        this.fvolinputpara=fvolinputpara;
    }
	   public String getFvolinputpara(){
      return fvolinputpara;
    }
             public void setFvoloutputpara(String fvoloutputpara){
        this.fvoloutputpara=fvoloutputpara;
    }
	   public String getFvoloutputpara(){
      return fvoloutputpara;
    }
             public void setFcurinputpara(String fcurinputpara){
        this.fcurinputpara=fcurinputpara;
    }
	   public String getFcurinputpara(){
      return fcurinputpara;
    }
             public void setFcuroutputpara(String fcuroutputpara){
        this.fcuroutputpara=fcuroutputpara;
    }
	   public String getFcuroutputpara(){
      return fcuroutputpara;
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
             public void setTrans_zparadeliver2(String trans_zparadeliver2){
        this.trans_zparadeliver2=trans_zparadeliver2;
    }
	   public String getTrans_zparadeliver2(){
      return trans_zparadeliver2;
    }
       
  

}