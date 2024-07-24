package tests;

import org.junit.jupiter.api.BeforeAll;

import pages.AuthPage;
import pages.MainMenuPage;
import pages.StartPage;

public class AuthTest extends BaseTest {
    private static AuthPage authPage;
    private static StartPage startPage;
    private static MainMenuPage mainPage;

    @BeforeAll
    public static void init() {
        authPage = new AuthPage();
        mainPage = new MainMenuPage();
    }

}
