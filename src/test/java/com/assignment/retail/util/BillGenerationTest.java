package com.assignment.retail.util;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.assignment.retail.config.ItemDetails;
import com.assignment.retail.constants.ItemConstants;
import com.assignment.retail.constants.RoleConstants;
import com.assignment.retail.factory.DiscountFactory;
import com.assignment.retail.model.UserEntity;

@RunWith(SpringJUnit4ClassRunner.class)
public class BillGenerationTest {

	@Mock
	ItemDetails itemDetails;

	@Mock
	DiscountFactory discountFactory;

	@InjectMocks
	BillGeneration billGeneration;

	private final Map<String, Double> itemsMap = new HashMap<>();

	@Test
	public void generateBillForFirstCustomerTest() {
		MockitoAnnotations.initMocks(this);
		itemsMap.put(ItemConstants.GROCERIES, 50.0);
		itemsMap.put(ItemConstants.ELECTRONIC, 60.0);
		itemsMap.put(ItemConstants.FURNITURE, 80.0);
		itemsMap.put(ItemConstants.CLOTHES, 100.0);
		itemsMap.put(ItemConstants.SHOES, 120.0);

		when(itemDetails.getItemsMap()).thenReturn(itemsMap);
		double bill = billGeneration.generateBill(Optional.empty());
		assertNotNull(bill);

	}

	@Test
	public void generateBillForEmployeeTest() {
		MockitoAnnotations.initMocks(this);
		itemsMap.put(ItemConstants.GROCERIES, 50.0);
		itemsMap.put(ItemConstants.ELECTRONIC, 60.0);
		itemsMap.put(ItemConstants.FURNITURE, 80.0);
		itemsMap.put(ItemConstants.CLOTHES, 100.0);
		itemsMap.put(ItemConstants.SHOES, 120.0);

		UserEntity userEntity = new UserEntity();
		userEntity.setRole(RoleConstants.EMPLOYEE);
		userEntity.setUsername("virat");
		userEntity.setUserRegisteredDate(LocalDateTime.now());
		when(discountFactory.getDiscountServiceObject(RoleConstants.EMPLOYEE).discount()).thenReturn(30.0);
		when(itemDetails.getItemsMap()).thenReturn(itemsMap);
		double bill = billGeneration.generateBill(Optional.of(userEntity));
		assertNotNull(bill);

	}
}
