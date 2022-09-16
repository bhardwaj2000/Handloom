package com.km.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.km.entity.KmOrder;

@Repository
public interface OrderRepository extends JpaRepository<KmOrder, Integer>{

}
