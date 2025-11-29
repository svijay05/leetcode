package graph;

public class Graph {
    private static class AdjNode {
        private int source;
        private int destination;
        private int cost;
        private AdjNode next;
        public AdjNode(int src, int dst, int cst) {
            source = src;
            destination = dst;
            cost = cst;
            next = null;
        }
    }
     class AdjList {
        private AdjNode head;
    }
    int count;
    AdjList[] array;

    public Graph(int cnt) {
        count = cnt;
        array = new AdjList[cnt];
        for(int i=0; i<cnt; i++){
            array[i]=new AdjList();
            array[i].head = null;
        }
    }
    public void AddEdge(int source, int destination, int cost){
        AdjNode node = new AdjNode(source, destination, cost);
        node.next = array[source].head;
        array[source].head =node;
    }

    //bi directional edge
    public void AddBiEdge(int source, int destination, int cost)
    {
        AddEdge(source,destination,cost);
        AddEdge(destination,source,cost);
    }

    public void Print(){
        AdjNode ad;
        for(int i=0;i<count;i++){
            ad = array[i].head;
            if(ad != null){
                System.out.print("Vertex " + i+ " is connected to:");
                while(ad != null)
                {
                    System.out.print(ad.destination+ " ");
                    ad = ad.next;
                }
                System.out.println("");
            }
        }
    }
}