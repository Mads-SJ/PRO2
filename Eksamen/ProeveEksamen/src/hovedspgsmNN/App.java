package hovedspgsmNN;

public class App {
    public static void main(String[] args) {
        BinaryTree<String> n2 = new BinaryTree<>("2");
        BinaryTree<String> n4 = new BinaryTree<>("4");
        BinaryTree<String> n7 = new BinaryTree<>("7");
        BinaryTree<String> n3 = new BinaryTree<>("3");
        BinaryTree<String> n8 = new BinaryTree<>("8");
        BinaryTree<String> nPlus1 = new BinaryTree<>("+", n2, n4);
        BinaryTree<String> nTimes = new BinaryTree<>("*", nPlus1, n7);
        BinaryTree<String> nPlus2 = new BinaryTree<>("+", n3, n8);
        BinaryTree<String> rootPlus = new BinaryTree<>("+", nTimes, nPlus2);

        System.out.println(rootPlus.countElement("+"));
        System.out.println();

        rootPlus.printInorder();
        System.out.println();

        System.out.println(rootPlus.value());
    }
}
