import java.util.HashMap;
import java.util.Map;

public class Node {
    private String name;
    public static Node NULL_NODE = new Node(null);
    public Map<Node, Integer> ways = new HashMap<>();
    
    Node(String n){
        this.name = n;
    }
    
    public Map<Node, Integer> getWays() {
        return ways;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
    public void addWays(Node nd, int distance){
        this.getWays().put(nd,distance);
    }

}
