import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

public abstract class AbstractCalculatorTest {

    protected Calculator calculator;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterClass
    public void tearDown() {
        calculator = null;
    }
}
