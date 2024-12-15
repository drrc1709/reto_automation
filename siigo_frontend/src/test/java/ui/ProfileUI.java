package ui;

import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ProfileUI {

    public static final Target AUTHENTICATED_USER = Target.the("dashboard title").located(
            ByShadow.cssSelector("div[class='company-header-title']", "siigo-header-molecule[class='data-siigo-five9 hydrated']"));

    public static final Target CREATE = Target.the("Click button Crear").located(
            ByShadow.cssSelector("div[class='wc--siigo dsm-siigo']", "siigo-header-molecule[class='data-siigo-five9 hydrated']", "siigo-button-atom[text='Crear']"));

    public static final Target CLIENTS = Target.the("Click option Clientes").located(
            ByShadow.cssSelector("a[data-value='Clientes']", "siigo-header-molecule[class='data-siigo-five9 hydrated']"));
}
