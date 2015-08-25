package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 电容器
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaCAPBankDto  implements Serializable {
    
	public ParaCAPBankDto() {
    }
	
          private int fcapvalue; //电容值(μF)
	      private String fcapwirestyle; //电容器组接线方式
	      private String fcapphaserwirestyle; //电容器组每相接线方式
	      private String fcapinnerprostyle; //电容器组内部保护方式
	      private String fcapresismode; //电容器串抗型号
	      private int fcapresisvalue; //电容器串抗电抗值(Ω)
	      private String fdchcoilmodel; //放电线圈型号
	      private String fdchcoilvarirate; //放电线圈/变比
	      private int fdchcoiloncevol; //放电线圈/一次电压(kV)
	      private int fdchcoilsecvol; //放电线圈/二次电压(kV)
	      private String fmidubalctvarirate; //中性点不平衡电流互感器/变比
	      private int funitcapacity; //容量
	      private int forgquantity; //初装台数
	      private int forgcapacity; //初装容量_kVar
	      private int fruncapacity; //运行台数
	      private int fruncapacith; //运行容量_kVar
	      private int fperreatance; //串抗百分电抗%
	      private int fimpedancevalue; //串抗阻抗值Ω
	      private String fparabusbar; //电容器所在母线
	      private int fratedcapacity; //放电线圈放电容量_kVA
	      private int fhiswitchcount; //断路器个数
	      private int fctcount; //电流互感器个数
	      private int farrestercount; //避雷器个数
	      private int fdisconnectcount; //隔离开关个数
	      private String fpowercapmodel; //电容器型号
	      private String fpowercapfac; //电容器厂家
	      private String fpowercapcountry; //电容器国家
	      private String fpowercapwiremode; //电容器接线方式
	      private String fdischargecoilfac; //放电线轮厂家
	      private String fdischargecoilmodel; //放电线轮型号
	      private String flghtarrestermodel; //避雷器型号
	      private String freactormodel; //串联电抗器型号
	      private String freactortype; //串联电抗器类型
	      private String freactorfac; //串联电抗器厂家
	      private int freactornum; //串联电抗器台数
	      private int freactorcapacity; //串联电抗器容量_kVA
	      private int freactorcurrent; //串联电抗器额定电流A
	      private String fzeroctmodel; //零序CT型号
	      private String fzerocttransratio; //零序CT变比
	      private String fzeroctfac; //零序CT厂家
	      private String fpowercaptype; //电容器类型
	      private int flghtacapacity; //避雷器方波通流容量_A
	      private java.sql.Date fcleandate; //清扫日期
	      private String feswitchmodel; //四联接地刀闸的型号
	      private String feswitchfac; //四联接地刀闸的厂家
	      private String flghtarresterfac; //避雷器厂家
	      private String fhasinfuse; //是否内熔丝
	      private String finternalwiremode; //单台电容器内部接线方式
	      private int finsurancedevcount; //保险器个数
	      private java.sql.Date ffixdate; //大修日期
	      private java.sql.Date fexamdate; //化验日期
	      private java.sql.Date fassaydate; //试验日期
	      private String feqpid; //设备ID
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.EtsEquipmentDto zparacapbank2; //设备ID
		 

  	
	
   /**
     * getters and setters
     */
           public void setFcapvalue(int fcapvalue){
        this.fcapvalue=fcapvalue;
    }
	   public int getFcapvalue(){
      return fcapvalue;
    }
           public void setFcapwirestyle(String fcapwirestyle){
        this.fcapwirestyle=fcapwirestyle;
    }
	   public String getFcapwirestyle(){
      return fcapwirestyle;
    }
           public void setFcapphaserwirestyle(String fcapphaserwirestyle){
        this.fcapphaserwirestyle=fcapphaserwirestyle;
    }
	   public String getFcapphaserwirestyle(){
      return fcapphaserwirestyle;
    }
           public void setFcapinnerprostyle(String fcapinnerprostyle){
        this.fcapinnerprostyle=fcapinnerprostyle;
    }
	   public String getFcapinnerprostyle(){
      return fcapinnerprostyle;
    }
           public void setFcapresismode(String fcapresismode){
        this.fcapresismode=fcapresismode;
    }
	   public String getFcapresismode(){
      return fcapresismode;
    }
           public void setFcapresisvalue(int fcapresisvalue){
        this.fcapresisvalue=fcapresisvalue;
    }
	   public int getFcapresisvalue(){
      return fcapresisvalue;
    }
           public void setFdchcoilmodel(String fdchcoilmodel){
        this.fdchcoilmodel=fdchcoilmodel;
    }
	   public String getFdchcoilmodel(){
      return fdchcoilmodel;
    }
           public void setFdchcoilvarirate(String fdchcoilvarirate){
        this.fdchcoilvarirate=fdchcoilvarirate;
    }
	   public String getFdchcoilvarirate(){
      return fdchcoilvarirate;
    }
           public void setFdchcoiloncevol(int fdchcoiloncevol){
        this.fdchcoiloncevol=fdchcoiloncevol;
    }
	   public int getFdchcoiloncevol(){
      return fdchcoiloncevol;
    }
           public void setFdchcoilsecvol(int fdchcoilsecvol){
        this.fdchcoilsecvol=fdchcoilsecvol;
    }
	   public int getFdchcoilsecvol(){
      return fdchcoilsecvol;
    }
           public void setFmidubalctvarirate(String fmidubalctvarirate){
        this.fmidubalctvarirate=fmidubalctvarirate;
    }
	   public String getFmidubalctvarirate(){
      return fmidubalctvarirate;
    }
           public void setFunitcapacity(int funitcapacity){
        this.funitcapacity=funitcapacity;
    }
	   public int getFunitcapacity(){
      return funitcapacity;
    }
           public void setForgquantity(int forgquantity){
        this.forgquantity=forgquantity;
    }
	   public int getForgquantity(){
      return forgquantity;
    }
           public void setForgcapacity(int forgcapacity){
        this.forgcapacity=forgcapacity;
    }
	   public int getForgcapacity(){
      return forgcapacity;
    }
           public void setFruncapacity(int fruncapacity){
        this.fruncapacity=fruncapacity;
    }
	   public int getFruncapacity(){
      return fruncapacity;
    }
           public void setFruncapacith(int fruncapacith){
        this.fruncapacith=fruncapacith;
    }
	   public int getFruncapacith(){
      return fruncapacith;
    }
           public void setFperreatance(int fperreatance){
        this.fperreatance=fperreatance;
    }
	   public int getFperreatance(){
      return fperreatance;
    }
           public void setFimpedancevalue(int fimpedancevalue){
        this.fimpedancevalue=fimpedancevalue;
    }
	   public int getFimpedancevalue(){
      return fimpedancevalue;
    }
           public void setFparabusbar(String fparabusbar){
        this.fparabusbar=fparabusbar;
    }
	   public String getFparabusbar(){
      return fparabusbar;
    }
           public void setFratedcapacity(int fratedcapacity){
        this.fratedcapacity=fratedcapacity;
    }
	   public int getFratedcapacity(){
      return fratedcapacity;
    }
           public void setFhiswitchcount(int fhiswitchcount){
        this.fhiswitchcount=fhiswitchcount;
    }
	   public int getFhiswitchcount(){
      return fhiswitchcount;
    }
           public void setFctcount(int fctcount){
        this.fctcount=fctcount;
    }
	   public int getFctcount(){
      return fctcount;
    }
           public void setFarrestercount(int farrestercount){
        this.farrestercount=farrestercount;
    }
	   public int getFarrestercount(){
      return farrestercount;
    }
           public void setFdisconnectcount(int fdisconnectcount){
        this.fdisconnectcount=fdisconnectcount;
    }
	   public int getFdisconnectcount(){
      return fdisconnectcount;
    }
           public void setFpowercapmodel(String fpowercapmodel){
        this.fpowercapmodel=fpowercapmodel;
    }
	   public String getFpowercapmodel(){
      return fpowercapmodel;
    }
           public void setFpowercapfac(String fpowercapfac){
        this.fpowercapfac=fpowercapfac;
    }
	   public String getFpowercapfac(){
      return fpowercapfac;
    }
           public void setFpowercapcountry(String fpowercapcountry){
        this.fpowercapcountry=fpowercapcountry;
    }
	   public String getFpowercapcountry(){
      return fpowercapcountry;
    }
           public void setFpowercapwiremode(String fpowercapwiremode){
        this.fpowercapwiremode=fpowercapwiremode;
    }
	   public String getFpowercapwiremode(){
      return fpowercapwiremode;
    }
           public void setFdischargecoilfac(String fdischargecoilfac){
        this.fdischargecoilfac=fdischargecoilfac;
    }
	   public String getFdischargecoilfac(){
      return fdischargecoilfac;
    }
           public void setFdischargecoilmodel(String fdischargecoilmodel){
        this.fdischargecoilmodel=fdischargecoilmodel;
    }
	   public String getFdischargecoilmodel(){
      return fdischargecoilmodel;
    }
           public void setFlghtarrestermodel(String flghtarrestermodel){
        this.flghtarrestermodel=flghtarrestermodel;
    }
	   public String getFlghtarrestermodel(){
      return flghtarrestermodel;
    }
           public void setFreactormodel(String freactormodel){
        this.freactormodel=freactormodel;
    }
	   public String getFreactormodel(){
      return freactormodel;
    }
           public void setFreactortype(String freactortype){
        this.freactortype=freactortype;
    }
	   public String getFreactortype(){
      return freactortype;
    }
           public void setFreactorfac(String freactorfac){
        this.freactorfac=freactorfac;
    }
	   public String getFreactorfac(){
      return freactorfac;
    }
           public void setFreactornum(int freactornum){
        this.freactornum=freactornum;
    }
	   public int getFreactornum(){
      return freactornum;
    }
           public void setFreactorcapacity(int freactorcapacity){
        this.freactorcapacity=freactorcapacity;
    }
	   public int getFreactorcapacity(){
      return freactorcapacity;
    }
           public void setFreactorcurrent(int freactorcurrent){
        this.freactorcurrent=freactorcurrent;
    }
	   public int getFreactorcurrent(){
      return freactorcurrent;
    }
           public void setFzeroctmodel(String fzeroctmodel){
        this.fzeroctmodel=fzeroctmodel;
    }
	   public String getFzeroctmodel(){
      return fzeroctmodel;
    }
           public void setFzerocttransratio(String fzerocttransratio){
        this.fzerocttransratio=fzerocttransratio;
    }
	   public String getFzerocttransratio(){
      return fzerocttransratio;
    }
           public void setFzeroctfac(String fzeroctfac){
        this.fzeroctfac=fzeroctfac;
    }
	   public String getFzeroctfac(){
      return fzeroctfac;
    }
           public void setFpowercaptype(String fpowercaptype){
        this.fpowercaptype=fpowercaptype;
    }
	   public String getFpowercaptype(){
      return fpowercaptype;
    }
           public void setFlghtacapacity(int flghtacapacity){
        this.flghtacapacity=flghtacapacity;
    }
	   public int getFlghtacapacity(){
      return flghtacapacity;
    }
           public void setFcleandate(java.sql.Date fcleandate){
        this.fcleandate=fcleandate;
    }
	   public java.sql.Date getFcleandate(){
      return fcleandate;
    }
           public void setFeswitchmodel(String feswitchmodel){
        this.feswitchmodel=feswitchmodel;
    }
	   public String getFeswitchmodel(){
      return feswitchmodel;
    }
           public void setFeswitchfac(String feswitchfac){
        this.feswitchfac=feswitchfac;
    }
	   public String getFeswitchfac(){
      return feswitchfac;
    }
           public void setFlghtarresterfac(String flghtarresterfac){
        this.flghtarresterfac=flghtarresterfac;
    }
	   public String getFlghtarresterfac(){
      return flghtarresterfac;
    }
           public void setFhasinfuse(String fhasinfuse){
        this.fhasinfuse=fhasinfuse;
    }
	   public String getFhasinfuse(){
      return fhasinfuse;
    }
           public void setFinternalwiremode(String finternalwiremode){
        this.finternalwiremode=finternalwiremode;
    }
	   public String getFinternalwiremode(){
      return finternalwiremode;
    }
           public void setFinsurancedevcount(int finsurancedevcount){
        this.finsurancedevcount=finsurancedevcount;
    }
	   public int getFinsurancedevcount(){
      return finsurancedevcount;
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
           public void setZparacapbank2(com.techstar.dmis.dto.EtsEquipmentDto zparacapbank2){
        this.zparacapbank2=zparacapbank2;
    }
	   public com.techstar.dmis.dto.EtsEquipmentDto getZparacapbank2(){
      return zparacapbank2;
    }
      
  

}