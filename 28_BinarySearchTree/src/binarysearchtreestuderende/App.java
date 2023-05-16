package binarysearchtreestuderende;

public class App {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bsTree = new BinarySearchTree<>();
        bsTree.add(45);
        bsTree.add(22);
        bsTree.add(11);
        bsTree.add(15);
        bsTree.add(30);
        bsTree.add(25);
        bsTree.add(77);
        bsTree.add(90);
        bsTree.add(88);

        bsTree.print();
        System.out.println("Max: " + bsTree.findMax());
        System.out.println("Min: " + bsTree.findMin());
        System.out.println();

        System.out.println(bsTree.removeMin());
        System.out.println(bsTree.removeMin());
        System.out.println(bsTree.removeMin());
        bsTree.print();
    }
}
