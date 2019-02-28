# Junit5
___


##1、 回顾

### 1.1 什么是JUnit5
与之前的版本不同，JUnit5 由三个不同的子模块组合而成。

## JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage ##

JUnit Platform : 作为在JVM 上启动测试框架的基础。它还定义了 TestEngine API，用于 开发在平台上运行的测试框架。该平台提供了一个控制台启动器，用于从命令行启动平台，以及一个基于JUnit 4的运行器，用于在基于JUnit 4的环境中运行平台上的任何TestEngine。
JUnit Jupiter： 是用于在JUnit5中编写测试和扩展的新编程模型和扩展模型的组合。Jupiter子项目为在平台上运行基于Jupiter的测试提供了一个测试引擎。
JUnit Vintage: 提供一个用于在平台上运行基于JUnit 3和JUnit 4的测试引擎。
### 1.2 支持的Java版本
Java 8 或者更高。然而，你也可以测试以前版本的JDK
### 1.3 开始
[github link](https://github.com/junit-team/junit5-samples)
## 2、 编写测试
第一个测试用例：
```
	public static void assertEquals(int expected, int actual, String message) {
		AssertEquals.assertEquals(expected, actual, message);
	}
```

```
package com.example.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class FirstDemo {
    private final Calculator calculator = new Calculator();
    @Test
    void addTest()
    {
        assertEquals(3,calculator.add(1,1),"1 + 1 should be equal 2");
    }
}

output:
org.opentest4j.AssertionFailedError: 1 + 1 should be equal 2 ==> 
Expected :3
Actual   :2


```
### 2.1 注解 Annotations
姓名|技能|排行
--|:--:|--:
### 2.2 测试类与方法 Test Classes and Methods
### 2.3 显示名称 Display Names
### 2.4 断言 Assertions
### 2.5 假设 Assumptions 
### 2.6 禁用测试 Disabling Tests
### 2.7 条件测试执行 Conditional Test Execution
### 2.8 标记和过滤 Tagging and Filtering
### 2.9 测试执行顺序 Test Execution Order
### 2.10 测试实例生命周期 Test Instance Lifecycle
### 2.11 嵌套测试 Nested Tests
### 2.12 构造器与方法的依赖注入 Dependency Injection for Constructors and Methods
### 2.13 测试接口与默认方法 Test Interfaces and Default Methods
### 2.14 重复测试 Repeated Tests
### 2.15 参数化测试 Parameterized Tests
### 2.16 测试模板 Test Templates
### 2.17 动态测试 Dynamic Tests
### 2.18 并行执行 Parallel Execution
### 2.19 内置扩展 Built-in Extensions