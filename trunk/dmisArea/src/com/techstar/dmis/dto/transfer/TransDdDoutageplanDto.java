package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 日停电计划
 * This classe is based on ValueObject Pattern
 */
public class TransDdDoutageplanDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDdDoutageplanDto() {
    }
	
          private String fmanualno; //手工编号
          private String fstationname; //变电站
          private String fline; //线路名
          private String fworkarea; //工作地点
          private String foutagearea; //停电范围
          private String fdispatchrange; //调度范围
          private java.sql.Timestamp fapplystime; //申请工作起始时间
          private java.sql.Timestamp fapplyetime; //申请工作结束时间
          private java.sql.Timestamp fapplyoutagetime; //申请停电时间
          private java.sql.Timestamp fapplyrestoretime; //申请发电时间
          private String fapplyunit; //申请单位
          private String fapplicant; //申请人
          private java.sql.Date fapplytime; //申请时间
          private String fremark; //备注
                  private String fattention; //注意事项
          private String fpermitcontent; //许可内容
          private String fapprooutageword; //批准停电字
          private String fapprooutageno; //批准停电号
          private java.sql.Timestamp fapproworkstime; //批准工作开始时间
          private java.sql.Timestamp fapproworketime; //批准工作结束时间
          private java.sql.Timestamp fapprostime; //批准停电开始时间
          private java.sql.Timestamp fapproetime; //批准停电结束时间
          private String fgenoutageseq; //停发电操作顺序
          private String fplanappropeople; //中调计划批准人
          private java.sql.Timestamp fcanceltime; //取消时间
          private String fabolish; //取消人
          private String fstatus; //状态
          private String fexcutestatus; //执行状态
          private int fmergeplanno; //合并计划编号
          private java.sql.Date freportdate; //上报日期
          private String fplansourcetype; //计划来源类型
          private String fplansourceno; //计划来源序号
          private String fstationid; //变电站ID
          private String flinenameid; //线路名ID
          private String fapplyunitid; //申请单位ID
          private String ffilltype; //是否调度员填写
          private String workcontent; //工作内容
          private String ispassed; //是否合格
          private String fchecker; //核查人
          private String reason; //核查不合格原因
          private java.sql.Timestamp fchecktime; //核查时间
          private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String fplanclass; //计划分类
          private String fvoltage; //电压等级
          private String fdayplanno; //日计划编号
          private int version; //数据库版本控制
          private java.util.Collection fddrepairdetail2; //日计划编号
          private java.util.Collection fdddayplandelaylist1; //日计划编号
          private java.util.Collection fdddayplanexcutelist1; //日计划编号
          private java.util.Collection fddfsmodechangelist4; //日计划编号
          private java.util.Collection fdayplancoopraterel1; //日计划编号
          private java.util.Collection fdddayplanfixvaluerel2; //日计划编号
          private java.util.Collection fzdhopexaminelist6; //日计划编号
  
    	 
	
   /**
     * getters and setters
     */
            public void setFmanualno(String fmanualno){
        this.fmanualno=fmanualno;
    }
	   public String getFmanualno(){
      return fmanualno;
    }
             public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
             public void setFline(String fline){
        this.fline=fline;
    }
	   public String getFline(){
      return fline;
    }
             public void setFworkarea(String fworkarea){
        this.fworkarea=fworkarea;
    }
	   public String getFworkarea(){
      return fworkarea;
    }
             public void setFoutagearea(String foutagearea){
        this.foutagearea=foutagearea;
    }
	   public String getFoutagearea(){
      return foutagearea;
    }
             public void setFdispatchrange(String fdispatchrange){
        this.fdispatchrange=fdispatchrange;
    }
	   public String getFdispatchrange(){
      return fdispatchrange;
    }
             public void setFapplystime(java.sql.Timestamp fapplystime){
        this.fapplystime=fapplystime;
    }
	   public java.sql.Timestamp getFapplystime(){
      return fapplystime;
    }
             public void setFapplyetime(java.sql.Timestamp fapplyetime){
        this.fapplyetime=fapplyetime;
    }
	   public java.sql.Timestamp getFapplyetime(){
      return fapplyetime;
    }
             public void setFapplyoutagetime(java.sql.Timestamp fapplyoutagetime){
        this.fapplyoutagetime=fapplyoutagetime;
    }
	   public java.sql.Timestamp getFapplyoutagetime(){
      return fapplyoutagetime;
    }
             public void setFapplyrestoretime(java.sql.Timestamp fapplyrestoretime){
        this.fapplyrestoretime=fapplyrestoretime;
    }
	   public java.sql.Timestamp getFapplyrestoretime(){
      return fapplyrestoretime;
    }
             public void setFapplyunit(String fapplyunit){
        this.fapplyunit=fapplyunit;
    }
	   public String getFapplyunit(){
      return fapplyunit;
    }
             public void setFapplicant(String fapplicant){
        this.fapplicant=fapplicant;
    }
	   public String getFapplicant(){
      return fapplicant;
    }
             public void setFapplytime(java.sql.Date fapplytime){
        this.fapplytime=fapplytime;
    }
	   public java.sql.Date getFapplytime(){
      return fapplytime;
    }
             public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
    }
                       public void setFattention(String fattention){
        this.fattention=fattention;
    }
	   public String getFattention(){
      return fattention;
    }
             public void setFpermitcontent(String fpermitcontent){
        this.fpermitcontent=fpermitcontent;
    }
	   public String getFpermitcontent(){
      return fpermitcontent;
    }
             public void setFapprooutageword(String fapprooutageword){
        this.fapprooutageword=fapprooutageword;
    }
	   public String getFapprooutageword(){
      return fapprooutageword;
    }
             public void setFapprooutageno(String fapprooutageno){
        this.fapprooutageno=fapprooutageno;
    }
	   public String getFapprooutageno(){
      return fapprooutageno;
    }
             public void setFapproworkstime(java.sql.Timestamp fapproworkstime){
        this.fapproworkstime=fapproworkstime;
    }
	   public java.sql.Timestamp getFapproworkstime(){
      return fapproworkstime;
    }
             public void setFapproworketime(java.sql.Timestamp fapproworketime){
        this.fapproworketime=fapproworketime;
    }
	   public java.sql.Timestamp getFapproworketime(){
      return fapproworketime;
    }
             public void setFapprostime(java.sql.Timestamp fapprostime){
        this.fapprostime=fapprostime;
    }
	   public java.sql.Timestamp getFapprostime(){
      return fapprostime;
    }
             public void setFapproetime(java.sql.Timestamp fapproetime){
        this.fapproetime=fapproetime;
    }
	   public java.sql.Timestamp getFapproetime(){
      return fapproetime;
    }
             public void setFgenoutageseq(String fgenoutageseq){
        this.fgenoutageseq=fgenoutageseq;
    }
	   public String getFgenoutageseq(){
      return fgenoutageseq;
    }
             public void setFplanappropeople(String fplanappropeople){
        this.fplanappropeople=fplanappropeople;
    }
	   public String getFplanappropeople(){
      return fplanappropeople;
    }
             public void setFcanceltime(java.sql.Timestamp fcanceltime){
        this.fcanceltime=fcanceltime;
    }
	   public java.sql.Timestamp getFcanceltime(){
      return fcanceltime;
    }
             public void setFabolish(String fabolish){
        this.fabolish=fabolish;
    }
	   public String getFabolish(){
      return fabolish;
    }
             public void setFstatus(String fstatus){
        this.fstatus=fstatus;
    }
	   public String getFstatus(){
      return fstatus;
    }
             public void setFexcutestatus(String fexcutestatus){
        this.fexcutestatus=fexcutestatus;
    }
	   public String getFexcutestatus(){
      return fexcutestatus;
    }
             public void setFmergeplanno(int fmergeplanno){
        this.fmergeplanno=fmergeplanno;
    }
	   public int getFmergeplanno(){
      return fmergeplanno;
    }
             public void setFreportdate(java.sql.Date freportdate){
        this.freportdate=freportdate;
    }
	   public java.sql.Date getFreportdate(){
      return freportdate;
    }
             public void setFplansourcetype(String fplansourcetype){
        this.fplansourcetype=fplansourcetype;
    }
	   public String getFplansourcetype(){
      return fplansourcetype;
    }
             public void setFplansourceno(String fplansourceno){
        this.fplansourceno=fplansourceno;
    }
	   public String getFplansourceno(){
      return fplansourceno;
    }
             public void setFstationid(String fstationid){
        this.fstationid=fstationid;
    }
	   public String getFstationid(){
      return fstationid;
    }
             public void setFlinenameid(String flinenameid){
        this.flinenameid=flinenameid;
    }
	   public String getFlinenameid(){
      return flinenameid;
    }
             public void setFapplyunitid(String fapplyunitid){
        this.fapplyunitid=fapplyunitid;
    }
	   public String getFapplyunitid(){
      return fapplyunitid;
    }
             public void setFfilltype(String ffilltype){
        this.ffilltype=ffilltype;
    }
	   public String getFfilltype(){
      return ffilltype;
    }
             public void setWorkcontent(String workcontent){
        this.workcontent=workcontent;
    }
	   public String getWorkcontent(){
      return workcontent;
    }
             public void setIspassed(String ispassed){
        this.ispassed=ispassed;
    }
	   public String getIspassed(){
      return ispassed;
    }
             public void setFchecker(String fchecker){
        this.fchecker=fchecker;
    }
	   public String getFchecker(){
      return fchecker;
    }
             public void setReason(String reason){
        this.reason=reason;
    }
	   public String getReason(){
      return reason;
    }
             public void setFchecktime(java.sql.Timestamp fchecktime){
        this.fchecktime=fchecktime;
    }
	   public java.sql.Timestamp getFchecktime(){
      return fchecktime;
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
             public void setFplanclass(String fplanclass){
        this.fplanclass=fplanclass;
    }
	   public String getFplanclass(){
      return fplanclass;
    }
             public void setFvoltage(String fvoltage){
        this.fvoltage=fvoltage;
    }
	   public String getFvoltage(){
      return fvoltage;
    }
             public void setFdayplanno(String fdayplanno){
        this.fdayplanno=fdayplanno;
    }
	   public String getFdayplanno(){
      return fdayplanno;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setFddrepairdetail2(java.util.Collection fddrepairdetail2){
        this.fddrepairdetail2=fddrepairdetail2;
    }
	   public java.util.Collection getFddrepairdetail2(){
      return fddrepairdetail2;
    }
             public void setFdddayplandelaylist1(java.util.Collection fdddayplandelaylist1){
        this.fdddayplandelaylist1=fdddayplandelaylist1;
    }
	   public java.util.Collection getFdddayplandelaylist1(){
      return fdddayplandelaylist1;
    }
             public void setFdddayplanexcutelist1(java.util.Collection fdddayplanexcutelist1){
        this.fdddayplanexcutelist1=fdddayplanexcutelist1;
    }
	   public java.util.Collection getFdddayplanexcutelist1(){
      return fdddayplanexcutelist1;
    }
             public void setFddfsmodechangelist4(java.util.Collection fddfsmodechangelist4){
        this.fddfsmodechangelist4=fddfsmodechangelist4;
    }
	   public java.util.Collection getFddfsmodechangelist4(){
      return fddfsmodechangelist4;
    }
             public void setFdayplancoopraterel1(java.util.Collection fdayplancoopraterel1){
        this.fdayplancoopraterel1=fdayplancoopraterel1;
    }
	   public java.util.Collection getFdayplancoopraterel1(){
      return fdayplancoopraterel1;
    }
             public void setFdddayplanfixvaluerel2(java.util.Collection fdddayplanfixvaluerel2){
        this.fdddayplanfixvaluerel2=fdddayplanfixvaluerel2;
    }
	   public java.util.Collection getFdddayplanfixvaluerel2(){
      return fdddayplanfixvaluerel2;
    }
             public void setFzdhopexaminelist6(java.util.Collection fzdhopexaminelist6){
        this.fzdhopexaminelist6=fzdhopexaminelist6;
    }
	   public java.util.Collection getFzdhopexaminelist6(){
      return fzdhopexaminelist6;
    }
}