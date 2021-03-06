package lesson1.tests.selenium;

import pages.seleniumPages.MainPage;
import test.SeleniumBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static test.enums.Urls.SITE;
import static org.testng.Assert.assertEquals;

public class CheckLinkPhonesAndAccessoriesTest extends SeleniumBase {
    private MainPage mainPage;

    @BeforeMethod
    public void beforeMethod() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void checkLinkPhonesAndAccessories() {

        // Navigate aliexpress
        driver.navigate().to(SITE.getUrl());

        //Click on categories
        mainPage.categoriesFolder.click();

        // Click on link Phones and accessories
        mainPage.clickOnCellphonesCategoryLink();

        // Expected title
        String expectedTitle = "Купить Мобильные телефоны и аксессуары по низкой цене в интернет магазине АлиЭкспресс";

        // Actual title
        String actualTitle = driver.getTitle();

        // Equals titles
        assertEquals(actualTitle, expectedTitle);
    }
}
