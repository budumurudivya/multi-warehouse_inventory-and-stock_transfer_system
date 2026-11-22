package com.example.ware_house.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

	private long id;
	private String productName;
	private String sku;
	private String catagery;
	private String unit;
	private double costPrice;
	private double sellingPrice;
	private long quantity;
	private String status;

}
