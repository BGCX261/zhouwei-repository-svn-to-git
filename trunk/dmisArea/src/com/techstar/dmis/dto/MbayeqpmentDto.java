package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 间隔设备映射表
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class MbayeqpmentDto  implements Serializable {
    
	public MbayeqpmentDto() {
    }
	
          private String feqpid; //设备id
	      private String fcimid; //cim模型中的设备id
	      private String fdevclass; //设备大类
	      private String fdispatchnumber; //设备调度号
	      private int fshared; //是否是边界设备
	      private String fid; //主键标示
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.MbayDto zmbayeqpment2; //间隔id
		 

  	
	
   /**
     * getters and setters
     */
           public void setFeqpid(String feqpid){
        this.feqpid=feqpid;
    }
	   public String getFeqpid(){
      return feqpid;
    }
           public void setFcimid(String fcimid){
        this.fcimid=fcimid;
    }
	   public String getFcimid(){
      return fcimid;
    }
           public void setFdevclass(String fdevclass){
        this.fdevclass=fdevclass;
    }
	   public String getFdevclass(){
      return fdevclass;
    }
           public void setFdispatchnumber(String fdispatchnumber){
        this.fdispatchnumber=fdispatchnumber;
    }
	   public String getFdispatchnumber(){
      return fdispatchnumber;
    }
           public void setFshared(int fshared){
        this.fshared=fshared;
    }
	   public int getFshared(){
      return fshared;
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
           public void setZmbayeqpment2(com.techstar.dmis.dto.MbayDto zmbayeqpment2){
        this.zmbayeqpment2=zmbayeqpment2;
    }
	   public com.techstar.dmis.dto.MbayDto getZmbayeqpment2(){
      return zmbayeqpment2;
    }
      
  

}