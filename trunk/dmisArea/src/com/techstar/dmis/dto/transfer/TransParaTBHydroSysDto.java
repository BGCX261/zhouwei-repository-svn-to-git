package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 汽轮机液压调速系统
 * This classe is based on ValueObject Pattern
 */
public class TransParaTBHydroSysDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransParaTBHydroSysDto() {
    }
	
          private int fsysspdchgratio; //系统速度变动率%
          private int fsysslowratio; //系统迟缓率%
          private int fhareaspdchgratio; //高负荷区域局部速度变动率%
          private int fspeedertimes; //调速器时间s
          private int fhdooropenspd; //高压调门开启速度／时间s
          private int fhdoorclsspd; //高压调门关闭速度／时间s
          private int fhdoormaxclsspd; //高压调门最大关闭速度2/s
          private String feqpid; //设备ID
          private int version; //数据库版本控制
          private String trans_zparatbhydrosys2; //设备ID
    	 
	
   /**
     * getters and setters
     */
            public void setFsysspdchgratio(int fsysspdchgratio){
        this.fsysspdchgratio=fsysspdchgratio;
    }
	   public int getFsysspdchgratio(){
      return fsysspdchgratio;
    }
             public void setFsysslowratio(int fsysslowratio){
        this.fsysslowratio=fsysslowratio;
    }
	   public int getFsysslowratio(){
      return fsysslowratio;
    }
             public void setFhareaspdchgratio(int fhareaspdchgratio){
        this.fhareaspdchgratio=fhareaspdchgratio;
    }
	   public int getFhareaspdchgratio(){
      return fhareaspdchgratio;
    }
             public void setFspeedertimes(int fspeedertimes){
        this.fspeedertimes=fspeedertimes;
    }
	   public int getFspeedertimes(){
      return fspeedertimes;
    }
             public void setFhdooropenspd(int fhdooropenspd){
        this.fhdooropenspd=fhdooropenspd;
    }
	   public int getFhdooropenspd(){
      return fhdooropenspd;
    }
             public void setFhdoorclsspd(int fhdoorclsspd){
        this.fhdoorclsspd=fhdoorclsspd;
    }
	   public int getFhdoorclsspd(){
      return fhdoorclsspd;
    }
             public void setFhdoormaxclsspd(int fhdoormaxclsspd){
        this.fhdoormaxclsspd=fhdoormaxclsspd;
    }
	   public int getFhdoormaxclsspd(){
      return fhdoormaxclsspd;
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
             public void setTrans_zparatbhydrosys2(String trans_zparatbhydrosys2){
        this.trans_zparatbhydrosys2=trans_zparatbhydrosys2;
    }
	   public String getTrans_zparatbhydrosys2(){
      return trans_zparatbhydrosys2;
    }
       
  

}