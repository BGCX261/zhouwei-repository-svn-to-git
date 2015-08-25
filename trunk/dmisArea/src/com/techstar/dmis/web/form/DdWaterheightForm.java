package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.DdClassondutylogDto;
import com.techstar.dmis.dto.DdWaterheightDto;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.dto.StdStationDto;

/**
 * @author 
 * @date
 */
public class DdWaterheightForm extends BaseForm {
	
	private DdWaterheightDto ddWaterheightDto = new DdWaterheightDto();

	
		
	public DdWaterheightForm() {

	}

	public DdWaterheightDto getDdWaterheightDto() {
		DdClassondutylogDto ddc = ddWaterheightDto.getZddwaterheight3();
		StdStationDto dds = ddWaterheightDto.getZddwaterheight2();
		 if (ddc == null){
			 ddc = new DdClassondutylogDto();
			 ddWaterheightDto.setZddwaterheight3(ddc);
		 }
		 if (dds ==null){
			 dds = new StdStationDto();
			 ddWaterheightDto.setZddwaterheight2(dds);
		 }
		return ddWaterheightDto;
	}

	public void setDdWaterheightDto(DdWaterheightDto ddWaterheightDto) {
		DdClassondutylogDto ddc = ddWaterheightDto.getZddwaterheight3();
		StdStationDto dds = ddWaterheightDto.getZddwaterheight2();
		 if (ddc == null){
			 ddc = new DdClassondutylogDto();
			 ddWaterheightDto.setZddwaterheight3(ddc);
		 }
		 if (dds ==null){
			 dds = new StdStationDto();
			 ddWaterheightDto.setZddwaterheight2(dds);
		 }
		this.ddWaterheightDto = ddWaterheightDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
