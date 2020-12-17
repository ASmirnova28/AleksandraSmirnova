package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSubtractionTest extends AbstractCalculatorTest {

    @DataProvider(name="subtractionData")
    public Object[][] TestData() {
        return new Double[][] {
                new Double[] {5.0, 5.0, 0.0},
                new Double[] {-5.0, 5.0, -10.0},
                new Double[] {0.0, 5.0, -5.0}
        };
    }

    @Test(dataProvider = "subtractionData")
    public void subtractTest(double a, double b, double expected) {
        Assert.assertEquals(calculator.sub(a, b), expected);
    }

}
