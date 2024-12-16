package ui;

import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.openqa.selenium.By;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class LoginUI {

    public static final Target TITLE = Target.the("title").located(
            By.xpath("//h4[contains(.,'Inicio de sesión')]"));

    public static final Target EMAIL = Target.the("email").located(
            ByShadow.cssSelector("#username-input", "#username"));

    public static final Target PASSWORD = Target.the("password").located(
            ByShadow.cssSelector("#password-input", "#current-password"));

    public static final Target SIGN_IN_BUTTON = Target.the("Sign in button").locatedBy("#login-submit");
}
