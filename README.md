###### tags: `spring`
# AOP


切面導向程式設計（Aspect Oriented Programming，AOP）是一種特別的開發方式，它的目的是將許多方法的共同行為抽離出來。
AOP 是將這些共通工作從原方法「分離」出來，並設定某個時機點才執行，有點像資料庫的「觸發程序」（trigger）。此處的分離，除了在另一個類別實作之外，更重要的是原方法「不需要呼叫」。

## 定義annotation

@Target指定Annotation所修飾範圍： 
取值(ElementType)有：

1.CONSTRUCTOR:用於建構式
2.FIELD:用於作用域
3.LOCAL_VARIABLE:用於區域變數
4.METHOD:用於方法 
5.PACKAGE:用於描述包裝
6.PARAMETER:用於描述變數
7.TYPE:用描述類別、interface或enum


@Retention用來指定保留階段
1.RetentionPolicy.SOURCE —— 這種Annotations只保留在code中，compile時間就會被忽略
2.RetentionPolicy.CLASS —— 這種Annotations保留在compile期間,在class中存在,但JVM會忽略
3.RetentionPolicy.RUNTIME —— 這種Annotations會在JVM保留,運行時被JVM或其他使用relection的code所使用

```java=
    @Target({ ElementType.PARAMETER, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface Action {

        String value() default "";
        String name() default "";
        //標籤裡面有value屬性可設定，如屬性名稱為value可以省略名稱直接指定直
    }

```

## 定義切面方法
@Aspect 定義類別為切面

並用pointcut指定@Action這個標示
```java=
   @Pointcut("@annotation(com.annotation.Action)")
    public void log() {
    }
```

接者就可撰寫Advice(類似lifecycle，依據方法的執行前後會執行方法):

|標籤|執行時間 |
| -------- | -------- | 
|@Around |可控制什麼時候去執行發法|
|@Before |方法執行前去呼叫|
|@After  |方法結束後去呼叫|
|@AfterReturning| 方法回傳值時呼叫，可接收回傳值|
|@AfterThrowing  |方法丟出錯誤時呼叫，可接收方法丟出錯誤|
