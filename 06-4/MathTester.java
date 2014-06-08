class MathTester{
    public static void main(String[] args){
	MyRectangle r = new MyRectangle(4, 5);
	MyTriangle t1 = new MyTriangle(4, 5);
	MyTrapezoid t2 = new MyTrapezoid(12.8, 15, 7);
	r.showArea();
	t1.showArea();
	t2.showArea();
    }
}