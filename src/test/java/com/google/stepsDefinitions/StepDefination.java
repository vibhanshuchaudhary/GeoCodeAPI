package com.google.stepsDefinitions;

import com.google.steps.SerenitySteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class StepDefination {

    @Steps
    SerenitySteps mystep;

    @When("^User requests geocode for address (.*)$")
    public void userRequestsGeocodeForAddressAddress(String arg0) throws Throwable {
        mystep.passAddress(arg0);
    }

    @Then("^User should get response code as (\\d+)$")
    public void userShouldGetResponseCodeAs(int arg0) throws Throwable {
        mystep.verifyResponseCode();

    }

    @And("^User should get longitude as (.*) and latitude as (.*)$")
    public void userShouldGetLongitudeAsLongitudeAndLatitudeAsLatitude(String arg0,String arg1) throws Throwable {
        mystep.verifyCoordinates(arg0,arg1);
    }
}
