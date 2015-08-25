package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 调度员值班表
 * This classe is based on ValueObject Pattern
 */
public class TransDdGroupmemberDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDdGroupmemberDto() {
    }
	
          private String id; //ID
          private int version; //数据库版本控制
          private String trans_zddgroupmember2; //班组ID
          private String trans_zddgroupmember4; //人员ID
    	 
	
   /**
     * getters and setters
     */
            public void setId(String id){
        this.id=id;
    }
	   public String getId(){
      return id;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setTrans_zddgroupmember2(String trans_zddgroupmember2){
        this.trans_zddgroupmember2=trans_zddgroupmember2;
    }
	   public String getTrans_zddgroupmember2(){
      return trans_zddgroupmember2;
    }
             public void setTrans_zddgroupmember4(String trans_zddgroupmember4){
        this.trans_zddgroupmember4=trans_zddgroupmember4;
    }
	   public String getTrans_zddgroupmember4(){
      return trans_zddgroupmember4;
    }
       
  

}