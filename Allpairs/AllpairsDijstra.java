import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;



class Vertex implements Comparable<Vertex> {
    public final String name;
    public List<GraphEdge> adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;

    public Vertex(String argName) {
        name = argName;
        adjacencies = new ArrayList<GraphEdge>();
    }

    public void addEdge(GraphEdge e) {
        adjacencies.add(e);
    }

    public String toString() {
        return name;
    }

    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }

}

class GraphEdge{
    public final Vertex target;
    public final double weight;

    public GraphEdge(Vertex argTarget, double argWeight) {
        target = argTarget;
        weight = argWeight;
    }
}

class AllpairsDijstra
{
    
    public static void print_graph()
    {
    }

    public static void ReinitWeights(Map<String, Vertex> vertexMap)
    {
        Collection<Vertex> vertices = vertexMap.values();
        
        for(Vertex u:vertices)
        {
            u.minDistance = Double.POSITIVE_INFINITY;
        }
    }
    public static void InitialisePQ(Vertex source, PriorityQueue<Vertex> vertexQueue)
    {
        System.out.println("Initialise PQ of size"+vertexQueue.size());
        source.minDistance = 0.;
        vertexQueue.add(source);

    }

    public static void dijstraPath(Vertex source,PriorityQueue<Vertex> vertexQueue)
    {

        while (!vertexQueue.isEmpty())
        {
            Vertex u = vertexQueue.poll();
            //System.out.println("Shortest Path Cost to " + u + " is: " + u.minDistance);
            // Visit each Edge exiting u

            for (GraphEdge e : u.adjacencies) {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU;
                    v.previous = u;
                //    System.out.print("Adding v");
                    vertexQueue.add(v);
                }
                

            }
        }
    }


// Driver program to test above functions
    public static void main(String args[])
    {
    
    
        Map<String, Vertex> vertexMap = new HashMap<String, Vertex>();
        BufferedReader in = null;
        try {
                in = new BufferedReader(new FileReader("try2.txt"));
                String line;
                boolean inVertex = true;
    
                while ((line = in.readLine()) != null) {
    
    
                        //store the edges
                        String[] parts = line.split(" ");
                        String vFrom = parts[0];
                        String vTo = parts[1];
                        //System.out.println("vFrom "+vFrom+" vTo "+vTo);
                        if(!vertexMap.containsKey(vFrom))
                        {
                            Vertex v= new Vertex(vFrom);
                            vertexMap.put(vFrom, v);
                        }
                        if(!vertexMap.containsKey(vTo))
                        {
                            Vertex v1= new Vertex(vTo);
                            vertexMap.put(vTo, v1);
                        }
    
    
                        double weight = Double.parseDouble(parts[2]);
                        Vertex v = vertexMap.get(vFrom);
                        if (v != null) {
                            v.addEdge(new GraphEdge(vertexMap.get(vTo), weight));
    
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            finally{
                if(in!= null)
                    try {
                        in.close();
                    } catch (IOException ignore) {
                    }
            }
            
        Collection<Vertex> vertices = vertexMap.values();
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        //Vertex source = vertices.iterator().next();
        for(Vertex source:vertices)
        {
            System.out.println("From " + source+":");
            //Vertex source = vertexMap.get(source);
            
        
            InitialisePQ(source,  vertexQueue);
            dijstraPath(source, vertexQueue);
            
            
            for (Vertex v : vertices)
            {
        	System.out.println("Shortest Path Cost to " + v + " is: " + v.minDistance);
                v.minDistance = Double.POSITIVE_INFINITY;
        
	    }
            System.out.println();
            
            int vertexsz = vertexQueue.size();
	    for(int i = 0; i < vertexsz; i++)
            {
		vertexQueue.remove();
	    }
            
        }
    
    }
}
