public class Reduce {
    public static int main(int n) {
        int count = 0;
        while (n>0){
            if (n%2 == 0){
                n = n/2;
            } else {
                n-=1;
            }
            count++;
        }
        return count;
    }
}
