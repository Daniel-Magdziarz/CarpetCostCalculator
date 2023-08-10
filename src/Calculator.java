public class Calculator {

    private FloorSize floorSize;
    private CarpetCost carpetCost;

    public Calculator(FloorSize floorSize, CarpetCost carpet) {
        this.floorSize = floorSize;
        carpetCost = carpet;
    }

    public double getTotalCost(){
        return floorSize.getArea() * carpetCost.getCost();
    }

}
