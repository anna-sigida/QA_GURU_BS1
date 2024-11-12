package tests.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import tests.config.BrowserStackConfig;
import tests.config.DeviceConfig;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackDriver implements WebDriverProvider {

    public static BrowserStackConfig bsConfig = ConfigFactory.create(BrowserStackConfig.class, System.getProperties());
    public static DeviceConfig deviceConfig = ConfigFactory.create(DeviceConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", bsConfig.getUserName());
        caps.setCapability("browserstack.key", bsConfig.getKey());

        caps.setCapability("app", deviceConfig.getApp());

        caps.setCapability("device", deviceConfig.getDevice());
        caps.setCapability("os_version", deviceConfig.getVersion());

        caps.setCapability("project", "Browserstack Auto Tests");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "wiki tests");

        try {
            return new RemoteWebDriver(
                    new URL(bsConfig.getRemoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}