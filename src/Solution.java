class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String result;
        String[] ones = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        String[] tens = {"", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
        String[] hundreds = {"", "One Hundred ", "Two Hundred ", "Three Hundred ", "Four Hundred ", "Five Hundred ", "Six Hundred ", "Seven Hundred ", "Eight Hundred ", "Nine Hundred "};
        String[] milliard = {"", "One Billion ", "Two Billion "};

        String oneDigits;
        String tensDigits;
        String oneDigitsThousands;
        String tensDigitsThousands;
        String oneDigitsMillions;
        String tensDigitsMillions;

        // small numbers
        if ((num % 100) > 9 && (num % 100) < 20) {
            oneDigits = ones[num % 100] + " ";
            tensDigits = "";
        } else {
            oneDigits = ones[num % 10] + " ";
            tensDigits = tens[(num % 100) / 10];
        }
        //thousands
        int thouDivider = num % 100_000;
        if ((thouDivider) / 1000 > 9 && (thouDivider) / 1000 < 20) {
            oneDigitsThousands = ones[thouDivider / 1000];
            tensDigitsThousands = "";
        } else {
            oneDigitsThousands = ones[(num % 10_000) / 1000];
            tensDigitsThousands = tens[(thouDivider) / 10_000];
        }
        //millions
        int millDivider = num % 100_000_000;
        if ((millDivider) / 1000_000 > 9 && (millDivider) / 1000_000 < 20) {
            oneDigitsMillions = ones[millDivider / 1000_000];
            tensDigitsMillions = "";
        } else {
            oneDigitsMillions = ones[(num % 10_000_000) / 1000_000];
            tensDigitsMillions = tens[(millDivider) / 10_000_000];
        }

        result = milliard[num / 1_000_000 / 1000]
                + hundreds[(num % 1_000_000_000) / 100_000_000] + tensDigitsMillions + oneDigitsMillions + "Million "
                + hundreds[(num % 1_000_000) / 100_000] + tensDigitsThousands + oneDigitsThousands + "Thousand "
                + hundreds[(num % 1000) / 100] + tensDigits + oneDigits;

        //word processing
        int[] numArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = numArray.length - 1; i >= 0; i--) {
            numArray[i] = num % 10;
            num /= 10;
            if (num == 0) break;
        }

        if (numArray[4] == 0 && numArray[5] == 0 && numArray[6] == 0) result = result.replace("Thousand ", "");
        if (numArray[1] == 0 && numArray[2] == 0 && numArray[3] == 0) result = result.replace("Million ", "");
        return result.trim();
    }
}