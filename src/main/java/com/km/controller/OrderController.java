package com.km.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.km.entity.KmOrder;
import com.km.repository.OrderRepository;
import com.km.service.OrderService;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/orders")
	public List<KmOrder> getAllOrders(){
		List<KmOrder> orderList=orderService.getAllOrders();
//		if(orderList.size()<=0) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
		return orderList;
	}
	
	@GetMapping("/orders/{id}")
	public KmOrder getOrder(@PathVariable("id") int id){
		KmOrder order = orderService.getOrder(id);
//		if(order==null) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//		return ResponseEntity.status(HttpStatus.FOUND).body(order);
		return order;
	}
	
	// for insert handler
	@PostMapping("/orders")
	public ResponseEntity<KmOrder> addOrder(@RequestBody KmOrder order) {
		KmOrder u=null;
		try {
			u=orderService.addOrder(order);
			System.out.println("order added : "+u);
			return ResponseEntity.status(HttpStatus.CREATED).body(u);// it show status created and return to body
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	// for delete handler
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Object> DeleteOrder(@PathVariable("id") int id) {
		System.out.println("given id is deleted "+id);
		try {
			orderService.deleteOrder(id);
			return ResponseEntity.ok().body("id deleted "+id);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	// for update handler
	@PutMapping("/orders/{id}")
	public ResponseEntity<KmOrder> updateOrder(@RequestBody KmOrder order,@PathVariable("id") int id) {
		try {
			this.orderService.updateOrder(order, id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(order);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}
