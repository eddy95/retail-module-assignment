package com.assignment.retail.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.assignment.retail.service.RetailService;

@RunWith(SpringJUnit4ClassRunner.class)
public class RetailControllerTest {

	@InjectMocks
	RetailController retailController;

	@Mock
	RetailService retailService;

	@Test
	public void fetchBillTest() {
		MockitoAnnotations.initMocks(this);
		when(retailService.fetchBill("virat")).thenReturn(5.0);
		double actual = retailController.fetchBill("virat");
		assertNotNull(actual);
	}

}
