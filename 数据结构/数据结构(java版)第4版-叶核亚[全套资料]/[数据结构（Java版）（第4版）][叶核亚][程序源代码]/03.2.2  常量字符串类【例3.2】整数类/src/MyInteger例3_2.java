//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��3��
//3.2.2  �����ַ�����
//����3.2�� �����ࡣ

public class MyInteger��3_2 
{
    public static void main(String args[])
    {
        String[] str16={"-7fff", "-80", "-1", "+7f", "3e8"};//����ʮ������ԭ��
        System.out.println("ʮ���ƣ�ʮ�����Ʋ���");   
        for (int i=0; i<str16.length; i++)
        {
            int value = MyInteger.parseInt(str16[i],16);
            System.out.println(value+"��0x"+MyInteger.toHexString(value));   
        }
    }
}
/*
�������н�����£�
ʮ���ƣ�ʮ�����Ʋ���
-32767��0xffff8001
-128��0xffffff80
-1��0xffffffff
127��0x0000007f
1000��0x000003e8
 */

  //@author��Yeheya��2014-10-4
