package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.FsRmchangbillDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class FsRmchangbillForm extends BaseForm {
	
	private FsRmchangbillDto fsRmchangbillDto = new FsRmchangbillDto();

	
		
	public FsRmchangbillForm() {

	}

	public FsRmchangbillDto getFsRmchangbillDto() {
		return fsRmchangbillDto;
	}

	public void setFsRmchangbillDto(FsRmchangbillDto fsRmchangbillDto) {
		this.fsRmchangbillDto = fsRmchangbillDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
