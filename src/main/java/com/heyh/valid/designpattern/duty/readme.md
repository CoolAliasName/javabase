# 责任链模式

* 基础责任链模式
* tomcat 中责任链模式的实现



## 基础责任链

### 基础概念

- ***定义***：使多个对象都有机会处理请求，从而 ***避免了请求的发送者和接受者之间的耦合关系***。将这些对象连成一条***链***，并沿着这条链传递该请求，知道有对象处理它为止。
- ***COR(责任链)模式的角色分工***
  * ***Handler***：抽象处理者，定义一个处理请求的接口。
  * ***Concrete Handler***： 具体处理者，处理请求的具体类，或者传给 ”下家”。
  * ***Requester***：发出请求等待处理的类，它无需关注到底是哪个具体的 Handler 处理它的请求。 
- ***OR的处理问题的场景***
  * 一个 request 在多个 handler 中选择合适的进行处理
  * 传统的通过 ***switch*** 或者 ***if-else*** 进行判断，然后执行
    * 职责界定不清晰，不满足单一职责准则。
    * 代码臃肿，***可读性差***。
    * 耦合过重，Request 调用***具体实现***，不便于 Handler 地拓展，丧失了***面向接口编程的在实现层面低耦合的优点***。
    * 没有对***选择逻辑***进行***封装***，具体实现被暴露，容易出现异常。
  * COR(责任链)模式，则是提供了***抽象Handler接口***
    * 每个具体的 Handler 的实现不与 Requester 耦合，只需要定义自己的***处理级别***，然后对于一个请求要么承担责任，进行***处理***，要么把请求 ***转发*** 到后续环节。
    * Requester也***无需知道具体为我提供服务的Handler的情况***，只需提交请求即可。
- ***COR(责任链)模式的优缺点***：
  * ***优点***：
    * 父类实现了请求传递的功能，子类实现请求的处理，符合***单一职责原则***，各个类实现一个动作或逻辑，也就是只有一个原因引起类的变化，子类的***实现非常简单***，责任链的建立也是非常***灵活***。
    * 责任链模式***屏蔽了请求的处理过程***，你发起的一个请求到底是谁处理的，这个你不用关心，只要把请求抛给责任链，就会得到结果，无需关心具体由谁处理，这时责任链的核心。
  * ***缺点***：
    * 主要的是***性能问题***，责任链较长时，性能会下降得很快
    * 不方便调试

### 实现

* 创建请求类。发出请求等待处理的类，它无需关注到底是哪个具体的Handler处理它的请求。

  ```java
  package com.heyh.valid.designpattern.duty.cor.requester;
  
  /**
   * 发出请求等待处理的类，它无需关注到底是哪个具体的Handler处理它的请求
   */
  public class ErrorRequester {
  
      //标记请求的类型
      private String duty;
  
      public String getDuty() {
          return duty;
      }
  
      public void setDuty(String duty) {
          this.duty = duty;
      }
  }
  ```

* 创建抽象处理者，定义一个处理请求的接口，实现了责任传递的逻辑。

  ```java
  package com.heyh.valid.designpattern.duty.cor.handle;
  
  import com.heyh.valid.designpattern.duty.cor.requester.ErrorRequester;
  
  /**
   * 抽象处理者，定义一个处理请求的接口
   */
  public abstract class Handler {
  
      // 记录当前责任链的下一个环节
      private Handler nextHandler;
      // 标记当前子类的类型
      private String duty;
      public static final String DBA = "SQL and the database";
      public static final String FRONT = "HTML and CSS";
      public static final String BGD = "Java and XML";
  
      // 方便子类设置自己的类型（子类通过无参数的构造器隐藏该实现）
      public Handler(String duty) {
          this.duty = duty;
      }
  
      // 责任链的指责传递逻辑的实现，不支持子类的覆盖
      public final void handlerMessage(ErrorRequester requester) {
          if (requester.getDuty().equals(duty)) {
              response(requester);
          } else {
              if (nextHandler != null) {
                  nextHandler.handlerMessage(requester);
              } else {
                  System.out.println("The Error is due to others!!!");
              }
          }
      }
  
      // 找到合适的类型时，回应请求的函数
      protected  abstract void response(ErrorRequester requester);
  
      public void setNextHandler(Handler nextHandler) {
          this.nextHandler = nextHandler;
      }
  
  }
  ```

* 创建三个具体处理类，内部实现很简单，每个环节类单独处理自己的逻辑。

  ```java
  public class DBAHandler extends Handler {
      // 设置当前子类的处理器类型
      public DBAHandler() {
          super(Handler.DBA);
      }
  
      @Override
      protected void response(ErrorRequester requester) {
          System.out.println( "What horrible "+ requester.getDuty() + " is!!!!");
      }
  }
  
  public class BGDHandler extends Handler {
      //设置当前子类的处理器类型
      public BGDHandler() {
          super(Handler.BGD);
      }
  
      //如果当前类型匹配上，那么进行响应
      @Override
      protected void response(ErrorRequester requester) {
          System.out.println("What horrible " + requester.getDuty() + " is!!!");
      }
  }
  
  public class FRONTHandler extends Handler {
      //设置当前子类的处理器类型
      public FRONTHandler() {
          super(Handler.FRONT);
      }
  
      //如果当前类型匹配上，那么进行响应
      @Override
      protected void response(ErrorRequester requester) {
  				System.out.println("What horrible " + requester.getDuty() + " is!!!");
      }
  }
  ```

* 测试类，将 `SQL and the database` 作为责任链的第一环，随机产生

  ```java
  package com.heyh.valid.designpattern.duty.cor;
  
  import com.heyh.valid.designpattern.duty.cor.handle.Handler;
  import com.heyh.valid.designpattern.duty.cor.handle.impl.BGDHandler;
  import com.heyh.valid.designpattern.duty.cor.handle.impl.DBAHandler;
  import com.heyh.valid.designpattern.duty.cor.handle.impl.FRONTHandler;
  import com.heyh.valid.designpattern.duty.cor.requester.ErrorRequester;
  
  import java.util.HashMap;
  import java.util.Map;
  
  public class CORTest {
      public static void main(String[] args) {
          // 构造词典
          Map<Integer, String> map = new HashMap<>();
          map.put(0, Handler.DBA);
          map.put(1, Handler.BGD);
          map.put(2, Handler.FRONT);
          int times = 0;
  
          // 建立责任链
          Handler dba = new DBAHandler();
          Handler bgd = new BGDHandler();
          Handler front = new FRONTHandler();
          dba.setNextHandler(bgd);
          bgd.setNextHandler(front);
  
          // 生成随机的请求，并且响应
          while (times++ != 10) {
              ErrorRequester requester = new ErrorRequester();
              requester.setDuty(map.get((int)(Math.random()*100)%3) );
              dba.handlerMessage(requester);
          }
      }
  }
  ```

  测试结果：

  <img src="责任链模式.assets/image-20191205214945331.png" alt="image-20191205214945331" style="zoom:50%;" />

