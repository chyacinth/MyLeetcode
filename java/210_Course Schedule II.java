/**
 * 拓扑排序。。用栈记录入度为0的节点，然后遍历栈，删除栈中节点对应的边，把入度为0的重新放进去
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        List<List> adjList = new ArrayList();
        Stack<Integer> zeroDegree = new Stack<>();
        int[] inDegree = new int[numCourses];
        Arrays.fill(inDegree, 0);
        for (int i = 0; i < numCourses; ++i) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; ++i) {            
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            ++inDegree[prerequisites[i][0]];
        }
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                zeroDegree.push(i);
            }
        }
        while (!zeroDegree.isEmpty()) {
            int startNode = zeroDegree.pop();
            result.add(startNode);
            List<Integer> nodeEdge = adjList.get(startNode);
            for (Integer endNode : nodeEdge) {
                --inDegree[endNode];
                if (inDegree[endNode] == 0) {
                    zeroDegree.push(endNode);
                }
            }
            
        }        
        if (result.size() != numCourses) {
            return new int[0];
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < resultArray.length; ++i) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}