package com.openMRS.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:/Features",
				glue = "com.openMRS.stepDef",
				dryRun = false,
				monochrome = true,
				plugin = {"rerun:failed_scenarios/failed_scenario.txt",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestRunner {

}
