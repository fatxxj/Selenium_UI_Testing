import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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
        Thread.sleep(1000);
        createUser();
        logout();
        Thread.sleep(3000);
        loginNewUser();
        Thread.sleep(3000);
        logoutAccountant();
        Thread.sleep(3000);
        loginAfterAccountant();
    }

    @Test
    void openConomeLocalhost() throws InterruptedException {
        driver.get("https://dev.conome.mk/account/login?ReturnUrl=%2F"); // open
        driver.manage().window().maximize();

        if(driver.findElement(By.id("details-button")).isDisplayed())
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
       // Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/account/login?ReturnUrl=%2F");
    }
    @Test
    void login() throws InterruptedException {
        //openConomeLocalhost();  // add this line if running this test individually
       // Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/account/login?ReturnUrl=%2F");
        driver.findElement(By.id("Username")).sendKeys(username);
        Thread.sleep(800);
        driver.findElement(By.id("Password")).sendKeys(password);
        Thread.sleep(800);
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(800);
      if(driver.findElement(By.id("proceedBtn")).isDisplayed()){
          Thread.sleep(800);
            driver.findElement(By.id("proceedBtn")).click(); // conome same account a
        }
        //driver.findElement(By.id("proceedBtn")).click(); // conome same account a
        Thread.sleep(800);
       // System.out.println(driver.getCurrentUrl());
       // Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/"); // check if successsful login
        System.out.println("Login is successsful!");

    }

    @Test
    void loginAfterAccountant() throws InterruptedException {
        //openConomeLocalhost();  // add this line if running this test individually
        // Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/account/login?ReturnUrl=%2F");
        driver.findElement(By.id("Username")).sendKeys(username);
        Thread.sleep(800);
        driver.findElement(By.id("Password")).sendKeys(password);
        Thread.sleep(800);
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(800);

        //driver.findElement(By.id("proceedBtn")).click(); // conome same account a
        Thread.sleep(800);
        // System.out.println(driver.getCurrentUrl());
        // Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/"); // check if successsful login
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
        //Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/Account/Login");
        System.out.println("Logout successful");
    }

    @Test
    void logoutAccountant() throws InterruptedException {
        //openConomeLocalhost();
        //login();
        driver.findElement(By.xpath("//*[contains(@class,'dropdown-toggle no-margin userdropdown user-img user-img-void user-img-dark text-align-right')]")).click(); // click user account logo
        Thread.sleep(800);
        driver.findElement(By.xpath("//header/div[1]/ul[1]/li[1]/ul[1]/li[6]/form[1]")).click();
        Thread.sleep(800);
        //Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/Account/Login");
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
        driver.findElement(By.id("NameMK")).sendKeys("?????? ???????????? 195005");
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
       // Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/companies/createbranch");
        driver.findElement(By.id("NameSQ")).sendKeys("Affiliate Company 195005");
        Thread.sleep(800);
        driver.findElement(By.id("NameMK")).sendKeys("?????????????????????????? ?????????????? 195005");
        Thread.sleep(800);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(800);
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        Thread.sleep(800);
        Assertions.assertTrue(driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]")).isDisplayed());

    }
    Random random = new Random();
    int num = random.nextInt(900) + 100;
    @Test
    void createUser() throws InterruptedException {
        //openConomeLocalhost();
        // login();

        String newUsername = "Accountant 195005_" + num;
        String accountantPassword = "AccountantPassword195005!";
        driver.findElement(By.xpath("//*[contains(@class,'logo logo-ipos-white logo-ipos')]")).click(); // click conome logo
        Thread.sleep(800);
        driver.findElement(By.xpath("//body/div[6]/aside[1]/nav[1]/ul[1]/li[4]/a[1]/p[1]")).click(); // click user logo
        Thread.sleep(800);
        //Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/users/index1");
        driver.findElement(By.xpath("//body/div[6]/aside[1]/nav[1]/ul[1]/li[4]/div[1]/a[1]")).click();//click create
        Thread.sleep(800);
        //Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/users/create");
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

        String newUsername = "Accountant195005_"+num;
        String accountantPassword = "AccountantPassword195005!";

        //Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/Account/Login");
        driver.findElement(By.id("Username")).sendKeys(newUsername);
        Thread.sleep(800);
        driver.findElement(By.id("Password")).sendKeys(accountantPassword);
        Thread.sleep(800);
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(800);
//        if(driver.findElement(By.id("proceedBtn"))!=null){
//            driver.findElement(By.id("proceedBtn")).click(); // conome same account a
//        }
        Thread.sleep(800);
       // Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/"); // check if successsful login
        System.out.println("Login is successsful as accountant!");


    }

    @Test
    void createWorker() throws InterruptedException {
        //openConomeLocalhost();
        //login();
        Random random = new Random();
        int num = random.nextInt(900) + 100;
        driver.findElement(By.xpath("//body/div[6]/aside[1]/nav[1]/ul[1]/li[5]/a[1]/p[1]")).click(); // click worker iicon
       // Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/employees/index1");
        driver.findElement(By.xpath("//body/div[6]/aside[1]/nav[1]/ul[1]/li[5]/div[1]/a[1]")).click(); // click create
       // Assertions.assertEquals(driver.getCurrentUrl(),"https://dev.conome.mk/employees/create");
        driver.findElement(By.id("Name")).sendKeys("Worker 195005"+num);
        driver.findElement(By.id("NameMK")).sendKeys("???????????????? 195005"+num);
        driver.findElement(By.id("Surname")).sendKeys("Worker Surname 195005"+num);
        driver.findElement(By.id("SurnameMK")).sendKeys("?????????????? ???? ???????????????? 195005"+num);
        driver.findElement(By.id("Phone")).sendKeys("70224560");
        driver.findElement(By.id("Address")).sendKeys("Worker Address");
        driver.findElement(By.id("AddressMK")).sendKeys("???????????? ???? ????????????????");
        driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]/div[2]/form[1]/div[4]/div[2]/div[1]/div[2]/div[5]/div[1]/div[1]/button[1]/div[1]")).click();  // click place
        driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]/div[2]/form[1]/div[4]/div[2]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]")).click(); //select place

        driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]/div[2]/form[1]/div[4]/div[2]/div[1]/div[2]/div[6]/div[1]/div[1]/button[1]/div[1]")).click(); //click workplace
        driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]/div[2]/form[1]/div[4]/div[2]/div[1]/div[2]/div[6]/div[1]/div[1]/button[1]/div[1]")).click(); //create workplace
        driver.findElement(By.xpath("//button[@id='AddWorkPlace']")).click();
        driver.findElement(By.id("DescriptionSQ")).sendKeys("This is a description of work place"+num);
        driver.findElement(By.id("DescriptionMK")).sendKeys("?????? ?? ???????? ???? ?????????????????? ??????????"+num);
        driver.findElement(By.id("SaveWorkPlace")).click(); //click to save work place
        driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]/div[2]/form[1]/div[5]/input[1]")).click(); //click create worker
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click(); //accept modal
        driver.findElement(By.cssSelector("body.desktop-detected.menu-on-top.pace-done.smooth:nth-child(2) header.box-shadow-header:nth-child(3) a:nth-child(4) div:nth-child(1) > span.logo.logo-ipos-white.logo-ipos")).click(); //go to home page

    }

    @Test
    void CreateProduct() throws InterruptedException {
        Random random = new Random();
        int num = random.nextInt(900) + 100;
        openConomeLocalhost();
        login();
        driver.findElement(By.xpath("//body/div[6]/aside[1]/nav[1]/ul[1]/li[6]/a[1]")).click(); // click product
        driver.findElement(By.xpath("//body/div[6]/aside[1]/nav[1]/ul[1]/li[6]/div[1]/a[1]")).click(); // click create
        driver.findElement(By.id("Product_NameSQ")).sendKeys("Product Name "+num);
        driver.findElement(By.id("Product_NameMK")).sendKeys("?????? ???? ???????????????? "+num);
        driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]/div[2]/form[1]/div[4]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/button[1]/div[1]")).click(); // click unit
        driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]/div[2]/form[1]/div[4]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]")).click(); //select unit
        driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]/div[2]/form[1]/div[4]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/button[1]/div[1]")).click();//click vat
        driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]/div[2]/form[1]/div[4]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[3]/a[1]")).click(); // select vat
        driver.findElement(By.id("Product_BuyingPriceWithVat")).sendKeys("100");
        driver.findElement(By.id("Product_Profit")).sendKeys("22");
        driver.findElement(By.xpath("//input[@id='test']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click(); //accept modal
        driver.findElement(By.cssSelector("body.desktop-detected.menu-on-top.pace-done.smooth:nth-child(2) header.box-shadow-header:nth-child(3) a:nth-child(4) div:nth-child(1) > span.logo.logo-ipos-white.logo-ipos")).click(); //go to home page

    }

    @Test
    void CreateIncome() throws InterruptedException {
        Random random = new Random();
        int num = random.nextInt(900) + 100;
        openConomeLocalhost();
        login();
        driver.findElement(By.xpath("//body/div[6]/aside[1]/nav[1]/ul[1]/li[7]/a[1]")).click();// click income
        driver.findElement(By.xpath("//body/div[6]/aside[1]/nav[1]/ul[1]/li[7]/div[1]/a[1]")).click(); // click create
        driver.findElement(By.id("Income_NoBilling")).sendKeys(""+num);
        driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/button[1]/div[1]")).click(); // click client
        driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]")).click(); // select client
        driver.findElement(By.id("ShowProduct")).click();


        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//td[contains(text(),'Product Name 278')]"));
        action.doubleClick(element).perform();


        driver.findElement(By.id("Qt")).sendKeys("3");
        driver.findElement(By.xpath("//input[@id='AddIncome']")).click();
        driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]/div[6]/div[1]/div[1]/label[2]")).click();
        driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[6]/div[1]/div[1]/div[1]/button[1]")).click();
        driver.findElement(By.cssSelector("body.desktop-detected.menu-on-top.pace-done.smooth:nth-child(2) header.box-shadow-header:nth-child(3) a:nth-child(4) div:nth-child(1) > span.logo.logo-ipos-white.logo-ipos")).click(); //go to home page

    }

    @Test
    void CreateSale() throws InterruptedException {
        Random random = new Random();
        int num = random.nextInt(900) + 100;
        openConomeLocalhost();
        login();
        driver.findElement(By.xpath("//body/div[6]/aside[1]/nav[1]/ul[1]/li[8]/a[1]")).click();
        driver.findElement(By.xpath("//body/div[6]/aside[1]/nav[1]/ul[1]/li[8]/div[1]/a[1]")).click();
        driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]/div[1]")).click();
        driver.findElement(By.xpath("//body/div[6]/div[2]/div[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[3]/a[1]")).click();
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//td[contains(text(),'Product Name 278')]"));
        action.doubleClick(element).perform();
        driver.findElement(By.id("Qt")).sendKeys("10");
        driver.findElement(By.id("addSaleDetail")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/section[1]/div[1]/div[3]/div[1]/div[1]/div[1]/label[9]")).click();
        driver.findElement(By.id("submitSaveLbl")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click(); //accept modal
        driver.findElement(By.cssSelector("body.desktop-detected.menu-on-top.pace-done.smooth:nth-child(2) header.box-shadow-header:nth-child(3) a:nth-child(4) div:nth-child(1) > span.logo.logo-ipos-white.logo-ipos")).click(); //go to home page

    }




}