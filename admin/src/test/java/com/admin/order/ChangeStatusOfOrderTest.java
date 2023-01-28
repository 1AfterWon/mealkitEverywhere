package com.admin.order;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.Criteria;
import com.admin.dto.OrderDTO;
import com.admin.service.OrderService;

@SpringBootTest
class ChangeStatusOfOrderTest {

	@Autowired
	OrderService os;
	
	@Test
	void contextLoads() {
		System.out.println("-------- 주문 상태 변경 테스트 시작 ---------");
		
		
		List<String> orderKeyList = new ArrayList<String>();
		String status = "D";
		
		orderKeyList.add("4634");
		orderKeyList.add("4631");
		orderKeyList.add("4433");
		
		System.out.println("변경할 상태 : " + status);
		System.out.println("변경할 주문키 : " + orderKeyList);
		
		for(String i : orderKeyList) {
			os.statusChange(status, Integer.parseInt(i));
			System.out.println("변경할 주문키: "+i);
			System.out.println("변경된 주문 상태: "+ status);
		}
		
		System.out.println("-------- 주문 상태 변경 테스트 끝 ---------");
	}

}