## 观察者模式

观察者模式原理也很简单，就是你在做事的时候旁边总有一个人在盯着你，当你做的事情是它感兴趣的时候，它就会跟着做另外一些事情。但是盯着你的人必须要到你那去登记，不然你无法通知它。观察者模式通常包含下面这几个角色：

- Subject 就是抽象主题：它负责管理所有观察者的引用，同时定义主要的事件操作。
- ConcreteSubject 具体主题：它实现了抽象主题的所有定义的接口，当自己发生变化时，会通知所有观察者。
- Observer 观察者：监听主题发生变化相应的操作接口。

### 观察者模式示例

参考 tomcat Lifecycle 实现设计，加入两个扩展类：LifecycleSupport、LifecycleEvent

* 定义扩展类 LifecycleEvent，用于定义事件类别，不同的事件可区别处理，更加灵活

  ```java
  package com.heyh.valid.designpattern.observer.util;
  
  import java.io.Serializable;
  
  /**
   * 辅助类扩展了观察者的功能
   */
  public class LifecycleEvent implements Serializable {
  
      private Object data;
      private String type;
  
      public LifecycleEvent(Object data, String type) {
          this.data = data;
          this.type = type;
      }
  
      public Object getData() {
          return data;
      }
  
      public String getType() {
          return type;
      }
  }
  ```

* 定义扩展类 LifecycleSupport，代理了主题对多观察者的管理，将这个管理抽出来统一实现，以后如果修改只要修改 LifecycleSupport 类就可以了，不需要去修改所有具体主题，因为所有具体主题的对观察者的操作都被代理给 LifecycleSupport 类了，这可以认为是观察者模式的改进版。

  ```java
  package com.heyh.valid.designpattern.observer.util;
  
  import com.heyh.valid.designpattern.observer.listener.LifecycleListener;
  
  import java.util.ArrayList;
  import java.util.List;
  
  public class LifecycleSupport {
  
      List<LifecycleListener> list = new ArrayList();
  
      public void addListener(LifecycleListener listener) {
          list.add(listener);
      }
  
      public void fireLifecycleEvent(String type, Object data) {
          LifecycleEvent event = new LifecycleEvent(data, type);
          for (LifecycleListener listener: list) {
              listener.lifecycleEvent(event);
          }
      }
  }
  ```

* 定义抽象观察者，

  ```java
  package com.heyh.valid.designpattern.observer.listener;
  
  import com.heyh.valid.designpattern.observer.util.LifecycleEvent;
  
  /**
   * 抽象观察者
   * 定义一个 lifecycleEvent 方法，这个方法就是当主题变化时要执行的方法
   */
  public interface LifecycleListener {
      public void lifecycleEvent(LifecycleEvent event);
  }
  ```

* 定义两个观察者具体实现，

  ```java
  /**
   * 具体的观察者
   * 实现了 LifecycleListener 接口的方法，就是这个具体的观察者具体的实现方式
   */
  public class LogLifecycleListener implements LifecycleListener {
      @Override
      public void lifecycleEvent(LifecycleEvent event) {
          if (event.getType().equals("log")) {
              System.out.println("这里是观察者 LogLifecycleListener...");
          }
      }
  }
  
  public class ServerLifecycleListener implements LifecycleListener {
      @Override
      public void lifecycleEvent(LifecycleEvent event) {
          if (event.getType().equals("server")) {
              System.out.println("这里是观察者 ServerLifecycleListener...");
          }
      }
  }
  ```

* 定义抽象主题

  ```java
  package com.heyh.valid.designpattern.observer.lifecycle;
  
  /**
   * 抽象主题
   * 定义了管理观察者的方法和它要所做的其它方法
   */
  public interface Lifecycle {
      public void start();
  	  public void stop();
  }
  ```

* 定义具体主题

  ```java
  package com.heyh.valid.designpattern.observer.lifecycle.impl;
  
  import com.heyh.valid.designpattern.observer.listener.LifecycleListener;
  import com.heyh.valid.designpattern.observer.listener.impl.LogLifecycleListener;
  import com.heyh.valid.designpattern.observer.lifecycle.Lifecycle;
  import com.heyh.valid.designpattern.observer.util.LifecycleEvent;
  
  import java.util.ArrayList;
  import java.util.List;
  
  /**
   * 具体主题
   * 实现了抽象主题的所有方法
   */
  public class StandarServer implements Lifecycle {
  
      private List<LifecycleListener> lifecycleListeners = new ArrayList<>();
  
      public void addLifecycleListeners(LifecycleListener lifecycleListener) {
          lifecycleListeners.add(lifecycleListener);
      }
  
      @Override
      public void start() {
          LifecycleListener listener = new LogLifecycleListener();
          this.addLifecycleListeners(listener);
          System.out.println("start!");
          this.fireLifecycleEvent("log", null);
      }
    
  	  @Override
      public void stop() {
          LifecycleListener listener = new ServerLifecycleListener();
          this.support.addListener(listener);
          this.support.fireLifecycleEvent("server", null);
          System.out.println("stop...");
      }
  
      public void fireLifecycleEvent(String type, Object data) {
          LifecycleEvent event = new LifecycleEvent(data, type);
          for (LifecycleListener LifecycleListener: lifecycleListeners) {
              LifecycleListener.lifecycleEvent(event);
          }
      }
  
  }
  ```

* 分别测试两种扩展类实现，

  ```java
  package com.heyh.valid.designpattern.observer;
  
  import com.heyh.valid.designpattern.observer.lifecycle.Lifecycle;
  import com.heyh.valid.designpattern.observer.lifecycle.impl.StandarServer;
  
  public class Observer {
      public static void main(String[] args) {
          Lifecycle lifecycle = new StandarServer();
  
          lifecycle.start();
          lifecycle.stop();
      }
  }
  ```

  <img src="观察者模式.assets/image-20191205192032059.png" alt="image-20191205192032059" style="zoom:50%;" />

 