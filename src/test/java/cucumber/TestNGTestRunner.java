package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",
glue="poojaPrabhuraj.StepDefinitions",
monochrome=true,
plugin= {"html:target/Cucumber.html"},
tags= "@ErrorValidation")
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
