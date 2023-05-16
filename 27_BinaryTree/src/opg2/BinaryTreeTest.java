package opg2;

import binartreestuderende.BinaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer> t1 = new BinaryTree<>(11);
        BinaryTree<Integer> t2 = new BinaryTree<>(15, t1, null);

        BinaryTree<Integer> t3 = new BinaryTree<>(25);
        BinaryTree<Integer> t4 = new BinaryTree<>(30, t3, null);

        BinaryTree<Integer> t5 = new BinaryTree<>(22, t2, t4);

        BinaryTree<Integer> t6 = new BinaryTree<>(88);
        BinaryTree<Integer> t7 = new BinaryTree<>(90, t6, null);
        BinaryTree<Integer> t8 = new BinaryTree<>(77, null, t7);

        BinaryTree<Integer> t9 = new BinaryTree<>(45, t5, t8);

        System.out.println(t9.size());
        System.out.println(t9.height());
        System.out.println("Preorder:");
        t9.printPreorder();
        System.out.println("Inorder:");
        t9.printInorder();
        System.out.println("Postorder:");
        t9.printPostorder();
        System.out.println("Sum: " + t9.sum());
    }
}
