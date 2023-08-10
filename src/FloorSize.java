public class FloorSize {

    private double width = 0;
    private double length = 0;
    private double area = 0;

    public FloorSize(double length, double width){
        this.width = width < 0 ? 0 : width;
        this.length = length < 0 ? 0 : length;
    }

    public FloorSize (double area){
        this.area = area < 0 ? 0 : area;
    }

    public double calculateArea(){
        this.area = this.area + (width * length); //either 'this.area' = 0 OR (width * length) = 0;
        return area;
    }

    public double getArea(){
        return area;
    }
}
