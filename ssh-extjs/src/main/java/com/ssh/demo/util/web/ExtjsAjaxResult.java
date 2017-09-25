package com.ssh.demo.util.web;

public class ExtjsAjaxResult {
	private boolean success = true;
	private String msg = "";
	
	public ExtjsAjaxResult(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	
	public ExtjsAjaxResult() {
		
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMsg() {
		return msg;
	}	
}
