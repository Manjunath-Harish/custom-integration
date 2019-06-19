
package com.activeai.integration.banking.apiservice.domain.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.activeai.integration.banking.apiservice.model.AccountGroupSummary;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accountGroupSummary"
})
public class CitiAccountResponse {

    @JsonProperty("accountGroupSummary")
    private List<AccountGroupSummary> accountGroupSummary = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("accountGroupSummary")
    public List<AccountGroupSummary> getAccountGroupSummary() {
        return accountGroupSummary;
    }

    @JsonProperty("accountGroupSummary")
    public void setAccountGroupSummary(List<AccountGroupSummary> accountGroupSummary) {
        this.accountGroupSummary = accountGroupSummary;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
