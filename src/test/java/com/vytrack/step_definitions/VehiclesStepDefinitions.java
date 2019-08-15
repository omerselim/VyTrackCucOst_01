package com.vytrack.step_definitions;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.Pages;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class VehiclesStepDefinitions {
    Pages pages = new Pages();

    @Then("click on any car on the grid")
    public void click_on_any_car_on_the_grid() {
        int size =BrowserUtils.getCountOfRows(By.cssSelector("tbody[class='grid-body']>tr"));       // table[id='table1'] > tbody>tr
        System.out.println("size fo table :"+size);
        int random=BrowserUtils.randomInt(size);
        System.out.println("element of :"+random);
        Driver.getDriver().findElement(By.cssSelector("tbody[class='grid-body'] tr:nth-of-type(" + random + ")")).click();
        BrowserUtils.waitFor(2);
    }

    @Then("system should be able to display general information")
    public void system_should_be_able_to_display_general_information() {
        String expected = "General Information";
        String actual = pages.vehiclesPage().generalInformation.getText();
        Assert.assertTrue(actual.equalsIgnoreCase(expected));
    }

    @Then("click on {string} button")
    public void click_on_button(String string) {
    pages.vehiclesPage().addEvent.click();
    BrowserUtils.waitFor(2);
    pages.vehiclesPage().title.sendKeys("Aaa Bbb");
    pages.vehiclesPage().description.sendKeys(pages.vehiclesPage().randomEventName);
    pages.vehiclesPage().color.click();
    pages.vehiclesPage().clickInGuestFrame();
    pages.vehiclesPage().eventSave.click();

    }

    @Then("event should be displayed under {string} and {string}")
    public void event_should_be_displayed_under_and(String string, String string2) {
        String newEventNameOnList = pages.vehiclesPage().newEvent.getText();
        Assert.assertTrue(newEventNameOnList.equalsIgnoreCase(pages.vehiclesPage().randomEventName));
    }



}
