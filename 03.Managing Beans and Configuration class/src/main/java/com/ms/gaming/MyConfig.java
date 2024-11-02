package com.ms.gaming;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age) {}

record PersonWithAddress(String name, int age, Address address) {}

record Address(String city, int pincode) {}

@Configuration
public class MyConfig {

  @Bean
  public String name() {
    return "MS 2.O";
  }

  @Bean
  public int age() {
    return 21;
  }

  @Bean
  public Person person() {
    var person = new Person("MS 3.O", 14);
    return person;
  }

  @Bean(name = "customNameAddress")
  public Address address() {
    var address = new Address("Bhagalpur", 812002);
    return address;
  }

  //   Using Existing Bean
  //   1.MethodCall
  @Bean
  public Person person2MethodCall() {
    return new Person(name(), age());
  }

  //   2.Parameter
  @Bean
  public PersonWithAddress person3Parameter(
    String name,
    int age,
    Address address
  ) {
    var personWithAddress = new PersonWithAddress(name, age, address);
    return personWithAddress;
  }

  //If Multiple the take this as default
  @Bean
  @Primary
  public Address addressPrimary() {
    return new Address("Patna", 810001);
  }

  @Bean
  @Qualifier("specificAddress")
  public Address addressSpecific() {
    return new Address("Kolkata", 700107);
  }

  @Bean
  public PersonWithAddress personSpecificAddress(
    String name,
    int age,
    @Qualifier("specificAddress") Address address
  ) {
    return new PersonWithAddress(name, age, address);
  }
}
