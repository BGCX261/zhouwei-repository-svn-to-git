package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 系统图修改记录
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ZdhCharalterrecordDto  implements Serializable {
    
	public ZdhCharalterrecordDto() {
    }
	
          private String taskexplanation; //工作任务说明
	      private String modexplanation; //图形修改工作说明
	      private int linediagramamount; //修改线路图数量
	      private int stationdiagramamount; //修改厂站图数量
	      private String accompanyingmap; //改图说明
	      private byte[] mdiagram; //修改后图
	      private int newtrfnum; //新发变压器数量
	      private int newbusnum; //新增母线数量
	      private int newswitchnum; //新增开关数量
	      private int newothersnum; //新发其它数量
	      private int newplantnum; //新发电厂数量
	      private int changtrmnum; //变压器切改数量
	      private int changbusnum; //母线切改数量
	      private int outtrfnum; //变压器退运数量
	      private int outbusnum; //母线退运数量
	      private int outswitchnum; //开关退运数量
	      private int bak1; //备用1
	      private int bak2; //备用11
	      private String fstatus; //流转状态
	      private int newline; //新投线路
	      private int outlinenum; //退出线路数量
	      private int changlinenum; //切改线路数量
	      private int outgeneratornum; //发电机退出数量
	      private String systemchartno; //系统图修改单正式编号
	      private String fexcutestatus; //执行状态
	      private String sys_fille; //填写人
	      private String sys_filldept; //填写单位
	      private java.sql.Timestamp sys_filltime; //填写时间
	      private int sys_isvalid; //是否有效字段
	      private String sys_dataowner; //数据所属单位
	      private String recordsno; //记录编号
	      private int version; //数据库版本控制
	      private java.util.Collection fzdhrmrec2; //记录编号
	      private com.techstar.dmis.dto.FsApprovebookDto zzdhcharalterrecord1; //批准书编号
	      private com.techstar.dmis.dto.ZdhAutoondutylogDto zzdhcharalterrecord2; //交接班记录编号
		 

  	private ZdhCharalterrecordWFTaskDto zdhCharalterrecordWFTaskDto;
	public ZdhCharalterrecordWFTaskDto getZdhCharalterrecordWFTaskDto() {
		return zdhCharalterrecordWFTaskDto;
	}
	public void setZdhCharalterrecordWFTaskDto(ZdhCharalterrecordWFTaskDto zdhCharalterrecordWFTaskDto) {
		this.zdhCharalterrecordWFTaskDto = zdhCharalterrecordWFTaskDto;
	}
   	
	
   /**
     * getters and setters
     */
           public void setTaskexplanation(String taskexplanation){
        this.taskexplanation=taskexplanation;
    }
	   public String getTaskexplanation(){
      return taskexplanation;
    }
           public void setModexplanation(String modexplanation){
        this.modexplanation=modexplanation;
    }
	   public String getModexplanation(){
      return modexplanation;
    }
           public void setLinediagramamount(int linediagramamount){
        this.linediagramamount=linediagramamount;
    }
	   public int getLinediagramamount(){
      return linediagramamount;
    }
           public void setStationdiagramamount(int stationdiagramamount){
        this.stationdiagramamount=stationdiagramamount;
    }
	   public int getStationdiagramamount(){
      return stationdiagramamount;
    }
           public void setAccompanyingmap(String accompanyingmap){
        this.accompanyingmap=accompanyingmap;
    }
	   public String getAccompanyingmap(){
      return accompanyingmap;
    }
           public void setMdiagram(byte[] mdiagram){
        this.mdiagram=mdiagram;
    }
	   public byte[] getMdiagram(){
      return mdiagram;
    }
           public void setNewtrfnum(int newtrfnum){
        this.newtrfnum=newtrfnum;
    }
	   public int getNewtrfnum(){
      return newtrfnum;
    }
           public void setNewbusnum(int newbusnum){
        this.newbusnum=newbusnum;
    }
	   public int getNewbusnum(){
      return newbusnum;
    }
           public void setNewswitchnum(int newswitchnum){
        this.newswitchnum=newswitchnum;
    }
	   public int getNewswitchnum(){
      return newswitchnum;
    }
           public void setNewothersnum(int newothersnum){
        this.newothersnum=newothersnum;
    }
	   public int getNewothersnum(){
      return newothersnum;
    }
           public void setNewplantnum(int newplantnum){
        this.newplantnum=newplantnum;
    }
	   public int getNewplantnum(){
      return newplantnum;
    }
           public void setChangtrmnum(int changtrmnum){
        this.changtrmnum=changtrmnum;
    }
	   public int getChangtrmnum(){
      return changtrmnum;
    }
           public void setChangbusnum(int changbusnum){
        this.changbusnum=changbusnum;
    }
	   public int getChangbusnum(){
      return changbusnum;
    }
           public void setOuttrfnum(int outtrfnum){
        this.outtrfnum=outtrfnum;
    }
	   public int getOuttrfnum(){
      return outtrfnum;
    }
           public void setOutbusnum(int outbusnum){
        this.outbusnum=outbusnum;
    }
	   public int getOutbusnum(){
      return outbusnum;
    }
           public void setOutswitchnum(int outswitchnum){
        this.outswitchnum=outswitchnum;
    }
	   public int getOutswitchnum(){
      return outswitchnum;
    }
           public void setBak1(int bak1){
        this.bak1=bak1;
    }
	   public int getBak1(){
      return bak1;
    }
           public void setBak2(int bak2){
        this.bak2=bak2;
    }
	   public int getBak2(){
      return bak2;
    }
           public void setFstatus(String fstatus){
        this.fstatus=fstatus;
    }
	   public String getFstatus(){
      return fstatus;
    }
           public void setNewline(int newline){
        this.newline=newline;
    }
	   public int getNewline(){
      return newline;
    }
           public void setOutlinenum(int outlinenum){
        this.outlinenum=outlinenum;
    }
	   public int getOutlinenum(){
      return outlinenum;
    }
           public void setChanglinenum(int changlinenum){
        this.changlinenum=changlinenum;
    }
	   public int getChanglinenum(){
      return changlinenum;
    }
           public void setOutgeneratornum(int outgeneratornum){
        this.outgeneratornum=outgeneratornum;
    }
	   public int getOutgeneratornum(){
      return outgeneratornum;
    }
           public void setSystemchartno(String systemchartno){
        this.systemchartno=systemchartno;
    }
	   public String getSystemchartno(){
      return systemchartno;
    }
           public void setFexcutestatus(String fexcutestatus){
        this.fexcutestatus=fexcutestatus;
    }
	   public String getFexcutestatus(){
      return fexcutestatus;
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
           public void setRecordsno(String recordsno){
        this.recordsno=recordsno;
    }
	   public String getRecordsno(){
      return recordsno;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setFzdhrmrec2(java.util.Collection fzdhrmrec2){
        this.fzdhrmrec2=fzdhrmrec2;
    }
	   public java.util.Collection getFzdhrmrec2(){
      return fzdhrmrec2;
    }
           public void setZzdhcharalterrecord1(com.techstar.dmis.dto.FsApprovebookDto zzdhcharalterrecord1){
        this.zzdhcharalterrecord1=zzdhcharalterrecord1;
    }
	   public com.techstar.dmis.dto.FsApprovebookDto getZzdhcharalterrecord1(){
      return zzdhcharalterrecord1;
    }
           public void setZzdhcharalterrecord2(com.techstar.dmis.dto.ZdhAutoondutylogDto zzdhcharalterrecord2){
        this.zzdhcharalterrecord2=zzdhcharalterrecord2;
    }
	   public com.techstar.dmis.dto.ZdhAutoondutylogDto getZzdhcharalterrecord2(){
      return zzdhcharalterrecord2;
    }
      
  

}