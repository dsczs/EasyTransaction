package com.yiqiniu.easytrans.test.mockservice.accounting.easytrans;

import com.yiqiniu.easytrans.test.mockservice.accounting.easytrans.AccountingCpsMethod.AccountingRequest;
import com.yiqiniu.easytrans.test.mockservice.accounting.easytrans.AccountingCpsMethod.AccountingResponse;

import java.util.concurrent.Future;

public interface AccountingApi {
    Future<AccountingResponse> accounting(AccountingRequest request);
}
