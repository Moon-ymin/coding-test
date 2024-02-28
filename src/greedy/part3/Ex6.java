package greedy.part3;
// https://kk-programming.tistory.com/13
// https://github.com/ndb796/python-for-coding-test/blob/master/11/6.java
public class Ex6 {
    public static void main(String[] args) {
        int answer = 0;
        int[] food_times = {3, 1, 2};
        long k = 5;
        int loops=0;
        int n = 0;

        for(int i=0; i<k; i=i+loops) {
            for(int j=0; j<food_times.length; j++){
                if ( food_times[j] != 0 ) {
                    food_times[j]--;
                    n = j;
                }
            }

            loops = loops + food_times.length;
        }
        int result = 0;
        switch (n) {
            case 0:
                if ( food_times[1] != 0 ) { result = 2; break; }
                else if ( food_times[2] != 0 ) { result = 3; break; }
                else if ( food_times[0] != 0 ) { result = 1; break; }
                else { result = -1; break; }
            case 1:
                if ( food_times[2] != 0 ) { result = 3; break; }
                else if ( food_times[0] != 0 ) { result = 1; break; }
                else if ( food_times[1] != 0 ) { result = 2; break; }
                else { result = -1; break; }
            case 2:
                if ( food_times[0] != 0 ) { result = 1; break; }
                else if ( food_times[1] != 0 ) { result = 2; break; }
                else if ( food_times[2] != 0 ) { result = 3; break; }
                else { result = -1; break; }
        }
        System.out.println(result);
    }
}
