package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 定值单明细
 * This classe is based on ValueObject Pattern
 */
public class TransBhFixedvaluebilldetailDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransBhFixedvaluebilldetailDto() {
    }
	
          private String platename; //版块
          private String paraname; //名称
          private String oldvalue; //原整定值
          private String newvalue; //现整定值
          private String serialno; //定值单明细编号
          private int version; //数据库版本控制
          private String trans_zbhfixedvaluebilldetail1; //定值单号
    	 
	
   /**
     * getters and setters
     */
            public void setPlatename(String platename){
        this.platename=platename;
    }
	   public String getPlatename(){
      return platename;
    }
             public void setParaname(String paraname){
        this.paraname=paraname;
    }
	   public String getParaname(){
      return paraname;
    }
             public void setOldvalue(String oldvalue){
        this.oldvalue=oldvalue;
    }
	   public String getOldvalue(){
      return oldvalue;
    }
             public void setNewvalue(String newvalue){
        this.newvalue=newvalue;
    }
	   public String getNewvalue(){
      return newvalue;
    }
             public void setSerialno(String serialno){
        this.serialno=serialno;
    }
	   public String getSerialno(){
      return serialno;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setTrans_zbhfixedvaluebilldetail1(String trans_zbhfixedvaluebilldetail1){
        this.trans_zbhfixedvaluebilldetail1=trans_zbhfixedvaluebilldetail1;
    }
	   public String getTrans_zbhfixedvaluebilldetail1(){
      return trans_zbhfixedvaluebilldetail1;
    }
       
  

}