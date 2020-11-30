//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��26��
//10.1 ���Ͽ��
//10.1.3 ����
//����10.1��  ʹ�ü��������������ͬ����4.3�� ������������⡣

import java.util.*;

public class PrimeRing_��10_1 
{
    public PrimeRing_��10_1(int max)                        //��1��max������
    {
        Collection<Integer> primeset = createPrime(max);   //��������
        System.out.println("��������: "+primeset.getClass().getName()+primeset.toString());
        
        List<Integer> ring = new ArrayList<Integer>(max);  //�����б��洢������
        ring.add(1);                                       //���������Integer(1)

        Queue<Integer> que = new LinkedList<Integer>();    //������������Ϊ����
        for (int i=2; i<=max; i++)                         //2��maxȫ�����
            que.add(i);                                    //���
        System.out.println("����: "+que.getClass().getName()+que.toString());
 
        int i=0;
        while (!que.isEmpty()) 
        {
            int key = que.poll();                          //����
//            System.out.print("����: "+key+"\t");
            if (primeset.contains(ring.get(i)+key))        //�ж����������ϰ���Ԫ��
            {
                i++;
                ring.add(key);                             //���������Integer(key)
            }
            else
                que.add(key);                              //key�ٴ����
//            System.out.println("����: "+que.toString());
        }
        System.out.println("1��"+max+"������: "+ring.getClass().getName()+ring.toString());
    }
    
    //���ذ���2��max�����������ļ��ϡ��㷨ͬ��4.3
    public Collection<Integer> createPrime(int max)
    {
        if (max<=0)
            return null;
//        Collection<Integer> primeset=new ArrayList<Integer>(max*2);    //�����б�˳���洢��û������
//        Collection<Integer> primeset=new LinkedList<Integer>(); //����ѭ��˫����洢��û������
        Collection<Integer> primeset=new TreeSet<Integer>();    //�����ϣ�ƽ�������������
        primeset.add(2);                                   //�����֪����С����2
        for (int key=3;  key<max*2;  key+=2)               //��������������ż���������
        {
            boolean yes=true;
            Iterator<Integer> it = primeset.iterator();    //���ص���������
            while (yes && it.hasNext())                    //���к��Ԫ�أ�ʹ�õ���������һ������
                yes = key % it.next()!=0;                  //��primes�е���������key
            if (yes)                                       //key������
                primeset.add(key);                         //��ӵ�����
        }
        return primeset;
    } 
    
    public static void main(String args[])
    {
         new PrimeRing_��10_1(10);
    }
}

/*
�������н�����£�
��������: java.util.TreeSet[2, 3, 5, 7, 11, 13, 17, 19]
����: java.util.LinkedList[2, 3, 4, 5, 6, 7, 8, 9, 10]
1��10������: java.util.ArrayList[1, 2, 3, 4, 7, 10, 9, 8, 5, 6]


*/

/*
//����������̬��Ա�������£���Ϊ����Ҫ�ӹ��췽����á�
//    static Collection<Integer> primeset; //��������

 
 //�ȸ��������ƽ�������������ȷ���������ṹ
public static <T> void preorder(TreeSet<T> treeset)
{
}
//�����������У�����һ��TreeMap����map��map����root����������ṹ��
//�����ɼ����ṹ����˽����ʱ�������޷�д����

*/
//@author��Yeheya��2014-10-26