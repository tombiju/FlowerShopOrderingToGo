/*Class to create user and shopkeeper with**/
public class Person{
  private String name;
  private double money;
  public Person(String name, double money){
    this.name=name;
    this.money=money;
  }
  public String getName(){
    return name;
  }
  public double getMoney(){
    return money;
  }
  public void transaction(double money){
    this.money+=money;
    //System.out.println(getName()+" now has $"+getMoney());
  }
}
