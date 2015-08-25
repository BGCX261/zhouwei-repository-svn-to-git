package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.StdLineDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class StdLineForm extends BaseForm {
	
	private StdLineDto stdLineDto = new StdLineDto();

	
		
	public StdLineForm() {

	}

	public StdLineDto getStdLineDto() {
		return stdLineDto;
	}

	public void setStdLineDto(StdLineDto stdLineDto) {
		this.stdLineDto = stdLineDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
