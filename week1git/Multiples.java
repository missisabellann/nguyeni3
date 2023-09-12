public class Multiples {
    public static int main(int n, int a, int b) {
        int count = 0;
        for(int i=1; i<n; i++){
            if ((i%a == 0) || (i%b == 0)){
                count++;
            }
        }
        return count;
    }

    public static int fixedMultiples(int n=1000, int a=3, int b = 5){
        int count = 0;
        for(int i=1; i<n; i++){
            if ((i%a == 0) || (i%b == 0)){
                count++;
            }
        }
        return count;
    }
}
