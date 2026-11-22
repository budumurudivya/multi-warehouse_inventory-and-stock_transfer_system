package com.example.ware_house.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ware_house.model.ProductData;
import com.example.ware_house.model.WareHouseData;
import com.example.ware_house.request.ProductRequest;
import com.example.ware_house.request.WareHouseRequest;
import com.example.ware_house.service.WareHouseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class WareHouseController {

	private final WareHouseService ser;

	@PostMapping("/products")
	public ResponseEntity<String> createProduct(@RequestBody ProductRequest req) {
		long data = ser.createProduct(req);
		return new ResponseEntity<String>("Product Added SuccessFully" + data, HttpStatus.CREATED);
	}

	@PutMapping("/products")
	public ResponseEntity<String> updateProduct(@RequestBody ProductRequest req) {
		long data = ser.updateProduct(req);
		return new ResponseEntity<String>("Product Data Updated" + data, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/products/productId/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable long productId) {
		long data = ser.deleteProduct(productId);
		return new ResponseEntity<String>("Product Deleted " + data, HttpStatus.ACCEPTED);
	}

	@GetMapping("/products")
	public ResponseEntity<List<ProductData>> getAllTickets() {

		List<ProductData> data = ser.getAllProducts();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping("/products/productId/{productId}")
	public ResponseEntity<ProductData> getProductById(long productId) {

		ProductData data = ser.getProductById(productId);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	
	
	//wareshouses.
	@PostMapping("/warehouses")
	public ResponseEntity<String> createWareHouse(@RequestBody WareHouseRequest req) {
		long data = ser.createWareHouse(req);
		return new ResponseEntity<String>("WareHouse Added SuccessFully" + data, HttpStatus.CREATED);
	}

	@PutMapping("/warehouses")
	public ResponseEntity<String> updateWareHouse(@RequestBody WareHouseRequest req) {
		long data = ser.updateWareHouse(req);
		return new ResponseEntity<String>("WareHouse Data Updated" + data, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/warehouses/wid/{wid}")
	public ResponseEntity<String> deleteWarehouse(@PathVariable long wid) {
		ser.deleteWareHouse(wid);
		return new ResponseEntity<String>("WareHouse Deleted ", HttpStatus.ACCEPTED);
	}

	@GetMapping("/warehouses")
	public ResponseEntity<List<WareHouseData>> getAllWareHouses() {

		List<WareHouseData> data = ser.getAllWareHouses();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping("/warehouses/wid/{wid}")
	public ResponseEntity<WareHouseData> getWarehousById(long wid) {
		WareHouseData data = ser.getWareHouseById(wid);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

}
