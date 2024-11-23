package com.ms.restful_services.Internationalization;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

  @Autowired
  private MessageSource messageSource;

  @GetMapping(path = "/internationalization")
  public String internationalization() {
    Locale locale = LocaleContextHolder.getLocale();
    return messageSource.getMessage(
      "good.morning.message",
      null,
      "Default Message",
      locale
    );
  }
}
