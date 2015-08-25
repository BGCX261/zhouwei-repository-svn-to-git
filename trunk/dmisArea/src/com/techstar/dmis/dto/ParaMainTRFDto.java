package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 主变压器
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaMainTRFDto  implements Serializable {
    
	public ParaMainTRFDto() {
    }
	
          private String fcapacityratio; //容量比
	      private String fwiregroup; //接线方式
	      private String finstallsite; //安装位置
	      private String ffirefightsysistmtd; //安装消防系统形式
	      private String fhvoutletmtd; //高压侧出线方式
	      private String fmvoutletmtd; //中压侧出线方式
	      private String flvoutletmtd; //低压侧出线方式
	      private int fnoloadcurrent; //空载电流_%
	      private int fnoloadloss; //空载损耗_kW
	      private int fhmshortci; //高中压侧短路阻抗_%
	      private int fhlshortci; //高低压侧短路阻抗_%
	      private int fmlshortci; //中低压侧短路阻抗_%
	      private int fhmshortcloss; //高中压侧短路损耗_kW
	      private int fhlshortcloss; //高低压侧短路损耗_kW
	      private int fmlshortcloss; //中低压侧短路损耗_kW
	      private String fweakinsulated; //是否弱绝缘
	      private int funtankweight; //器身重_t
	      private int foilweight; //油重_t
	      private int ftotalweight; //总重_t
	      private String fvoltageratio; //电压比_kV
	      private String fcurrentratio; //电流比_A
	      private int fratedcapacity; //额定容量
	      private String fhaveload; //高压侧是否有载调压
	      private String fcoolmethod; //冷却方式
	      private int fselfcoolmethod; //自冷容量_%
	      private String fphaseno; //相数
	      private String finsulatedielectric; //绝缘介质
	      private String fcombinationcap; //容量组合
	      private String ftotallyencolosed; //是否全密封
	      private String fisthermosyphon; //有无热虹吸
	      private String ftankstructure; //油箱结构
	      private String ftankstrength; //油箱强度
	      private int fuptankweight; //油枕重_t
	      private String fhavenoloadvolrglt; //中压侧是否无载调压
	      private String fspecdev; //加带特殊装置
	      private String ffaulttestfac; //潜伏性故障检测仪厂家
	      private String ffaulttestmodel; //潜伏性故障检测仪型号
	      private String fwaterctrlmodel; //水喷雾系统控制装置型号
	      private String fwaterctrlfac; //水喷雾系统控制装置厂家
	      private String fishas; //是否有载
	      private String fhighvolcompare; //主变套管TA变比/高压侧
	      private String fmidvolcompare; //主变套管TA变比/中压侧
	      private String flowvolcompare; //主变套管TA变比/低压侧
	      private String fimpedancehemo; //220kV零序阻抗(Ω)/高压侧通电、中压侧开路
	      private String fimpedancehems; //220kV零序阻抗(Ω)/高压侧通电、中压侧短路
	      private String fimpedancehome; //220kV零序阻抗(Ω)/高压侧开路、中压侧通电
	      private String fimpedancehsme; //220kV零序阻抗(Ω)/高压侧短路、中压侧通电
	      private String fnphighvolcompare; //220kV主变中性点TA变比/高压侧
	      private String fnpmidvolcompare; //220kV主变中性点TA变比/中压侧
	      private String fmthighvolcompare; //220kV主变间隙TA变比/高压侧
	      private String fmtmidvolcompare; //220kV主变间隙TA变比/中压侧
	      private java.sql.Date ffixdate; //大修日期
	      private java.sql.Date fexamdate; //化验日期
	      private java.sql.Date fassaydate; //试验日期
	      private String feqpid; //设备ID
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.EtsEquipmentDto zparamaintrf2; //设备ID
		 

  	
	
   /**
     * getters and setters
     */
           public void setFcapacityratio(String fcapacityratio){
        this.fcapacityratio=fcapacityratio;
    }
	   public String getFcapacityratio(){
      return fcapacityratio;
    }
           public void setFwiregroup(String fwiregroup){
        this.fwiregroup=fwiregroup;
    }
	   public String getFwiregroup(){
      return fwiregroup;
    }
           public void setFinstallsite(String finstallsite){
        this.finstallsite=finstallsite;
    }
	   public String getFinstallsite(){
      return finstallsite;
    }
           public void setFfirefightsysistmtd(String ffirefightsysistmtd){
        this.ffirefightsysistmtd=ffirefightsysistmtd;
    }
	   public String getFfirefightsysistmtd(){
      return ffirefightsysistmtd;
    }
           public void setFhvoutletmtd(String fhvoutletmtd){
        this.fhvoutletmtd=fhvoutletmtd;
    }
	   public String getFhvoutletmtd(){
      return fhvoutletmtd;
    }
           public void setFmvoutletmtd(String fmvoutletmtd){
        this.fmvoutletmtd=fmvoutletmtd;
    }
	   public String getFmvoutletmtd(){
      return fmvoutletmtd;
    }
           public void setFlvoutletmtd(String flvoutletmtd){
        this.flvoutletmtd=flvoutletmtd;
    }
	   public String getFlvoutletmtd(){
      return flvoutletmtd;
    }
           public void setFnoloadcurrent(int fnoloadcurrent){
        this.fnoloadcurrent=fnoloadcurrent;
    }
	   public int getFnoloadcurrent(){
      return fnoloadcurrent;
    }
           public void setFnoloadloss(int fnoloadloss){
        this.fnoloadloss=fnoloadloss;
    }
	   public int getFnoloadloss(){
      return fnoloadloss;
    }
           public void setFhmshortci(int fhmshortci){
        this.fhmshortci=fhmshortci;
    }
	   public int getFhmshortci(){
      return fhmshortci;
    }
           public void setFhlshortci(int fhlshortci){
        this.fhlshortci=fhlshortci;
    }
	   public int getFhlshortci(){
      return fhlshortci;
    }
           public void setFmlshortci(int fmlshortci){
        this.fmlshortci=fmlshortci;
    }
	   public int getFmlshortci(){
      return fmlshortci;
    }
           public void setFhmshortcloss(int fhmshortcloss){
        this.fhmshortcloss=fhmshortcloss;
    }
	   public int getFhmshortcloss(){
      return fhmshortcloss;
    }
           public void setFhlshortcloss(int fhlshortcloss){
        this.fhlshortcloss=fhlshortcloss;
    }
	   public int getFhlshortcloss(){
      return fhlshortcloss;
    }
           public void setFmlshortcloss(int fmlshortcloss){
        this.fmlshortcloss=fmlshortcloss;
    }
	   public int getFmlshortcloss(){
      return fmlshortcloss;
    }
           public void setFweakinsulated(String fweakinsulated){
        this.fweakinsulated=fweakinsulated;
    }
	   public String getFweakinsulated(){
      return fweakinsulated;
    }
           public void setFuntankweight(int funtankweight){
        this.funtankweight=funtankweight;
    }
	   public int getFuntankweight(){
      return funtankweight;
    }
           public void setFoilweight(int foilweight){
        this.foilweight=foilweight;
    }
	   public int getFoilweight(){
      return foilweight;
    }
           public void setFtotalweight(int ftotalweight){
        this.ftotalweight=ftotalweight;
    }
	   public int getFtotalweight(){
      return ftotalweight;
    }
           public void setFvoltageratio(String fvoltageratio){
        this.fvoltageratio=fvoltageratio;
    }
	   public String getFvoltageratio(){
      return fvoltageratio;
    }
           public void setFcurrentratio(String fcurrentratio){
        this.fcurrentratio=fcurrentratio;
    }
	   public String getFcurrentratio(){
      return fcurrentratio;
    }
           public void setFratedcapacity(int fratedcapacity){
        this.fratedcapacity=fratedcapacity;
    }
	   public int getFratedcapacity(){
      return fratedcapacity;
    }
           public void setFhaveload(String fhaveload){
        this.fhaveload=fhaveload;
    }
	   public String getFhaveload(){
      return fhaveload;
    }
           public void setFcoolmethod(String fcoolmethod){
        this.fcoolmethod=fcoolmethod;
    }
	   public String getFcoolmethod(){
      return fcoolmethod;
    }
           public void setFselfcoolmethod(int fselfcoolmethod){
        this.fselfcoolmethod=fselfcoolmethod;
    }
	   public int getFselfcoolmethod(){
      return fselfcoolmethod;
    }
           public void setFphaseno(String fphaseno){
        this.fphaseno=fphaseno;
    }
	   public String getFphaseno(){
      return fphaseno;
    }
           public void setFinsulatedielectric(String finsulatedielectric){
        this.finsulatedielectric=finsulatedielectric;
    }
	   public String getFinsulatedielectric(){
      return finsulatedielectric;
    }
           public void setFcombinationcap(String fcombinationcap){
        this.fcombinationcap=fcombinationcap;
    }
	   public String getFcombinationcap(){
      return fcombinationcap;
    }
           public void setFtotallyencolosed(String ftotallyencolosed){
        this.ftotallyencolosed=ftotallyencolosed;
    }
	   public String getFtotallyencolosed(){
      return ftotallyencolosed;
    }
           public void setFisthermosyphon(String fisthermosyphon){
        this.fisthermosyphon=fisthermosyphon;
    }
	   public String getFisthermosyphon(){
      return fisthermosyphon;
    }
           public void setFtankstructure(String ftankstructure){
        this.ftankstructure=ftankstructure;
    }
	   public String getFtankstructure(){
      return ftankstructure;
    }
           public void setFtankstrength(String ftankstrength){
        this.ftankstrength=ftankstrength;
    }
	   public String getFtankstrength(){
      return ftankstrength;
    }
           public void setFuptankweight(int fuptankweight){
        this.fuptankweight=fuptankweight;
    }
	   public int getFuptankweight(){
      return fuptankweight;
    }
           public void setFhavenoloadvolrglt(String fhavenoloadvolrglt){
        this.fhavenoloadvolrglt=fhavenoloadvolrglt;
    }
	   public String getFhavenoloadvolrglt(){
      return fhavenoloadvolrglt;
    }
           public void setFspecdev(String fspecdev){
        this.fspecdev=fspecdev;
    }
	   public String getFspecdev(){
      return fspecdev;
    }
           public void setFfaulttestfac(String ffaulttestfac){
        this.ffaulttestfac=ffaulttestfac;
    }
	   public String getFfaulttestfac(){
      return ffaulttestfac;
    }
           public void setFfaulttestmodel(String ffaulttestmodel){
        this.ffaulttestmodel=ffaulttestmodel;
    }
	   public String getFfaulttestmodel(){
      return ffaulttestmodel;
    }
           public void setFwaterctrlmodel(String fwaterctrlmodel){
        this.fwaterctrlmodel=fwaterctrlmodel;
    }
	   public String getFwaterctrlmodel(){
      return fwaterctrlmodel;
    }
           public void setFwaterctrlfac(String fwaterctrlfac){
        this.fwaterctrlfac=fwaterctrlfac;
    }
	   public String getFwaterctrlfac(){
      return fwaterctrlfac;
    }
           public void setFishas(String fishas){
        this.fishas=fishas;
    }
	   public String getFishas(){
      return fishas;
    }
           public void setFhighvolcompare(String fhighvolcompare){
        this.fhighvolcompare=fhighvolcompare;
    }
	   public String getFhighvolcompare(){
      return fhighvolcompare;
    }
           public void setFmidvolcompare(String fmidvolcompare){
        this.fmidvolcompare=fmidvolcompare;
    }
	   public String getFmidvolcompare(){
      return fmidvolcompare;
    }
           public void setFlowvolcompare(String flowvolcompare){
        this.flowvolcompare=flowvolcompare;
    }
	   public String getFlowvolcompare(){
      return flowvolcompare;
    }
           public void setFimpedancehemo(String fimpedancehemo){
        this.fimpedancehemo=fimpedancehemo;
    }
	   public String getFimpedancehemo(){
      return fimpedancehemo;
    }
           public void setFimpedancehems(String fimpedancehems){
        this.fimpedancehems=fimpedancehems;
    }
	   public String getFimpedancehems(){
      return fimpedancehems;
    }
           public void setFimpedancehome(String fimpedancehome){
        this.fimpedancehome=fimpedancehome;
    }
	   public String getFimpedancehome(){
      return fimpedancehome;
    }
           public void setFimpedancehsme(String fimpedancehsme){
        this.fimpedancehsme=fimpedancehsme;
    }
	   public String getFimpedancehsme(){
      return fimpedancehsme;
    }
           public void setFnphighvolcompare(String fnphighvolcompare){
        this.fnphighvolcompare=fnphighvolcompare;
    }
	   public String getFnphighvolcompare(){
      return fnphighvolcompare;
    }
           public void setFnpmidvolcompare(String fnpmidvolcompare){
        this.fnpmidvolcompare=fnpmidvolcompare;
    }
	   public String getFnpmidvolcompare(){
      return fnpmidvolcompare;
    }
           public void setFmthighvolcompare(String fmthighvolcompare){
        this.fmthighvolcompare=fmthighvolcompare;
    }
	   public String getFmthighvolcompare(){
      return fmthighvolcompare;
    }
           public void setFmtmidvolcompare(String fmtmidvolcompare){
        this.fmtmidvolcompare=fmtmidvolcompare;
    }
	   public String getFmtmidvolcompare(){
      return fmtmidvolcompare;
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
           public void setZparamaintrf2(com.techstar.dmis.dto.EtsEquipmentDto zparamaintrf2){
        this.zparamaintrf2=zparamaintrf2;
    }
	   public com.techstar.dmis.dto.EtsEquipmentDto getZparamaintrf2(){
      return zparamaintrf2;
    }
      
  

}