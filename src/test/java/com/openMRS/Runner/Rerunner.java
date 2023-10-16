package com.openMRS.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@failed_scenarios/failed_scenario.txt",
				glue = "com.openMRS.stepDef",
				dryRun = false,
				monochrome = true
				)
public class Rerunner {

}
