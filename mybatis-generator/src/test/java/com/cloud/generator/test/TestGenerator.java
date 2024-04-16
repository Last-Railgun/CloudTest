package com.cloud.generator.test;

import com.test.cloud.common.Generator;
import org.junit.jupiter.api.Test;

public class TestGenerator {
    @Test
    public void test01() {
        Generator.generator("seata_account");
        System.out.println("生成完毕...");
    }
}
