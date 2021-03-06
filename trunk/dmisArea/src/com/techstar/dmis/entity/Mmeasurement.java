package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 量测点
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class Mmeasurement implements Serializable {
    
	public Mmeasurement() {
    }
    		 private String fname;//名称
					 private String fdescription;//描述
					 private String faliasname;//别名
					 private String fmemberof_psr;//所属电力系统资源
					 private String fterminal;//连接端点
					 private String fmeasurementtype;//量测类型
					 private String funit;//量测值单位
					 private String flimitsets;//限值
					 private String fid;//主键标示
					 private int version;//数据库版本控制
				
   /**
     * getters and setters
     */
           public void setFname(String fname){
        this.fname=fname;
    }
	   public String getFname(){
      return fname;
    }
           public void setFdescription(String fdescription){
        this.fdescription=fdescription;
    }
	   public String getFdescription(){
      return fdescription;
    }
           public void setFaliasname(String faliasname){
        this.faliasname=faliasname;
    }
	   public String getFaliasname(){
      return faliasname;
    }
           public void setFmemberof_psr(String fmemberof_psr){
        this.fmemberof_psr=fmemberof_psr;
    }
	   public String getFmemberof_psr(){
      return fmemberof_psr;
    }
           public void setFterminal(String fterminal){
        this.fterminal=fterminal;
    }
	   public String getFterminal(){
      return fterminal;
    }
           public void setFmeasurementtype(String fmeasurementtype){
        this.fmeasurementtype=fmeasurementtype;
    }
	   public String getFmeasurementtype(){
      return fmeasurementtype;
    }
           public void setFunit(String funit){
        this.funit=funit;
    }
	   public String getFunit(){
      return funit;
    }
           public void setFlimitsets(String flimitsets){
        this.flimitsets=flimitsets;
    }
	   public String getFlimitsets(){
      return flimitsets;
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
      
  

}