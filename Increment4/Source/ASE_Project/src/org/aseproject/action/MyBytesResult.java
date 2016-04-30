package org.aseproject.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

public class MyBytesResult implements Result {
	 
    public void execute(ActionInvocation invocation) throws Exception {
 
        MyAction action = (MyAction) invocation.getAction();
        HttpServletResponse response = ServletActionContext.getResponse();
 
        response.setContentType(action.getMyContentType());
        response.setContentLength(action.getMyContentLength());
 
        response.getOutputStream().write(action.getMyImageInBytes());
        response.getOutputStream().flush();
    }

	
 
}
