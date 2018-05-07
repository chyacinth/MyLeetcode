/*
有点麻烦的一题……其实就是纯模拟，但是特殊情况比较多，处理时最好有一个清晰的思路
1. 找出一行能存那几个词
2. 如果不是最后一行， 那么直接算空格数和有多少个空档要+1
3. 如果是最后一行，那么空格数强行变成1，然后如果长度不足maxWidth再补足
*/
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();        
        int p = 0, totalLength = 0, ed = 0, wordNum, avgSpace, wordLength, extraSpaceIdx;
        while (p < words.length) {
            totalLength = -1;
            ed = p;
            while ((ed < words.length) && (totalLength + 1 + words[ed].length() <= maxWidth)) {
                totalLength += 1 + words[ed].length();
                ed += 1;
            }
            wordNum = ed - p;
            wordLength = totalLength - (wordNum - 1);    
            if (ed >= words.length) {avgSpace = 1; extraSpaceIdx = 0;} else
            if (wordNum == 1) {avgSpace = 0; extraSpaceIdx = 0;} else {
                avgSpace = (maxWidth - wordLength)/(wordNum - 1);
                extraSpaceIdx = (maxWidth - wordLength) % (wordNum - 1);
            }            
            StringBuilder line = new StringBuilder();
            for (int i = p; i < ed; i++) {
                line.append(words[i]);
                if (i < ed - 1) {
                    for (int j = 0; j < avgSpace; j++) {line.append(" ");}
                    if (i - p < extraSpaceIdx) {line.append(" ");}                
                }
            }
            p = ed;
            for (int j = line.length() + 1; j <= maxWidth; j++) {line.append(" ");}     
            result.add(line.toString());
        }
        return result;
    }
}