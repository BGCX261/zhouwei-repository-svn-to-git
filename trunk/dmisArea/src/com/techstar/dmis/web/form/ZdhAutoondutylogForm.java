package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.ZdhAutoondutylogDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class ZdhAutoondutylogForm extends BaseForm {
	
	private ZdhAutoondutylogDto zdhAutoondutylogDto = new ZdhAutoondutylogDto();

	
		
	public ZdhAutoondutylogForm() {

	}

	public ZdhAutoondutylogDto getZdhAutoondutylogDto() {
		return zdhAutoondutylogDto;
	}

	public void setZdhAutoondutylogDto(ZdhAutoondutylogDto zdhAutoondutylogDto) {
		this.zdhAutoondutylogDto = zdhAutoondutylogDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
