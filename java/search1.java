import java.util.Scanner;

public class search1{

    public static void  main(String [] args) {
        String [] array = {"1","2","3","4","5"};

        Scanner inp = new Scanner(System.in);
        System.out.print("enter input");
        String target=inp.nextLine();

        int result = linearSearch(array,target);

        if (result == -1){
            System.out.println("String not present in array");
        }
        else{
         System.out.println("count :" + result);
        }
    }
        public static int linearSearch(String[] array , String[] target){
            for(int i=0;i<(array.length);i++){
                if (array[i].equals(target)){
                return i;
            }
        }
        return -1;

    }
        
    
}

