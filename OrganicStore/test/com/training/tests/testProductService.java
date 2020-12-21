package com.training.tests;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.DisplayName;

import com.training.models.Edible;
import com.training.models.Products;
import com.training.services.ProductService;
import com.training.utils.ConnectionUtils;

class testProductService {
	
	ProductService service = new ProductService();
	Connection con = ConnectionUtils.getConnectionFromPool();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before is called only once before all tests");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After is all called only once after all tests");
	}

	@BeforeEach
	void setUp(TestInfo info) throws Exception {
		System.out.println(info.getDisplayName()+" Called");
	}

	@AfterEach
	void tearDown(TestInfo info) throws Exception {
		System.out.println(info.getDisplayName() + " Finished");

	}
	
	@Test
	@DisplayName("test for row gets added or not")
	void testIfRowIsAdded() {
		Edible e1 = new Edible(100,"testItem",0.0,1,"random", "random","random");
		ProductService service = new ProductService(con);
		boolean actual = service.add(e1);
		assertEquals(true,actual);
	}
	
	@Test
	@DisplayName("test for retrieving data is not empty")
	void testListNotEmpty() {
		String tableName = "Garments";
		String dateCheck = "2020-11-12";
		List<Products> list=service.findAll(tableName,dateCheck);
				assertNotNull(list);
	}
	@Test
	@DisplayName("test for retrieving maximum sale info is not empty")
	void testMaxSaleisNotEmpty() {
		String tableName = "Garments";
		List<Products> list1=service.findMax(tableName);
				assertNotNull(list1);						
	}

}
