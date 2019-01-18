package com.yiqiniu.easytrans.idempotent;

import com.yiqiniu.easytrans.filter.EasyTransFilterChain;
import com.yiqiniu.easytrans.protocol.EasyTransRequest;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Map;

public class DefaultIdempotentTransactionDefinition implements IdempotentTransactionDefinition {

    @Override
    public TransactionDefinition getTransactionDefinition(EasyTransFilterChain filterChain, Map<String, Object> header,
                                                          EasyTransRequest<?, ?> request) {
        return new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
    }

}
