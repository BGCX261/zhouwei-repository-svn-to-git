package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 日计划定值单关系
 * This classe is based on ValueObject Pattern
 */
public class TransDdDayplanfixvaluerelDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDdDayplanfixvaluerelDto() {
    }
	
          private String frelid; //关系ID
          private int version; //数据库版本控制
          private String trans_zdddayplanfixvaluerel2; //日计划编号
          private String trans_zdddayplanfixvaluerel4; //定值单ID
    	 
	
   /**
     * getters and setters
     */
            public void setFrelid(String frelid){
        this.frelid=frelid;
    }
	   public String getFrelid(){
      return frelid;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setTrans_zdddayplanfixvaluerel2(String trans_zdddayplanfixvaluerel2){
        this.trans_zdddayplanfixvaluerel2=trans_zdddayplanfixvaluerel2;
    }
	   public String getTrans_zdddayplanfixvaluerel2(){
      return trans_zdddayplanfixvaluerel2;
    }
             public void setTrans_zdddayplanfixvaluerel4(String trans_zdddayplanfixvaluerel4){
        this.trans_zdddayplanfixvaluerel4=trans_zdddayplanfixvaluerel4;
    }
	   public String getTrans_zdddayplanfixvaluerel4(){
      return trans_zdddayplanfixvaluerel4;
    }
       
  

}