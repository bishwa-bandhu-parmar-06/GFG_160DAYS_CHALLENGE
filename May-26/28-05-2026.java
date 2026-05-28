// Vertical Sum
// Difficulty: MediumAccuracy: 64.76%Submissions: 54K+Points: 4Average Time: 20m
// Given a binary tree having n nodes, find the vertical sum of the nodes that are in the same vertical line. Return all sums through different vertical lines starting from the left-most vertical line to the right-most vertical line.

class Solution{

    public ArrayList <Integer> verticalSum(Node root) {

        ArrayList<Integer>a=new ArrayList<>();

        if(root==null){

            return a;

        }

        else{

            Map<Integer,ArrayList<Integer>>map=new TreeMap<>();

            Queue<Pair>q=new LinkedList<>();

            q.add(new Pair(root,0));

            while(!q.isEmpty()){

                Pair pair=q.poll();

                if(!map.containsKey(pair.hd)){

                    ArrayList<Integer>b=new ArrayList<>();

                    b.add(pair.node.data);

                    map.put(pair.hd,b);

                   

                }

                else{

                    map.get(pair.hd).add(pair.node.data);

                }

                

                if(pair.node.left!=null){

                    q.add(new Pair(pair.node.left,pair.hd-1));

                    

                }

                if(pair.node.right!=null){

                    q.add(new Pair(pair.node.right,pair.hd+1));

                }

            }

            //System.out.print(map);

            int sum=0;

            for(Map.Entry<Integer,ArrayList<Integer>>e:map.entrySet()){

                ArrayList<Integer>t=new ArrayList<>();

                t.addAll(e.getValue());

                for(int i:t){

                    sum+=i;

                }

                a.add(sum);

                sum=0;

            }

            return a;

        }

    }

    

    class Pair{

        Node node;

        int hd;

        Pair(Node node,int hd){

            this.node=node;

            this.hd=hd;

        }

    }

}