package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 年低频减载方案的属性清单
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class FsYearlfplanDto  implements Serializable {
    
	public FsYearlfplanDto() {
    }
	
          private int fannual; //年度
	      private String fprogramclass; //方案分类
	      private String funit; //单位
	      private int ffirstvalue; //第一轮值
	      private int fsecondvalue; //第二轮值
	      private int fthirdvalue; //第三轮值
	      private int ffourthvalue; //第四轮值
	      private int ffifthvalue; //第五轮值
	      private int fsixthvalue; //第六轮值
	      private int fseventhvalue; //第七轮值
	      private int fspecialvalue; //特殊轮值
	      private String fprogramid; //方案编号
	      private int version; //数据库版本控制
		 

  	
	
   /**
     * getters and setters
     */
           public void setFannual(int fannual){
        this.fannual=fannual;
    }
	   public int getFannual(){
      return fannual;
    }
           public void setFprogramclass(String fprogramclass){
        this.fprogramclass=fprogramclass;
    }
	   public String getFprogramclass(){
      return fprogramclass;
    }
           public void setFunit(String funit){
        this.funit=funit;
    }
	   public String getFunit(){
      return funit;
    }
           public void setFfirstvalue(int ffirstvalue){
        this.ffirstvalue=ffirstvalue;
    }
	   public int getFfirstvalue(){
      return ffirstvalue;
    }
           public void setFsecondvalue(int fsecondvalue){
        this.fsecondvalue=fsecondvalue;
    }
	   public int getFsecondvalue(){
      return fsecondvalue;
    }
           public void setFthirdvalue(int fthirdvalue){
        this.fthirdvalue=fthirdvalue;
    }
	   public int getFthirdvalue(){
      return fthirdvalue;
    }
           public void setFfourthvalue(int ffourthvalue){
        this.ffourthvalue=ffourthvalue;
    }
	   public int getFfourthvalue(){
      return ffourthvalue;
    }
           public void setFfifthvalue(int ffifthvalue){
        this.ffifthvalue=ffifthvalue;
    }
	   public int getFfifthvalue(){
      return ffifthvalue;
    }
           public void setFsixthvalue(int fsixthvalue){
        this.fsixthvalue=fsixthvalue;
    }
	   public int getFsixthvalue(){
      return fsixthvalue;
    }
           public void setFseventhvalue(int fseventhvalue){
        this.fseventhvalue=fseventhvalue;
    }
	   public int getFseventhvalue(){
      return fseventhvalue;
    }
           public void setFspecialvalue(int fspecialvalue){
        this.fspecialvalue=fspecialvalue;
    }
	   public int getFspecialvalue(){
      return fspecialvalue;
    }
           public void setFprogramid(String fprogramid){
        this.fprogramid=fprogramid;
    }
	   public String getFprogramid(){
      return fprogramid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
      
  

}