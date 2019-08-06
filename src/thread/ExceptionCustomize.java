package thread;

class FuShuIndexException extends Exception {
    FuShuIndexException(String msg) {
        super(msg);
    }
}

class DividerIsZeroException extends RuntimeException {
    DividerIsZeroException(String msg) {
        super(msg);
    }
}

public class ExceptionCustomize {
    public static void main(String[] args) throws FuShuIndexException {
        String str1 = "aaa";
        String str2 = "bbb";
        if (str1 != str2) {
            System.out.println(true);
        }
        int i = 0;
        if (i < 0) {
            throw new FuShuIndexException("负数");
        }else if (i == 0) {
            throw new DividerIsZeroException("为0");
        }
    }
}
