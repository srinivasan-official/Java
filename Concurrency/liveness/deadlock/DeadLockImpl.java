package liveness.deadlock;

import java.util.ArrayList;
import java.util.List;

/**
 * When DeadLockImpl runs, it's extremely likely that both threads will block when they attempt to invoke bowBack. 
 * Neither block will ever end, because each thread is waiting for the other to exit bow.
 * @author srinivasan
 *
 */
public class DeadLockImpl {
	
	public static void main(String[] args) throws InterruptedException {
		Friend kasi = new Friend("Kasi");
		Friend vasanth = new Friend("Vasanth");
		
		List<Thread> threadList = new ArrayList<>();
		threadList.add(new Thread(() -> kasi.bow(vasanth)));
		threadList.add(new Thread(() -> vasanth.bow(kasi)));
		
		for(Thread p : threadList) {
			p.start();
		}
		
		while(true) {
			Thread.sleep(1000);
			for(Thread p : threadList) {
				System.out.println(p.getName() + " " + p.getState());
			}
		}
		
	}
	
	static class Friend {
		private final String name;
		
		public Friend(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public synchronized void bow(Friend friend) {
			System.out.println(this.name + " : " + friend.name + " has bowed to me");
			friend.bowBack(this);
		}
		
		public synchronized void bowBack(Friend friend) {
			System.out.println(this.name + " : " + friend.name + " has bowed back to me");
		}
	}

}
