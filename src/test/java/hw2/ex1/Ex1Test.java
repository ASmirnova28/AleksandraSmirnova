package hw2.ex1;

import hw2.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex1Test extends AbstractTest {

    @Test
    public void ex1Test() {

        //1-4. Steps are in CommonStepsTest class
        commonTS.fourInitialSteps();

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerItems = webDriver.findElements(By.cssSelector("ul.m-l8 > li"));
        softAssert.assertEquals(headerItems.size(), 4);
        List<String> headerText = new ArrayList<>();
        for (WebElement headerItem : headerItems) {
            headerText.add(headerItem.getText());
        }
        List<String> list1 = Arrays.asList("HOME", "CONTACT FORM"
                , "SERVICE", "METALS & COLORS");
        softAssert.assertEquals(headerText, list1);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = webDriver.findElements(By.className("benefit"));
        softAssert.assertEquals(images.size(), 4);
        for (WebElement image : images) {
            softAssert.assertTrue(image.isDisplayed());
        }

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        for (WebElement text : webDriver.findElements(By.className("benefit"))) {
            if (!text.findElement(By.className("benefit-txt")).getText().equals("")) {
                softAssert.assertTrue(text.isDisplayed());
            }
        }

        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(webDriver.findElement(By.id("frame")).isDisplayed());

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");
        softAssert.assertTrue(webDriver.findElement(By.id("frame-button")).isDisplayed());

        // 10. Switch to original window back
        webDriver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSectionItems = webDriver.findElements(By.cssSelector("ul.sidebar-menu > li"));
        softAssert.assertEquals(leftSectionItems.size(), 5);
        List<String> items = new ArrayList<>();
        for (WebElement leftSectionItem : leftSectionItems) {
            items.add(leftSectionItem.getText());
        }
        List<String> list2 = Arrays.asList("Home", "Contact form", "Service"
                , "Metals & Colors", "Elements packs");
        softAssert.assertEquals(items, list2);

        // 12. Close Browser
        webDriver.close();
        softAssert.assertAll();
    }
}
