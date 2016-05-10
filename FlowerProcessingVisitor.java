public class FlowerProcessingVisitor implements FlowerVisitor{
    public void visit(Rose rose){
      System.out.println("You visited a rose!");
    }
    public void visit(PassionFlower passionFlower){
      System.out.println("You visited a passion flower!");
    }
    public void visit(Marigold marigold){
      System.out.println("You visited a marigold!");
    }
    public void visit(Jasmine jasmine){
      System.out.println("You visited a jasmine!");
    }
    public void visit(IndianLotus IndianLotus){
      System.out.println("You visited an indian lotus!");
    }

}
