package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 自动化系统
 * This classe is based on ValueObject Pattern
 */
public class TransParaDCSysInfoDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransParaDCSysInfoDto() {
    }
	
          private String fsystemname; //系统名称
          private String fsystemclass; //系统类型
          private String fmanufacturers; //集成厂商
          private String fsystemmodels; //系统型号
          private String fsoftwareversion; //软件版本
          private String fdatabasetype; //数据库类型
          private String felectricsubstation; //安装地点
          private int fmoney; //合同额万元
          private String fmainfunction; //主要功能
          private int fcalculatorquantity; //计算机数量台
          private int fsonstationquantity; //相连子站数台
          private String fid; //设备ID
          private int version; //数据库版本控制
          private String trans_zparadcsysinfo2; //设备ID
    	 
	
   /**
     * getters and setters
     */
            public void setFsystemname(String fsystemname){
        this.fsystemname=fsystemname;
    }
	   public String getFsystemname(){
      return fsystemname;
    }
             public void setFsystemclass(String fsystemclass){
        this.fsystemclass=fsystemclass;
    }
	   public String getFsystemclass(){
      return fsystemclass;
    }
             public void setFmanufacturers(String fmanufacturers){
        this.fmanufacturers=fmanufacturers;
    }
	   public String getFmanufacturers(){
      return fmanufacturers;
    }
             public void setFsystemmodels(String fsystemmodels){
        this.fsystemmodels=fsystemmodels;
    }
	   public String getFsystemmodels(){
      return fsystemmodels;
    }
             public void setFsoftwareversion(String fsoftwareversion){
        this.fsoftwareversion=fsoftwareversion;
    }
	   public String getFsoftwareversion(){
      return fsoftwareversion;
    }
             public void setFdatabasetype(String fdatabasetype){
        this.fdatabasetype=fdatabasetype;
    }
	   public String getFdatabasetype(){
      return fdatabasetype;
    }
             public void setFelectricsubstation(String felectricsubstation){
        this.felectricsubstation=felectricsubstation;
    }
	   public String getFelectricsubstation(){
      return felectricsubstation;
    }
             public void setFmoney(int fmoney){
        this.fmoney=fmoney;
    }
	   public int getFmoney(){
      return fmoney;
    }
             public void setFmainfunction(String fmainfunction){
        this.fmainfunction=fmainfunction;
    }
	   public String getFmainfunction(){
      return fmainfunction;
    }
             public void setFcalculatorquantity(int fcalculatorquantity){
        this.fcalculatorquantity=fcalculatorquantity;
    }
	   public int getFcalculatorquantity(){
      return fcalculatorquantity;
    }
             public void setFsonstationquantity(int fsonstationquantity){
        this.fsonstationquantity=fsonstationquantity;
    }
	   public int getFsonstationquantity(){
      return fsonstationquantity;
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
             public void setTrans_zparadcsysinfo2(String trans_zparadcsysinfo2){
        this.trans_zparadcsysinfo2=trans_zparadcsysinfo2;
    }
	   public String getTrans_zparadcsysinfo2(){
      return trans_zparadcsysinfo2;
    }
       
  

}