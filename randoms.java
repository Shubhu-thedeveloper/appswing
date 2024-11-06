import java.util.Random;
public class randoms {
    public static void main(String[] args) {
        Random r = new Random();
        while(true){
            int r1 = (r.nextInt(10)%2);
            System.out.println(r1%2);
            // if(r1 == 1){
            //     break;
            // }
            ;
            
        }
    }
}
