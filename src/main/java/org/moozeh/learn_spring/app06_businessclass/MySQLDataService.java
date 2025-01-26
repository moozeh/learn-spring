package org.moozeh.learn_spring.app06_businessclass;

import org.springframework.stereotype.Component;

@Component
public class MySQLDataService implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[] { 4, 5, 6 };
    }
}
