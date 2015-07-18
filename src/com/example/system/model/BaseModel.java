package com.example.system.model;

import java.io.Serializable;

public class BaseModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ErrorCode;
	private String ErrorCodeInfo;
	public String getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}
	public String getErrorCodeInfo() {
		return ErrorCodeInfo;
	}
	public void setErrorCodeInfo(String errorCodeInfo) {
		ErrorCodeInfo = errorCodeInfo;
	}

}
