//�����ݽṹ��Java�棩����4�棩ϰ������ʵ��ָ���������ߣ�Ҷ���ǣ�2015��2��5��
//3.2.2   �����ַ�����
//��ʵ��3-9��ϰ���� �������ࡣ

public class MyDouble_ex 
{
    public static void main(String args[])
    {
        String str[]={"12345", "-123","-0.1234567", "-12345E2", "-12345.67E-2","-12345E0"};
        for (int i=0; i<str.length; i++)
        {
            System.out.println("parseDouble(\""+str[i]+"\")="+MyDouble.parseDouble(str[i]));
            System.out.println("toDouble(\""+str[i]+"\")="+MyDouble.toDouble(str[i]));
        }
    } 
}
/*
�������н�����£�
parseDouble("12345")=12345.0
toDouble("12345")=12345.0
parseDouble("-0.1234567")=-0.12345670000000002
toDouble("-0.1234567")=-0.12345670000000002
parseDouble("-12345E2")=-1234500.0
toDouble("-12345E2")=-1234500.0
parseDouble("-12345.67E-2")=-123.45670000000001
toDouble("-12345.67E-2")=-123.45670000000001
parseDouble("-12345E0")=-12345.0
toDouble("-12345E0")=-12345.0
*/
