package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 绯荤粺瀛楀吀绫诲瀷瀹炰綋
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class SystemdicTypeDto  implements Serializable {
    
	public SystemdicTypeDto() {
    }
	
          private String typename; //绫诲瀷鍚嶇О
	      private String memo; //涓枃鎻忚堪
	      private String typeid; //涓婚敭
	      private int version; //数据库版本控制
	      private java.util.Collection systemdic; //${attrs.cnName}
		 

  	
	
   /**
     * getters and setters
     */
           public void setTypename(String typename){
        this.typename=typename;
    }
	   public String getTypename(){
      return typename;
    }
           public void setMemo(String memo){
        this.memo=memo;
    }
	   public String getMemo(){
      return memo;
    }
           public void setTypeid(String typeid){
        this.typeid=typeid;
    }
	   public String getTypeid(){
      return typeid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setSystemdic(java.util.Collection systemdic){
        this.systemdic=systemdic;
    }
	   public java.util.Collection getSystemdic(){
      return systemdic;
    }
      
  

}