package com.vytrack.pages.fleet;

import com.vytrack.utilities.BasePage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
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

    @FindBy(css = "body[id='tinymce']")
    public WebElement description;

//    public WebElement color = Driver.getDriver().findElement(By.cssSelector("span.color:nth-child("+BrowserUtils.randomInt(12)+")"));

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

    @FindBy( xpath= "//a[contains(text(),'Activity')]")
    public WebElement activity;

    @FindBy(xpath = "(//div[@class='message-item message'])[1]")
    public WebElement firstEvent;


    @FindBy(css = "i[class='fa-cog hide-text']")
    public WebElement grid;

    @FindBy(css = "div[class='column-manager dropdown open']>a")
    public WebElement gridTable;

    @FindBy(css = "a[class='column-filter-renderable-tab active']")
    public WebElement All;

    @FindBy(css = "a[xpath='1']")
    public WebElement sellected;

    @FindBy(css = "a[class^='pull-right']")
    public WebElement sellectAll;

    @FindBy(css = "label[xpath='1']")
    public WebElement firstOnTheList;

    @FindBy(css = "button[class^='ui-button ui-corner']")
    public WebElement xAddEvent;

    @FindBy(css = "span[class='close']")
    public WebElement xGridSettings;

    @FindBy(css = "tr th:nth-child(1) a.grid-header-cell__link > span.grid-header-cell__label")
    public WebElement ID;

    @FindBy(css = "tr th:nth-child(2) a.grid-header-cell__link > span.grid-header-cell__label")
    public WebElement LP;

    public String randomWord1 = BrowserUtils.randomName(10);
    public String randomWord2 = BrowserUtils.randomName(10);
    int number;
    String GridOptions = "tbody.ui-sortable:nth-child(2) tr.renderable:nth-child("+number+") > td.visibility-cell"; //css

//    public String newEvent = "//strong[contains(text(),'"+randomEventName+"')]";





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

    public void unsellectGridOptions() {
        for (int i=3; i<=20; i++ ){
//            BrowserUtils.waitPlease2(500);
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            WebElement element = Driver.getDriver().findElement(By.cssSelector("tbody.ui-sortable:nth-child(2) tr.renderable:nth-child("+i+") > td.visibility-cell"));
            js.executeScript("arguments[0].scrollIntoView();", element);
            element.click();
        }
    }
    public void clickHidenElement(By by) {
        WebElement tmpElement=Driver.getDriver().findElement(by);
        JavascriptExecutor executor=(JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", tmpElement);
    }

//    public void unsellectGridOptions() {
//        for (int i=3; i<=20; i++ ){
////            BrowserUtils.waitPlease2(500);
//            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//            WebElement element = Driver.getDriver().findElement(By.cssSelector("tbody.ui-sortable:nth-child(2) tr.renderable:nth-child("+i+") > td.visibility-cell"));
//            js.executeScript("arguments[0].scrollIntoView();", element);
//            element.click();
//        }
//    }


}
