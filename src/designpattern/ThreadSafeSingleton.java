package designpattern;

/* 饿汉模式：声明变量时直接初始化，也就是对象还没被试图使用之前就已经初始化了，浪费内存但是无线程安全的问题
 * private static EagerSingleton singObj = new EagerSingleton();
 * 
 * 懒汉模式：即延迟加载，声明变量时不初始化，只有被试图使用时对象才会进行初始化
 * private static LazySingleton singObj = null;
 * public static LazySingleton getSingleInstance(){
 * 		if (singObj == null)  
 *   		{  
 *       		singObj = new LazySingleton();  
 *   		}  
 * 		return singObj;
 * }
 * 
 * 但是会导致多线程环境下重复初始化的问题，因为有可能多个线程同时通过if语句进入初始化模块。解决方式：
 * 1.整个getSingleInstance方法使用synchronized 修饰
 * 引入性能问题，若实例已存在，所有线程可直接获得，不会再初始化实例，此时是没有线程安全的问题的
 * 但是synchronized会使得同一时间仍然只有一个线程可获取实例，造成性能下降
 * 
 * 2.双重检查锁，将同步的粒度降低。只有不能直接获得实例的情况下，才进行同步。如下：
 * 
 * 要点：private的构造函数，public的实例获取方法getSingleInstance，static的获取方法和实例句柄
 */
public class ThreadSafeSingleton {
	
	private static ThreadSafeSingleton singObj = null;
	private ThreadSafeSingleton() {
	}

	public static ThreadSafeSingleton getSingleInstance() {
		if (null == singObj) {
			synchronized (ThreadSafeSingleton.class) {
				if (null == singObj)
					singObj = new ThreadSafeSingleton();
			}
		}
		return singObj;
	}

}
