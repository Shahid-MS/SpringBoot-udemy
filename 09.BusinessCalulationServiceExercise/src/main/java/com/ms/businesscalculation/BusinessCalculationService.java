package com.ms.businesscalculation;

import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationService {

  private DataService dataService;

  public BusinessCalculationService(DataService dataService) {
    System.out.println("Business calculation constructor called");
    this.dataService = dataService;
  }

  public int findMax() {
    int max = Integer.MIN_VALUE;
    for (int currData : dataService.retrieveData()) {
      max = Math.max(max, currData);
    }
    return max;
  }
}
