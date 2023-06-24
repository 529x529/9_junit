package ru.lamoda;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ValueSourceTest {
    @ValueSource(
            strings = {"Мужчинам", "Женщинам", "Детям"}
    )

    @ParameterizedTest()
    void mainPageShouldHaveCategories(String categoryName) {
        open("https://www.lamoda.ru/");
        $("._genderWrapper_1pmw8_74")
                .$(byText(categoryName))
                .shouldHave(visible);
    }
}
