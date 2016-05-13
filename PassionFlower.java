public class PassionFlower implements Flower{
private int amount;
private double price;
private String name;
public PassionFlower(int amount, double price, String name){
  this.amount=amount;
  this.price=price;
  this.name=name;
}
public double accept(FlowerVisitor flowerVisitor, int amount){
  return amount*flowerVisitor.calculate(this);
}
public double getPrice(){
  return this.price;
}
public void setPrice(double price){
  this.price=price;
  System.out.println("The price was changed to $"+this.price);
}
public int getAmount(){
  return this.amount;
}
}
