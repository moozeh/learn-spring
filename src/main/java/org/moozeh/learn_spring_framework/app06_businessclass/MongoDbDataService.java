package org.moozeh.learn_spring_framework.app06_businessclass;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MongoDbDataService implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[] {1, 2, 3};
    }
}
