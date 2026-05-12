package ecommerce;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.Add_to_cart;
import pages.OrderPage;
import pages.ViewOrderPage;

public class ViewOrderTest extends BaseTest{
	@Test
	public void view() {
		Add_to_cart prod = new Add_to_cart(driver);
	    prod.add_to_cart();  
		OrderPage order= new OrderPage(driver);
		ViewOrderPage vieworder= order.orderProduct();
		vieworder.goToOrdersPage();
	}
}
