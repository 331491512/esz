/**
 * 
 */
package com.westangel.common.util;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.westangel.common.config.MediaConfig;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.OutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.image.BufferedImage;


/**
 * @author bigdragon
 * 二维码生成工具
 * 利用了google的zxing
 *
 */

	 
public class QRCodeUtil {
	 
	   private static final int BLACK = 0xFF000000;
	   private static final int WHITE = 0xFFFFFFFF;
	 
	   
	   public static BufferedImage toBufferedImage(BitMatrix matrix) {
	     int width = matrix.getWidth();
	     int height = matrix.getHeight();
	     BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	     for (int x = 0; x < width; x++) {
	       for (int y = 0; y < height; y++) {
	         image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
	       }
	     }
	     return image;
	   }
	 
	   
	   public static void writeToFile(BitMatrix matrix, String format, File file)
	       throws IOException {
	     BufferedImage image = toBufferedImage(matrix);
	     if (!ImageIO.write(image, format, file)) {
	       throw new IOException("Could not write an image of format " + format + " to " + file);
	     }
	   }
	 
	   
	   public static void writeToStream(BitMatrix matrix, String format, OutputStream stream)
	       throws IOException {
	     BufferedImage image = toBufferedImage(matrix);
	     if (!ImageIO.write(image, format, stream)) {
	       throw new IOException("Could not write an image of format " + format);
	     }
	   }
	 
	   public static void main(String args[]){
			// TODO Auto-generated method stub
			String qrCodePicFileName = "qrcode_test.png";
			String filePath = "./";
			String qrCodeContent="http://127.0.0.1/org/profile";
			//生产二维码图片文件
			try {
			     MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			     
			     Map hints = new HashMap();
			     hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			     BitMatrix bitMatrix = multiFormatWriter.encode(qrCodeContent, BarcodeFormat.QR_CODE, 300,300,hints);
			     File file = new File(filePath,qrCodePicFileName);
			     QRCodeUtil.writeToFile(bitMatrix, "png", file);
			     System.out.println("Ok! QRCode write to file succeed. qrcodeContent="+qrCodeContent);
			     
			 } catch (Exception e) {
			     e.printStackTrace();
			     System.out.println("ERROR in orgQRCodeCreate(): "+e.getMessage());
			 
			 }
			
		   
	   }
	 }