package xunit;

class WasRun extends TestCase {
    String log;

    WasRun(String methodName) {
        super(methodName);
    }

    @Override
    void setUp() {
        log = "setUp ";
    }

    @Override
    void tearDown() {
        log += "tearDown ";
    }

    public void testMethod() {
        log += "testMethod ";
    }

    public void testBrokenMethod() throws Exception {
        throw new Exception();
    }
}
