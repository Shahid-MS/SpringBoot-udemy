package com.ms.restful_services.Filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

  @GetMapping("/static-filtering")
  public SomeBean getBean() {
    return new SomeBean("value1", "value2", "value3");
  }

  @GetMapping("/static-filtering-list")
  public List<SomeBean> getBeanList() {
    return Arrays.asList(
      new SomeBean("val1", "val2", "val3"),
      new SomeBean("val4", "val5", "val6")
    );
  }

  @GetMapping("/dynamic-filtering")
  public MappingJacksonValue getDynamicBean() {
    DynamicSomeBean someBean = new DynamicSomeBean("val1", "val2", "val3");
    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);

    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(
      "field1",
      "field3"
    );
    FilterProvider filterProvider = new SimpleFilterProvider()
      .addFilter("someBeanFilter", filter);
    mappingJacksonValue.setFilters(filterProvider);

    return mappingJacksonValue;
  }

  @GetMapping("/dynamic-filtering-list")
  public MappingJacksonValue getDyanmicBeanList() {
    List<DynamicSomeBean> listDynamicSomeBean = Arrays.asList(
      new DynamicSomeBean("val1", "val2", "val3"),
      new DynamicSomeBean("val4", "val5", "val6")
    );

    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(
      listDynamicSomeBean
    );

    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(
      "field2"
    );
    FilterProvider filterProvider = new SimpleFilterProvider()
      .addFilter("someBeanFilter", filter);
    mappingJacksonValue.setFilters(filterProvider);

    return mappingJacksonValue;
  }
}
