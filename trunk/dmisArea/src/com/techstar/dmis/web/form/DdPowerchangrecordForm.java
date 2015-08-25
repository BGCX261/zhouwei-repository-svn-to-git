package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.DdClassondutylogDto;
import com.techstar.dmis.dto.DdPowerchangrecordDto;
import com.techstar.dmis.dto.StdStationDto;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.dto.StdStationDto;

/**
 * @author 
 * @date
 */
public class DdPowerchangrecordForm extends BaseForm {
	
	private DdPowerchangrecordDto ddPowerchangrecordDto = new DdPowerchangrecordDto();

	
		
	public DdPowerchangrecordForm() {

	}

	public DdPowerchangrecordDto getDdPowerchangrecordDto() {
		DdClassondutylogDto ddc = ddPowerchangrecordDto.getZddpowerchangrecord4();
		StdStationDto dds = ddPowerchangrecordDto.getZddpowerchangrecord6();
		 if (ddc == null){
			 ddc = new DdClassondutylogDto();
			 ddPowerchangrecordDto.setZddpowerchangrecord4(ddc);
		 }
		 if (dds ==null){
			 dds = new StdStationDto();
			 ddPowerchangrecordDto.setZddpowerchangrecord6(dds);
		 }
		return ddPowerchangrecordDto;
	}

	public void setDdPowerchangrecordDto(DdPowerchangrecordDto ddPowerchangrecordDto) {
		DdClassondutylogDto ddc = ddPowerchangrecordDto.getZddpowerchangrecord4(); //当前班志编号
		 StdStationDto dds = ddPowerchangrecordDto.getZddpowerchangrecord6();
		 if (ddc == null){
			 ddc = new DdClassondutylogDto();
			 ddPowerchangrecordDto.setZddpowerchangrecord4(ddc);
		 }
		 if (dds ==null){
			 dds = new StdStationDto();
			 ddPowerchangrecordDto.setZddpowerchangrecord6(dds);
		 }
		this.ddPowerchangrecordDto = ddPowerchangrecordDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
