package com.apress.prospring3.service;

import java.util.concurrent.Future;

public interface AsyncService {

	Future<String> greetingAsync(String name);
}
