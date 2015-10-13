package algorithms;

import Util.ListNode;

public class ReverseList {

	public static ListNode reverseList(ListNode head) {
		if (null == head || null == head.getNext()) {
			return head;
		}
		ListNode reverseHead = reverseList(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);
		return reverseHead;
	}

	public static ListNode reverseList2(ListNode head) {
		ListNode pre = null;    			//指向已反转好的链表首
		ListNode cur = head;				//指向未反转好的链表首
		while (cur != null) {
			ListNode next = cur.getNext();	//保存待反转结点的下一个，因为反转后会断裂
			cur.setNext(pre);				//将待反转结点进行反转，指向已反转好的链表首
			pre = cur;						//更新pre至已反转好的链表首
			cur = next;						//更新cur至未反转好的链表首
		}									
		return pre;							//cur为null时代表未反转好的链表已空，返回已反转好的链表pre
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node4 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node1 = new ListNode(1);
		ListNode head = new ListNode(0);
		head.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(null);
		Util.Util.printLinkedList(head);
		head = reverseList(head);
		Util.Util.printLinkedList(head);
		head = reverseList2(head);
		Util.Util.printLinkedList(head);
	}

}
