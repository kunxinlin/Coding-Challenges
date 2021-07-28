import java.util.*;

public class Problem146_LRUCache {
    Node head = new Node();
    Node tail = new Node();
    Map<Integer, Node> map;
    int capacity;

    public Problem146_LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int result = -1;
        Node node = map.get(key);
        if(node !=null){
            result = node.value;
            //these extra steps are to account for our access
            //since we accessed its most recently used, so we move it to the front of our list again
            //by doing a remove and addToFront
            remove(node);
            addToFront(node);
        }

        return result;
    }

    public void put(int key, int value) {
        Node node = map.get(key); //get the node value from our key
        if(node != null){
            //if the node exist, then we simply do a remove, then add node with updated value
            //which simulates an update.
            remove(node);
            node.value = value;
            addToFront(node);
        }
        else{
            //check if full
            if(map.size() == capacity){
                map.remove(tail.prev.key); //we remove the prev that our tail dummy pointed to from our map
                remove(tail.prev); //remove the reference from our nodes
            }

            //else add the new node to our map and references
            Node new_node = new Node();
            new_node.key = key;
            new_node.value = value;

            map.put(key, new_node);
            addToFront(new_node);
        }
    }

    public void addToFront(Node node){
        Node head_next = head.next; //the node that comes after the head node.
        node.next = head_next; //set the inserted node's next to the previous node after head
        head_next.prev = node; //set the previous of that to current node
        head.next = node; //head next now points to inserted node
        node.prev = head; //current node prev is now head
    }

    //we find the node by its key and value through our map
    public void remove(Node node){
        node.next.prev = node.prev; //this is easier for me to understand
        node.prev.next = node.next; //vs creating a temp variable to hold the node's next and prev
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
}
