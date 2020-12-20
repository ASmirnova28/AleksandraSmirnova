import hw1.DataProviders;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorMultiplicationTest extends AbstractCalculatorTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "multiplicationData")
    public void multiplicationTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected, 0.0001);
    }
}
