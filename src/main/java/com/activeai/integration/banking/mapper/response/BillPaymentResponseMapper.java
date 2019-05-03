package com.activeai.integration.banking.mapper.response;

import org.springframework.stereotype.Component;

@Component("billpaymentResponseMapper")
public class BillPaymentResponseMapper {

    /**
     * In this method you can change the obtained string accordingly to the RegisteredBillerResponse
     * @param apiResponseBody
     * @return String of RegistereBillerResponse
     */
    public static String getManipulatedRegisteredBillerResponse(String apiResponseBody) {
        return apiResponseBody;
    }
}
