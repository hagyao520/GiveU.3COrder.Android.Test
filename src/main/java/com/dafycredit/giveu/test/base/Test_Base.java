package com.dafycredit.giveu.test.base;

import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;

public class Test_Base {
	
	private String name;

    private String desc;

    private boolean cancel;

    private AndroidDriver<WebElement> driver;

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public AndroidDriver<WebElement> getDriver() {
        return driver;
    }

    public void setDriver(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

}
