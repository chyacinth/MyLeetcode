class FileSystem {

    class Node {
        private boolean isFile;
        private String name;
        private StringBuilder content;
        private Map<String, Node> nameToNode = new HashMap<>();
        
        Node(boolean isFile, String name) {
            this.isFile = isFile;
            this.name = name;
            if (isFile) {
                content = new StringBuilder();
            }
        }
    }
    
    private Node rootNode = new Node(false, "");
    
    private Node getFile(String rawPath) {
        String[] paths = rawPath.split("/");
        String fileName = paths[paths.length - 1];
        Node node = rootNode;
        for (int i = 0; i < paths.length; ++i) {
            String path = paths[i];
            if (path.isEmpty()) { continue; }
            if (!node.nameToNode.containsKey(path)) {
                if (i == paths.length - 1) {
                    node.nameToNode.put(path, new Node(true, path));
                } else {
                    node.nameToNode.put(path, new Node(false, path));
                }
            }
            node = node.nameToNode.get(path);
        }
        return node;
    }
    
    public FileSystem() {
        
    }
    
    public List<String> ls(String rawPath) {
        String[] paths = rawPath.split("/");
        Node node = rootNode;
        for (String path : paths) {
            if (path.isEmpty()) { continue; }
            node = node.nameToNode.get(path);
        }
        List<String> result = new ArrayList<>();
        if (node.isFile) {
            result.add(node.name);
        } else {
            result = node
                .nameToNode
                .keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList());
        }
        return result;
    }
    
    public void mkdir(String rawPath) {
        String[] paths = rawPath.split("/");
        Node node = rootNode;
        for (String path : paths) {
            if (path.isEmpty()) { continue; }
            if (!node.nameToNode.containsKey(path)) {
                node.nameToNode.put(path, new Node(false, path));
                System.out.println("Path is: " + path);
            }
            node = node.nameToNode.get(path);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        Node fileNode = getFile(filePath);
        fileNode.content.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        Node fileNode = getFile(filePath);
        return fileNode.content.toString();
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */