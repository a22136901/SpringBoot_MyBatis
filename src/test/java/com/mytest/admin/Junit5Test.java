package com.mytest.admin;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Junit5功能测试")
@SpringBootTest     //这个标签使用了SpringBoot的容器驱动，这样才能自动注入等操作。
public class Junit5Test {

    /**
     * 参数化测试，xxxSource
     */
    @ParameterizedTest
    @DisplayName("参数化测试")
    @ValueSource(ints = {1,2,3,4,5})
    void testParameterizedTest(int i){
        System.out.println(i);
    }
    @ParameterizedTest
    @DisplayName("参数化测试")
    @MethodSource("stringProvider")
    void testParameterizedTest2(String i){
        System.out.println(i);
    }
    static Stream<String> stringProvider(){
        return Stream.of("a","b","c");
    }

    /**
     * 测试前置条件，前置条件失败则跳过测试
     */
    @DisplayName("测试前置条件")
    @Test
    void testAssumptions(){
        Assumptions.assumeTrue(true,"结果不是true");//这里成功了，不跳过测试。
        System.out.println("111");
    }

    /**
     * 断言：前面断言失败，失败后面的代码不会执行。
     */
    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions(){
        int sum = add(2, 3);
        // 判定相等。
        assertEquals(5,sum,"业务逻辑计算失败");
        // 判定数组相等。
        assertArrayEquals(new int[]{1,2},new int[]{1,2},"数组内容不相等");

        // 判断是不是同一个对象。
        Object o1 = new Object();
        Object o2 = new Object();
        assertNotSame(o1,o2,"两个对象一样");

        // 组合断言，所有断言成功才能继续
        assertAll("test",
                () -> assertTrue(true && true,"结果不为true"),
                () -> assertEquals(1,1,"结果不是1"));

        // 异常断言，断定业务逻辑一定出异常
        assertThrows(ArithmeticException.class,() -> {
            int i = 10/0;
        },"业务逻辑居然正常运行？");

        // 还有超时断言，Timeout

        // 快速失败
//        fail("测试失败了");
    }
    int add(int x,int y){
        return x+y;
    }

    /**
     * 运行之后左下角展示名称变了，并且执行了测试
     */
    @DisplayName("DisplayName注解测试")
    @Test
    void testDisplayName(){
        System.out.println(1);
    }

    @Disabled       //禁用测试方法
    @DisplayName("DisplayName注解测试二")
    @Test
    void testDisplayName2(){
        System.out.println(2);
    }

    /**
     * 重复测试，给重复测试的次数
     */
    @RepeatedTest(5)
    @Test
    void testRepeatedTest(){
        System.out.println("重复测试中");
    }

    /**
     * 测试超时，规定方法的测试时间和单位，超时抛出异常
     */
    @Timeout(value = 500,unit = TimeUnit.MICROSECONDS)
    @Test
    void testTimeout(){

    }


    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试就要开始了....");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束了....");
    }

    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有测试就要开始了......");
    }

    @AfterAll
    static void testAfterAll(){
        System.out.println("所有测试结束了......");
    }

}
