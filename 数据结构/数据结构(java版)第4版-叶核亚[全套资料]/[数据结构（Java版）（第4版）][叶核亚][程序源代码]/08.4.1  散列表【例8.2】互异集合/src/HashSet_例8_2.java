//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��14��
//8.4.1   ɢ�б�
//����8.2��  ʹ��ɢ�б��ʾ���켯�ϡ�

public class HashSet_��8_2 
{
    //��ʵ��1-2������    
    //����n����������������Χ��0��size-1������������������
    public static Integer[] randomDifferent(int n, int size)
    {
        Integer[] values = new Integer[n];
        HashSet<Integer> set = new HashSet<Integer>();     //�����ɢ�б�
        int i=0;
        while (i<n)
        {
            int key = (int)(Math.random()*size);
            if (set.add(key))                              //���һ���������ɢ�б�ɹ�
               values[i++]=key;
        }
        return values;                                     //������������
    }
    //�˴�ɢ�б�������ǣ�����Ƿ��ظ���һ��������洢���Ρ�
    //������ɢ�б��toArray()������һ�ǲ��ܷ���Integer[]��ֻ�ܷ���Object[]�����ǣ��ƻ����������

    public static void main(String[] args) 
    {
        int n=10, size=100;
        Integer[] values = randomDifferent(n, size);
        System.out.print(n+"��Ԫ��0��"+size+"֮��Ļ������������: ");
        Array1.print(values);                             //����1.4
    }
}
/*
�������н�����£�
x=7��Ԫ���ظ���δ���롣
10��Ԫ��0��100֮��Ļ������������:  7 20 48 75 83 35 28 96 22 23

x=14��Ԫ���ظ���δ���롣
10��Ԫ��0��100֮��Ļ������������:  38 21 42 49 22 16 5 14 54 62

*/
//@author��Yeheya��2014-10-16