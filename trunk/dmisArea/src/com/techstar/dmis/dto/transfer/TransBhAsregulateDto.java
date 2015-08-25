package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 自投规程
 * This classe is based on ValueObject Pattern
 */
public class TransBhAsregulateDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransBhAsregulateDto() {
    }
	
          private String fstationname; //厂站名称
          private java.sql.Date fwritedate; //编制日期
          private String funitname; //单位名称
          private String dispatchcenteropinion; //调通中心批准意见
          private String runmodedeptopinion; //方式处批准意见
          private String protectdeptopinion; //保护处审核意见
          private String protectresponsor; //保护专责人
          private String excutetime; //执行时间
          private String ondutyname; //值班调度员
                  private String remarks; //备注
          private String asregulateno; //自投规程编号
          private String fiscancel; //是否作废
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String asregulateid; //id
          private int version; //数据库版本控制
          private java.util.Collection fbhasregulatedetail3; //id
          private String trans_zbhasregulate2; //变电站编号
    	 
	
   /**
     * getters and setters
     */
            public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
             public void setFwritedate(java.sql.Date fwritedate){
        this.fwritedate=fwritedate;
    }
	   public java.sql.Date getFwritedate(){
      return fwritedate;
    }
             public void setFunitname(String funitname){
        this.funitname=funitname;
    }
	   public String getFunitname(){
      return funitname;
    }
             public void setDispatchcenteropinion(String dispatchcenteropinion){
        this.dispatchcenteropinion=dispatchcenteropinion;
    }
	   public String getDispatchcenteropinion(){
      return dispatchcenteropinion;
    }
             public void setRunmodedeptopinion(String runmodedeptopinion){
        this.runmodedeptopinion=runmodedeptopinion;
    }
	   public String getRunmodedeptopinion(){
      return runmodedeptopinion;
    }
             public void setProtectdeptopinion(String protectdeptopinion){
        this.protectdeptopinion=protectdeptopinion;
    }
	   public String getProtectdeptopinion(){
      return protectdeptopinion;
    }
             public void setProtectresponsor(String protectresponsor){
        this.protectresponsor=protectresponsor;
    }
	   public String getProtectresponsor(){
      return protectresponsor;
    }
             public void setExcutetime(String excutetime){
        this.excutetime=excutetime;
    }
	   public String getExcutetime(){
      return excutetime;
    }
             public void setOndutyname(String ondutyname){
        this.ondutyname=ondutyname;
    }
	   public String getOndutyname(){
      return ondutyname;
    }
                       public void setRemarks(String remarks){
        this.remarks=remarks;
    }
	   public String getRemarks(){
      return remarks;
    }
             public void setAsregulateno(String asregulateno){
        this.asregulateno=asregulateno;
    }
	   public String getAsregulateno(){
      return asregulateno;
    }
             public void setFiscancel(String fiscancel){
        this.fiscancel=fiscancel;
    }
	   public String getFiscancel(){
      return fiscancel;
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
             public void setAsregulateid(String asregulateid){
        this.asregulateid=asregulateid;
    }
	   public String getAsregulateid(){
      return asregulateid;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setFbhasregulatedetail3(java.util.Collection fbhasregulatedetail3){
        this.fbhasregulatedetail3=fbhasregulatedetail3;
    }
	   public java.util.Collection getFbhasregulatedetail3(){
      return fbhasregulatedetail3;
    }
             public void setTrans_zbhasregulate2(String trans_zbhasregulate2){
        this.trans_zbhasregulate2=trans_zbhasregulate2;
    }
	   public String getTrans_zbhasregulate2(){
      return trans_zbhasregulate2;
    }
       
  

}