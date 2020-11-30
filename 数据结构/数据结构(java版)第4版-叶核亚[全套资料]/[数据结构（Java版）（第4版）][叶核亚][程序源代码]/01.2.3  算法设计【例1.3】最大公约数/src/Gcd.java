//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǡ�2014��7��3�ա�JDK 8.11��
//��1.2.3   �㷨���
//����1.3�� ���������������Լ����
//4.3 �ݹ顾ʵ��4-5���ݹ��㷨

public class Gcd
{
    public static int gcd1(int a, int b)          //����a��b���������
    {
        while (b!=0)
        {
            int temp = a%b;
            a = b;
            b = temp; 
        }
        return a;
    }
    
    //4.3 �ݹ顾ʵ��4-5���ݹ��㷨
    public static int gcd2(int a, int b)          //����a,b������������ݹ鷽��
    {
        if(b==0)
            return a;
        if(a<0)
            return gcd2(-a, b);
        if(b<0)
            return gcd2(a, -b);
        return gcd2(b, a%b);
    }
    
    public static void main(String args[]) 
    {
        int a=12, b=18, c=24;
        System.out.println("gcd1("+a+","+b+","+c+")="+gcd1(gcd2(a,b), c));
    }
}
/*
�������н������:
gcd1(12,18,24)=6

*/
//author��Yeheya��2014-7-3
