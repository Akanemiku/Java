import java.util.Scanner;

public class Circle_I {
	public static void main(String[] args) {
		Circle circle = new Circle();
		circle.showPerimeter();
		circle.showArea();
				
	}
	public static class Circle{
		public double radius;
		public double perimeter;
		public double area;
		public Circle(){
			inputRadius();
		}
		public Circle(double radius1){
			if(radius1 > 0){
				radius = radius1;
			}else{
				inputRadius();
			}
		}
		private void inputRadius(){
			Scanner input = new Scanner(System.in);
			System.out.println("请输入圆的半径：");
			radius = input.nextDouble();
		}
		public void showPerimeter(){
			if(radius <= 0){
				inputRadius();
			}
			perimeter = 2*Math.PI*radius;
			System.out.println("周长为："+perimeter);
		}
		public void showArea(){
			if(radius <= 0){
				inputRadius();
			}
			area = Math.PI*Math.pow(radius,2);
			System.out.println("面积为："+area);
		}
	}
}
