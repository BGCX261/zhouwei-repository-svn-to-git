package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 故障责任
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class StdBhtresponseDto extends DictionaryBaseDto implements Serializable {
    
	public StdBhtresponseDto() {
    }
	
          private String faultreponsibility1; //故障责任１
	      private String faultreponsibility2; //故障责任2
	      private String faultresponsedept; //故障责任单位
	      private int version; //数据库版本控制
	      private java.util.Collection fbhactionrecord3; //故障责任编号
		 

  	
	
   /**
     * getters and setters
     */
           public void setFaultreponsibility1(String faultreponsibility1){
        this.faultreponsibility1=faultreponsibility1;
    }
	   public String getFaultreponsibility1(){
      return faultreponsibility1;
    }
           public void setFaultreponsibility2(String faultreponsibility2){
        this.faultreponsibility2=faultreponsibility2;
    }
	   public String getFaultreponsibility2(){
      return faultreponsibility2;
    }
           public void setFaultresponsedept(String faultresponsedept){
        this.faultresponsedept=faultresponsedept;
    }
	   public String getFaultresponsedept(){
      return faultresponsedept;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setFbhactionrecord3(java.util.Collection fbhactionrecord3){
        this.fbhactionrecord3=fbhactionrecord3;
    }
	   public java.util.Collection getFbhactionrecord3(){
      return fbhactionrecord3;
    }
      
  

}