package aop;

public class Human implements Sleepable{

    @Override
    public void sleep() {
        System.out.println("这人要睡觉了！");
    }
}
