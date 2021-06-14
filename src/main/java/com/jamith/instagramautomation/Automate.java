package com.jamith.instagramautomation;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class Automate {

    private final DriverInitializer driverInitializer;

    public Automate(DriverInitializer driverInitializer) {
        this.driverInitializer = driverInitializer;
    }

    private FirefoxDriver driver;
    @Value("instagram.username")
    private String username;

    @Value("instagram.password")
    private String password;

    @PostConstruct
    public void start(){
        driver = driverInitializer.getFirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        performLogin();

//        closeDriver();
    }

    private void performLogin(){
        driver.get("https://www.instagram.com/");
        WebElement username = driver.findElement(By.xpath("/html/body/div[1]/section/main/article/div[2]/div[1]/div/form/div/div[1]/div/label/input"));
        WebElement password = driver.findElement(By.xpath("/html/body/div[1]/section/main/article/div[2]/div[1]/div/form/div/div[2]/div/label/input"));
        username.sendKeys((CharSequence) username);
        password.sendKeys((CharSequence) password);
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/section/main/article/div[2]/div[1]/div/form/div/div[3]/button"));
        loginButton.click();
    }

    private void closeDriver(){
        driver.close();
    }

}
