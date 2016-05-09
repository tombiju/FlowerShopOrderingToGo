/**
Flower Shop Ordering To Go - Create a flower shop application which deals in flower objects and use those flower objects in a bouquet object which can then be sold.
Keep track of the number of objects and when you may need to order more.
-Implemented by Tom Biju
*/
import java.util.Scanner;
public class FlowerShop{
  public static void main(String args[]){
    /**establishing store defaults of 20 flowers for each type of flower*/
    Rose roseStock=new Rose(20,9.00,"roses");
    PassionFlower passionFlowerStock=new PassionFlower(20,7.00,"passion flowers");
    Marigold marigoldStock=new Marigold(20, 5.00,"marigolds");
    Jasmine jasmineStock=new Jasmine(20,8.00,"jasmines");
    IndianLotus indianLotusStock=new IndianLotusStock(20,10.00,"indian lotuses");
    String userInput;
    Scanner scanner=new Scanner(System.in);
    System.out.println("Hello Customer! Welcome to Fragrant Flowers! How may I help you today?");
    do{
      System.out.println("1-BUY");
      System.out.println("2-EXIT");
      userInput=scanner.nextString();
      if(userInput.equals("1")){
        roseStock.accept(new FlowerVisitor());
      }
    }while(true);
  }
}
