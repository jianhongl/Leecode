/**
 * FileName: MyLinkedList
 * Author:   Jianhongl
 * Date:     17/2/2022 11:09 pm
 * Description:
 * History:
 */
package systemDesign;

/**
 * @author lujianhong
 * @create 17/2/2022
 * @since 1.0.0
 */
public class MyLinkedList {
    private Node head;

    private Node tail;

    private int size;

    private class Node {
        private int val;
        private Node next;
        private Node prev;

        public Node (int val) {
            this.val = val;
        }

        public Node (int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
        size = 0;
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        Node cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }

        return cur.val;
    }

    public void addAtHead(int val) {
        Node nextNode = head.next;
        Node newNode = new Node(val);
        head.next = newNode;
        newNode.prev = head;
        newNode.next = nextNode;
        nextNode.prev = newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node prevNode = tail.prev;
        Node newNode = new Node(val);
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = tail;
        tail.prev = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        if (index == size) {
            addAtTail(val);
        } else if (index < 0) {
            addAtHead(val);
        } else {
            Node cur = head;
            for (int i = 0; i <= index - 1; i++) {
                cur = cur.next;
            }
            Node newNode = new Node(val);
            Node nextNode = cur.next;
            cur.next = newNode;
            newNode.prev = cur;
            newNode.next = nextNode;
            nextNode.prev = newNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            Node cur = head;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            size--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(1));       //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));;            //返回3
    }
}
