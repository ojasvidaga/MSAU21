package com.aums.course.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="classpath:features/LoginTest.feature", glue="com.aums.course.cucumber")
public class TestRunner {

}
