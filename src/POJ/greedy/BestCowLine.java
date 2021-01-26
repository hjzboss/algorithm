package POJ.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * FJ is about to take his N (1 <= N <= 30,000) cows to the annual "Farmer of the Year" competition.
 * In this contest every farmer arranges his cows in a line and herds them past the judges.
 * <p>
 * The contest organizers adopted a new registration scheme this year:
 * simply register the initial letter of every cow in the order they will appear (e.g.,
 * If FJ takes Bessie, Sylvia, and Dora in that order, he just registers BSD).
 * After the registration phase ends, every group is judged in increasing lexicographic order
 * (i.e., alphabetical order) according to the string of the initials of the cows' names.
 * <p>
 * FJ is very busy this year and has to hurry back to his farm,
 * so he wants to be judged as early as possible. He decides to rearrange his cows,
 * who have already lined up, before registering them.
 * <p>
 * FJ marks a location for a new line of the competing cows.
 * He then proceeds to marshal the cows from the old line to the new one by
 * repeatedly sending either the first or last cow in the (remainder of the) original line
 * to the end of the new line. When he's finished, FJ takes his cows for registration in this new order.
 * <p>
 * Given the initial order of his cows, determine the least lexicographic string of initials
 * he can make this way.
 * 输入
 * * Line 1: A single integer: N
 * <p>
 * * Lines 2..N+1: Line i+1 contains a single initial ('A'..'Z') of the cow in the ith position in the original line
 * 输出
 * The least lexicographic string he can make.
 * Every line (except perhaps the last one) contains the initials of 80 cows ('A'..'Z') in the newline.
 * 样例输入
 * 6
 * A
 * C
 * D
 * B
 * C
 * B
 * 样例输出
 * ABCBCD9
 */
public class BestCowLine {
    private static int N;
    private static char[] s = new char[N];
    private static int count;

    /**
     * 目标是构建字典序尽可能小的字符串
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        N = cin.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            builder.append(cin.next());
        }
        s = builder.toString().toCharArray();

        solve();
    }

    public static void solve() {
        int a = 0, b = N - 1;
        count = 0;
        while (a <= b) {
            boolean left = false;
            for (int i = 0; a + i <= b; i++) {
                if (s[a + i] < s[b - i]) {
                    left = true;
                    break;
                } else if (s[a + i] > s[b - i]) {
                    left = false;
                    break;
                }
            }
            if (left) System.out.print(s[a++]);
            else System.out.print(s[b--]);
            count++;
            if(count >= 80) {
                count = 0;
                System.out.println();
            }
        }
        System.out.println();
    }
}
