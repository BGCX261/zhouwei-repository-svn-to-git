package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 日计划配合工作关系表
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DayplancoopraterelDto  implements Serializable {
    
	public DayplancoopraterelDto() {
    }
	
          private String fcooperatename; //配合工作名称
	      private java.sql.Date cooperatedate; //配合工作日期
	      private String frelid; //关系ID
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.DdDoutageplanDto zdayplancoopraterel1; //日计划编号
		 

  	
	
   /**
     * getters and setters
     */
           public void setFcooperatename(String fcooperatename){
        this.fcooperatename=fcooperatename;
    }
	   public String getFcooperatename(){
      return fcooperatename;
    }
           public void setCooperatedate(java.sql.Date cooperatedate){
        this.cooperatedate=cooperatedate;
    }
	   public java.sql.Date getCooperatedate(){
      return cooperatedate;
    }
           public void setFrelid(String frelid){
        this.frelid=frelid;
    }
	   public String getFrelid(){
      return frelid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZdayplancoopraterel1(com.techstar.dmis.dto.DdDoutageplanDto zdayplancoopraterel1){
        this.zdayplancoopraterel1=zdayplancoopraterel1;
    }
	   public com.techstar.dmis.dto.DdDoutageplanDto getZdayplancoopraterel1(){
      return zdayplancoopraterel1;
    }
      
  

}