package com.ms.businesscalculation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class mySqlDataService implements DataService {

  @Override
  public int[] retrieveData() {
    return new int[] { 11, 31, 51, 61, 31, 21, 11 };
  }
}
