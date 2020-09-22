package dataStructure.chuan;

public abstract class chuanAbstract {

    public int maxSize=10;//串中字符初始长度

    public char[] chars;//串对象

    public int length;//串长度

    public abstract void String(int n);//定义个能保存n个字符串的串

    public abstract int compare(String s);//串比较

    public abstract void concat(String s );//串拼接

    public abstract String subString(int pos,int len);//串截取

}
