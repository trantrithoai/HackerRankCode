package main

import (
    "fmt"
)

func minimumBribes(q []int32) {
    bribes := 0
    
    for i := 0; i < len(q); i++ {
        // Check if the current person has moved more than two positions ahead
        if q[i] - int32(i+1) > 2 {
            fmt.Println("Too chaotic")
            return
        }
        
        // Count the number of bribes for the current person
        // The max index we need to check is `q[i] - 2` because a person can't bribe more than 2 people
        for j := max(0, q[i] - 2); j < int32(i); j++ {
            if q[j] > q[i] {
                bribes++
            }
        }
    }
    
    fmt.Println(bribes)
}

// Helper function to get the maximum of two int32 values
func max(x, y int32) int32 {
    if x > y {
        return x
    }
    return y
}

func main() {
    q := []int32{2, 1, 5, 3, 4}
    minimumBribes(q) // Output should be 3
    
    q = []int32{2, 5, 1, 3, 4}
    minimumBribes(q) // Output should be "Too chaotic"
}
