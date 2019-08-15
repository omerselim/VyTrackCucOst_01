package com.vytrack.pages.fleet;

import com.vytrack.utilities.BasePage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class VehiclesPage extends BasePage {
    @FindBy(xpath = "//label[text()='Page:']/following-sibling::ul//input")
    public WebElement pageNumber;

    @FindBy(css = "h5.user-fieldset:nth-child(1) > span:nth-child(1)")
    public WebElement generalInformation;

    @FindBy(css = "a[class='btn icons-holder-text no-hash']")
    public WebElement addEvent;

    @FindBy(css = "input[name='oro_calendar_event_form[title]']")
    public WebElement title;

    @FindBy(css = "body[id='tinymce'] p")
    public WebElement description;

    public WebElement color = Driver.getDriver().findElement(By.cssSelector("span.color:nth-child("+BrowserUtils.randomInt(12)+")"));

    @FindBy(css = "input#s2id_autogen3")
    public WebElement guests;

    @FindBy(css = "input[class='input-small datepicker-input start hasDatepicker']")
    public WebElement eventStartDate;

    @FindBy(css = "input[class='input-small timepicker-input start ui-timepicker-input']")
    public WebElement eventStartTime;

    @FindBy(css = "input[class='input-small datepicker-input start hasDatepicker']")
    public WebElement eventEndDate;

    @FindBy(css = "input[class='input-small timepicker-input start ui-timepicker-input']")
    public WebElement eventEndTime;

    @FindBy(css = "button[class='btn btn-primary']")
    public WebElement eventSave;

    public String randomEventName = BrowserUtils.randomName(10);

//    public String newEvent = "//strong[contains(text(),'"+randomEventName+"')]";

    @FindBy(css = "div[data-layout='separate'] [class='list-item']:nth-child(1)")
    public WebElement newEvent;




    public Integer getPageNumber(){
        return  Integer.valueOf(pageNumber.getAttribute("value"));
    }


    public void clickRandomVehicle() {
        int size =BrowserUtils.getCountOfRows(By.cssSelector("tbody[class='grid-body']>tr"));       // table[id='table1'] > tbody>tr
        System.out.println("size fo table :"+size);
        int random=BrowserUtils.randomInt(size);
        System.out.println("element of :"+random);
        Driver.getDriver().findElement(By.cssSelector("tbody[class='grid-body'] tr:nth-of-type(" + random + ")")).click();
    }

    public void clickInGuestFrame(){
        Driver.getDriver().switchTo().frame("oro_calendar_event_form_description-uid-5d53fab6411ce_ifr");
        Driver.getDriver().findElement(By.xpath("//div[contains(text(),'Random User')]")).click();
    }




}