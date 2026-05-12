package ecommerce;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.Add_to_cart;
import pages.OrderPage;

public class OrderTest extends BaseTest{
	@Test
	public void order() {
		Add_to_cart prod= new Add_to_cart(driver);
		prod.add_to_cart();
		OrderPage order= new OrderPage(driver);
		order.orderProduct();
		
	}
}
