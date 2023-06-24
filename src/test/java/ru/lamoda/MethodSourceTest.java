package ru.lamoda;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MethodSourceTest extends TestBase {
    static Stream<Arguments> verifyMenuButtons() {

        return Stream.of(
                Arguments.of("Женщинам", List.of("Идеи", "Новинки", "Одежда", "Обувь", "Аксессуары",
                        "Бренды", "Premium", "Спорт","Resale", "Красота", "Дом", "Sale%")),
                Arguments.of("Мужчинам", List.of("Идеи", "Новинки", "Одежда", "Обувь", "Аксессуары",
                        "Бренды", "Premium", "Спорт","Resale", "Красота", "Дом", "Sale%")),
                Arguments.of("Детям", List.of("Школа", "Новинки", "Девочкам", "Мальчикам",
                        "Малышам", "Бренды", "Premium", "Спорт", "Игрушки", "Дом", "Уход", "Resale", "Sale%"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "При выборе категории {0} в меню отображаются следующие кнопки {1}")
    void verifyMenuButtons(String categoryName, List<String> expectedButtons) {
        open("https://www.lamoda.ru/");
        $("._genderWrapper_1pmw8_74").$(byText(categoryName)).click();
        $$("._root_1416b_2 a").should(texts(expectedButtons));
    }
}
