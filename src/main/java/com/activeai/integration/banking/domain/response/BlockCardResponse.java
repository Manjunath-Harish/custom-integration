package com.activeai.integration.banking.domain.response;

import com.activeai.integration.banking.constants.StatusEnum;
import com.activeai.integration.banking.model.Result;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
public class BlockCardResponse extends Response{

  @JsonProperty("referenceId")
  private String referenceId;

  @JsonProperty("status")
  private StatusEnum status;

  public String getReferenceId() {
    return referenceId;
  }

  public void setReferenceId(String referenceId) {
    this.referenceId = referenceId;
  }

  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("ActivationCardResponse{");
    sb.append("referenceId='").append(referenceId).append('\'');
    sb.append(", status=").append(status);
    sb.append('}');
    return sb.toString();
  }

}
