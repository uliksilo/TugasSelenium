import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class TugasSelenium {

//    Test Case
//    1. Mengisi username dan password kosong
//    2. Mengisi username dan mengosongkan password

    WebDriver driver;
    WebDriverWait wait;
    WebElement username;
    WebElement password;
    WebElement w3loginBtn;
    WebElement loginBtn;
    WebElement errorMsg;
    WebElement title;

    @Test()
    public void loginWithEmptyUsernameAndPassword() {
        String driverPath = System.getProperty("user.dir") + "/resources/chromedriver.exe";
        System.out.println("Driver Path: " + driverPath);
        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://www.w3schools.com/");

        w3loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("w3loginbtn")));
        w3loginBtn.click();

        loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("LoginModal_cta_bottom_box__wU1AF")));
        loginBtn.click();

        errorMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("EmailInput_email_error__IJxXf")));
        Assert.assertTrue(errorMsg.isDisplayed(), "Please enter an email");
        driver.close();

    }

        //        modalusername id
        //current-password id
    @Test()
    public void loginWithEmptyUsername(){
//        String driverPath = System.getProperty("user.dir") + "/resources/chromedriver.exe";
//        System.out.println("Driver Path: " + driverPath);//absolutepath(letak project pada device)
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");//relativepath(hanya lokasi pada intellij)

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://www.w3schools.com/");

        w3loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Log in']")));
        w3loginBtn.click();

        password = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("current-password")));
        password.sendKeys("siregar01");

        loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("LoginModal_cta_bottom_box__wU1AF")));
        loginBtn.click();

        errorMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("EmailInput_email_error__IJxXf")));
        Assert.assertTrue(errorMsg.isDisplayed(), "Please enter an email");
        driver.close();

        //xpath button login //*[@id="root"]/div/div/div[4]/div[1]/div/div[4]/div[1]/button



        }


}
