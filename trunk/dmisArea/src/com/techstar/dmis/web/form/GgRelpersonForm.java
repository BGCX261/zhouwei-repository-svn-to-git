package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.GgRelpersonDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class GgRelpersonForm extends BaseForm {
	
	private GgRelpersonDto ggRelpersonDto = new GgRelpersonDto();

	
		
	public GgRelpersonForm() {

	}

	public GgRelpersonDto getGgRelpersonDto() {
		return ggRelpersonDto;
	}

	public void setGgRelpersonDto(GgRelpersonDto ggRelpersonDto) {
		this.ggRelpersonDto = ggRelpersonDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
