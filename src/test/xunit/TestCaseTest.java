package xunit;

public class TestCaseTest extends TestCase {
    private TestResult testResult;

    TestCaseTest(String methodName) {
        super(methodName);
    }

    @Override
    void setUp() {
        testResult = new TestResult();
    }

    @Override
    void tearDown() {
    }

    public void testTemplateMethod() {
        WasRun test = new WasRun("testMethod");
        test.run(testResult);
        if ((!"setUp testMethod tearDown ".equals(test.log))) {
            throw new AssertionError();
        }
    }

    public void testResult() {
        WasRun test = new WasRun("testMethod");
        test.run(testResult);
        if ((!"1 run, 0 failed".equals(testResult.summary()))) {
            throw new AssertionError();
        }
    }

    public void testFailedResult() {
        WasRun test = new WasRun("testBrokenMethod");
        test.run(testResult);
        if ((!"1 run, 1 failed".equals(testResult.summary()))) {
            throw new AssertionError();
        }
    }

    public void testFailedResultFormatting() {
        testResult.testStarted();
        testResult.testFailed();
        if ((!"1 run, 1 failed".equals(testResult.summary()))) {
            throw new AssertionError();
        }
    }

    public void testSuite() {
        TestSuite testSuite = new TestSuite();
        testSuite.add(new WasRun("testMethod"));
        testSuite.add(new WasRun("testBrokenMethod"));
        testSuite.run(testResult);
        if ((!"2 run, 1 failed".equals(testResult.summary()))) {
            throw new AssertionError();
        }
    }
}
