//�����ݽṹ��Java�棩����4�棩ϰ���𡷣����ߣ�Ҷ���ǣ�2015��2��8��
//4.3 �ݹ�
//��ϰ������4.1��  �õݹ��㷨��ӡ��������

public class DigitTower
{
    public static void line(int i, int n)                         //���һ�У��ݹ鷽��
    {
        System.out.print(String.format("%3d",i));
        if (i<n)
        { 
            line(i+1, n);
            System.out.print(String.format("%3d",i));
        }
    }
    
    public static void main(String args[])
    {
        int n=9;
        for(int i=1; i<=n; i++)
        {
            System.out.print(String.format("%"+3*(n-i+1)+"c", ' ')); //ǰ���ո�
            line(1, i);
            System.out.println();
        }
    }
}
/*
�������н�����£�
                             1
                          1  2  1
                       1  2  3  2  1
                    1  2  3  4  3  2  1
                 1  2  3  4  5  4  3  2  1
              1  2  3  4  5  6  5  4  3  2  1
           1  2  3  4  5  6  7  6  5  4  3  2  1
        1  2  3  4  5  6  7  8  7  6  5  4  3  2  1
     1  2  3  4  5  6  7  8  9  8  7  6  5  4  3  2  1

*/
//author��Yeheya��2014-9-23
