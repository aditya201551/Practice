import java.util.*;
class GraphNode
{
    int size=0;
    class vertex
    {
        vertex next;
        HashSet<vertex> edge=new HashSet<>();
        int weight;
        vertex(int weight)
        {
            this.weight = weight;
            next=null;
            edge=null;
        }
    }

    vertex head=null;

    void addVertex(int weight)
    {
        size++;
        if(head==null) {
            head = new vertex(weight);
            return;
        }
        vertex tmp=head;
        while(tmp.next!=null)
            tmp=tmp.next;
        tmp.next=new vertex(weight);
    }

    void addEdge(int u, int v)
    {
        if(head==null) {
            System.out.println("Graph is empty");
            return;
        }
        vertex originVertex=head;
        while(originVertex!=null && originVertex.weight!=u)
            originVertex=originVertex.next;

        if(originVertex==null)
        {
            System.out.println("Cannot connect edge: INVALID vertex: INVALID origin vertex(u)");
            return;
        }


        vertex destVertex=head;
        while(destVertex!=null && destVertex.weight!=v)
            destVertex=destVertex.next;

        if(destVertex==null)
        {
            System.out.println("Cannot connect edge: INVALID vertex: INVALID destination vertex(v)");
            return;
        }
        originVertex.edge.add(destVertex);
    }

    void deleteVertex(int vertex)
    {
        if(head==null || (vertex<0 || vertex>size))
        {
            System.out.println("Graph is empty: Cannot delete an empty graph | INVALID vertex");
            return;
        }
        size--;
        if (head == null)
            return;

        vertex temp = head;


        if (vertex == 0)
        {
            head = temp.next;   // Change head
            return;
        }

        for (int i=0; temp!=null && i<vertex-1; i++)
            temp = temp.next;


        if (temp == null || temp.next == null)
            return;
        
        vertex next = temp.next.next;

        temp.next = next;
    }
}