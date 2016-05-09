public class Rose implements Flower{
  private int amount;
  private int price;
  private String name;
  public Rose(int amount, double price, String name){
    this.amount=amount;
    this.price=price;
    this.name=name;
  }
  public void accept(FlowerVisitor flowerVisitor){
    flowerVisitor.visit(this);
  }

}
