package opgave2sortedlinkedlist;

public class TestSortedLinkedList {
    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();
        list.addElement("C");
        list.addElement("A");

        list.udskrivElements();
        System.out.println();

        list.addElement("B");
        list.udskrivElements();
        System.out.println();

        list.addElement("D");
        list.udskrivElements();
        System.out.println();

        System.out.println(list.countElements());
        System.out.println();

        System.out.println(list.removeLast());
        list.udskrivElements();
        System.out.println();

        System.out.println(list.removeElement("A"));
        list.udskrivElements();
        System.out.println(list.removeElement("C"));
        list.udskrivElements();
        list.addElement("A");
        list.addElement("C");
        System.out.println(list.removeElement("B"));
        list.udskrivElements();
        System.out.println();

        // OPG 4
        // Tidskompleksitet = O(n * m) for n og m lig de to listers længde
        SortedLinkedList list2 = new SortedLinkedList();
        list2.addElement("B");
        list2.addElement("A");
        list2.addElement("C");
        list2.addElement("E");
        list2.addElement("D");

        list.addAll(list2);
        list.udskrivElements();

        // OPG 5
        System.out.println("Normal count: " + list.countElements());
        System.out.println("Recursive count: " + list.countElementsRecursive());
    }
}
