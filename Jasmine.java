public class Jasmine implements Flower{
private int amount;
private double price;
private String name;
public Jasmine(int amount, double price, String name){
  this.amount=amount;
  this.price=price;
  this.name=name;
}
public double accept(FlowerVisitor flowerVisitor, int amount, double userMoney, boolean isOwner){
  if(!isOwner){
  if(amount>this.amount){
    System.out.println("We do not have that many jasmines in stock!");
    return 0;
  }
    int actualAmount=checkInventory(amount);
    double actualPrice=actualAmount*flowerVisitor.calculate(this);
    if(userMoney<actualPrice){
      System.out.println("You do not have enough money to make this transaction!");
      return 0;
    }
    if(actualAmount>0){
    System.out.print("You bought "+actualAmount+" jasmines for $");
    System.out.printf("%.2f",actualPrice);
    System.out.println();
    System.out.println("There are now "+getAmount()+" jasmines in stock.");
    }
    return actualPrice;
  }
  else{
    double orderPrice=amount*flowerVisitor.calculate(this);
    if(userMoney<orderPrice){
      System.out.println("You do not have enough money to make this transaction!");
      return 0;
    }
    else{
      this.amount+=amount;
      System.out.print("You have bought "+amount+" jasmines for $");
      System.out.printf("%.2f",orderPrice);
      System.out.println();
      System.out.println("There are now "+getAmount()+" jasmines in stock.");
    }
    return orderPrice;
  }
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
    System.out.println("Jasmines are out of stock!");
  }
  return actualBought;
}
}
