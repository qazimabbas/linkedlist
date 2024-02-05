package LinkedLists.LinkedList3;

public class Main {
    public static void main(String[] args) {
        linklist l1 = new linklist();
        l1.insertAtEnd(1);
        l1.insertAtEnd(1);
        l1.insertAtEnd(2);
        l1.insertAtEnd(2);
        l1.insertAtEnd(3);
        l1.insertAtEnd(3);
        
        l1.Pairtosingle3();
        l1.printList();
    }
    
}
