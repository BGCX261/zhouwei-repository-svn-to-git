package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 水轮机参数
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaWaterTBDto  implements Serializable {
    
	public ParaWaterTBDto() {
    }
	
          private String fpowerplan; //电厂名称
	      private String fpowerunitno; //机组编号
	      private String fpowerunitmode; //机组型号
	      private int fpowerunitcapa; //机组容量
	      private String fwatertbfactory; //水轮机生产厂家
	      private String fwatertbtype; //水轮机类型
	      private int fwaterintertiatimes; //水流惯性时间常数s
	      private int ftbintertiatimes; //机组惯性时间常数s
	      private int ftbmaxoutpower; //机组最大输出功率%
	      private int ftbidlerpower; //机组空载功耗%
	      private String feqpid; //设备ID
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.EtsEquipmentDto zparawatertb2; //设备ID
		 

  	
	
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
           public void setFpowerunitmode(String fpowerunitmode){
        this.fpowerunitmode=fpowerunitmode;
    }
	   public String getFpowerunitmode(){
      return fpowerunitmode;
    }
           public void setFpowerunitcapa(int fpowerunitcapa){
        this.fpowerunitcapa=fpowerunitcapa;
    }
	   public int getFpowerunitcapa(){
      return fpowerunitcapa;
    }
           public void setFwatertbfactory(String fwatertbfactory){
        this.fwatertbfactory=fwatertbfactory;
    }
	   public String getFwatertbfactory(){
      return fwatertbfactory;
    }
           public void setFwatertbtype(String fwatertbtype){
        this.fwatertbtype=fwatertbtype;
    }
	   public String getFwatertbtype(){
      return fwatertbtype;
    }
           public void setFwaterintertiatimes(int fwaterintertiatimes){
        this.fwaterintertiatimes=fwaterintertiatimes;
    }
	   public int getFwaterintertiatimes(){
      return fwaterintertiatimes;
    }
           public void setFtbintertiatimes(int ftbintertiatimes){
        this.ftbintertiatimes=ftbintertiatimes;
    }
	   public int getFtbintertiatimes(){
      return ftbintertiatimes;
    }
           public void setFtbmaxoutpower(int ftbmaxoutpower){
        this.ftbmaxoutpower=ftbmaxoutpower;
    }
	   public int getFtbmaxoutpower(){
      return ftbmaxoutpower;
    }
           public void setFtbidlerpower(int ftbidlerpower){
        this.ftbidlerpower=ftbidlerpower;
    }
	   public int getFtbidlerpower(){
      return ftbidlerpower;
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
           public void setZparawatertb2(com.techstar.dmis.dto.EtsEquipmentDto zparawatertb2){
        this.zparawatertb2=zparawatertb2;
    }
	   public com.techstar.dmis.dto.EtsEquipmentDto getZparawatertb2(){
      return zparawatertb2;
    }
      
  

}