package LinkedLists.LinkedList3.LinkedList2;


class Node<T>{
    T data;
    Node<T> next;
    Node(T data){
        this.data=data;
    }
    Node(T data,Node<T> next){
        this.data=data;
        this.next=next;
    }     
    }
public class LinkedList<T>{
    private Node<T> head;

    public void Insert(T x){
    if(head==null){
        head = new Node<T>(x,head);
        return;
    }
    Node<T> p = head;
    while(p.next!=null){
        p=p.next;
    }
    p.next = new Node<T>(x,p.next);
    }

    public void InsertAtIndex(T ele, int index){
        if(index<=0||head==null){
            head= new Node<T>(ele, head);
            return;
        }
        Node<T> p = head;
        int i=1;
        while(p.next!=null){
            if(i==index){
                break;
            }
            p=p.next;
            i++;
        }
        p.next = new Node<T>(ele, p.next);
    }

    public void ReplaceByIndex(T element,int index){
        if(head==null){
            return;
        }else if(head!=null&&index<=0){
            head = new Node<T>(element,head.next);
            return;
        }
        Node<T> p = head;
        int i = 1;
        boolean flag = false;
        while(p.next!=null){
            if(i==index){
                flag = true;
                break;
            }
            p = p.next;
            i++;
        }
        if(flag){
            p.next = new Node<T>(element, p.next.next);
            return;
        }
    }
    public void ReplaceByValue(T element,T value){
        if(head==null){
            return;
        }else if(head.data==value){
            head = new Node<T>(element,head.next);
            return;
        }
        Node<T> p = head;
        boolean flag = false;
        while(p.next!=null){
            if(p.next.data==value){
                flag = true;
                break;
            }
            p = p.next;
        }
        if(flag){
            p.next = new Node<T>(element, p.next.next);
            return;
        }
    }
    public void concate(LinkedList<T> l2){
        if(this.head==null && l2.head==null){
        return;
        }else if(this.head==null){
            this.head=l2.head;
            return;
    }else if(l2.head==null){
            return;
    }Node<T> p = this.head;
        while(p.next!=null){
            p=p.next;
        }
            p.next=l2.head;
            return;
    }
    public int size(){
        if(this.head==null){
            return 0;
        }
        Node<T> p = this.head;
        int size=1;
        while(p.next!=null){
            p=p.next;
            size++;
        }
        return size;
    }
    
    public void LinkedListToArray(T arr[]){
        if(this.head==null){
            return;
        }
        int ind=0;
        for(Node<T> q=this.head;q!=null;q=q.next){
            arr[ind++]=q.data;
        }
    }
    public void Duplicate(LinkedList<T> l){
        if(l.head==null){
            return;
        }
        this.head=l.head;
        
    }
    public void DeleteByValue(T value){
        if(head.data==value){
           head=head.next;
        }
        Node<T> p = head;
        while(p.next!=null){
            if(value==p.next.data){
                p.next=p.next.next;
                break;
            }
            p=p.next;
        }
    }
    public void DeleteByIndex(int pos){
        if(pos==0){
            head=head.next;
            return;
        }
        Node<T> p= head; int i=1;
        while(p.next!=null){
            if(i==pos){
                p.next=p.next.next;
                break;
            }
            p=p.next;
            i++;
        }
        return;
    }
    public void ArrayToLinkedList(T arr[]){
        if(arr.length==0){
            return;
        }
        head = new Node<T>(arr[0]); 
        int i=1;
        Node<T> p = head;
        while(i!=arr.length){
              p.next = new Node<T>(arr[i]);
              i++; p=p.next;
       
        }
    }
    // public void InsertString(String data){
    //     for(int i=0;i<data.length();i++){
    //         Insert(data.charAt(i));
    //     } 
    // }

    public void PrintList(){
        for(Node<T> p = head;p!=null;p=p.next){
            System.out.println(p.data);
        }
    }
}
