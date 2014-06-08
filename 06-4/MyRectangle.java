public class MyRectangle{
    
    double width;
    double height;

    public MyRectangle(double w, double h){
	width = w;
	height = h;
    }

    public void showArea(){
	System.out.println("幅" + height + "cm, 高さ" + width + "cmの長方形の面積は" + width * height + "[cm^2]です。");
    }
}