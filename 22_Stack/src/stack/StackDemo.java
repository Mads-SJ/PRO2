package stack;

public class StackDemo {
    public static void main(String[] args) {
      //  StackI s = new NodeStack();
       //  StackI s = new ArrayStack(5);
        StackI s = new ArrayListStack();
        s.push("Tom");
        s.push("Diana");
        s.push("Harry");
        s.push("Thomas");
        s.push("Bob");
        s.push("Brian");
        System.out.println(s.peek());
        System.out.println(s.isEmpty() + " " + s.size());
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
        System.out.println();
        System.out.println(s.isEmpty() + " " + s.size());
        System.out.println();
        
        // -------- test af reverse --------
        
//        Integer[] tal = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//        reverse(tal);
//        for (int i = 0; i < tal.length; i++) {
//            System.out.print(tal[i] + " ");
//        }
        System.out.println();
        System.out.println(checkParentheses("(3+{5{99{*}}[23[{67}67]]})"));
        System.out.println(checkParentheses("(}){"));
    }
    
    public static void reverse(Object[] tabel) {
        StackI stack = new ArrayStack(tabel.length);
        // StackI stack = new NodeStack();
        for (int i = 0; i < tabel.length; i++) {
            stack.push(tabel[i]);
        }
        int i = 0;
        while (!stack.isEmpty()) {
            tabel[i] = stack.pop();
            i++;
        }
    }

    public static boolean checkParentheses(String s){
        StackI stack = new ArrayStack(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if(c == ')' || c == '}' || c == ']') {
                if(stack.isEmpty()){
                    return false;
                }
                char top = (char) stack.pop();
                if (c == ')' && top != '('
                        || c == '}' && top != '{'
                        || c == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
