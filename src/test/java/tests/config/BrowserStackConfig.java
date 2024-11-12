package tests.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:bs.properties"})

public interface BrowserStackConfig extends Config {
    @Key("userName")
    @DefaultValue("anna_ZtknGS")
    String getUserName();

    @Key("accessKey")
    @DefaultValue("f71NeMTQfGa76ZTYZqXQ")
    String getKey();

    @Key("remoteUrl")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String getRemoteUrl();
}
