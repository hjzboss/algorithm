package Stack;

import java.util.Scanner;

public class postorder {//将中缀表达式转换为后缀表达式
    public static void main(String[] args) {
        stack<String> operator = new stack<>(10);

        System.out.println("请输入中缀表达式((1+2)*(2+3))：");
        Scanner in = new Scanner(System.in);
        while(!in.hasNext("#")){
            String next = in.next();
            switch (next){
                case "-":
                case "*":
                case "/":
                case "+":operator.push(next);break;
                case "(":
                    System.out.print("");
                    break;
                case ")":
                    System.out.print(operator.pop());
                    break;
                default:
                    System.out.print(next);
                    break;
            }
        }
    }
}
