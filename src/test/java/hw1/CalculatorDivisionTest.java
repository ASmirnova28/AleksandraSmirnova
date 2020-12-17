package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorDivisionTest extends AbstractCalculatorTest {

    @DataProvider(name="divisionData")
    public Object[][] divisionTestData() {
        return new Double[][] {
                new Double[] {5.0, 5.0, 1.0},
                new Double[] {-5.0, 5.0, -1.0},
                new Double[] {0.0, 5.0, 0.0}
        };
    }

    @Test(dataProvider = "divisionData")
    public void divisionTest(double a, double b, double expected) {
        Assert.assertEquals(calculator.div(a, b), expected);
    }
}
