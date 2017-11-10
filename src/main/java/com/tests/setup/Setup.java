package com.tests.setup;

import com.tests.helpers.ui.Browser;
import com.tests.helpers.ui.Page;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Setup extends Page{

    public static Properties browserProp = new Properties();
    public static Properties projectProp = new Properties();
    public static InputStream browserFile = null;
    public static InputStream projectFile = null;

    public Setup(){
        try {

            browserFile = new FileInputStream("properties/browser.properties");
            projectFile = new FileInputStream("properties/project.properties");


            // load a properties file
            browserProp.load(browserFile);
            projectProp.load(projectFile);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void startBrowser() {
        DriverFactory.getDriver();
        new Browser().navigateTo(projectProp.getProperty("app_url"));
    }


}
