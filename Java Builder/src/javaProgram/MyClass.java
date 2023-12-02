package javaProgram;

public class MyClass {
    private int x=1;
    int x2=2;

    public void setX(int x) {
        this.x = x;
    }

    public void printX() {
        // Use "this" to invoke the current object's method
        System.out.println("Value of x: " + this.getX());
        this.x2=x2;
        System.out.println(x2);
    }

    public int getX() {
        return this.x;
    }
    public static void main(String[] args) {
    	MyClass mc =new MyClass();
    	mc.printX();
    	System.out.println();
	}
}
