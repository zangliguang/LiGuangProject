package com.zang.liguang.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonConfig;
import net.sf.json.JSONObject;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.ServletActionContext;

public class LiGuangUtils {
	
	public static void listToJson(List list) throws IOException {
		JSONObject jobj = new JSONObject();
		jobj.accumulate("total", list.size());// total代表一共有多少数据
		jobj.put("rows", list);// row是代表显示的页的数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jobj);
		out.flush();
		out.close();
	}
	


	public static String Md5(String plainText ) { 
		try { 
		MessageDigest md = MessageDigest.getInstance("MD5"); 
		md.update(plainText.getBytes()); 
		byte b[] = md.digest(); 

		int i; 

		StringBuffer buf = new StringBuffer(""); 
		for (int offset = 0; offset < b.length; offset++) { 
		i = b[offset]; 
		if(i<0) i+= 256; 
		if(i<16) 
		buf.append("0"); 
		buf.append(Integer.toHexString(i)); 
		} 

		System.out.println("result: " + buf.toString());//32位的加密 

		System.out.println("result: " + buf.toString().substring(8,24));//16位的加密 

		return buf.toString();
		} catch (NoSuchAlgorithmException e) { 
		// TODO Auto-generated catch block 
		e.printStackTrace(); 
		return "";
		} 
		} 
	public static void printJson(HashMap<String, Object> returnMap) throws IOException {
		JsonConfig config = new JsonConfig();
        config.registerJsonValueProcessor(Timestamp.class,new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		JSONObject jsonObject=JSONObject.fromObject(returnMap,config);
		HttpServletResponse response= ServletActionContext.getResponse();
		response.reset();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8"); 
		PrintWriter out = response.getWriter();
		out.print(jsonObject); 	
		out.flush();
		out.close();
	}
	
	
	
    /** 
     * 检查传入file的format名称，判断是不是图片 
     * @param f 传入的文件 
     * @return 
     */  
    public static String getFormatInFile(File f) {  
        return getFormatName(f);  
    }  
     
    /** 
     * 对文件进行format检索 
     * .jpg .jpeg .jpe .jfif ===> JPEG 
     * .png ===> png 
     * .gif ===> gif 
     * . 
     * @param o 
     * @return 
     */  
    // Returns the format name of the image in the object 'o'.  
    // Returns null if the format is not known.  
    private static String getFormatName(Object o) {  
        try {  
            // Create an image input stream on the image  
            ImageInputStream iis = ImageIO.createImageInputStream(o);  
     
            // Find all image readers that recognize the image format  
            Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);  
            if (!iter.hasNext()) {  
                // No readers found  
                return null;  
            }  
     
            // Use the first reader  
            ImageReader reader = (ImageReader) iter.next();  
     
            // Close stream  
            iis.close();  
     
            // Return the format name  
            return reader.getFormatName();  
        } catch (IOException e) {  
            //  
        }  
     
        // The image could not be read  
        return null;  
    }  

    
    
    /**
     * 根据后缀名判断是不是图片
     * @param pInput
     * @return
     */
    public static boolean isPicture(String pInput) {
        if (null != pInput && pInput.length() > 0) {
          // 获得文件后缀名
          String tmpName = pInput.substring(pInput.lastIndexOf(".") + 1, pInput.length());
          // 声明图片后缀名数组
          String imgeArray[] = { "bmp", "dib", "gif", "jfif", "jpe", "jpeg", "jpg", "png", "tif", "tiff", "ico" };
          // 遍历名称数组
          for (int i = 0; i < imgeArray.length; i++) {
            // 判断单个类型文件的场合
            if (imgeArray[i].equals(tmpName.toLowerCase())) {
              return true;
            }
          }
        }
        return false;
      }
    
    
	/**
	 * 上传附件获得文件名
	 * @param fileName
	 * @return
	 */
	public static String getNewFilename(String fileName) {
		int pos = fileName.lastIndexOf(".");
		String lsex = fileName.substring(pos);
		String ls = String.valueOf(new Date().getTime());
		String lsfilename = ls + getRandom() + lsex;
		return lsfilename;
	}
	
	
	/**
	 * 取得4位随机数
	 * 
	 * @return
	 */
	private static String getRandom() {
		String strInt = "";
		Integer i = new Integer((int) (Math.random() * 10000));
		strInt = String.valueOf(i);
		if (strInt.length() != 4) {
			return getRandom();
		} else {
			return strInt;
		}
	}
	
	
	
	/**
	 * 生成缩略图,返回名字
	 */
	public static String CreateThumbnail(String imgSrcPath, String imgSrcName)
			throws Exception {
		try {
			// File srcFile = new File(imgSrcPath+imgSrcName);
			File srcFile = new File(imgSrcPath + File.separator, imgSrcName);
			if (!srcFile.exists()) {
				return null;
			}
			/*
			 * String destFilePath = imgSrcPath + imgSrcName.substring(0,
			 * imgSrcName.lastIndexOf(".")) + "_s.jpg";
			 */
			String destFilePath = imgSrcPath + File.separator
					+ imgSrcName.substring(0, imgSrcName.lastIndexOf("."))
					+ "_s.jpg";
			Image oldImg = ImageIO.read(srcFile);
			/* 计算合适的长宽比例 */
			int width = oldImg.getWidth(null);
			int height = oldImg.getHeight(null);
			int target_width = 100;
			int target_height = 100;
			int new_width, new_height;
			float target_ratio = (float) target_width / (float) target_height;
			float image_ratio = (float) width / (float) height;

			if (target_ratio > image_ratio) {
				new_height = target_height;
				new_width = (int) Math.floor(image_ratio
						* (float) target_height);
			} else {
				new_height = (int) Math.floor((float) target_width
						/ image_ratio);
				new_width = target_width;
			}

			new_width = new_width > target_width ? target_width : new_width;
			new_height = new_height > target_height ? target_height
					: new_height;

			BufferedImage tag = new BufferedImage(new_width, new_height,
					BufferedImage.TYPE_INT_RGB);

			tag.getGraphics().drawImage(
					oldImg.getScaledInstance(new_width, new_height,
							Image.SCALE_SMOOTH), 0, 0, null);
			// tag.getGraphics().drawImage(src.getScaledInstance(widthdist,
			// heightdist, Image.SCALE_AREA_AVERAGING), 0, 0, null);

			FileOutputStream out = new FileOutputStream(destFilePath);
			// JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			// encoder.encode(tag);
			ImageIO.write(tag, "JPEG", out);
			out.close();
			String smallName = imgSrcName.substring(0, imgSrcName.lastIndexOf(".")) + "_s.jpg";
			//imgSrcPath+"/"+smallName;
			
			return  smallName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



	public static void printText(String string) throws IOException {
		
		HttpServletResponse response= ServletActionContext.getResponse();
		response.reset();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8"); 
		PrintWriter out = response.getWriter();
		out.print(string); 	
		out.flush();
		out.close();
	}

}
