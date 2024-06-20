package utilities;

import java.util.List;

public class TestCase {
    private String testClass;
    private String testCaseName;
    private String input;
    private String additionalInput;
    private boolean executionRequired;

    // Getter and Setter for testClass
    public String getTestClass() {
        return testClass;
    }

    public void setTestClass(String testClass) {
        this.testClass = testClass;
    }

    // Getter and Setter for testCaseName
    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    // Getter and Setter for input
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    // Getter and Setter for additionalInput
    public String getAdditionalInput() {
        return additionalInput;
    }

    public void setAdditionalInput(String additionalInput) {
        this.additionalInput = additionalInput;
    }

    // Getter and Setter for executionRequired
    public boolean isExecutionRequired() {
        return executionRequired;
    }

    public void setExecutionRequired(boolean executionRequired) {
        this.executionRequired = executionRequired;
    }

    // Methods to read input and additionalInput for a given test case name
    public static String readInput(List<TestCase> testCases, String testCaseName) {
        for (TestCase testCase : testCases) {
            if (testCase.getTestCaseName().equalsIgnoreCase(testCaseName)) {
                return testCase.getInput();
            }
        }
        return null; // or throw an exception if test case name is not found
    }

    public static String readAdditionalInput(List<TestCase> testCases, String testCaseName) {
        for (TestCase testCase : testCases) {
            if (testCase.getTestCaseName().equalsIgnoreCase(testCaseName)) {
                return testCase.getAdditionalInput();
            }
        }
        return null; // or throw an exception if test case name is not found
    }
}

