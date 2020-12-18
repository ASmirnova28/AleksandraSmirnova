import hw1.DataProviders;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivisionTest extends AbstractCalculatorTest {

@Test(dataProviderClass = DataProviders.class, dataProvider = "divisionData")
public void divisionTest(double a, double b, double expexted) {
    double actual = calculator.div(a, b);
    assertEquals(actual, expexted, 0.0001);

}


}
