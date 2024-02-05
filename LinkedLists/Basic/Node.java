package LinkedLists.Basic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class Node {
    int data;
    Node next;
    String alpha;
    Node(){

    }
    Node (Node next, int data){
        this.next = next;
        this.data = data;
    }
    Node (Node next, String alpha){
        this.next = next;
        this.alpha = alpha;
    }
    public static Node Insert(Node head, int x){
        if(head==null||head.data>x){
            head = new Node(head,x);
            return head;
        }
        Node p = head;
        while(p.next!=null){
            if(p.next.data>x){
                break;
            }
            p=p.next;
        }
       
        p.next = new Node(p.next, x);
        return head;
    }
    public static Node Delete(Node head, int x){
        if(head==null||head.data>x){
            return head;
        }else if(head.data==x){
            return head.next;
        }
        for(Node p = head; p!=null; p = p.next){
            if(p.next==null||p.next.data>x){
                break;
            }else if(p.next.data==x){
                p.next = p.next.next;
                break;
            }
        }
        return head;
    }
    public static Node Replace(Node head,String alpha,int pos){
        if(pos==0){
            head = new Node(head, alpha);
            return head;
        }
        int counter = 1;
        Node p = head;
        while(p.next!=null){
            if(counter==pos){
                break;
            }
            p = p.next;
            counter++;
        }
        p.next = new Node(p.next, alpha);
        return head;

    }
    public static Node concate(Node head1,Node head2){
          Node p=head1;
          Node q=head2;
          if(p==null && q==null){
            return null;
          }else if(p==null){
            return q;
          }else if(q==null){
            return p;
          }while(p.next!=null){
            p=p.next;
          }
          p.next=q;
          return head1;
    }
    public static int[] LinkedListToArray(Node head){
        if(head==null){
            return null;
        }
        int size =1;
        Node p = head;
        while(p.next!=null){
            size++;
            p=p.next;
        }
        
        int arr[] = new int[size];
        int i=0;
        for(Node q=head;q!=null;q=q.next){

            arr[i]=q.data;
            i++;
        }
        return arr;
    }
    public static void  DeleteIndex(Node head,int pos){
        Node p=head;
        int i=1;
         if(pos==0){
            head=null;
            head.data=-5;
            // System.out.println(head.data);
                return;
            }else{
            while(p.next!=null){
            if(i==pos){
                p.next=p.next.next;
                break;
             }
             i++;
             p=p.next;
        }
        return;
    }
    }
   

    public static void main(String[] args) {
        Node head1 = null;
        Node head2 = null;
        head1=Node.Insert(head1, 5);
        head1=Node.Insert(head1, 2);
        head1=Node.Insert(head1, 4);
        head1=Node.Insert(head1, 3);
        head1=Node.Insert(head1, 1);
        
        head2=Node.Insert(head2, 6);
        head2=Node.Insert(head2, 7);
        head2=Node.Insert(head2, 9);
        head2=Node.Insert(head2, 10);
        head2=Node.Insert(head2, 8);

        head1=Node.concate(head1, head2);
        head1 = Node.Delete(head1, 6);
        System.out.println(head1.data);
        // int arr[];
        // arr=Node.LinkedListToArray(head1);
        // System.out.println("Loop of array");
        // for(int i=0; i<arr.length;i++){
        //     System.out.println(arr[i]);
        // }
        System.out.println("Loop of linkedlist");
        for(Node p=head1;p!=null;p=p.next){
            System.out.println(p.data);
           
        } 
    }

}
