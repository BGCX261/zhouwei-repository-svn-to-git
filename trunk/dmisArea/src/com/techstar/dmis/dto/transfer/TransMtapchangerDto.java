package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 变压器分节头
 * This classe is based on ValueObject Pattern
 */
public class TransMtapchangerDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransMtapchangerDto() {
    }
	
          private String fname; //名称
          private String fdescription; //描述
          private String faliasname; //别名
          private String ftransformerwinding; //所属绕组
          private int fhighstep; //FHIGHSTEP
          private int flowstep; //FLOWSTEP
          private int fneutralkv; //FNEUTRALKV
          private int fneutralstep; //FNEUTRALSTEP
          private int fnormalstep; //FNORMALSTEP
          private int fstepphaseshiftincrement; //FSTEPPHASESHIFTINCREMENT
          private int fstepvoltageincrement; //FSTEPVOLTAGEINCREMENT
          private String ftculcontrolmode; //FTCULCONTROLMODE
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
             public void setFtransformerwinding(String ftransformerwinding){
        this.ftransformerwinding=ftransformerwinding;
    }
	   public String getFtransformerwinding(){
      return ftransformerwinding;
    }
             public void setFhighstep(int fhighstep){
        this.fhighstep=fhighstep;
    }
	   public int getFhighstep(){
      return fhighstep;
    }
             public void setFlowstep(int flowstep){
        this.flowstep=flowstep;
    }
	   public int getFlowstep(){
      return flowstep;
    }
             public void setFneutralkv(int fneutralkv){
        this.fneutralkv=fneutralkv;
    }
	   public int getFneutralkv(){
      return fneutralkv;
    }
             public void setFneutralstep(int fneutralstep){
        this.fneutralstep=fneutralstep;
    }
	   public int getFneutralstep(){
      return fneutralstep;
    }
             public void setFnormalstep(int fnormalstep){
        this.fnormalstep=fnormalstep;
    }
	   public int getFnormalstep(){
      return fnormalstep;
    }
             public void setFstepphaseshiftincrement(int fstepphaseshiftincrement){
        this.fstepphaseshiftincrement=fstepphaseshiftincrement;
    }
	   public int getFstepphaseshiftincrement(){
      return fstepphaseshiftincrement;
    }
             public void setFstepvoltageincrement(int fstepvoltageincrement){
        this.fstepvoltageincrement=fstepvoltageincrement;
    }
	   public int getFstepvoltageincrement(){
      return fstepvoltageincrement;
    }
             public void setFtculcontrolmode(String ftculcontrolmode){
        this.ftculcontrolmode=ftculcontrolmode;
    }
	   public String getFtculcontrolmode(){
      return ftculcontrolmode;
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