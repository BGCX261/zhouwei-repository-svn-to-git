package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 间隔设备映射表
 * This classe is based on ValueObject Pattern
 */
public class TransMbayeqpmentDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransMbayeqpmentDto() {
    }
	
          private String feqpid; //设备id
          private String fcimid; //cim模型中的设备id
          private String fdevclass; //设备大类
          private String fdispatchnumber; //设备调度号
          private int fshared; //是否是边界设备
          private String fid; //主键标示
          private int version; //数据库版本控制
          private String trans_zmbayeqpment2; //间隔id
    	 
	
   /**
     * getters and setters
     */
            public void setFeqpid(String feqpid){
        this.feqpid=feqpid;
    }
	   public String getFeqpid(){
      return feqpid;
    }
             public void setFcimid(String fcimid){
        this.fcimid=fcimid;
    }
	   public String getFcimid(){
      return fcimid;
    }
             public void setFdevclass(String fdevclass){
        this.fdevclass=fdevclass;
    }
	   public String getFdevclass(){
      return fdevclass;
    }
             public void setFdispatchnumber(String fdispatchnumber){
        this.fdispatchnumber=fdispatchnumber;
    }
	   public String getFdispatchnumber(){
      return fdispatchnumber;
    }
             public void setFshared(int fshared){
        this.fshared=fshared;
    }
	   public int getFshared(){
      return fshared;
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
             public void setTrans_zmbayeqpment2(String trans_zmbayeqpment2){
        this.trans_zmbayeqpment2=trans_zmbayeqpment2;
    }
	   public String getTrans_zmbayeqpment2(){
      return trans_zmbayeqpment2;
    }
       
  

}