/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] buff = new char[4];
    private int bufCount = 0;
    private int bufIndex = 0;

    public int read(char[] buf, int n) {
        int ptr = 0;

        while (ptr < n) {
            if (bufIndex == 0) {
                bufCount = read4(buff);
            }

            if (bufCount == 0) {
                return ptr;
            }

            while (bufIndex < bufCount && ptr < n) {
                buf[ptr++] = buff[bufIndex++];
            }

            if (bufIndex == bufCount) {
                bufIndex = 0;
            }
        }

        return ptr;
    }
}