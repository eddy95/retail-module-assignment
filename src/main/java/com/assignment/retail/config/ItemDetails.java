package com.assignment.retail.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.assignment.retail.constants.ItemConstants;

@Component
public class ItemDetails {

	private final Map<String, Double> itemsMap = new HashMap<>();

	@PostConstruct
	private void fillItems() {
		itemsMap.put(ItemConstants.GROCERIES, 50.0);
		itemsMap.put(ItemConstants.ELECTRONIC, 60.0);
		itemsMap.put(ItemConstants.FURNITURE, 80.0);
		itemsMap.put(ItemConstants.CLOTHES, 100.0);
		itemsMap.put(ItemConstants.SHOES, 120.0);
	}

	public Map<String, Double> getItemsMap() {
		return itemsMap;
	}
}
