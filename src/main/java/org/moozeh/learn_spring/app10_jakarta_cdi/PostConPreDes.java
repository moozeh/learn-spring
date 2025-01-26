package org.moozeh.learn_spring.app10_jakarta_cdi;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * 2004년에 스프링이 나오고, Java 가 이후에 2009년 12월 Java EE 6에 도입하게 된다.
 * 
 * 스프링은 이러한 CDI 에 대한 규격을 구현한다.
 * 
 * CDI (Context & Dependency Injection) 자체는 규격을 뜻한다.
 * 
 * 이후, 스프링6 가 되면서, Jakarta EE를 지원하게 되는데, 
 * 동일하게 Jakarta API에 대해서도 지원이 되고 있음을 확인할 수 있는 예제이다.
 */

// @Component
@Named // JakartaCDI Injection API를 써보자!
class BusinessService {
    private DataService dataService;

    public DataService getDataService() {
        
        return this.dataService;
    }

    // @Autowired
    @Inject // Autowired 대신에 Inject를 써보자!
    public void setDataService(DataService dataService) {
        System.out.println("Setter Injection");
        this.dataService = dataService;
    }
    
}

// @Component
@Named
class DataService {

}

@Configurable
@ComponentScan
public class PostConPreDes {
    public static void main(String[] args) {
        try (var ctx = new AnnotationConfigApplicationContext(PostConPreDes.class)) {
            System.out.println(ctx.getBean(BusinessService.class)
                .getDataService());
        }
    }
}
