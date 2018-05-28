public class A{
	public A(){
		System.out.println("父类默认构造");
	}
}

public class B extends A{
	public B(){
		//super();//子类构造中默认会调用父类构造
		//默认先调用父类构造
		System.out.println("子类默认构造");
	}
}

public class Test{
	public static void main(String[] args){
		B ccc = new B();
		B();
	}
}

输出结果：
父类默认构造
子类默认构造

//构造方法不可继承
//父类私有属性在子类中不能直接访问
//继承关系是一种is-a关系：父类和子类之间必须存在is-a关系

实例化子类对象
Warrior 曹操 = new Warrior();
Archmage 小乔 = new Archmage();

子类对象实现父类
战士 is a 英雄
法师 is a 英雄
多态：同一个类不同的表现形式
Hero 曹操 = new Warrior();
Hero 小乔 = new Archmage();

英雄 is a 法师,错误的关系
Archmage 小乔 = new Hero();