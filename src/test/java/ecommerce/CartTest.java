package ecommerce;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.Add_to_cart;
import pages.CartPage;

public class CartTest extends BaseTest{
	@Test
	public void cart() {
		Add_to_cart prod= new Add_to_cart(driver);
		prod.add_to_cart();
		CartPage cartp= new CartPage(driver);
		cartp.cartView();
		System.out.println("Cart view ");
	}
}
