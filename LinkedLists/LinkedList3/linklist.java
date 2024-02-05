package LinkedLists.LinkedList3;


public class linklist {
    private Node head;
    class Node{
    Node next; 
    Object data;
    Node(Object data,Node next){
        this.data = data;
        this.next = next;
    }
    Node(Object data){
        this.data = data;
    }
    }
    public void insertAtEnd(Object data){
        if(head==null){
            head=new Node(data,head);
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next = new Node(data,temp.next);
    }
    public void insertAtFirst(Object data){
        head=new Node(data,head);
    }
    public void insertAtIndex(Object data, int index){
        if(head==null || index==1){
            head = new Node(data,head);
            return;
        }
        int i = 2;
        Node temp = head;
        while(temp.next!=null){
            if(index==i){
                break;
            }
            temp = temp.next;
            i++;
        }
        temp.next = new Node(data,temp.next);
    }
    public void ReplaceByIndex(Object data, int index){
        if(head==null){
            head = new Node(data,head);
            return;
        }else if(index==1){
            // head.data = data; kar sakta hu but is tareqa sa nahe karna mujhe
            head = new Node(data,head.next);
            return;
        }
        Node temp = head; 
        int i = 2;
        while(temp.next!=null){
            if(i==index){
                break;
            }
            temp = temp.next;
            i++;
        }
        if(temp.next!=null){
            temp.next = new Node(data,temp.next.next);
        }
        // temp.next = new Node(data,temp.next);//ye sahe ha but nahe karna esa
    }
    public void ReplaceByValue(Object data, Object val){
        if(head==null){
            head = new Node(data,head);
            return;
        }else if(head.data==val){
            head = new Node(data,head.next);
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            if(temp.data==val){
                break;
            }
            temp = temp.next;
        }
        if(temp.next!=null){
            temp.next = new Node(data,temp.next.next);
        }
    }
    public void concate(linklist l){
        if(l.head==null && this.head==null){
            return;
        }else if(this.head==null){
        head = l.head;
        return;
       }else if(l.head == null){
        l.head = this.head;
        return;
       }
       Node temp = l.head;
       while(temp.next!=null){
        temp= temp.next;
       }
       temp.next = l.head;
    }
    public int size(){
        if(this.head==null){
            return 0;
        }
        int i = 1;
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
            i++;
        }
        return i;
    }
    public void Duplicate(linklist l){
        if(l.head==null){
            return;
        }
            this.head=l.head;
    }
    public void deletefirst(){
        head = head.next;
    }
    public void deletelast(){
        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next = null;

    }
    public void deletebyValue(Object val){
        if(head.data==val){
            head = head.next;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            if(val==temp.next.data){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
    public void deletebyIndex(int ind){
        if(head==null){
            return;
        }else if(ind==1){
            head = head.next;
            return;
        }
        Node temp = head;
        int i = 2;
        while(temp.next!=null){
            if(i==ind){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
            i++;
        }
    }
    public void ArrayToNewLinkedList(Object arr[]){
        if(arr.length==0){
            return;
        }
        int i=0;
        this.head=new Node(arr[i++]);
        while(i<arr.length){
            this.insertAtEnd(arr[i++]);
        }
    }
    public void ArrayToExistingLinkedList(int arr[]){
        if(arr.length==0){
            return;
        }
        int i=0;
        while(i<arr.length){
           this.insertAtEnd(arr[i++]);
        }
    }
    public Object[] LinkedListToArray(){
        if(this.head==null){
            return null;
        }
        Object[] a = new Object[this.size()];
        Node temp = this.head;
        int i=0;
        while(temp!=null){
            a[i++] = temp.data;
            temp = temp.next;
        }
        return a;
    }
    public void printList(){
        if(this.head==null){
            return;
        }
        for(Node temp=this.head;temp!=null;temp=temp.next){
            System.out.println(temp.data);
        }
    }
    public void StringCharAtEveryNode(String s){
        if(s.length()==0){
           return;
        }
        int i=0;
        while(i<s.length()){
            this.insertAtEnd(s.charAt(i++));
        }
    }
    public linklist EvenNodes(){
        if(this.head==null){
            return null;
        }
        linklist l = new linklist();
        int i=0;
        Node temp = this.head;
        while(temp!=null){
            if(i%2==0){
                l.insertAtEnd(temp.data);
            }
            temp=temp.next;
            i++;
        }
        return l;
    }
    public linklist OddNodes(){
        if(this.head==null){
            return null;
        }
        linklist l = new linklist();
        int i=0;
        Node temp = this.head;
        while(temp!=null){
            if(i%2!=0){
                l.insertAtEnd(temp.data);
            }
            temp=temp.next;
            i++;
        }
        return l;
    }
    public void Merge(linklist even, linklist odd){
        if(even.head==null && odd.head==null){
            return;
        }else if(even.head==null){
            this.head= odd.head;
        }else if(odd.head==null){
            this.head = even.head;
        }
        Node e = even.head;
        Node o = odd.head;
        int i = 0;
        while(e!=null||o!=null){
            if(i%2==0){
                this.insertAtEnd(e.data);
                e = e.next;
            }else if(i%2!=0){
                this.insertAtEnd(o.data);
                o = o.next;
            }
            i++;
        }
    }
    public Object SeachByIndex(int ind){
        if(this.head==null){
            return -1;
        }
        Node temp = this.head;
        Object element=null;
        int i = 1;
        while(temp!=null){
            if(i==ind){
               element = temp.data;
               break;
            }
            i++;
            temp = temp.next;
        }
        return element;
    }
    public int SearchByValue(Object ele){
        if(this.head==null){
            return -1;
        }
        Node temp = this.head;
        int i = 1;
        while(temp!=null){
            if(temp.data==ele){
                break;
            }
            i++;
            temp = temp.next;
        }
        return i;
    }
    public void sort(){
        if(this.head==null){
            return;
        }
        int var;
       for(Node temp=this.head;temp.next!=null;temp=temp.next){
        for(Node temp2=this.head;temp2.next!=null;temp2=temp2.next){
            if((int)temp2.next.data<(int)temp2.data){
                var = (int)temp2.next.data;
                temp2.next.data = temp2.data;
                temp2.data = var;
            }
        }
       }
    }
    public void InsertSorted(int x){
        if(this.head==null||(int)head.data>x){
            head = new Node(x,head);
        }
        Node temp = this.head;
        while(temp.next!=null){
            if((int)temp.next.data>x){
                break;
            }
            temp = temp.next;
        }
        temp.next = new Node(x,temp.next);
    }
    public int Secondlast(){
        if(this.head==null){
            throw new IllegalStateException();
        }else if(head.next==null ){
            throw new IllegalStateException("There isn't any secondlast element inside this linkedlist");
        }else if( head.next.next==null){
            return (int)this.head.data;
        }
        Node temp = this.head.next;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        return (int)temp.data;
    }
    public void Pairtosingle(){
        if(this.head==null){
            return;
        }
        Node temp = this.head;
        while(temp!=null){
            temp.next=temp.next.next;
            temp = temp.next;
        }
    }
    public void DeleteDuplicate(){
        if(this.head==null){
            return;
        }
        Node temp = this.head;
        Node p;
        while(temp!=null){
           p = temp.next;
           while(p.next!=null){
            if(temp.data==p.data){
                p.next=p.next.next;
            }
            p=p.next;
            // if(p==null){
            //     break;
            // }
           }
            temp = temp.next;
        }
    }
   /* public void Pairtosingle3(){
        if(this.head==null){
            return;
        }
        Object a[] = this.LinkedListToArray();
        for(int i=0;i<a.length;i++){
            for(int j=i+1,k=0;j<a.length;j++){//1213231
                if(a[i]==a[j]){
                    this.deletebyIndex(j+1-k);
                    k++;
                }
            }
        }
    }*/ this method is currently not working properly the above method is exactly the same use that one.

    
}
