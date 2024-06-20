package selective;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import utilities.ExcelUtils;
import utilities.TestCase;

public class NewSampleTest {
  @Test
  public void f() throws IOException {
	  
	  List<TestCase> testcases = ExcelUtils.readTestCases();
	  
	  for(TestCase testcase : testcases) {
		  System.out.println(TestCase.readInput(testcases, testcase.getTestCaseName()) +" "+ TestCase.readAdditionalInput(testcases, testcase.getTestCaseName()));
	  }
	  
  }
}
