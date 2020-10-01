package Creation;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//Directory for Feature file location
		features="src\\test\\resources\\Creation", 
		
		//Attempted to run multiple files via tags I have commented it out so I can run one at a time
		//tags= "@AccCreateSmokeTest_Case_1, @PurcahseSmokeTest_Case_1",
		
		//Package
		glue= {"Creation", },
		monochrome = true,
		
		//Reporting
		plugin = {"pretty","junit:target/Reports/testReport.xml"})

public class TestRunner {


	
	
}
