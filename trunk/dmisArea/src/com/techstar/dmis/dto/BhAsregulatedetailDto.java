package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 自投规程明细
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class BhAsregulatedetailDto  implements Serializable {
    
	public BhAsregulatedetailDto() {
    }
	
          private int fvoltage; //电压等级
	      private String modename; //方式名称
	      private String content; //内容
	      private String modetype; //方式分类
	      private String asregulatedetailid; //自投规程项目编号
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.BhAsregulateDto zbhasregulatedetail3; //自投规程编号
		 

  	
	
   /**
     * getters and setters
     */
           public void setFvoltage(int fvoltage){
        this.fvoltage=fvoltage;
    }
	   public int getFvoltage(){
      return fvoltage;
    }
           public void setModename(String modename){
        this.modename=modename;
    }
	   public String getModename(){
      return modename;
    }
           public void setContent(String content){
        this.content=content;
    }
	   public String getContent(){
      return content;
    }
           public void setModetype(String modetype){
        this.modetype=modetype;
    }
	   public String getModetype(){
      return modetype;
    }
           public void setAsregulatedetailid(String asregulatedetailid){
        this.asregulatedetailid=asregulatedetailid;
    }
	   public String getAsregulatedetailid(){
      return asregulatedetailid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZbhasregulatedetail3(com.techstar.dmis.dto.BhAsregulateDto zbhasregulatedetail3){
        this.zbhasregulatedetail3=zbhasregulatedetail3;
    }
	   public com.techstar.dmis.dto.BhAsregulateDto getZbhasregulatedetail3(){
      return zbhasregulatedetail3;
    }
      
  

}