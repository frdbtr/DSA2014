public class MyTriangle{
    double base, height;

    public MyTriangle(double b, double h){
	base = b;
	height = h;
    }

    public void showArea(){
	System.out.println("底辺" + base + "cm, 高さ" + height + "cmの三角形の面積は" + base * height / 2 + "[cm^2]です。");
    }
}