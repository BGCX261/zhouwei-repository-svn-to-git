package com.sitechasia.webx.core.utils.commons;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import com.sitechasia.webx.core.utils.commons.FileUtils;

import junit.framework.TestCase;

/**
 * 文件和流工具类单元测试
 *
 */
public class FileUtilsTest extends TestCase {

	private File testDir;

	private File testFile;

	protected void setUp() throws Exception {
		super.setUp();
		testFile = this.newFile(this.getTestDirectory(),"test1.txt");
	}

	protected void tearDown() throws Exception {
		FileUtils.deleteDirectory(testDir);
		super.tearDown();
	}

	public void testConvertPath() {
		assertEquals(FileUtils.convertPath("c:\\dir\\file.txt"),
				"c:/dir/file.txt");
		assertEquals(FileUtils.convertPath("/dir/file.txt"), "/dir/file.txt");
	}

	public void testAssembleFilePath() {
		assertEquals(FileUtils.assembleFilePath("c:\\dir\\", "file.txt"),
				"c:/dir/file.txt");
		assertEquals(FileUtils.assembleFilePath("c:\\dir", "file.txt"),
				"c:/dir/file.txt");
		assertEquals(FileUtils.assembleFilePath("c:\\dir\\", "/file.txt"),
				"c:/dir/file.txt");
		assertEquals(FileUtils.assembleFilePath("c:\\dir", "/file.txt"),
				"c:/dir/file.txt");

		assertEquals(FileUtils.assembleFilePath("c:/dir/", "file.txt"),
				"c:/dir/file.txt");
		assertEquals(FileUtils.assembleFilePath("c:/dir", "file.txt"),
				"c:/dir/file.txt");
		assertEquals(FileUtils.assembleFilePath("c:/dir/", "/file.txt"),
				"c:/dir/file.txt");
		assertEquals(FileUtils.assembleFilePath("c:/dir", "/file.txt"),
				"c:/dir/file.txt");
	}

	public void testReadWriteByteArray() throws IOException {
		// 写入
		FileUtils.write("test1".getBytes(), testFile);
		// 读取
		byte[] data = FileUtils.readToByteArray(testFile);

		assertEquals(new String(data), "test1");
	}

	public void testReadWriteString() throws IOException {
		FileUtils.write("test1", testFile, "utf-8");
		byte[] data = FileUtils.readToByteArray(testFile);
		assertEquals(new String(data, "utf-8"), "test1");
	}

	public void testReadWriteStream() throws IOException {
		ByteArrayInputStream in = new ByteArrayInputStream("test1".getBytes());
		FileUtils.write(in, testFile);
		byte[] data = FileUtils.readToByteArray(testFile);
		assertEquals(new String(data), "test1");
	}

	public void testWriteOutputSteam() throws IOException{
		//准备
		FileUtils.write("test", testFile);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		//执行测试方法
		FileUtils.write(testFile, out);
		//验证
		assertEquals(out.toString(),"test");
	}

	public void testDiectory() throws IOException {
		if (testDir.exists()) {
			FileUtils.deleteDirectory(testDir);
		}
		testDir.mkdirs();

		File file = this.newFile(testDir,"test.txt");
		this.createFile(file, "test.txt".getBytes());

		File subdir = new File(testDir, "subdir");
		subdir.mkdirs();

		file = this.newFile(subdir,"subdir-test.txt");
		this.createFile(file, "subdir-test.txt".getBytes());

		File subsubdir = new File(subdir,"subsubdir");
		subsubdir.mkdirs();

		file = this.newFile(subsubdir,"subsubdir-test.xml");
		this.createFile(file, "subsubdir-test.xml".getBytes());

		//获取文件列表
		Collection files = FileUtils.listFiles(testDir);
		assertEquals(files.size(),3);
		Collection filenames = this.filesToFilenames(files);
		assertTrue(filenames.contains("test.txt"));
		assertTrue(filenames.contains("subdir-test.txt"));
		assertTrue(filenames.contains("subsubdir-test.xml"));

		//删除subsubdir-test.xml
		FileUtils.forceDelete(file);
		files = FileUtils.listFiles(testDir);
		assertEquals(files.size(),2);
		assertTrue(filenames.contains("test.txt"));
		assertTrue(filenames.contains("subdir-test.txt"));

		//删除subdir
		FileUtils.deleteDirectory(subdir);
		files = FileUtils.listFiles(testDir);
		assertEquals(files.size(),1);
		assertTrue(filenames.contains("test.txt"));

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
			FileUtils.forceDelete(destination);
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
			FileUtils.closeOutputStream(output);
		}
	}

	private Collection<String> filesToFilenames(Collection files) {
		Collection<String> filenames = new java.util.ArrayList<String>(files
				.size());
		Iterator i = files.iterator();
		while (i.hasNext()) {
			filenames.add(((File) i.next()).getName());
		}
		return filenames;
	}

}
