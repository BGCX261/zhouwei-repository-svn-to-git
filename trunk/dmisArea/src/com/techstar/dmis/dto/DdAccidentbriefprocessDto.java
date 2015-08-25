package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 故障简报处理过程
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdAccidentbriefprocessDto  implements Serializable {
    
	public DdAccidentbriefprocessDto() {
    }
	
          private java.sql.Date fprocesstime; //处理时间
	      private String fhandlecontent; //处理内容
	      private String fhandler; //处理人员
	      private int fhandleno; //处理序号
	      private String fstepid; //编号
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.DdAccidentbriefDto zddaccidentbriefprocess1=new DdAccidentbriefDto(); //故障编号
		 

  	
	
   /**
     * getters and setters
     */
           public void setFprocesstime(java.sql.Date fprocesstime){
        this.fprocesstime=fprocesstime;
    }
	   public java.sql.Date getFprocesstime(){
      return fprocesstime;
    }
           public void setFhandlecontent(String fhandlecontent){
        this.fhandlecontent=fhandlecontent;
    }
	   public String getFhandlecontent(){
      return fhandlecontent;
    }
           public void setFhandler(String fhandler){
        this.fhandler=fhandler;
    }
	   public String getFhandler(){
      return fhandler;
    }
           public void setFhandleno(int fhandleno){
        this.fhandleno=fhandleno;
    }
	   public int getFhandleno(){
      return fhandleno;
    }
           public void setFstepid(String fstepid){
        this.fstepid=fstepid;
    }
	   public String getFstepid(){
      return fstepid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZddaccidentbriefprocess1(com.techstar.dmis.dto.DdAccidentbriefDto zddaccidentbriefprocess1){
        this.zddaccidentbriefprocess1=zddaccidentbriefprocess1;
    }
	   public com.techstar.dmis.dto.DdAccidentbriefDto getZddaccidentbriefprocess1(){
      return zddaccidentbriefprocess1;
    }
      
  

}