package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 用户
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class StdConsumerDto extends DictionaryBaseDto implements Serializable {
    
	public StdConsumerDto() {
    }
	
          private String consumername; //用户名称
	      private String shortname; //用户简称
	      private String grade; //客户等级
	      private String consumer; //客户联系人
	      private String telephon; //客户电话
	      private String address; //客户地址
	      private String zipcode; //客户邮编
	      private String manageunitno; //管辖供电公司名称
	      private String dispathunitno; //调度单位名称
	      private int version; //数据库版本控制
		 

  	
	
   /**
     * getters and setters
     */
           public void setConsumername(String consumername){
        this.consumername=consumername;
    }
	   public String getConsumername(){
      return consumername;
    }
           public void setShortname(String shortname){
        this.shortname=shortname;
    }
	   public String getShortname(){
      return shortname;
    }
           public void setGrade(String grade){
        this.grade=grade;
    }
	   public String getGrade(){
      return grade;
    }
           public void setConsumer(String consumer){
        this.consumer=consumer;
    }
	   public String getConsumer(){
      return consumer;
    }
           public void setTelephon(String telephon){
        this.telephon=telephon;
    }
	   public String getTelephon(){
      return telephon;
    }
           public void setAddress(String address){
        this.address=address;
    }
	   public String getAddress(){
      return address;
    }
           public void setZipcode(String zipcode){
        this.zipcode=zipcode;
    }
	   public String getZipcode(){
      return zipcode;
    }
           public void setManageunitno(String manageunitno){
        this.manageunitno=manageunitno;
    }
	   public String getManageunitno(){
      return manageunitno;
    }
           public void setDispathunitno(String dispathunitno){
        this.dispathunitno=dispathunitno;
    }
	   public String getDispathunitno(){
      return dispathunitno;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
      
  

}