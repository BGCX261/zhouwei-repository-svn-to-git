package  com.techstar.griddemo.entity;

import java.io.Serializable;
/**
 * Domain classe for 销售明细
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class SaleDetail implements Serializable {
    
	public SaleDetail() {
    }
        private String print_no;
	    private java.sql.Date print_time;
	    private int goodsqty;
	    private String custom_id;
	    private String custom_name;
	    private java.sql.Date begin_date;
	    private java.sql.Date end_date;
	    private String id;
	    private int version;
	    private com.techstar.griddemo.entity.SaleBill salebill;
		
   /**
     * getters and setters
     */
           public void setPrint_no(String print_no){
        this.print_no=print_no;
    }
	   public String getPrint_no(){
      return print_no;
    }
           public void setPrint_time(java.sql.Date print_time){
        this.print_time=print_time;
    }
	   public java.sql.Date getPrint_time(){
      return print_time;
    }
           public void setGoodsqty(int goodsqty){
        this.goodsqty=goodsqty;
    }
	   public int getGoodsqty(){
      return goodsqty;
    }
           public void setCustom_id(String custom_id){
        this.custom_id=custom_id;
    }
	   public String getCustom_id(){
      return custom_id;
    }
           public void setCustom_name(String custom_name){
        this.custom_name=custom_name;
    }
	   public String getCustom_name(){
      return custom_name;
    }
           public void setBegin_date(java.sql.Date begin_date){
        this.begin_date=begin_date;
    }
	   public java.sql.Date getBegin_date(){
      return begin_date;
    }
           public void setEnd_date(java.sql.Date end_date){
        this.end_date=end_date;
    }
	   public java.sql.Date getEnd_date(){
      return end_date;
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
           public void setSalebill(com.techstar.griddemo.entity.SaleBill salebill){
        this.salebill=salebill;
    }
	   public com.techstar.griddemo.entity.SaleBill getSalebill(){
      return salebill;
    }
      
  

}