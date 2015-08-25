package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.StdDispatchunitDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class StdDispatchunitForm extends BaseForm {
	
	private StdDispatchunitDto stdDispatchunitDto = new StdDispatchunitDto();

	
		
	public StdDispatchunitForm() {

	}

	public StdDispatchunitDto getStdDispatchunitDto() {
		return stdDispatchunitDto;
	}

	public void setStdDispatchunitDto(StdDispatchunitDto stdDispatchunitDto) {
		this.stdDispatchunitDto = stdDispatchunitDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
