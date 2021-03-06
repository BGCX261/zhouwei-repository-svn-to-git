package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 组织机构
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class StdUnitDto extends DictionaryBaseDto implements Serializable {
    
	public StdUnitDto() {
    }
	
          private String unitname; //单位名称
	      private String unitshortname; //单位简称
	      private String fatherno; //上级单位编号
	      private int displayno; //显示序号
	      private int version; //数据库版本控制
	      private java.util.Collection fetsequipment5; //单位编号
	      private java.util.Collection fetsequipment6; //单位编号
		 

  	
	
   /**
     * getters and setters
     */
           public void setUnitname(String unitname){
        this.unitname=unitname;
    }
	   public String getUnitname(){
      return unitname;
    }
           public void setUnitshortname(String unitshortname){
        this.unitshortname=unitshortname;
    }
	   public String getUnitshortname(){
      return unitshortname;
    }
           public void setFatherno(String fatherno){
        this.fatherno=fatherno;
    }
	   public String getFatherno(){
      return fatherno;
    }
           public void setDisplayno(int displayno){
        this.displayno=displayno;
    }
	   public int getDisplayno(){
      return displayno;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setFetsequipment5(java.util.Collection fetsequipment5){
        this.fetsequipment5=fetsequipment5;
    }
	   public java.util.Collection getFetsequipment5(){
      return fetsequipment5;
    }
           public void setFetsequipment6(java.util.Collection fetsequipment6){
        this.fetsequipment6=fetsequipment6;
    }
	   public java.util.Collection getFetsequipment6(){
      return fetsequipment6;
    }
      
  

}