package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.DdCutofflistDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class DdCutofflistForm extends BaseForm {
	
	private DdCutofflistDto ddCutofflistDto = new DdCutofflistDto();

	
		
	public DdCutofflistForm() {

	}

	public DdCutofflistDto getDdCutofflistDto() {
		return ddCutofflistDto;
	}

	public void setDdCutofflistDto(DdCutofflistDto ddCutofflistDto) {
		this.ddCutofflistDto = ddCutofflistDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
