# spring-demos

## Description

- This repository is just to demonstrate the collection of spring framework features.
- This **"spring_aop"** branch contains **Logging Aspect, Performance Aspect and Security Aspect.**

### What is Spring AOP?

- AOP stands for Aspect-oriented Programming. Aspect-oriented Programming (AOP) complements Object-oriented Programming (OOP) by providing another way of thinking about program structure. The key unit of modularity in OOP is the class, whereas in AOP the unit of modularity is the aspect.
- A layered approach is typically used to build applications:
  - **Web Layer** - View logic for web apps or JSON conversion for REST API
  - **Business Layer** - Business Logic (service classes)
  - **Data Layer** - Persistence Logic (repository classes)
- Each layer has **different responsibilites**.
  - However, there are a **few common aspects** that apply to all layers
    - **Security**
    - **Performance**
    - **Logging**
- These common aspects are called **Cross Cutting Concerns.**
- **Aspect Oriented Programming** can be used to implement Cross Cutting Concerns.

### How to do it?
1. Implement the cross cutting concern as an aspect
2. Define point cuts to indicate where the aspect should be applied
3. **Two** popular AOP Frameworks
   1. **Spring AOP**
      1. Not a complete AOP solution But very popular
      2. Only works with Spring Beans
      3. Eg. Intercet method calls to Spring Beans
   2. **AspectJ**
      1. Complete AOP solution But rarely used
      2. Eg. Intercept any method call on any Java class
      3. Eg. Intercept change of values in a field.

### AOP Terminology
- **Compile Time**
  - **Advice** - What code to execute? Eg. Logging, Authentication - **WHAT**
  - **Pointcut** - Expression that identifies method calls to be intercepted. Eg. ("execution(* com.demo.snap.*.*.*(..))") - **WHEN**
  - **Aspect** - A combination of:
    - **Advice** - what to do and
    - **Pointcut** - when to intercept a method call
  - **Weaver** - Weaver is the framework that implements AOP
    - **AspectJ or Spring AOP**
- **Runtime**
  - **Join Point** - When pointcut condition is true, the advice is executed. A specific execution instance of an advice is called a Join Point.

### AOP Annotations
- **@Before** - Do something **before** a method is called
- **@After** - Do something **after** a method is executed **irrespective of whether:**
  - Method executes successfully or
  - Method throws an exception
- **@AfterReturning** - Do something **ONLY when a method executes successfully**
- **@AfterThrowing** - Do something **ONLY when a method throws an exception**
- **@Around** - Do something before and after a method execution. Do something **AROUND** a method execution.

### References:
- Aspect Oriented Programming with Spring: https://docs.spring.io/spring-framework/reference/core/aop.html 
- AOP Concepts: https://docs.spring.io/spring-framework/reference/core/aop/introduction-defn.html
- [NEW] Master Spring Boot 3 & Spring Framework 6 with Java (Udemy Course): https://www.udemy.com/course/spring-boot-and-spring-framework-tutorial-for-beginners/