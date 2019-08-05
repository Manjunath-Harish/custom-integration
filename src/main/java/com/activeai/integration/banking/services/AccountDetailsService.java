package com.activeai.integration.banking.services;

import com.activeai.integration.banking.constants.MessageConstants;
import com.activeai.integration.banking.constants.PropertyConstants;
import com.activeai.integration.banking.domain.response.AccountDetailResponse;
import com.activeai.integration.banking.domain.response.DepositAccountDetailResponse;
import com.activeai.integration.banking.domain.response.LoanAccountDetailResponse;
import com.activeai.integration.banking.mapper.response.AccountsResponseMapper;
import com.activeai.integration.banking.utils.ApplicationLogger;
import com.activeai.integration.banking.utils.PropertyUtil;
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

@Service("accountDetailsService")
public class AccountDetailsService {
  @Autowired private AccountsResponseMapper accountsResponseMapper;
  @Autowired private PropertyUtil propertyUtil;
  private static final String error_message_format = "{0} : {1} : {2}";

  /**
   * Fetches CASA Account Details for selected Account
   * @param customerId,accountId
   * @return ResponseEntity of type AccountDetailResponse
   */
  public ResponseEntity<AccountDetailResponse> getCasaAccountDetailsResponseEntity(String customerId, String accountId, String accessToken) {
    AccountDetailResponse response = new AccountDetailResponse();
    try {
      HttpResponse<String>
          apiResponse = Unirest.get(propertyUtil.getAPIUrl(PropertyConstants.CASA_ACCOUNT_DETAILS_API_END_POINT, customerId, accountId))
          .header("cache-control", "no-cache").asString();
      ApplicationLogger.logInfo("API Response status: " + apiResponse.getStatus() + " and response status text :" + apiResponse.getStatusText());
      if (StringUtils.isNotEmpty(apiResponse.getBody())) {
        ApplicationLogger.logInfo("Casa Account Details Response Body Before Transformation :" + apiResponse.getBody());
        response = accountsResponseMapper.getManipulatedCasaAccountDetailsResponse(apiResponse.getBody());
        ApplicationLogger.logInfo("Casa Account Details Response Body After Transformation :" + response);
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

  /**
   * Fetches Deposit Account Details for selected Account
   * @param customerId
   * @param accountId
   * @return ResponseEntity of type DepositAccountDetailResponse
   */
  public ResponseEntity<DepositAccountDetailResponse> getDepositAccountDetailsResponseEntity(String customerId, String accountId, String accessToken) {
    DepositAccountDetailResponse response = new DepositAccountDetailResponse();
    try {
      HttpResponse<String>
          apiResponse = Unirest.get(propertyUtil.getAPIUrl(PropertyConstants.DEPOSIT_ACCOUNT_DETAILS_API_END_POINT, customerId, accountId))
          .header("cache-control", "no-cache").asString();
      ApplicationLogger.logInfo("API Response status: " + apiResponse.getStatus() + " and response status text :" + apiResponse.getStatusText());
      if (StringUtils.isNotEmpty(apiResponse.getBody())) {
        ApplicationLogger.logInfo("Deposit Account Details Response Body Before Transformation :" + apiResponse.getBody());
        response = accountsResponseMapper.getManipulatedDepositAccountDetailsResponse(apiResponse.getBody());
        ApplicationLogger.logInfo("Deposit Account Details Response Body After Transformation :" + response);
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

  /**
   * Fetches Loan Account Details for selected Account
   * @param customerId
   * @param accountId
   * @return ResponseEntity of type LoanAccountDetailResponse
   */
  public ResponseEntity<LoanAccountDetailResponse> getLoanAccountDetailsResponseEntity(String customerId, String accountId, String accessToken) {
    LoanAccountDetailResponse response = new LoanAccountDetailResponse();
    try {
      HttpResponse<String>
          apiResponse = Unirest.get(propertyUtil.getAPIUrl(PropertyConstants.LOAN_ACCOUNT_DETAILS_API_END_POINT, customerId, accountId))
          .header("cache-control", "no-cache").asString();
      ApplicationLogger.logInfo("API Response status: " + apiResponse.getStatus() + " and response status text :" + apiResponse.getStatusText());
      if (StringUtils.isNotEmpty(apiResponse.getBody())) {
        ApplicationLogger.logInfo("Loan Account Details Response Body Before Transformation :" + apiResponse.getBody());
        response = accountsResponseMapper.getManipulatedLoanAccountDetailsResponse(apiResponse.getBody());
        ApplicationLogger.logInfo("Loan Account Details Response Body After Transformation :" + response);
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
