package org.moozeh.learn_spring.app06_businessclass;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class BusinessCalculationService {
    private final DataService dataService; // write access modifier every time.

    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
