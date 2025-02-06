import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.MainPage;

import static org.junit.Assert.assertTrue;

public class SwitchingBetweenSectionsConstructorTest extends BaseTest {

    MainPage objMainPage;

    @Test
    @DisplayName("Переход к разделу Булки из раздела Соусы")
    public void switchingSectionsSaucesToBunsTest() {
        objMainPage = new MainPage(driver);
        objMainPage.clickSaucesButton();
        objMainPage.clickBunsButton();
        String className = objMainPage.getClassBunsSection();
        assertTrue(className.contains("type_current"));
    }

    @Test
    @DisplayName("Переход к разделу Булки из раздела Начинки")
    public void switchingSectionsFillingsToBunsTest() {
        objMainPage = new MainPage(driver);
        objMainPage.clickFillingsButton();
        objMainPage.clickBunsButton();
        String className = objMainPage.getClassBunsSection();
        assertTrue(className.contains("type_current"));
    }

    @Test
    @DisplayName("Переход к разделу Соусы из раздела Булки")
    public void switchingSectionsBunsToSaucesTest() {
        objMainPage = new MainPage(driver);
        objMainPage.clickSaucesButton();
        String className = objMainPage.getClassSaucesSection();
        assertTrue(className.contains("type_current"));
    }

    @Test
    @DisplayName("Переход к разделу Соусы из раздела Начинки")
    public void switchingSectionsFillingsToSaucesTest() {
        objMainPage = new MainPage(driver);
        objMainPage.clickFillingsButton();
        objMainPage.clickSaucesButton();
        String className = objMainPage.getClassSaucesSection();
        assertTrue(className.contains("type_current"));
    }

    @Test
    @DisplayName("Переход к разделу Начинки из раздела Булки")
    public void switchingSectionsBunsToFillingsTest() {
        objMainPage = new MainPage(driver);
        objMainPage.clickFillingsButton();
        String className = objMainPage.getClassFillingsSection();
        assertTrue(className.contains("type_current"));
    }

    @Test
    @DisplayName("Переход к разделу Начинки из раздела Соусы")
    public void switchingSectionsSaucesToFillingsTest() {
        objMainPage = new MainPage(driver);
        objMainPage.clickSaucesButton();
        objMainPage.clickFillingsButton();
        String className = objMainPage.getClassFillingsSection();
        assertTrue(className.contains("type_current"));
    }
}