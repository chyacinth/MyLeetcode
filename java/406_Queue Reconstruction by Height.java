/**
 * 重排序，顺序为：高的人在前，高度相同，则前面人少的人在前。这是因为这样做的话，我们按这个顺序来定位人，可以给每个人找到一个位置的位置
 * 然后按顺序遍历，并建立起队伍。在遍历第i个人时，前面的人已经建立好。根据这个人前面有多少个人可以唯一确定他在当前队伍中的位置。
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;        
        Arrays.sort(people, (int[] x, int[] y) -> {
            if (x[0] != y[0]){
                return y[0] - x[0];
            } else { 
                return x[1] - y[1]; 
            }
        });        
        List<int[]> resultList = new ArrayList<>();
        for (int i = 0; i < len; ++i) {
            int[] temp = {people[i][0], people[i][1]};
            resultList.add(temp[1], temp);            
        }
        for (int i = 0; i < len; i++) {
            int[] temp = resultList.get(i);
            people[i][0] = temp[0];
            people[i][1] = temp[1];
        }
        return people;
    }
}