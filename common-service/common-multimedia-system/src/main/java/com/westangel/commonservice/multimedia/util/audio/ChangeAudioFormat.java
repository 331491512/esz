/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.multimedia.util.audio;<br/>  
 * <b>文件名：</b>ChangeAudioFormat.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年11月16日下午3:50:00<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.multimedia.util.audio;
import it.sauronsoftware.jave.AudioAttributes;  
import it.sauronsoftware.jave.Encoder;  
import it.sauronsoftware.jave.EncoderException;  
import it.sauronsoftware.jave.EncodingAttributes;  
import it.sauronsoftware.jave.InputFormatException;  
import java.io.File; 
/** 
* @ClassName: ChangeAudioFormat
* @Description: 
* @author lichenghao
* @date 2016年11月16日 下午3:50:00  
*/
public class ChangeAudioFormat {
	
	public static void changeToMp3(String sourcePath, String targetPath) {  
        File source = new File(sourcePath);  
        File target = new File(targetPath);  
        AudioAttributes audio = new AudioAttributes();  
        Encoder encoder = new Encoder();  
  
        audio.setCodec("libmp3lame");  
        EncodingAttributes attrs = new EncodingAttributes();  
        attrs.setFormat("mp3");  
        attrs.setAudioAttributes(audio);  
  
        try {  
            encoder.encode(source, target, attrs);  
        } catch (IllegalArgumentException e) {  
            e.printStackTrace();  
        } catch (InputFormatException e) {  
            e.printStackTrace();  
        } catch (EncoderException e) {  
            e.printStackTrace();  
        }  
    }
	
	public static void main(String[] args) {
		String path1 = "D:\\fileupload\\1479281301878.amr";  
		String path2 = "D:\\fileupload\\1479281301878.mp3";  
        changeToMp3(path1, path2);  
	}
}  
