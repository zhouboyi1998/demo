<h1 align="center">🚀 策略模式</h1>

### ✨ 目的

* 当实现某一功能存在多种实现策略时
* 定义多种实现策略，将其封装起来
* 在运行时，可以根据条件，选择不同的策略来实现该功能

---

### 📦 结构

#### Strategy（抽象策略）

* 定义需要实现的功能

```
PayService
```

#### Concrete Strategy（具体策略）

* 实现功能的不同策略

```
AliPayServiceImpl
WeChatPayServiceImpl
BandCardPayServiceImpl
```

#### Context（上下文）

* 持有所有策略的上下文
* 调用方需要通过上下文来获取具体策略

```
PayContext
```

---

### 🏹 实现

* 在上下文中，使用 `Map` 存储所有的具体策略
    * `Key`：策略名称
    * `Value`：是具体策略对象
* 调用方通过策略名称，从 `Map` 中获取具体策略对象
