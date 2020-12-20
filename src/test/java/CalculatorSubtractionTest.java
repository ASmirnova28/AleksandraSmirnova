import hw1.DataProviders;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorSubtractionTest extends AbstractCalculatorTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "subtractionData")
    public void subtractionTest(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected, 0.0001);
    }
}
