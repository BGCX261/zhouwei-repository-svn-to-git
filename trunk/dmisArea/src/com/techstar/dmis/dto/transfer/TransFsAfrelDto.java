package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 发电批准书定值单关系表
 * This classe is based on ValueObject Pattern
 */
public class TransFsAfrelDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransFsAfrelDto() {
    }
	
          private String fapprovfixrelno; //批准书定值单单关系编号
          private int version; //数据库版本控制
          private String trans_zfsafrel1; //批准书计算机编号
          private String trans_zfsafrel4; //定值单编号
    	 
	
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
             public void setTrans_zfsafrel1(String trans_zfsafrel1){
        this.trans_zfsafrel1=trans_zfsafrel1;
    }
	   public String getTrans_zfsafrel1(){
      return trans_zfsafrel1;
    }
             public void setTrans_zfsafrel4(String trans_zfsafrel4){
        this.trans_zfsafrel4=trans_zfsafrel4;
    }
	   public String getTrans_zfsafrel4(){
      return trans_zfsafrel4;
    }
       
  

}