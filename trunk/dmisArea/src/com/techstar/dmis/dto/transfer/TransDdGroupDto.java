package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 班组表
 * This classe is based on ValueObject Pattern
 */
public class TransDdGroupDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDdGroupDto() {
    }
	
          private String fgroupname; //班组名称
          private int roundno; //轮次编号
          private String id; //班组编号
          private int version; //数据库版本控制
          private java.util.Collection fddgroupmember2; //班组编号
    	 
	
   /**
     * getters and setters
     */
            public void setFgroupname(String fgroupname){
        this.fgroupname=fgroupname;
    }
	   public String getFgroupname(){
      return fgroupname;
    }
             public void setRoundno(int roundno){
        this.roundno=roundno;
    }
	   public int getRoundno(){
      return roundno;
    }
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
             public void setFddgroupmember2(java.util.Collection fddgroupmember2){
        this.fddgroupmember2=fddgroupmember2;
    }
	   public java.util.Collection getFddgroupmember2(){
      return fddgroupmember2;
    }
       
  

}