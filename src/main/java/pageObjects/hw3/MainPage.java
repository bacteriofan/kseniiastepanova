package pageObjects.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.*;


public class MainPage {

    @FindBy(xpath = "//li[@class = 'dropdown uui-profile-menu']")
    private WebElement loginButton;

    @FindBy(id = "Name")
    private WebElement usernameField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement submitCredentials;

    @FindBy(xpath = "//span[@ui = 'label']")
    private WebElement userNameLabel;

    @FindBy(xpath = "//h3[@name = 'main-title']")
    private WebElement mainHeader;

    @FindBy(xpath = "//p[@name = 'jdi-text']")
    private WebElement mainText;

    @FindBy(xpath = "//a[contains(text(),'JDI Github')]")
    private WebElement subHeader;

    @FindBy(xpath = "//h3[@class='text-center']/a")
    private WebElement url;

    @FindBy(xpath = "//div[@id = 'mCSB_1_container']")
    private WebElement leftSection;

    @FindBy(xpath = "//div[@class = 'footer-content overflow']")
    private WebElement footer;

    @FindBy(xpath = "//ul[@class = 'uui-navigation nav navbar-nav m-l8']/li")
    private List<WebElement> headerItemTexts;

    @FindBy(xpath = "//div[@class = 'row clerafix benefits']//div[@class = 'benefit-icon']")
    private List<WebElement> images;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textsUnderImages;


    //---------------------------------------------------------------------------------------------------------------------

    public void open(WebDriver driver) {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }

    public void checkMainPageTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), "Home Page");
    }

    public void login(String login, String password, String name) {
        loginButton.click();
        usernameField.sendKeys(login);
        passwordField.sendKeys(password);
        submitCredentials.click();
        assertEquals(userNameLabel.getText(), name);
    }

    public void checkHeaderItemsText() {
        List<String> expectedHeaderItemsTexts = new LinkedList<String>();
        expectedHeaderItemsTexts.add("HOME");
        expectedHeaderItemsTexts.add("CONTACT FORM");
        expectedHeaderItemsTexts.add("SERVICE");
        expectedHeaderItemsTexts.add("METALS & COLORS");

        for (int i = 0; i < headerItemTexts.size(); i++) {
            assertEquals(headerItemTexts.get(i).getText(),
                    expectedHeaderItemsTexts.get(i));
        }
    }

    public void checkImagesAreDisplayed() {
        assertEquals(images.size(), 4);
        images.forEach(image -> assertTrue(image.isDisplayed()));
   }

    public void checkTextUnderImages() {
        List<String> expectedTexts = new LinkedList<String>();
        expectedTexts.add("To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        expectedTexts.add("To be flexible and\n" +
                "customizable");
        expectedTexts.add("To be multiplatform");
        expectedTexts.add("Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        for (int i = 0; i < textsUnderImages.size(); i++) {
            assertEquals(textsUnderImages.get(i).getText(),
                    expectedTexts.get(i));
        }
    }

    public void checkMainHeaderText() {
        assertEquals(mainHeader.getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(mainText.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
                "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE " +
                "IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
    }

    public void checkSubHeader() {
        assertEquals(subHeader.getText(), "JDI GITHUB");
    }

    public void checkURL() {
        assertEquals(url.getAttribute("href"), "https://github.com/epam/JDI");
    }

    public void checkLeftSectionIsDisplayed() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkFooterIsDisplayed() {
        assertTrue(footer.isDisplayed());
    }
}

