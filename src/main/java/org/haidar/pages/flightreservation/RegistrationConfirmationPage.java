package org.haidar.pages.flightreservation;

import org.haidar.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmationPage extends AbstractPage {

    public RegistrationConfirmationPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.goToFlightSearchButton));
        return this.goToFlightSearchButton.isDisplayed();
    }

    @FindBy(css = "#registration-confirmation-section p b")
    private WebElement firstNameElement;

    @FindBy(id = "go-to-flights-search")
    private WebElement goToFlightSearchButton;

    public void goToFlightSearch(){
        this.goToFlightSearchButton.click();
    }

    public String getFirstName(){
        return this.firstNameElement.getText();
    }

}



