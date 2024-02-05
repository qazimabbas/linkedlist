package LinkedLists.LinkedList1;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
   
        
    }
class Node2{
    char data;
    Node2 next;
    Node2(char data,Node2 next){
        this.data=data;
        this.next=next;
    }
    
}
class LinkedList {
    private Node head;
    private Node2 head2;
    public void Insert(int data){
        if(head==null){
            head=new Node(data,head);
            return;
        }
        Node p=head;
        while(p.next!=null){
            p=p.next;
        }
        p.next = new Node(data,p.next);
    }
    public void InsertChar(char data){
        if(head2==null){
            head2=new Node2(data,head2);
            return;
        }
        Node2 p = head2;
        while(p.next!=null){
            p=p.next;
        }
        p.next = new Node2(data, p.next);
    }

    public void InsertSorted(int n){
        if(head==null || head.data>n ){
            head=new Node(n,head);
            return;
        }
        Node p=head;
        while(p.next!=null){
            if(p.next.data>n){
               break;
            }
            p=p.next;
        }
        p.next=new Node(n, p.next);
    }
    public void InsertAtIndex(int ele, int index){
        if(index<=0||head==null){
            head= new Node(ele, head);
            return;
        }
        Node p = head;
        int i=1;
        while(p.next!=null){
            if(i==index){
                break;
            }
            p=p.next;
            i++;
        }
        p.next = new Node(ele, p.next);
    }
    public void ReplaceByIndex(int element,int index){
        if(head==null){
            return;
        }else if(head!=null&&index<=0){
            head = new Node(element,head.next);
            return;
        }
        Node p = head;
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
            p.next = new Node(element, p.next.next);
            return;
        }
        
    }
    public void ReplaceByValue(int element,int value){
        if(head==null){
            return;
        }else if(head.data==value){
            head = new Node(element,head.next);
            return;
        }
        Node p = head;
        boolean flag = false;
        while(p.next!=null){
            if(p.next.data==value){
                flag = true;
                break;
            }
            p = p.next;
        }
        if(flag){
            p.next = new Node(element, p.next.next);
            return;
        }
        
    }
    public void Sortlist(){
        if(this.head==null){
            return;
        }
        int temp;
        for(Node p=this.head;p.next!=null;p=p.next ){
            for(Node q=this.head;q.next!=null;q=q.next){
                if(q.data>q.next.data){
                    temp=q.data;
                    q.data=q.next.data;
                    q.next.data=temp;
                }
            }
        }
    }
    public void concate(LinkedList l1, LinkedList l2){
        if(l1.head==null && l2.head==null){
        return;
        }else if(l1.head==null){
    if(this.head==l1.head ){
            l1.head=l2.head;
            return;
            }return;
    }else if(l2.head==null){
    if(this.head==l2.head ){
        l2.head=l1.head;
        return;
        }return;
    }Node p = this.head;
        while(p.next!=null){
            p=p.next;
        }if(this.head==l1.head){
            p.next=l2.head;
            return;
        } p.next=l1.head;
    }
    
    public void concate2(LinkedList l1, LinkedList l2){
       Node p = l1.head;
       Node q = l2.head;
       Node temp = this.head;
       if(p==null && q==null){
            return;  
       }else if(temp==q){
            if(temp==null){
                l2.head=l1.head;
                return;
            }
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=p;
            return;
       }else if(temp==p){
        if(temp==null){
            l1.head=l2.head;
            return;
        }
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=q;
        return;
       }

    }
    public void SortedConcate(LinkedList l1, LinkedList l2){
        if(l1.head==null && l2.head==null){
            return;
        }else if(l1.head==null){
            if(this.head==l1.head){
                l1.head=l2.head;
                Sortlist();
                return;
            }
            Sortlist();
            return;
        }else if(l2.head==null){
            if(this.head==l2.head){
                l2.head=l1.head;
                Sortlist();
                return;
            }
            Sortlist();
            return;
        }
        Node p = this.head;
        while(p.next!=null){
            p=p.next;
        }
        if(this.head==l1.head){
            p.next=l2.head;
            Sortlist();
            return;
        }
        p.next=l1.head;
        Sortlist();
    }
    public int size(){
        if(this.head==null){
            return 0;
        }
        Node p = this.head;
        int size=1;
        while(p.next!=null){
            p=p.next;
            size++;
        }
        return size;
    }

    public int[] LinkedListToArray(){
        if(this.head==null){
            return null;
        }
        int arr[] = new int[size()];
        int ind=0;
        for(Node q=this.head;q!=null;q=q.next){
            arr[ind++]=q.data;
        }
        return arr;
    }
    public void Duplicate(LinkedList l){
        if(l.head==null){
            return;
        }
        this.head=l.head;
        
    }
    public void DeleteByValue(int value){
        if(head.data==value){
           head=head.next;
        }
        Node p = head;
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
        Node p= head; int i=1;
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
    public void PrintList(){
        for(Node p=head;p!=null;p=p.next){
            System.out.println(p.data);
        }
    }
    public void PrintCharList(){
        for(Node2 p=head2;p!=null;p=p.next){
            System.out.print(p.data);
        }
        System.out.println();
    }
  
    public void ArrayToLinkedList(int arr[]){
        if(arr.length==0){
            return;
        }
        head = new Node(arr[0]); 
        int i=1;
        Node p = head;
        while(i!=arr.length){
              p.next = new Node(arr[i]);
              i++; p=p.next;
       
        }
    }
    public void InsertString(String data){
        for(int i=0;i<data.length();i++){
            InsertChar(data.charAt(i));
        } 
    }
    public void EvenNodesList(LinkedList l1){
        if(l1.head2==null){
            return;
        }
        this.InsertChar(l1.head2.data);
        Node2 p = l1.head2;
        int i=1;
        while(p.next!=null){
            if(i%2==0){
                this.InsertChar(p.next.data);   
            }
            i++;
            p=p.next;

        }
    }
    public void OddNodesList(LinkedList l1){
        if(l1.head2==null){
            return;
        }
        Node2 p = l1.head2;
        int i=1;
        while(p.next!=null){
            if(i%2!=0){
                this.InsertChar(p.next.data);   
            }
            i++;
            p=p.next;

        }
    }
    public void Merge(LinkedList even,LinkedList odd){
        if(even.head2==null && odd.head2==null){
            return;
        }else if(even.head2==null){
            this.head2=odd.head2;
            return;
        }else if(odd.head2==null){
            this.head2=even.head2;
            return;
        }
        Node2 e = even.head2;
        Node2 o = odd.head2;
        int i=0;
        while(e!=null || o!=null){
              if(i%2==0){
                this.InsertChar(e.data);
                e=e.next;
              }else if(i%2!=0){
                this.InsertChar(o.data);
                 o=o.next;
              }
              i++;
        }

    }


    
}

