

public class SingletonDemo {
    //单例模式(饿汉模式)
    private static class SinletonDemoInstance{
        private static final SingletonDemo instance = new SingletonDemo();
    }

    public static SingletonDemo getInstance(){
        return SinletonDemoInstance.instance;
    }
    //私有构造函数
    private SingletonDemo(){}
}
