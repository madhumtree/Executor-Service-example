package com.threadpool.writer;

public class Result {

	String fname;
	String timeStamp;
	Result(String fname,String timestmp){
		this.fname=fname;
		this.timeStamp=timestmp;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
