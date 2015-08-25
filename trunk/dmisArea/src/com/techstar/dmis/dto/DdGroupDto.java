package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 班组表
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdGroupDto extends DictionaryBaseDto implements Serializable {
    
	public DdGroupDto() {
    }
	
          private String fgroupname; //班组名称
	      private int roundno; //轮次编号
	      private int version; //数据库版本控制
	      private java.util.Collection fddgroupmember2; //班组编号
		 

  	
	
   /**
     * getters and setters
     */
           public void setFgroupname(String fgroupname){
        this.fgroupname=fgroupname;
    }
	   public String getFgroupname(){
      return fgroupname;
    }
           public void setRoundno(int roundno){
        this.roundno=roundno;
    }
	   public int getRoundno(){
      return roundno;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setFddgroupmember2(java.util.Collection fddgroupmember2){
        this.fddgroupmember2=fddgroupmember2;
    }
	   public java.util.Collection getFddgroupmember2(){
      return fddgroupmember2;
    }
      
  

}