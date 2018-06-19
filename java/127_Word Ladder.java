/*
深搜，可以看成图论题，只是可以不用O(n^2)的时间建图，考虑到wordLength一般<<dictLength，因此找一个字符串的所有联通字符串
可以通过对该字符串的每个字符替换，看替换后的字符串是否在dict中，如果在就说明联通
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> queueHash = new HashSet<>();
        Set<String> dictHash = new HashSet<>(wordList);
        Queue<String> queue = new ArrayDeque<>();        
        if (!dictHash.contains(endWord)) return 0;
        queue.add(beginWord);
        queueHash.add(beginWord);
        int cnt = 0;
        String curStr;    
        while (!queue.isEmpty()) {
            int sz = queue.size();
            cnt += 1;
            for (int i = 0; i < sz; i++) {
                curStr = queue.poll();                
                for (String nextStr : getNextStrings(new StringBuilder(curStr), dictHash)) {
                    if (queueHash.contains(nextStr)) {continue;}
                    if (nextStr.equals(endWord)) return (cnt + 1);
                    queueHash.add(nextStr);
                    queue.add(nextStr);
                }
            }
        }
        return 0;
    }
    
    private List<String> getNextStrings(StringBuilder str, Set<String> dictHash) {
        List<String> results = new ArrayList<String>();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                str.setCharAt(i, ch);
                String s = str.toString();
                if (dictHash.contains(s))
                    results.add(s);
            }
            str.setCharAt(i, temp);
        }
        return results;
    }
}