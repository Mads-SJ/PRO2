package opgave3sortedlinkelistdouble;

public class TestSortedLinkedListDouble {
    public static void main(String[] args) {
        SortedLinkedListDouble list = new SortedLinkedListDouble();
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
        list.udskrivBagfra();
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

        System.out.println(list.countElements());
        list.udskrivBagfra();
    }
}
