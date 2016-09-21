/**
 * 项目名称：hithere-center2
 * 包名：com.cyou.test.singleton
 * 文件名：Singleton1.java
 * 版本信息：V1.0
 * 日期：2015-4-14-下午03:17:38
 * 作者：litaijun
 * Copyright (c) 2015畅游天下-版权所有
 */

package com.cyou.test.singleton;

/**
 * 类名称：Singleton1
 * 类描述：(饿汉式单例)
 * 
 * <pre>
 *  单例模式的优点：
 * 	1、在内存中只有一个对象，节省内存空间。
 * 	2、避免频繁的创建销毁对象，可以提高性能。
 * 	3、避免对共享资源的多重单用。
 * 	4、可以全局访问。
 * 实用场景：
 * 	1、需要频繁实例化然后销毁的对象。
 * 	2、创建对象时耗时过多或则耗资源过多，但又经常用到的对象。
 * 	3、有状态的工具类对象。
 * 	4、频繁访问数据库或文件的对象。
 * </pre>
 * 
 * 创建人：litaijun
 * 创建时间：2015-4-14 下午03:17:38
 * 修改人：
 * 修改时间：2015-4-14 下午03:17:38
 * 修改备注：
 * 
 * @version 1.0.0
 */

public class Singleton1 {

	private static Singleton1 singleton = new Singleton1();

	private Singleton1() {
	}

	public static Singleton1 getInstance() {
		return singleton;
	}
}
