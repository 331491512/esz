/**
 * 
 */
package com.westangel.commonservice.multimedia.util.image;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.exif.ExifIFD0Directory;

/**
 * @author
 *
 */
public class ImageRotate {
	public final static int IMAGE_DEGREE_NONE = 0; // 未旋转
	public final static int IMAGE_DEGREE_LEFT_90 = 90; // 左旋转90度
	public final static int IMAGE_DEGREE_LEFT_180 = 180;
	public final static int IMAGE_DEGREE_LEFT_270 = 270;

	// 获得图片旋转角度，为左旋转度数
	public int getImageDegree(ByteArrayInputStream image) {
		if(image==null) return 0;
		try {
			// 核心对象操作对象
			Metadata metadata = ImageMetadataReader.readMetadata(image);
			// 获取所有不同类型的Directory，如ExifSubIFDDirectory, ExifInteropDirectory,
			// ExifThumbnailDirectory等，这些类均为ExifDirectoryBase extends
			// Directory子类
			// 分别遍历每一个Directory，根据Directory的Tags就可以读取到相应的信息
			Iterable<Directory> iterable = metadata.getDirectories();
			for (Iterator<Directory> iter = iterable.iterator(); iter.hasNext();) {
				Directory dr = iter.next();
				if (!dr.containsTag(ExifIFD0Directory.TAG_ORIENTATION))
					return 0;
				return getOrientationDegree(dr.getInt(ExifIFD0Directory.TAG_ORIENTATION));
			}
		} catch (Exception e) {
		}
		return IMAGE_DEGREE_NONE;
	}

	private  int getOrientationDegree(int orientation) {
		switch (orientation) {
		case 3:
			return IMAGE_DEGREE_LEFT_180;
		case 6:
			return IMAGE_DEGREE_LEFT_90;
		case 8:
			return IMAGE_DEGREE_LEFT_270;
		default:
			return IMAGE_DEGREE_NONE;
		}
	}

	// 旋转图片，方向为右旋转
	public boolean rotateImage(ByteArrayInputStream inputImage,
			ByteArrayOutputStream outputImage, int rotateDegree)
			 {
		try{
			if(inputImage==null){
				//NodeLogger.instance().error("ERROR in ImageRotate.roateImage(): inputImage is null.");
				return false;
				
			}
			
			BufferedImage bufferedimage = ImageIO.read(inputImage);
			if(bufferedimage==null){
				//NodeLogger.instance().error("ERROR in ImageRotate.roateImage(): get bufferedimage null from inputstream. ");
				return false;
			}
			int w = bufferedimage.getWidth();
			int h = bufferedimage.getHeight();
			int type = bufferedimage.getColorModel().getTransparency();
			BufferedImage img;
			Graphics2D graphics2d;
			(graphics2d = (img = new BufferedImage(w, h, type)).createGraphics())
					.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
							RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			graphics2d.rotate(Math.toRadians(rotateDegree), w / 2, h / 2);
			graphics2d.drawImage(bufferedimage, 0, 0, null);
			graphics2d.dispose();
			ImageIO.write(img, "jpg", outputImage);
		}
		catch(Exception e){
			//NodeLogger.instance().error("Exception in ImageRotate.roateImage(): "+e.getMessage());
			e.printStackTrace();
			return false;
		}
	
		return true;
	}

    public static byte[] toByteArray(InputStream in) throws IOException {
	        ByteArrayOutputStream out=new ByteArrayOutputStream();
	        byte[] buffer=new byte[1024*1024*4];
	        int n=0;
	        while ( (n=in.read(buffer)) !=-1) {
	            out.write(buffer,0,n);
	        }
	        return out.toByteArray();
	}
	
    public boolean writeFile(ByteArrayOutputStream os){
    	File fileDir = new File("c:" + File.separator );
    	String fileName =  "img2.jpg";
		File file = new File(fileDir, fileName );
		BufferedOutputStream outputStream=null;
		try {
			outputStream = new BufferedOutputStream(new FileOutputStream(file));
			outputStream.write(os.toByteArray());
			outputStream.close();
			System.out.println("Ok! write image file succeed. file:"
					+fileDir.getPath()+"/"+fileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		
		File imgFile = new File("c:" + File.separator + "img1.jpg");
		InputStream is = null;
		try {
			is = new FileInputStream(imgFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
	    ByteArrayInputStream inputStream = null;
		try {
			byte[] b = toByteArray(is);
			inputStream = new ByteArrayInputStream(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    ImageRotate imageRotate = new ImageRotate();
		int imageDegree = imageRotate.getImageDegree(inputStream);
		System.out.println("image degree:"+imageDegree);
		if(imageDegree!=0){
		  //旋转
		  ByteArrayOutputStream os = new ByteArrayOutputStream();
		  boolean result = imageRotate.rotateImage(inputStream, os, imageDegree);
		  if(result){
			  System.out.println("Ok! rotateImage succeed.");
			  imageRotate.writeFile(os);
		  }
		  else
		  {
			  System.out.println("ERROR! rotateImage failed.");
			  
		  }
		  
		}
		
		

	}
}
