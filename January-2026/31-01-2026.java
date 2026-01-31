// Implement k Queues in a Single Array
// Difficulty: HardAccuracy: 61.88%Submissions: 2K+Points: 8
// You are given two integers n and k. Your task is to implement a class kQueues that uses a single array of size n to simulate k independent queues.

// The class should support the following operations:

// enqueue(x, i) → Adds the element x into the i-th queue.
// dequeue(i) → Removes the front element from the i-th queue and returns it. Returns -1 if the queue is empty.
// isEmpty(i) → Returns true if i-th queue is empty, else return false.
// isFull() → Returns true if the array is completely full and no more elements can be inserted, otherwise false.

// There will be a sequence of q queries represented as:

// 1 x i : Call enqueue(x, i)
// 2 i : Call dequeue(i)
// 3 i : Call isEmpty(i)
// 4 : Call isFull()

// The driver code will process the queries, call the corresponding functions, and print the results of dequeue, isEmpty, and isFull operations.
// You only need to implement the above four functions.

// Examples:


class kQueues {
    List<Queue<Integer>> qt = new ArrayList<>();
    int k;
    int n;
    int size;
    kQueues(int n, int k) {
        // Initialize your data members
        for(int i = 0; i < n; i++) {
            qt.add(new LinkedList<>());
        }
        this.k = k;
        this.n = n;
    }

    void enqueue(int x, int i) {
        // enqueue element x into queue number i
        if(i >= qt.size()) return;
        
        size++;
        qt.get(i).offer(x);
    }

    int dequeue(int i) {
        // dequeue element from queue number i
        if(i >= qt.size()) return -1;
        if(qt.get(i).isEmpty()) return -1;
        size--;
        return qt.get(i).poll();
    }

    boolean isEmpty(int i) {
        // check if queue i is empty
        if(i >= qt.size()) return false;
        return qt.get(i).isEmpty();
    }

    boolean isFull() {
        // check if array is full
        return size == n;
    }
}