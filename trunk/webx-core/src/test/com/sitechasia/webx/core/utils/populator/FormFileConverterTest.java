package com.sitechasia.webx.core.utils.populator;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.struts.upload.DiskFile;
import org.apache.struts.upload.FormFile;

import junit.framework.TestCase;

/**
 * <p>
 * Title: FormFileConverterTest
 * </p>
 * <p>
 * Description: FormFileConverter单元测试类
 * </p>
 *
 * @author 左禾兴
 * @version 1.0
 */
public class FormFileConverterTest extends TestCase {

	private FormFileConverter converter;

	// 本测试需要使用到FormFile，而FormFile需要用到File
	private File testDir;

	private File testFile;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		converter = new FormFileConverter();
		// 准备文件
		testFile = this.newFile(this.getTestDirectory(), "test1.txt");
		this.createFile(testFile, "test4FormFileConverter".getBytes());
	}

	@Override
	protected void tearDown() throws Exception {
		converter = null;
		// 删除文件
		if (testFile != null && testFile.exists())
			testFile.delete();
		if (testDir != null && testDir.exists())
			testDir.delete();
		super.tearDown();
	}

	/**
	 * 测试转换方法
	 * @throws IOException
	 */
	public void testConvertValue() throws IOException {
		InputStream stream = null;

		try {
			FormFile formFile = new DiskFile(testFile.getAbsolutePath());
			FormFile formFileNull = null;

			//FormFile is null
			stream = (InputStream) converter.convertValue(formFileNull, InputStream.class, null);
			assertNull(stream);

			//type is not InputStream
			stream = (InputStream) converter.convertValue(formFile, String.class, null);
			assertNull(stream);

			//正确的转换
			stream = (InputStream) converter.convertValue(formFile,
					InputStream.class, null);
			assertNotNull(stream);
		} finally {
			if (stream != null)
				stream.close();
		}

	}

	private File getTestDirectory() {
		if (testDir == null) {
			testDir = (new File("test")).getAbsoluteFile();
		}
		testDir.mkdirs();
		return testDir;
	}

	private File newFile(File parentDir, String filename) throws IOException {
		File destination = new File(parentDir, filename);
		if (destination.exists()) {
			destination.delete();
		}
		return destination;
	}

	private void createFile(File file, byte[] data) throws IOException {
		if (!file.getParentFile().exists()) {
			throw new IOException("Cannot create file " + file
					+ " as the parent directory does not exist");
		}
		BufferedOutputStream output = new BufferedOutputStream(
				new java.io.FileOutputStream(file));
		try {
			output.write(data);
		} finally {
			output.close();
		}
	}
}
