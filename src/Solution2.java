public class Solution2 {
    private final String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        String result = "";
        if (num == 0) return "Zero";
        int i = 0;

        while (num > 0) {
            if (num % 1000 != 0)
                result = helper(num % 1000) + thousands[i] + " " + result;
            num /= 1000;
            i++;
        }
        return result.trim();
    }

    public String helper(int num) {

        if (num == 0) return "";
        else if (num < 20) return lessThan20[num % 100] + " ";
        else if (num < 100) return tens[(num % 100) / 10] + " " + helper(num % 10);
        else return lessThan20[(num % 1000)/100] + " Hundred " + helper((num % 100));
    }
}