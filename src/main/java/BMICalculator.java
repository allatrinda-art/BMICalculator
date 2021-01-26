import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * @author allatrinda
 */
public class BMICalculator {

    @Test
    public void calcTEst() {
        open("https://healthunify.com/bmicalculator/");
        $(By.name("wg")).sendKeys("85");
        $(By.name("ht")).sendKeys("185");
        $(By.name("cc")).click();
        String result = $(By.name("desk")).getAttribute("value");// изучить getAttribute
        Assert.assertEquals(result, "Your category is Normal");
    }

}
