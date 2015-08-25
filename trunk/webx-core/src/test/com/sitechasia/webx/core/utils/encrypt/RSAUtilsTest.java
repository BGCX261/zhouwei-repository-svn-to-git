package com.sitechasia.webx.core.utils.encrypt;

import java.security.KeyPair;

import junit.framework.TestCase;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import com.sitechasia.webx.core.utils.encrypt.RSAUtils;

/**
 * <code>com.sitechasia.webx.core.util.RSAUtils</code>单元测试用例
 * 
 * @author zane
 * 
 */
public class RSAUtilsTest extends TestCase {

	private KeyPair keyPair;

	/**
	 * 初始化
	 */
	protected void setUp() throws Exception {
		keyPair = RSAUtils.generateKeyPair();
		super.setUp();
	}

	/**
	 * 反初始化
	 */
	protected void tearDown() throws Exception {
		keyPair = null;
		super.tearDown();
	}

	public void testEncryptDecryptByte() throws Exception {
		String plainText = "Demo4RSA";
		byte[] cryperText;
		byte[] decryptText;

		cryperText = RSAUtils.encrypt(plainText, keyPair.getPublic());
		decryptText = RSAUtils.decrypt(cryperText, keyPair.getPrivate());
		assertEquals(plainText, new String(decryptText));

		cryperText = RSAUtils.encrypt(plainText.getBytes(), keyPair.getPublic());
		decryptText = RSAUtils.decrypt(cryperText, keyPair.getPrivate());
		assertEquals(plainText, new String(decryptText));
	}

	public void testEncryptDecryptHex() throws Exception {
		String plainText = "Demo4RSA";
		String cryperText;
		String decryptText;

		cryperText = RSAUtils.encryptHex(plainText, keyPair.getPublic());
		decryptText = RSAUtils.decryptHex(cryperText, keyPair.getPrivate());
		assertEquals(decryptText, new String(Hex.encodeHex(plainText.getBytes())));

		cryperText = RSAUtils.encryptHex(plainText.getBytes(), keyPair.getPublic());
		decryptText = RSAUtils.decryptHex(cryperText, keyPair.getPrivate());
		assertEquals(decryptText, new String(Hex.encodeHex(plainText.getBytes())));
	}

	public void testEncryptDecryptBase64() throws Exception {
		String plainText = "Demo4RSA";
		String cryperText;
		String decryptText;

		cryperText = RSAUtils.encryptBase64(plainText, keyPair.getPublic());
		decryptText = RSAUtils.decryptBase64(cryperText, keyPair.getPrivate());
		assertEquals(decryptText, new String(Base64.encodeBase64(plainText.getBytes())));

		cryperText = RSAUtils.encryptBase64(plainText.getBytes(), keyPair.getPublic());
		decryptText = RSAUtils.decryptBase64(cryperText, keyPair.getPrivate());
		assertEquals(decryptText, new String(Base64.encodeBase64(plainText.getBytes())));
	}

}
