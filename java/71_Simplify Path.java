/*
use Stack
注意逻辑，先consume /，然后直接捕获非/字符串，判断进行字符串相应操作
*/
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int i = 0, slen = path.length();
        while (i < slen) {
            //consume slash
            if (path.charAt(i) == '/') {
                while (i < slen && path.charAt(i) == '/') {i += 1;}
                continue;
            }
                        
            //consume other symbol
            else {
                StringBuilder folder = new StringBuilder();
                while (i < slen && path.charAt(i) != '/') {
                    folder.append(path.charAt(i));
                    i += 1;
                }
                String folderStr = folder.toString();
                if (folderStr.equals("..")) {
                    if (!stack.isEmpty())
                        stack.pop();
                }
                else if (!folderStr.equals(".")) {
                    stack.push(folder.toString());
                }
            }
        }
        Iterator<String> iter = stack.iterator();
        if (!iter.hasNext()) return "/";
        StringBuilder result = new StringBuilder();
        while (iter.hasNext()) {
            result.append('/' + iter.next());
        }
        return result.toString();
    }
}