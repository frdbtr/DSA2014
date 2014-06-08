public class MyTrapezoid{
    double base1, base2, height;

    public MyTrapezoid(double b1, double b2, double h){
	base1 = b1;
	base2 = b2;
	height = h;
    }

    public void showArea(){
	System.out.println("上辺" + base1 + "cm, 下辺" + base2 + "cm, 高さ" + height + "の台形の面積は" + (base1 + base2) * height /2 + "[cm^2]です。");
    }
}