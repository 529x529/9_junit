package ru.lamoda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CsvSourceTest extends TestBase {

    @CsvSource(value = {
            "Мужчинам | Одежда | Мужская одежда",
            "Женщинам | Одежда | Женская одежда",
            "Детям | Мальчикам | Одежда, обувь и аксессуары для мальчиков"
    },
            delimiter = '|')

    @DisplayName("Проверка перехода на страницы разделов при клике на кнопку меню")
    @ParameterizedTest(name ="При выборе категории {0} и клике на кнопку меню {1} осуществляется переход на страницу раздела {2}")
    void transitionToSectionPages(String categoryName, String button, String page) {
        open("https://www.lamoda.ru/");
        $("._genderWrapper_1pmw8_74").$(byText(categoryName)).click();
        $("._menuWrapper_1pmw8_94").$(byText(button)).click();
        $("._titleWrap_641wy_6").shouldHave(text(page));
    }
}
