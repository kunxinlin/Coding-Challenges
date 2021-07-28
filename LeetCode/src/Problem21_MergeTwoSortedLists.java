public class Problem21_MergeTwoSortedLists {
/*    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;

        //while both still have nodes to compare
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        //when only one list has elements left
        if(l1 == null){
            curr.next = l2;
        }
        else{
            curr.next = l1;
        }

        return dummyHead.next;
    }*/
}
