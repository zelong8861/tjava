import java.util.Stack;

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

    private static void testMerge () {
    }

    public static void main(String[] args) {
       // testTrueFalse();
        System.out.println(isValid("{[(}]}"));
    }
}