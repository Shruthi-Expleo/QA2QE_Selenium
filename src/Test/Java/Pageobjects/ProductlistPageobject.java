package Pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.Keys.ENTER;

public class ProductlistPageobject {

        private WebElement search;


    public void entersearch(String searchtext) {
        search.clear();
        search.sendKeys(searchtext);
        search.sendKeys(Keys.ENTER);
    }

}