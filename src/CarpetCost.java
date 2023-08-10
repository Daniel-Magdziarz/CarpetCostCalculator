public class CarpetCost {

    private double cost;

    public CarpetCost(double cost) {
        this.cost = cost < 0 ? 0 : cost;
    }

    public double getCost(){
        return cost;
    }

}
