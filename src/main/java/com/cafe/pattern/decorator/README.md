<h1 align="center">🚀 装饰器模式</h1>

### ✨ 目的

* 在不修改目标对象代码的情况下，对其进行功能增强
* 目标对象可以专注于自己的业务，与增强解耦


* 装饰器模式和代理模式的区别
    * 装饰器模式：功能增强
    * 代理模式：访问控制

---

### 📦 结构

#### Component（抽象组件）

* 具体组件和装饰器的共同接口

```
CaptchaGenerator
```

#### Concrete Component（具体组件）

* 需要被增强的对象，负责执行业务逻辑

```
ColorfulCaptchaGenerator
GrayCaptchaGenerator
```

#### Decorator（抽象装饰器）

* 具体装饰器的共同接口，定义装饰器的通用行为

```
CaptchaGeneratorDecorator
```

#### Concrete Decorator（具体装饰器）

* 负责实现业务逻辑之外的增强逻辑

```
CaptchaGeneratorRedisDecorator
CaptchaGeneratorDatabaseDecorator
```

---

### 🏹 实现

* `Concrete Component` 和 `Decorator` 实现同一个接口（`Component`）
* `Decorator` 再派生出多个子类，即 `Concrete Decorator`
* 在 `Concrete Decorator` 中实现功能增强
* 客户端从原来的调用 `Concrete Component` 中的方法
* 修改为调用 `Concrete Decorator` 中的方法，从而实现带有增强的业务功能
