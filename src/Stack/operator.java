package Stack;

import java.util.Scanner;
/*中缀表达式求值*/
public class operator {
    public static void main(String[] args) {
        stack<String> operator = new stack<>(20);
        stack<Double> operands = new stack<>(20);

        System.out.println("请输入运算式(格式如: ( 1 + 2 ) #)：");
        Scanner in = new Scanner(System.in);
        while(!in.hasNext("#")){//输入#结束
            String next = in.next();
            switch (next){
                case "(":break;
                case "+":
                case "-":
                case "*":
                case "/":operator.push(next);break;
                case ")":{
                    double value1 = operands.pop();
                    double value2 = operands.pop();
                    String op = operator.pop();
                    switch (op){
                        case "+":operands.push(value2+value1);break;
                        case "-":operands.push(value2-value1);break;
                        case "*":operands.push(value2*value1);break;
                        case "/":operands.push(value2/value1);break;
                    }
                }break;
                default:operands.push(Double.parseDouble(next));break;
            }
        }
        System.out.println("运算结果是："+operands.pop());
    }
}
