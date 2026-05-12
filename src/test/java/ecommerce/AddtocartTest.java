package ecommerce;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.Add_to_cart;

public class AddtocartTest extends BaseTest{
	@Test
	public void addcartproduct() {
		Add_to_cart prod= new Add_to_cart(driver);
		 prod.add_to_cart();
	}
}
