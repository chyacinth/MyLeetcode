class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if (x < 0):
            return False        

        if (x == 0):
            return True

        powerl = -1
        while pow(10, powerl) <= x:
            powerl += 1

        powerl -= 1        
        powerr = 0
        length = powerl

        for _ in range(length + 1):
            if ((x // pow(10,powerl)) % 10) != ((x // pow(10,powerr)) % 10):
                return False
            powerl -= 1
            powerr += 1

        return True