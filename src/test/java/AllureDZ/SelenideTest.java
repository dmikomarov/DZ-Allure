package AllureDZ;

import org.junit.jupiter.api.Test;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {
  @Test
  @Owner("Dmitry Komarov")
  @Feature("Issue в репозитории")
  @Story("Проверка Issue")
  @Severity(SeverityLevel.NORMAL)
  @DisplayName("Проверка Issue (Allure c Listener)")
  void testIssueSearch(){
    SelenideLogger.addListener("allure", new AllureSelenide());

    open("https://github.com/");
    $("[name=q]").setValue("selenide").pressEnter();
    $(".repo-list").shouldHave(text("selenide/selenide"));
    $(linkText("selenide/selenide")).click();
    $("#issues-tab").click();
    $("#issue_2130_link").shouldHave(text("Add conditions oneOfTexts, oneOfExactTexts, oneOfTextsCaseSensitive, oneOfExactTextsCaseSensitive"));
  }
}
