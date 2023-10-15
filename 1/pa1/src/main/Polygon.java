/*
 * Name: Junseop Kim
 * Student ID #: 2019134006
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public class Polygon implements IPolygon {
	ICLL<Point> boundary;

	public Polygon(ICLL<Point> p){
		boundary = p;
	}

	@Override
	public boolean pointInPolygon(Point p) {
		/*
		 * Input:
		 *	- point in 2D space
		 *
		 * Output:
		 *  - the number of elements in the linked list.
		 * 
		 * Note: You should use the "Ray-Casting" algorithm described in the
		 *       handout.
		 *
		 * Note: Your ray should have slope 0, meaning it extends to infinity
		 *       directly to the right of the point (see edge case #4)
		 *
		 * Note: You DO NOT have to consider the following edge cases:
		 *          1) There are two points in the polygon with the same x and y
		 *          2) The test point lies on a straight line with two adjacent
	 	 *             points on the boundary, or lies exactly on the boundary
	 	 *          3) The test point has the same x and y as a point
		 *              already in the polygon
		 *          4) The ray intersecting the boundary at a vertex (where two
		 *             edges meet).
		 *                 i) This is the reason for the slope 0 ray
		 */
		//다음 2가지 조건을 모두 만족할 때(AND, &&) 교점을 갖는다:
		//1. 점p의 y 좌표는 다각형의 이웃한 노드 관계인 두 꼭짓점의 y좌표 사이에 존재한다.
		//2. 점p를 시점으로 갖는 x축과 평행한 반직선과 다각형 변과의 교점의 x좌표는 점p의 x값보다 커야한다.
		//   (반직선은 x가 증가하는 방향으로 뻗어나가도록 설정했기 때문.)

		int px = p.getX();
		int py = p.getY();

		int count = 0; // x축과 평행한 반직선과 다각형과 만난 횟수

		if(boundary.size() <3){
			return false;
		}


		for(int i = 0; i<boundary.size();i++){ //다각형 변 AB
			Point A = boundary.getHead();
			boundary.rotate(Direction.TO_NEXT);
			Point B = boundary.getHead();

			int ax = A.getX();
			int ay = A.getY();

			int bx = B.getX();
			int by = B.getY();

			if(py>Math.min(ay,by) && py<Math.max(ay,by)){
				double xinter = (double) (py-ay)*(bx-ax)/(by-ay)+ax; // y= py와 선분 AB와의 교점의 x좌표
				if(px < xinter){
					count ++;
				}
			}
		}
		return count %2 == 1; //홀수면 해당 점은 다각형 내부에. => true, 짝수라면 밖에. =>false
	}
}
