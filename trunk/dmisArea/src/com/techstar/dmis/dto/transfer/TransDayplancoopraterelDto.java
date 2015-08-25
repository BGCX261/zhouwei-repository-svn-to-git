package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 日计划配合工作关系表
 * This classe is based on ValueObject Pattern
 */
public class TransDayplancoopraterelDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDayplancoopraterelDto() {
    }
	
          private String fcooperatename; //配合工作名称
          private java.sql.Date cooperatedate; //配合工作日期
          private String frelid; //关系ID
          private int version; //数据库版本控制
          private String trans_zdayplancoopraterel1; //日计划编号
    	 
	
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
             public void setTrans_zdayplancoopraterel1(String trans_zdayplancoopraterel1){
        this.trans_zdayplancoopraterel1=trans_zdayplancoopraterel1;
    }
	   public String getTrans_zdayplancoopraterel1(){
      return trans_zdayplancoopraterel1;
    }
       
  

}