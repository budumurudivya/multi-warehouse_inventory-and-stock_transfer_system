package com.example.ware_house.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.ware_house.model.ProductData;
import com.example.ware_house.model.WareHouseData;
import com.example.ware_house.request.ProductRequest;
import com.example.ware_house.request.WareHouseRequest;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@PropertySource("classpath:dao/warehouse/wareHouseDao.xml")
public class WareHouseDao {

	private final RowMapper<WareHouseData> wareHouseMapper = BeanPropertyRowMapper.newInstance(WareHouseData.class);
	private final RowMapper<ProductData> productMapper = BeanPropertyRowMapper.newInstance(ProductData.class);

	private final NamedParameterJdbcTemplate npjt;

	@Value("${createProduct}")
	private String createProduct;

	@Value("${deleteProduct}")
	private String deleteProduct;

	@Value("${getAllProducts}")
	private String getAllProducts;

	@Value("${getProductById}")
	private String getProductById;

	@Value("${updateProduct}")
	private String updateProduct;

	// warehouses.

	@Value("${getWareHouseById}")
	private String getWareHouseById;

	@Value("${getAllWareHouses}")
	private String getAllWareHouses;

	@Value("${deleteWareHouse}")
	private String deleteWareHouse;

	@Value("${updateWareHouse}")
	private String updateWareHouse;

	@Value("${createWareHouse}")
	private String createWareHouse;

	public long createProduct(ProductRequest req) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		npjt.update(createProduct, new BeanPropertySqlParameterSource(req), keyHolder, new String[] { "id" });
		return keyHolder.getKey().longValue();
	}

	public void updateProduct(ProductRequest req) {
		npjt.update(updateProduct, new BeanPropertySqlParameterSource(req));
	}

	public void deleteProduct(long id) {
		npjt.update(deleteProduct, Map.of("id", id));
	}

	public List<ProductData> getAllProducts() {
		return Optional.ofNullable(npjt.query(getAllProducts, productMapper)).orElse(Collections.emptyList());
	}

	public ProductData getAllProducts(long productId) {
		return npjt.query(getAllProducts, Map.of("id", productId), productMapper).stream().findFirst().orElse(null);
	}

	public long createWareHouse(WareHouseRequest req) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		npjt.update(createWareHouse, new BeanPropertySqlParameterSource(req), keyHolder, new String[] { "id" });
		return keyHolder.getKey().longValue();
	}

	public long updateWareHouse(WareHouseRequest req) {
		npjt.update(updateWareHouse, new BeanPropertySqlParameterSource(req));
		return req.getId();
	}

	public void deleteWareHouse(long id) {
		npjt.update(deleteWareHouse, Map.of("id", id));
	}

	public List<WareHouseData> getAllWareHouses() {
		return Optional.ofNullable(npjt.query(getAllWareHouses, wareHouseMapper)).orElse(Collections.emptyList());
	}

	public WareHouseData getWareHouseById(long id) {
		return npjt.query(getWareHouseById, Map.of("id", id), wareHouseMapper).stream().findFirst().orElse(null);
	}

}
