/**
Flower Shop Ordering To Go - Create a flower shop application which deals in flower objects and use those flower objects in a bouquet object which can then be sold.
Keep track of the number of objects and when you may need to order more.
-Implemented by Tom Biju
*/
//Tom Biju
import java.util.Scanner;
import java.lang.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
public class FlowerShop{
  public static void main(String args[]){
    /*Creating user and shopkeeper**/
    Person user;
    Person shopKeeper=new Person("Tom Biju",100);
      double userMoney=0;
      boolean light=false;
    Scanner scanner=new Scanner(System.in);
    if(args.length!=0){ //Only accounts for one part names if entering via command line!
      try{
      userMoney=Double.parseDouble(args[1]);
    }
    catch(Exception e){
      System.out.println("That's not a monetary value!");
    }
    if(userMoney>0){
      light=true;
    }else{
      do{
      System.out.println("How much money are you willing to spend?: ");
      try{
        userMoney=Double.parseDouble(scanner.next());
      }
      catch(Exception e){
        System.out.println("That's not a monetary value!");
      }
    }while(userMoney==0);
    }
      user=new Person(args[0],userMoney);
    }
    else{
      System.out.println("What is your name?:");
      String userName=scanner.nextLine();
      while(light==false){
      try{
      System.out.println("How much money are you willing to spend?: ");
      userMoney=Double.parseDouble(scanner.next());
    }
    catch(Exception e){
      System.out.println("That's not a monetary value!");
    }
    if(userMoney>0){
      light=true;
    }
  }
      user=new Person(userName,userMoney);
    }
    //Music implementation learned from RB Whitaker at rbwhitaker.wikidot.com
    try{
    InputStream in = new FileInputStream(new File("songOfStorms.wav"));
    AudioStream audioStream = new AudioStream(in);
    AudioPlayer.player.start(audioStream);
  }
  catch (Exception e)
  {
    e.printStackTrace();
   System.exit(1);
  }
  //AudioPlayer.player.stop(audioStream); //code to stop music
    /**establishing store defaults of 20 flowers for each type of flower*/
    Rose roseStock=new Rose(20,9.00,"roses");
    PassionFlower passionFlowerStock=new PassionFlower(20,7.00,"passion flowers");
    Marigold marigoldStock=new Marigold(20, 5.00,"marigolds");
    Jasmine jasmineStock=new Jasmine(20,8.00,"jasmines");
    IndianLotus indianLotusStock=new IndianLotus(20,10.00,"indian lotuses");
    String userInput;
    boolean flag=true;
    System.out.println("Hello "+user.getName()+"! Welcome to Fragrant Flowers! How may I help you today?");
    do{
      System.out.println("1-BUY");
      System.out.println("2-BROWSE");
      System.out.println("3-BECOME STORE OWNER");
      System.out.println("4-BECOME BUYER");
      System.out.println("5-EXIT");

      userInput=scanner.next();
      if(userInput.equals("1")){
        System.out.println("Would you like to buy ...");
        System.out.println("1-Roses");
        System.out.println("2-Passion Flowers");
        System.out.println("3-Marigolds");
        System.out.println("4-Jasmines");
        System.out.println("5-Indian Lotuses");
        System.out.println("6-A bouquet");
        userInput=scanner.next();
        System.out.println("How many would you like?");
        int amount=scanner.nextInt();
        //Learned how to implement image viewing from Alvin Alexander @ alvinalexander.com
        switch(userInput){
          case "1":
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
      else if(userInput.equals("2")){
        JFrame editorFrame;
        ImageIcon imageIcon;
        BufferedImage image;
        JLabel jLabel;
        System.out.println("Would you like to view ...");
        System.out.println("1-Rose");
        System.out.println("2-Passion Flower");
        System.out.println("3-Marigold");
        System.out.println("4-Jasmine");
        System.out.println("5-Indian Lotus");
        int choice=scanner.nextInt();
        //Learned how to implement image viewing from Alvin Alexander @ alvinalexander.com
        switch(choice){
          case 1:
          System.out.print("The price for a rose is $");
          System.out.printf("%.2f",roseStock.getPrice());
          System.out.println();
          editorFrame = new JFrame("Roses");
          editorFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
          image=null;
          try{
          image = ImageIO.read(new File("roses.jpg"));
        }
        catch (Exception e)
        {
          e.printStackTrace();
         System.exit(1);
        }
          imageIcon = new ImageIcon(image);
          jLabel = new JLabel();
          jLabel.setIcon(imageIcon);
          editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);
          editorFrame.pack();
          editorFrame.setLocationRelativeTo(null);
          editorFrame.setVisible(true);
            break;
          case 2:
          System.out.print("The price for a passion flower is $");
          System.out.printf("%.2f",passionFlowerStock.getPrice());
          System.out.println();
          editorFrame = new JFrame("Passion Flowers");
          editorFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
          image=null;
          try{
          image = ImageIO.read(new File("passionFlowers.jpg"));
        }
        catch (Exception e)
        {
          e.printStackTrace();
         System.exit(1);
        }
          imageIcon = new ImageIcon(image);
          jLabel = new JLabel();
          jLabel.setIcon(imageIcon);
          editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);
          editorFrame.pack();
          editorFrame.setLocationRelativeTo(null);
          editorFrame.setVisible(true);
            break;
          case 3:
          System.out.print("The price for a marigold is $");
          System.out.printf("%.2f",marigoldStock.getPrice());
          System.out.println();
          editorFrame = new JFrame("Marigolds");
          editorFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
          image=null;
          try{
          image = ImageIO.read(new File("marigolds.jpg"));
        }
        catch (Exception e)
        {
          e.printStackTrace();
         System.exit(1);
        }
          imageIcon = new ImageIcon(image);
          jLabel = new JLabel();
          jLabel.setIcon(imageIcon);
          editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);
          editorFrame.pack();
          editorFrame.setLocationRelativeTo(null);
          editorFrame.setVisible(true);
            break;
          case 4:
          System.out.print("The price for a jasmine is $");
          System.out.printf("%.2f",jasmineStock.getPrice());
          System.out.println();
          editorFrame = new JFrame("Jasmines");
          editorFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
          image=null;
          try{
          image = ImageIO.read(new File("jasmines.jpg"));
        }
        catch (Exception e)
        {
          e.printStackTrace();
         System.exit(1);
        }
          imageIcon = new ImageIcon(image);
          jLabel = new JLabel();
          jLabel.setIcon(imageIcon);
          editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);
          editorFrame.pack();
          editorFrame.setLocationRelativeTo(null);
          editorFrame.setVisible(true);
            break;
          case 5:
          System.out.print("The price for an indian lotus is $");
          System.out.printf("%.2f",indianLotusStock.getPrice());
          System.out.println();
          editorFrame = new JFrame("Indian Lotues");
          editorFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
          image=null;
          try{
          image = ImageIO.read(new File("indianLotus.jpg"));
        }
        catch (Exception e)
        {
          e.printStackTrace();
         System.exit(1);
        }
          imageIcon = new ImageIcon(image);
          jLabel = new JLabel();
          jLabel.setIcon(imageIcon);
          editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);
          editorFrame.pack();
          editorFrame.setLocationRelativeTo(null);
          editorFrame.setVisible(true);
            break;
          default:
            //bouquet yet to be implemented
            break;
        }
      }
      else{
        flag=false;
        System.out.println("Thank you, come again!");
        System.exit(1);
      }
        //switch statement goes here
      //  roseStock.accept(new FlowerProcessingVisitor());
      }while(flag);
    }
  }
