//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��11��
//4.2.5   ���ȶ���
//����4.4�� ���̰����ȼ����ȹ���

public class Process  implements Comparable<Process>       //����
{
    private String name;                                   //������
    private int priority;                                  //���ȼ�
                
    //������̣�����name��priority�ֱ�ָ�������������ȼ���
    //���ȼ���ΧΪ1��10��1��ͣ�10��ߣ�Ĭ��5������ʱ�׳���Ч�����쳣
    public Process(String name, int priority)
    {
        this.name = name;
        if (priority>=1 && priority<=10)
            this.priority = priority;
        else throw new IllegalArgumentException("priority="+priority);
    }
    public Process(String name)
    {
        this(name, 5);
    }
    public String toString()
    {
        return "("+this.name+","+this.priority+")";
    }

    public int compareTo(Process p)                        //���̰����ȼ��Ƚϴ�С
    {
        return this.priority - p.priority;
    }
}

class Process_ex 
{
    public static void main(String args[])
    {
        Process process[]={new Process("A",4),new Process("B",3),new Process("C"),
                           new Process("D",4),new Process("E",10),new Process("F",1)};
        PriorityQueue<Process> que = new PriorityQueue<Process>(false); //�����ն��У�����
//        PriorityQueue2<Process> que = new PriorityQueue2<Process>(false); //��10��
        System.out.print("��ӽ��̣�");
        for (int i=0; i<process.length; i++)
        {
            que.add(process[i]);                           //�������
            System.out.print(process[i]+" ");
        }
        System.out.print("\n���ӽ��̣�");
        while (!que.isEmpty()) 
            System.out.print(que.poll().toString()+" ");   //����
        System.out.println();
    }
}
    
/*
���γ������н�����¡�
��ӽ��̣�(A,4) (B,3) (C,5) (D,4) (E,10) (F,1) 
���ӽ��̣�(E,10) (C,5) (A,4) (D,4) (B,3) (F,1)        //����

��ӽ��̣�(A,4) (B,3) (C,5) (D,4) (E,10) (F,1)
���ӽ��̣�(F,1) (B,3) (A,4) (D,4) (C,5) (E,10)        //����

*/

//author��Yeheya��2014-9-23

//��10�³������н��ͬ�ϡ�
