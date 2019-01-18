package com.yiqiniu.easytrans.test.mockservice.accounting.easytrans;

import com.yiqiniu.easytrans.protocol.BusinessIdentifer;
import com.yiqiniu.easytrans.protocol.cps.CompensableMethod;
import com.yiqiniu.easytrans.protocol.cps.CompensableMethodRequest;
import com.yiqiniu.easytrans.test.Constant;
import com.yiqiniu.easytrans.test.mockservice.accounting.AccountingService;
import com.yiqiniu.easytrans.test.mockservice.accounting.easytrans.AccountingCpsMethod.AccountingRequestCfg;
import com.yiqiniu.easytrans.test.mockservice.accounting.easytrans.AccountingCpsMethod.AccountingResponse;
import com.yiqiniu.easytrans.test.mockservice.order.OrderService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;

@Component
public class AccountingCpsMethod implements CompensableMethod<AccountingRequestCfg, AccountingResponse> {


    public static final String METHOD_NAME = "accounting";
    @Resource
    private AccountingService service;

    @Override
    public AccountingResponse doCompensableBusiness(AccountingRequestCfg param) {
        return service.accounting(param);
    }

    @Override
    public void compensation(AccountingRequestCfg param) {
        OrderService.checkThrowException(OrderService.EXCEPTION_TAG_IN_MIDDLE_OF_CONSISTENT_GUARDIAN_WITH_ROLLEDBACK_MASTER_TRANS);
        service.reverseEntry(param);
    }

    @Override
    public int getIdempotentType() {
        return IDENPOTENT_TYPE_FRAMEWORK;
    }

    public static class AccountingRequest implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        private Integer userId;

        private Long amount;

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Long getAmount() {
            return amount;
        }

        public void setAmount(Long amount) {
            this.amount = amount;
        }
    }

    @BusinessIdentifer(appId = Constant.APPID, busCode = METHOD_NAME)
    public static class AccountingRequestCfg extends AccountingRequest implements CompensableMethodRequest<AccountingResponse> {
        private static final long serialVersionUID = 1L;

        @Override
        public String toString() {
            return "AccountingRequestCfg [getUserId()=" + getUserId() + ", getAmount()=" + getAmount() + "]";
        }

    }

    public static class AccountingResponse implements Serializable {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        private boolean success = true;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

    }


}
