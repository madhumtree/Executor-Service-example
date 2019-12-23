package com.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.threadpool.writer.Employee;
import com.threadpool.writer.FileWriterTask;
import com.threadpool.writer.Result;
import com.threadpool.*;
public class AppStarter {

	public static void main(String[] asgs) throws InterruptedException {
		  List<Future<Result>> resultList = null;
		ExecutorService executer=Executors.newFixedThreadPool(2);
		
		List<FileWriterTask> tasks=new ArrayList<FileWriterTask>();

		List<Employee> lst1=new ArrayList<Employee>();
		Employee emp=new Employee("a","a","m");
		Employee emp2=new Employee("a","a","m");
lst1.add(emp);
lst1.add(emp2);

List<Employee> lst2=new ArrayList<Employee>();
Employee em3=new Employee("a","a","m");
Employee emp4=new Employee("a","a","m");
lst2.add(em3);
lst2.add(emp4);
System.out.println("******started executor*********");
FileWriterTask writerTask1=new FileWriterTask(lst1, "file1");
FileWriterTask writerTask2=new FileWriterTask(lst2, "file2");

tasks.add(writerTask1);
tasks.add(writerTask2);

resultList =executer.invokeAll(tasks);
System.out.println("******executor Completed*********");

executer.shutdown();

System.out.println("\n========Printing the results======");

for (int i = 0; i < resultList.size(); i++) {
    Future<Result> future = resultList.get(i);
    try {
        Result result = future.get();
        System.out.println(result.getFname() + ": " + result.getTimeStamp());
    } catch (Exception  e) {
        e.printStackTrace();
    }
}

	}
	
}
