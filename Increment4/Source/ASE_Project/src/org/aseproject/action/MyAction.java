package org.aseproject.action;

import com.opensymphony.xwork2.ActionSupport;

public class MyAction extends ActionSupport {
	  
	private static byte[] myImageInBytes = null;
	private static String myContentType = "image/png";
	private static String myContentDisposition = "inline";
	private static int myContentLength;
	private static int myBufferSize;
	  
	public static byte[] getMyImageInBytes() {
		return myImageInBytes;
	}

	public static void setMyImageInBytes(byte[] myImageInBytes) {
		MyAction.myImageInBytes = myImageInBytes;
	}

	public static String getMyContentType() {
		return myContentType;
	}

	public static void setMyContentType(String myContentType) {
		MyAction.myContentType = myContentType;
	}

	public static String getMyContentDisposition() {
		return myContentDisposition;
	}

	public static void setMyContentDisposition(String myContentDisposition) {
		MyAction.myContentDisposition = myContentDisposition;
	}

	public static int getMyContentLength() {
		return myContentLength;
	}

	public static void setMyContentLength(int myContentLength) {
		MyAction.myContentLength = myContentLength;
	}

	public static int getMyBufferSize() {
		return myBufferSize;
	}

	public static void setMyBufferSize(int myBufferSize) {
		MyAction.myBufferSize = myBufferSize;
	}

	public String doDefault() {
	    return "myImageResult";
	  }

	
	 
	}