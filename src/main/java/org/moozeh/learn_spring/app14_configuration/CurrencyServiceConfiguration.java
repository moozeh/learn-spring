package org.moozeh.learn_spring.app14_configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 별도로 내가 설정하고 싶은 값들이 많을 경우, application.properties 에서 직접 설정하면 된다.
 * currency-service.url=...
 * currency-service.username=...
 * currency-service.key= ...
 *
 * 하지만, 그 설정 값들이 많아질 경우, 별도로 Confiruation Class를 만드는 것도 좋은 방법이다.
 *
 * properties 파일에서 설정한 값 그대로, 아래 설정 클래스에서 그대로 매핑되게 된다..!
 * 매번 불러올 필요가 없게 된다.
 */

@ConfigurationProperties(prefix = "currency-service") // 모든 같은 설정값에 접두사를 사용하므로
@Component // 해당 설정 클래스 또한 의존성으로써 Spring 에서 관리하게 한다. 너무 편하다.
public class CurrencyServiceConfiguration {

    private String url;
    private String username;
    private String key;

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getKey() {
        return key;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
