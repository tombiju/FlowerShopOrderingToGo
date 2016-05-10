public class PassionFlower implements Flower{
private int amount;
private double price;
private String name;
public PassionFlower(int amount, double price, String name){
  this.amount=amount;
  this.price=price;
  this.name=name;
}
public void accept(FlowerVisitor flowerVisitor){
  flowerVisitor.visit(this);
}
}
