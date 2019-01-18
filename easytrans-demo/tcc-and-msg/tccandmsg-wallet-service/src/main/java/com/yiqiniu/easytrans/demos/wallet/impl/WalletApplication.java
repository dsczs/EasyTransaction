package com.yiqiniu.easytrans.demos.wallet.impl;

import com.yiqiniu.easytrans.EnableEasyTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEasyTransaction
@EnableTransactionManagement
public class WalletApplication {
    public static void main(String[] args) {
        SpringApplication.run(WalletApplication.class, args);
    }
}
