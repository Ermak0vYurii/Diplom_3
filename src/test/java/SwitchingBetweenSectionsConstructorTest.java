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
        assertTrue(objMainPage.listBunsIsDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу Булки из раздела Начинки")
    public void switchingSectionsFillingsToBunsTest() {
        objMainPage = new MainPage(driver);
        objMainPage.clickFillingsButton();
        objMainPage.clickBunsButton();
        assertTrue(objMainPage.listBunsIsDisplayed());
    }



}
