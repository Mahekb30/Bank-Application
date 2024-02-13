package com.example.dtos;

public class LoanEvent {
  
  private String message;
  private String status;
  private LoanRequestDto loan;
  
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public LoanRequestDto getLoan() {
    return loan;
  }
  public void setLoan(LoanRequestDto loan) {
    this.loan = loan;
  }
  public LoanEvent(String message, String status, LoanRequestDto loan) {
    super();
    this.message = message;
    this.status = status;
    this.loan = loan;
  }
  public LoanEvent() {
    super();
    // TODO Auto-generated constructor stub
  }
  
  
}
