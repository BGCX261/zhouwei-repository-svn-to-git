package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 断路器
 * This classe is based on ValueObject Pattern
 */
public class TransParaHISwitchDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransParaHISwitchDto() {
    }
	
          private String flinename; //路名
          private String fswitchtype; //开关类型
          private String finstallsite; //安装位置
          private java.sql.Date fcheckdate; //保护传校日期
          private java.sql.Date flightmaintaindate; //小修日期
          private java.sql.Date fmoisturedate; //微水测量日期
          private String finccreepagedist; //增爬措施
          private java.sql.Date frtvtime; //涂RTV时间
          private int fratedcurrent; //额定电流_A
          private int fdropoutcurrent; //开断电流_kA
          private int frupturecapacity; //遮断容量_MVA
          private int ffracturecreepage; //断口泄漏比距_CM／kV
          private int fearthcreepage; //对地泄漏比距_CM／kV
          private String fmechanismtype; //机构类型
          private int fthermaleqailibrium; //热稳定电流
          private int fpeakwithstand; //动稳定电流
          private java.sql.Date fheavymaintaindate; //机构大修日期
          private int fratedgaspressure; //额定气体压力
          private String fcompagetype; //组合设备类型
          private String frtvfac; //涂RTV厂家
          private java.sql.Date ffixdate; //大修日期
          private java.sql.Date fexamdate; //化验日期
          private java.sql.Date fassaydate; //试验日期
          private String feqpid; //设备ID
          private int version; //数据库版本控制
          private String trans_zparahiswitch2; //设备ID
    	 
	
   /**
     * getters and setters
     */
            public void setFlinename(String flinename){
        this.flinename=flinename;
    }
	   public String getFlinename(){
      return flinename;
    }
             public void setFswitchtype(String fswitchtype){
        this.fswitchtype=fswitchtype;
    }
	   public String getFswitchtype(){
      return fswitchtype;
    }
             public void setFinstallsite(String finstallsite){
        this.finstallsite=finstallsite;
    }
	   public String getFinstallsite(){
      return finstallsite;
    }
             public void setFcheckdate(java.sql.Date fcheckdate){
        this.fcheckdate=fcheckdate;
    }
	   public java.sql.Date getFcheckdate(){
      return fcheckdate;
    }
             public void setFlightmaintaindate(java.sql.Date flightmaintaindate){
        this.flightmaintaindate=flightmaintaindate;
    }
	   public java.sql.Date getFlightmaintaindate(){
      return flightmaintaindate;
    }
             public void setFmoisturedate(java.sql.Date fmoisturedate){
        this.fmoisturedate=fmoisturedate;
    }
	   public java.sql.Date getFmoisturedate(){
      return fmoisturedate;
    }
             public void setFinccreepagedist(String finccreepagedist){
        this.finccreepagedist=finccreepagedist;
    }
	   public String getFinccreepagedist(){
      return finccreepagedist;
    }
             public void setFrtvtime(java.sql.Date frtvtime){
        this.frtvtime=frtvtime;
    }
	   public java.sql.Date getFrtvtime(){
      return frtvtime;
    }
             public void setFratedcurrent(int fratedcurrent){
        this.fratedcurrent=fratedcurrent;
    }
	   public int getFratedcurrent(){
      return fratedcurrent;
    }
             public void setFdropoutcurrent(int fdropoutcurrent){
        this.fdropoutcurrent=fdropoutcurrent;
    }
	   public int getFdropoutcurrent(){
      return fdropoutcurrent;
    }
             public void setFrupturecapacity(int frupturecapacity){
        this.frupturecapacity=frupturecapacity;
    }
	   public int getFrupturecapacity(){
      return frupturecapacity;
    }
             public void setFfracturecreepage(int ffracturecreepage){
        this.ffracturecreepage=ffracturecreepage;
    }
	   public int getFfracturecreepage(){
      return ffracturecreepage;
    }
             public void setFearthcreepage(int fearthcreepage){
        this.fearthcreepage=fearthcreepage;
    }
	   public int getFearthcreepage(){
      return fearthcreepage;
    }
             public void setFmechanismtype(String fmechanismtype){
        this.fmechanismtype=fmechanismtype;
    }
	   public String getFmechanismtype(){
      return fmechanismtype;
    }
             public void setFthermaleqailibrium(int fthermaleqailibrium){
        this.fthermaleqailibrium=fthermaleqailibrium;
    }
	   public int getFthermaleqailibrium(){
      return fthermaleqailibrium;
    }
             public void setFpeakwithstand(int fpeakwithstand){
        this.fpeakwithstand=fpeakwithstand;
    }
	   public int getFpeakwithstand(){
      return fpeakwithstand;
    }
             public void setFheavymaintaindate(java.sql.Date fheavymaintaindate){
        this.fheavymaintaindate=fheavymaintaindate;
    }
	   public java.sql.Date getFheavymaintaindate(){
      return fheavymaintaindate;
    }
             public void setFratedgaspressure(int fratedgaspressure){
        this.fratedgaspressure=fratedgaspressure;
    }
	   public int getFratedgaspressure(){
      return fratedgaspressure;
    }
             public void setFcompagetype(String fcompagetype){
        this.fcompagetype=fcompagetype;
    }
	   public String getFcompagetype(){
      return fcompagetype;
    }
             public void setFrtvfac(String frtvfac){
        this.frtvfac=frtvfac;
    }
	   public String getFrtvfac(){
      return frtvfac;
    }
             public void setFfixdate(java.sql.Date ffixdate){
        this.ffixdate=ffixdate;
    }
	   public java.sql.Date getFfixdate(){
      return ffixdate;
    }
             public void setFexamdate(java.sql.Date fexamdate){
        this.fexamdate=fexamdate;
    }
	   public java.sql.Date getFexamdate(){
      return fexamdate;
    }
             public void setFassaydate(java.sql.Date fassaydate){
        this.fassaydate=fassaydate;
    }
	   public java.sql.Date getFassaydate(){
      return fassaydate;
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
             public void setTrans_zparahiswitch2(String trans_zparahiswitch2){
        this.trans_zparahiswitch2=trans_zparahiswitch2;
    }
	   public String getTrans_zparahiswitch2(){
      return trans_zparahiswitch2;
    }
       
  

}