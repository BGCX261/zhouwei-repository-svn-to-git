package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 大屏幕投影系统
 * This classe is based on ValueObject Pattern
 */
public class TransParaBigScreenDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransParaBigScreenDto() {
    }
	
          private String fctrlsysver; //控制系统版本
          private String fspecmesu; //规格尺寸
          private String fother; //其他
          private String feqpid; //设备ID
          private int version; //数据库版本控制
          private String trans_zparabigscreen2; //设备ID
    	 
	
   /**
     * getters and setters
     */
            public void setFctrlsysver(String fctrlsysver){
        this.fctrlsysver=fctrlsysver;
    }
	   public String getFctrlsysver(){
      return fctrlsysver;
    }
             public void setFspecmesu(String fspecmesu){
        this.fspecmesu=fspecmesu;
    }
	   public String getFspecmesu(){
      return fspecmesu;
    }
             public void setFother(String fother){
        this.fother=fother;
    }
	   public String getFother(){
      return fother;
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
             public void setTrans_zparabigscreen2(String trans_zparabigscreen2){
        this.trans_zparabigscreen2=trans_zparabigscreen2;
    }
	   public String getTrans_zparabigscreen2(){
      return trans_zparabigscreen2;
    }
       
  

}