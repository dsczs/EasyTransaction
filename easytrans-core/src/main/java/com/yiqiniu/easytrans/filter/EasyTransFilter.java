package com.yiqiniu.easytrans.filter;

import com.yiqiniu.easytrans.protocol.EasyTransRequest;

import java.util.Map;


public interface EasyTransFilter {

    /**
     * do invoke filter.
     *
     * <code>
     * // before filter
     * Result result = invoker.invoke(invocation);
     * // after filter
     * return result;
     * </code>
     *
     * @param invoker    service
     * @param invocation invocation.
     * @return invoke result.
     */
    EasyTransResult invoke(EasyTransFilterChain filterChain, Map<String, Object> header, EasyTransRequest<?, ?> request);

}
