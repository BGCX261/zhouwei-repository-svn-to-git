package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 设备对应参数表
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class EQPParaDescDto  implements Serializable {
    
	public EQPParaDescDto() {
    }
	
          private String fparaid; //参数ID
	      private String ffieldname; //参数字段名
	      private String fparaname; //参数名称
	      private String fischanged; //是否记录变化
	      private String fid; //ID
	      private int version; //数据库版本控制
		 

  	
	
   /**
     * getters and setters
     */
           public void setFparaid(String fparaid){
        this.fparaid=fparaid;
    }
	   public String getFparaid(){
      return fparaid;
    }
           public void setFfieldname(String ffieldname){
        this.ffieldname=ffieldname;
    }
	   public String getFfieldname(){
      return ffieldname;
    }
           public void setFparaname(String fparaname){
        this.fparaname=fparaname;
    }
	   public String getFparaname(){
      return fparaname;
    }
           public void setFischanged(String fischanged){
        this.fischanged=fischanged;
    }
	   public String getFischanged(){
      return fischanged;
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
      
  

}