package com.google.steps;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static org.hamcrest.Matchers.*;

public class SerenitySteps {

    private String pass_key = "AIzaSyA2fREIe1D2Y48aZ1QQiIcokpgrAHIZ8e0";
    private String address = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    Response response;

    @Step
    public void passAddress(String arg0) {
        response = SerenityRest.when().post(address + arg0 + "&key=" + pass_key);
    }

    @Step
    public void verifyResponseCode() {
        response.then().assertThat().statusCode(200);
    }

    @Step
    public void verifyCoordinates(String arg0, String arg1) {

        //JsonPath jp=new JsonPath(response.asString());
        //String val1=jp.get(arg0).toString();
        //String val2=jp.get(arg1).toString();
//        response.then().body("results.geometry.location.lng[0]", equalTo(arg0));
//        response.then().body("results.geometry.location.lat[0]", equalTo(arg1));
        //SerenityRest.then().body("results.geometry.location.lng[0]",equalTo(arg0));
        //SerenityRest.then().body("results.geometry.location.lat[0]",equalTo(arg0));

        JsonPath jP = response.jsonPath();

        String actual = response.jsonPath().getString("results.geometry.location.lng[0]");
        System.out.println(actual);
        System.out.println(arg0);

        response.then().assertThat().body("results.geometry.location.lng", equalTo(Double.parseDouble(arg0)));


    }
}
