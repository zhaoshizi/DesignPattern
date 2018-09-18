// 双检锁/双重校验锁（DCL，即 double-checked locking）
// JDK 版本：JDK1.5 起

// 是否 Lazy 初始化：是

// 是否多线程安全：是

// 实现难度：较复杂

// 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
// getInstance() 的性能对应用程序很关键。
package singletonpattern;

public class SingletonObject2{
    private volatile static SingletonObject2 singletonObject;
    //让构造函数为 private，这样该类就不会被实例化
    private SingletonObject2(){}

    public static SingletonObject2 getInstance(){
        if (singletonObject == null){
            synchronized(SingletonObject2.class){
                if(singletonObject == null){
                    singletonObject = new SingletonObject2();
                }
            }
        }
        return singletonObject;
    }
    public void show(){
        System.out.println("SingletonObjects2.");
    }
}