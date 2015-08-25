package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 发电批准书
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class FsApprovebookDto  implements Serializable {
    
	public FsApprovebookDto() {
    }
	
          private String fapprovbookno; //正式编号
	      private String fstationname; //厂站名
	      private String fprojectname; //工程名称
	      private java.sql.Date fgenerationtime; //发电日期
	      private String fprojectunit; //工程单位
	      private String fsendtounit; //抄送单位
	      private java.sql.Date fcompletiondate; //完成时间
	      private String fproblem; //执行过程说明
	      private String fstatus; //流转状态
	      private String fstationid; //厂站编号
	      private String fwriterunit; //批准书编制单位
	      private byte[] feqpcontent; //设备信息
	      private String sys_fille; //填写人
	      private String sys_filldept; //填写单位
	      private java.sql.Timestamp sys_filltime; //填写时间
	      private int sys_isvalid; //是否有效字段
	      private String sys_dataowner; //数据所属单位
	      private String fvoltage; //电压等级
	      private String fexcutestatus; //执行状态
	      private String fapprovcomputerno; //批准书内部编号
	      private int version; //数据库版本控制
	      private java.util.Collection ffsapprovebookdetail1; //批准书内部编号
	      private java.util.Collection ffsafrel1; //批准书内部编号
	      private java.util.Collection ffsapproveeqprel1; //批准书内部编号
	      private java.util.Collection ffsallappendix1; //批准书内部编号
	      private com.techstar.dmis.dto.BhAsregulateDto zfsapprovebook6; //自投规程编号
		 

  	
	
   /**
     * getters and setters
     */
           public void setFapprovbookno(String fapprovbookno){
        this.fapprovbookno=fapprovbookno;
    }
	   public String getFapprovbookno(){
      return fapprovbookno;
    }
           public void setFstationname(String fstationname){
        this.fstationname=fstationname;
    }
	   public String getFstationname(){
      return fstationname;
    }
           public void setFprojectname(String fprojectname){
        this.fprojectname=fprojectname;
    }
	   public String getFprojectname(){
      return fprojectname;
    }
           public void setFgenerationtime(java.sql.Date fgenerationtime){
        this.fgenerationtime=fgenerationtime;
    }
	   public java.sql.Date getFgenerationtime(){
      return fgenerationtime;
    }
           public void setFprojectunit(String fprojectunit){
        this.fprojectunit=fprojectunit;
    }
	   public String getFprojectunit(){
      return fprojectunit;
    }
           public void setFsendtounit(String fsendtounit){
        this.fsendtounit=fsendtounit;
    }
	   public String getFsendtounit(){
      return fsendtounit;
    }
           public void setFcompletiondate(java.sql.Date fcompletiondate){
        this.fcompletiondate=fcompletiondate;
    }
	   public java.sql.Date getFcompletiondate(){
      return fcompletiondate;
    }
           public void setFproblem(String fproblem){
        this.fproblem=fproblem;
    }
	   public String getFproblem(){
      return fproblem;
    }
           public void setFstatus(String fstatus){
        this.fstatus=fstatus;
    }
	   public String getFstatus(){
      return fstatus;
    }
           public void setFstationid(String fstationid){
        this.fstationid=fstationid;
    }
	   public String getFstationid(){
      return fstationid;
    }
           public void setFwriterunit(String fwriterunit){
        this.fwriterunit=fwriterunit;
    }
	   public String getFwriterunit(){
      return fwriterunit;
    }
           public void setFeqpcontent(byte[] feqpcontent){
        this.feqpcontent=feqpcontent;
    }
	   public byte[] getFeqpcontent(){
      return feqpcontent;
    }
           public void setSys_fille(String sys_fille){
        this.sys_fille=sys_fille;
    }
	   public String getSys_fille(){
      return sys_fille;
    }
           public void setSys_filldept(String sys_filldept){
        this.sys_filldept=sys_filldept;
    }
	   public String getSys_filldept(){
      return sys_filldept;
    }
           public void setSys_filltime(java.sql.Timestamp sys_filltime){
        this.sys_filltime=sys_filltime;
    }
	   public java.sql.Timestamp getSys_filltime(){
      return sys_filltime;
    }
           public void setSys_isvalid(int sys_isvalid){
        this.sys_isvalid=sys_isvalid;
    }
	   public int getSys_isvalid(){
      return sys_isvalid;
    }
           public void setSys_dataowner(String sys_dataowner){
        this.sys_dataowner=sys_dataowner;
    }
	   public String getSys_dataowner(){
      return sys_dataowner;
    }
           public void setFvoltage(String fvoltage){
        this.fvoltage=fvoltage;
    }
	   public String getFvoltage(){
      return fvoltage;
    }
           public void setFexcutestatus(String fexcutestatus){
        this.fexcutestatus=fexcutestatus;
    }
	   public String getFexcutestatus(){
      return fexcutestatus;
    }
           public void setFapprovcomputerno(String fapprovcomputerno){
        this.fapprovcomputerno=fapprovcomputerno;
    }
	   public String getFapprovcomputerno(){
      return fapprovcomputerno;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setFfsapprovebookdetail1(java.util.Collection ffsapprovebookdetail1){
        this.ffsapprovebookdetail1=ffsapprovebookdetail1;
    }
	   public java.util.Collection getFfsapprovebookdetail1(){
      return ffsapprovebookdetail1;
    }
           public void setFfsafrel1(java.util.Collection ffsafrel1){
        this.ffsafrel1=ffsafrel1;
    }
	   public java.util.Collection getFfsafrel1(){
      return ffsafrel1;
    }
           public void setFfsapproveeqprel1(java.util.Collection ffsapproveeqprel1){
        this.ffsapproveeqprel1=ffsapproveeqprel1;
    }
	   public java.util.Collection getFfsapproveeqprel1(){
      return ffsapproveeqprel1;
    }
           public void setFfsallappendix1(java.util.Collection ffsallappendix1){
        this.ffsallappendix1=ffsallappendix1;
    }
	   public java.util.Collection getFfsallappendix1(){
      return ffsallappendix1;
    }
           public void setZfsapprovebook6(com.techstar.dmis.dto.BhAsregulateDto zfsapprovebook6){
        this.zfsapprovebook6=zfsapprovebook6;
    }
	   public com.techstar.dmis.dto.BhAsregulateDto getZfsapprovebook6(){
      return zfsapprovebook6;
    }
      
  

}