package com.activeai.integration.banking.services;

import com.activeai.integration.banking.constants.MessageConstants;
import com.activeai.integration.banking.constants.PropertyConstants;
import com.activeai.integration.banking.domain.request.FundTransferRequest;
import com.activeai.integration.banking.domain.request.PayeesRequest;
import com.activeai.integration.banking.domain.response.FundTransferResponse;
import com.activeai.integration.banking.domain.response.PayeesResponse;
import com.activeai.integration.banking.mapper.response.FundTransferResponseMapper;
import com.activeai.integration.banking.utils.ApplicationLogger;
import com.activeai.integration.banking.utils.PropertyUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Objects;

@Service("transferService")
public class TransferService {

  @Autowired private FundTransferResponseMapper fundTransferResponseMapper;
  @Autowired private PropertyUtil propertyUtil;
  private static final String error_message_format = "{0} : {1} : {2}";

  public ResponseEntity<PayeesResponse> getPayeesResponseEntity(PayeesRequest payeeRequest) {
    PayeesResponse response = new PayeesResponse();
    try {
      /**
       * Here only for first account fetching payees
       * But you need to fetch all payees for each accounts where user added as beneficiary
       */
      HttpResponse<String> apiResponse =
          Unirest.get(propertyUtil.getAPIUrlForPayees(PropertyConstants.PAYEES_API_END_POINT, payeeRequest))
              .header("cache-control", "no-cache").asString();
      ApplicationLogger.logInfo("API Response status: " + apiResponse.getStatus() + " and response status text :" + apiResponse.getStatusText());
      if (StringUtils.isNotEmpty(apiResponse.getBody())) {
        ApplicationLogger.logInfo("Payees Response Body Before Transformation :" + apiResponse.getBody());
        response = fundTransferResponseMapper.getManipulatedPayeesResponse(apiResponse.getBody());
        ApplicationLogger.logInfo("Payees Response Body After Transformation :" + apiResponse.getBody());
      }
      return ResponseEntity.ok(response);
    } catch (UnirestException e) {
      ApplicationLogger.logError(MessageFormat
          .format(error_message_format, MessageConstants.API_FAILURE_MESSAGE, this.getClass().getName(), ExceptionUtils.getStackTrace(e)));
    } catch (IOException e) {
      ApplicationLogger.logError(MessageFormat
          .format(error_message_format, MessageConstants.DE_SERIALIZATION_EXCEPTION_MESSAGE, this.getClass().getName(),
              ExceptionUtils.getStackTrace(e)));
    } catch (Exception e) {
      ApplicationLogger.logError(MessageFormat
          .format(error_message_format, MessageConstants.EXCEPTION_MESSAGE, this.getClass().getName(), ExceptionUtils.getStackTrace(e)));
    }
    response.setResult(propertyUtil.frameErrorResponse(MessageConstants.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", 500));
    return ResponseEntity.ok(response);
  }

  public ResponseEntity<FundTransferResponse> getConfirmTransferResponseEntity(FundTransferRequest fundTransferRequest) {
    FundTransferResponse response = new FundTransferResponse();
    try {
      HttpResponse<String> apiResponse =
          Unirest.get(propertyUtil.getAPIUrlForFundTransfer(PropertyConstants.TRANSFER_CONFIRM_API_END_POINT, fundTransferRequest))
              .header("cache-control", "no-cache").asString();
      ApplicationLogger.logInfo("API Response status: " + apiResponse.getStatus() + " and response status text :" + apiResponse.getStatusText());
      if (Objects.nonNull(apiResponse) && StringUtils.isNotEmpty(apiResponse.getBody())) {
        ApplicationLogger.logInfo("Confirm Transfer Response Body Before Transformation :" + apiResponse.getBody());
        response = fundTransferResponseMapper.getManipulatedFundTransferResponse(apiResponse.getBody());
        ApplicationLogger.logInfo("Confirm Transfer Response Body After Transformation :" + response);
      }
      return ResponseEntity.ok(response);
    } catch (UnirestException e) {
      ApplicationLogger.logError(MessageFormat
          .format(error_message_format, MessageConstants.API_FAILURE_MESSAGE, this.getClass().getName(), ExceptionUtils.getStackTrace(e)));
    } catch (IOException e) {
      ApplicationLogger.logError(MessageFormat
          .format(error_message_format, MessageConstants.DE_SERIALIZATION_EXCEPTION_MESSAGE, this.getClass().getName(),
              ExceptionUtils.getStackTrace(e)));
    } catch (Exception e) {
      ApplicationLogger.logError(MessageFormat
          .format(error_message_format, MessageConstants.EXCEPTION_MESSAGE, this.getClass().getName(), ExceptionUtils.getStackTrace(e)));
    }
    response.setResult(propertyUtil.frameErrorResponse(MessageConstants.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", 500));
    return ResponseEntity.ok(response);
  }
}
