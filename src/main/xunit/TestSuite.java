package xunit;

import java.util.ArrayList;
import java.util.List;

class TestSuite {
    private List<TestCase> testCases = new ArrayList<>();

    void add(TestCase testCase) {
        testCases.add(testCase);
    }

    void run(TestResult testResult) {
        for (TestCase testCase: testCases) {
            testCase.run(testResult);
        }
    }
}
