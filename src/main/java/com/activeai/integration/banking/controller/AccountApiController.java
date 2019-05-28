package com.activeai.integration.banking.controller;

import com.activeai.integration.banking.domain.response.*;
import com.activeai.integration.banking.services.AccountsService;
import com.activeai.integration.banking.utils.ApplicationLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Accounts Related APIs", description = "Shows API Documentation Regards Accounts APIs")
@RestController
public class AccountApiController {

  @Autowired private AccountsService accountsService;
  @Autowired private ObjectMapper objectMapper;
  @ApiOperation(value = "Returns selected account balance")
  @RequestMapping(value = "/{customerId}/accounts/{accountId}/balance", produces = {"application/json"}, method = RequestMethod.GET)
  public ResponseEntity<AccountBalanceResponse> getAccountBalance(@PathVariable(name = "customerId", required = true) String customerId,
      @PathVariable(name = "accountId", required = true) String accountId) {
    ApplicationLogger.logInfo("Entering getAccountBalance API");
    return accountsService.getAccountBalanceResponseEntity(customerId, accountId);
  }

  @ApiOperation(value = "Returns selected account details")
  @RequestMapping(value = "/{customerId}/accounts/{accountId}", produces = {"application/json"}, method = RequestMethod.GET)
  public ResponseEntity<AccountDetailResponse> getAccountDetail(@PathVariable(name = "customerId", required = true) String customerId,
      @PathVariable(name = "accountId", required = true) String accountId) {
    ApplicationLogger.logInfo("Entering getAccountDetails API");
    return accountsService.getAccountDetailsResponseEntity(customerId, accountId);
  }

  @ApiOperation(value = "Returns selected account transaction history")
  @RequestMapping(value = "/{customerId}/accounts/{accountId}/transactions", produces = {"application/json"}, method = RequestMethod.GET)
  public ResponseEntity<AccountTransactionsResponse> getAccountTransactions(
      @PathVariable(name = "customerId", required = true) String customerId,
      @PathVariable(name = "accountId", required = true) String accountId) {
    ApplicationLogger.logInfo("Entering getAccountTransactions API");
    return accountsService.getAccountTransactionsResponseEntity(customerId, accountId);
  }

  /**
   *
   * @param customerId
   * @return
   */
  @ApiOperation(value = "Returns list of accounts based on customer ID")
  @RequestMapping(value = "/{customerId}/accounts/ACCOUNT", produces = {"application/json"}, method = RequestMethod.GET)
  public ResponseEntity<AccountsResponse> getCasaAccounts(@PathVariable(name = "customerId", required = true) String customerId) {
    ApplicationLogger.logInfo("Entering getCasaAccountsResponseEntity API");
    return accountsService.getCasaAccountsResponseEntity(customerId);
  }
  @ApiOperation(value = "Returns list of accounts based on customer ID")
  @RequestMapping(value = "/{customerId}/accounts/DEPOSIT", produces = {"application/json"}, method = RequestMethod.GET)
  public ResponseEntity<DepositAccountsResponse> getDepositAccounts(@PathVariable(name = "customerId", required = true) String customerId) {
    ApplicationLogger.logInfo("Entering getDepositAccountsResponseEntity API");
    return accountsService.getDepositAccountsResponseEntity(customerId);
  }

}
