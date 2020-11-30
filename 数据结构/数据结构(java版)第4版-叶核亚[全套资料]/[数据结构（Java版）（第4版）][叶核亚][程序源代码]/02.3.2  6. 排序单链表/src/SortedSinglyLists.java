//�����ݽṹ��Java�棩����4�棩����⡷�����ߣ�Ҷ���ǣ�2015��8��24��
//��2.3.3  ��������
//��ʵ��2-10������2����ƽ��ֵ�ȶ���������Ĳ�����

public class SortedSinglyLists                             //����������Ĳ���
{
    //����list����Ԫ�ص�ƽ��ֵ��������㹫ʽ�ͽ����ÿ���ʽΪ��ֵ��ֵ��ͬ��Ԫ�ظ�����
    //��8���� ���ַ����ҵ��㷨����ʾASL�ɹ���ʽ
    public static double average(SortedSinglyList<Integer> list)
    {
        if (list.isEmpty())
            throw new IllegalArgumentException("���ܶԿյ��������ƽ��ֵ��"); //�׳���Ч�����쳣
        System.out.print("(");
        Node<Integer> p=list.head.next;
        int value=p.data;                                  //��¼ǰ�����Ԫ�أ��жϺ��Ԫ���Ƿ���ͬ
        int count=1, sum=0, length=1;                      //count��¼ֵ��ͬ��Ԫ�ظ���  
        for (p=p.next;  p!=null;  p=p.next)                //����������
        {
            if (p.data==value)                             //����ǰһ�����Ԫ��ֵ��ͬ
                count++;
            else
            {
                sum += value*count;                        //Ԫ��ֵ���
                System.out.print(value+"��"+count+"+");
                value = p.data;
                count=1;
            }
            length++;                             //ͳ�Ƶ�����Ԫ�ظ���
        }
        sum += value*count;
        double aver=(sum+0.0)/length;          //����ƽ��ֵ��ʵ������Ԥ���������˳���Ϊ0����
        System.out.println(value+"��"+count+")/"+length+" = "+sum+"/"+length+" = "+aver);
        return aver;                                       //����ƽ��ֵ
    }
    
    public static void main(String[] args) 
    {
        Integer[] values = {1,2,2,3,3,3,3,4};              //ͼ8.2 �����ж���
        average(new SortedSinglyList<Integer>(values));
    }
}
/* 
�������н�����£�
(1��1+2��2+3��4+4��1)/8=21/8=2.625
*/
//@author��Yeheya��2015-8-24
