package hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "additionData")
    public Object[][] additionTestData() {
        return new Double[][]{
                new Double[]{5.0, 5.0, 10.0},
                new Double[]{-5.0, 5.0, 0.0},
                new Double[]{0.0, -5.0, -5.0}
        };
    }

    @DataProvider(name = "divisionData")
    public Object[][] divisionTestData() {
        return new Double[][]{
                new Double[]{5.0, 5.0, 1.0},
                new Double[]{-5.0, 5.0, -1.0},
                new Double[]{0.0, 5.0, 0.0}
        };
    }

    @DataProvider(name = "multiplicationData")
    public Object[][] multiplicationTestData() {
        return new Double[][]{
                new Double[]{5.0, 5.0, 25.0},
                new Double[]{-5.0, 5.0, -25.0},
                new Double[]{0.0, 5.0, 0.0}
        };
    }

    @DataProvider(name = "subtractionData")
    public Object[][] subtractionTestData() {
        return new Double[][]{
                new Double[]{5.0, 5.0, 0.0},
                new Double[]{-5.0, 5.0, -10.0},
                new Double[]{0.0, 5.0, -5.0}
        };
    }

}
