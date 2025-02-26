package com.ms.restful_services.Exception;

import java.time.LocalDateTime;

public class ErrorDetails {

  private LocalDateTime date;
  private String message;
  private String details;

  public ErrorDetails(LocalDateTime date, String message, String details) {
    this.date = date;
    this.message = message;
    this.details = details;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public String getMessage() {
    return message;
  }

  public String getDetails() {
    return details;
  }
}
