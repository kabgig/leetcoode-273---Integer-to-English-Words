class Solution {
    public String numberToWords(int num) {
        String result = "";
        String[] ones = {"","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine "};
        String[] tens = {"","Ten ","Twenty ","Thirty ","Forty ","Fifty ", "Sixty ", "Seventy ","Eighty ", "Ninety "};
        String[] hundreds = {"","One Hundred ","Two Hundred ","Three Hundred ","Four Hundred ","Five Hundred ","Six Hundred ","Seven Hundred ","Eight Hundred ","Nine Hundred "};
        String [] thousands = {"","One Thousand ","Two Thousand ","Three Thousand ","Four Thousand ","Five Thousand ","Six Thousand ","Seven Thousand ","Eight Thousand ","Nine Thousand "};
        String[] milliard = {"","One Milliard ","Two Milliard "};

        result =  hundreds[(num % 1_000_000)/100_000] + tens[(num % 100_000)/10_000] + ones[(num % 10_000)/1000] + "Thousand "
                + hundreds[(num % 1000)/100] + tens[(num % 100)/10] + ones[num % 10];

        return result.trim();
    }
}