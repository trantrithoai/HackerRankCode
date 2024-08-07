public static void minimumBribes(List<Integer> q) {
    int bribes = 0;
    
    for (int i = 0; i < q.size(); i++) {
        // Check if the current person has moved more than two positions ahead
        if (q.get(i) - (i + 1) > 2) {
            System.out.println("Too chaotic");
            return;
        }
        
        // Count the number of bribes for the current person
        // The max index we need to check is `q[i] - 2` because a person can't bribe more than 2 people
        for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
            if (q.get(j) > q.get(i)) {
                bribes++;
            }
        }
    }
    
    System.out.println(bribes);
}
