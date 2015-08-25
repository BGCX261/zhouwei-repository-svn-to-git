package  com.techstar.framework.ui.entity;

import java.io.Serializable;
/**
 * Domain classe for 系统表格
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class SysUiGrid implements Serializable {
    
	public SysUiGrid() {
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