/*
下面这个算法解释得很好
# https://leetcode.com/problems/least-operators-to-express-number/discuss/208376/python2-O(log-target)-chinese
# https://leetcode.com/articles/least-operators-to-express-number/
class Solution:
    def leastOpsExpressTarget(self, x: int, target: int) -> int:
        def cost(i):
            return 2 if i == 0 else i
        N = []  # x-based representation of target
        while target > 0:
            target, r = divmod(target, x)
            N.append(r)
        # For every i-th most significant digit `n`, it can be accounted either by 
        # `n * cost(i)` or `(x - n) * cost(i) + cost(i + 1)`.
        # It may be proved (TODO: how?) that more operators are needed O.W., so the optimal
        #  value can be calculated digit by digit.
        
        # least operators required so far if there is no carry to the more significant digit
        nocarry = N[0] * cost(0)
        # least operators required so far if there is a carry to the more significant digit
        carry = (x - N[0]) * cost(0)
        for i, n in zip(range(1, len(N)), N[1:]):
            nocarry, carry = min(
                # 1. no carry from the previous && no carry to the next
                n * cost(i) + nocarry,
                # 2. carry from the previous && no carry to the next
                n * cost(i) + carry + cost(i)), \
                min(
                # 3. no carry from the previous && carry to the next
                (x - n) * cost(i) + nocarry,
                # 4. carry from the previous && carry to the next
                (x - n) * cost(i) + carry + cost(i) - 2 * cost(i))
            # For case 4., there are redundant operators.
            # e.g. 100 - 20 + 10 - 4 which can be reduced to 100 - 10 - 4
            # Generally, there are 2 unnecessary operators.
        return min(nocarry, carry + cost(len(N))) - 1
        */