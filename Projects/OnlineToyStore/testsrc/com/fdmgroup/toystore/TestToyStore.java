package com.fdmgroup.toystore;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.toystore.exception.InventoryLowException;
import com.fdmgroup.toystore.exception.OutOfStockException;
import com.fdmgroup.toystore.exception.ProductRecallException;

public class TestToyStore{
	ToyStore myToyStore;
	@Mock private Product toy1, toy2, toy3;
	@Mock private Stock stock1, stock2, stock3;
	@Mock private OrderLine order1, order2, order3, order4, order5;
	OrderLines orderToy1, orderToy2, orderToy3, orderToy4, orderAllToys123;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
	}

	@Before
	public void setUp() throws Exception {
		myToyStore = new ToyStore();
		MockitoAnnotations.initMocks(this);
		
		BigDecimal price = new BigDecimal(100);
		
		when(toy1.getName()).thenReturn("Buzz Lightyear");
		when(toy1.getDesc()).thenReturn("Infinity & Beyond!");
		when(toy1.getPrice()).thenReturn(price);
		
		when(toy2.getName()).thenReturn("Sheriff Woody");
		when(toy2.getDesc()).thenReturn("Howdy Partner!");
		when(toy2.getPrice()).thenReturn(price);
		
		when(toy3.getName()).thenReturn("Little Bo Peep");
		when(toy3.getDesc()).thenReturn("Sheep Sheep Sheep!");
		when(toy3.getPrice()).thenReturn(price);
		when(toy3.isRecalled()).thenReturn(true);
		
		when(stock1.getProduct()).thenReturn(toy1);
		when(stock1.getStock()).thenReturn(8);
		
		when(stock2.getProduct()).thenReturn(toy2);
		when(stock2.getStock()).thenReturn(0);
		
		when(stock3.getProduct()).thenReturn(toy3);
		when(stock3.getStock()).thenReturn(0);
		
		myToyStore.addStockToInventory(stock1);
		myToyStore.addStockToInventory(stock2);
		myToyStore.addStockToInventory(stock3);
		
		when(order1.getProduct()).thenReturn(toy1);
		when(order1.getStock()).thenReturn(3);
		
		when(order2.getProduct()).thenReturn(toy2);
		when(order2.getStock()).thenReturn(2);
		
		when(order3.getProduct()).thenReturn(toy3);
		when(order3.getStock()).thenReturn(0);
		
		orderToy1 = new OrderLines(1);
		orderToy2 = new OrderLines(2);
		orderToy3 = new OrderLines(3);
		orderToy4 = new OrderLines(4);
		orderAllToys123 = new OrderLines(123);
		
		orderToy1.placeOrders(order1);
		orderToy2.placeOrders(order2);
		orderToy3.placeOrders(order3);
		orderAllToys123.placeOrders(order1, order2, order3);
		
		when(order4.getProduct()).thenReturn(toy1);
		when(order4.getStock()).thenReturn(10);

		orderToy4.placeOrders(order4);
	}
	
	@After
	public void tearDown(){
		myToyStore = new ToyStore();
	}
	
	@Test 
	public void TestUpdateAndPurchase() throws ProductRecallException, InventoryLowException, OutOfStockException{
		ToyStore newStore = new ToyStore();
		Product newProduct1 = new Product(3, "Rex", "Giant Green Toy (1 Foot)", 75);
		Product newProduct2 = new Product(4, "Slinky Dog", "Got Springs For Daysss", 100);
		Stock newStock1 = new Stock(newProduct1, 20);
		Stock newStock2 = new Stock(newProduct2, 60);
		newStore.addStockToInventory(newStock1);
		newStore.addStockToInventory(newStock2);
		OrderLine newOrder1 = new OrderLine(1, newProduct1, 5);
		OrderLine newOrder2 = new OrderLine(2, newProduct2, 10);
		OrderLines newOrders = new OrderLines(5); 
		newOrders.placeOrders(newOrder1, newOrder2);
		newStore.executeOrders(newOrders);
		assertTrue((newStore.getInventory().size() == 2) && (newStore.getInventory().get(0).getStock() == 15) && (newStore.getInventory().get(1).getStock() == 50));
	}
	
	@Test 
	public void TestMultipleUpdatingStock(){
		ToyStore newStore = new ToyStore();
		Product newProduct1 = new Product(3, "Rex", "Giant Green Toy (1 Foot)", 75);
		Product newProduct2 = new Product(4, "Slinky Dog", "Got Springs For Daysss", 100);
		Stock newStock1 = new Stock(newProduct1, 20);
		Stock newStock2 = new Stock(newProduct2, 60);
		Stock newStock3 = new Stock(newProduct1, 30);
		Stock newStock4 = new Stock(newProduct2, 40);
		newStore.addStockToInventory(newStock1);
		newStore.addStockToInventory(newStock2);
		newStore.addStockToInventory(newStock3);
		newStore.addStockToInventory(newStock4);
		assertTrue((newStore.getInventory().size() == 2) && (newStore.getInventory().get(0).getStock() == 50) && (newStore.getInventory().get(1).getStock() == 100));
	}
	
	@Test 
	public void TestUpdatingStock(){
		ToyStore newStore = new ToyStore();
		Product newProduct1 = new Product(3, "Rex", "Giant Green Toy (1 Foot)", 75);
		Product newProduct2 = new Product(4, "Slinky Dog", "Got Springs For Daysss", 100);
		Product newProduct3 = new Product(3, "Rex", "Giant Green Toy (1 Foot)", 75);
		Stock newStock1 = new Stock(newProduct1, 20);
		Stock newStock2 = new Stock(newProduct2, 60);
		Stock newStock3 = new Stock(newProduct3, 30);
		newStore.addStockToInventory(newStock1);
		newStore.addStockToInventory(newStock2);
		newStore.addStockToInventory(newStock3);
		assertTrue((newStore.getInventory().size() == 2) && (newStore.getInventory().get(1).getStock() == 60));
	}
	
	@Test(expected = InventoryLowException.class)
	public void TestSuccessfulPurchases() throws OutOfStockException, ProductRecallException, InventoryLowException{
		ToyStore newStore = new ToyStore();
		Product newProduct1 = new Product(5, "Mr. Potato Head", "Where my nose?", 125);
		Product newProduct2 = new Product(6, "Mrs. Potato Head", "Where my lays?", 150);
		Stock newStock1 = new Stock(newProduct1, 12);
		Stock newStock2 = new Stock(newProduct2, 8);
		newStore.addStockToInventory(newStock1);
		newStore.addStockToInventory(newStock2);
		OrderLine newOrder1 = new OrderLine(1, newProduct1, 1);
		OrderLine newOrder2 = new OrderLine(2, newProduct2, 20);
		OrderLines newOrders = new OrderLines(5); 
		newOrders.placeOrders(newOrder1, newOrder2);
		newStore.executeOrders(newOrders);
	}
	
	@Test
	public void TestSingleSuccessfulPurchase2() throws OutOfStockException, ProductRecallException, InventoryLowException{
		ToyStore newStore = new ToyStore();
		Product newProduct1 = new Product(5, "Mr. Potato Head", "Where my nose?", 125);
		Product newProduct2 = new Product(6, "Mrs. Potato Head", "Where my lays?", 150);
		Stock newStock1 = new Stock(newProduct1, 12);
		Stock newStock2 = new Stock(newProduct2, 8);
		newStore.addStockToInventory(newStock1);
		newStore.addStockToInventory(newStock2);
		OrderLine newOrder1 = new OrderLine(1, newProduct1, 6);
		OrderLine newOrder2 = new OrderLine(2, newProduct2, 4);
		OrderLines newOrders = new OrderLines(5); 
		newOrders.placeOrders(newOrder1, newOrder2);
		newStore.executeOrders(newOrders);
		assertTrue(newStore.getInventory().get(1).getStock() == 4);
	}
	
	@Test
	public void TestSingleSuccessfulPurchase1() throws OutOfStockException, ProductRecallException, InventoryLowException{
		ToyStore newStore = new ToyStore();
		Product newProduct1 = new Product(5, "Mr. Potato Head", "Where my nose?", 125);
		Product newProduct2 = new Product(6, "Mrs. Potato Head", "Where my lays?", 150);
		Stock newStock1 = new Stock(newProduct1, 12);
		Stock newStock2 = new Stock(newProduct2, 8);
		newStore.addStockToInventory(newStock1);
		newStore.addStockToInventory(newStock2);
		OrderLine newOrder1 = new OrderLine(1, newProduct1, 5);
		OrderLine newOrder2 = new OrderLine(2, newProduct2, 3);
		OrderLines newOrders = new OrderLines(5); 
		newOrders.placeOrders(newOrder1, newOrder2);
		newStore.executeOrders(newOrders);
		
		assertTrue(newStore.getInventory().get(0).getStock() == 7);
	}
	
	@Test(expected = InventoryLowException.class) 
	public void TestLowInventory() throws OutOfStockException, ProductRecallException, InventoryLowException{
		myToyStore.executeOrders(orderToy4);
	}
	
	@Test(expected = OutOfStockException.class) 
	public void TestOutOfStock() throws OutOfStockException, ProductRecallException, InventoryLowException{
		myToyStore.executeOrders(orderToy2);
	}
	
	@Test(expected = ProductRecallException.class) 
	public void TestRecalled() throws OutOfStockException, ProductRecallException, InventoryLowException{
		myToyStore.executeOrders(orderToy3);
	}
	
	@Test 
	public void TestContainsOrderAllToys123(){
		assertTrue((orderAllToys123.getOrderLines().contains(order1)) && (orderAllToys123.getOrderLines().contains(order2)) && (orderAllToys123.getOrderLines().contains(order3)) );
	}
	
	@Test 
	public void TestSizeOrderAllToys123(){
		assertTrue(orderAllToys123.getOrderLines().size() == 3);
	}
	
	@Test 
	public void TestSizeOrderToy3(){
		assertTrue((orderToy3.getOrderLines().size() == 1) && (orderToy3.getOrderLines().get(0) == order3));
	}
	
	@Test 
	public void TestSizeOrderToy2(){
		assertTrue((orderToy2.getOrderLines().size() == 1) && (orderToy2.getOrderLines().get(0) == order2));
	}
	
	@Test 
	public void TestSizeOrderToy1(){
		assertTrue((orderToy1.getOrderLines().size() == 1) && (orderToy1.getOrderLines().get(0) == order1));
	}
	
	@Test
	public void TestForOrder3Stock(){
		assertTrue(order3.getStock() == 0);
	}
	
	@Test
	public void TestForOrder3Product(){
		assertTrue(order3.getProduct().getName() == "Little Bo Peep");
	}
	
	@Test
	public void TestForOrder2Stock(){
		assertTrue(order2.getStock() == 2);
	}
	
	@Test
	public void TestForOrder2Product(){
		assertTrue(order2.getProduct().getName() == "Sheriff Woody");
	}
	
	@Test
	public void TestForOrder1Stock(){
		assertTrue(order1.getStock() == 3);
	}
	
	@Test
	public void testOrderLinesWithNull() throws ProductRecallException, InventoryLowException, OutOfStockException{
		ToyStore toyStore = new ToyStore();
		toyStore.executeOrders(null);
	}
	
	
	@Test
	public void TestForOrder1Product(){
		assertTrue(order1.getProduct().getName() == "Buzz Lightyear");
	}
	
	@Test 
	public void TestForToyCountInventory(){
		assertTrue(myToyStore.getInventory().size() == 3);
	}
	
	@Test
	public void TestStockLittleBoDescription(){
		assertNotNull(stock3.toString());
	}
	
	@Test
	public void TestStockSherrifDescription(){
		assertNotNull(stock2.toString());
	}
	
	@Test
	public void TestStockBuzzDescription(){
		assertNotNull(stock1.toString());
	}
	
	@Test
	public void TestStockLittleBoNumber(){
		assertTrue((stock3.getProduct().getName() == "Little Bo Peep") && (stock3.getStock() == 0));
	}
	
	@Test
	public void TestStockSheriffNumber(){
		assertTrue((stock2.getProduct().getName() == "Sheriff Woody") && (stock2.getStock() == 0));
	}
	
	@Test
	public void TestStockBuzzNumber(){
		assertTrue((stock1.getProduct().getName() == "Buzz Lightyear") && (stock1.getStock() == 8));
	}
	
	@Test 
	public void TestForLittleBoRecallTrue(){
		assertTrue(myToyStore.getInventory().get(2).getProduct().isRecalled());
	}
	
	@Test 
	public void TestForLittleBoPrice(){
		BigDecimal value = new BigDecimal(100);
		BigDecimal price = myToyStore.getInventory().get(2).getProduct().getPrice();
		assertEquals(value, price);
	}
	
	@Test
	public void TestForLittleBoDesc(){
		assertTrue(myToyStore.getInventory().get(2).getProduct().getDesc() == "Sheep Sheep Sheep!");
	}
	
	@Test
	public void TestForLittleBoName(){
		assertTrue(myToyStore.getInventory().get(2).getProduct().getName() == "Little Bo Peep");
	}
	
	@Test 
	public void TestForSheriffRecallFalse(){
		assertFalse(myToyStore.getInventory().get(1).getProduct().isRecalled());
	}
	
	@Test 
	public void TestForSheriffPrice(){
		BigDecimal value = new BigDecimal(100);
		BigDecimal price = myToyStore.getInventory().get(1).getProduct().getPrice();
		assertEquals(value, price);
	}
	
	@Test
	public void TestForSheriffDesc(){
		assertTrue(myToyStore.getInventory().get(1).getProduct().getDesc() == "Howdy Partner!");
	}
	
	@Test
	public void TestForSheriffName(){
		assertTrue(myToyStore.getInventory().get(1).getProduct().getName() == "Sheriff Woody");
	}
	
	@Test 
	public void TestForBuzzRecallFalse(){
		assertFalse(myToyStore.getInventory().get(0).getProduct().isRecalled());
	}
	
	@Test 
	public void TestForBuzzPrice(){
		BigDecimal value = new BigDecimal(100);
		BigDecimal price = myToyStore.getInventory().get(0).getProduct().getPrice();
		assertEquals(value, price);
	}
	
	@Test
	public void TestForBuzzDesc(){
		assertTrue(myToyStore.getInventory().get(0).getProduct().getDesc() == "Infinity & Beyond!");
	}

	@Test
	public void TestForBuzzName(){
		assertTrue(myToyStore.getInventory().get(0).getProduct().getName() == "Buzz Lightyear");
	}
	
	@Test
	public void testToyStoreContructor(){
		assertNotNull(myToyStore);
	}
}