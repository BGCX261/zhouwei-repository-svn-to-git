package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 变压器绕组
 * This classe is based on ValueObject Pattern
 */
public class TransMtransformerwindingDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransMtransformerwindingDto() {
    }
	
          private String fname; //名称
          private String fdescription; //描述
          private String faliasname; //别名
          private String fmemberof_powertransformer; //所属变压器
          private String fterminals; //连接端点
          private String fgrounded; //是否接地
          private int fr; //R
          private int fratedkv; //额定电压
          private int fratedmva; //额定负荷
          private String fwindingtype; //绕组类型
          private int fx; //X
          private String fmemberof_equipmentcontainer; //所属设备对象
          private String ftapchangers; //分接开关
          private String fid; //主键标示
          private int version; //数据库版本控制
    	 
	
   /**
     * getters and setters
     */
            public void setFname(String fname){
        this.fname=fname;
    }
	   public String getFname(){
      return fname;
    }
             public void setFdescription(String fdescription){
        this.fdescription=fdescription;
    }
	   public String getFdescription(){
      return fdescription;
    }
             public void setFaliasname(String faliasname){
        this.faliasname=faliasname;
    }
	   public String getFaliasname(){
      return faliasname;
    }
             public void setFmemberof_powertransformer(String fmemberof_powertransformer){
        this.fmemberof_powertransformer=fmemberof_powertransformer;
    }
	   public String getFmemberof_powertransformer(){
      return fmemberof_powertransformer;
    }
             public void setFterminals(String fterminals){
        this.fterminals=fterminals;
    }
	   public String getFterminals(){
      return fterminals;
    }
             public void setFgrounded(String fgrounded){
        this.fgrounded=fgrounded;
    }
	   public String getFgrounded(){
      return fgrounded;
    }
             public void setFr(int fr){
        this.fr=fr;
    }
	   public int getFr(){
      return fr;
    }
             public void setFratedkv(int fratedkv){
        this.fratedkv=fratedkv;
    }
	   public int getFratedkv(){
      return fratedkv;
    }
             public void setFratedmva(int fratedmva){
        this.fratedmva=fratedmva;
    }
	   public int getFratedmva(){
      return fratedmva;
    }
             public void setFwindingtype(String fwindingtype){
        this.fwindingtype=fwindingtype;
    }
	   public String getFwindingtype(){
      return fwindingtype;
    }
             public void setFx(int fx){
        this.fx=fx;
    }
	   public int getFx(){
      return fx;
    }
             public void setFmemberof_equipmentcontainer(String fmemberof_equipmentcontainer){
        this.fmemberof_equipmentcontainer=fmemberof_equipmentcontainer;
    }
	   public String getFmemberof_equipmentcontainer(){
      return fmemberof_equipmentcontainer;
    }
             public void setFtapchangers(String ftapchangers){
        this.ftapchangers=ftapchangers;
    }
	   public String getFtapchangers(){
      return ftapchangers;
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
       
  

}