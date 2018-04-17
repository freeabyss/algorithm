package science.freeabyss.algorithm.leetcode;

/**
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves,
 * judge if this robot makes a circle, which means it moves back to the original place.
 * <p>
 * The move sequence is represented by a string. And each move is represent by a character.
 * The valid robot moves are R (Right), L (Left), U (Up) and D (down).
 * The output should be true or false representing whether the robot makes a circle.
 *
 * @author abyss
 * @date 2018/4/13
 */
public class JudgeCircle {
    public static boolean solution(String moves) {
        int horizontalPosition = 0;
        int verticalPosition = 0;

        for (char a : moves.toCharArray()) {
            if (a == 'U') horizontalPosition++;
            else if (a == 'D') horizontalPosition--;
            else if (a == 'L') verticalPosition++;
            else if (a == 'R') verticalPosition--;
        }
        return verticalPosition == 0 && horizontalPosition == 0;
    }

    public static boolean solution2(String moves) {
        int robotMoveLen = moves.length();
        int ULength = robotMoveLen - moves.replace("U", "").length();
        int LLength = robotMoveLen - moves.replace("L", "").length();
        int RLength = robotMoveLen - moves.replace("R", "").length();
        int DLength = robotMoveLen - moves.replace("D", "").length();
        return ULength == DLength && LLength == RLength;
    }
}
