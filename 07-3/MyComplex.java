public class MyComplex{

    private double real, imag;

    public MyComplex(double x, double y){
	real = x;
	imag = y;
    }

    public MyComplex(double x){
	real = x;
    }

    public String toString(){
	return real + " + " + imag + " i";
    }

    public double real(){
	return real;
    }

    public double imag(){
	return imag;
    }

    public static MyComplex add(MyComplex a, MyComplex b){
	double r = a.real() + b.real();
	double i = a.imag() + b.imag();
	return new MyComplex(r, i);
    }

    public static MyComplex sub(MyComplex a, MyComplex b){
	double r = a.real() - b.real();
	double i = a.imag() - b.imag();
	return new MyComplex(r, i);
    }

    public static MyComplex mul(MyComplex a, MyComplex b){
	double r = (a.real() * b.real()) - (a.imag() * b.imag());
	double i = (a.real() * b.imag()) + (a.imag() * b.real());
	return new MyComplex(r, i);
    }

    public static MyComplex div(MyComplex a, MyComplex b){
	MyComplex c = new MyComplex(b.real(), b.imag()*-1);
	a = MyComplex.mul(a, c);
	double d = c.real() * c.real() + c.imag() * c.imag();
	double r = a.real() / d;
	double i = a.imag() / d;
	return new MyComplex(r, i);
    }

    public MyComplex add(MyComplex a){
	double r = real + a.real();
	double i = imag + a.imag();
	return new MyComplex(r, i);
    }

    public MyComplex sub(MyComplex a){
	double r = real - a.real();
	double i = imag - a.imag();
	return new MyComplex(r, i);
    }

    public MyComplex mul(MyComplex a){
	double r = (real * a.real()) - (imag * a.imag());
	double i = (real * a.imag()) + (imag * a.real());
	return new MyComplex(r, i);
    }

    public MyComplex div(MyComplex a){
	MyComplex b = new MyComplex(real, imag);
	return MyComplex.div(b, a);
    }

    public MyComplex con(){
	return new MyComplex(real, -imag);
    }
}