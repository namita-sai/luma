package cucumberOption;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions( features = "src/test/java/featureLayer"
   				, glue = "stepdefination"
//   				, dryRun = true
//   				, monochrome = false
  				, plugin = {"pretty", "html:target/cucmber.html","json:target/exp.json"}
		        )

@Test
public class LumaRunner extends AbstractTestNGCucumberTests
{

}
