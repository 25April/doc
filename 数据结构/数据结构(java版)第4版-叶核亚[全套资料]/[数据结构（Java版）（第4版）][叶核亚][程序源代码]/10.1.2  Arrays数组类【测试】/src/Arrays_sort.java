//�����ݽṹ��Java�棩����4�棩����⡷�����ߣ�Ҷ���ǣ�2014��8��22�գ�JDK 8.25
//10.1.2   Arrays������
// Arrays����Ͳ����㷨��

import java.util.Arrays;

public class Arrays_sort 
{
    public static void main(String args[])
    {  
        //int������������Ͷ��ַ�����
        int[] value1=Array1.randomInt(10,100);                 //����������������飬����1.4
        System.out.print("��������У� ");  Array1.print(value1);        
        java.util.Arrays.sort(value1);                     //int[]��������      
        System.out.print("�������У� ");   Array1.print(value1);        
        int key=100;
        int i=java.util.Arrays.binarySearch(value1, key);
        System.out.println("���ַ�����"+key+"�������"+i+"������"+(i>=0 && i<value1.length?"":"��")+"�ɹ�");

        //Integer����������������Ͷ��ַ�����
        Integer[] value2=Array1.randomInteger(10,100);        //��������������������飬����1.4
        System.out.print("\n��������У� ");  Array1.print(value2);
        java.util.Arrays.sort(value2);                               //Integer[]��������      
        System.out.print("�������У� ");   Array1.print(value2); 
        key=50;
        i=java.util.Arrays.binarySearch(value2, key);
        System.out.println("���ַ�����"+key+"�������"+i+"������"+(i>=0 && i<value2.length?"":"��")+"�ɹ�");
    }
}
/* 
�������н�����£�
��������У�  2 54 61 67 96 29 91 95 76 79
�������У�  2 29 54 61 67 76 79 91 95 96
���ַ�����100�������-11�����Ҳ��ɹ�

��������У�  28 22 34 49 41 66 49 1 77 98
�������У�  1 22 28 34 41 49 49 66 77 98
���ַ�����50�������-8�����Ҳ��ɹ�

*/
//@author��Yeheya��2014-8-22
