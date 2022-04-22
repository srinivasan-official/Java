package ExecutorImpl;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorImpl {

	public static void main(String[] args) {
		Executor executor = Executors.newCachedThreadPool();
		System.out.println(Runtime.getRuntime().availableProcessors());
		AtomicInteger integer;
	}

}
