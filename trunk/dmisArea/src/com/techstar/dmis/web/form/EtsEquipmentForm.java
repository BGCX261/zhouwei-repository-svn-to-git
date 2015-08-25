package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.EtsEquipmentDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class EtsEquipmentForm extends BaseForm {
	
	private EtsEquipmentDto etsEquipmentDto = new EtsEquipmentDto();

	
		
	public EtsEquipmentForm() {

	}

	public EtsEquipmentDto getEtsEquipmentDto() {
		return etsEquipmentDto;
	}

	public void setEtsEquipmentDto(EtsEquipmentDto etsEquipmentDto) {
		this.etsEquipmentDto = etsEquipmentDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
