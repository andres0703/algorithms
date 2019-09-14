package codechef;

public class EasyFibbonacci {
    public int fib(long N) {
        int[] arr = new int[60];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        long a = 1, b = 1, c = 2;
        for (int i = 3; i < 60; i++) {
            c = a + b;
            a = b;
            b = c;

            arr[i] = (int) (c % 10);
        }

        int count = 0;
        while (Math.pow(2, count + 1) < N) {
            count++;
        }

        int idx = (int) (Math.pow(2, count) % 60L) - 1;
        System.out.println(idx);

        return arr[idx];
    }

    public static void main(String[] args) {
        EasyFibbonacci easyFibbonacci = new EasyFibbonacci();
        System.out.println(easyFibbonacci.fib(866337779898053L));

    }
}

/*
                     7
         3           7           1
   1     3     5     7     9     1     3
0  1  2  3  4  5  6  7  8  9  0  1  2  3  4

0
1
1
3
3
5
5

kth number, where k is











                                                                                                                  31
                                                  15                                                              31
                     7                            15                              23                              31
         3           7            11              15              19              23              27              31              35
   1     3     5     7     9      11      13      15      17      19      21      23      25      27      29      31      33      35      37
0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18  19  20  21  22  23  24  25  26  27  28  29  30  31  32  33  34  35  36  37

27

0  1  1  2
0  1  2  3
   1     3
         3

 */


/*
1 4 2 5 7 9 1 4 2 5 7 9 1 4 2 5 7 9

4 5 9 4 5 9 4 5 9
 */

/*

12

1 3 5 7 9 11 13 15 17 19
3 7 9 11 15 19
7 11 19

66
64
4



1050
1024
1024 % 60
4

1050 ?
1. find the nearest lower power of 2 (1024)
2. mod 60 (4)
3. fib[4]




 */
