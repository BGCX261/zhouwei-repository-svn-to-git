package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 间隔标准停电范围
 * This classe is based on ValueObject Pattern
 */
public class TransMSTDBayOutageDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransMSTDBayOutageDto() {
    }
	
          private String foutagedescription; //停电范围
          private String fworkplace; //工作地点
          private String fid; //主键标识
          private int version; //数据库版本控制
          private String trans_zmstdbayoutage2; //间隔id
          private String trans_zmstdbayoutage3; //组合id
    	 
	
   /**
     * getters and setters
     */
            public void setFoutagedescription(String foutagedescription){
        this.foutagedescription=foutagedescription;
    }
	   public String getFoutagedescription(){
      return foutagedescription;
    }
             public void setFworkplace(String fworkplace){
        this.fworkplace=fworkplace;
    }
	   public String getFworkplace(){
      return fworkplace;
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
             public void setTrans_zmstdbayoutage2(String trans_zmstdbayoutage2){
        this.trans_zmstdbayoutage2=trans_zmstdbayoutage2;
    }
	   public String getTrans_zmstdbayoutage2(){
      return trans_zmstdbayoutage2;
    }
             public void setTrans_zmstdbayoutage3(String trans_zmstdbayoutage3){
        this.trans_zmstdbayoutage3=trans_zmstdbayoutage3;
    }
	   public String getTrans_zmstdbayoutage3(){
      return trans_zmstdbayoutage3;
    }
       
  

}