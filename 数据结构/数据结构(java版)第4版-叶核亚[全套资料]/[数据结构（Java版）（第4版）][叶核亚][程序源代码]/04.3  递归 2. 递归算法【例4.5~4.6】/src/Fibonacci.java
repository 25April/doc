//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��3��
//4.3 �ݹ�
//����4.5��  �õݹ��㷨��Fibonacci���С�

public class Fibonacci
{
    public static int fib(int n)                 //����Fibonacci���е�n��ݹ鷽��
    {
        if (n<0)
            throw new java.lang.IllegalArgumentException("n="+n); //�׳���Ч�����쳣
        if (n==0 || n==1)                                 //�߽��������ݹ��������
            return n;
        return fib(n-2)+fib(n-1);                          //�ݹ���ã�����ͨʽ
    }

    public static void main(String args[])
    {
        for (int i=0; i<=24; i++)
            System.out.print(fib(i)+" ");
        System.out.println();
    }
}
/*
�������н�����£�
0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711 28657 46368
*/
//author��Yeheya��2014-9-23