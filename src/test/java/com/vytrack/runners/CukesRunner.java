package com.vytrack.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-cucumber-reports" },

//        tags = {"@dashboard-navigation"},
//        tags = {"@VYT-4121_login"},
//        tags = {"@vehicles"},

        features = {"src/test/resources/features"},      // to specify where are the features. feature contains scenarios, every scenario is like a test
        glue = {"com/vytrack/step_definitions"},

//       dryRun = true      //dryRun = true  --> generates step definitions automatically
        dryRun = false
)
public class CukesRunner {

}
