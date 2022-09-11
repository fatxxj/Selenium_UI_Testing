import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

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
    void callTests() throws InterruptedException {
        openConomeLocalhost();
        Thread.sleep(3000);
        login();
        Thread.sleep(3000);
        addClient();
        createCompany();
        createUser();
        logout();
        Thread.sleep(3000);
        loginNewUser();
    }

    @Test
    void openConomeLocalhost() throws InterruptedException {
        driver.get("https://dev.conome.mk/account/login?ReturnUrl=%2F"); // open
        driver.manage().window().maximize();
        if(driver.findElement(By.id("details-button"))!=null)
        {
            Thread.sleep(800);
            driver.findElement(By.id("details-button")).click();
        }
        driver.findElement(By.id("proceed-link")).click();
        if(driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary btn-sm acceptcookies')]"))!=null); // acceptCookies
        {
            driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary btn-sm acceptcookies')]")).click(); // acceptCookies
            Thread.sleep(800);
        }
        Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/account/login?ReturnUrl=%2F");
    }
    @Test
    void login() throws InterruptedException {
        //openConomeLocalhost();  // add this line if running this test individually
        Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/account/login?ReturnUrl=%2F");
        driver.findElement(By.id("Username")).sendKeys(username);
        Thread.sleep(800);
        driver.findElement(By.id("Password")).sendKeys(password);
        Thread.sleep(800);
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(800);
        driver.findElement(By.id("proceedBtn")).click(); // conome same account a
        Thread.sleep(800);
        System.out.println(driver.getCurrentUrl());
        Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/"); // check if successsful login
        System.out.println("Login is successsful!");

    }

    @Test
    void logout() throws InterruptedException {
        //openConomeLocalhost();
        //login();
        driver.findElement(By.xpath("//*[contains(@class,'dropdown-toggle no-margin userdropdown user-img user-img-void user-img-dark text-align-right')]")).click(); // click user account logo
        Thread.sleep(800);
        driver.findElement(By.xpath("//header/div[1]/ul[1]/li[1]/ul[1]/li[8]/form[1]/a[1]")).click();
        Thread.sleep(800);
        Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/Account/Login");
        System.out.println("Logout successful");
    }
    @Test
    void addClient() throws InterruptedException {

        //openConomeLocalhost();
       // login();
        driver.findElement(By.xpath("//body/div[6]/aside[1]/nav[1]/ul[1]/li[3]")).click();
        Thread.sleep(800);
        driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/section[1]/a[1]")).click();
        Thread.sleep(800);
        driver.findElement(By.id("NameSQ")).sendKeys("Fat Halimi 195005");
        Thread.sleep(800);
        driver.findElement(By.id("NameMK")).sendKeys("Фат Халими 195005");
        Thread.sleep(800);
        driver.findElement(By.id("dropdownMenuButton")).click();
        Thread.sleep(800);
        driver.findElement(By.id("IncomeClient")).click();
        Thread.sleep(800);
        driver.findElement(By.id("dropdownMenuButton")).click();
        Thread.sleep(800);
        driver.findElement(By.xpath("//*[contains(@data-id,'PlaceID')]")).click();
        Thread.sleep(800);
        driver.findElement((By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]/div[2]/form[1]/div[3]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]"))).click();
        Thread.sleep(800);
        driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]/div[2]/form[1]/div[4]/input[1]")).click();
        Thread.sleep(800);
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        Thread.sleep(800);
        Assertions.assertTrue(driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]")).isDisplayed());
        System.out.println("");
    }
    @Test
    void createCompany() throws InterruptedException {
        //openConomeLocalhost();
        //login();
        driver.findElement(By.xpath("//*[contains(@class,'logo logo-ipos-white logo-ipos')]")).click();
        driver.findElement(By.xpath("//body/div[6]/aside[1]/nav[1]/ul[1]/li[1]/a[1]")).click(); // click company
        Thread.sleep(800);
        driver.findElement(By.xpath("//body/div[6]/aside[1]/nav[1]/ul[1]/li[1]/div[1]/a[3]")).click();  //create affiliate
        Thread.sleep(800);
        Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/companies/createbranch");
        driver.findElement(By.id("NameSQ")).sendKeys("Affiliate Company 195005");
        Thread.sleep(800);
        driver.findElement(By.id("NameMK")).sendKeys("Организациска единица 195005");
        Thread.sleep(800);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(800);
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        Thread.sleep(800);
        Assertions.assertTrue(driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]")).isDisplayed());

    }
    @Test
    void createUser() throws InterruptedException {
        //openConomeLocalhost();
       // login();
        Random random = new Random();
        int num = random.nextInt(90) + 10;
        String newUsername = "Accountant 195005_" + num;
        String accountantPassword = "AccountantPassword195005!";
        driver.findElement(By.xpath("//*[contains(@class,'logo logo-ipos-white logo-ipos')]")).click(); // click conome logo
        Thread.sleep(800);
        driver.findElement(By.xpath("//body/div[6]/aside[1]/nav[1]/ul[1]/li[4]/a[1]/p[1]")).click(); // click user logo
        Thread.sleep(800);
        Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/users/index1");
        driver.findElement(By.xpath("//body/div[6]/aside[1]/nav[1]/ul[1]/li[4]/div[1]/a[1]")).click();//click create
        Thread.sleep(800);
        Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/users/create");
        driver.findElement(By.id("user_Username")).sendKeys(newUsername); //give name to new user
        Thread.sleep(800);
        driver.findElement(By.xpath("//*[contains(@data-id,'Roles')]")).click(); // click roles
        Thread.sleep(800);
        driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[3]/a[1]")).click(); //select accountant
        Thread.sleep(800);
        driver.findElement(By.id("user_Password")).sendKeys(accountantPassword); // send password to new user
        Thread.sleep(800);
        driver.findElement(By.id("user_PasswordHint")).sendKeys("This is hint "); // passwordHint
        Thread.sleep(800);
        driver.findElement(By.id("user_Email")).sendKeys("halimifat@gmail.com"); //send email
        Thread.sleep(800);
        driver.findElement(By.xpath("//input[@type='submit']")).click(); // click create
        Thread.sleep(800);
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click(); // click ok
        Thread.sleep(800);
    }

    @Test
    void loginNewUser() throws InterruptedException {
       // openConomeLocalhost();
       // Thread.sleep(3000);
       // login();
       // Thread.sleep(3000);
       // logout();
        String newUsername = "Accountant195005";
        String accountantPassword = "AccountantPassword195005!";

        Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/Account/Login");
        driver.findElement(By.id("Username")).sendKeys(newUsername);
        Thread.sleep(800);
        driver.findElement(By.id("Password")).sendKeys(accountantPassword);
        Thread.sleep(800);
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(800);
        driver.findElement(By.id("proceedBtn")).click(); // conome same account a
        Thread.sleep(800);
        Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/"); // check if successsful login
        System.out.println("Login is successsful as accountant!");


    }
}
