package com.preact.SpringBootSandbox.unittesting.controller;

import com.preact.SpringBootSandbox.unittesting.service.UnitTestService;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@ExtendWith(MockitoExtension.class)
class UnitTestingControllerTest {

    @Mock
    UnitTestService unitTestService;

    @InjectMocks
    private UnitTestingController unitTestingController;



    @Test
    public void helloWorldTestWithJUnitAssertion_Pass(){
        String actualValue = unitTestingController.helloWorld();
        Assertions.assertEquals("Hello World",actualValue);
    }

    @Test
    public void helloWorldTestWithAssertJAssertions_Pass(){
        String actualValue = unitTestingController.helloWorld();
        org.assertj.core.api.Assertions.assertThat(actualValue)
                .isNotEmpty()
                .startsWith("Hello")
                .endsWith("World")
                .isEqualTo("Hello World")
        ;

    }


    @Test
    void getValue2N_JUnitAssertions() {
        Mockito.when(unitTestService.getValue2N(2)).thenReturn(IntStream.range(1,2+1).boxed().collect(Collectors.toList()));
        List<Integer> actualValue = unitTestingController.getValue2N(2);
        Assertions.assertEquals(actualValue.size(),2);
        Assertions.assertEquals(actualValue.get(0),1);
        Assertions.assertEquals(actualValue.get(1),2);
    }

    @Test
    void getValue2N_AssertJ() {
        List<Integer> expectedValues = IntStream.range(1,2+1).boxed().collect(Collectors.toList());
        Mockito.when(unitTestService.getValue2N(2)).thenReturn(expectedValues);
        List<Integer> actualValue = unitTestingController.getValue2N(2);

        org.assertj.core.api.Assertions.assertThat(actualValue)
                .contains(1,2)
                .hasSize(2);
    }

    @Test
    void getValue2N_Hamcrust() {
        List<Integer> expectedValues = IntStream.range(1,3).boxed().collect(Collectors.toList());
        Mockito.when(unitTestService.getValue2N(2)).thenReturn(expectedValues);
        List<Integer> actualValue = unitTestingController.getValue2N(2);

        MatcherAssert.assertThat(actualValue, Matchers.hasSize(2));
        MatcherAssert.assertThat(actualValue, Matchers.contains(1,2));
    }
}