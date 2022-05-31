package com.invest.microservices.mainlogic.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLoadBanlancerController {
	
	protected final String APP_NOTIFICATION = "1invest-notification";
	
	@Autowired
    private LoadBalancerClient loadBalancer;
	
	@GetMapping("/notification-test")
	public String testLoadBalancer() throws Exception {
		ServiceInstance serviceInstance = this.loadBalancer.choose(APP_NOTIFICATION);
		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello";
		return url;
	}
	
}
