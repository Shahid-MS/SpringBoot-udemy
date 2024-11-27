package com.ms.gradleaop.Business;

import com.ms.gradleaop.Data.DataService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

  @Autowired
  private DataService dataService;

  public int claculateMax() {
    int[] data = dataService.retrieveData();
    try {
      Thread.sleep(30);
    } catch (Exception e) {
      e.printStackTrace();
    }

    // throw new RuntimeException("Throwing new Runtime Exception");
    return Arrays.stream(data).max().orElse(0);
  }
}
