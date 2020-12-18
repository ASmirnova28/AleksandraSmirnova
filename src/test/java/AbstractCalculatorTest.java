import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

public abstract class AbstractCalculatorTest {

    protected Calculator calculator;

    @BeforeSuite
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterSuite
    public void tearDown() {
        calculator = null;
    }
}
