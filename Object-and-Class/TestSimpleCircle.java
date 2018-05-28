public class Main {
	public static void main(String []args) {
		SimpleCircle circle1 = new SimpleCircle();
		System.out.println("The area of the circle of radius "+circle1.radius+" is "+circle1.S());
		SimpleCircle circle2 = new SimpleCircle(25);
		System.out.println("The area of the circle of radius "+circle2.radius+" is "+circle2.S());
		circle2.radius = 100;
		System.out.println("The area of the circle of radius "+circle2.radius+" is "+circle2.S());
	}
} 
class SimpleCircle{
	double radius;
	SimpleCircle(){
		radius = 1;
	}
	SimpleCircle(double newRadius){
		radius = newRadius;
	}
	double S() {
		return radius*radius*Math.PI;
	}
	double C() {
		return 2*Math.PI*radius;
	}
	void setRadius(double newRadius) {
		radius = newRadius;
	}
	
}
