package com.tests.helpers.ui;

import org.openqa.selenium.WebElement;

public class Fill {

    private Page page;
    WebElement element;

    public Fill(Page page, WebElement element)
    {
        this.page = page;
        this.element = element;
    }

    public Page with(String value)
    {
        element.clear();
        element.sendKeys(value);
        //element.sendKeys(Keys.TAB);
        return page;
    }
}
