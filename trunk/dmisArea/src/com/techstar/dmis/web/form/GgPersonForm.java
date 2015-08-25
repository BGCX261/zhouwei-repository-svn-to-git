package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.GgPersonDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class GgPersonForm extends BaseForm {
	
	private GgPersonDto ggPersonDto = new GgPersonDto();

	
		
	public GgPersonForm() {

	}

	public GgPersonDto getGgPersonDto() {
		return ggPersonDto;
	}

	public void setGgPersonDto(GgPersonDto ggPersonDto) {
		this.ggPersonDto = ggPersonDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
