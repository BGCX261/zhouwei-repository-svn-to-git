package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 电压合格率汇总表详情
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class FsVecmrepdetail implements Serializable {
    
	public FsVecmrepdetail() {
    }
    		 private String unitname;//单位
					 private int monthrate;//电压合格率值
					 private int yearrate;//年度累计值
					 private String monthrepdetailid;//报表项目编号
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.FsVecollectmonrep zfsvecmrepdetail1;
	    		
   /**
     * getters and setters
     */
           public void setUnitname(String unitname){
        this.unitname=unitname;
    }
	   public String getUnitname(){
      return unitname;
    }
           public void setMonthrate(int monthrate){
        this.monthrate=monthrate;
    }
	   public int getMonthrate(){
      return monthrate;
    }
           public void setYearrate(int yearrate){
        this.yearrate=yearrate;
    }
	   public int getYearrate(){
      return yearrate;
    }
           public void setMonthrepdetailid(String monthrepdetailid){
        this.monthrepdetailid=monthrepdetailid;
    }
	   public String getMonthrepdetailid(){
      return monthrepdetailid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZfsvecmrepdetail1(com.techstar.dmis.entity.FsVecollectmonrep zfsvecmrepdetail1){
        this.zfsvecmrepdetail1=zfsvecmrepdetail1;
    }
	   public com.techstar.dmis.entity.FsVecollectmonrep getZfsvecmrepdetail1(){
      return zfsvecmrepdetail1;
    }
      
  

}