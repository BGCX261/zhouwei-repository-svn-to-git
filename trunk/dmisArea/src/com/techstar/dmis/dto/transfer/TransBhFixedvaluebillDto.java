package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 定值单
 * This classe is based on ValueObject Pattern
 */
public class TransBhFixedvaluebillDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransBhFixedvaluebillDto() {
    }
	
          private java.sql.Date fixvaluedate; //出单日期
          private String fstatus; //业务状态
          private String fapprover; //审批人
          private String fchecker; //校核人
          private String fcaculator; //计算人
          private String fremark; //说明
          private java.sql.Date fexcutetime; //执行时间
          private String ondutymember; //值班调度员
          private String eqpid; //装置编号
              private String fixvalueno; //定值单编号
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String fchangereason; //改变原因
          private String fixvaluebillno; //定值单号
          private int version; //数据库版本控制
          private java.util.Collection fbhfixedvaluebilldetail1; //定值单号
    	 
	
   /**
     * getters and setters
     */
            public void setFixvaluedate(java.sql.Date fixvaluedate){
        this.fixvaluedate=fixvaluedate;
    }
	   public java.sql.Date getFixvaluedate(){
      return fixvaluedate;
    }
             public void setFstatus(String fstatus){
        this.fstatus=fstatus;
    }
	   public String getFstatus(){
      return fstatus;
    }
             public void setFapprover(String fapprover){
        this.fapprover=fapprover;
    }
	   public String getFapprover(){
      return fapprover;
    }
             public void setFchecker(String fchecker){
        this.fchecker=fchecker;
    }
	   public String getFchecker(){
      return fchecker;
    }
             public void setFcaculator(String fcaculator){
        this.fcaculator=fcaculator;
    }
	   public String getFcaculator(){
      return fcaculator;
    }
             public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
    }
             public void setFexcutetime(java.sql.Date fexcutetime){
        this.fexcutetime=fexcutetime;
    }
	   public java.sql.Date getFexcutetime(){
      return fexcutetime;
    }
             public void setOndutymember(String ondutymember){
        this.ondutymember=ondutymember;
    }
	   public String getOndutymember(){
      return ondutymember;
    }
             public void setEqpid(String eqpid){
        this.eqpid=eqpid;
    }
	   public String getEqpid(){
      return eqpid;
    }
                  public void setFixvalueno(String fixvalueno){
        this.fixvalueno=fixvalueno;
    }
	   public String getFixvalueno(){
      return fixvalueno;
    }
             public void setSys_fille(String sys_fille){
        this.sys_fille=sys_fille;
    }
	   public String getSys_fille(){
      return sys_fille;
    }
             public void setSys_filldept(String sys_filldept){
        this.sys_filldept=sys_filldept;
    }
	   public String getSys_filldept(){
      return sys_filldept;
    }
             public void setSys_filltime(java.sql.Timestamp sys_filltime){
        this.sys_filltime=sys_filltime;
    }
	   public java.sql.Timestamp getSys_filltime(){
      return sys_filltime;
    }
             public void setSys_isvalid(int sys_isvalid){
        this.sys_isvalid=sys_isvalid;
    }
	   public int getSys_isvalid(){
      return sys_isvalid;
    }
             public void setSys_dataowner(String sys_dataowner){
        this.sys_dataowner=sys_dataowner;
    }
	   public String getSys_dataowner(){
      return sys_dataowner;
    }
             public void setFchangereason(String fchangereason){
        this.fchangereason=fchangereason;
    }
	   public String getFchangereason(){
      return fchangereason;
    }
             public void setFixvaluebillno(String fixvaluebillno){
        this.fixvaluebillno=fixvaluebillno;
    }
	   public String getFixvaluebillno(){
      return fixvaluebillno;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setFbhfixedvaluebilldetail1(java.util.Collection fbhfixedvaluebilldetail1){
        this.fbhfixedvaluebilldetail1=fbhfixedvaluebilldetail1;
    }
	   public java.util.Collection getFbhfixedvaluebilldetail1(){
      return fbhfixedvaluebilldetail1;
    }
       
  

}