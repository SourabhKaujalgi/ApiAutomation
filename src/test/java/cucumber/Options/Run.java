package cucumber.Options;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Feature",glue={"Bddsteodefination"}, 
plugin = { "pretty", "json:target/jsonReports/Cucumber.json" },
dryRun = false,
monochrome = true ,
tags = {"@DeletePlace"})

public class Run {

}
