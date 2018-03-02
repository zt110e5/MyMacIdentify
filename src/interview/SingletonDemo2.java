public class SingletonDemo2 {
    private static SingletonDemo2 instance = null;
    //私有构造函数
    private SingletonDemo2(){}
    public synchronized static SingletonDemo2 getInstance(){
        if (instance==null)
            instance = new SingletonDemo2();
        return instance;
    }
}
