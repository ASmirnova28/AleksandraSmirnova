package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorMultiplicationTest extends AbstractCalculatorTest{

    @DataProvider(name="multiplicationData")
    public Object[][] TestData() {
        return new Double[][] {
                new Double[] {5.0, 5.0, 25.0},
                new Double[] {-5.0, 5.0, -25.0},
                new Double[] {0.0, 5.0, 0.0}
        };
    }

    @Test(dataProvider = "multiplicationData")
    public void multiplyDoubleTest(double a, double b, double expected) {
        Assert.assertEquals(calculator.mult(a, b), expected);
    }

}
