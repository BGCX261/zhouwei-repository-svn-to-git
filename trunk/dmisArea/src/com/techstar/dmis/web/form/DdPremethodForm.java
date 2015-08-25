package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.DdPremethodDto;

//please add your business methods start
// to do it
//add your business method end

/**
 * @author
 * @date
 */
public class DdPremethodForm extends BaseForm {

	private DdPremethodDto ddPremethodDto = new DdPremethodDto();

	private FormFile fpremethodcontent;

	public DdPremethodForm() {

	}

	public DdPremethodDto getDdPremethodDto() {
		return ddPremethodDto;
	}

	public void setDdPremethodDto(DdPremethodDto ddPremethodDto) {
		this.ddPremethodDto = ddPremethodDto;
	}

	public FormFile getFpremethodcontent() {
		return fpremethodcontent;
	}

	public void setFpremethodcontent(FormFile fpremethodcontent) {
		this.fpremethodcontent = fpremethodcontent;
	}

	// please add your business methods start
	// to do it
	// add your business method end
}
