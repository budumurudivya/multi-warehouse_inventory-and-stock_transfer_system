package com.example.ware_house.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.example.ware_house.dao.WareHouseDao;
import com.example.ware_house.model.ProductData;
import com.example.ware_house.model.WareHouseData;
import com.example.ware_house.request.ProductRequest;
import com.example.ware_house.request.WareHouseRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WareHouseService {

	private final WareHouseDao dao;

	public long createProduct(ProductRequest req) {
		return dao.createProduct(req);
	}

	public long updateProduct(ProductRequest req) {
		dao.updateProduct(req);
		;
		return req.getId();
	}

	public long deleteProduct(long id) {
		dao.deleteProduct(id);
		return id;

	}

	public List<ProductData> getAllProducts() {
		return dao.getAllProducts();
	}

	public ProductData getProductById(long productId) {
		return dao.getAllProducts(productId);
	}

	// .ware house apis.
	public long createWareHouse(WareHouseRequest req) {
		return dao.createWareHouse(req);
	}

	public long updateWareHouse(WareHouseRequest req) {
		dao.updateWareHouse(req);
		return req.getId();
	}

	public void deleteWareHouse(long id) {
		dao.deleteWareHouse(id);
	}

	public List<WareHouseData> getAllWareHouses() {
		return dao.getAllWareHouses();
	}

	public WareHouseData getWareHouseById(long id) {
		return dao.getWareHouseById(id);
	}

}
