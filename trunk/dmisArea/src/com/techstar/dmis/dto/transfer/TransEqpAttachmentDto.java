package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 设备附件
 * This classe is based on ValueObject Pattern
 */
public class TransEqpAttachmentDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransEqpAttachmentDto() {
    }
	
          private String fattachname; //附件名称
          private String fattachtype; //附件类型
          private String fattachremark; //附件说明
              private String fid; //主键标示
          private int version; //数据库版本控制
          private String trans_zeqpattachment2; //设备ID
    	 
	
   /**
     * getters and setters
     */
            public void setFattachname(String fattachname){
        this.fattachname=fattachname;
    }
	   public String getFattachname(){
      return fattachname;
    }
             public void setFattachtype(String fattachtype){
        this.fattachtype=fattachtype;
    }
	   public String getFattachtype(){
      return fattachtype;
    }
             public void setFattachremark(String fattachremark){
        this.fattachremark=fattachremark;
    }
	   public String getFattachremark(){
      return fattachremark;
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
             public void setTrans_zeqpattachment2(String trans_zeqpattachment2){
        this.trans_zeqpattachment2=trans_zeqpattachment2;
    }
	   public String getTrans_zeqpattachment2(){
      return trans_zeqpattachment2;
    }
       
  

}