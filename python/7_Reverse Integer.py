class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        ret = 0
        sgn = 1

        if x < 0:
            sgn = -1
            x = -x

        while x > 0:
            ret = ret * 10
            ret = ret + (x % 10)
            x = x // 10            

        ret = ret * sgn

        if (ret > (1<<31) - 1) or (ret < -(1<<31)):
            ret = 0

        return ret