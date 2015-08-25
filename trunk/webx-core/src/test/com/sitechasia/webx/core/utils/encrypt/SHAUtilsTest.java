package com.sitechasia.webx.core.utils.encrypt;

import java.security.NoSuchAlgorithmException;

import junit.framework.TestCase;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import com.sitechasia.webx.core.utils.encrypt.SHAUtils;

/**
 * <code>com.sitechasia.webx.core.util.SHAUtils</code>单元测试用例
 * 
 * @author zane
 * 
 */
public class SHAUtilsTest extends TestCase {

	public void testSHAByte() throws DecoderException, NoSuchAlgorithmException {
		String testData = "PHP & Information Security";
		String expectDigestHex = "b47210605096b9aa0129f88695e229ce309dd362";
		byte[] expectDigestByte = Hex.decodeHex(expectDigestHex.toCharArray());

		byte[] result = SHAUtils.getSHADigest(testData);
		assertEquals(new String(result), new String(expectDigestByte));

		result = SHAUtils.getSHADigest(testData.getBytes());
		assertEquals(new String(result), new String(expectDigestByte));

	}

	public void testSHAHex() throws NoSuchAlgorithmException {
		String testData = "PHP & Information Security";
		String expectDigestHex = "b47210605096b9aa0129f88695e229ce309dd362";

		String result = SHAUtils.getSHADigestHex(testData);
		assertEquals(result, expectDigestHex);

		result = SHAUtils.getSHADigestHex(testData.getBytes());
		assertEquals(result, expectDigestHex);
	}

	public void testSHABase64() throws NoSuchAlgorithmException, DecoderException {
		String testData = "PHP & Information Security";
		String expectDigestHex = "b47210605096b9aa0129f88695e229ce309dd362";
		String expectDigestBase64 = new String((Base64.encodeBase64(Hex.decodeHex(expectDigestHex.toCharArray()))));

		String result = SHAUtils.getSHADigestBase64(testData);
		assertEquals(result, expectDigestBase64);

		result = SHAUtils.getSHADigestBase64(testData.getBytes());
		assertEquals(result, expectDigestBase64);
	}
}
