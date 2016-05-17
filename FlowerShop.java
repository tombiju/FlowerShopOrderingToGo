/**
Flower Shop Ordering To Go - Create a flower shop application which deals in flower objects and use those flower objects in a bouquet object which can then be sold.
Keep track of the number of objects and when you may need to order more.
-Implemented by Tom Biju
*/
//Tom Biju
import java.util.Scanner;
import java.util.Random;
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
    double value=0.00;
    int amount=0;
    int converted;
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
    MusicPlayer jam=new MusicPlayer();
    jam.play("windwaker.wav");
  //   //Music implementation learned from RB Whitaker at rbwhitaker.wikidot.com
  //   try{
  //   InputStream in = new FileInputStream(new File("songOfStorms.wav"));
  //   AudioStream audioStream = new AudioStream(in);
  //   AudioPlayer.player.start(audioStream);
  // }
  // catch (Exception e)
  // {
  //   e.printStackTrace();
  //  System.exit(1);
  // }
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
      System.out.print("The shop keeper, "+shopKeeper.getName()+", has $");
      System.out.printf("%.2f",shopKeeper.getMoney());
      System.out.println();
      System.out.print(user.getName()+" has $");
      System.out.printf("%.2f",user.getMoney());
      System.out.println();
      System.out.println("1-BUY");
      System.out.println("2-BROWSE");
      System.out.println("3-BECOME STORE OWNER");
      System.out.println("4-GET MORE MONEY");
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
        converted=Integer.parseInt(userInput);
        if(converted>0&&converted<6){
        System.out.println("How many would you like?");
        amount=scanner.nextInt();
      }
        //Learned how to implement image viewing from Alvin Alexander @ alvinalexander.com
        switch(userInput){
          case "1":
            value=roseStock.accept(new FlowerProcessingVisitor(),amount,user.getMoney(),false);
            user.transaction(-1*value);
            shopKeeper.transaction(value);
            break;
          case "2":
            value=passionFlowerStock.accept(new FlowerProcessingVisitor(),amount,user.getMoney(),false);
            user.transaction(-1*value);
            shopKeeper.transaction(value);
            break;
          case "3":
            value=marigoldStock.accept(new FlowerProcessingVisitor(),amount,user.getMoney(),false);
            user.transaction(-1*value);
            shopKeeper.transaction(value);
            break;
          case "4":
            value=jasmineStock.accept(new FlowerProcessingVisitor(),amount,user.getMoney(),false);
            user.transaction(-1*value);
            shopKeeper.transaction(value);
            break;
          case "5":
            value=indianLotusStock.accept(new FlowerProcessingVisitor(),amount,user.getMoney(),false);
            user.transaction(-1*value);
            shopKeeper.transaction(value);
            break;
          case "6":
             //TODO implement bouquet
             int flowerCount=0;
             double bouquetPrice=0;
             do{
               System.out.print("The shop keeper, "+shopKeeper.getName()+" has $");
               System.out.printf("%.2f",shopKeeper.getMoney());
               System.out.println();
               System.out.print(user.getName()+" has $");
               System.out.printf("%.2f",user.getMoney());
               System.out.println();
               System.out.println("There are currently "+flowerCount+" flowers in your bouquet.");
                 System.out.println("Would you like to buy ...");
                 System.out.println("1-Roses");
                 System.out.println("2-Passion Flowers");
                 System.out.println("3-Marigolds");
                 System.out.println("4-Jasmines");
                 System.out.println("5-Indian Lotuses");
                 System.out.println("6-Finish With Current Purchase");
                 userInput=scanner.next();
                 converted=Integer.parseInt(userInput);
                 if(converted>0&&converted<6){
                 System.out.println("How many would you like?");
                 amount=scanner.nextInt();
               }
                 //Learned how to implement image viewing from Alvin Alexander @ alvinalexander.com
                 if((flowerCount+amount)<=12){
                 switch(userInput){
                   case "1":
                     value=roseStock.accept(new FlowerProcessingVisitor(),amount,user.getMoney(),false);
                     if(value>0){
                       user.transaction(-1*value);
                       shopKeeper.transaction(value);
                       bouquetPrice+=value;
                       flowerCount+=amount;
                     }
                     break;
                   case "2":
                     value=passionFlowerStock.accept(new FlowerProcessingVisitor(),amount,user.getMoney(),false);
                     if(value>0){
                       user.transaction(-1*value);
                       shopKeeper.transaction(value);
                       bouquetPrice+=value;
                       flowerCount+=amount;
                     }
                     break;
                   case "3":
                     value=marigoldStock.accept(new FlowerProcessingVisitor(),amount,user.getMoney(),false);
                     if(value>0){
                       user.transaction(-1*value);
                       shopKeeper.transaction(value);
                       bouquetPrice+=value;
                       flowerCount+=amount;
                     }
                     break;
                   case "4":
                     value=jasmineStock.accept(new FlowerProcessingVisitor(),amount,user.getMoney(),false);
                     if(value>0){
                       user.transaction(-1*value);
                       shopKeeper.transaction(value);
                       bouquetPrice+=value;
                       flowerCount+=amount;
                     }
                     break;
                   case "5":
                     value=indianLotusStock.accept(new FlowerProcessingVisitor(),amount,user.getMoney(),false);
                     if(value>0){
                       user.transaction(-1*value);
                       shopKeeper.transaction(value);
                       bouquetPrice+=value;
                       flowerCount+=amount;
                     }
                     break;
                  case "6":
                      flowerCount=12;
                      break;
                   default:
                     System.out.println("That's not a valid option...");
                     break;
                 }}
                 else{
                   System.out.println("You can only have 12 flowers total in a bouquet!");
                 }
               }while(flowerCount!=12);
               if(bouquetPrice>0){
               System.out.print("You purchased a bouquet for $");
               System.out.printf("%.2f",bouquetPrice);
               System.out.println();
             }
               break;
          default:
            System.out.println("That's not a valid option...");
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
          System.out.println("There are currently "+roseStock.getAmount()+" of roses in stock");
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
          System.out.println("There are currently "+passionFlowerStock.getAmount()+" of passion flowers in stock");
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
          System.out.println("There are currently "+marigoldStock.getAmount()+" of marigolds in stock");
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
          System.out.println("There are currently "+jasmineStock.getAmount()+" of jasmines in stock");
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
          System.out.println("There are currently "+indianLotusStock.getAmount()+" of indian lotuses in stock");
          editorFrame = new JFrame("Indian Lotus");
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
            System.out.println("That's not a valid option...");
            break;
        }
      }
      else if(userInput.equals("3")){
        System.out.println("Proceeding behind the storecounter...");
        System.out.println("Would you like to...");
        System.out.println("1-Order Flowers");
        System.out.println("2-Change the Music");
        int choice=scanner.nextInt();
        switch(choice){
          case 1:
          System.out.println("Would you like to buy ...");
          System.out.println("1-Roses");
          System.out.println("2-Passion Flowers");
          System.out.println("3-Marigolds");
          System.out.println("4-Jasmines");
          System.out.println("5-Indian Lotuses");
          System.out.println("6-A bouquet");
          userInput=scanner.next();
          converted=Integer.parseInt(userInput);
          if(converted>0&&converted<6){
          System.out.println("How many would you like?");
          amount=scanner.nextInt();
        }
          //Learned how to implement image viewing from Alvin Alexander @ alvinalexander.com
          switch(userInput){
            case "1":
              value=roseStock.accept(new FlowerProcessingVisitor(),amount,shopKeeper.getMoney(),true);
              shopKeeper.transaction(-1*value);
              break;
            case "2":
              value=passionFlowerStock.accept(new FlowerProcessingVisitor(),amount,shopKeeper.getMoney(),true);
              shopKeeper.transaction(-1*value);
              break;
            case "3":
              value=marigoldStock.accept(new FlowerProcessingVisitor(),amount,shopKeeper.getMoney(),true);
              shopKeeper.transaction(-1*value);
              break;
            case "4":
              value=jasmineStock.accept(new FlowerProcessingVisitor(),amount,shopKeeper.getMoney(),true);
              shopKeeper.transaction(-1*value);
              break;
            case "5":
              value=indianLotusStock.accept(new FlowerProcessingVisitor(),amount,shopKeeper.getMoney(),true);
              shopKeeper.transaction(-1*value);
              break;
            }
            break;
          case 2:
            System.out.println("Would you like to...");
            System.out.println("1-Play The Song of Storms?");
            System.out.println("2-Play The Milk Bar Song?");
            System.out.println("3-Play The Wind Waker Theme?");
            System.out.println("4-Stop the music?");
            choice=scanner.nextInt();
            switch(choice){
              case 1:
                jam.stop();
                jam.play("songOfStorms.wav");
                break;
              case 2:
                jam.stop();
                jam.play("milkbar.wav");
                break;
              case 3:
                jam.stop();
                jam.play("windwaker.wav");
                break;
              case 4:
                jam.stop();
                break;
              default:
                System.out.println("That's not a valid option");
            }
            break;
          default:
            System.out.println("That's not a valid option...");
        }
      }
      else if(userInput.equals("4")){
        boolean validity=false;
        int lotteryPlayer;
        do{
        System.out.println("Are you the...");
        System.out.println("1-Customer");
        System.out.println("2-Shopkeeper");
        lotteryPlayer=scanner.nextInt();
        if(lotteryPlayer==1||lotteryPlayer==2){
          validity=true;
          Random rand = new Random();

          int  lottery = rand.nextInt(100) + 1;
          System.out.println("You've won $"+lottery+"!");
          if(lotteryPlayer==1){
            user.transaction(lottery);
          }
          else{
            shopKeeper.transaction(lottery);
          }
        }
      }while(validity==false);
      }
      else if(userInput.equals("5")){
        flag=false;
        System.out.println("Thank you, come again!");
        System.exit(1);
      }
      else{
        System.out.println("That's not a valid option!");
      }
      }while(flag);
    }
  }
