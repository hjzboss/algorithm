package test;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        long a1 = cin.nextInt();
        long a2 = cin.nextInt();

        long temp;
        int i = 10;
        for (; i > 0; i--) {
            temp = a1 * a2;
            if(a1 > 0 && a2 >0){
                if(temp < a1 || temp < a2){
                    break;
                }
            }
            if(a1 < 0 && a2 > 0){
                if(temp > 0){
                    break;
                }else{
                    long tmp = -temp;
                    long a = -a1;
                    if(tmp < a || tmp < a2){
                        break;
                    }
                }
            }
            if(a1 > 0 && a2 < 0){
                if(temp > 0){
                    break;
                }else{
                    long tmp = -temp;
                    long a = -a2;
                    if(tmp < a || tmp < a1){
                        break;
                    }
                }
            }
            if(a1 < 0 && a2 < 0){
                if(temp < 0) break;
                long tmp = -temp;
                if(tmp > a1 || tmp > a2){
                    break;
                }
            }
            if (temp < 10000 && temp > -10000) {
                if (i == 10) {
                    System.out.print(temp);
                } else {
                    System.out.print(" " + temp);
                }
            } else {
                break;
            }
            a1 = a2;
            a2 = temp;
        }
        for (; i > 0; i--) {
            if (i == 10) {
                System.out.print(0);
            }
            else System.out.print(" " + 0);
        }
        System.out.println();
    }
}
