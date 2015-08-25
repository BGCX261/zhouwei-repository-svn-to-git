package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 保护辅助设备台帐
 * This classe is based on ValueObject Pattern
 */
public class TransParaAuxProtectDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransParaAuxProtectDto() {
    }
	
          private String ffaultrecorderno; //设备录波器编号(调度命名)
          private String fanalog; //模拟量
          private String fswitch; //开关量
          private String fisinuse; //是否运行
          private String fmaterialcodify; //设备物资编码
          private String fremark; //备注
          private String feqpid; //设备ID
          private int version; //数据库版本控制
          private String trans_zparaauxprotect2; //设备ID
    	 
	
   /**
     * getters and setters
     */
            public void setFfaultrecorderno(String ffaultrecorderno){
        this.ffaultrecorderno=ffaultrecorderno;
    }
	   public String getFfaultrecorderno(){
      return ffaultrecorderno;
    }
             public void setFanalog(String fanalog){
        this.fanalog=fanalog;
    }
	   public String getFanalog(){
      return fanalog;
    }
             public void setFswitch(String fswitch){
        this.fswitch=fswitch;
    }
	   public String getFswitch(){
      return fswitch;
    }
             public void setFisinuse(String fisinuse){
        this.fisinuse=fisinuse;
    }
	   public String getFisinuse(){
      return fisinuse;
    }
             public void setFmaterialcodify(String fmaterialcodify){
        this.fmaterialcodify=fmaterialcodify;
    }
	   public String getFmaterialcodify(){
      return fmaterialcodify;
    }
             public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
    }
             public void setFeqpid(String feqpid){
        this.feqpid=feqpid;
    }
	   public String getFeqpid(){
      return feqpid;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setTrans_zparaauxprotect2(String trans_zparaauxprotect2){
        this.trans_zparaauxprotect2=trans_zparaauxprotect2;
    }
	   public String getTrans_zparaauxprotect2(){
      return trans_zparaauxprotect2;
    }
       
  

}