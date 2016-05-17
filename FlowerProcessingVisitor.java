public class FlowerProcessingVisitor implements FlowerVisitor{
    public double calculate(Rose rose){
      //System.out.println("You visited a rose!");
      return rose.getPrice();
    }
    public double calculate(PassionFlower passionFlower){
      //System.out.println("You visited a passion flower!");
      return passionFlower.getPrice();
    }
    public double calculate(Marigold marigold){
      //System.out.println("You visited a marigold!");
      return marigold.getPrice();
    }
    public double calculate(Jasmine jasmine){
      //System.out.println("You visited a jasmine!");
      return jasmine.getPrice();
    }
    public double calculate(IndianLotus indianLotus){
      //System.out.println("You visited an indian lotus!");
      return indianLotus.getPrice();
    }

}
