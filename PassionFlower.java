public class PassionFlower implements Flower{
private int amount;
private double price;
private String name;
public PassionFlower(int amount, double price, String name){
  this.amount=amount;
  this.price=price;
  this.name=name;
}
public double accept(FlowerVisitor flowerVisitor, int amount, double userMoney){
    int actualAmount=checkInventory(amount);
    double actualPrice=actualAmount*flowerVisitor.calculate(this);
    if(userMoney<actualPrice){
      System.out.println("You do not have enough money to make this transaction!");
      return 0;
    }
    if(actualAmount>0){
    System.out.print("You bought "+actualAmount+" passion flowers for $");
    System.out.printf("%.2f",actualPrice);
    System.out.println();
  }
    return actualPrice;
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
public int checkInventory(int amount){
  int actualBought=0;
  for(int i=0;i<amount;i++){
    if(this.amount>0){
        this.amount--;
        actualBought++;
    }
  }
  if(this.amount==0){
    System.out.println("Passion Flowers are out of stock!");
  }
  return actualBought;
}
}
