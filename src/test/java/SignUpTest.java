import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {
    @Test
    public void sendFiveDigitsToZipCodeTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // Check that register button is shown
        boolean isRegisterButtonDisplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isRegisterButtonDisplayed, "Register button isn't shown");
    }
    @Test
    public void sendFourDigitsToZipcodeTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Input 4 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        // Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // Error message is shown
        boolean isErrorShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorShown, "Error message isn't shown");
    }
    @Test
    public void sendSignUpFormTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Vlad");
        driver.findElement(By.name("last_name")).sendKeys("Safronov");
        driver.findElement(By.name("email")).sendKeys("Vlad@qa.com");
        driver.findElement(By.name("password1")).sendKeys("qwerty123");
        driver.findElement(By.name("password2")).sendKeys("qwerty123");
        // Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // Check massage account is created
        boolean isSuccessMassageShown = driver.findElement(By.className("confirmation_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isSuccessMassageShown, "Success message isn't shown");
    }
    @Test
    public void sendTextZipCodeTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Input text in zipcode field
        driver.findElement(By.name("zip_code")).sendKeys("test");
        // Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // Error message is shown
        boolean isErrorShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorShown, "Error message isn't shown");
    }
    @Test
    public void sendEmptyZipCodeTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // Error message is shown
        boolean isErrorShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorShown, "Error message isn't shown");
    }
    @Test
    public void openShoppingChatTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open main page
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        // Input text in search field
        driver.findElement(By.linkText("Shopping Cart")).click();
        // Error message is shown
        boolean isErrorShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorShown, "Error message isn't shown");
    }
    @Test
    public void searchWithoutDataTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open main page
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        // Click on Search
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[2]/td/form/input[2]")).click();
        // Error message is shown
        boolean isErrorShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorShown, "Error message isn't shown");
    }
    @Test
    public void searchWithUnavailableDataTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open main page
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        // Input text in search field
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[2]/td/form/input[1]")).sendKeys("test");
        // Click on Search
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[2]/td/form/input[2]")).click();
        // Confirmation message is shown
        boolean isConfirmShown = driver.findElement(By.className("confirmation_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isConfirmShown, "Confirmation message isn't shown");
    }
    @Test
    public void logInWithoutDataTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open main page
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        // Input text in search field
        driver.findElement(By.cssSelector("[value=Login]")).click();
        // Error message is shown
        boolean isErrorShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorShown, "Error message isn't shown");
    }
    @Test
    public void sendSignUpFormWithoutNameTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // Input data into fields
        driver.findElement(By.name("last_name")).sendKeys("Safronov");
        driver.findElement(By.name("email")).sendKeys("Vlad@qa.com");
        driver.findElement(By.name("password1")).sendKeys("qwerty123");
        driver.findElement(By.name("password2")).sendKeys("qwerty123");
        // Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // Error message is shown
        boolean isErrorShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorShown, "Error message isn't shown");
    }
    @Test
    public void sendSignUpFormWithoutEmailTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Vlad");
        driver.findElement(By.name("last_name")).sendKeys("Safronov");
        driver.findElement(By.name("password1")).sendKeys("qwerty123");
        driver.findElement(By.name("password2")).sendKeys("qwerty123");
        // Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // Error message is shown
        boolean isErrorShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorShown, "Error message isn't shown");
    }
    @Test
    public void sendSignUpFormWithoutPasswordTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Vlad");
        driver.findElement(By.name("last_name")).sendKeys("Safronov");
        driver.findElement(By.name("email")).sendKeys("Vlad@qa.com");
        driver.findElement(By.name("password2")).sendKeys("qwerty123");
        // Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // Error message is shown
        boolean isErrorShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorShown, "Error message isn't shown");
    }
    @Test
    public void sendSignUpFormWithoutLastNameTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Vlad");
        driver.findElement(By.name("last_name")).sendKeys("Safronov");
        driver.findElement(By.name("email")).sendKeys("Vlad@qa.com");
        driver.findElement(By.name("password1")).sendKeys("qwerty123");
        driver.findElement(By.name("password2")).sendKeys("qwerty123");
        // Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // Check massage account is created
        boolean isSuccessMassageShown = driver.findElement(By.className("confirmation_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isSuccessMassageShown, "Success message isn't shown");
    }
    @Test
    public void sendEmptySignUpFormTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // Error message is shown
        boolean isErrorShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorShown, "Error message isn't shown");
    }
    @Test
    public void sendZipCodeWithInvalidDataTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Input 5 symbols
        driver.findElement(By.name("zip_code")).sendKeys("!@#$%");
        // Click to 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Error message is shown
        boolean isErrorShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorShown, "Error message isn't shown");
    }
    @Test
    public void sendWithoutConfirmPasswordsSignUpFormTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Vlad");
        driver.findElement(By.name("last_name")).sendKeys("Safronov");
        driver.findElement(By.name("email")).sendKeys("Vlad@qa.com");
        driver.findElement(By.name("password1")).sendKeys("qwerty123");
        // Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // Error message is shown
        boolean isErrorShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorShown, "Error message isn't shown");
    }
    @Test
    public void sendDifferentPasswordsSignUpFormTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Vlad");
        driver.findElement(By.name("last_name")).sendKeys("Safronov");
        driver.findElement(By.name("email")).sendKeys("Vlad@qa.com");
        driver.findElement(By.name("password1")).sendKeys("qwerty123");
        driver.findElement(By.name("password2")).sendKeys("qwerty124");
        // Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // Error message is shown
        boolean isErrorShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorShown, "Error message isn't shown");
    }
    @Test
    public void sendInvalidEmailSignUpFormTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Vlad");
        driver.findElement(By.name("last_name")).sendKeys("Safronov");
        driver.findElement(By.name("email")).sendKeys("Vlad@com");
        driver.findElement(By.name("password1")).sendKeys("qwerty123");
        driver.findElement(By.name("password2")).sendKeys("qwerty123");
        // Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // Error message is shown
        boolean isErrorShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorShown, "Error message isn't shown");
    }
    @Test
    public void sendInvalidNameSignUpFormTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("!@#$%^&*");
        driver.findElement(By.name("last_name")).sendKeys("Safronov");
        driver.findElement(By.name("email")).sendKeys("Vlad@qa.com");
        driver.findElement(By.name("password1")).sendKeys("qwerty123");
        driver.findElement(By.name("password2")).sendKeys("qwerty123");
        // Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // Error message is shown
        boolean isErrorShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorShown, "Error message isn't shownnn");
    }
    @Test
    public void sendInvalidLastNameSignUpFormTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Vlad");
        driver.findElement(By.name("last_name")).sendKeys("!@#$%^&*");
        driver.findElement(By.name("email")).sendKeys("Vlad@qa.com");
        driver.findElement(By.name("password1")).sendKeys("qwerty123");
        driver.findElement(By.name("password2")).sendKeys("qwerty123");
        // Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // Error message is shown
        boolean isErrorShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorShown, "Error message isn't shown");
    }
    @Test
    public void sendSixDigitsToZipcodeTest () throws NoSuchElementException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Input 3 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        // Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // Error message is shown
        try {
            driver.findElement(By.className("error_message")).isDisplayed();
        }
            catch (NoSuchElementException e){
            Assert.fail("Bug");
        }
        finally {
            driver.quit();
        }
    }
}


