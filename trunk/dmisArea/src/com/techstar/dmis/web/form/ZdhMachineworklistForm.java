package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.ZdhMachineworklistDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class ZdhMachineworklistForm extends BaseForm {
	
	private ZdhMachineworklistDto zdhMachineworklistDto = new ZdhMachineworklistDto();

	
		
	public ZdhMachineworklistForm() {

	}
	public ZdhMachineworklistDto getZdhMachineworklistDto() {
		if (zdhMachineworklistDto.getZzdhmachineworklist1() == null) {
			com.techstar.dmis.dto.ZdhAutoondutylogDto zzdhworkbill2 = new com.techstar.dmis.dto.ZdhAutoondutylogDto();
			zdhMachineworklistDto.setZzdhmachineworklist1(zzdhworkbill2);
		}		

		return zdhMachineworklistDto;
	}

	public void setZdhMachineworklistDto(ZdhMachineworklistDto zdhMachineworklistDto) {
		if (zdhMachineworklistDto.getZzdhmachineworklist1() == null) {
			com.techstar.dmis.dto.ZdhAutoondutylogDto zzdhworkbill2 = new com.techstar.dmis.dto.ZdhAutoondutylogDto();
			zdhMachineworklistDto.setZzdhmachineworklist1(zzdhworkbill2);
		}		
		this.zdhMachineworklistDto = zdhMachineworklistDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
