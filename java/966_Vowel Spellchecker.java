class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> lowerWords = new HashMap<>();
        Map<String, String> vowelWords = new HashMap<>();
        for (String word : wordlist) {
            String lowerWord = word.toLowerCase();
            lowerWords.putIfAbsent(lowerWord, word);
            vowelWords.putIfAbsent(lowerWord.replaceAll("[aeiou]", "*"), word);
            
        }        
        List<String> result = new ArrayList<>();
        for (String query : queries) {
            if (words.contains(query)) {
                result.add(query);
            } else {
                String lowerQuery = query.toLowerCase();
                if (lowerWords.containsKey(lowerQuery)) {
                    result.add(lowerWords.get(lowerQuery));
                } else {
                    String vowelQuery = lowerQuery.replaceAll("[aeiou]", "*");
                    if (vowelWords.containsKey(vowelQuery)) {
                        result.add(vowelWords.get(vowelQuery));
                    } else {
                        result.add("");
                    }
                }
            }
        }
        return result.toArray(new String[0]);
    }
}