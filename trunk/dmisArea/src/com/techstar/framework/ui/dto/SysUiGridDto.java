package  com.techstar.framework.ui.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 系统表格
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class SysUiGridDto  implements Serializable {
    
	public SysUiGridDto() {
    }
	
	public String toString(){
	    StringBuffer sb = new StringBuffer();
 sb.append("[ATTR_CNNAEM:用户ID&ATTR_ENNAME:user_id&ATTR_TYPE:string&ATTR_LENGTH:42&ATTR_VALUE:"+this.getUser_id()+"]");
 sb.append("$%$[ATTR_CNNAEM:业务名称&ATTR_ENNAME:bus_name&ATTR_TYPE:string&ATTR_LENGTH:60&ATTR_VALUE:"+this.getBus_name()+"]");
 sb.append("$%$[ATTR_CNNAEM:子业务名称&ATTR_ENNAME:sub_name&ATTR_TYPE:string&ATTR_LENGTH:60&ATTR_VALUE:"+this.getSub_name()+"]");
 sb.append("$%$[ATTR_CNNAEM:备注&ATTR_ENNAME:note&ATTR_TYPE:string&ATTR_LENGTH:200&ATTR_VALUE:"+this.getNote()+"]");
 sb.append("$%$[ATTR_CNNAEM:编号&ATTR_ENNAME:id&ATTR_TYPE:string&ATTR_LENGTH:50&ATTR_VALUE:"+this.getId()+"]");
 sb.append("$%$[ATTR_CNNAEM:数据库版本控制&ATTR_ENNAME:version&ATTR_TYPE:integer&ATTR_LENGTH:50&ATTR_VALUE:"+this.getVersion()+"]");
return sb.toString();
	}

	
          private String user_id;
	      private String bus_name;
	      private String sub_name;
	      private byte[] advance_query;
	      private byte[] custom_xml;
	      private String note;
	      private String id;
	      private int version;
		
  	
	
   /**
     * getters and setters
     */
           public void setUser_id(String user_id){
        this.user_id=user_id;
    }
	   public String getUser_id(){
      return user_id;
    }
           public void setBus_name(String bus_name){
        this.bus_name=bus_name;
    }
	   public String getBus_name(){
      return bus_name;
    }
           public void setSub_name(String sub_name){
        this.sub_name=sub_name;
    }
	   public String getSub_name(){
      return sub_name;
    }
           public void setAdvance_query(byte[] advance_query){
        this.advance_query=advance_query;
    }
	   public byte[] getAdvance_query(){
      return advance_query;
    }
           public void setCustom_xml(byte[] custom_xml){
        this.custom_xml=custom_xml;
    }
	   public byte[] getCustom_xml(){
      return custom_xml;
    }
           public void setNote(String note){
        this.note=note;
    }
	   public String getNote(){
      return note;
    }
           public void setId(String id){
        this.id=id;
    }
	   public String getId(){
      return id;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
      
  

}