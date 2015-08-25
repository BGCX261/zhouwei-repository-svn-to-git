package com.sitechasia.webx.core.utils.encrypt;

import java.security.NoSuchAlgorithmException;

import junit.framework.TestCase;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import com.sitechasia.webx.core.utils.encrypt.MD5Utils;

/**
 * <code>com.sitechasia.webx.core.util.MD5Utils</code>单元测试用例
 * 
 * @author zane
 */
public class MD5UtilsTest extends TestCase {

	public void testMD5Byte() throws DecoderException, NoSuchAlgorithmException {
		String testData = "PHP & Information Security";
		String expectDigestHex = "88dd8f282721af2c704e238e7f338c41";
		byte[] expectDigestByte = Hex.decodeHex(expectDigestHex.toCharArray());

		byte[] result = MD5Utils.getMD5Digest(testData);
		assertEquals(new String(result), new String(expectDigestByte));

		result = MD5Utils.getMD5Digest(testData.getBytes());
		assertEquals(new String(result), new String(expectDigestByte));

	}

	public void testMD5Hex() throws NoSuchAlgorithmException {
		String testData = "PHP & Information Security";
		String expectDigestHex = "88dd8f282721af2c704e238e7f338c41";

		String result = MD5Utils.getMD5DigestHex(testData);
		assertEquals(result, expectDigestHex);

		result = MD5Utils.getMD5DigestHex(testData.getBytes());
		assertEquals(result, expectDigestHex);
	}

	public void testMD5Base64() throws NoSuchAlgorithmException, DecoderException {
		String testData = "PHP & Information Security";
		String expectDigestHex = "88dd8f282721af2c704e238e7f338c41";
		String expectDigestBase64 = new String((Base64.encodeBase64(Hex.decodeHex(expectDigestHex.toCharArray()))));

		String result = MD5Utils.getMD5DigestBase64(testData);
		assertEquals(result, expectDigestBase64);

		result = MD5Utils.getMD5DigestBase64(testData.getBytes());
		assertEquals(result, expectDigestBase64);
	}

}
