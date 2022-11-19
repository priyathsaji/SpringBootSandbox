package com.preact.SpringBootSandbox.unittesting.service;

import com.preact.SpringBootSandbox.unittesting.modal.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;


import java.util.List;
import java.util.Objects;


@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@ActiveProfiles("test")
class UnitTestServiceTestWithSpringContext {

    @Autowired
    UnitTestService unitTestService;

    @Test
    public void test(){
        List<Item> items = unitTestService.getItemsFromDb();
        Assertions.assertThat(items)
                .hasSize(3)
                .allMatch(item-> Objects.nonNull(item.getId()))
        ;
    }

}