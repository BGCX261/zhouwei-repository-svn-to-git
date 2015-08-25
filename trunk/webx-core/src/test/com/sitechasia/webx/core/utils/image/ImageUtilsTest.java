/**
 * Create time 2007-12-27 上午11:25:48
 */
package com.sitechasia.webx.core.utils.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import junit.framework.TestCase;

/**
 * <p>
 * Title: ImageUtilsTest
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author WangYonghui
 * @version 1.0
 */
public class ImageUtilsTest extends TestCase {

	private File tempFile;

	private BufferedImage image;

	private BufferedImage watermarkImage;

	private URL url;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		tempFile = new File("temp.bmp");
		if (!tempFile.exists()) {
			tempFile.createNewFile();
		}

		url = this.getClass().getResource("/com/sitechasia/webx/core/utils/image/image.gif");
		image = ImageIO.read(url);
		watermarkImage = ImageIO.read(this.getClass().getResource("/com/sitechasia/webx/core/utils/image/watermarkImage.gif"));
	}

	@Override
	protected void tearDown() throws Exception {
		// 将临时文件删除
		if (tempFile != null && tempFile.exists() && tempFile.isFile()) {
			tempFile.delete();
		}
		url = null;
		image = null;
		watermarkImage = null;
		super.tearDown();
	}

	public void testReadImageFromFile() throws Exception {
		ImageIO.write(image, "bmp", tempFile);
		BufferedImage imageFromFile = ImageUtils.readImage(tempFile);
		assertNotNull(imageFromFile);
	}

	public void testReadImageFromInputStream() throws Exception {
		ImageIO.write(image, "bmp", tempFile);
		InputStream is = new FileInputStream(tempFile);
		BufferedImage imageFromInputStream = ImageUtils.readImage(is);
		assertNotNull(imageFromInputStream);
	}

	public void testReadImageFromUrl() throws Exception {
		BufferedImage imageFromUrl = ImageUtils.readImage(url);
		assertNotNull(imageFromUrl);
	}

	public void testWriteImageToFile() throws Exception {
		ImageUtils.writeImage(image, "bmp", tempFile);
		assertTrue(tempFile.length() > 0);
	}

	public void testWriteImageToOutputStream() throws Exception {
		OutputStream os = new FileOutputStream("aaa.bmp");
		ImageUtils.writeImage(image, "bmp", os);
		File f = new File("aaa.bmp");
		assertTrue(f.exists());
		assertTrue(f.length() > 0);
		os.close();
		f.delete();
	}

	// 测试按指定尺寸缩小图片
	public void testZoomBySize() throws Exception {
		BufferedImage bi = ImageUtils.zoom(image, 50, 50);
		assertEquals(50, bi.getWidth());
		assertEquals(50, bi.getHeight());
	}

	// 测试按指定比例缩小图片
	public void testZoomByScale() throws Exception {
		BufferedImage bi = ImageUtils.zoom(image, 0.5, 0.5);
		assertEquals(0.5, (double) bi.getHeight() / image.getHeight());
		assertEquals(0.5, (double) bi.getHeight() / image.getHeight());
	}

	public void testImageWatermarkWithoutTransparency() throws Exception {
		BufferedImage modified;
		modified = ImageUtils.watermark(image, watermarkImage,
				ImageConstants.WatermarkLayout.MIDDLE_CENTER);
		assertNotNull(modified);
		assertSame(modified, image);
	}

	public void testImageWatermarkWithTransparency() throws Exception {
		BufferedImage modified;
		modified = ImageUtils.watermark(image, watermarkImage,
				ImageConstants.WatermarkLayout.MIDDLE_CENTER, 0.2f);
		assertNotNull(modified);
		assertSame(modified, image);
	}

	public void testImageWatermarkWithPoint() throws Exception {
		BufferedImage modified;
		Point position = new Point(10, 10);
		modified = ImageUtils.watermark(image, watermarkImage, position);
		assertNotNull(modified);
		assertSame(modified, image);
		// watermark is null
		modified = ImageUtils.watermark(image, null, position);
		assertNotNull(modified);
		assertSame(modified, image);
	}

	public void testImageWatermarkWithPointAndTransparency() throws Exception {
		BufferedImage modified;
		Point position = new Point(10, 10);
		modified = ImageUtils.watermark(image, watermarkImage, position, 0.2f);
		assertNotNull(modified);
		assertSame(modified, image);
		// watermark is null
		modified = ImageUtils.watermark(image, null, position, 0.2f);
		assertNotNull(modified);
		assertSame(modified, image);
	}

	public void testTextWatermark() throws Exception {
		BufferedImage modified;
		Font font = new Font("Arial", Font.BOLD, 30);
		modified = ImageUtils.watermark(image, "Copy Right", font,
				ImageConstants.WatermarkLayout.MIDDLE_CENTER);
		assertNotNull(modified);
		assertSame(modified, image);

		// watermarkText is null or ""
		modified = ImageUtils.watermark(image, null, font,
				ImageConstants.WatermarkLayout.MIDDLE_CENTER);
		assertNotNull(modified);
		assertSame(modified, image);

		modified = ImageUtils.watermark(image, "", font,
				ImageConstants.WatermarkLayout.MIDDLE_CENTER);
		assertNotNull(modified);
		assertSame(modified, image);
	}

	public void testTextWatermarkWithColor() throws Exception {
		BufferedImage modified;
		Font font = new Font("Arial", Font.BOLD, 30);
		modified = ImageUtils.watermark(image, "Copy Right", font, Color.blue,
				ImageConstants.WatermarkLayout.MIDDLE_CENTER);
		assertNotNull(modified);
		assertSame(modified, image);

		// watermarkText is null or ""
		modified = ImageUtils.watermark(image, null, font, Color.blue,
				ImageConstants.WatermarkLayout.MIDDLE_CENTER);
		assertNotNull(modified);
		assertSame(modified, image);

		modified = ImageUtils.watermark(image, "", font, Color.blue,
				ImageConstants.WatermarkLayout.MIDDLE_CENTER);
		assertNotNull(modified);
		assertSame(modified, image);
	}

	public void testTextWatermarkWithColorAndTransparency() throws Exception {
		BufferedImage modified;
		Font font = new Font("Arial", Font.BOLD, 30);
		modified = ImageUtils.watermark(image, "Copy Right", font, Color.blue,
				ImageConstants.WatermarkLayout.MIDDLE_CENTER, 1.0f);
		assertNotNull(modified);
		assertSame(modified, image);

		// watermarkText is null or ""
		modified = ImageUtils.watermark(image, null, font, Color.blue,
				ImageConstants.WatermarkLayout.MIDDLE_CENTER, 1.0f);
		assertNotNull(modified);
		assertSame(modified, image);

		modified = ImageUtils.watermark(image, "", font, Color.blue,
				ImageConstants.WatermarkLayout.MIDDLE_CENTER, 1.0f);
		assertNotNull(modified);
		assertSame(modified, image);
	}

	public void testTextWatermarkWithPoint() throws Exception {
		BufferedImage modified;
		Font font = new Font("Arial", Font.BOLD, 30);
		Point position = new Point(10, 10);
		modified = ImageUtils.watermark(image, "Copy Right", font, position);
		assertNotNull(modified);
		assertSame(modified, image);

		// watermarkText is null or ""
		modified = ImageUtils.watermark(image, null, font, position);
		assertNotNull(modified);
		assertSame(modified, image);

		modified = ImageUtils.watermark(image, "", font, position);
		assertNotNull(modified);
		assertSame(modified, image);
	}

	public void testTextWatermarkWithPointAndColor() throws Exception {
		BufferedImage modified;
		Font font = new Font("Arial", Font.BOLD, 30);
		Point position = new Point(10, 10);
		modified = ImageUtils.watermark(image, "Copy Right", font, Color.blue,
				position);
		assertNotNull(modified);
		assertSame(modified, image);

		// watermarkText is null or ""
		modified = ImageUtils
				.watermark(image, null, font, Color.blue, position);
		assertNotNull(modified);
		assertSame(modified, image);

		modified = ImageUtils.watermark(image, "", font, Color.blue, position);
		assertNotNull(modified);
		assertSame(modified, image);
	}

	public void testTextWatermarkWithPointAndColorAndTranspalency()
			throws Exception {
		BufferedImage modified;
		Font font = new Font("Arial", Font.BOLD, 30);
		Point position = new Point(10, 10);
		modified = ImageUtils.watermark(image, "Copy Right", font, Color.blue,
				position, 1.0f);
		File f = new File("fff.bmp");
		f.createNewFile();
		ImageUtils.writeImage(image, "bmp", f);
		assertNotNull(modified);
		assertSame(modified, image);
		f.delete();

		// watermarkText is null or ""
		modified = ImageUtils.watermark(image, null, font, Color.blue,
				position, 1.0f);
		assertNotNull(modified);
		assertSame(modified, image);

		modified = ImageUtils.watermark(image, "", font, Color.blue, position,
				1.0f);
		assertNotNull(modified);
		assertSame(modified, image);
	}

}
