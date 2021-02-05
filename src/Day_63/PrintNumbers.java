package Day_63;
/***
 * 剑指 Offer 17. 打印从1到最大的n位数
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * 
 * @author MyPC
 *
 */
public class PrintNumbers {
    public int[] printNumbers(int n) {
        int end = (int) Math.pow(10,n);
        int[] res = new int[end];
        for(int i=0;i<end;i++) {
        	res[i] = i+1;
        }
        return res;
    }
    
    public static void main(String[] args) {
		System.out.println(1+"hello");
	}
    /**
     * 评价:
     * 		该种做法并未体现在剑指offer原书中的思想，
     * 在原书中并未限制n的大小，所以我们是需要考虑溢出问题。
     * 所以使用char数组来模仿进行加减法
     */
    public void printNumbers2(int n) {
        // 输入n，比如输入3，数组中为1，2，3，4....999
        // int基本数据类型，是32位，范围：-2,147,483,648‬~2,147,483,6487
        // 所以当n为9是可以的，但是n为10，就超出了int的范围
        // 创建一个字符数组,长度为n
        char[] chars = new char[n];
        // 先初始化
        for (int i = 0; i < n; i++) {
            chars[i] = '0';
        }
        // 加一，打印
        while (plus(chars, n)) {
            // 打印方法
            pringMethod(chars, n);
        }
    }

    /**
     * 一个使字符数组加一的操作，如果现在小于9...9，加一，返回true，如果等于9...9,返回false
     *
     * @param chars
     * @return
     */
    public boolean plus(char[] chars, int n) {
        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] < '9') {
                chars[i] = (char) (chars[i] + 1);
                break;
            } else {//这一位是9
                if (i == 0) return false;
                chars[i] = '0';
            }
        }
        return true;
    }

    /**
     * 一个打印方法，
     */
    public void pringMethod(char[] chars, int n) {
        int i;
        for (i = 0; i < n; i++) {
            if (chars[i] == '0') continue;
            else break;
        }
        for (int j = i; j < n; j++) {
            System.out.print(chars[j]);
        }
        System.out.println();
    }
    
}


