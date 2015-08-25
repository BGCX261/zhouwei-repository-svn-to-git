/*
 *
 * Copyright (c) 2006- CE, Inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * CE Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with CE.
 */
package com.sitechasia.webx.core.utils.encrypt;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * RSA加密算法实现类
 * <pre>
 *   //使用准备，如果已有数字证书，此步可以忽略
 *   KeyPair keyPair = RSAUtils.generateKeyPair();
 *   PublicKey publicKey = keyPair.getPublic();
 *   PrivateKey privateKey = keyPair.getPrivate()；
 *
 *   //明文
 *   String plainTextString = ... ;
 *   byte[] plainTextBytes = ... ;
 *   //Byte格式加解密
 *   //加密
 *   byte[] cryperTextBytes = RSAUtils.encrypt(plainTextString, publicKey);
 *   或者
 *   byte[] cryperTextBytes = RSAUtils.encrypt(plainTextBytes,publicKey)
 *   //解密
 *   byte[] decryptTextBytes = RSAUtils.decrypt(cryperTextBytes, privateKey));
 *
 *   //Hex格式加解密
 *   //加密
 *   String cryperTextHexString = RSAUtils.encryptHex(plainTextString, publicKey);
 *   或者
 *   String cryperTextHexString = RSAUtils.encryptHex(plainTextBytes,publicKey)
 *   //解密
 *   String decryptTextString = RSAUtils.decryptHex(cryperTextHexString, privateKey));
 *
 *   //Base64格式加解密
 *   //加密
 *   String cryperTextBase64String = RSAUtils.encryptBase64(plainTextString, publicKey);
 *   或者
 *   String cryperTextBase64String = RSAUtils.encryptBase64(plainTextBytes,publicKey)
 *   //解密
 *   String decryptTextBase64String = RSAUtils.decryptBase64(cryperTextBase64String, privateKey));
 * </pre>
 *
 * @author zane
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public final class RSAUtils {
	private RSAUtils() {
	}
	private static final String RSA_ALGORITHM = "RSA";

	private static Cipher getRSACipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
		return Cipher.getInstance(RSA_ALGORITHM);
	}

	/**
	 * 生成RSA密钥对
	 *
	 * @return 密钥对
	 * @throws NoSuchAlgorithmException
	 * @since 1.0
	 */
	public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance(RSA_ALGORITHM);
		keyGen.initialize(1024);
		return keyGen.generateKeyPair();
	}

	/**
	 * 用公钥加密明文byte数组，返回byte数组密文
	 *
	 * @param plainText
	 *            明文byte数组
	 * @param publicKey
	 *            公钥
	 * @return 密文byte数组
	 * @throws Exception
	 * @since 1.0
	 */
	public static byte[] encrypt(byte[] plainText, PublicKey publicKey) throws Exception {
		Cipher cipher = getRSACipher();
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return cipher.doFinal(plainText);
	}

	/**
	 * 用公钥加密明文字符串，返回byte数组密文
	 *
	 * @param plainText
	 *            明文字符串
	 * @param publicKey
	 *            公钥
	 * @return 密文byte数组
	 * @throws Exception
	 * @since 1.0
	 */
	public static byte[] encrypt(String plainText, PublicKey publicKey) throws Exception {
		return encrypt(plainText.getBytes(), publicKey);
	}

	/**
	 * 用公钥加密明文byte数组，返回Hex字符串密文
	 *
	 * @param plainText
	 *            明文byte数组
	 * @param publicKey
	 *            公钥
	 * @return Hex字符串
	 * @throws Exception
	 * @since 1.0
	 */
	public static String encryptHex(byte[] plainText, PublicKey publicKey) throws Exception {
		return new String(Hex.encodeHex(encrypt(plainText, publicKey)));
	}

	/**
	 * 用公钥加密明文字符串，返回Hex字符串密文
	 *
	 * @param plainText
	 *            明文字符串
	 * @param publicKey
	 *            公钥
	 * @return Hex字符串
	 * @throws Exception
	 * @since 1.0
	 */
	public static String encryptHex(String plainText, PublicKey publicKey) throws Exception {
		return new String(Hex.encodeHex(encrypt(plainText, publicKey)));
	}

	/**
	 * 用公钥加密明文byte数组，返回Base64字符串密文
	 *
	 * @param plainText
	 *            明文byte数组
	 * @param publicKey
	 *            公钥
	 * @return Base64字符串
	 * @throws Exception
	 * @since 1.0
	 */
	public static String encryptBase64(byte[] plainText, PublicKey publicKey) throws Exception {
		return new String(Base64.encodeBase64(encrypt(plainText, publicKey)));
	}

	/**
	 * 用公钥加密明文字符串，返回Base64字符串密文
	 *
	 * @param plainText
	 *            明文字符串
	 * @param publicKey
	 *            公钥
	 * @return Base64字符串密文
	 * @throws Exception
	 * @since 1.0
	 */
	public static String encryptBase64(String plainText, PublicKey publicKey) throws Exception {
		return new String(Base64.encodeBase64(encrypt(plainText, publicKey)));
	}

	/**
	 * 用私钥解密byte密文，返回byte数组明文
	 *
	 * @param cipherText
	 *            byte密文
	 * @param privateKey
	 *            私钥
	 * @return byte数组明文
	 * @throws Exception
	 * @since 1.0
	 */
	public static byte[] decrypt(byte[] cipherText, PrivateKey privateKey) throws Exception {
		Cipher cipher = getRSACipher();
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return cipher.doFinal(cipherText);
	}

	/**
	 * 用私钥解密Hex密文，返回Hex字符串明文
	 *
	 * @param cipherTextHex
	 *            Hex密文
	 * @param privateKey
	 *            私钥
	 * @return Hex字符串明文
	 * @throws Exception
	 * @since 1.0
	 */
	public static String decryptHex(String cipherTextHex, PrivateKey privateKey) throws Exception {
		return new String(Hex.encodeHex(decrypt(Hex.decodeHex(cipherTextHex.toCharArray()), privateKey)));
	}

	/**
	 * 用私钥解密Base64格式密文，返回Base64格式字符串明文
	 *
	 * @param cipherTextBase64
	 *            Base64格式密文
	 * @param privateKey
	 *            私钥
	 * @return Base64格式字符串明文
	 * @throws Exception
	 * @since 1.0
	 */
	public static String decryptBase64(String cipherTextBase64, PrivateKey privateKey) throws Exception {
		return new String(Base64.encodeBase64(decrypt(Base64.decodeBase64(cipherTextBase64.getBytes()), privateKey)));
	}
}
