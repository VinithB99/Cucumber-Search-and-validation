package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class BeforeAndAfter {
	
	@Before
	public void createReport() {
		System.out.println("********Report is Generating for all Scenarios*********");
	}
	
	@After
	public void closeReport() {
		System.out.println("*********Close all the Report**********");
	}
	
	@BeforeStep
	public void beforeSteps() {
		System.out.println("*****Before Steps*********");
	}
	
	@AfterStep
	public void afterSteps() {
		System.out.println("********After Steps*******");
	}

}
