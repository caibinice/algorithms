package algorithms.leetcode;

public class RotateImage90Degree {

/**
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

Example 2:
Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 
rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */


 /*
 * clockwise rotate
 * first swap the symmetry (i.e. transpose the matrix), then reverse each row
 * 1 2 3     1 4 7     7 4 1
 * 4 5 6  => 2 5 8  => 8 5 2
 * 7 8 9     3 6 9     9 6 3
 * 
 * anti-clockwise rotate
 * first swap the symmetry (i.e. transpose the matrix), then reverse each col
*/

    // Turns rows into cols and vice versa
    private void transposeImage(int[][] image) {
      for(int i = 0; i < image.length; i++) {
          for(int j = i + 1; j < image[i].length; j++) {
              int tmp = image[i][j];
              image[i][j] = image[j][i];
              image[j][i] = tmp;
          }
      }
  }

    public void rotate(int[][] image) {
      // Turns rows into cols and vice versa 行和列翻转
        transposeImage(image);

        // reverse each row of the image 将每一行的元素左右对称互换
        for(int row = 0; row < image.length; row++) {
            int i = 0;
            int j = image[row].length - 1;
            while(i < j) {
                int tmp = image[row][i];
                image[row][i++] = image[row][j];
                image[row][j--] = tmp;
            }
        }
    }


    


}