package test;

import models.Form;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumTest {




    private WebDriver driver;
    private WebDriver getWebDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        return driver;
    }
    @BeforeEach
    public void SetUp(){
        getWebDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
    }
    @Test
    public void FormFillOutTest(){
        driver.findElement(By.id("forename")).sendKeys("Tales");
        driver.findElement(By.id("submit")).click();
    }

    @Test
    public void TitleValidation() {
        String title = driver.findElement(By.xpath("//h1[@class=\"display-1 mb-3\"]")).getText();
        Assertions.assertEquals(title, "Web Playground");

    }

    @Test
    public void ButtonClickingUpToDown() {
        By byButtom = By.cssSelector("a.anibtn");
        driver.findElement(byButtom).click();
        WaitTransition(byButtom);
        String textButton = driver.findElement(byButtom).getText();
        Assertions.assertEquals("CLICK ME UP!", textButton);
    }
    @Test
    public void ButtonClickingDownToUp() {
        By byButtom = By.cssSelector("a.anibtn");
        driver.findElement(byButtom).click();
        WaitTransition(byButtom);
        driver.findElement(byButtom).click();

        String textButton = driver.findElement(By.cssSelector("a.anibtn")).getText();
        Assertions.assertEquals("CLICK ME DOWN!", textButton);
    }

    @Test
    public void FillOutAnotherForm(){



        Form form = new Form(driver);
        form.openForm();
        form.enterName("Tales");
        form.enterEmail("tales.pinto@hotmail.com");
        form.state("NSW");
        form.checkbox();
        form.submit();

        By popUpMessage = By.className("popup-message");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(popUpMessage));
        Assertions.assertEquals("Thanks for your feedback Tales", driver.findElement(popUpMessage).getText());

    }



        @AfterEach
    public void quit(){
        driver.quit();
    }


    private void WaitTransition(By byButtom) {
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(
                ExpectedConditions.textToBe(byButtom, "CLICK ME DOWN!")
        );
    }


}
