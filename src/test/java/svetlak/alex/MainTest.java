package svetlak.alex;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class MainTest {

    WarHammerCatalogCheck warHammerCatalogCheck = new WarHammerCatalogCheck();

    static String URL = "https://www.games-workshop.com/en-GB/Home";

    public String race = "T'au codex";

    @DisplayName("Поиск кодекса Тау в каталоге")
    @Tag("Catalog")
    @Test
    void searchCodex() {
        open(URL);
        warHammerCatalogCheck.searchField.setValue(race);
        warHammerCatalogCheck.searchButton.click();
        warHammerCatalogCheck.mainContent.shouldHave(Condition.text("Codex: T’au Empire"));
    }

    @ValueSource(strings = {"Codex: T’au Empire", "Codex: Chaos Knights"})
    @DisplayName("Поиск кодексов Тау и Хаоситов")
    @Tag("Catalog")
    @ParameterizedTest(name = "Поиск {0} ")
    void searchCodex(String race) {
        open(URL);
        warHammerCatalogCheck.searchField.setValue(race);
        warHammerCatalogCheck.searchButton.click();
        warHammerCatalogCheck.mainContent.shouldHave(Condition.text(race));
    }

    @CsvSource(value = {
            "Codex: T’au Empire| 25",
            "Codex: Chaos Knights| 25"
    },
            delimiter = '|')
    @DisplayName(" Проверка кодексов и цен")
    @Tag("Catalog")
    @ParameterizedTest(name = "Поиск кодексв {0} и проверка цены {1}")
    void searchCodex(String race, String price) {
        open(URL);
        warHammerCatalogCheck.searchField.setValue(race);
        warHammerCatalogCheck.searchButton.click();
        warHammerCatalogCheck.mainContent.shouldHave(Condition.text(race));
        warHammerCatalogCheck.mainContent.shouldHave(Condition.text(price));

    }


}
