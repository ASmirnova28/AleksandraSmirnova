package hw2.ex2;

import hw2.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Ex2Test extends AbstractTest {

    @Test
    public void ex2Test() {

        //1-4. Steps are in CommonStepsTest class
        commonTS.fourInitialSteps();

        // 5. Open through the header menu Service -> Different Elements Page
        WebElement menuService = webDriver.findElement(By.xpath("//li[3]/a[1]"));
        menuService.click();
        WebElement diffElemPage = webDriver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[8]"));
        diffElemPage.click();
        softAssert.assertEquals(webDriver.getTitle(), "Different Elements");

        // 6. Select checkboxes
        WebElement checkbox1 = webDriver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox1.click();
        softAssert.assertTrue(checkbox1.isSelected());
        WebElement checkbox2 = webDriver.findElement(By.xpath("//label[3]/input"));
        checkbox2.click();
        softAssert.assertTrue(checkbox2.isSelected());

        // 7. Select radio
        WebElement radio = webDriver.findElement(By.xpath("//div[3]/label[4]/input"));
        radio.click();
        softAssert.assertTrue(radio.isSelected());

        // 8. Select in dropdown
        webDriver.findElement(By.className("colors")).click();
        WebElement yellow = webDriver.findElement(By.xpath("//select[@class='uui-form-element']/option[text()='Yellow']"));
        yellow.click();
        softAssert.assertTrue(yellow.isSelected());

         /*9. Assert that
         • for each checkbox there is an individual log row and value is corresponded to the status of checkbox
         • for radio button there is a log row and value is corresponded to the status of radio button
         • for dropdown there is a log row and value is corresponded to the selected value.*/
        List<WebElement> logRows = webDriver.findElements(By.xpath("//section[div[contains(text(), 'log')]]/div/div/ul/li"));
        List<String> list3 = Arrays.asList("Water", "Wind", "Yellow", "Selen");
        for (WebElement l : logRows) {
            softAssert.assertTrue(list3.contains(l.getText()));
        }

        // 10. Close Browser
        webDriver.close();
        softAssert.assertAll();
    }
}
