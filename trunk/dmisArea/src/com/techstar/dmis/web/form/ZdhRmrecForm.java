package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.ZdhRmrecDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class ZdhRmrecForm extends BaseForm {
	
	private ZdhRmrecDto zdhRmrecDto = new ZdhRmrecDto();

	
		
	public ZdhRmrecForm() {

	}

	public ZdhRmrecDto getZdhRmrecDto() {
		if (zdhRmrecDto.getZzdhrmrec1() == null) {
			com.techstar.dmis.dto.ZdhAutoondutylogDto zdhAutoondutylog = new com.techstar.dmis.dto.ZdhAutoondutylogDto();
			zdhRmrecDto.setZzdhrmrec1(zdhAutoondutylog);
		}
		
		 if (zdhRmrecDto.getZzdhrmrec2() == null) {
			com.techstar.dmis.dto.ZdhCharalterrecordDto zdhCharalterrecord = new com.techstar.dmis.dto.ZdhCharalterrecordDto();
			zdhRmrecDto.setZzdhrmrec2(zdhCharalterrecord);
		}
		/*	
		if (zdhRmrecDto.getZzdhrmrec4() == null) {
			com.techstar.dmis.dto.StdStationDto stdStation = new com.techstar.dmis.dto.StdStationDto();
			zdhRmrecDto.setZzdhrmrec4(stdStation);
		}
		*/
		return zdhRmrecDto;
	}

	public void setZdhRmrecDto(ZdhRmrecDto zdhRmrecDto) {
		if (zdhRmrecDto.getZzdhrmrec1() == null) {
			com.techstar.dmis.dto.ZdhAutoondutylogDto zdhAutoondutylog = new com.techstar.dmis.dto.ZdhAutoondutylogDto();
			zdhRmrecDto.setZzdhrmrec1(zdhAutoondutylog);
		}
		
		if (zdhRmrecDto.getZzdhrmrec2() == null) {
			com.techstar.dmis.dto.ZdhCharalterrecordDto zdhCharalterrecord = new com.techstar.dmis.dto.ZdhCharalterrecordDto();
			zdhRmrecDto.setZzdhrmrec2(zdhCharalterrecord);
		}
		/*
		if (zdhRmrecDto.getZzdhrmrec4() == null) {
			com.techstar.dmis.dto.StdStationDto stdStation = new com.techstar.dmis.dto.StdStationDto();
			zdhRmrecDto.setZzdhrmrec4(stdStation);
		}
		*/
		this.zdhRmrecDto = zdhRmrecDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
