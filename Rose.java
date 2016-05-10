public class Rose implements Flower{
  private int amount;
  private double price;
  private String name;
  public Rose(int amount, double price, String name){
    this.amount=amount;
    this.price=price;
    this.name=name;
  }
  public void accept(FlowerVisitor flowerVisitor){
    flowerVisitor.visit(this);
  }
public void getPrice(){
  System.out.println(this.price);
}
public void setPrice(double price){
  this.price=price;
  System.out.println("The price was changed to $"+this.price);
}
public int getAmount(){
  return this.amount;
}
public void buyFlowers(int Flowers){//calculate price

}
}
