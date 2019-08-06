package offer_test.jump_floor_ii;

public class JumpFloorII {
    public int Jump(int target) {
        if (target == 0 || target == 1) {
            return 1;
        }else if (target == 2) {
            return 2;
        }
        int result = 0;
        for (int i = 0; i < target; i ++) {
            result += Jump(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new JumpFloorII().Jump(5));
    }
}
