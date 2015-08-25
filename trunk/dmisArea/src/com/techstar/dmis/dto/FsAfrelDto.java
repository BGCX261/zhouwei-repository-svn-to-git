package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 发电批准书定值单关系表
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class FsAfrelDto  implements Serializable {
    
	public FsAfrelDto() {
    }
	
          private String fapprovfixrelno; //批准书定值单单关系编号
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.FsApprovebookDto zfsafrel1; //批准书计算机编号
	      private com.techstar.dmis.dto.BhFixedvaluebillDto zfsafrel4; //定值单编号
		 

  	
	
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
           public void setZfsafrel1(com.techstar.dmis.dto.FsApprovebookDto zfsafrel1){
        this.zfsafrel1=zfsafrel1;
    }
	   public com.techstar.dmis.dto.FsApprovebookDto getZfsafrel1(){
      return zfsafrel1;
    }
           public void setZfsafrel4(com.techstar.dmis.dto.BhFixedvaluebillDto zfsafrel4){
        this.zfsafrel4=zfsafrel4;
    }
	   public com.techstar.dmis.dto.BhFixedvaluebillDto getZfsafrel4(){
      return zfsafrel4;
    }
      
  

}