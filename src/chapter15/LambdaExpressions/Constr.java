package chapter15.LambdaExpressions;

public class Constr {
    int i;
    int i2;

    Constr() {}

    Constr(int i) {
        this.i = i;
    }

//    Constr(int i, int i2) {
//        this.i = i;
//        this.i2 = i2;
//    }

    void getI() {
        System.out.println("i=" + i);
        System.out.println("i1=" + i2);
    }

    static void test(FuncIntParam fip, int i) {
        System.out.println(fip.getNum(i));
    }

    static int test1(int i) {
        return i * 10;
    }

    int test2(int i) {
        return i * 20;
    }

}
