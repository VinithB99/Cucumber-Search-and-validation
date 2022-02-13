package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"steps"},
		monochrome = false,
		plugin = {"pretty"}
		
	)
public class TestngRunner extends AbstractTestNGCucumberTests{

}
