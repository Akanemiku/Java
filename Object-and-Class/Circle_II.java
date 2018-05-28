import java.util.Scanner;

public class Circle_II {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入圆的半径：");
		double radius = input.nextDouble();
		Circle circle = new Circle(radius);
		circle.show();	
	}
	public static class Circle{
		
		private double radius;
		private double perimeter;
		private double area;
		
		public double getRadius(){
			return radius;
		}
		
		public void show(){
			System.out.println("周长为："+this.getPerimeter());
			System.out.println("面积为："+this.getArea());
		}
		
		public Circle(){};
		public Circle(double radius){
			this.setRadius(radius);
		}
		
		public void setRadius(double radius){
			this.radius = radius;
		}
		
		public double getPerimeter(){		
			perimeter = 2*Math.PI*radius;
			return perimeter;
		}
		public double getArea(){
			area = Math.PI*Math.pow(radius,2);
			return area;
		}
	}
}
