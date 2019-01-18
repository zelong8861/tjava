import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

@FunctionalInterface
interface PrintMsg {

    void printMsg();

}


public class c01 {

    /**
     * 三个 boolean 两个为真 则结果为真
     */
    private static void testTrueFalse() {
        boolean a = true;
        boolean b = false;
        boolean c = false;

        boolean flag = a ? (b | c) : (b & c);

        System.out.println(flag);
    }

    private static boolean isValid(String embr) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < embr.length(); i++) {
            if (embr.charAt(i) == '{' || embr.charAt(i) == '[' || embr.charAt(i) == '(') {
                stack.push(embr.charAt(i));
            } else {

                if (stack.size() == 0) return false;

                char c = stack.peek();
                stack.pop();
                char match;
                switch (embr.charAt(i)) {
                    case ']':
                        match = '[';
                        break;
                    case '}':
                        match = '{';
                        break;
                    case ')':
                        match = '(';
                        break;
                    default:
                        return false;
                }

                if (match != c) return false;
            }
        }
        return true;
    }

    private static void testMerge() {
    }

    private static void execute(PrintMsg printer) {
        printer.printMsg();
    }

    private static void doCompute(lambdaFunc lambdaFunc) {
        lambdaFunc.compute();
    }

    public static void main(String[] args) {
        testTrueFalse();
        System.out.println(isValid("{[(}]}"));

        /*
         *
         * lambda function
         *
         * */

        execute(new PrintMsg() {
            @Override
            public void printMsg() {
                System.out.println("hello world");
            }
        });

        execute(() -> System.out.println("world hello"));

        execute(() -> System.out.println("hello world !!!!!"));

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        list.forEach(n -> {
            if (n % 2 == 0) System.out.println("偶数是：" + n);
        });

        List<String> listStr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            listStr.add("bob" + String.valueOf(i));
        }

        listStr.forEach(n -> System.out.println(n.substring(0, 3)));

    }
}