//�����ݽṹ��Java�棩����4�棩ϰ���𡷣����ߣ�Ҷ���ǣ�2015��8��12��
//7.4.2   ��С�������Ĺ����㷨
//��ϰ7-15�� ��Ȩ����ͼG6��G7_Hexagon��ʾ7�����㣬����������
//��ϰ����7-15���μ��� Prim�㷨
//7.5.1 ��Դ���·����Dijkstra�㷨
//������7��Dijkstra�㷨

public class G7_HexagonStar 
{
    public static void main(String args[])
    {
        String graphname="G7_HexagonStar";
        String[] vertices={"A","B","C","D","E","F","G"};
        Triple[] edges={new Triple(0,1,7),  new Triple(0,5,13), new Triple(0,6,6),
                        new Triple(1,0,7),  new Triple(1,2,12), new Triple(1,6,4),
                        new Triple(2,1,12), new Triple(2,3,5),  new Triple(2,6,19), 
                        new Triple(3,2,5),  new Triple(3,4,11), new Triple(3,6,20),
                        new Triple(4,3,11), new Triple(4,5,10), new Triple(4,6,16),
                        new Triple(5,0,13), new Triple(5,4,10), new Triple(5,6,15),
                        new Triple(6,0,6),  new Triple(6,1,4),  new Triple(6,2,19),
                        new Triple(6,3,20), new Triple(6,4,16), new Triple(6,5,15)};
//        MatrixGraph<String> graph = new MatrixGraph<String>(vertices, edges);
      AdjListGraph<String> graph = new AdjListGraph<String>(vertices, edges);     //�ڽӱ��ʾ��ͼ
//        System.out.print("��Ȩ����ͼ"+graphname+"��"+graph.toString());

        System.out.print("������ȱ���ͼ"+graphname+"��");
        for (int i=0; i<graph.vertexCount(); i++)
            graph.BFSTraverse(i);
        
/*        System.out.print("��Ȩ����ͼ"+graphname+"��prim�㷨��");
        graph.minSpanTree();

        System.out.print("��Ȩ����ͼ"+graphname+"��Dijkstra�㷨��");
        for (int i=0; i<graph.vertexCount(); i++)
            graph.shortestPath(i);               //����vi�ĵ�Դ���·����Dijkstra�㷨
            */
    }
}
/*
�������н�����£�
��Ȩ����ͼG6_G7_Hexagon�����㼯�ϣ�SeqList(A, B, C, D, E, F, G) 
�ڽӾ���:  
     0     7     ��     ��     ��    13     6
     7     0    12     ��     ��     ��     4
     ��    12     0     5     ��     ��    19
     ��     ��     5     0    11     ��    20
     ��     ��     ��    11     0    10    16
    13     ��     ��     ��    10     0    15
     6     4    19    20    16    15     0
     ���߱�
0 -> ((0,1,7),(0,5,13),(0,6,6))
1 -> ((1,0,7),(1,2,12),(1,6,4))
2 -> ((2,1,12),(2,3,5),(2,6,19))
3 -> ((3,2,5),(3,4,11),(3,6,20))
4 -> ((4,3,11),(4,5,10),(4,6,16))
5 -> ((5,0,13),(5,4,10),(5,6,15))
6 -> ((6,0,6),(6,1,4),(6,2,19),(6,3,20),(6,4,16),(6,5,15))

������ȱ���ͼG7_HexagonStar��{ A B F G C E D } 
{ B A C G F D E } 
{ C B D G A E F } 
{ D C E G B F A } 
{ E D F G C A B } 
{ F A E G B D C } 
{ G A B C D E F } 

prim�㷨��
mst�߼��ϣ�(0,1,7),(0,2,99999),(0,3,99999),(0,4,99999),(0,5,13),(0,6,6),
mst�߼��ϣ�(0,6,6),(6,2,19),(6,3,20),(6,4,16),(0,5,13),(6,1,4),
mst�߼��ϣ�(0,6,6),(6,1,4),(6,3,20),(6,4,16),(0,5,13),(1,2,12),
mst�߼��ϣ�(0,6,6),(6,1,4),(1,2,12),(6,4,16),(0,5,13),(2,3,5),
mst�߼��ϣ�(0,6,6),(6,1,4),(1,2,12),(2,3,5),(0,5,13),(3,4,11),
mst�߼��ϣ�(0,6,6),(6,1,4),(1,2,12),(2,3,5),(3,4,11),(4,5,10),
��С�������ı߼��ϣ�(0,6,6) (6,1,4) (1,2,12) (2,3,5) (3,4,11) (4,5,10) ����С����Ϊ48

Dijkstra�㷨��
A�ĵ�Դ���·����(A,B)����7��(A,B,C)����19��(A,B,C,D)����24��(A,G,E)����22��(A,F)����13��(A,G)����6��
B�ĵ�Դ���·����(B,A)����7��(B,C)����12��(B,C,D)����17��(B,G,E)����20��(B,G,F)����19��(B,G)����4��
C�ĵ�Դ���·����(C,B,A)����19��(C,B)����12��(C,D)����5��(C,D,E)����16��(C,D,E,F)����26��(C,B,G)����16��
D�ĵ�Դ���·����(D,C,B,A)����24��(D,C,B)����17��(D,C)����5��(D,E)����11��(D,E,F)����21��(D,G)����20��
E�ĵ�Դ���·����(E,G,A)����22��(E,G,B)����20��(E,D,C)����16��(E,D)����11��(E,F)����10��(E,G)����16��
F�ĵ�Դ���·����(F,A)����13��(F,G,B)����19��(F,E,D,C)����26��(F,E,D)����21��(F,E)����10��(F,G)����15��
G�ĵ�Դ���·����(G,A)����6��(G,B)����4��(G,B,C)����16��(G,D)����20��(G,E)����16��(G,F)����15��
                        
*/
//@author��Yeheya��2015-8-12

