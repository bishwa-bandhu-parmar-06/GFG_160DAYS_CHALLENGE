// Design MinMax Queue
// Difficulty: MediumAccuracy: 82.66%Submissions: 4K+Points: 4
// Design a SpecialQueue data structure that functions like a normal queue but with additional support for retrieving the minimum and maximum element efficiently.
// The SpecialQueue must support the following operations:

// enqueue(x): Insert an element x at the rear of the queue.
// dequeue(): Remove the element from the front of the queue.
// getFront(): Return the front element without removing.
// getMin(): Return the minimum element in the queue in O(1) time.
// getMax(): Return the maximum element in the queue in O(1) time.
// There will be a sequence of queries queries[][]. The queries are represented in numeric form:

// 1 x : Call enqueue(x)
// 2:  Call dequeue()
// 3: Call getFront()
// 4: Call getMin()
// 5: Call getMax()
// The driver code will process the queries, call the corresponding functions, and print the outputs of getFront(), getMin(), getMax() operations.
// You only need to implement the above five functions.

// Note: It is guaranteed that all the queries are valid.



class SpecialQueue {
    Queue<Integer> q = new LinkedList<Integer>();
	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;
	
	public SpecialQueue() {
		// Define Data Structures
	}

	public void enqueue(int x) {
		// Insert element into the queue
		if (x>max) {
			max = x;
		}
		if (x<min) {
			min = x;
		}
		q.add(x);
	}

	public void dequeue() {
		// Remove element from the queue
		int removeElement = q.remove();
		if (q.isEmpty()) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			return;
		}
		if (removeElement == min) {
			min = Integer.MAX_VALUE;
			q.forEach(value -> {
				if (value < min) {
					min = value;
				}
			});
		}
		if (removeElement == max) {
			max = Integer.MIN_VALUE;
			q.forEach(value -> {
				if (value > max) {
					max = value;
				}
			});
		}
	}

	public int getFront() {
		// Get front element
		return q.peek();
	}

	public int getMin() {
		// Get minimum element
		return min;
	}

	public int getMax() {
		// Get maximum element
		return max;
	}
}