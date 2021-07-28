import java.util.LinkedList;
import java.util.List;

public class Problem2_AddTwoNumbers {
    public static void main(String[] args) {
        //342
        LinkedList<Integer> l1 = new LinkedList<>(){{
            add(2);
            add(4);
            add(3);
        }};

        //465
        LinkedList<Integer> l2 = new LinkedList<>(){{
            add(5);
            add(6);
            add(4);
        }};

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(addList(l1,l2));
    }

    static LinkedList<Integer> addList(LinkedList<Integer> l1, LinkedList<Integer> l2){
        int size =  l1.size()>l2.size() ? l1.size() : l2.size();
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 0;

        for(int i = 0; i < size; i++){
            int sum = 0;

            if(l1.get(i) + l2.get(i) + carry >= 10){
                sum = (l1.get(i) + l2.get(i) + carry) % 10;
                carry = 1;
            }else{
                sum = l1.get(i) + l2.get(i) + carry;
                carry = 0;
            }

            result.add(sum);
        }

        return result;
    }

    //LeetCode uses a custom ListNode, so it only gives you the value of the head.
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode dummyHead = new ListNode();
//        ListNode currHead = dummyHead;//dummy and curr is point to the same instance of a ListNode now
//        int carry = 0;
//
//        //if both is pointing to null, it means end of both list/no more digits.
//        while (l1 != null || l2 != null) {
//            int val1 = (l1 != null) ? l1.val : 0; //if null, we substitute it with a 0
//            int val2 = (l2 != null) ? l2.val : 0;
//            int sum = val1 + val2 + carry;
//            carry = sum / 10;
//
//            //the dummyHead.next is pointing to this as well since its the same instance
//            currHead.next = new ListNode(sum % 10); //create a node of the resulting number
//            currHead = currHead.next;
//
//            //if the l1 is null it means there no more number its point to, therefore no need to point to
//            //the next node.
//            if (l1 != null) l1 = l1.next;
//            if (l2 != null) l2 = l2.next; //one of the list might have more digits
//        }
//        if (carry > 0) {
//            //if theres a carry from the sum of the last numbers, need to create the 1
//            currHead.next = new ListNode(carry);
//        }
//        //dummyHead.next still points to the starting node of our resulting LinkedList
//        //this is why dummy is needed. otherwise we have no way to return the head of the LinkedList
//        return dummyHead.next;
//    }
}
