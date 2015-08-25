package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for RTU
 * This classe is based on ValueObject Pattern
 */
public class TransParaRTUDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransParaRTUDto() {
    }
	
          private String fisasampling; //遥测量是否为交流采样
          private int finputpara; //输入参数
          private String fisdirectgather; //是否总调直采
          private java.sql.Date fdrivedate; //传动日期
          private String fsampingstyle; //采样方式
          private String feqpid; //设备ID
          private int version; //数据库版本控制
          private String trans_zparartu3; //设备ID
    	 
	
   /**
     * getters and setters
     */
            public void setFisasampling(String fisasampling){
        this.fisasampling=fisasampling;
    }
	   public String getFisasampling(){
      return fisasampling;
    }
             public void setFinputpara(int finputpara){
        this.finputpara=finputpara;
    }
	   public int getFinputpara(){
      return finputpara;
    }
             public void setFisdirectgather(String fisdirectgather){
        this.fisdirectgather=fisdirectgather;
    }
	   public String getFisdirectgather(){
      return fisdirectgather;
    }
             public void setFdrivedate(java.sql.Date fdrivedate){
        this.fdrivedate=fdrivedate;
    }
	   public java.sql.Date getFdrivedate(){
      return fdrivedate;
    }
             public void setFsampingstyle(String fsampingstyle){
        this.fsampingstyle=fsampingstyle;
    }
	   public String getFsampingstyle(){
      return fsampingstyle;
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
             public void setTrans_zparartu3(String trans_zparartu3){
        this.trans_zparartu3=trans_zparartu3;
    }
	   public String getTrans_zparartu3(){
      return trans_zparartu3;
    }
       
  

}