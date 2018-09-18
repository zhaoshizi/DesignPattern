// 登记式/静态内部类
// 是否 Lazy 初始化：是

// 是否多线程安全：是

// 实现难度：一般

// 描述：这种方式能达到双检锁方式一样的功效，但实现更简单。对静态域使用延迟初始化，应使用这种方式而不是
// 双检锁方式。这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。这种方式同样利用
// 了 classloader 机制来保证初始化 instance 时只有一个线程，它跟第 1种方式不同的是：第 1 种方式只要
//  Singleton 类被装载了，那么 instance 就会被实例化（没有达到 lazy loading 效果），而这种方式是 
//  Singleton 类被装载了，instance 不一定被初始化。因为 SingletonHolder 类没有被主动使用，只有通过显
//  式调用 getInstance 方法时，才会显式装载 SingletonHolder 类,从而实例化 instance。想象一下，如果
//  实例化 instance 很消耗资源，所以想让它延迟加载，另外一方面，又不希望在 Singleton 类加载时就实例
//  化，因为不能确保 Singleton 类还可能在其他的地方被主动使用从而被加载，那么这个时候实例化 instance 
//  显然是不合适的。
package singletonpattern;

public class SingletonObject3{
    //让构造函数为 private，这样该类就不会被实例化
    private SingletonObject3(){}
    private static class SingletonObjectHandler{
        public static final SingletonObject3 singletonObject = new SingletonObject3();
    }
    public static final SingletonObject3 getInstance(){
        return SingletonObjectHandler.singletonObject;
    }
    public void show(){
        System.out.println("SingletonObjects3.");
    }
}