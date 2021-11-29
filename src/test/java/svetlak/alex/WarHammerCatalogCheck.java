package svetlak.alex;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class WarHammerCatalogCheck {

    public SelenideElement
            searchField = $(".search-term"),
            searchButton = $(".gtm-view-all"),
            mainContent = $("#mainContent");
    }
