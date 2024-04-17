import com.codeborne.selenide.Condition;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.DateGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardTest {


    @Test
    void shouldTest() {
        open("http://localhost:9999/");
        $("[data-test-id='city'] input.input__control").setValue("Казань");
        //$("[data-test-id='city'] input.input__control").sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        // Очищаем поле ввода с датой
        //$("[data-test-id='date'] input").clear();
// Посылаем комбинацию клавиш для удаления текста в поле
        $("[data-test-id='date'] input").sendKeys(Keys.SHIFT, Keys.ARROW_UP);
        $("[data-test-id='date'] input").sendKeys(Keys.DELETE);
        // Заполняем поле ввода с датой новым значением
        $(By.xpath("/html/body/div[2]/div/div/div/div/div/table/tbody/tr[4]/td[6]")).click();

        $("[data-test-id='name'] input.input__control").setValue("Иванов Петр");
        $("[data-test-id='phone'] input.input__control").setValue("+79261234567");
        $("[data-test-id='agreement']").click();
        $("span.button__text\n").click();
        //$(withText("Успешно! ")).shouldBe(visible, Duration.ofSeconds(15));
        $(By.cssSelector("div.notification__content")).shouldBe(visible,Duration.ofSeconds(15));
        $(By.cssSelector("div.notification__content")).shouldHave(Condition.exactText("Встреча успешно забронирована на 20.04.2024"));

    }
}
