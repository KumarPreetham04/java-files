public class sts3 {
    public static String swapString(String str,int i,int j){
        char[] s = str.toCharArray();
        char ch;
        ch = s[j];
        s[i]=s[j];
        s[j]=ch;
        return String.valueOf(s);
    }

    public static void generatePermutation(String str,int start,int end){
        if(start == end-1){
            System.out.println(str);
        }
        else{
            for(int i = start;i<end;i++){
                str = swapString(str,start,i);
                generatePermutation(str,start+1,end);
                str = swapString(str,start,i);
            }
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
        int len = str.length();
        System.out.println("All the permutations of the string are: ");
        generatePermutation(str, 0, len);
    }
}