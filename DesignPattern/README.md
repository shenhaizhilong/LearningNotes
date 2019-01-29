
# Design Pattern
___

## 设计原则

1. 单一职责原则			*一个类只负责一个一个功能领域中的相应职责*
2. 开闭原则				*对扩展开放，对修改关闭*
3. 里氏替换原则			*所有引用基类对象的地方都可以用子类的对象替换，而程序不产生任何错误和异常*
4. 迪米特法则			*一个软件实体应该尽可能少的与其他实体发生作用*
5. 合成复用原则    		*尽可能多的使用对象的组合而不是继承来达到复用*
6. 接口隔离原则			*使用多个接口，而不是单一的总接口*
7. 依赖倒转原则			*依赖抽象而不是依赖于细节-> 即面向接口编程*



## 常见设计模式

<!-- GFM-TOC -->

* 一、创建型
    * 1. [单例](Singleton.md)
    * 2. [工厂方法](FactoryMethod.md)
    * 3. [抽象工厂](AbstractFactory.md)
    * 4. [建造者](Builder.md)
    * 5. [原型模式](Prototype.md)
* 二、行为型
    * 1. [责任链](/RequestLink/PurchaseRequest.java)
    * 2. [迭代器](Iterator.md)
* 三、结构型
    * 1. [适配器](Adapter.md)
    * 2. [装饰](Decorator.md)
    * 3. [享元](FlyWeight.md)
    * 4. [代理](Proxy.md)

<!-- GFM-TOC -->


# 参考资料
- [design-pattern-java](https://legacy.gitbook.com/book/quanke/design-pattern-java/details)
- [Java 并发编程的艺术](http://ifeve.com/the-art-of-java-concurrency-program-1/)
- [Design Patterns](http://www.oodesign.com/)
- [Design patterns implemented in Java](http://java-design-patterns.com/)
- [The breakdown of design patterns in JDK](http://www.programering.com/a/MTNxAzMwATY.html)