public static String gridChallenge(List<String> grid) {
    // Sort each row
    for (int i = 0; i < grid.size(); i++) {
        char[] row = grid.get(i).toCharArray();
        Arrays.sort(row);
        grid.set(i, new String(row));
    }

    // Check if columns are sorted
    int numRows = grid.size();
    int numCols = grid.get(0).length();

    for (int col = 0; col < numCols; col++) {
        for (int row = 1; row < numRows; row++) {
            if (grid.get(row).charAt(col) < grid.get(row - 1).charAt(col)) {
                return "NO";
            }
        }
    }

    return "YES";
}
