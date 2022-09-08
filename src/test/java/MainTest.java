import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest {
    public static WebDriver driver;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
    }

    /*@AfterEach///
    void tearDown() {
        driver.quit();
    }*/
    String email = "halimifat@gmail.com";
    String password = "Fati12345@#";
    @Test()
    void callTest() throws InterruptedException {
        openConome();
        registerAccount();
        login();
        newComer();
    }
    @Test
    void openConome() {
        driver.get("https://www.conome.mk/");
        if(driver.findElement(By.xpath("//*[contains(@class, 'pum-close popmake-close')]"))!=null) // if ad is displayed
        {
            driver.findElement(By.xpath("//*[contains(@class, 'pum-close popmake-close')]")).click(); // click to close ad
        }
        if(driver.findElement(By.xpath("//*[contains(@id, 'cookie_action_close_header')]"))!=null) { // if cookie is displayed
            driver.findElement(By.xpath("//*[contains(@id, 'cookie_action_close_header')]")).click(); // click to accept cookies
        }

    }

    @Test
    void registerAccount() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(@class,'menu_cus btn_get btn-meta btn_hover')]")).click(); // click register
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary btn-sm acceptcookies')]")).click(); // accept cookies
        Thread.sleep(1500);
        driver.findElement(By.xpath("//button[contains(@class,'login100-form-btn btn-submit')]")).click(); //  click continue
        Thread.sleep(1500);
        driver.findElement(By.id("Email")).sendKeys("halimifat.fh@gmail.com");// send email
        driver.findElement(By.id("Password")).sendKeys(password); // send password
        driver.findElement(By.id("PasswordHint")).sendKeys("HintOfPw"); // send hint password
        driver.findElement(By.xpath("//button[contains(@class,'login100-form-btn')]")).click(); // click register

    }

    @Test
    void login(){
        driver.findElement(By.id("Username")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("proceed")).click();
    }

    @Test
    void newComer(){
        driver.findElement(By.id("CompanyName")).sendKeys("DemoCompany195005");
        driver.findElement(By.id("next")).click();
        driver.findElement(By.tagName("button")).click();
    }



}
