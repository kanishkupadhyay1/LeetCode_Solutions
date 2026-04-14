class MyLinkedList {

    class node{
        int val;
        node next;

        public node(int val){
            this.val=val;
            this.next=null;
        }
    }

    private node head;
    private int size;

    public MyLinkedList() {
        head=null;
        size=0;
    }
    
    public int get(int index) {
if(index<0 || index>=size)return -1;

node cu=head;

        while(index-- >0){
            cu=cu.next;
        }
        
        return cu.val;
    }
    
    public void addAtHead(int val) {
        node nn=new node(val);
        nn.next=head;
        head=nn;
        size++;
    }
    
    public void addAtTail(int val) {
        node nn=new node(val);

        if(head==null)head=nn;
        else{
            node cu=head;
            while(cu.next!=null){
                cu=cu.next;
            }
            cu.next=nn;
            
        }
        
        
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        
        if(index<0 || index>size)return;

        if(index == 0){
    addAtHead(val);
    return;
}

        node cu=head;
        while(--index>0){
            cu=cu.next;
        }
        
        node nn=new node(val);

        nn.next=cu.next;
        cu.next=nn;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=size)return;

        if(index == 0){
    head = head.next;
    size--;
    return;
}
        else{
            node cu=head;
            while(--index>0){
                cu=cu.next;
            }
            cu.next=cu.next.next;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */