/*
为每一个网站分配随机字符串（定长）
使用双向Map(就是两个Map)，记录short->long和long->short
*/
public class Codec {
    private HashMap<String, String> short2long = new HashMap<>();
    private HashMap<String, String> long2short = new HashMap<>();
    final String alphabet = "abcdefghijklmnopqrstuvwxyz" + 
                            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                            "0123456789";
    private int len = alphabet.length();
    
    public String getRandomString(int n) {
        Random rd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(alphabet.charAt(rd.nextInt(len)));
        }
        return sb.toString();
    }
    
    // Encodes a URL to a shortened URL.    
    public String encode(String longUrl) {
        String shortUrl = getRandomString(8);
        while (short2long.get(shortUrl) != null) {
            shortUrl = getRandomString(8);
        }
        long2short.put(longUrl, shortUrl);
        short2long.put(shortUrl,longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return short2long.get(shortUrl);
    }        
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));