import hw1.DataProviders;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorAdditionTest extends AbstractCalculatorTest {

@Test(dataProviderClass = DataProviders.class, dataProvider = "additionData")
public void additionTest(double a, double b, double expected) {
    double actual = calculator.sum(a, b);
    assertEquals(actual, expected, 0.0001);
}



}




