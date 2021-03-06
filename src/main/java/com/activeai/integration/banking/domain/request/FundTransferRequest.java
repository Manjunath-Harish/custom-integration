package com.activeai.integration.banking.domain.request;

import com.activeai.integration.banking.constants.PayeeTypeEnum;
import com.activeai.integration.banking.model.Phone;
import com.activeai.integration.banking.model.User;

import java.util.List;

public class FundTransferRequest extends User {

  /** IMPS, RTGS, NEFT. */
  private String type;

  /**
   * source account to debit from
   */
  private String sourceAccountId;

  /** amount to transfer. */
  private String amount;

  /** purpose of transfer. */
  private String purpose;

  /**
   * selected Payee Id
   */
  private String payeeId;

  /** transaction remarks if any. */
  private String remarks;

  /** payeeType INTERNAL_DOMESTIC, WALLET or EXTERNAL_DOMESTIC. */
  private PayeeTypeEnum payeeType;

  /** The payee IFSC code. */
  private String payeeIFSCCode;

  /** The payee bank id. */
  private String payeeBankId;

  /** The payee branch id. */
  private String payeeBranchId;

  /**
   * Account Id incase if this is different from account number
   */
  private String payeeAccountId;

  /**
   * Account Number to which amount will be credited
   */
  private String payeeAccountNumber;

  /**
   * In case of Quick transfer, the mobile number to which amount will be credited
   */
  private Phone payeeMobileNumber;

  /**
   * In case of Quick transfer, the emailId to which amount will be credited
   */
  private String payeeEmailId;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getSourceAccountId() {
    return sourceAccountId;
  }

  public void setSourceAccountId(String sourceAccountId) {
    this.sourceAccountId = sourceAccountId;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getPurpose() {
    return purpose;
  }

  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  public String getPayeeId() {
    return payeeId;
  }

  public void setPayeeId(String payeeId) {
    this.payeeId = payeeId;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public PayeeTypeEnum getPayeeType() {
    return payeeType;
  }

  public void setPayeeType(PayeeTypeEnum payeeType) {
    this.payeeType = payeeType;
  }

  public String getPayeeIFSCCode() {
    return payeeIFSCCode;
  }

  public void setPayeeIFSCCode(String payeeIFSCCode) {
    this.payeeIFSCCode = payeeIFSCCode;
  }

  public String getPayeeBankId() {
    return payeeBankId;
  }

  public void setPayeeBankId(String payeeBankId) {
    this.payeeBankId = payeeBankId;
  }

  public String getPayeeBranchId() {
    return payeeBranchId;
  }

  public void setPayeeBranchId(String payeeBranchId) {
    this.payeeBranchId = payeeBranchId;
  }

  public String getPayeeAccountId() {
    return payeeAccountId;
  }

  public void setPayeeAccountId(String payeeAccountId) {
    this.payeeAccountId = payeeAccountId;
  }

  public String getPayeeAccountNumber() {
    return payeeAccountNumber;
  }

  public void setPayeeAccountNumber(String payeeAccountNumber) {
    this.payeeAccountNumber = payeeAccountNumber;
  }

  public Phone getPayeeMobileNumber() {
    return payeeMobileNumber;
  }

  public void setPayeeMobileNumber(Phone payeeMobileNumber) {
    this.payeeMobileNumber = payeeMobileNumber;
  }

  public String getPayeeEmailId() {
    return payeeEmailId;
  }

  public void setPayeeEmailId(String payeeEmailId) {
    this.payeeEmailId = payeeEmailId;
  }

  @Override public String toString() {
    final StringBuffer sb = new StringBuffer("FundTransferRequest{");
    sb.append("type='").append(type).append('\'');
    sb.append(", sourceAccountId='").append(sourceAccountId).append('\'');
    sb.append(", amount='").append(amount).append('\'');
    sb.append(", purpose='").append(purpose).append('\'');
    sb.append(", payeeId='").append(payeeId).append('\'');
    sb.append(", remarks='").append(remarks).append('\'');
    sb.append(", payeeType='").append(payeeType).append('\'');
    sb.append(", payeeIFSCCode='").append(payeeIFSCCode).append('\'');
    sb.append(", payeeBankId='").append(payeeBankId).append('\'');
    sb.append(", payeeBranchId='").append(payeeBranchId).append('\'');
    sb.append(", payeeAccountId='").append(payeeAccountId).append('\'');
    sb.append(", payeeAccountNumber='").append(payeeAccountNumber).append('\'');
    sb.append(", payeeMobileNumber='").append(payeeMobileNumber).append('\'');
    sb.append(", payeeEmailId='").append(payeeEmailId).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
