package com.vytrack.step_definitions;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.Pages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class VehiclesStepDefinitions {
    private Pages pages = new Pages();
    private String eventTitle = pages.vehiclesPage().randomWord1;
    private String Description = pages.vehiclesPage().randomWord2;

    @Then("user verifies that default page number is {int}")
    public void user_verifies_that_default_page_number_is(Integer expected) {
        Assert.assertEquals(expected, pages.vehiclesPage().getPageNumber());
    }

    @Then("click on any car on the grid")
    public void click_on_any_car_on_the_grid() {
        int size =BrowserUtils.getCountOfRows(By.cssSelector("tbody[class='grid-body']>tr"));       // table[id='table1'] > tbody>tr
        System.out.println("size fo table :"+size);
        int random=BrowserUtils.randomInt(size);
        System.out.println("element of :"+random);
        BrowserUtils.waitPlease(2);
        Driver.getDriver().findElement(By.cssSelector("tbody[class='grid-body'] tr:nth-of-type(" + random + ")")).click();
        BrowserUtils.waitFor(4);
    }

    @Then("system should be able to display general information")
    public void system_should_be_able_to_display_general_information() {
        String expected = "General Information";
        String actual = pages.vehiclesPage().generalInformation.getText();
        Assert.assertTrue(actual.equalsIgnoreCase(expected));
    }

    @Then("click on {string} button")
    public void click_on_button(String string) {
        BrowserUtils.waitFor(2);
        pages.vehiclesPage().addEvent.click();
        BrowserUtils.waitFor(2);
        System.out.println("Title :"+eventTitle);
        System.out.println("Description :"+Description);
        pages.vehiclesPage().title.click();
        pages.vehiclesPage().title.sendKeys(eventTitle);
//        pages.vehiclesPage().description.click();
//        pages.vehiclesPage().description.sendKeys(Description);
////    pages.vehiclesPage().color.click();
//    pages.vehiclesPage().clickInGuestFrame();
        pages.vehiclesPage().eventSave.click();

    }

    @Then("event should be displayed under {string} and {string}")
    public void event_should_be_displayed_under_and(String string, String string2) {
        BrowserUtils.waitPlease(2);
        pages.vehiclesPage().activity.click();
        BrowserUtils.waitPlease(2);
        String newEventNameOnList = pages.vehiclesPage().firstEvent.getText();
        Assert.assertTrue(newEventNameOnList.equalsIgnoreCase(eventTitle));
    }


    @Then("click on {string} located at right upper corner of the tab")
    public void clickOnLocatedAtRightUpperCornerOfTheTab(String arg0) {
//        BrowserUtils.waitPlease(3);
//        pages.vehiclesPage().xAddEvent.click();
        BrowserUtils.waitPlease(3);
        pages.vehiclesPage().grid.click();
        BrowserUtils.waitPlease(1);

    }

    @Then("user should be able to see the GridSettings window")
    public void userShouldBeAbleToSeeTheGridSettingsWindow() {
        String title = pages.vehiclesPage().gridTable.getAttribute("title");
        Assert.assertTrue(title.equalsIgnoreCase("Grid Settings"));
    }

    @And("truck driver should be able reset the grid")
    public void truckDriverShouldBeAbleResetTheGrid() {
        BrowserUtils.waitPlease(2);
        pages.vehiclesPage().clickHidenElement(By.cssSelector("a[class^='pull-right']"));
        BrowserUtils.waitPlease(1);
        pages.vehiclesPage().clickHidenElement(By.cssSelector("a[class^='pull-right']"));
        BrowserUtils.waitPlease(1);
        pages.vehiclesPage().unsellectGridOptions();
        pages.vehiclesPage().xGridSettings.click();
        BrowserUtils.waitPlease(1);
        Assert.assertEquals("ID",pages.vehiclesPage().ID.getText());
        Assert.assertEquals("LICENSE PLATE",pages.vehiclesPage().LP.getText());

    }


}
