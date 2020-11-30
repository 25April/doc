//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��11��
//4.3 �ݹ�
//��˼����4-4��  ��n����

public class Factorial
{
    public static int factorial(int n)                     //��׳�n!���ݹ鷽��
    {
        if (n<0)
            throw new java.lang.IllegalArgumentException("n="+n); //�׳���Ч�����쳣
        if (n==0 || n==1)                                  //�߽��������ݹ��������
            return 1;
        return n*factorial(n-1);                           //�ݹ���ã�����ͨʽ
    }

    public static void main(String args[])
    {
        int n=5;
        System.out.println(n+"!="+factorial(n));           //5!=120
        
        //ϰ��4
        System.out.println(n+"!="+toString(n)+factorial(n));
    }
    
    
    //ϰ��4
    public static String toString(int n)                   //��׳�n!
    {
        if (n>=0)
        	return toString(n, "");
        throw new java.lang.IllegalArgumentException("n="+n); //�׳���Ч�����쳣
    }
    private static String toString(int n, String str)      //��׳�n!���ݹ鷽��
    {
        if (n==0 || n==1)
            return "";
        else
        {
            str += n+"*"+(n-1)+"!="+toString(n-1, str);
            return str;
        }
    }
}
/*
�������н�����£�
5!=120      
5!=5*4*3*2*1=120
*/
//author��Yeheya��2014-9-23
