package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.ZdhFaultlistDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class ZdhFaultlistForm extends BaseForm {
	
	private ZdhFaultlistDto zdhFaultlistDto = new ZdhFaultlistDto();

	
		
	public ZdhFaultlistForm() {

	}

	public ZdhFaultlistDto getZdhFaultlistDto() {
		///*
		if (zdhFaultlistDto.getZzdhfaultlist7() == null) {
			com.techstar.dmis.dto.ZdhAutoondutylogDto zdhAutoondutylog = new com.techstar.dmis.dto.ZdhAutoondutylogDto();
			zdhFaultlistDto.setZzdhfaultlist7(zdhAutoondutylog);
		}
		System.out.println("###########"+zdhFaultlistDto.getRfilltime());
		//*/
		return zdhFaultlistDto;
	}

	public void setZdhFaultlistDto(ZdhFaultlistDto zdhFaultlistDto) {
		///*
		if (zdhFaultlistDto.getZzdhfaultlist7() == null) {
			com.techstar.dmis.dto.ZdhAutoondutylogDto zdhAutoondutylog = new com.techstar.dmis.dto.ZdhAutoondutylogDto();
			zdhFaultlistDto.setZzdhfaultlist7(zdhAutoondutylog);
		}
		System.out.println("###########"+zdhFaultlistDto.getRfilltime());
		//*/
		this.zdhFaultlistDto = zdhFaultlistDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
