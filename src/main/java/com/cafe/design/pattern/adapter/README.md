<h1 align="center">🚀 适配器模式</h1>

### ✨ 目的

* 通过一个适配器在中间作为桥梁
* 使得两个互不兼容的类可以在一起工作

---

### 📦 结构

#### Adaptee（适配者）

* 需要先被适配，再提供给 `Client` 使用的类

```
AdviceSender
SMSSender
MailSender
```

#### Adapter（适配器）

* 对 `Adaptee` 做适配，使得其可以被 `Client` 使用

###### Class Adapter

```
AdviceClassAdapter
SMSClassAdapter
MailClassAdapter
```

###### Object Adapter

```
AdviceObjectAdapter
SMSObjectAdapter
MailObjectAdapter
```

#### Target（目标接口）

* `Client` 发起业务调用时，所使用的接口、抽象类

```
MessageHandler
```

#### Client（客户端）

* 需要使用 `Adaptee` 提供的功能的类

```
Client
```

---

### 🏹 实现

#### 类适配器

* 适配器模式通常使用多继承来实现
* `Adapter` 同时继承 `Adaptee` 和 `Target`
* 在 `Java` 中，可以通过继承 `Adaptee`，实现 `Target` 的方式达成
* 这种实现方式被称为 **类适配器**

#### 对象适配器

* 除了上述的 **类适配器** 的方式，还可以使用 **对象适配器** 的方式来实现
* `Adapter` 不再继承 `Adaptee`，而是将一个 `Adaptee` 对象注入进来
* 通过 `Adaptee` 对象来调用其内部的方法
