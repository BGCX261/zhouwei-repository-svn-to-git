package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 设备连接端点
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class MterminalDto  implements Serializable {
    
	public MterminalDto() {
    }
	
          private String fname; //名称
	      private String fdescription; //描述
	      private String faliasname; //别名
	      private String fconductingequipment; //所属导电设备
	      private String fconnectivitynode; //拓扑节点
	      private String fid; //主键标示
	      private int version; //数据库版本控制
		 

  	
	
   /**
     * getters and setters
     */
           public void setFname(String fname){
        this.fname=fname;
    }
	   public String getFname(){
      return fname;
    }
           public void setFdescription(String fdescription){
        this.fdescription=fdescription;
    }
	   public String getFdescription(){
      return fdescription;
    }
           public void setFaliasname(String faliasname){
        this.faliasname=faliasname;
    }
	   public String getFaliasname(){
      return faliasname;
    }
           public void setFconductingequipment(String fconductingequipment){
        this.fconductingequipment=fconductingequipment;
    }
	   public String getFconductingequipment(){
      return fconductingequipment;
    }
           public void setFconnectivitynode(String fconnectivitynode){
        this.fconnectivitynode=fconnectivitynode;
    }
	   public String getFconnectivitynode(){
      return fconnectivitynode;
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