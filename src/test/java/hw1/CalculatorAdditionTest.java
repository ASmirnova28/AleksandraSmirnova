package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorAdditionTest extends AbstractCalculatorTest {

        @DataProvider(name = "additionData")
        public Object[][] additionTestData() {
            return new Double[][] {
                    new Double[] {5.0, 5.0, 10.0},
                    new Double[] {-5.0, 5.0, 0.0},
                    new Double[] {0.0, -5.0, -5.0}
            };
        }

        @Test(dataProvider = "additionData")
        public void additionTest(double a, double b, double expected) {
            Assert.assertEquals(calculator.sum(a, b), expected);
        }

    }




