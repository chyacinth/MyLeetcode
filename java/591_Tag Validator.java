class Solution {
  static class Node {
    private boolean valid;
    private int p;

    Node(boolean valid, int p) {
      this.valid = valid;
      this.p = p;
    }
  }

  private boolean isValidName(String code) {
    return (code.length() <= 9 && code.matches("[0-9A-Z]+"));
  }

  private Node isClosed(String code, int p, String tagName) {
    while (p < code.length()) {
      while (p < code.length() && code.charAt(p) != '<') {
        ++p;
      }
      if (p < code.length()) {
        if (code.startsWith("<![CDATA[", p)) {
          int r = code.indexOf("]]>", p);
          if (r == -1) {
            return new Node(false, r + 1);
          } else {
            p = r + 3;
            continue;
          }
        }
        int r = code.indexOf('>', p);
        if (r == -1) {
          return new Node(false, r + 1);
        }
        String foundTagName = code.substring(p + 1, r);
        if (foundTagName.equals("/" + tagName)) {
          return new Node(true, r + 1);
        }
        if (!isValidName(foundTagName)) {
          return new Node(false, p + 1);
        }
        Node res = isClosed(code, r + 1, foundTagName);
        if (!res.valid) {
          return new Node(false, res.p);
        }
        p = res.p;
      }
    }
    return new Node(false, p);
  }

  public boolean isValid(String code) {
    if (code.charAt(0) != '<') {
      return false;
    }
    int r = code.indexOf('>');
    if (r == -1) { return false; }
    String foundTagName = code.substring(1, r);
    if (!isValidName(foundTagName )) { return false; }
    Node res = isClosed(code, r + 1, foundTagName);
    return (res.valid && res.p == code.length());
  }
}
