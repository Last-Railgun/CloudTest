package com.test.cloud;

import com.test.cloud.common.Generator;

public class Main {
    public static void main(String[] args) {
        Generator.generator("seata_account");
        System.out.println("生成完毕...");
    }
}