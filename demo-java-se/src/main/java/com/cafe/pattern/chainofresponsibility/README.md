<h1 align="center">🚀 责任链模式</h1>

### ✨ 目的

* 避免客户端与多个处理者之间的耦合
* 客户端只需要发起一次调用，请求会沿着处理者链依次执行，无需客户端手动管理调用的顺序和链路

---

### 📦 结构

#### Handler（抽象处理者）

* 定义处理者的行为
    * `handle()`：处理逻辑方法
    * `getNextHandler()`：获取下一个处理者方法
    * `setNextHandler()`：设置下一个处理者方法

```
IOrderChecker
AbstractOrderChecker
```

#### Concrete Handler（具体处理者）

* 具体处理者，实现处理逻辑，设置下一个处理者

```
RepeatOrderChecker
UserChecker
GoodsChecker
AddressChecker
```

#### Client（客户端）

* 需要使用 `Handler Chain` 提供的功能的类

```
Client
```

---

### 🏹 实现

* 定义 `Handler` 接口
* `Handler` 接口派生出多个子类，即 `Concrete Handler`
* 每个 `Concrete Handler` 定义不同的处理逻辑，设置下一个 `Concrete Handler`
* `Client` 调用第一个 `Concrete Handler`，即可实现 `Handler Chain` 上所有 `Concrete Handler` 的处理逻辑
