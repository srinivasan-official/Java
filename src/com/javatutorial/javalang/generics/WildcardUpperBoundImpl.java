package com.javatutorial.javalang.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardUpperBoundImpl {

	public static void main(String[] args) {
		WildcardUpperBoundUtil wubUtil = new WildcardUpperBoundUtil();
		
		List<Integer> integerArr = Arrays.asList(1, 2, 3, 4, 5);
		//System.out.println(wubUtil.getSum(integerArr));
		
		List<Double> doubleArr = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);
		//System.out.println(wubUtil.getSum(doubleArr));
		
		SyncSettings elb = new SyncSettings();
		elb.setServiceName("ELB");
		elb.setFreqOfSync(1);
		elb.setHourlySync(true);
		
		SyncSettings ec2 = new SyncSettings();
		ec2.setServiceName("EC2");
		ec2.setFreqOfSync(2);
		ec2.setHourlySync(true);
		
		Route53Settings acm = new Route53Settings();
		acm.setServiceName("ACM");
		acm.setFreqOfSync(3);
		acm.setHourlySync(true);
		acm.setRoute53FreqOfSync(4);
		acm.setRoute53HourlySync(true);
		
		List<? extends SyncSettings> syncSettings = Arrays.asList(elb, ec2, acm);
		for(SyncSettings syncSetting : syncSettings) {
			System.out.print(syncSetting.getServiceName() + " " + syncSetting.getFreqOfSync() + " " + syncSetting.isHourlySync());
			if("ACM".equals(syncSetting.getServiceName())) {
				//Route53Settings route53 = (Route53Settings) syncSettings;
				//System.out.print(route53.getRoute53FreqOfSync() + " " + route53.isRoute53HourlySync());
			}
			System.out.println();
		}
		
		SyncSettings s = (SyncSettings) acm;
		Route53Settings r = (Route53Settings) s;
	}

}

class WildcardUpperBoundUtil {
	public double getSum(List<? extends Number> list) {
		double sum = 0;
		
		for(Number n : list) {
			sum += n.doubleValue();
		}
		
		//list.forEach(System.out::println);
		
		return sum;
	}
}

class SyncSettings {
	private String serviceName;
	private int freqOfSync;
	private boolean isHourlySync;
	
	public int getFreqOfSync() {
		return freqOfSync;
	}
	
	public void setFreqOfSync(int freqOfSync) {
		this.freqOfSync = freqOfSync;
	}
	
	public boolean isHourlySync() {
		return isHourlySync;
	}
	
	public void setHourlySync(boolean isHourlySync) {
		this.isHourlySync = isHourlySync;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
}

class Route53Settings extends SyncSettings {
	private int route53FreqOfSync;
	private boolean isRoute53HourlySync;
	
	public int getRoute53FreqOfSync() {
		return route53FreqOfSync;
	}
	
	public void setRoute53FreqOfSync(int route53FreqOfSync) {
		this.route53FreqOfSync = route53FreqOfSync;
	}
	
	public boolean isRoute53HourlySync() {
		return isRoute53HourlySync;
	}
	
	public void setRoute53HourlySync(boolean isRoute53HourlySync) {
		this.isRoute53HourlySync = isRoute53HourlySync;
	}
}