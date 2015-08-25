package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 故障简报处理过程
 * This classe is based on ValueObject Pattern
 */
public class TransDdAccidentbriefprocessDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDdAccidentbriefprocessDto() {
    }
	
          private java.sql.Date fprocesstime; //处理时间
          private String fhandlecontent; //处理内容
          private String fhandler; //处理人员
          private int fhandleno; //处理序号
          private String fstepid; //编号
          private int version; //数据库版本控制
          private String trans_zddaccidentbriefprocess1; //故障编号
    	 
	
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
             public void setTrans_zddaccidentbriefprocess1(String trans_zddaccidentbriefprocess1){
        this.trans_zddaccidentbriefprocess1=trans_zddaccidentbriefprocess1;
    }
	   public String getTrans_zddaccidentbriefprocess1(){
      return trans_zddaccidentbriefprocess1;
    }
       
  

}