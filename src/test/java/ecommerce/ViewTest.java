package ecommerce;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.View_Product;

public class ViewTest extends BaseTest{
	@Test(groups= {"smoke"})
	public void viewProduct() {
		View_Product prod= new View_Product(driver,"ViewProduct");
		 prod.viewProduct();
	}
}
