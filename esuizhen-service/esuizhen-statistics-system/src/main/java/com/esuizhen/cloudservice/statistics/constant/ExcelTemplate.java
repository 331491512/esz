package com.esuizhen.cloudservice.statistics.constant;


public class ExcelTemplate {
	public static final StringBuffer HEADER = new StringBuffer(
            "<html xmlns:x=\"urn:schemas-microsoft-com:office:excel\">")
            .append("<head>")
            .append("<meta http-equiv=\"content-type\" content=\"application/vnd.ms-excel; charset=UTF-8\"/>")
            .append("<!--[if gte mso 9]><xml>").append("<x:ExcelWorkbook>")
            .append("<x:ExcelWorksheets>").append("<x:ExcelWorksheet>").append(
                    "<x:Name></x:Name>").append("<x:WorksheetOptions>").append(
                    "<x:Print>").append("<x:ValidPrinterInfo />").append(
                    "</x:Print>").append("</x:WorksheetOptions>").append(
                    "</x:ExcelWorksheet>").append("</x:ExcelWorksheets>")
            .append("</x:ExcelWorkbook>").append("</xml><![endif]-->")
            .append("<style type=\"text/css\"><!-- ")
            .append(".txt{padding-top:1px;padding-right:1px;padding-left:1px;mso-ignore:padding;color:black;font-size:11.0pt;font-weight:400;font-style:normal;text-decoration:none;font-family:宋体;mso-generic-font-family:auto;mso-font-charset:134;mso-number-format:\"\\@\";text-align:general;vertical-align:middle;mso-background-source:auto;mso-pattern:auto;white-space:nowrap;} --> </style>")
            .append("</head>").append("<body>").append("<table>");
	
	public static final StringBuffer FOOTER = new StringBuffer("</table></body></html>");
}
