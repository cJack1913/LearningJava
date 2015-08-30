package classinit;

/*
 * 程序先试图访问Beetle.main()方法，于是开始加载Beetle
 * 1.尝试加载当前类
 * 2.若存在父类则尝试加载父类（*）
 * 3.根基类中的static初始化
 * 4.子类的static初始化
 * 此时所有的相关类加载完毕
 * 
 * main()方法执行，遇到new时进行对象创建
 * 1.对象所有声明变量初始化(基本类型为默认，引用为null)，包括父类声明变量(包括父类private)，若父类子类的声明重名则都存在。           Beetle:d(father),d(insect),d(自己),i,j,k
 * 2.调用构造器第一句，即调用父类构造器(隐式或显式super()来指定父类的构造器)
 * 3.当父类的高一级父类为object时，父类执行父类中的赋值语句(包含块)
 * 5.父类构造器余下部分(此时可对当前类变量或父类变量进行操作，如例子中的d和j，若当前类和父类都声明该变量，使用super.变量名来获取父类变量)
 * 6.子类执行子类中的赋值语句(包含块)，构造器余下部分
 * 
 * int i = 1; 则int i;在第一步时已经执行，i = 1;在执行到当前类的赋值语句时执行
 */
class father {
	int d = 1;
	father(){
	}
	
}
class Insect extends father{
	private int i = 9;
	int d = 2;
	protected int j;
	{System.out.println("block Insect initialized");}
	
	Insect(){
		System.out.println("i = "+ i +",j = "+j);
		d = 3;
		super.d = 4;
		System.out.println("father.d = "+ super.d);
		System.out.println("Insect.d = "+ d);
		j = 39;
	}
	
	private static int x1 = printInit("static Insect.x1 initialized");
	
	static int printInit(String s){
		System.out.println(s);
		return 47;
	}
}
public class Beetle extends Insect{
	int d = 3;
	private int k = printInit("Beetle.k initialized");
	{System.out.println("block Beetle initialized");}
	
	
	public Beetle(){
		System.out.println("k = "+ k);
		System.out.println("j = "+ j);
		System.out.println("Beetle.d = " + d);
	}
	
	private static int x2 = printInit("static Beetle.x2 initialized");
	
	public static void main(String[] args) {
		System.out.println("Beetle constructor");
		Beetle b = new Beetle();
	}
}
