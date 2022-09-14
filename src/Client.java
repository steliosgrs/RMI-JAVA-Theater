public class Client implements java.io.Serializable {

   String type;
   int number;
   String name;
   int ticket_price;

   public Client(String type, int number,String name,int ticket_price){
       this.type=type;
       this.number=number;
       this.name=name;
       this.ticket_price=ticket_price;
   }
}
