package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 存储设备
 * This classe is based on ValueObject Pattern
 */
public class TransParaStoreEQPDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransParaStoreEQPDto() {
    }
	
          private int fharddiskcapa; //硬盘容量/单块(G)
          private int fharddiskcount; //数量
          private String fother; //其他
          private String feqpid; //设备ID
          private int version; //数据库版本控制
          private String trans_zparastoreeqp2; //设备ID
    	 
	
   /**
     * getters and setters
     */
            public void setFharddiskcapa(int fharddiskcapa){
        this.fharddiskcapa=fharddiskcapa;
    }
	   public int getFharddiskcapa(){
      return fharddiskcapa;
    }
             public void setFharddiskcount(int fharddiskcount){
        this.fharddiskcount=fharddiskcount;
    }
	   public int getFharddiskcount(){
      return fharddiskcount;
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
             public void setTrans_zparastoreeqp2(String trans_zparastoreeqp2){
        this.trans_zparastoreeqp2=trans_zparastoreeqp2;
    }
	   public String getTrans_zparastoreeqp2(){
      return trans_zparastoreeqp2;
    }
       
  

}