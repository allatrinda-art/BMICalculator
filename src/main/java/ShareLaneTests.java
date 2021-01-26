import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ShareLaneTests {

  /*  @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\itechart\\Downloads\\chromedriver_win32.zip");
    }*/

    @Test
    public void ZipCode() {
        /*User can enter zip-code to proceed to sign up form*/
        open("https://www.sharelane.com/");
        $(By.xpath("//*[text()='ENTER']")).click();
        open("https://www.sharelane.com/cgi-bin/register.py");
        $(By.name("zip_code")).sendKeys("12345");
        $(By.cssSelector("[value=Continue]")).click();

        String result = $(By.cssSelector("[value=Register]")).getAttribute("value");// изучить getAttribute
        Assert.assertEquals(result, "Register");
    }

    @Test
    public void zipcode4Digits(){
        /*Error when 4 digits were entered*/
        open("https://www.sharelane.com/");
        $(By.xpath("//*[text()='ENTER']")).click();
        open("https://www.sharelane.com/cgi-bin/register.py");
        $(By.name("zip_code")).sendKeys("1234");
        $(By.cssSelector("[value=Continue]")).click();

        String result = $(By.cssSelector(".error_message")).getAttribute("class");// изучить getAttribute
        Assert.assertEquals(result, "Oops, error on page. ZIP code should have 5 digits\n");
    }

    @Test
    public void zipcode6Digits() {
        /*Error when 6 digits were entered*/
        open("https://www.sharelane.com/");
        $(By.xpath("//*[text()='ENTER']")).click();
        open("https://www.sharelane.com/cgi-bin/register.py");
        $(By.name("zip_code")).sendKeys("123456");
        $(By.cssSelector("[value=Continue]")).click();

        String result = $(By.cssSelector(".error_message")).getAttribute("class");// изучить getAttribute
        Assert.assertEquals(result, "Oops, error on page. ZIP code should have 5 digits\n");
    }

    @Test
    public void emptyZipcode(){
        /*Error when zip code field is empty*/
        open("https://www.sharelane.com/");
        $(By.xpath("//*[text()='ENTER']")).click();
        open("https://www.sharelane.com/cgi-bin/register.py");
        $(By.name("zip_code")).sendKeys("");
        $(By.cssSelector("[value=Continue]")).click();

        String result = $(By.cssSelector(".error_message")).getAttribute("class");// изучить getAttribute
        Assert.assertEquals(result, "Oops, error on page. ZIP code should have 5 digits\n");
    }

    @Test
    public void userCanSignUp(){
        /*userCanSignUp filling all required fields*/
        open("https://www.sharelane.com/");
        $(By.xpath("//*[text()='ENTER']")).click();
        open("https://www.sharelane.com/cgi-bin/register.py");
        $(By.name("zip_code")).sendKeys("12345");
        $(By.cssSelector("[value=Continue]")).click();
        $(By.name("first_name")).sendKeys("Luke");
        $(By.name("email")).sendKeys("1@mailinator.com");
        $(By.name("password1")).sendKeys("pswrd");
        $(By.name("password2")).sendKeys("pswrd");
        $(By.cssSelector("[value=Register]")).click();

        String result = $(By.cssSelector("[value=Continue]")).getAttribute("value");
        Assert.assertEquals(result, "Account is created!\n");

    }
}
