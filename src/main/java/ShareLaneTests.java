import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ShareLaneTests {

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
}
