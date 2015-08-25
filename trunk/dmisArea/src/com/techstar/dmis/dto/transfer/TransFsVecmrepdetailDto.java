package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 电压合格率汇总表详情
 * This classe is based on ValueObject Pattern
 */
public class TransFsVecmrepdetailDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransFsVecmrepdetailDto() {
    }
	
          private String unitname; //单位
          private int monthrate; //电压合格率值
          private int yearrate; //年度累计值
          private String monthrepdetailid; //报表项目编号
          private int version; //数据库版本控制
          private String trans_zfsvecmrepdetail1; //报表编号
    	 
	
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
             public void setTrans_zfsvecmrepdetail1(String trans_zfsvecmrepdetail1){
        this.trans_zfsvecmrepdetail1=trans_zfsvecmrepdetail1;
    }
	   public String getTrans_zfsvecmrepdetail1(){
      return trans_zfsvecmrepdetail1;
    }
       
  

}