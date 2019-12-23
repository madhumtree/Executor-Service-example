package com.threadpool.writer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.io.*;

public class FileWriterTask implements Callable<Result>{

	List<Employee> lst=new ArrayList<Employee>();
	String Fname;
	
	
	public FileWriterTask(List<Employee> lst,String Fname){
	this.lst=lst;	
	this.Fname=Fname;
	}
	
	@Override
	public Result call() throws Exception {
		// TODO Auto-generated method stub
		writeFile();
		return new Result(Fname,new Date().toString());
	}


	public void writeFile() throws IOException
	{
		FileWriter fileWriter = new FileWriter("D:\\threadpooloutput\\"+this.Fname);
		fileWriter.write(lst.toString());
		fileWriter.close();

	}
}
