package stack;

public class TestPostFixEvaluator {
    public static void main(String[] args) {
        PostFixEvaluator evaluator = new PostFixEvaluator();
        System.out.println(evaluator.evaluate("2 3 + 4 *"));
        System.out.println(evaluator.evaluate("2 3 4 + *"));
        System.out.println(evaluator.evaluate("2 3 4 * +"));
        System.out.println(evaluator.evaluate("2 3 4 * + 5 -"));
        System.out.println(evaluator.evaluate("2 3 4 * + 5 - 6 /"));
        System.out.println(evaluator.evaluate("12 2 5 + - 4 * 2 /"));
    }
}
