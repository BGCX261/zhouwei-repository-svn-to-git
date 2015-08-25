package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.ZdhRsrecordDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class ZdhRsrecordForm extends BaseForm {
	
	private ZdhRsrecordDto zdhRsrecordDto = new ZdhRsrecordDto();

	
		
	public ZdhRsrecordForm() {

	}

	public ZdhRsrecordDto getZdhRsrecordDto() {
		if (zdhRsrecordDto.getZzdhrsrecord1() == null) {
			com.techstar.dmis.dto.DdAccidentbriefDto ddAccidentbrief = new com.techstar.dmis.dto.DdAccidentbriefDto();
			zdhRsrecordDto.setZzdhrsrecord1(ddAccidentbrief);
		}
		
		if (zdhRsrecordDto.getZzdhrsrecord2() == null) {
			com.techstar.dmis.dto.ZdhAutoondutylogDto zdhAutoondutylog = new com.techstar.dmis.dto.ZdhAutoondutylogDto();
			zdhRsrecordDto.setZzdhrsrecord2(zdhAutoondutylog);
		}
		
		return zdhRsrecordDto;
	}

	public void setZdhRsrecordDto(ZdhRsrecordDto zdhRsrecordDto) {
		if (zdhRsrecordDto.getZzdhrsrecord1() == null) {
			com.techstar.dmis.dto.DdAccidentbriefDto ddAccidentbrief = new com.techstar.dmis.dto.DdAccidentbriefDto();
			zdhRsrecordDto.setZzdhrsrecord1(ddAccidentbrief);
		}
		
		if (zdhRsrecordDto.getZzdhrsrecord2() == null) {
			com.techstar.dmis.dto.ZdhAutoondutylogDto zdhAutoondutylog = new com.techstar.dmis.dto.ZdhAutoondutylogDto();
			zdhRsrecordDto.setZzdhrsrecord2(zdhAutoondutylog);
		}
		this.zdhRsrecordDto = zdhRsrecordDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
