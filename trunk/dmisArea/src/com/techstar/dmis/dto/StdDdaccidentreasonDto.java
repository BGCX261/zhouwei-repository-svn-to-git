package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 调度故障原因
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class StdDdaccidentreasonDto extends DictionaryBaseDto implements Serializable {
    
	public StdDdaccidentreasonDto() {
    }
	
          private String accidenteqpid; //故障设备名称id
	      private String accidentreason; //故障原因
	      private int version; //数据库版本控制
	      private java.util.Collection fddaccidentbrief1; //故障原因编号
		 

  	
	
   /**
     * getters and setters
     */
           public void setAccidenteqpid(String accidenteqpid){
        this.accidenteqpid=accidenteqpid;
    }
	   public String getAccidenteqpid(){
      return accidenteqpid;
    }
           public void setAccidentreason(String accidentreason){
        this.accidentreason=accidentreason;
    }
	   public String getAccidentreason(){
      return accidentreason;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setFddaccidentbrief1(java.util.Collection fddaccidentbrief1){
        this.fddaccidentbrief1=fddaccidentbrief1;
    }
	   public java.util.Collection getFddaccidentbrief1(){
      return fddaccidentbrief1;
    }
      
  

}