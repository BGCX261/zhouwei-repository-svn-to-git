package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.DdClassondutylogDto;
import com.techstar.dmis.dto.DdWaterproofplanDto;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.dto.StdStationDto;
import com.techstar.dmis.dto.GgRelpersonDto;

/**
 * @author 
 * @date
 */
public class DdWaterproofplanForm extends BaseForm {
	
	private DdWaterproofplanDto ddWaterproofplanDto = new DdWaterproofplanDto();

	
		
	public DdWaterproofplanForm() {

	}

	public DdWaterproofplanDto getDdWaterproofplanDto() {
		DdClassondutylogDto ddc = ddWaterproofplanDto.getZddwaterproofplan2();
		
		 if (ddc == null){
			 ddc = new DdClassondutylogDto();
			 ddWaterproofplanDto.setZddwaterproofplan2(ddc);
		 }
		 
		 
		return ddWaterproofplanDto;
	}

	public void setDdWaterproofplanDto(DdWaterproofplanDto ddWaterproofplanDto) {
		DdClassondutylogDto ddc = ddWaterproofplanDto.getZddwaterproofplan2();
		
		 if (ddc == null){
			 ddc = new DdClassondutylogDto();
			 ddWaterproofplanDto.setZddwaterproofplan2(ddc);
		 }
		 
		this.ddWaterproofplanDto = ddWaterproofplanDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
