package com.ms.restful_services.Person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {

  @GetMapping("/v1/person")
  public PersonV1 getFirstPersonVersion() {
    return new PersonV1("Bob Charlie");
  }

  @GetMapping("/v2/person")
  public PersonV2 getSecondPersonVersion() {
    return new PersonV2(new Name("Bob", "Charlie"));
  }

  @GetMapping(path = "/person", params = "version=1")
  public PersonV1 getFirstPersonVersionParameter() {
    return new PersonV1("Bob Charlie");
  }

  @GetMapping(path = "/person", params = "version=2")
  public PersonV2 getSecondPersonVersionParameter() {
    return new PersonV2(new Name("Bob", "Charlie"));
  }

  @GetMapping(path = "/person/headers", headers = "X-API-VERSION=1")
  public PersonV1 getFirstPersonVersionHeaders() {
    return new PersonV1("Bob Charlie");
  }

  @GetMapping(path = "/person/headers", headers = "X-API-VERSION=2")
  public PersonV2 getSecondPersonVersionHeaders() {
    return new PersonV2(new Name("Bob", "Charlie"));
  }

  @GetMapping(
    path = "/person/accept",
    produces = "application/vnd.company.app-v1+json"
  )
  public PersonV1 getFirstPersonVersionMediaType() {
    return new PersonV1("Bob Charlie");
  }

  @GetMapping(
    path = "/person/accept",
    produces = "application/vnd.company.app-v2+json"
  )
  public PersonV2 getSecondPersonVersionMediaType() {
    return new PersonV2(new Name("Bob", "Charlie"));
  }
}
