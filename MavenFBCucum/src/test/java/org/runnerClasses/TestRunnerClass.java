package org.runnerClasses;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\FeatureFiles\\login.feature",glue="org.stepdefinition",dryRun=false,
snippets=SnippetType.CAMELCASE,tags= {"@sanity or @regression"},
plugin = {"pretty"},
monochrome=true)
public class TestRunnerClass {

}
