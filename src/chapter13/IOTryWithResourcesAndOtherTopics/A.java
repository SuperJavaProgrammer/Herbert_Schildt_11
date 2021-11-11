package chapter13.IOTryWithResourcesAndOtherTopics;

strictfp class A { //ensure that floating-point calculations take place precisely as they did in earlier versions of Java
    int a;
    int b;

    native int nm(); // is used to declare native code methods

    A(int aa, int bb) {
        aa = a;
        bb = b;
    }

    A(int c) {
        this(c, c);
    }

    A() {
        this(0);
    }

    @Override
    public String toString() {
        return "A toString";
    }
}
