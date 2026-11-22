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
public class WareHouseRequest {
	private long id;
	private String name;
	private String code;
	private String city;
	private String address;
	private String status;

}
