class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
    int i = 0;
    int n = words.length;
    List<String> result = new ArrayList<>();
    while (i < n) {
      int j = i;
      int cnt = 0;
      int wordLength = 0;
      while (j < words.length && wordLength + words[j].length() + cnt <= maxWidth) {
        wordLength += words[j].length();
        ++cnt;
        ++j;
      }
      int space = cnt == 1? maxWidth - wordLength : (maxWidth - wordLength) / (cnt - 1);
      int additionSpace = cnt == 1? 0 : (maxWidth - wordLength) % (cnt - 1);
      StringBuilder sb = new StringBuilder();
      for (int k = i; k < j; ++k) {
        --cnt;
        sb.append(words[k]);
        if (cnt > 0) {
          if (j == n) {
            sb.append(" ");
          } else {
            for (int t = 0; t < space; ++t) {
              sb.append(" ");
            }
            if (additionSpace > 0) {
              sb.append(" ");
            }
            --additionSpace;
          }
        }
      }
      while (sb.length() < maxWidth) {
        sb.append(" ");
      }
      result.add(sb.toString());
      i = j;
    }
    return result;
  }
}