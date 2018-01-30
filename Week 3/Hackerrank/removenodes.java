/*
 * Complete the function below.
 */
/*
   For your reference:
   LinkedListNode {
    int val;
    LinkedListNode *next;
   };
 */

static LinkedListNode removeNodes(LinkedListNode list, int x) {

        while (list != null && list.val > x)
                list = list.next;

        if (list == null) return null;

        LinkedListNode prev = list;
        LinkedListNode ahead = list.next;

        while (ahead != null) {
                if (ahead.val > x)
                        prev.next = ahead.next;
                else
                        prev = prev.next;
                ahead = ahead.next;
        }
        return list;
}
