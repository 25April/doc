//�����ݽṹ��Java�棩����4�棩ϰ���𡷣����ߣ�Ҷ���ǣ�2014��12��26��
//��2.3 ���Ա����ʽ�洢��ʵ��
//��ʵ��2-7��ϰ����������Ԫ�ص�ƽ��ֵ��

public class SinglyList_average 
{
    //�㷨���У���Ч�ʵͣ�ʱ�临�Ӷ���O(n*n)��
    public static double average(SinglyList<Integer> list) //������Ԫ�ص�ƽ��ֵ
    {
        int sum=0;
        for(int i=0; i<list.size(); i++)                   //size()��ʱ����O(n)
            sum += list.get(i).intValue();                 //get(i)��ʱ����O(n)
        return (double)sum/list.size();                    //ʵ���������ڳ���Ϊ0����
    }
	
    public static double averageAll(SinglyList<Integer> list)//������Ԫ�ص�ƽ��ֵ��ʱ�临�Ӷ���O(n)
    {
        int sum=0, count=0;
//        for (Node<Integer> p=list.head.next;  p!=null;  p=p.next)   //����������O(n)��Ҫ��head��nextȨ�ޱ�����public
        for (Node<Integer> p=list.first();  p!=null;  p=list.next(p))   //�Ե�����ʽ����������O(n)
        {
            sum += p.data.intValue();                      //Ԫ��ֵ���
            count++;                                       //ͳ��Ԫ�ظ���
        }
        if (list.isEmpty())
            throw new IllegalArgumentException("���ܶԿյ��������ƽ��ֵ��"); //�׳���Ч�����쳣
        return (double)sum/count;                          //����ƽ��ֵ��ʵ�����������˳���Ϊ0����
    }
    
    public static void main(String args[])
    {
        Integer[] values={10,20,30}; 
    	SinglyList<Integer> list = new SinglyList<Integer>(values);//Array1.random(10,100));//����1.4//���ز���n�������������
        System.out.println("list="+list.toString());
        System.out.println("average(list)="+average(list));
        System.out.println("averageAll(list)="+averageAll(list));
        System.out.println("averageExceptMaxMin(list)="+averageExceptMaxMin(list));
    }

    //��ʵ��2-7��  ����3����2.3��
    //ȥ����߷ֺ���ͷ֣�����ƽ��ֵ��O(n)
    public static double averageExceptMaxMin(SinglyList<Integer> list)
    {
        if (list.isEmpty())
            throw new IllegalArgumentException("���ܶԿյ��������ƽ��ֵ��"); //�׳���Ч�����쳣
        int sum=0, i=0, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        Node<Integer> p=list.head.next;               //Ҫ��headȨ�ޱ�����public
        while (p!=null)                               //����������
        {
            int value = p.data.intValue();
            sum += value; 
            if (value>max)
                max = value;
            if (value<min)
                min = value;
            p = p.next;
            i++;
        }
        if (i==1 || i==2)
            return (double)sum/i;                     //��������Ԫ�ص�ƽ��ֵ�������˳���Ϊ0����
        return (double)(sum-max-min)/(i-2);           //����ȥ����߷ֺ���ͷֺ��ƽ��ֵ
    }
}
/*
�������н�����£�    
list=(10,20,30)
average(list)=20.0
averageAll(list)=20.0
averageExceptMaxMin(list)=20.0

*/
/*�޸�
double average(SeqList<Student> list)                   //��ƽ��ֵ
{
    int n=stulist.length();                         //˳�����
    double sum=0;
    for (int i=0; i<n; i++)
         sum += stulist.get(i).score;               //�˴�get(i)����Student�ṹ����
    return n>0 ? sum/n: 0;                          //����0��Ԫ�ؽ�����������Ϊ0����
}
double average(SinglyList<Student> list)    //��ƽ��ֵ
{
    int n=stulist.length();                           //��������
    if (n>0)
    {
        double sum=0;
        for (int i=0; i<n; i++)
             sum += stulist.get(i).score;             //�˴�get(i)����Student�ṹ����
        return sum/n;
    }
    return 0.0;                                       //����0��Ԫ�صĽ�����������Ϊ0����
}
*/


