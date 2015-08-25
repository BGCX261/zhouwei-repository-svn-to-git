package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 保护一次设备故障分类
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class StdBheqpfaultDto extends DictionaryBaseDto implements Serializable {
    
	public StdBheqpfaultDto() {
    }
	
          private String feqpid; //设备ID
	      private String accidenttype1; //故障分类１
	      private String accidenttype2; //统计分类
	      private String feqpname; //故障设备名称
	      private int version; //数据库版本控制
	      private java.util.Collection fbhactionrecord6; //分类编号
		 

  	
	
   /**
     * getters and setters
     */
           public void setFeqpid(String feqpid){
        this.feqpid=feqpid;
    }
	   public String getFeqpid(){
      return feqpid;
    }
           public void setAccidenttype1(String accidenttype1){
        this.accidenttype1=accidenttype1;
    }
	   public String getAccidenttype1(){
      return accidenttype1;
    }
           public void setAccidenttype2(String accidenttype2){
        this.accidenttype2=accidenttype2;
    }
	   public String getAccidenttype2(){
      return accidenttype2;
    }
           public void setFeqpname(String feqpname){
        this.feqpname=feqpname;
    }
	   public String getFeqpname(){
      return feqpname;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setFbhactionrecord6(java.util.Collection fbhactionrecord6){
        this.fbhactionrecord6=fbhactionrecord6;
    }
	   public java.util.Collection getFbhactionrecord6(){
      return fbhactionrecord6;
    }
      
  

}