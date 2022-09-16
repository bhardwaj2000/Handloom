package com.km.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.km.entity.KmOrder;
import com.km.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<KmOrder> getAllOrders(){
		return orderRepository.findAll();
		}
	public KmOrder getOrder(int id) {
		KmOrder kmOrder=null;
		try {
			kmOrder=orderRepository.findById(id).get();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return kmOrder;
	}
	public KmOrder addOrder(KmOrder order) {
		KmOrder order2=orderRepository.save(order);
		return order2;
	}
	public void deleteOrder(int id) {
		orderRepository.deleteById(id);
	}
	public void updateOrder(KmOrder order,int id) {
		order.setorderId(id);
		orderRepository.save(order);
	}

}
