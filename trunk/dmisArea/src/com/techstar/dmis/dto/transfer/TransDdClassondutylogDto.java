package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 调度交接班记录
 * This classe is based on ValueObject Pattern
 */
public class TransDdClassondutylogDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDdClassondutylogDto() {
    }
	
          private java.sql.Timestamp fsuccessiontime; //值班开始时间
          private java.sql.Timestamp fhandovertime; //值班结束时间
          private String fminister; //接班值长
          private String fmainattendant; //接班正值
          private String fsecondattendant; //接班副值
          private String fdelresponser; //交班值长
          private String fdelworkgroup; //交班正值
          private String fdelattworkgroup; //交班副值
          private String fforecast; //气象情况
          private String fdelivercnt; //交接内容
              private String sys_fille; //填写人
          private String sys_filldept; //填写单位
          private java.sql.Timestamp sys_filltime; //填写时间
          private int sys_isvalid; //是否有效字段
          private String sys_dataowner; //数据所属单位
          private String fworkshift; //班次
          private String fid; //班志编号
          private int version; //数据库版本控制
          private java.util.Collection fddpowerplantoperlog4; //班志编号
          private java.util.Collection fddoperationnotebook4; //班志编号
          private java.util.Collection fddsasusprecord3; //班志编号
          private java.util.Collection fddwaterheight3; //班志编号
          private java.util.Collection fddwaterproofplan2; //班志编号
          private java.util.Collection fddhloadrecord4; //班志编号
          private java.util.Collection fddpowerchangrecord4; //班志编号
          private java.util.Collection fddhpoweroperaterrd5; //班志编号
    	 
	
   /**
     * getters and setters
     */
            public void setFsuccessiontime(java.sql.Timestamp fsuccessiontime){
        this.fsuccessiontime=fsuccessiontime;
    }
	   public java.sql.Timestamp getFsuccessiontime(){
      return fsuccessiontime;
    }
             public void setFhandovertime(java.sql.Timestamp fhandovertime){
        this.fhandovertime=fhandovertime;
    }
	   public java.sql.Timestamp getFhandovertime(){
      return fhandovertime;
    }
             public void setFminister(String fminister){
        this.fminister=fminister;
    }
	   public String getFminister(){
      return fminister;
    }
             public void setFmainattendant(String fmainattendant){
        this.fmainattendant=fmainattendant;
    }
	   public String getFmainattendant(){
      return fmainattendant;
    }
             public void setFsecondattendant(String fsecondattendant){
        this.fsecondattendant=fsecondattendant;
    }
	   public String getFsecondattendant(){
      return fsecondattendant;
    }
             public void setFdelresponser(String fdelresponser){
        this.fdelresponser=fdelresponser;
    }
	   public String getFdelresponser(){
      return fdelresponser;
    }
             public void setFdelworkgroup(String fdelworkgroup){
        this.fdelworkgroup=fdelworkgroup;
    }
	   public String getFdelworkgroup(){
      return fdelworkgroup;
    }
             public void setFdelattworkgroup(String fdelattworkgroup){
        this.fdelattworkgroup=fdelattworkgroup;
    }
	   public String getFdelattworkgroup(){
      return fdelattworkgroup;
    }
             public void setFforecast(String fforecast){
        this.fforecast=fforecast;
    }
	   public String getFforecast(){
      return fforecast;
    }
             public void setFdelivercnt(String fdelivercnt){
        this.fdelivercnt=fdelivercnt;
    }
	   public String getFdelivercnt(){
      return fdelivercnt;
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
             public void setFworkshift(String fworkshift){
        this.fworkshift=fworkshift;
    }
	   public String getFworkshift(){
      return fworkshift;
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
             public void setFddpowerplantoperlog4(java.util.Collection fddpowerplantoperlog4){
        this.fddpowerplantoperlog4=fddpowerplantoperlog4;
    }
	   public java.util.Collection getFddpowerplantoperlog4(){
      return fddpowerplantoperlog4;
    }
             public void setFddoperationnotebook4(java.util.Collection fddoperationnotebook4){
        this.fddoperationnotebook4=fddoperationnotebook4;
    }
	   public java.util.Collection getFddoperationnotebook4(){
      return fddoperationnotebook4;
    }
             public void setFddsasusprecord3(java.util.Collection fddsasusprecord3){
        this.fddsasusprecord3=fddsasusprecord3;
    }
	   public java.util.Collection getFddsasusprecord3(){
      return fddsasusprecord3;
    }
             public void setFddwaterheight3(java.util.Collection fddwaterheight3){
        this.fddwaterheight3=fddwaterheight3;
    }
	   public java.util.Collection getFddwaterheight3(){
      return fddwaterheight3;
    }
             public void setFddwaterproofplan2(java.util.Collection fddwaterproofplan2){
        this.fddwaterproofplan2=fddwaterproofplan2;
    }
	   public java.util.Collection getFddwaterproofplan2(){
      return fddwaterproofplan2;
    }
             public void setFddhloadrecord4(java.util.Collection fddhloadrecord4){
        this.fddhloadrecord4=fddhloadrecord4;
    }
	   public java.util.Collection getFddhloadrecord4(){
      return fddhloadrecord4;
    }
             public void setFddpowerchangrecord4(java.util.Collection fddpowerchangrecord4){
        this.fddpowerchangrecord4=fddpowerchangrecord4;
    }
	   public java.util.Collection getFddpowerchangrecord4(){
      return fddpowerchangrecord4;
    }
             public void setFddhpoweroperaterrd5(java.util.Collection fddhpoweroperaterrd5){
        this.fddhpoweroperaterrd5=fddhpoweroperaterrd5;
    }
	   public java.util.Collection getFddhpoweroperaterrd5(){
      return fddhpoweroperaterrd5;
    }
       
  

}