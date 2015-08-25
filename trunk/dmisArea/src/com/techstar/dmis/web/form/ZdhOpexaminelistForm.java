package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.ZdhOpexaminelistDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class ZdhOpexaminelistForm extends BaseForm {
	
	private ZdhOpexaminelistDto zdhOpexaminelistDto = new ZdhOpexaminelistDto();

	
		
	public ZdhOpexaminelistForm() {

	}

	public ZdhOpexaminelistDto getZdhOpexaminelistDto() {
		if (zdhOpexaminelistDto.getZzdhopexaminelist5() == null) {
			com.techstar.dmis.dto.ZdhAutoondutylogDto zzdhOpexaminelist = new com.techstar.dmis.dto.ZdhAutoondutylogDto();
			zdhOpexaminelistDto.setZzdhopexaminelist5(zzdhOpexaminelist);
		}	

		return zdhOpexaminelistDto;
	}

	public void setZdhOpexaminelistDto(ZdhOpexaminelistDto zdhOpexaminelistDto) {
		if (zdhOpexaminelistDto.getZzdhopexaminelist5() == null) {
			com.techstar.dmis.dto.ZdhAutoondutylogDto zzdhOpexaminelist = new com.techstar.dmis.dto.ZdhAutoondutylogDto();
			zdhOpexaminelistDto.setZzdhopexaminelist5(zzdhOpexaminelist);
		}	
		this.zdhOpexaminelistDto = zdhOpexaminelistDto;
	}
		
	//please add your business methods start
	// to do it
    //add your business method end
}
