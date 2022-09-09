import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLocalhost {

    public static WebDriver driver;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
    }


    String username = "FatHalimi";
    String password = "FatHalimi2022!";

    @Test
    void callTests(){
        openConomeLocalhost();
        login();
        addClient();
    }

    @Test
    void openConomeLocalhost()
    {
        driver.get("https://dev.conome.mk/account/login?ReturnUrl=%2F"); // open
        driver.manage().window().maximize();
        if(driver.findElement(By.id("details-button"))!=null)
        {
            driver.findElement(By.id("details-button")).click();
        }
        driver.findElement(By.id("proceed-link")).click();
        if(driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary btn-sm acceptcookies')]"))!=null); // acceptCookies
        {
            driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary btn-sm acceptcookies')]")).click(); // acceptCookies
        }
        Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/account/login?ReturnUrl=%2F");
    }
    @Test
    void login(){
        openConomeLocalhost();  // add this line if running this test individually
        Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/account/login?ReturnUrl=%2F");
        driver.findElement(By.id("Username")).sendKeys(username);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.id("proceedBtn")).click(); // conome same account a
        System.out.println(driver.getCurrentUrl());
        Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/"); // check if successsful login
        System.out.println("Login is successsful!");

    }
    @Test
    void addClient(){

        openConomeLocalhost();
        login();
        driver.findElement(By.xpath("//body/div[6]/aside[1]/nav[1]/ul[1]/li[3]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/section[1]/a[1]")).click();
        driver.findElement(By.id("NameSQ")).sendKeys("Fat Halimi 195005");
        driver.findElement(By.id("NameMK")).sendKeys("Фат Халими 195005");
        driver.findElement(By.id("dropdownMenuButton")).click();
        driver.findElement(By.id("IncomeClient")).click();
        driver.findElement(By.id("dropdownMenuButton")).click();
        driver.findElement(By.xpath("//*[contains(@data-id,'PlaceID')]")).click();
        driver.findElement((By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]/div[2]/form[1]/div[3]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]"))).click();
        driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]/div[2]/form[1]/div[4]/input[1]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]")).isDisplayed());
        System.out.println("");
    }
}
