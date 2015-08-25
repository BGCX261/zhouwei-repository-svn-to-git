package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.DdClassondutylogDto;
import com.techstar.dmis.dto.DdSasusprecordDto;
import com.techstar.dmis.dto.EtsEquipmentDto;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.dto.StdStationDto;

/**
 * @author 
 * @date
 */
public class DdSasusprecordForm extends BaseForm {
	
	private DdSasusprecordDto ddSasusprecordDto = new DdSasusprecordDto();

	
		
	public DdSasusprecordForm() {

	}

	public DdSasusprecordDto getDdSasusprecordDto() {
		DdClassondutylogDto ddc = ddSasusprecordDto.getZddsasusprecord3();
		EtsEquipmentDto dde = ddSasusprecordDto.getZddsasusprecord2();
		 if (ddc == null){
			 ddc = new DdClassondutylogDto();
			 ddSasusprecordDto.setZddsasusprecord3(ddc);
		 }
		 if (dde ==null){
			 dde = new EtsEquipmentDto();
			 ddSasusprecordDto.setZddsasusprecord2(dde);
		 }
		return ddSasusprecordDto;
	}

	public void setDdSasusprecordDto(DdSasusprecordDto ddSasusprecordDto) {
		DdClassondutylogDto ddc = ddSasusprecordDto.getZddsasusprecord3();
		EtsEquipmentDto dde = ddSasusprecordDto.getZddsasusprecord2();
		 if (ddc == null){
			 ddc = new DdClassondutylogDto();
			 ddSasusprecordDto.setZddsasusprecord3(ddc);
		 }
		 if (dde ==null){
			 dde = new EtsEquipmentDto();
			 ddSasusprecordDto.setZddsasusprecord2(dde);
		 }
		this.ddSasusprecordDto = ddSasusprecordDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
