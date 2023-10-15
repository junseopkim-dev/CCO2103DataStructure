/*
 * Name: Junseop Kim
 * Student ID #: 2019134006
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public class Sorter implements ISorter {
	public Sorter() { ; }

	@Override
	public int[] ascending(int[] A) {
		/*
		 * Input:
		 *	- an integer array A
		 *
		 * Output: a sorted array A in *ascending* order.
		 */

		//버블정렬 알고리즘 적용
		
		for(int i =0;i<A.length;i++){
			for (int j=A.length-1;j>i;j--){ // 패스, 맨 오른쪽 끝(index: A.length-1)에서부터 시작
				if(A[j-1]>A[j]){ //오름차순 정렬을 위해, 왼쪽이 오른쪽보다 클 경우 스왑 수행
					int temp = A[j]; //임시 저장용 변수 temp 생성. A[j] 기억용
					A[j]=A[j-1];
					A[j-1]=temp;
				}
			}
		}
		return A;
	}

	@Override
	public int[] descending(int[] A) {
		/*
		 * Input:
		 *	- an integer array A
		 *
		 * Output: a sorted array A in *descending* order.
		 */

		//버블정렬 알고리즘 적용

		for(int i =0;i<A.length;i++){ 
			for (int j=A.length-1;j>i;j--){// 패스, 맨 오른쪽 끝(index: A.length-1)에서부터 시작
				if(A[j-1]<A[j]){ //내림차순 정렬을 위해, 오른쪽이 왼쪽보다 큰 경우 스왑 수행
					int temp = A[j]; //임시 저장용 변수 temp 생성. A[j] 기억용
					A[j]=A[j-1];
					A[j-1]=temp;
				}
			}
		}
		return A;
	}
}
