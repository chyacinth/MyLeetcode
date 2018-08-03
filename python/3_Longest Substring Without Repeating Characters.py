class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        m = 0
        cur = 0
        dict = {}
        for i in range(len(s)):
            if s[i] not in dict:
                cur = cur + 1
            else:
                cur = min(cur+1, i - dict[s[i]])
            
            dict[s[i]] = i
            m = max(m, cur)
        return m