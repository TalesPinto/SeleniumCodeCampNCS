package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

    @Test
    public void SeleniumTest(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
        driver.findElement(By.id("forename")).sendKeys("Tales");
        driver.findElement(By.id("submit")).click();

    }

    @Test
    public void TitleValidation() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
        String title = driver.findElement(By.xpath("//h1[@class=\"display-1 mb-3\"]")).getText();

        Assertions.assertEquals(title, "Web Playground");

    }

    @Test
    public void ButtonClickingTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
        driver.findElement((By.xpath("//div/a[@role=\"button\"]"))).click();
    }
}
