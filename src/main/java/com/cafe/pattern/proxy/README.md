<h1 align="center">🚀 代理模式</h1>

### ✨ 目的

* 使用代理对象控制其它对象对目标对象的访问
* 客户端通过代理对象实现功能
* 且不需要知道代理对象底层的具体实现

#### 装饰器模式

* 客户端知道装饰器可以对组件进行增强
    * 通常都是由客户端自行创建具体组件，再自行传入具体装饰器
    * 以实现特定的功能增强

#### 代理模式

* 客户端并不知道代理对象底层的具体实现
    * 不需要知道代理对象实际是调用了目标对象来实现功能的
    * 只需要知道调用代理对象可以实现自己所需要的功能即可

---

### 📦 结构

#### Subject（抽象主题）

* 目标对象和代理对象的共同接口

```
IDFeign
```

#### Real Subject（目标对象）

* 需要被代理的对象，负责执行业务逻辑

```
IDController
```

#### Proxy（代理对象）

* 控制其它对象对目标对象的访问

```
IDFeignClient
```

---

### 🏹 实现

* `Real Subject` 和 `Proxy` 实现同一个接口（`Subject`）
* 在 `Proxy` 中调用 `Real Subject` 实现业务逻辑
* 客户端调用 `Proxy` 实现所需要的功能，无需感知 `Proxy` 的底层实现
