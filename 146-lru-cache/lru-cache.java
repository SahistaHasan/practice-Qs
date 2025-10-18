class Node{
    int x;
    int y;
    Node prev;
    Node next;
    Node(int x, int y){
         this.x=x;
         this.y=y;
    }
}
class LRUCache {
    Map<Integer,Node> map=new HashMap<>();
    Node head=new Node(0,0);
    Node tail = new Node(0,0);
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        head.prev=null;
        tail.next=null;
        tail.prev=head;
    }
    public void delete(Node n1){
        Node before=n1.prev;
        Node later=n1.next;
        before.next=later;
        later.prev=before;
    }
    public void insert(Node n1){
          Node temp=head.next;
          head.next=n1;
          n1.prev=head;
          n1.next=temp;
          temp.prev=n1;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        delete(map.get(key));
       insert(map.get(key));
        return map.get(key).y;
      
       
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node temp=map.get(key);
            temp.y=value;
            delete(map.get(key));
            map.remove(key);
            insert(temp);
            map.put(key,temp);
        }
          else if(map.size()>=capacity){
            Node tobedel = tail.prev;
            delete(tail.prev);
            map.remove(tobedel.x);
            Node newnode = new Node(key,value);
            insert(newnode);
            map.put(key,newnode);
        }
         if(!map.containsKey(key)) {
            Node newnode = new Node(key,value);
            insert(newnode);
            map.put(key,newnode);

        }
        
       
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */