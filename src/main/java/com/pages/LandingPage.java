package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage {

    private WebDriver driver= DriverFactory.getDriver();

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "hero-name")
    private WebElement heroName;

    @FindBy(xpath = "//button[text()=' Add hero ']")
    private WebElement addHero;

    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElement search;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    private WebElement editHeroTextbox;



    public static String hero="";

    public void enterHeroName(String heroText) throws InterruptedException {
        TestUtil.explicitWaitVisibiblityOf(heroName);
        heroName.sendKeys(heroText);
        hero=heroText;
        Thread.sleep(5000);
    }

    public void clickAddHero() throws InterruptedException {
        TestUtil.explicitWaitElementToBeClickable(addHero);
        addHero.click();
        Thread.sleep(2000);
    }

    public void clickSearch() throws InterruptedException {
        TestUtil.explicitWaitElementToBeClickable(search);
        search.click();
        Thread.sleep(2000);
    }

    public boolean verifyUserIsAdded()  {

        WebElement addedHero=driver.findElement(By.xpath("//span[text()='"+hero+"']"));
        TestUtil.explicitWaitVisibiblityOf(addedHero);
        return addedHero.isDisplayed();
    }

    public void deleteAddedUser() throws InterruptedException {

        WebElement deleteHero=driver.findElement(By.xpath("//span[text()='"+hero+"']/following::button[@title='delete hero']"));
        TestUtil.explicitWaitVisibiblityOf(deleteHero);
        deleteHero.click();
        Thread.sleep(2000);
    }

    public void editHero(String heroText) throws InterruptedException {
        WebElement addedHero=driver.findElement(By.xpath("//span[text()='"+hero+"']"));
        TestUtil.explicitWaitVisibiblityOf(addedHero);
        addedHero.click();
        TestUtil.explicitWaitVisibiblityOf(editHeroTextbox);
        Thread.sleep(2000);
        editHeroTextbox.sendKeys(heroText);
        editHeroTextbox.sendKeys(Keys.ENTER);
    }

    public void deleteAllHeros() throws InterruptedException {

        Thread.sleep(2000);
        List<WebElement> deleteHero=driver.findElements(By.xpath("//button[@title='delete hero']"));
        for(int i=0;i<deleteHero.size();i++)
        {
            deleteHero.get(i).click();
        }
        Thread.sleep(2000);
    }

    public String getCount() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> deleteHero=driver.findElements(By.xpath("//span[@class='badge']"));
        int size=deleteHero.size()-1;
        return deleteHero.get(size).getText();

    }

}
