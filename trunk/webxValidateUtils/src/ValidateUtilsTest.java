
import org.apache.commons.lang.math.NumberUtils;

import com.sitechasia.webx.util.validate.ValidateUtils;


public class ValidateUtilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String email = "zhouwei@gmail.com";
		System.out.println(ValidateUtils.isEmail(email));
		email = "ZHOUWEI@GMAIL.COM";
		System.out.println(ValidateUtils.isEmail(email));
		email = "";
		System.out.println(ValidateUtils.isEmail(email));
		email = null;
		System.out.println(ValidateUtils.isEmail(email));

		String number = "12";
		System.out.println(ValidateUtils.isNumber(number));
		number = "one";
		System.out.println(ValidateUtils.isNumber(number));
		number = "";
		System.out.println(ValidateUtils.isNumber(number));
		number = null;
		System.out.println(ValidateUtils.isNumber(number));

		String value = "ww";
		System.out.println(NumberUtils.toInt(value));

	}

}
