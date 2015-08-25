package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 发电机及其励磁系统
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaGeneratorDto  implements Serializable {
    
	public ParaGeneratorDto() {
    }
	
          private String fpowerplan; //电厂名称
	      private String fpowerunitno; //机组编号
	      private int fpowerunitcapa; //机组容量
	      private String fgenmode; //发电机型号
	      private int fgeninertia; //发电机组转动惯量秒
	      private int fhavepower; //发电机有功功率MW
	      private int fidlepower; //发电机无功功率Mvar
	      private int fspecpower; //额定功率因数
	      private int fspecvol; //额定机端电压kV
	      private int fspeccurrent; //额定电流A
	      private int frotorspecpower; //转子额定电压V
	      private int frotorspeccur; //转子额定电流A
	      private int fidlerotorspecvol; //空载额定转子电压V
	      private int fidlerotorspeccur; //空载额定转子电流A
	      private int fdsynresistance; //直轴同步电抗PU
	      private int fasynresistance; //交轴同步电抗PU
	      private int fatempresistance; //直轴暂态电抗PU
	      private int fdtempresistance; //交轴暂态电抗PU
	      private int fasectempresistance; //直轴次暂态电抗PU
	      private int fdsectempresistance; //交轴次暂态电抗PU
	      private int fpownegseqresi; //发电机负序电抗PU
	      private int fpowzerseqresi; //发电机零序电抗PU
	      private int fatempresistancets; //直轴开路暂态时常数秒
	      private int fdtempresistancets; //交轴开路暂态时常数秒
	      private int frotorresistance; //76℃转子直阻Ω
	      private int faotempresistimes; //直轴开路次暂态时间常数秒
	      private int fdotempresistimes; //交轴开路次暂态时间常数秒
	      private int fastempresistimes; //直轴短路暂态时常数秒
	      private int fdstempresistimes; //交轴短路暂态时常数秒
	      private int fasstempresistimes; //直轴短路次暂态时间常数秒
	      private int fdsstempresistimes; //交轴短路次暂态时间常数秒
	      private String fexcitationstyle; //励磁方式
	      private String fexcitationmode; //励磁机型号
	      private int fexcitationspeccapa; //励磁机额定容量KVA
	      private int fexcitationrate; //励磁机频率HZ
	      private int fratefactor; //功率因数
	      private int fspecoutputvol; //额定输出电压V
	      private int fspecoutputcur; //额定输出电流A
	      private int fspecfieldvol; //额定励磁电压V
	      private int fspecfieldcur; //额定励磁电流A
	      private int fexcitationresis; //励磁机同步电抗PU
	      private int ftempsynresis; //暂态同步电抗PU
	      private int fsectempsynresis; //次暂态同步电抗PU
	      private int fexcitationnsresis; //励磁机负序电抗PU
	      private int fexciwindstiff; //76℃励磁绕组直阻Ω
	      private int frotortimes; //转子时间常数秒
	      private int frotordiverratio; //转子分流器变比A/mv
	      private String fmagnetmode; //永磁机型号
	      private int fmagnetcapa; //永磁机容量kVA
	      private int fmagnetspecratio; //永磁机额定频率HZ
	      private int fmagnetspecvol; //永磁机额定电压V
	      private int fmagnetspeccur; //永磁机额定电流A
	      private int fmagnetpowerratio; //永磁机功率因数
	      private int fgenfixtimeexcivol; //发电机空载额定时励磁电压V
	      private int fgenfixtimeexcicur; //发电机空载额定时励磁电流A
	      private int fexcifixtimevol; //励磁机空载额定时励磁电压V
	      private int fexcifixtimecur; //励磁机空载额定时励磁电流A
	      private String feqpid; //设备ID
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.EtsEquipmentDto zparagenerator2; //设备ID
		 

  	
	
   /**
     * getters and setters
     */
           public void setFpowerplan(String fpowerplan){
        this.fpowerplan=fpowerplan;
    }
	   public String getFpowerplan(){
      return fpowerplan;
    }
           public void setFpowerunitno(String fpowerunitno){
        this.fpowerunitno=fpowerunitno;
    }
	   public String getFpowerunitno(){
      return fpowerunitno;
    }
           public void setFpowerunitcapa(int fpowerunitcapa){
        this.fpowerunitcapa=fpowerunitcapa;
    }
	   public int getFpowerunitcapa(){
      return fpowerunitcapa;
    }
           public void setFgenmode(String fgenmode){
        this.fgenmode=fgenmode;
    }
	   public String getFgenmode(){
      return fgenmode;
    }
           public void setFgeninertia(int fgeninertia){
        this.fgeninertia=fgeninertia;
    }
	   public int getFgeninertia(){
      return fgeninertia;
    }
           public void setFhavepower(int fhavepower){
        this.fhavepower=fhavepower;
    }
	   public int getFhavepower(){
      return fhavepower;
    }
           public void setFidlepower(int fidlepower){
        this.fidlepower=fidlepower;
    }
	   public int getFidlepower(){
      return fidlepower;
    }
           public void setFspecpower(int fspecpower){
        this.fspecpower=fspecpower;
    }
	   public int getFspecpower(){
      return fspecpower;
    }
           public void setFspecvol(int fspecvol){
        this.fspecvol=fspecvol;
    }
	   public int getFspecvol(){
      return fspecvol;
    }
           public void setFspeccurrent(int fspeccurrent){
        this.fspeccurrent=fspeccurrent;
    }
	   public int getFspeccurrent(){
      return fspeccurrent;
    }
           public void setFrotorspecpower(int frotorspecpower){
        this.frotorspecpower=frotorspecpower;
    }
	   public int getFrotorspecpower(){
      return frotorspecpower;
    }
           public void setFrotorspeccur(int frotorspeccur){
        this.frotorspeccur=frotorspeccur;
    }
	   public int getFrotorspeccur(){
      return frotorspeccur;
    }
           public void setFidlerotorspecvol(int fidlerotorspecvol){
        this.fidlerotorspecvol=fidlerotorspecvol;
    }
	   public int getFidlerotorspecvol(){
      return fidlerotorspecvol;
    }
           public void setFidlerotorspeccur(int fidlerotorspeccur){
        this.fidlerotorspeccur=fidlerotorspeccur;
    }
	   public int getFidlerotorspeccur(){
      return fidlerotorspeccur;
    }
           public void setFdsynresistance(int fdsynresistance){
        this.fdsynresistance=fdsynresistance;
    }
	   public int getFdsynresistance(){
      return fdsynresistance;
    }
           public void setFasynresistance(int fasynresistance){
        this.fasynresistance=fasynresistance;
    }
	   public int getFasynresistance(){
      return fasynresistance;
    }
           public void setFatempresistance(int fatempresistance){
        this.fatempresistance=fatempresistance;
    }
	   public int getFatempresistance(){
      return fatempresistance;
    }
           public void setFdtempresistance(int fdtempresistance){
        this.fdtempresistance=fdtempresistance;
    }
	   public int getFdtempresistance(){
      return fdtempresistance;
    }
           public void setFasectempresistance(int fasectempresistance){
        this.fasectempresistance=fasectempresistance;
    }
	   public int getFasectempresistance(){
      return fasectempresistance;
    }
           public void setFdsectempresistance(int fdsectempresistance){
        this.fdsectempresistance=fdsectempresistance;
    }
	   public int getFdsectempresistance(){
      return fdsectempresistance;
    }
           public void setFpownegseqresi(int fpownegseqresi){
        this.fpownegseqresi=fpownegseqresi;
    }
	   public int getFpownegseqresi(){
      return fpownegseqresi;
    }
           public void setFpowzerseqresi(int fpowzerseqresi){
        this.fpowzerseqresi=fpowzerseqresi;
    }
	   public int getFpowzerseqresi(){
      return fpowzerseqresi;
    }
           public void setFatempresistancets(int fatempresistancets){
        this.fatempresistancets=fatempresistancets;
    }
	   public int getFatempresistancets(){
      return fatempresistancets;
    }
           public void setFdtempresistancets(int fdtempresistancets){
        this.fdtempresistancets=fdtempresistancets;
    }
	   public int getFdtempresistancets(){
      return fdtempresistancets;
    }
           public void setFrotorresistance(int frotorresistance){
        this.frotorresistance=frotorresistance;
    }
	   public int getFrotorresistance(){
      return frotorresistance;
    }
           public void setFaotempresistimes(int faotempresistimes){
        this.faotempresistimes=faotempresistimes;
    }
	   public int getFaotempresistimes(){
      return faotempresistimes;
    }
           public void setFdotempresistimes(int fdotempresistimes){
        this.fdotempresistimes=fdotempresistimes;
    }
	   public int getFdotempresistimes(){
      return fdotempresistimes;
    }
           public void setFastempresistimes(int fastempresistimes){
        this.fastempresistimes=fastempresistimes;
    }
	   public int getFastempresistimes(){
      return fastempresistimes;
    }
           public void setFdstempresistimes(int fdstempresistimes){
        this.fdstempresistimes=fdstempresistimes;
    }
	   public int getFdstempresistimes(){
      return fdstempresistimes;
    }
           public void setFasstempresistimes(int fasstempresistimes){
        this.fasstempresistimes=fasstempresistimes;
    }
	   public int getFasstempresistimes(){
      return fasstempresistimes;
    }
           public void setFdsstempresistimes(int fdsstempresistimes){
        this.fdsstempresistimes=fdsstempresistimes;
    }
	   public int getFdsstempresistimes(){
      return fdsstempresistimes;
    }
           public void setFexcitationstyle(String fexcitationstyle){
        this.fexcitationstyle=fexcitationstyle;
    }
	   public String getFexcitationstyle(){
      return fexcitationstyle;
    }
           public void setFexcitationmode(String fexcitationmode){
        this.fexcitationmode=fexcitationmode;
    }
	   public String getFexcitationmode(){
      return fexcitationmode;
    }
           public void setFexcitationspeccapa(int fexcitationspeccapa){
        this.fexcitationspeccapa=fexcitationspeccapa;
    }
	   public int getFexcitationspeccapa(){
      return fexcitationspeccapa;
    }
           public void setFexcitationrate(int fexcitationrate){
        this.fexcitationrate=fexcitationrate;
    }
	   public int getFexcitationrate(){
      return fexcitationrate;
    }
           public void setFratefactor(int fratefactor){
        this.fratefactor=fratefactor;
    }
	   public int getFratefactor(){
      return fratefactor;
    }
           public void setFspecoutputvol(int fspecoutputvol){
        this.fspecoutputvol=fspecoutputvol;
    }
	   public int getFspecoutputvol(){
      return fspecoutputvol;
    }
           public void setFspecoutputcur(int fspecoutputcur){
        this.fspecoutputcur=fspecoutputcur;
    }
	   public int getFspecoutputcur(){
      return fspecoutputcur;
    }
           public void setFspecfieldvol(int fspecfieldvol){
        this.fspecfieldvol=fspecfieldvol;
    }
	   public int getFspecfieldvol(){
      return fspecfieldvol;
    }
           public void setFspecfieldcur(int fspecfieldcur){
        this.fspecfieldcur=fspecfieldcur;
    }
	   public int getFspecfieldcur(){
      return fspecfieldcur;
    }
           public void setFexcitationresis(int fexcitationresis){
        this.fexcitationresis=fexcitationresis;
    }
	   public int getFexcitationresis(){
      return fexcitationresis;
    }
           public void setFtempsynresis(int ftempsynresis){
        this.ftempsynresis=ftempsynresis;
    }
	   public int getFtempsynresis(){
      return ftempsynresis;
    }
           public void setFsectempsynresis(int fsectempsynresis){
        this.fsectempsynresis=fsectempsynresis;
    }
	   public int getFsectempsynresis(){
      return fsectempsynresis;
    }
           public void setFexcitationnsresis(int fexcitationnsresis){
        this.fexcitationnsresis=fexcitationnsresis;
    }
	   public int getFexcitationnsresis(){
      return fexcitationnsresis;
    }
           public void setFexciwindstiff(int fexciwindstiff){
        this.fexciwindstiff=fexciwindstiff;
    }
	   public int getFexciwindstiff(){
      return fexciwindstiff;
    }
           public void setFrotortimes(int frotortimes){
        this.frotortimes=frotortimes;
    }
	   public int getFrotortimes(){
      return frotortimes;
    }
           public void setFrotordiverratio(int frotordiverratio){
        this.frotordiverratio=frotordiverratio;
    }
	   public int getFrotordiverratio(){
      return frotordiverratio;
    }
           public void setFmagnetmode(String fmagnetmode){
        this.fmagnetmode=fmagnetmode;
    }
	   public String getFmagnetmode(){
      return fmagnetmode;
    }
           public void setFmagnetcapa(int fmagnetcapa){
        this.fmagnetcapa=fmagnetcapa;
    }
	   public int getFmagnetcapa(){
      return fmagnetcapa;
    }
           public void setFmagnetspecratio(int fmagnetspecratio){
        this.fmagnetspecratio=fmagnetspecratio;
    }
	   public int getFmagnetspecratio(){
      return fmagnetspecratio;
    }
           public void setFmagnetspecvol(int fmagnetspecvol){
        this.fmagnetspecvol=fmagnetspecvol;
    }
	   public int getFmagnetspecvol(){
      return fmagnetspecvol;
    }
           public void setFmagnetspeccur(int fmagnetspeccur){
        this.fmagnetspeccur=fmagnetspeccur;
    }
	   public int getFmagnetspeccur(){
      return fmagnetspeccur;
    }
           public void setFmagnetpowerratio(int fmagnetpowerratio){
        this.fmagnetpowerratio=fmagnetpowerratio;
    }
	   public int getFmagnetpowerratio(){
      return fmagnetpowerratio;
    }
           public void setFgenfixtimeexcivol(int fgenfixtimeexcivol){
        this.fgenfixtimeexcivol=fgenfixtimeexcivol;
    }
	   public int getFgenfixtimeexcivol(){
      return fgenfixtimeexcivol;
    }
           public void setFgenfixtimeexcicur(int fgenfixtimeexcicur){
        this.fgenfixtimeexcicur=fgenfixtimeexcicur;
    }
	   public int getFgenfixtimeexcicur(){
      return fgenfixtimeexcicur;
    }
           public void setFexcifixtimevol(int fexcifixtimevol){
        this.fexcifixtimevol=fexcifixtimevol;
    }
	   public int getFexcifixtimevol(){
      return fexcifixtimevol;
    }
           public void setFexcifixtimecur(int fexcifixtimecur){
        this.fexcifixtimecur=fexcifixtimecur;
    }
	   public int getFexcifixtimecur(){
      return fexcifixtimecur;
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
           public void setZparagenerator2(com.techstar.dmis.dto.EtsEquipmentDto zparagenerator2){
        this.zparagenerator2=zparagenerator2;
    }
	   public com.techstar.dmis.dto.EtsEquipmentDto getZparagenerator2(){
      return zparagenerator2;
    }
      
  

}