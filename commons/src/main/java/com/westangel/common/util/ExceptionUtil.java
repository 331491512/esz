package com.westangel.common.util;

import com.westangel.common.excption.CommonErrorException;

public class ExceptionUtil {
	public static CommonErrorException commonErrorException(Integer errorCode, String errorMessage, String errorDescription)
	{
		CommonErrorException exception = new CommonErrorException(errorMessage);
		exception.setErrorCode(errorCode);
		if (null != errorDescription) {
			exception.setErrorDescription(errorDescription);	
		}
		return exception;
	}
}
