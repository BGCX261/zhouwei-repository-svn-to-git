package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 存储设备
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaStoreEQPDto  implements Serializable {
    
	public ParaStoreEQPDto() {
    }
	
          private int fharddiskcapa; //硬盘容量/单块(G)
	      private int fharddiskcount; //数量
	      private String fother; //其他
	      private String feqpid; //设备ID
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.EtsEquipmentDto zparastoreeqp2; //设备ID
		 

  	
	
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
           public void setZparastoreeqp2(com.techstar.dmis.dto.EtsEquipmentDto zparastoreeqp2){
        this.zparastoreeqp2=zparastoreeqp2;
    }
	   public com.techstar.dmis.dto.EtsEquipmentDto getZparastoreeqp2(){
      return zparastoreeqp2;
    }
      
  

}