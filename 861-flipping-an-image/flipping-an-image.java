class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        for (int i = 0; i < image.length; i++) {

            int j = 0;
            int k = image[0].length - 1;

            while (j < k) {
                int temp = image[i][j];
                image[i][j] = image[i][k];
                image[i][k] = temp;

                j++;
                k--;
            }

            for (int c = 0; c < image[0].length; c++) {

                if (image[i][c] == 1) {
                    image[i][c] = 0;
                } else {
                    image[i][c] = 1;
                }
            }
        }

        return image;
    }
}