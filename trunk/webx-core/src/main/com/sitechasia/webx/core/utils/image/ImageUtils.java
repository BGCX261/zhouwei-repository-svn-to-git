/*
 *
 * Copyright (c) 2006- CE, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information of CE Inc.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with CE.
 */
package com.sitechasia.webx.core.utils.image;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import com.sitechasia.webx.core.utils.image.ImageConstants.WatermarkLayout;

/**
 * 图像工具类。目前主要有如下功能：
 * <ol>
 * <li>图像读取，目前只支持读取以下格式图像：bmp,wbmp,gif,jpge,png
 * <li>图像转换和写入，目前只支持写入以下格式图像：bmp,wbmp,jpeg,png
 * <li>图像缩放，支持绝对像素缩放和百分比缩放
 * <li>图像水印,支持文本水印和图像水印
 * </ol>
 *
 * @author zane
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public final class ImageUtils {
	private ImageUtils() {
	}

	/**
	 * 从指定文件名读取图像，目前只支持读取以下格式图像：bmp,wbmp,gif,jpge,png。
	 *
	 * @param file
	 *            文件名
	 * @return BufferedImage 图像
	 * @since 1.0
	 *
	 *
	 * <pre>
	 * BufferedImage image;
	 * image = ImageUtils.readImage(new File(&quot;myImage.jpg&quot;));
	 * image = ImageUtils.readImage(new File(&quot;myImage.gif&quot;));
	 * image = ImageUtils.readImage(new File(&quot;myImage.bmp&quot;));
	 * image = ImageUtils.readImage(new File(&quot;myImage.png&quot;));
	 * </pre>
	 */
	public static BufferedImage readImage(File file) {
		BufferedImage image = null;
		if (file != null && file.isFile() && file.exists()) {
			try {
				image = ImageIO.read(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
		return image;
	}

	/**
	 * 从文件流读取图像，目前只支持读取以下格式图像：bmp,wbmp,gif,jpge,png。
	 *
	 * @param input
	 *            输入文件流
	 * @return BufferedImage 图像
	 * @since 1.0
	 */
	public static BufferedImage readImage(InputStream input) {
		BufferedImage image = null;
		if (input != null) {
			try {
				image = ImageIO.read(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
		return image;
	}

	/**
	 * 从URL读取图像，目前只支持读取以下格式图像：bmp,wbmp,gif,jpge,png。
	 *
	 * @param url
	 * @return BufferedImage 图像
	 * @since 1.0
	 */
	public static BufferedImage readImage(URL url) {
		BufferedImage image = null;
		if (url != null) {
			try {
				image = ImageIO.read(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
		return image;
	}

	/**
	 * 获得指定图像的像素宽
	 *
	 * @param image
	 *            图像
	 * @return 图像的像素宽
	 * @since 1.0
	 */
	public static int getWidth(BufferedImage image) {
		return image.getWidth();
	}

	/**
	 * 获得指定图像的像素高
	 *
	 * @param image
	 *            图像
	 * @return 图像的像素高
	 * @since 1.0
	 */
	public static int getHeight(BufferedImage image) {
		return image.getHeight();
	}

	/**
	 * 按指定格式输出<code>BufferedImage</code>到文件out中，如果没有指定image或formatName或输出文件out,
	 * 则do nothing 。目前只支持写入以下格式图像：bmp,wbmp,jpeg,png。
	 *
	 * @param image
	 *            图像
	 * @param formatName
	 *            格式
	 * @param out
	 *            输出文件
	 * @throws IOException
	 * @since 1.0
	 * @see com.sitechasia.webx.core.utils.image.ImageConstants.FormatName
	 *
	 *
	 * <pre>
	 * ImageUtils.writeImage(imageToSave, ImageConstants.FormatName.BMP, new File(&quot;newImage.bmp&quot;));
	 * ImageUtils.writeImage(imageToSave, ImageConstants.FormatName.JPEG, new File(&quot;newImage.jpg&quot;));
	 * ImageUtils.writeImage(imageToSave, ImageConstants.FormatName.PNG, new File(&quot;newImage.png&quot;));
	 * ImageUtils.writeImage(imageToSave, ImageConstants.FormatName.WBMP, new File(&quot;newImage.wbmp&quot;));
	 * </pre>
	 *
	 */
	public static void writeImage(BufferedImage image, String formatName, File out) throws IOException {
		if (image != null && formatName != null && !"".equals(formatName) && out != null) {
			ImageIO.write(image, formatName, out);
		}
	}

	/**
	 * 按指定格式输出<code>BufferedImage</code>到out中，如果没有指定image或formatName或输出流out,
	 * 则do nothing 。目前只支持写入以下格式图像：bmp,wbmp,jpeg,png。
	 *
	 * @param image
	 *            图像
	 * @param formatName
	 *            格式
	 * @param out
	 *            输出流
	 * @throws IOException
	 * @since 1.0
	 * @see com.sitechasia.webx.core.utils.image.ImageConstants.FormatName
	 */
	public static void writeImage(BufferedImage image, String formatName, OutputStream out) throws IOException {
		if (image != null && formatName != null && !"".equals(formatName) && out != null) {
			ImageIO.write(image, formatName, out);
		}
	}

	/**
	 * 按指定像素大小缩放图像
	 *
	 * @param image
	 *            图像
	 * @param width
	 *            宽度像素
	 * @param heigth
	 *            高度像素
	 * @return 缩放后的图像
	 */
	public static BufferedImage zoom(BufferedImage image, int width, int heigth) {
		double sx = (double) width / image.getWidth();
		double sy = (double) heigth / image.getHeight();
		return zoom(image, sx, sy);
	}

	/**
	 * 按指定比例缩放图像
	 *
	 * @param image
	 *            原图像
	 * @param sx
	 *            x轴缩放比例
	 * @param sy
	 *            y轴缩放比例
	 * @return 缩放后的图像
	 */
	public static BufferedImage zoom(BufferedImage image, double sx, double sy) {
		AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(sx, sy), null);
		return op.filter(image, null);
	}

	/**
	 * 在图像source中增加图像水印
	 *
	 * @param source
	 *            原图像
	 * @param watermarkImage
	 *            用作水印的图像
	 * @param watermarkLayout
	 *            水印在原图像中的起点
	 * @return 增加水印后的图像
	 * @see com.sitechasia.webx.core.utils.image.ImageConstants.WatermarkLayout
	 *
	 *
	 * <pre>
	 *          BufferedImage source = ...; //得到原图像
	 *          BufferedImage watermark = ...; //得到用作水印的图像
	 *
	 *          //默认透明度0.5f
	 *          //水印采用中部居中布局，其他布局参考com.sitechasia.webx.core.utils.image.ImageConstants.WatermarkLayout
	 *          BufferedImage modified = ImageUtils.watermark(source, watermark, WatermarkLayout.MIDDLE_CENTER);
	 * </pre>
	 */
	public static BufferedImage watermark(BufferedImage source, BufferedImage watermarkImage, String watermarkLayout) {
		return watermark(source, watermarkImage, watermarkLayout, 0.5f);
	}

	/**
	 * 在图像source中增加图像水印
	 *
	 * @param source
	 *            原图像
	 * @param watermarkImage
	 *            用作水印的图像
	 * @param watermarkLayout
	 *            水印在原图像中的起点
	 * @param transparency
	 *            透明度，取值范围：0.0 - 1.0
	 * @return 增加水印后的图像
	 * @see com.sitechasia.webx.core.utils.image.ImageConstants.WatermarkLayout
	 *
	 *
	 * <pre>
	 *          BufferedImage source = ...; //得到原图像
	 *          BufferedImage watermark = ...; //得到用作水印的图像
	 *
	 *          //水印采用中部居中布局，其他布局参考com.sitechasia.webx.core.utils.image.ImageConstants.WatermarkLayout
	 *          BufferedImage modified = ImageUtils.watermark(source, watermark, WatermarkLayout.MIDDLE_CENTER,0.8f);
	 * </pre>
	 */
	public static BufferedImage watermark(BufferedImage source, BufferedImage watermarkImage, String watermarkLayout,
			float transparency) {
		Point position = computeWatermarkPosition(source, watermarkImage.getWidth(), watermarkImage.getHeight(),
				watermarkLayout);
		return watermark(source, watermarkImage, position, transparency);
	}

	/**
	 * 在图像source中增加图像水印
	 *
	 * @param source
	 *            原图像
	 * @param watermarkImage
	 *            用作水印的图像
	 * @param position
	 *            水印在原图像中的起点
	 * @return 增加水印后的图像
	 *
	 *
	 * <pre>
	 *          Point position = new Point(30,30);
	 *
	 *          BufferedImage source = ...; //得到原图像
	 *          BufferedImage watermark = ...; //得到用作水印的图像
	 *
	 *          //默认透明度0.5f
	 *          BufferedImage modified = ImageUtils.watermark(source, watermark, position);
	 * </pre>
	 */
	public static BufferedImage watermark(BufferedImage source, BufferedImage watermarkImage, Point position) {
		return watermark(source, watermarkImage, position, 0.5f);
	}

	/**
	 * 在图像source中增加图像水印
	 *
	 * @param source
	 *            原图像
	 * @param watermarkImage
	 *            用作水印的图像
	 * @param position
	 *            水印在原图像中的起点
	 * @param transparency
	 *            透明度，取值范围：0.0 - 1.0
	 * @return 增加水印后的图像
	 *
	 *
	 * <pre>
	 *          Point position = new Point(30,30);
	 *
	 *          BufferedImage source = ...; //得到原图像
	 *          BufferedImage watermark = ...; //得到用作水印的图像
	 *          BufferedImage modified = ImageUtils.watermark(source, watermark, position,0.8f);
	 * </pre>
	 */
	public static BufferedImage watermark(BufferedImage source, BufferedImage watermarkImage, Point position,
			float transparency) {
		if (source == null)
			return null;
		if (watermarkImage == null || position == null)
			return source;
		Graphics2D g2d = (Graphics2D) source.getGraphics();
		// Create an alpha composite of transparency
		AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency);
		g2d.setComposite(alpha);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.drawImage(watermarkImage, position.x, position.y, watermarkImage.getWidth(), watermarkImage.getHeight(),
				null);
		// Free graphic resources
		g2d.dispose();
		return source;
	}

	/**
	 * 在图像source中增加文字水印
	 *
	 * @param source
	 *            原图像
	 * @param watermarkText
	 *            用作水印的文本
	 * @param textFont
	 *            文本字体
	 * @param watermarkLayout
	 *            水印在原图像中的起点
	 * @return 增加水印后的图像
	 * @see com.sitechasia.webx.core.utils.image.ImageConstants.WatermarkLayout
	 *
	 *
	 * <pre>
	 *          Font font = new Font(&quot;Arial&quot;, Font.BOLD, 30);
	 *
	 *          BufferedImage source = ...; //得到原图像
	 *          //生成水印，默认透明度0.5f，默认颜色白色
	 *          //水印采用中部居中布局，其他布局参考com.sitechasia.webx.core.utils.image.ImageConstants.WatermarkLayout
	 *          BufferedImage modified = ImageUtils.watermark(source, &quot;Copy Right&quot;, font, WatermarkLayout.MIDDLE_CENTER);
	 * </pre>
	 */
	public static BufferedImage watermark(BufferedImage source, String watermarkText, Font textFont,
			String watermarkLayout) {
		return watermark(source, watermarkText, textFont, Color.white, watermarkLayout, 0.5f);
	}

	/**
	 * 在图像source中增加文字水印
	 *
	 * @param source
	 *            原图像
	 * @param watermarkText
	 *            用作水印的文本
	 * @param textFont
	 *            文本字体
	 * @param textColor
	 *            文本颜色
	 * @param watermarkLayout
	 *            水印在原图像中的起点
	 * @return 增加水印后的图像
	 * @see com.sitechasia.webx.core.utils.image.ImageConstants.WatermarkLayout
	 *
	 *
	 * <pre>
	 *          Font font = new Font(&quot;Arial&quot;, Font.BOLD, 30);
	 *          Color color = Color.WHITE;
	 *
	 *          BufferedImage source = ...; //得到原图像
	 *          //生成水印，默认透明度0.5f
	 *          //水印采用中部居中布局，其他布局参考com.sitechasia.webx.core.utils.image.ImageConstants.WatermarkLayout
	 *          BufferedImage modified = ImageUtils.watermark(source, &quot;Copy Right&quot;, font, color, WatermarkLayout.MIDDLE_CENTER);
	 * </pre>
	 */
	public static BufferedImage watermark(BufferedImage source, String watermarkText, Font textFont, Color textColor,
			String watermarkLayout) {
		return watermark(source, watermarkText, textFont, textColor, watermarkLayout, 0.5f);
	}

	/**
	 * 在图像source中增加文字水印
	 *
	 * @param source
	 *            原图像
	 * @param watermarkText
	 *            用作水印的文本
	 * @param textFont
	 *            文本字体
	 * @param textColor
	 *            文本颜色
	 * @param watermarkLayout
	 *            水印在原图像中的起点
	 * @param transparency
	 *            透明度，取值范围：0.0 - 1.0
	 * @return 增加水印后的图像
	 * @see com.sitechasia.webx.core.utils.image.ImageConstants.WatermarkLayout
	 *
	 *
	 * <pre>
	 *          Font font = new Font(&quot;Arial&quot;, Font.BOLD, 30);
	 *          Color color = Color.WHITE;
	 *
	 *          BufferedImage source = ...; //得到原图像
	 *          //生成水印
	 *          //水印采用中部居中布局，其他布局参考com.sitechasia.webx.core.utils.image.ImageConstants.WatermarkLayout
	 *          BufferedImage modified = ImageUtils.watermark(source, &quot;Copy Right&quot;, font, color, WatermarkLayout.MIDDLE_CENTER, 0.8f);
	 * </pre>
	 */
	public static BufferedImage watermark(BufferedImage source, String watermarkText, Font textFont, Color textColor,
			String watermarkLayout, float transparency) {
		if (source == null)
			return null;
		if (watermarkText == null || watermarkText.equals(""))
			return source;
		Graphics2D g2d = (Graphics2D) source.getGraphics();
		// Create an alpha composite of transparency
		AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency);
		g2d.setComposite(alpha);
		g2d.setColor(textColor);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setFont(textFont);
		FontMetrics fontMetrics = g2d.getFontMetrics();
		Rectangle2D rect = fontMetrics.getStringBounds(watermarkText, g2d);
		Point position = computeWatermarkPosition(source, (int) rect.getWidth(), (int) rect.getHeight(),
				watermarkLayout);
		g2d.drawString(watermarkText, position.x, position.y + (int) rect.getHeight());
		// Free graphic resources
		g2d.dispose();
		return source;
	}

	/**
	 * 在图像source中增加文字水印
	 *
	 * @param source
	 *            原图像
	 * @param watermarkText
	 *            用作水印的文本
	 * @param textFont
	 *            文本字体
	 * @param position
	 *            水印在原图像中的起点
	 * @return 增加水印后的图像
	 *
	 *
	 * <pre>
	 *          Font font = new Font(&quot;Arial&quot;, Font.BOLD, 30);
	 *          Point position = new Point(30,30);
	 *
	 *          BufferedImage source = ...; //得到原图像
	 *          //生成水印，默认透明度0.5f，默认颜色白色
	 *          BufferedImage modified = ImageUtils.watermark(source, &quot;Copy Right&quot;, font, position);
	 * </pre>
	 */
	public static BufferedImage watermark(BufferedImage source, String watermarkText, Font textFont, Point position) {
		return watermark(source, watermarkText, textFont, Color.WHITE, position, 0.5f);
	}

	/**
	 * 在图像source中增加文字水印
	 *
	 * @param source
	 *            原图像
	 * @param watermarkText
	 *            用作水印的文本
	 * @param textFont
	 *            本文字体
	 * @param textColor
	 *            文本颜色
	 * @param position
	 *            水印在原图像中的起点
	 * @return 增加水印后的图像
	 *
	 *
	 * <pre>
	 *          Font font = new Font(&quot;Arial&quot;, Font.BOLD, 30);
	 *          Color color = Color.WHITE;
	 *          Point position = new Point(30,30);
	 *
	 *          BufferedImage source = ...; //得到原图像
	 *          //生成水印，默认透明度0.5f
	 *          BufferedImage modified = ImageUtils.watermark(source, &quot;Copy Right&quot;, font, color,position);
	 * </pre>
	 */
	public static BufferedImage watermark(BufferedImage source, String watermarkText, Font textFont, Color textColor,
			Point position) {
		return watermark(source, watermarkText, textFont, textColor, position, 0.5f);
	}

	/**
	 * 在图像source中增加文字水印
	 *
	 * @param source
	 *            图像
	 * @param watermarkText
	 *            用作水印的文本
	 * @param textFont
	 *            文本字体
	 * @param textColor
	 *            文本颜色
	 * @param position
	 *            水印在原图像中的起点
	 * @param transparency
	 *            透明度，取值范围：0.0 - 1.0
	 * @return 增加水印后的图像
	 *
	 *
	 * <pre>
	 *          Font font = new Font(&quot;Arial&quot;, Font.BOLD, 30);
	 *          Color color = Color.WHITE;
	 *          Point position = new Point(30,30);
	 *
	 *          BufferedImage source = ...; //得到原图像
	 *          BufferedImage modified = ImageUtils.watermark(source, &quot;Copy Right&quot;, font, color,position,0.8f);
	 * </pre>
	 */
	public static BufferedImage watermark(BufferedImage source, String watermarkText, Font textFont, Color textColor,
			Point position, float transparency) {
		if (source == null)
			return null;
		if (watermarkText == null || watermarkText.equals(""))
			return source;
		Graphics2D g2d = (Graphics2D) source.getGraphics();
		// Create an alpha composite of transparency
		AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency);
		g2d.setComposite(alpha);
		g2d.setColor(textColor);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setFont(textFont);
		FontMetrics fontMetrics = g2d.getFontMetrics();
		Rectangle2D rect = fontMetrics.getStringBounds(watermarkText, g2d);
		g2d.drawString(watermarkText, position.x, position.y + (int) rect.getHeight());
		// Free graphic resources
		g2d.dispose();
		return source;
	}

	/**
	 * 获取watermark在原图中的起点位置坐标,如果坐标为负数，则表示从原点开始。
	 *
	 * @param source
	 *            原图像
	 * @param width
	 *            watermark宽
	 * @param height
	 *            watermark高
	 * @param layout
	 *            watermark布局
	 * @return 获取watermark在原图中的起点位置坐标
	 */
	private static Point computeWatermarkPosition(BufferedImage source, int width, int height, String layout) {
		if (source == null)
			return null;
		int sourceWidth = source.getWidth();
		int sourceHeight = source.getHeight();
		int px = 0;
		int py = 0;
		if (WatermarkLayout.BOTTOM_LEFT.equalsIgnoreCase(layout)) {
			px = 0;
			py = sourceHeight - height;
		} else if (WatermarkLayout.BOTTOM_CENTER.equalsIgnoreCase(layout)) {
			px = sourceWidth / 2 - (int) width / 2;
			py = sourceHeight - height;
		} else if (WatermarkLayout.BOTTOM_RIGHT.equalsIgnoreCase(layout)) {
			px = sourceWidth - width;
			py = sourceHeight - height;
		} else if (WatermarkLayout.MIDDLE_LEFT.equalsIgnoreCase(layout)) {
			px = 0;
			py = sourceHeight / 2 - (int) height / 2;
		} else if (WatermarkLayout.MIDDLE_CENTER.equalsIgnoreCase(layout)) {
			px = sourceWidth / 2 - (int) width / 2;
			py = sourceHeight / 2 - (int) height / 2;
		} else if (WatermarkLayout.MIDDLE_RIGHT.equalsIgnoreCase(layout)) {
			px = sourceWidth - width;
			py = sourceHeight / 2 - (int) height / 2;
		} else if (WatermarkLayout.TOP_LEFT.equalsIgnoreCase(layout)) {
			px = 0;
			py = 0;
		} else if (WatermarkLayout.TOP_CENTER.equalsIgnoreCase(layout)) {
			px = sourceWidth / 2 - (int) width / 2;
			py = 0;
		} else if (WatermarkLayout.TOP_RIGHT.equalsIgnoreCase(layout)) {
			px = sourceWidth - width;
			py = 0;
		}
		return new Point(px, py);
	}
}
