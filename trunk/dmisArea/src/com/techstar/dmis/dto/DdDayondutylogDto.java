package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 调度日志
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdDayondutylogDto  implements Serializable {
    
	public DdDayondutylogDto() {
    }
	
          private byte[] content; //日志内容
	      private java.sql.Date logdate; //日志日期
	      private String sys_fille; //填写人
	      private String sys_filldept; //填写单位
	      private java.sql.Timestamp sys_filltime; //填写时间
	      private int sys_isvalid; //是否有效字段
	      private String sys_dataowner; //数据所属单位
	      private String fondutyid; //日志编号
	      private int version; //数据库版本控制
	      private java.util.Collection fddoperationnotebook5; //日志编号
		 

  	
	
   /**
     * getters and setters
     */
           public void setContent(byte[] content){
        this.content=content;
    }
	   public byte[] getContent(){
      return content;
    }
           public void setLogdate(java.sql.Date logdate){
        this.logdate=logdate;
    }
	   public java.sql.Date getLogdate(){
      return logdate;
    }
           public void setSys_fille(String sys_fille){
        this.sys_fille=sys_fille;
    }
	   public String getSys_fille(){
      return sys_fille;
    }
           public void setSys_filldept(String sys_filldept){
        this.sys_filldept=sys_filldept;
    }
	   public String getSys_filldept(){
      return sys_filldept;
    }
           public void setSys_filltime(java.sql.Timestamp sys_filltime){
        this.sys_filltime=sys_filltime;
    }
	   public java.sql.Timestamp getSys_filltime(){
      return sys_filltime;
    }
           public void setSys_isvalid(int sys_isvalid){
        this.sys_isvalid=sys_isvalid;
    }
	   public int getSys_isvalid(){
      return sys_isvalid;
    }
           public void setSys_dataowner(String sys_dataowner){
        this.sys_dataowner=sys_dataowner;
    }
	   public String getSys_dataowner(){
      return sys_dataowner;
    }
           public void setFondutyid(String fondutyid){
        this.fondutyid=fondutyid;
    }
	   public String getFondutyid(){
      return fondutyid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setFddoperationnotebook5(java.util.Collection fddoperationnotebook5){
        this.fddoperationnotebook5=fddoperationnotebook5;
    }
	   public java.util.Collection getFddoperationnotebook5(){
      return fddoperationnotebook5;
    }
      
  

}