package dataStructure.chuan;

public class chuan extends chuanAbstract{


    @Override
    public void String(int n) {//构造一个串对象
        this.maxSize=n;
        this.chars=new char[n];
        this.length=0;
    }

    @Override//基本算法与String类的compareTo一致
    public int compare(String s) {
        int i=0;
        while(this.chars[i]==s.charAt(i)&&i<this.chars.length&&i<s.length()){
            i++;
        }
        if(i==this.length&&i==s.length()){
            return  0;//完全相等
        }else if(i==s.length()&&i<length){
            return 1;//包含关系
        }else{
            return -1;//不相等
        }
    }

    /*
       String的concat方法与其基本类似，先判断追加的字符串长度是否为0，在调用array.copy方法对其进行数组扩容，扩容的数量级为追加的字符串
       长度，扩容结束之后会调用System.copyArrays方法对追加的字符串进行一个复制
    */
    @Override
    public void concat(String s) {//总体可看做先判断原串的最大长度是否能容纳下新增的串，如不能先进行一个扩容操作，之后进行一个串内容转换
        if(this.maxSize<this.length+s.length()){//长度扩容
            char[] a = new char[this.length];
            for(int i=0;i<chars.length;i++){
                a[i]=chars[i];
            }
            this.maxSize=this.length+s.length();
            this.chars=new char[maxSize];

            for(int i=0;i<a.length;i++){//恢复当前串的原始状态
                this.chars[i]=a[i];
            }
        }

        for(int i=0;i<s.length();i++){//将追加的字符串追加到原字符串末尾
            this.chars[this.length]=s.charAt(i);
            this.length++;
        }
    }

    @Override
    public String subString(int pos, int len) {
        if(pos+len>this.length){//如果获取的子串起始位置与结束位置之和大于串长度，返回一个空字符串
            return null;
        }
        StringBuffer a = new StringBuffer();
        for(int i=0;i<len;i++){
            a.append(this.chars[i+pos]);
        }
        return a.toString();
    }
}
