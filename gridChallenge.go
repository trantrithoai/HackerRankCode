package main

import (
	"fmt"
	"sort"
	"strings"
)

func gridChallenge(grid []string) string {
	// Sort each row
	for i, row := range grid {
		sortedRow := strings.Split(row, "")
		sort.Strings(sortedRow)
		grid[i] = strings.Join(sortedRow, "")
	}

	// Check if columns are sorted
	numRows := len(grid)
	numCols := len(grid[0])

	for col := 0; col < numCols; col++ {
		for row := 1; row < numRows; row++ {
			if grid[row][col] < grid[row-1][col] {
				return "NO"
			}
		}
	}

	return "YES"
}

func main() {
	grid1 := []string{"ebacd", "fghij", "olmkn", "trpqs", "xywuv"}
	fmt.Println(gridChallenge(grid1)) // Output: YES

	grid2 := []string{"abc", "lmp", "qrt"}
	fmt.Println(gridChallenge(grid2)) // Output: YES

	grid3 := []string{"mpxz", "abcd", "wlmf"}
	fmt.Println(gridChallenge(grid3)) // Output: NO
}
