/**
 * wordIdxByAbbr 记录缩写对应的原word和abbrevation。然后后面插的时候每次碰到map中记录过的情况，就把冲突的两个word都往后移一个，然后
 */
class Solution {
    static class WordIdx {
        String word;
        int idx;
        WordIdx(String word, int idx) {
            this.word = word;
            this.idx = idx;
        }
    }
    
    String getAbbr(String word, int idx) {
        if (word.length() <= 3 || idx == word.length() - 1) {
            return word;
        }
        if ((word.length() - 1 - idx) == 1) {
            return word;
        }
        return "" + word.substring(0, idx) + (word.length() - 1 - idx) + word.charAt(word.length() - 1);
    }
    
    public List<String> wordsAbbreviation(List<String> dict) {
        List<String> results = new ArrayList<>(Arrays.asList(new String[dict.size()]));
        System.out.println(results.size());
        Map<String, WordIdx> wordIdxByAbbr = new HashMap<String, WordIdx>();
        
        for (int i = 0; i < dict.size(); ++i) {
            int j = 1;
            String abbr = getAbbr(dict.get(i), j);
            while (wordIdxByAbbr.containsKey(abbr)) {
                ++j;
                WordIdx existWordIdx = wordIdxByAbbr.get(abbr);
                String existAbbr = getAbbr(existWordIdx.word, j);
                
                if (!wordIdxByAbbr.containsKey(existAbbr)) {
                    wordIdxByAbbr.put(existAbbr, new WordIdx(existWordIdx.word, existWordIdx.idx));
                    results.set(existWordIdx.idx, existAbbr);
                }
                
                abbr = getAbbr(dict.get(i), j);
            }
            wordIdxByAbbr.put(abbr, new WordIdx(dict.get(i), i));            
            results.set(i, abbr);
        }
        
        return results;
    }
}