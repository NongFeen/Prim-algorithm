import java.util.ArrayList;

public class SpanningTrees {
    private ArrayList<Node> ndList = new ArrayList<>();
    private ArrayList<String> ndNameList = new ArrayList<>();
    private String[] input;
    SpanningTrees(String[] wayList){
        this.input = wayList;
        this.createNodeList();
        this.addAllway();
    }
    
    public ArrayList<Node> getNdList() {
        return ndList;
    }

    public ArrayList<String> getNdNameList() {
        return ndNameList;
    }

    public String[] getInput() {
        return input;
    }

    private void addAllway(){
        for (Node nd : this.getNdList()) {
            for(int i =0;i<this.getInput().length;i++){
                String[] str = this.getInput()[i].split(",");
                if(nd.getName().equals(str[0])){
                    for(Node target : this.getNdList()){
                        if(target.getName().equals(str[1])){
                        nd.addWays(target,Integer.parseInt(str[2]));
                        target.addWays(nd,Integer.parseInt(str[2]));
                        break;
                        }
                    }
                }
            }
        }
    }
    private void createNodeList(){
        for(int i =0;i<this.getInput().length;i++){
            String[] str = this.getInput()[i].split(",");
            for(int j=0;j<2;j++)
            {
                if(!this.getNdNameList().contains(str[j])){
                    this.getNdList().add(new Node(str[j]));
                    this.getNdNameList().add(str[j]);
                }
            }
        }
    }
    public void findMinSpanTree(String start){
        Node startNode =new Node("Incorrect Input");
        ArrayList<Node> storeList = new ArrayList<>();
        for(Node nd:this.getNdList()){//find startnode
            if(nd.getName().equals(start))
            startNode=nd;
        }
        storeList.add(startNode);

        while(storeList.size()<this.getNdList().size()){//loop till full
            Node lowestNode = Node.NULL_NODE;
            int lowestDistance = Integer.MAX_VALUE;
            Node originOfLowestNode = Node.NULL_NODE;
            for(Node node : storeList){//loop in store list to find next node
                for(var map : node.getWays().entrySet()){
                    if(map.getValue()<lowestDistance && !storeList.contains(map.getKey())){
                        lowestNode = map.getKey();
                        lowestDistance = map.getValue();
                        originOfLowestNode = node;
                    }
                }
            }
            System.out.println(originOfLowestNode + " \t--->   " +lowestNode +" "+ lowestDistance);
            storeList.add(lowestNode);
        }
    }
}
