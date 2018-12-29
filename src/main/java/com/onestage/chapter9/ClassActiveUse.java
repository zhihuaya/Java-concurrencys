package com.onestage.chapter9;

public class ClassActiveUse {

    public static void main(String[] args) {
        //System.out.println(f.i);
    }


}

class f {

    static {
        System.out.println("静态代码快");
    }
    public static int i = 1;

}
