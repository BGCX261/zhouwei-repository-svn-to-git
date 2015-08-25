package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 所内变压器
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaAuxTRFDto  implements Serializable {
    
	public ParaAuxTRFDto() {
    }
	
          private String fvoltageratio; //电压比_kV
	      private String fcurrentratio; //电流比_A
	      private String fwiregroup; //接线组别
	      private int fratedcapacity; //容量_kVA
	      private int fratedcapacity2; //所内变二次容量_kVA
	      private String ftransuse; //变压器用途
	      private String fcoolmethod; //冷却方式
	      private String floadvolregulation; //是否有载调压
	      private int fnoloadcurrent; //空载电流_%
	      private int fnoloadloss; //空载损耗_kW
	      private int fshortcimpedance; //短路阻抗_%
	      private int fshortcloss; //短路损耗_kW
	      private int ftotalweight; //总重_t
	      private int fzeroseqimpedance; //零序阻抗_Ω
	      private String fswitchno; //开关/刀闸调度号
	      private String fphaseno; //相数
	      private String floadfanmotor; //是否有风机
	      private String ffanmotorfac; //风机厂名
	      private int funtankweight; //器身重
	      private String ffanmotormodel; //风机型号
	      private String finsulatedielectric; //绝缘介质
	      private String fcableoutlet; //是否直接与电缆连接
	      private String foilsealmethod; //油密封方式
	      private String foilconservatortype; //油枕型式
	      private String ftcmotorfac; //温控器厂家
	      private String ftcmotormodel; //温控器型号
	      private String felecmodel; //小电阻型号
	      private int felecvalue; //小电阻值
	      private String felecfac; //小电阻厂家
	      private String felecmaterial; //小电阻材质
	      private String fetrfconnector; //接地变中性点连接
	      private int fhpcapacity; //额定容量(MVA)/高压侧
	      private int flpcapacity; //额定容量(MVA)/低压侧
	      private int fhpspecvol; //额定电压(kV)/高压侧
	      private int flpspecvol; //额定电压(kV)/低压侧
	      private int fhpspeccur; //额定电流(A)/高压侧
	      private int flpspeccur; //额定电流(A)/低压侧
	      private String fhpconnmod; //接线方式/高压侧
	      private String flpconnmod; //接线方式/低压侧
	      private int fimpedance; //阻抗电压(%)/高低
	      private String fhasfirepumps; //所内变是否带消防泵
	      private int ffirepumpmode; //消防泵型号
	      private int ffirepumpcapa; //消防泵容量(kW)
	      private int ffirepumpvol; //消防泵额定电压(V)
	      private int ffirepumpspeccur; //消防泵额定电流(A)
	      private int ffirepumppulcur; //消防泵启动电流(A)
	      private java.sql.Date ffixdate; //大修日期
	      private java.sql.Date fexamdate; //化验日期
	      private java.sql.Date fassaydate; //试验日期
	      private String feqpid; //设备ID
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.EtsEquipmentDto zparaauxtrf2; //设备ID
		 

  	
	
   /**
     * getters and setters
     */
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
           public void setFwiregroup(String fwiregroup){
        this.fwiregroup=fwiregroup;
    }
	   public String getFwiregroup(){
      return fwiregroup;
    }
           public void setFratedcapacity(int fratedcapacity){
        this.fratedcapacity=fratedcapacity;
    }
	   public int getFratedcapacity(){
      return fratedcapacity;
    }
           public void setFratedcapacity2(int fratedcapacity2){
        this.fratedcapacity2=fratedcapacity2;
    }
	   public int getFratedcapacity2(){
      return fratedcapacity2;
    }
           public void setFtransuse(String ftransuse){
        this.ftransuse=ftransuse;
    }
	   public String getFtransuse(){
      return ftransuse;
    }
           public void setFcoolmethod(String fcoolmethod){
        this.fcoolmethod=fcoolmethod;
    }
	   public String getFcoolmethod(){
      return fcoolmethod;
    }
           public void setFloadvolregulation(String floadvolregulation){
        this.floadvolregulation=floadvolregulation;
    }
	   public String getFloadvolregulation(){
      return floadvolregulation;
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
           public void setFshortcimpedance(int fshortcimpedance){
        this.fshortcimpedance=fshortcimpedance;
    }
	   public int getFshortcimpedance(){
      return fshortcimpedance;
    }
           public void setFshortcloss(int fshortcloss){
        this.fshortcloss=fshortcloss;
    }
	   public int getFshortcloss(){
      return fshortcloss;
    }
           public void setFtotalweight(int ftotalweight){
        this.ftotalweight=ftotalweight;
    }
	   public int getFtotalweight(){
      return ftotalweight;
    }
           public void setFzeroseqimpedance(int fzeroseqimpedance){
        this.fzeroseqimpedance=fzeroseqimpedance;
    }
	   public int getFzeroseqimpedance(){
      return fzeroseqimpedance;
    }
           public void setFswitchno(String fswitchno){
        this.fswitchno=fswitchno;
    }
	   public String getFswitchno(){
      return fswitchno;
    }
           public void setFphaseno(String fphaseno){
        this.fphaseno=fphaseno;
    }
	   public String getFphaseno(){
      return fphaseno;
    }
           public void setFloadfanmotor(String floadfanmotor){
        this.floadfanmotor=floadfanmotor;
    }
	   public String getFloadfanmotor(){
      return floadfanmotor;
    }
           public void setFfanmotorfac(String ffanmotorfac){
        this.ffanmotorfac=ffanmotorfac;
    }
	   public String getFfanmotorfac(){
      return ffanmotorfac;
    }
           public void setFuntankweight(int funtankweight){
        this.funtankweight=funtankweight;
    }
	   public int getFuntankweight(){
      return funtankweight;
    }
           public void setFfanmotormodel(String ffanmotormodel){
        this.ffanmotormodel=ffanmotormodel;
    }
	   public String getFfanmotormodel(){
      return ffanmotormodel;
    }
           public void setFinsulatedielectric(String finsulatedielectric){
        this.finsulatedielectric=finsulatedielectric;
    }
	   public String getFinsulatedielectric(){
      return finsulatedielectric;
    }
           public void setFcableoutlet(String fcableoutlet){
        this.fcableoutlet=fcableoutlet;
    }
	   public String getFcableoutlet(){
      return fcableoutlet;
    }
           public void setFoilsealmethod(String foilsealmethod){
        this.foilsealmethod=foilsealmethod;
    }
	   public String getFoilsealmethod(){
      return foilsealmethod;
    }
           public void setFoilconservatortype(String foilconservatortype){
        this.foilconservatortype=foilconservatortype;
    }
	   public String getFoilconservatortype(){
      return foilconservatortype;
    }
           public void setFtcmotorfac(String ftcmotorfac){
        this.ftcmotorfac=ftcmotorfac;
    }
	   public String getFtcmotorfac(){
      return ftcmotorfac;
    }
           public void setFtcmotormodel(String ftcmotormodel){
        this.ftcmotormodel=ftcmotormodel;
    }
	   public String getFtcmotormodel(){
      return ftcmotormodel;
    }
           public void setFelecmodel(String felecmodel){
        this.felecmodel=felecmodel;
    }
	   public String getFelecmodel(){
      return felecmodel;
    }
           public void setFelecvalue(int felecvalue){
        this.felecvalue=felecvalue;
    }
	   public int getFelecvalue(){
      return felecvalue;
    }
           public void setFelecfac(String felecfac){
        this.felecfac=felecfac;
    }
	   public String getFelecfac(){
      return felecfac;
    }
           public void setFelecmaterial(String felecmaterial){
        this.felecmaterial=felecmaterial;
    }
	   public String getFelecmaterial(){
      return felecmaterial;
    }
           public void setFetrfconnector(String fetrfconnector){
        this.fetrfconnector=fetrfconnector;
    }
	   public String getFetrfconnector(){
      return fetrfconnector;
    }
           public void setFhpcapacity(int fhpcapacity){
        this.fhpcapacity=fhpcapacity;
    }
	   public int getFhpcapacity(){
      return fhpcapacity;
    }
           public void setFlpcapacity(int flpcapacity){
        this.flpcapacity=flpcapacity;
    }
	   public int getFlpcapacity(){
      return flpcapacity;
    }
           public void setFhpspecvol(int fhpspecvol){
        this.fhpspecvol=fhpspecvol;
    }
	   public int getFhpspecvol(){
      return fhpspecvol;
    }
           public void setFlpspecvol(int flpspecvol){
        this.flpspecvol=flpspecvol;
    }
	   public int getFlpspecvol(){
      return flpspecvol;
    }
           public void setFhpspeccur(int fhpspeccur){
        this.fhpspeccur=fhpspeccur;
    }
	   public int getFhpspeccur(){
      return fhpspeccur;
    }
           public void setFlpspeccur(int flpspeccur){
        this.flpspeccur=flpspeccur;
    }
	   public int getFlpspeccur(){
      return flpspeccur;
    }
           public void setFhpconnmod(String fhpconnmod){
        this.fhpconnmod=fhpconnmod;
    }
	   public String getFhpconnmod(){
      return fhpconnmod;
    }
           public void setFlpconnmod(String flpconnmod){
        this.flpconnmod=flpconnmod;
    }
	   public String getFlpconnmod(){
      return flpconnmod;
    }
           public void setFimpedance(int fimpedance){
        this.fimpedance=fimpedance;
    }
	   public int getFimpedance(){
      return fimpedance;
    }
           public void setFhasfirepumps(String fhasfirepumps){
        this.fhasfirepumps=fhasfirepumps;
    }
	   public String getFhasfirepumps(){
      return fhasfirepumps;
    }
           public void setFfirepumpmode(int ffirepumpmode){
        this.ffirepumpmode=ffirepumpmode;
    }
	   public int getFfirepumpmode(){
      return ffirepumpmode;
    }
           public void setFfirepumpcapa(int ffirepumpcapa){
        this.ffirepumpcapa=ffirepumpcapa;
    }
	   public int getFfirepumpcapa(){
      return ffirepumpcapa;
    }
           public void setFfirepumpvol(int ffirepumpvol){
        this.ffirepumpvol=ffirepumpvol;
    }
	   public int getFfirepumpvol(){
      return ffirepumpvol;
    }
           public void setFfirepumpspeccur(int ffirepumpspeccur){
        this.ffirepumpspeccur=ffirepumpspeccur;
    }
	   public int getFfirepumpspeccur(){
      return ffirepumpspeccur;
    }
           public void setFfirepumppulcur(int ffirepumppulcur){
        this.ffirepumppulcur=ffirepumppulcur;
    }
	   public int getFfirepumppulcur(){
      return ffirepumppulcur;
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
           public void setZparaauxtrf2(com.techstar.dmis.dto.EtsEquipmentDto zparaauxtrf2){
        this.zparaauxtrf2=zparaauxtrf2;
    }
	   public com.techstar.dmis.dto.EtsEquipmentDto getZparaauxtrf2(){
      return zparaauxtrf2;
    }
      
  

}