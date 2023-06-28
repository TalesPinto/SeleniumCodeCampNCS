package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Form {

    private WebDriver driver;
    public Form(WebDriver driver) {
        this.driver = driver;
    }

    public void openForm() {
        By formButton = By.cssSelector("[aria-label=forms]");
        driver.findElement(formButton).click();
    }
    public void enterName(String name) {
        driver.findElement(By.id("name")).sendKeys((name));
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("email")).sendKeys((email));
    }

    public void state(String state) {
        driver.findElement(By.className("v-select__selections")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.className("v-select__selections")));

        for (WebElement currentElement : driver.findElements(By.cssSelector("[role=option]"))){
            if(currentElement.getText().equalsIgnoreCase(state)) {
                currentElement.click();
                break;
            }
        }

    }

    public void checkbox() {
        driver.findElement(By.cssSelector("[for=agree]")).click();

        for(WebElement button : driver.findElements(By.cssSelector("[type=button]"))) {
            if(button.getText().equalsIgnoreCase("submit")) {
                button.click();
                break;
            }
        }

    }

    public void submit() {

    }


}
