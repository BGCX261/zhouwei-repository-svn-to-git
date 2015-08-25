package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 日计划相关方式变更表
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdDayplanchangelistDto  implements Serializable {
    
	public DdDayplanchangelistDto() {
    }
	
          private String fstationname; //变电站
	      private String fchangecnt; //变更内容
	      private String fstationid; //变电站ID
	      private String sys_fille; //填写人
	      private String sys_filldept; //填写单位
	      private java.sql.Date sys_filltime; //填写时间
	      private String fid; //序号
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.DdDoutageplanDto dddoutageplan0= new com.techstar.dmis.dto.DdDoutageplanDto(); //计划编号
		 

  	
	
   /**
     * getters and setters
     */
           public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
           public void setFchangecnt(String fchangecnt){
        this.fchangecnt=fchangecnt;
    }
	   public String getFchangecnt(){
      return fchangecnt;
    }
           public void setFstationid(String fstationid){
        this.fstationid=fstationid;
    }
	   public String getFstationid(){
      return fstationid;
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
           public void setSys_filltime(java.sql.Date sys_filltime){
        this.sys_filltime=sys_filltime;
    }
	   public java.sql.Date getSys_filltime(){
      return sys_filltime;
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
           public void setDddoutageplan0(com.techstar.dmis.dto.DdDoutageplanDto dddoutageplan0){
        this.dddoutageplan0=dddoutageplan0;
    }
	   public com.techstar.dmis.dto.DdDoutageplanDto getDddoutageplan0(){
      return dddoutageplan0;
    }
      
  

}