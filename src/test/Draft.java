package test;

import java.util.Scanner;

/**
 * @author hjz
 * @version 1.0
 * @date 2021/4/7 22:58
 */
public class Draft {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        int fistA, fistB, shoutA, shoutB, sumA = 0, sumB = 0;
        int temp;
        while(n > 0) {
            shoutA = cin.nextInt();
            fistA = cin.nextInt();
            shoutB = cin.nextInt();
            fistB = cin.nextInt();
            cin.nextLine();
            temp = shoutA + shoutB;
            if(fistA != fistB) {
                if(fistA == temp) sumB++;
                if(fistB == temp) sumA++;
            }
            n--;
        }

        System.out.print(sumA + " " + sumB);
    }
}
