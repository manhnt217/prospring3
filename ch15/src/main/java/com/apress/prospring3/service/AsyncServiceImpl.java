package com.apress.prospring3.service;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service("asyncService")
public class AsyncServiceImpl implements AsyncService {

	static int foo;
	
	private Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

	@Async
	@Override
	public Future<String> greetingAsync(String name) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		logger.info("Done " + name);
		return new AsyncResult<String>("Hello " + name);
	}

}
