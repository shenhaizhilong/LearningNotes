package suggestions151;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/25 19:20
 */
public class ConvertToChineseNumber {
    public static String convertToChineseNumber(int n)
    {
        String chineseNumber = "";
        switch (n)
        {
            case 0:
                chineseNumber = "零";
                break;
            case 1:
                chineseNumber = "壹";
                break;
            case 2:
                chineseNumber = "贰";
                break;
            case 3:
                chineseNumber = "叄";
                break;
            case 4:
                chineseNumber = "肆";
                break;
            case 5:
                chineseNumber = "伍";
                break;
            case 6:
                chineseNumber = "陆";
                break;
            case 7:
                chineseNumber = "柒";
                break;
            case 8:
                chineseNumber = "捌";
                break;
            case 9:
                chineseNumber = "玖";
                break;
            default:
                break;

        }
        return chineseNumber;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(convertToChineseNumber(i));
        }
    }
}
