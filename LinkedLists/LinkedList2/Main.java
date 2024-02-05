package LinkedLists.LinkedList3.LinkedList2;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> l1 = new LinkedList<>();
        LinkedList<String> l2 = new LinkedList<>();
        l1.Insert("My name is kazim abbas soomro");
        l1.Insert("I am a professional web developer");
        l1.InsertAtIndex("And an app developer",2);
        l1.ReplaceByValue("Replaced by value", "And an app developer");
        l1.ReplaceByIndex("Replaced by index ", 3);
        l2.Insert("This is something from linkedlist l2");
        l2.Insert(" 2 This is something from linkedlist l2");
        l2.Insert(" 3 This is something from linkedlist l2");
        
        l2.concate(l1);
        l2.DeleteByIndex(6);
        


        String arr[] = new String[l2.size()];
        l2.LinkedListToArray(arr);
        // for(int i=0;i<arr.length;i++){
        //     System.out.println(arr[i]);
        // }

        l1.ArrayToLinkedList(arr);
        l1.PrintList();

        // l1.Duplicate(l2);
        // l1.PrintList();


        

    }
    
}
