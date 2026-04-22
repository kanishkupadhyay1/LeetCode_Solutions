class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) return image; 

        fill(image, sr, sc, originalColor, color);
        return image;
    }

    private void fill(int[][] image, int r, int c, int originalColor, int newColor) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) return;
        if (image[r][c] != originalColor) return;

        image[r][c] = newColor; 

        fill(image, r + 1, c, originalColor, newColor);

        fill(image, r - 1, c, originalColor, newColor); 

        fill(image, r, c + 1, originalColor, newColor); 
        fill(image, r, c - 1, originalColor, newColor); 
    }
}
