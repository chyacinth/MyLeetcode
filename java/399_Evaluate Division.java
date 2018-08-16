/**
 * 统计连通块的题目用邻接表做比较好，
 * 对于那种两点之间的距离唯一确定的图，要求两点之间距离可以用点A到A所在连通块代表点与
 * 点B到B所在连通块代表点之和（积）即可求得。
 * 只需要在统计连通快的时候记录每个点到代表点的距离和代表点是谁即可
 */
class Solution {
    double[] lengthToRepresent;
    int[] represent;
    boolean[] visited;
    
    public void dfs(
        double lengthPrev, int x, 
        List<List<Integer>> adjNodeList, List<List<Double>> adjWeightList) {
        visited[x] = true;
        for (int i = 0; i < adjNodeList.get(x).size(); ++i) {            
            double weight = lengthPrev * adjWeightList.get(x).get(i);
            int endNode = adjNodeList.get(x).get(i);
            if (!visited[endNode]) {
                represent[endNode] = represent[x];
                lengthToRepresent[endNode] = weight;
                dfs(weight, endNode, adjNodeList, adjWeightList);
            }
        }
    }
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {        
        int num = 0;
        HashMap<String, Integer> strNumMap = new HashMap<>();
        for (int i = 0; i < equations.length; ++i) {                        
            if (strNumMap.get(equations[i][0]) == null) {
                strNumMap.put(equations[i][0], num++);
            }            
            
            if (strNumMap.get(equations[i][1]) == null) {
                strNumMap.put(equations[i][1], num++);
            }                                    
        }
        
        List<List<Integer>> adjNodeList = new ArrayList<>();
        List<List<Double>> adjWeightList = new ArrayList<>();
        for (int i = 0; i < num; ++i) {
            adjNodeList.add(new ArrayList<Integer>());
            adjWeightList.add(new ArrayList<Double>());
        }
        for (int i = 0; i < equations.length; ++i) {
            int numA = strNumMap.get(equations[i][0]);
            int numB = strNumMap.get(equations[i][1]);
            double weight = values[i];
            adjNodeList.get(numA).add(numB);
            adjNodeList.get(numB).add(numA);
            adjWeightList.get(numA).add(weight);
            adjWeightList.get(numB).add(1 / weight);
        }
                
        lengthToRepresent = new double[num];
        represent = new int[num];
        Arrays.fill(lengthToRepresent, -1);
        visited = new boolean[num];
        for (int i = 0; i < num; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                lengthToRepresent[i] = 1;
                represent[i] = i;
                dfs(1, i, adjNodeList, adjWeightList);
            }
        }
        double[] results = new double[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            Integer numA = strNumMap.get(queries[i][0]);
            Integer numB = strNumMap.get(queries[i][1]);
            if ((numA == null) || (numB == null) || (represent[numA] != represent[numB]) ||
                (lengthToRepresent[numA] == -1) || (lengthToRepresent[numB] == -1)) {
                results[i] = -1;
            } else {
                results[i] = lengthToRepresent[numB] / lengthToRepresent[numA];
            }
        }
        return results;
    }    
}