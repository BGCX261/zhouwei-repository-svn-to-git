package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 报表树分类和报表数据关系
 * This classe is based on ValueObject Pattern
 */
public class TransRepTree2resultDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransRepTree2resultDto() {
    }
	
          private String f_relationid; //关系ID
          private int version; //数据库版本控制
          private String trans_zreptree2result1; //报表分类ID
          private String trans_zreptree2result2; //报表结果ID
    	 
	
   /**
     * getters and setters
     */
            public void setF_relationid(String f_relationid){
        this.f_relationid=f_relationid;
    }
	   public String getF_relationid(){
      return f_relationid;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setTrans_zreptree2result1(String trans_zreptree2result1){
        this.trans_zreptree2result1=trans_zreptree2result1;
    }
	   public String getTrans_zreptree2result1(){
      return trans_zreptree2result1;
    }
             public void setTrans_zreptree2result2(String trans_zreptree2result2){
        this.trans_zreptree2result2=trans_zreptree2result2;
    }
	   public String getTrans_zreptree2result2(){
      return trans_zreptree2result2;
    }
       
  

}