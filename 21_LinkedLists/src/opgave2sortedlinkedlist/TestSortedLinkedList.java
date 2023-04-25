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
    }
}
