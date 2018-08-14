class Solution:
    def is_num(self, char):
        return (ord(char) >= ord('0') and ord(char) <= ord('9'))

    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        i = 0
        for i in range(len(str)):
            if str[i] != ' ':                
                break
        str = str[i:]
        if str == '':
            return 0
        sgn = 1
        if str[0] == '-':
            sgn = -1
        if (str[0] == '-' or str[0] == '+'):
            str = str[1:]
            if str == '':
                return 0

        for i in range(len(str)):
            if not (self.is_num(str[i])):
                str = str[:i]
                break
        
        if str == '':
            return 0

        ret = 0
        for i in range(len(str)):
            digit = ord(str[i]) - ord('0')
            ret = ret * 10
            ret = ret + digit

        ret *= sgn
        INT_MAX = 2147483647
        INT_MIN = -2147483648
        if ret > INT_MAX:
            return INT_MAX
        if ret < INT_MIN:
            return INT_MIN

        return ret