package com.rpghelper.citymaker.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NameUtilsTest {

    @Test
    void whenRequestAName_expectedANoEmptyString() {
        String name = NameUtils.genRandomName();
        assertThat(name)
                .isNotBlank()
                .doesNotContain("null");

    }
}