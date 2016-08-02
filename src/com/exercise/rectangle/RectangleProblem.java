package com.exercise.rectangle;

import javax.swing.text.AbstractDocument.LeafElement;

/**
 * 
 * 
 * @author dzheleza
 *
 */
public class RectangleProblem {

	private int heigth;
	private int width ;
	/**
	 * The position of point A of points ABCD.
	 * The sides are parallel to the axis.
	 * Point A is positioned in the bottom left angle.
	 */
	private Point startPositionBottom;
	private Point startPositionCeiling;

	public RectangleProblem(int heigth, int width){
		this.heigth = heigth;
		this.width = width;
	}

	public  void mergeSort(int [] a){
		sort(a, 0, a.length-1);
	}
	
	public void merge(int[] a, int lo, int mid, int hi) {
		int[] aux = new int[a.length];
		for (int i = lo; i <= hi; i++) {
			aux[i] = a[i];
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {

			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (aux[i] > aux[j]) {
				a[k] = aux[i++];
			} else {
				a[k] = aux[j++];

			}
		}

	}	
	
	public void sort(int[] a, int lo, int hi) {

		if (lo >= hi) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		// sort left
		sort(a, lo , mid);
		//sort rigth
		sort(a , mid +1, hi);
		
		merge(a, lo, mid, hi);
		
	}

		
	
	
	public Point[] sortByX(Point [] pointList){
		//mergeSort
		return null;
	}

	public Point[] sortByY(Point [] pointList){
		//mergeSort
		return null;
	}

	public void findPointsInInterval(Point[] pointList) {
		int startindex = 0;
		int startPosX = pointList[0].getX();
		int maxPoints = 1;
		for (int i = 0; i < pointList.length-1; i++) {
			int currentPosition = pointList[i].getX();
			int additionalPoints = 1;
			for (int t = i+1; t < pointList.length; t++) {
				if (currentPosition + width >= pointList[t].getX()) {
					additionalPoints++;
				} else {
					
					break;
				}
			}
			if (maxPoints < additionalPoints) {
				maxPoints = additionalPoints;
				startPosX = pointList[i].getX();
				startindex = i;
			}
		}
		System.out.println(" Start index: " + startindex + " Max Points:" + maxPoints + " PointPos:" + startPosX );
		
	}


	public static void main(String[] args) {
		RectangleProblem t = new RectangleProblem(4, 4);
		Point[] pointList = {new Point(-3,1), new Point(1,1),new Point(1,2), new Point(2,5),new Point(3,2),new Point(7,1), new Point(7,5),new Point(7,4)};
		t.findPointsInInterval(pointList);
	
	}
}
