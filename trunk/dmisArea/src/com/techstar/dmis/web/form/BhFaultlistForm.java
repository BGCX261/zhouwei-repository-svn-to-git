package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.BhFaultlistDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class BhFaultlistForm extends BaseForm {
	
	private BhFaultlistDto bhFaultlistDto = new BhFaultlistDto();

	
		
	public BhFaultlistForm() {

	}

	public BhFaultlistDto getBhFaultlistDto() {
		return bhFaultlistDto;
	}

	public void setBhFaultlistDto(BhFaultlistDto bhFaultlistDto) {
		this.bhFaultlistDto = bhFaultlistDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
