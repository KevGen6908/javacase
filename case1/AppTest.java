package ru.spbstu.telematics.java;






import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;





/**
 * Unit test for simple App.
 */
public class AppTest 
{
@Test
    public void testSnakeAdd() {
        int size = 3;
        int[][] snakeArray = snakeAdding.snakeadd(size);

        int expected[][] = {
            {1, 2, 3},
            {6, 5, 4},
            {7, 8, 9}
        };

        assertArrayEquals(expected, snakeArray);
    }

    @Test
    public void testSnakeAddWithSize1() {
        int size = 1;
        int[][] snakeArray = snakeAdding.snakeadd(size);

        int expected[][] = {{1}};

        assertArrayEquals(expected, snakeArray);
    }

    @Test
    public void testSnakeAddWithSize4() {
        int size = 4;
        int[][] snakeArray = snakeAdding.snakeadd(size);

        int expected[][] = {
            {1, 2, 3, 4},
            {8, 7, 6, 5},
            {9, 10, 11, 12},
            {16, 15, 14, 13}
        };

        assertArrayEquals(expected, snakeArray);
    }
}
