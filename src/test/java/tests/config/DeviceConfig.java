package tests.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:android.properties"})

public interface DeviceConfig extends Config {
    @Key("deviceName")
    String getDevice();

    @Key("platformVersion")
    String getVersion();

    @Key("appUrl")
    String getApp();
}
