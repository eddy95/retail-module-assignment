package com.assignment.retail.util;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.retail.config.ItemDetails;
import com.assignment.retail.constants.ItemConstants;
import com.assignment.retail.constants.RoleConstants;
import com.assignment.retail.factory.DiscountFactory;
import com.assignment.retail.model.UserEntity;

@Component
public class BillGeneration {

	@Autowired
	ItemDetails itemDetails;

	@Autowired
	DiscountFactory discountFactory;

	public double generateBill(Optional<UserEntity> user) {
		double bill = 0.0;
		if (user.isPresent()) {
			String role = user.get().getRole();
			double discount = discountFactory.getDiscountServiceObject(role).discount();
			switch (role) {
			case RoleConstants.CUSTOMER: {
				discount = (LocalDateTime.now().getYear() - user.get().getUserRegisteredDate().getYear()) >= 2
						? discount
						: 0;
				break;
			}
			}

			for (Map.Entry<String, Double> entry : itemDetails.getItemsMap().entrySet()) {
				if (!entry.getKey().equals(ItemConstants.GROCERIES)) {
					bill = bill + entry.getValue();
				}
			}
			bill = (bill - (bill * (discount / 100))) + itemDetails.getItemsMap().get(ItemConstants.GROCERIES);
		} else {
			for (Map.Entry<String, Double> entry : itemDetails.getItemsMap().entrySet()) {
				bill = bill + entry.getValue();
			}
		}
		return calculateOtherDiscount(bill);
	}

	private double calculateOtherDiscount(double bill) {
		if (bill / 100 >= 1) {
			bill = bill - Math.floor(bill / 100) * 5;
		}
		return bill;
	}
}
