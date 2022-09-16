package com.km;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.km.entity.KmOrder;
import com.km.repository.OrderRepository;

@SpringBootApplication
public class HandloomApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(HandloomApplication.class, args);
		OrderRepository orderRepository=context.getBean(OrderRepository.class);
//		KmOrder order=new KmOrder();
//		order.setBuyer("omkar");
//		order.setItem("dormat");
//		orderRepository.save(order);
//		System.out.println(order);
		
//		orderRepository.deleteAll();
		
		
	}
//	
//	public void addCrosMappings(CorsRegistry registry) {
//		registry.addMapping("/**").allowedMethods("GET","POST");
//	}

}
