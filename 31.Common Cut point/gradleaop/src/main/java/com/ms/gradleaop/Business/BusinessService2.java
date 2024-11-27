package com.ms.gradleaop.Business;

import com.ms.gradleaop.AOP.Aspects.Annotations.TrackTime;
import com.ms.gradleaop.Data.DataService2;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService2 {

  @Autowired
  private DataService2 dataService2;

  @TrackTime
  public int claculateMin() {
    int[] data = dataService2.retrieveData();
    try {
      Thread.sleep(30);
    } catch (Exception e) {
      e.printStackTrace();
    }

    // throw new RuntimeException("Throwing new Runtime Exception");
    return Arrays.stream(data).min().orElse(0);
  }
}
