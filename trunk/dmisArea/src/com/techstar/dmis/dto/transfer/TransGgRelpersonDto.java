package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 外部人员
 * This classe is based on ValueObject Pattern
 */
public class TransGgRelpersonDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransGgRelpersonDto() {
    }
	
          private String name; //姓名
          private String type; //所属分类
          private String telephon; //联系方式
          private String workunit; //工作单位
          private String address; //工作地址
          private String title; //担任职务
          private String remark; //备注
          private String fmobil; //电话mobil
          private String id; //个人iD
          private int version; //数据库版本控制
    	 
	
   /**
     * getters and setters
     */
            public void setName(String name){
        this.name=name;
    }
	   public String getName(){
      return name;
    }
             public void setType(String type){
        this.type=type;
    }
	   public String getType(){
      return type;
    }
             public void setTelephon(String telephon){
        this.telephon=telephon;
    }
	   public String getTelephon(){
      return telephon;
    }
             public void setWorkunit(String workunit){
        this.workunit=workunit;
    }
	   public String getWorkunit(){
      return workunit;
    }
             public void setAddress(String address){
        this.address=address;
    }
	   public String getAddress(){
      return address;
    }
             public void setTitle(String title){
        this.title=title;
    }
	   public String getTitle(){
      return title;
    }
             public void setRemark(String remark){
        this.remark=remark;
    }
	   public String getRemark(){
      return remark;
    }
             public void setFmobil(String fmobil){
        this.fmobil=fmobil;
    }
	   public String getFmobil(){
      return fmobil;
    }
             public void setId(String id){
        this.id=id;
    }
	   public String getId(){
      return id;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
       
  

}