package scaner_test;

class DListNode {
    DListNode next;
    DListNode prev;
    int val;

    DListNode (int value) {
        this.val = value;
    }
}

class InsertNode {

    public static void insertNode(DListNode cur, int value) {
        if (cur.val <= value) {
            while (cur.val <= cur.next.val) {
                if (cur.val <= value && value <= cur.next.val) {
                    insert(cur, cur.next, value);
                    return;
                }
                cur = cur.next;
            }
            insert(cur, cur.next, value);
            return;
        } else {
            while (cur.val >= cur.prev.val) {
                if (cur.val >= value && value >= cur.prev.val) {
                    insert(cur.prev, cur, value);
                    return;
                }
                cur = cur.prev;
            }
            insert(cur.prev, cur, value);
            return;
        }
    }

    public static void insert(DListNode head, DListNode tail, int value) {
        DListNode node = new DListNode(value);
        head.next = node;
        node.prev = head;

        node.next = tail;
        tail.prev = node;
    }
}

class Main {
    public static void main(String[] args) {
        DListNode head = new DListNode(0);
        DListNode tail = new DListNode(10);

        head.next = tail;
        head.prev = tail;
        tail.prev = head;
        tail.next = head;

        for (int i = 1; i <= 9; i++) {
            InsertNode.insertNode(head, i);
        }
        InsertNode.insertNode(head, 4);
        InsertNode.insertNode(head, 3);
        InsertNode.insertNode(head, 5);
        InsertNode.insertNode(head, 5);
        InsertNode.insertNode(head, -1);

        DListNode cur = head.next;
        for (; cur != head; cur = cur.next) {
            System.out.println(cur.val);
        }
    }
}



