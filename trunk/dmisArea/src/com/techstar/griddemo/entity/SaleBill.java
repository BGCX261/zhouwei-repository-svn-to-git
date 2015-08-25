package  com.techstar.griddemo.entity;

import java.io.Serializable;
/**
 * Domain classe for 销售总单
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class SaleBill implements Serializable {
    
	public SaleBill() {
    }
        private java.sql.Date cre_date;
	    private String custom_id;
	    private String custom_name;
	    private String sale_mode;
	    private String tranpriority;
	    private int total;
	    private String memo;
	    private java.sql.Date check_begin_date;
	    private java.sql.Date check_end_date;
	    private byte[] sale_doc;
	    private String id;
	    private int version;
	    private java.util.Collection saledetails;
	    private SaleBillAddr addr;
/**
     * getters and setters
     */
           public void setCre_date(java.sql.Date cre_date){
        this.cre_date=cre_date;
    }
	   public java.sql.Date getCre_date(){
      return cre_date;
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
           public void setSale_mode(String sale_mode){
        this.sale_mode=sale_mode;
    }
	   public String getSale_mode(){
      return sale_mode;
    }
           public void setTranpriority(String tranpriority){
        this.tranpriority=tranpriority;
    }
	   public String getTranpriority(){
      return tranpriority;
    }
           public void setTotal(int total){
        this.total=total;
    }
	   public int getTotal(){
      return total;
    }
           public void setMemo(String memo){
        this.memo=memo;
    }
	   public String getMemo(){
      return memo;
    }
           public void setCheck_begin_date(java.sql.Date check_begin_date){
        this.check_begin_date=check_begin_date;
    }
	   public java.sql.Date getCheck_begin_date(){
      return check_begin_date;
    }
           public void setCheck_end_date(java.sql.Date check_end_date){
        this.check_end_date=check_end_date;
    }
	   public java.sql.Date getCheck_end_date(){
      return check_end_date;
    }
           public void setSale_doc(byte[] sale_doc){
        this.sale_doc=sale_doc;
    }
	   public byte[] getSale_doc(){
      return sale_doc;
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
           public void setSaledetails(java.util.Collection saledetails){
        this.saledetails=saledetails;
    }
	   public java.util.Collection getSaledetails(){
      return saledetails;
    }
	public SaleBillAddr getAddr() {
		return addr;
	}
	public void setAddr(SaleBillAddr addr) {
		this.addr = addr;
	}
      
  

}