package com.assignment.retail.factory;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.assignment.retail.constants.RoleConstants;
import com.assignment.retail.service.DiscountService;
import com.assignment.retail.service.impl.AffiliateServiceImpl;
import com.assignment.retail.service.impl.CustomerServiceImpl;
import com.assignment.retail.service.impl.EmployeeServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class DiscountFactoryTest {

	final private Map<String, DiscountService> map = new HashMap<>();

	@InjectMocks
	DiscountFactory discountFactory;

	@Mock
	AffiliateServiceImpl affiliateServiceImpl;
	@Mock
	CustomerServiceImpl customerServiceImpl;
	@Mock
	EmployeeServiceImpl employeeServiceImpl;

	@Test
	public void getDiscountServiceObjectTest() {
		MockitoAnnotations.initMocks(this);
		map.put(RoleConstants.AFFILIATE, affiliateServiceImpl);
		map.put(RoleConstants.CUSTOMER, customerServiceImpl);
		map.put(RoleConstants.EMPLOYEE, employeeServiceImpl);

		ReflectionTestUtils.setField(discountFactory, "map", map);
		DiscountService discountService = discountFactory.getDiscountServiceObject(RoleConstants.EMPLOYEE);
		assertNotNull(discountService);

	}

}
