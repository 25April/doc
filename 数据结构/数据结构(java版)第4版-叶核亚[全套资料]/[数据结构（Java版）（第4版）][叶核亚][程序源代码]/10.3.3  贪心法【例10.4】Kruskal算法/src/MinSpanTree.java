//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��27��
//10.3   �㷨��Ʋ���
//10.3.3   ̰�ķ�
//5.  Kruskal�㷨ʵ��
//��2�� ��С��������

import java.util.Comparator;

public class MinSpanTree     //��С�������࣬�洢һ����Ȩ����ͼ��С�������ı߼��ϣ��Լ���С����
{
    private Triple[] mst;                                  //�洢��С�������ı߼���
    private int cost=0;                                    //��С����������
 
    //��Kruskal�㷨�����Ȩ����ͼ����С������������ۣ�ʹ����С�ѺͲ��鼯��
    //����nָ��ͼ�Ķ�������edges����ָ��ͼ�����бߣ�ÿ��ֻ��ʾһ�Σ���compָ���Ƚ���
//    public MinSpanTree(AbstractGraph<T> graph, Comparator<Triple> comp)
    public MinSpanTree(int n, Triple[] edges, Comparator<Triple> comp)
    {
        this.mst = new Triple[n-1];                        //mst�洢��С�������ı߼��ϣ�����Ϊ������-1
        Heap<Triple> minheap = new Heap<Triple>(true, edges, comp);
                                       //ʹ����С�Ѵ洢һ��ͼ�����бߣ��߰�Ȩֵ�Ƚϴ�С��comp�Ƚ����ṩ��
        UnionFindSet ufset = new UnionFindSet(n);          //���鼯
        System.out.println("���鼯��"+ufset.toString()+"����С�ѣ�"+minheap.toString());
        int i=0;                                           //��С�������е�ǰ�ߵ����
        for (int j=0; j<n; j++)                            //��ѡ����������-1������
        {
            Triple minedge = minheap.removeRoot();         //ɾ����С�ѵĸ�������Ȩֵ��С�ı�
            System.out.print("��С��"+minedge.toString()+"��");
            if (ufset.union(minedge.row, minedge.column)) 
            {                                              //����СȨֵ�ߵ������յ����ڵ��������Ϻϲ�
                this.mst[i++]=minedge;                     //�ñ߼�����С������
                this.cost+=minedge.value;                  //������С�������Ĵ���
                System.out.println("�����"+minedge.toString()+"��"+"���鼯��"+ufset.toString());
            }
        }
    }

    public String toString()                               //������С�������߼��ϵ������ַ���
    {
        String str="��С�������ı߼��ϣ�";
        for (int i=0; i<mst.length; i++)
            str+=mst[i]+" ";
        return str+"����С����Ϊ"+this.cost;
    }
    private static void print(boolean table[])             //���һά���飬�������һ����
    {
        System.out.print("("+table[0]);
        for (int i=1; i<table.length; i++)
            System.out.print(","+table[i]);
        System.out.println(")");
    }
}
//@author��Yeheya��2014-8-29
/*

 ??   //��Prim�㷨�����Ȩͼ����С������������ۣ�//ʹ����С��
    //����nָ��������, edges����ָ��ͼ�����б�
    public MinSpanTree(int n, Triple[] edges, Comparator<Triple> comp)
    {
        MinHeap<Triple> minheap = new MinHeap<Triple>(edges, comp);  //ʹ����С�Ѵ洢һ��ͼ�����бߣ��߰�Ȩֵ�Ƚϴ�С
        System.out.println("��С�ѣ�"+minheap.toString());
        mst = new Triple[n-1];                               //mst�洢��С�������ı߼��ϣ�����Ϊ������-1
        boolean vertmst[]=new boolean[n];
        print(vertmst);
        int i=0;                                           //��С�������е�ǰ�ߵ����
        vertmst[i]=true;   //������СȨֵ�ߵ�������ڵļ���
        for (int j=1; j<n; j++)                            //��ѡ����������-1������
        {
            Triple minedge = minheap.removeMin();            //ɾ����С�ѵĸ���������СȨֵ�ı�
            if (!vertmst[minedge.dest])   //��СȨֵ�ߵ������յ㲻��һ������
            {
               //vertmst[minedge.start]=true;   //������СȨֵ�ߵ�������ڵļ���
                vertmst[minedge.dest]=true;   //������СȨֵ�ߵ�������ڵļ���
                this.mst[i++]=minedge;                     //�ñ߼�����С������
                this.cost+=minedge.weight;                 //������С�������Ĵ���
                System.out.print("�����"+minedge.toString()+"��");
                print(vertmst);
            }
        }
    }

*/
