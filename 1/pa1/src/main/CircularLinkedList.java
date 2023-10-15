/*
 * Name: Junseop Kim
 * Student ID #: 2019134006
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public class CircularLinkedList<T> implements ICLL<T> {
	class Node {
		Node next;
		Node previous;
		// you can further implement your node class here.
		T data; // 타입 제네릭 T로 갖는 data 필드 추가

		Node(T obj){
			this.data = obj;
			this.next = null;
			this.previous = null;
		}
	}

	private Node head;
	// you may declare additional variables here.
	private int size = 0; // 리스트 크기 카운터 size

	public CircularLinkedList() {
		// implement your constructor here.
		head = null; //빈 리스트
	}

	@Override
	public int size() {
		/*
		 * Input:
		 *	- none
		 *
		 * Output:
		 *  - the number of elements in the linked list.
		 */
		return size;
	}

	@Override
	public boolean isEmpty() {
		/*
		 * Input:
		 *	- none
		 *
		 * Output:
		 *  - whether or not the list is empty.
		 */
		return size == 0;
	}

	@Override
	public T getHead() {
		/*
		 * Input:
		 *	- none
		 *
		 * Output: 
		 *  - the element stored in the node pointed by the head.
		 */
		if(isEmpty()){
			return null;
		}
		else{
			return head.data;
		}
		
	}

	@Override
	public void rotate(Direction direction) { ////2가지 : TO_NEXT, TO_PREVIOUS
		/*
		 * Input:
		 *	- the rotation orientation
		 *
		 * Output: 
		 *  - none
		 * 
		 * Does:
		 *  - rotates the linked list so that the head points to the Node in that direction.
		 */

		if(direction == Direction.TO_NEXT){
			head = head.next;
		}
		else if(direction == Direction.TO_PREVIOUS){
			head = head.previous;
		}
		return;
	}

	@Override
	public void insert(T element) {


		/*
		 * Input:
		 *	- element to be inserted to the list
		 *
		 * Output: 
		 *  - none
		 * 
		 * Does:
		 *  - inserts the given element before the Node pointed by the head.
		 */

		Node newnode = new Node(element);
		if(isEmpty()){ //빈 노드에서 추가할 시
			head = newnode;
			head.next = head;
			head.previous = head;
		}
		else{ // 최소 1개 이상의 노드 존재 시
			newnode.next = head;
			newnode.previous = head.previous;
			head.previous.next = newnode;
			head.previous = newnode;

		}
		size++;



		return;
	}

	@Override
	public T delete() {
		/*
		 * Input:
		 *	- none
		 *
		 * Output:
		 *  - the element pointed to by the head at the start of the method call.
		 * 
		 * Does:
		 *  - deletes the element pointed to by the head and returns it.
		 *  - if the list is empty, return null.
		 * 
		 * Note:
		 *  - if nonempty after deletion,
		 *    the new head should be the next node of the original head.
		 */
		T deleted = getHead();
		if(isEmpty()){
			return null;
		}
		else if(size == 1){
			head = null;
		}
		else{
			head.previous.next = head.next;
			head.next.previous = head.previous;
			head = head.next; // the new head should be the next node of the original head.
			
		}
		size--;
		return deleted; //the element pointed to by the head at the start of the method call.
	}

	@Override
	public boolean find(T target) {
		/*
		 * Input:
		 *	- target element to find in the list.
		 *
		 * Output:
		 *  - whether or not the search succeeded.
		 * 
		 * Does:
		 *  - moves the head to the first instance of target in the list if the search succeeded.
		 *  - does not move the head if the search failed.
		 */
		Node temp = head; // 초기 head가 가리키는 노드 저장용 임시노드 temp 생성
		if(isEmpty()){
			return false;
		}

		do{
			if(head.data.equals(target)){
				return true;
			}
			head = head.next;
		}
		while(head != temp);
		return false;
	}
}
