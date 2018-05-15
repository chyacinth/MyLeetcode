/*
dfs，写的时候不能太快，要有自己的套路，我的套路是：dpf(原始字符串，当前准备下手的字符编号st，当前个数num等，最后是当前结果数组result)
最后结果存入results中，先根据st,num，字符串判断是否合法，再根据st,num，字符串判断是否结束，
之后再递归
*/
class Solution {
    List<String> results = new ArrayList<>();
    public void dfs(String s, int num, int st, List<Integer> result) {
        int len = st + 1;
        if (len > 3 * num || len < num) {return;}
        if (num == 0) {
            StringBuilder str = new StringBuilder();
            for (int i = 3; i >= 0; i--){
                str.append(result.get(i));
                if (i > 0) str.append('.');
            }
            results.add(new String(str));
        }        
        int sum = 0, cnt = 1;
        for (int i = st; i >= st - 2; i--) {
            cnt *= 10;
            if (i < 0) break;
            int tmp = (int)s.charAt(i) - '0';
            sum += tmp * (cnt / 10);
            if (tmp == 0 && i < st) continue;
            if (sum >= 0 && sum <256) {
                result.add(sum);
                dfs(s, num - 1, i - 1, result);
                result.remove(result.size() - 1);
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 4, s.length() - 1, new ArrayList<Integer>());
        return results;
    }
}