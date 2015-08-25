package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.ZdhEligiblermrateDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class ZdhEligiblermrateForm extends BaseForm {
	
	private ZdhEligiblermrateDto zdhEligiblermrateDto = new ZdhEligiblermrateDto();

	
		
	public ZdhEligiblermrateForm() {

	}

	public ZdhEligiblermrateDto getZdhEligiblermrateDto() {
		if (zdhEligiblermrateDto.getZzdheligiblermrate1() == null) {
			com.techstar.dmis.dto.ZdhAutoondutylogDto zzdheligiblermrate1 = new com.techstar.dmis.dto.ZdhAutoondutylogDto();
			zdhEligiblermrateDto.setZzdheligiblermrate1(zzdheligiblermrate1);
		}	
		return zdhEligiblermrateDto;
	}

	public void setZdhEligiblermrateDto(ZdhEligiblermrateDto zdhEligiblermrateDto) {
		if (zdhEligiblermrateDto.getZzdheligiblermrate1() == null) {
			com.techstar.dmis.dto.ZdhAutoondutylogDto zzdheligiblermrate1 = new com.techstar.dmis.dto.ZdhAutoondutylogDto();
			zdhEligiblermrateDto.setZzdheligiblermrate1(zzdheligiblermrate1);
		}	
		this.zdhEligiblermrateDto = zdhEligiblermrateDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
