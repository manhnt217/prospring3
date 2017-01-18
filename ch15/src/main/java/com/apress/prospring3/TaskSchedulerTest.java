package com.apress.prospring3;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.service.AsyncService;

public class TaskSchedulerTest {

	public static void main(String[] args) {

		try (GenericXmlApplicationContext context = new GenericXmlApplicationContext()) {
			context.load("classpath:META-INF/spring/task-scheduler-app-context.xml");
			context.refresh();
			
			AsyncService asyncService = context.getBean("asyncService", AsyncService.class);
			
			List<Future<String>> greetings = new LinkedList<>();
			for (int i = 0; i < 5; i++) {
				greetings.add(asyncService.greetingAsync("John " + i));
			}

			/*Thread.sleep(6000);*/
			
			for (Future<String> greeting : greetings) {
				System.out.println(greeting.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
