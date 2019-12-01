# Java Q&A

####下面代码存在什么问题
```java
public class MyClass {
                  public static void main(String arguments[])     {
                      amethod(arguments);
                  }
                  public void amethod(String[] arguments){
                      System.out.println(arguments);
                      System.out.println(arguments[1]);
                  }
              }
```
1. ***错误，void amethod()不是static类型***
2. 错误，main()方法不正确
3. 错误，数组必须导入参数
4. 方法amethod()必须用String类型描述

***

####关于Java8中提供的四个核心函数式接口的描述，正确的一项是？
1. Predicate接口中的方法不能够返回数据，只能够接收并操作数据    --> Predicate是个断言式接口其参数是<T,boolean>，也就是给一个参数T，返回boolean类型的结果. 谓语接口，顾名思义，中文中的‘是’与‘不是’是中文语法的谓语，同样的该接口对应的方法为接收一个参数，返回一个Boolean类型值，多用于判断与过滤，当然你可以把他理解成特殊的Funcation<T,R>，但是为了便于区分语义 
2. Consumer接口中的方法可以对数据进行判断，并且可以返回判断结果  --> Consumer：代表了接受一个输入参数并且无返回的操作，相当于消费者。
3. Function接口中的方法可以接收参数，并且将数据处理后返回       --> Fcuntion接口是对接受一个T类型参数,返回R类型的结果的方法的抽象,通过调用apply方法执行内容。
4. Supplier接口中的方法可以接收基本数据类型参数，但是没有返回值  --> Supplier 接口翻译过来就是提供者,和上面的消费者相反，该接口对应的方法类型为不接受参数，但是提供一个返回值，通俗的理解为这种接口是无私的奉献者，不仅不要参数，还返回一个值,使用get()方法获得这个返回值

***

####一个异常将终止？
1. 整个程序
2. 只终止抛出异常的方法
3. 产生异常的try块
4. 上面的说法都不对
***

####下列关于包、类和源文件的描述中，不正确的一项是？
1. 一个包可以包含多个类                                   --> true
2. 一个源文件中，只能有一个public class                    --> true
3. 属于同一个包的类在默认情况不可以互相访问，必须使用import导入 --> 一个类可以使用所属包中的所有类，以及其他包中的共有类（public class）。即只有公有类才能被另外一个包访问。
4. 系统不会为源文件创建默认的包
***

####编译下列代码可能会输出什么？
```java
class Test {
                 static int i ;  
                 public static void main(String args[]) {
                     System.out.println(i);
             }
             }
```
1. Error Variable i may not have been initialized
2. null
3. 1
4. ***0  --> 定义为 类的属性自然赋值 0 但是,定义为方法的局部变量一定要初始化 这是规定***

***

####编译下列代码可能会输出什么？
```java
class Test {
    public static void main(String args[]) {
        float [][] f1 = {{1.2f,2.3f},{4.5f,5.6f}} ;
        Object oo = f1 ;
        f1[1] = oo ;
        System.out.println("Best Wishes "+f1[1]);
    }
}
```
1. {4.5,5.6}
2. 4.5
3. ***compilation error in line NO.5  --> Object can't be convert as float array***
4. exception
***

####下面关于泛型的描述中错误的一项是？  (cnblogs.com/zhaoyibing/p/9051428.html)
1. “? extends 类”表示设置泛型上限                    --> Plate<？ extends Fruit> , 一个能放水果以及一切是水果派生类的盘子. 上界<? extends T>不能往里存，只能往外取 , 读取出来的东西只能放在Fruit或它的基类里
2. “? super 类”表示设置泛型下限                      --> Plate<？ super Fruit> , 一个能放水果以及一切是水果基类的盘子。 下界<? super T>不影响往里存，但往外取只能放在Object对象里.实际上是放松了容器元素的类型控制。既然元素是Fruit的基类，那往里存粒度比Fruit小的都可以。但往外读取元素就费劲了，只有所有类的基类Object对象才能装下。但这样的话，元素的类型信息就全部丢失。
3. 利用“?”通配符可以接收全部的泛型类型实例，但却不可修改泛型属性内容
4. 如果类在定义时使用了泛型，则在实例化类对象时需要设置相应的泛型类型，否则程序将无法编译通过

PECS（Producer Extends Consumer Super）原则，已经很好理解了：
频繁往外读取内容的，适合用上界Extends。
经常往里插入的，适合用下界Super。
***
