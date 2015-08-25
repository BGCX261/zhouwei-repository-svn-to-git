package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 发电批准书定值单关系表
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class FsAfrel implements Serializable {
    
	public FsAfrel() {
    }
    		 private String fapprovfixrelno;//批准书定值单单关系编号
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.FsApprovebook zfsafrel1;
	    			 private com.techstar.dmis.entity.BhFixedvaluebill zfsafrel4;
	    		
   /**
     * getters and setters
     */
           public void setFapprovfixrelno(String fapprovfixrelno){
        this.fapprovfixrelno=fapprovfixrelno;
    }
	   public String getFapprovfixrelno(){
      return fapprovfixrelno;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZfsafrel1(com.techstar.dmis.entity.FsApprovebook zfsafrel1){
        this.zfsafrel1=zfsafrel1;
    }
	   public com.techstar.dmis.entity.FsApprovebook getZfsafrel1(){
      return zfsafrel1;
    }
           public void setZfsafrel4(com.techstar.dmis.entity.BhFixedvaluebill zfsafrel4){
        this.zfsafrel4=zfsafrel4;
    }
	   public com.techstar.dmis.entity.BhFixedvaluebill getZfsafrel4(){
      return zfsafrel4;
    }
      
  

}