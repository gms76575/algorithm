public class Test {
    public static void main(String[] args) {
        char[] chars = new char[Integer.MAX_VALUE>>>2];
        for (int i=0;i<chars.length;i++) {
            chars[i] = 'A';
        }
        String str2 = new String(chars);
    }
}
