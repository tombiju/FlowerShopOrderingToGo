/**
Flower Shop Ordering To Go - Create a flower shop application which deals in flower objects and use those flower objects in a bouquet object which can then be sold.
Keep track of the number of objects and when you may need to order more.
-Implemented by Tom Biju
*/
import java.util.Scanner;
import java.lang.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
public class FlowerShop{
  public static void main(String args[]){
    /**establishing store defaults of 20 flowers for each type of flower*/
    Rose roseStock=new Rose(20,9.00,"roses");
    PassionFlower passionFlowerStock=new PassionFlower(20,7.00,"passion flowers");
    Marigold marigoldStock=new Marigold(20, 5.00,"marigolds");
    Jasmine jasmineStock=new Jasmine(20,8.00,"jasmines");
    IndianLotus indianLotusStock=new IndianLotus(20,10.00,"indian lotuses");
    String userInput;
    boolean flag=true;
    Scanner scanner=new Scanner(System.in);
    System.out.println("Hello Customer! Welcome to Fragrant Flowers! How may I help you today?");
    do{
      System.out.println("1-BUY");
      System.out.println("2-EXIT");
      userInput=scanner.next();
      if(userInput.equals("1")){
        System.out.println("Would you like to buy ...");
        System.out.println("1-Roses");
        System.out.println("2-PassionFlower");
        System.out.println("3-Marigold");
        System.out.println("4-Jasmine");
        System.out.println("5-Indian Lotus");
        System.out.println("6-A bouquet");
        userInput=scanner.next();
        System.out.println("How many would you like?");
        int amount=scanner.nextInt();
        //Learned how to implement image viewing from Alvin Alexander @ alvinalexander.com
        switch(userInput){
          case "1":
            JFrame editorFrame = new JFrame("Roses");
            editorFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            BufferedImage image=null;
            try{
            image = ImageIO.read(new File("C:\\Users\\Tom\\Desktop\\rose.jpg"));
          }
          catch (Exception e)
          {
            e.printStackTrace();
           System.exit(1);
          }
            ImageIcon imageIcon = new ImageIcon(image);
            JLabel jLabel = new JLabel();
            jLabel.setIcon(imageIcon);
            editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);
            editorFrame.pack();
            editorFrame.setLocationRelativeTo(null);
            editorFrame.setVisible(true);
            roseStock.accept(new FlowerProcessingVisitor(),amount);
            break;
          case "2":
            passionFlowerStock.accept(new FlowerProcessingVisitor(),amount);
            break;
          case "3":
            marigoldStock.accept(new FlowerProcessingVisitor(),amount);
            break;
          case "4":
            jasmineStock.accept(new FlowerProcessingVisitor(),amount);
            break;
          case "5":
            indianLotusStock.accept(new FlowerProcessingVisitor(),amount);
            break;
          default:
            //bouquet yet to be implemented
            break;
        }
      }
      else{
        flag=false;
        System.out.println("Thank you, come again!");
      }
        //switch statement goes here
      //  roseStock.accept(new FlowerProcessingVisitor());
      }while(flag);
    }
  }
