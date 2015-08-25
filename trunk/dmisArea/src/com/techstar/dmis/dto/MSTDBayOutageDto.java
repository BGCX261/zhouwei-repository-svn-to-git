package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 间隔标准停电范围
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class MSTDBayOutageDto  implements Serializable {
    
	public MSTDBayOutageDto() {
    }
	
          private String foutagedescription; //停电范围
	      private String fworkplace; //工作地点
	      private String fid; //主键标识
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.MbayDto zmstdbayoutage2; //间隔id
	      private com.techstar.dmis.dto.MBayGroupDto zmstdbayoutage3; //组合id
		 

  	
	
   /**
     * getters and setters
     */
           public void setFoutagedescription(String foutagedescription){
        this.foutagedescription=foutagedescription;
    }
	   public String getFoutagedescription(){
      return foutagedescription;
    }
           public void setFworkplace(String fworkplace){
        this.fworkplace=fworkplace;
    }
	   public String getFworkplace(){
      return fworkplace;
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
           public void setZmstdbayoutage2(com.techstar.dmis.dto.MbayDto zmstdbayoutage2){
        this.zmstdbayoutage2=zmstdbayoutage2;
    }
	   public com.techstar.dmis.dto.MbayDto getZmstdbayoutage2(){
      return zmstdbayoutage2;
    }
           public void setZmstdbayoutage3(com.techstar.dmis.dto.MBayGroupDto zmstdbayoutage3){
        this.zmstdbayoutage3=zmstdbayoutage3;
    }
	   public com.techstar.dmis.dto.MBayGroupDto getZmstdbayoutage3(){
      return zmstdbayoutage3;
    }
      
  

}