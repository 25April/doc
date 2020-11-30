//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��3��
//4.2 ����
//����4.3�� ������������⡣

public class PrimeRing 
{	
    public PrimeRing(int max)                              //��1��max������
    {
        SortedSeqList<Integer> primeset = createPrime(max);//����˳���洢��������
        System.out.println("��������: "+primeset.toString());
        
        SeqList<Integer> ring = new SeqList<Integer>(max); //˳����洢������
        ring.insert(1);                                    //���������Integer(1)

        Queue<Integer> que = new SeqQueue<Integer>(max);   //�����ն��У���ʽ����Ҳ��
//        Queue<Integer> que = new LinkedQueue<Integer>();   //�����ն���
        for (int i=2; i<=max; i++)                         //2��maxȫ�����
            que.add(i);
        System.out.println("����: "+que.toString());
 
        int i=0;
        while (!que.isEmpty()) 
        {
            int key = que.poll();                          //����
//            System.out.print("����: "+k+"\t");
            if (primeset.contains(ring.get(i)+key))        //�ж�����������˳�����������ң�
            {
                i++;
                ring.insert(key);                          //���������Integer(key)
            }
            else
                que.add(key);                              //key�ٴ����
//            System.out.println("����: "+que.toString());
        }
        System.out.println("1��"+max+"������: "+ring.toString());
    }
    
    //���ذ���2��max����������������˳���Ҳ�ɷ���ѭ��˫����
    public SortedSeqList<Integer> createPrime(int max)
    {
        if (max<=0)
            return null;
        SortedSeqList<Integer> primeset=new SortedSeqList<Integer>(max*2);//����˳���洢����
        primeset.insert(2);                                //�����֪����С����
        for (int key=3;  key<max*2;  key+=2)               //��������������ż���������
        {
            int i=0;
            while (i<primeset.size() && key % primeset.get(i)!=0)//��primeset�е���������key
                i++;
            if (i==primeset.size())                        //key������
                primeset.insert(key);                      //����˳���β�������ֵ
        }
        return primeset;
    }    
    
    public static void main(String args[])
    {
         new PrimeRing(10);
    }
}

/*
�������н�����£�
��������: SortedSeqList(2, 3, 5, 7, 11, 13, 17, 19) 
����: SeqQueue(2,3,4,5,6,7,8,9,10)
1��10������: SeqList(1, 2, 3, 4, 7, 10, 9, 8, 5, 6) 


��������: (2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37) 
����: SeqQueue(2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
1��20������: (1, 2, 3, 4, 7, 10, 13, 16, 15, 8, 9, 14, 17, 20, 11, 12, 19, 18, 5, 6) 

*/
//����������̬��Ա�������£���Ϊ����Ҫ�ӹ��췽����á�
//    static SortedSeqList<Integer> primeset; //��������

//@author��Yeheya��2014-10-28