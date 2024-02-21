package solutions.Anshul2718;

public class Triangle extends Shape {
    Triangle(double height, double width){
        super(height,width);
    }
    double compute_area(){
        return (this.height*this.width)/2;
    }
}
