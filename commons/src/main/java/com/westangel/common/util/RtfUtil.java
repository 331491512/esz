package com.westangel.common.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

import org.apache.commons.lang.StringUtils;

public class RtfUtil
{

	/**
	 * 从 Rtf 格式的字符序列中读取字符串（输出中间态）。
	 * 
	 * @param rftString
	 *            Rtf 格式的字符序列
	 * @param outputCharset
	 *            输出字符串的编码
	 * 
	 * @return 输出的字符串
	 */
	public static String readFromRtfString(String rftString)
	{
		String result = null;
		try {
			String outputCharset = "GB2312";
			rftString = replace(rftString);
			DefaultStyledDocument styledDoc = new DefaultStyledDocument();
			InputStream inStream = new ByteArrayInputStream(rftString.getBytes());

			new RTFEditorKit().read(inStream, styledDoc, 0);

			try {
				for (byte b : styledDoc.getText(0, styledDoc.getLength()).getBytes("ISO8859_1")) {
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			result = new String(styledDoc.getText(0, styledDoc.getLength()).getBytes("ISO8859_1"), outputCharset);
			result = StringUtils.deleteWhitespace(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String replace(String rtfString)
	{
		rtfString =  rtfString.replace("8c\\'ac", "c9\\'d0");
		return rtfString;
	}

	public static void main(String[] args) throws Exception
	{
		String rtfString = "{\\rtf1\\ansi\\ansicpg936\\deff0\\deflang1033\\deflangfe2052{\\fonttbl{\\f0\\fnil\\fcharset134\\'cb\\'ce\\'cc\\'e5;}}{\\colortbl;\\red0\\green0\\blue0;}\\viewkind4\\uc1\\pard\\cf1\\lang2052\\b\\f0\\fs28\\'be\\'b5\\'cf\\'c2\\'cb\\'f9\\'bc\\'fb\\cf0\\b0\\par\\'be\\'e0\\'c3\\'c5\\'b3\\'dd30cm\\'d2\\'d4\\'cf\\'c2\\'ca\\'b3\\'b9\\'dc\\'d6\\'dc\\'b1\\'da\\'bf\\'c9\\'bc\\'fb\\'ca\\'fd\\'cc\\'f5\\'bb\\'d2\\'c0\\'b6\\'c9\\'ab\\'d3\\'d8\\'c7\\'fa\\'d5\\'b3\\'c4\\'a4\\'c2\\'a1\\'c6\\'f0\\'a3\\'ac\\'d5\\'b3\\'c4\\'a4\\'c9\\'d0\\'b9\\'e2\\'d5\\'fb\\'a1\\'a3\\par\\'ea\\'da\\'c3\\'c5\\'cd\\'a8\\'b9\\'fd\\'cb\\'b3\\'c0\\'fb\\'a1\\'a3\\par\\'ce\\'b8\\'d5\\'b3\\'c4\\'a4\\'ba\\'ec\\'b0\\'d7\\'cf\\'e0\\'bc\\'e4\\'bb\\'a8\\'b0\\'df\\'d1\\'f9\\'b8\\'c4\\'b1\\'e4\\'a3\\'ac\\'d6\\'e5\\'f4\\'c5\\'b2\\'bb\\'b4\\'d6\\'a3\\'ac\\'c8\\'e1\\'c8\\'ed\\'a3\\'ac\\'c8\\'e4\\'b6\\'af\\'bf\\'c9\\'a1\\'a3\\par\\'d3\\'c4\\'c3\\'c5\\'d4\\'b2\\'a3\\'ac\\'bf\\'aa\\'b7\\'c5\\'d7\\'b4\\'a1\\'a3\\par\\'ca\\'ae\\'b6\\'fe\\'d6\\'b8\\'b3\\'a6\\'c7\\'f2\\'b2\\'bf\\'bf\\'c9\\'bc\\'fb\\'cd\\'d6\\'d4\\'b2\\'d0\\'ce\\'d5\\'b3\\'c4\\'a4\\'c8\\'b1\\'cb\\'f0\\'b0\\'bc\\'cf\\'dd\\'b8\\'b2\\'b0\\'d7\\'cc\\'a6\\'a3\\'ac\\'bd\\'b5\\'b2\\'bf\\'bf\\'c9\\'bc\\'fb\\'ce\\'b4\\'bc\\'fb\\'c3\\'f7\\'cf\\'d4\\'d2\\'ec\\'b3\\'a3\\'a1\\'a3\\parHP\\'a3\\'ba\\'a3\\'a8+\\'a3\\'a9\\par\\par{\\fonttbl{\\f0\\fnil\\fcharset134\\'cb\\'ce\\'cc\\'e5;}}{\\colortbl;\\red0\\green0\\blue0;}\\viewkind4\\uc1\\pard\\cf1\\lang2052\\b\\f0\\fs28\\'be\\'b5\\'cf\\'c2\\'d5\\'ef\\'b6\\'cf\\cf0\\b0\\par\\'ca\\'b3\\'b9\\'dc\\'be\\'b2\\'c2\\'f6\\'c7\\'fa\\'d5\\'c5\\par\\'ca\\'ae\\'b6\\'fe\\'d6\\'b8\\'b3\\'a6\\'c7\\'f2\\'b2\\'bf\\'c0\\'a3\\'d1\\'f1\\par\\par}";
		String text = readFromRtfString(rtfString);
		System.out.println(text);
	}

}