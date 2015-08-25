package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 自动化缺陷分类2
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class StdZdhfaulttypeDto extends DictionaryBaseDto implements Serializable {
    
	public StdZdhfaulttypeDto() {
    }
	
          private String stdparentid; //父ID
	      private String ffaulttype2; //自动化缺陷分类2
	      private int version; //数据库版本控制
	      private java.util.Collection fzdhfaultlist10; //缺陷类型ID
		 

  	
	
   /**
     * getters and setters
     */
           public void setStdparentid(String stdparentid){
        this.stdparentid=stdparentid;
    }
	   public String getStdparentid(){
      return stdparentid;
    }
           public void setFfaulttype2(String ffaulttype2){
        this.ffaulttype2=ffaulttype2;
    }
	   public String getFfaulttype2(){
      return ffaulttype2;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setFzdhfaultlist10(java.util.Collection fzdhfaultlist10){
        this.fzdhfaultlist10=fzdhfaultlist10;
    }
	   public java.util.Collection getFzdhfaultlist10(){
      return fzdhfaultlist10;
    }
      
  

}