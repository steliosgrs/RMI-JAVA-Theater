import java.util.ArrayList;
public class Theater {

    int[] cost = new int[5];
    int[] seats = new int[5];

    protected Theater(){

        // Θέσεις θεάτρου
        seats[0] = 200;
        seats[1] = 300;
        seats[2] = 500;
        seats[3] = 100;
        seats[4] = 50;

        // Κόστος κάθε θέσης
        cost[0] = 50;
        cost[1] = 40;
        cost[2] = 30;
        cost[3] = 25;
        cost[4] = 20;
    }



    public int getCost(String Type){
        int temp;
        switch (Type) {
            case "ΠΑ": temp = cost[0]; break;
            case "ΠΒ": temp = cost[0]; break;
            case "ΠΓ": temp = cost[0]; break;
            case "ΚΕ": temp = cost[0]; break;
            case "ΠΘ": temp = cost[0]; break;
        }
        return temp;
    }


    public int if_available(String Type, int Number){
        if (seats[0]>Number) {
            return 1;
        }else if (seats[1]>Number) {
            return 1;
        }else if (seats[2]>Number) {
            return 1;
        }else if (seats[3]>Number) {
            return 1;
        }else if (seats[4]>Number) {
            return 1;
        }else {
            return 0;
        }
    }

}
