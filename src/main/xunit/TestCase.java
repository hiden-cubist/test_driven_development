package xunit;

import java.lang.reflect.InvocationTargetException;

abstract class TestCase {
    private String methodName;

    TestCase(String methodName) {
        this.methodName = methodName;
    }

    abstract void setUp();

    abstract void tearDown();

    void run(TestResult testResult) {
        testResult.testStarted();

        setUp();

        try {
            this.getClass().getMethod(methodName).invoke(this);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | AssertionError e) {
            testResult.testFailed();
        }

        tearDown();
    }
}
