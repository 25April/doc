//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��22�գ�JDK 8.11
//��1.2.3   �㷨���
//����1.4��  ���Դ洢����������ϡ�

public class Random 
{
    public static void main(String[] args) 
    {
//      Integer[] value = {new Integer(32),new Integer(15),new Integer(78),new Integer(99)}; 
//        Integer[] value = {32,15,78,99,87,34,14,19,76,46,1}; //Java�Զ���int��װ��Integerʵ��
//        Object[] value1 = Array1.random(10); //�﷨��ȷ

        int n=10, size=100;
        Integer[] values = Array1.randomInteger(n, size);      //ͨ������������ľ�̬����
        System.out.print(n+"��Ԫ��0��"+size+"֮������������: ");
        Array1.print(values);
    }
}
/*
�������н�����£�
10��Ԫ��0��100֮������������:  24 93 71 65 93 83 90 67 71 23
*/
//@author��Yeheya��2014-9-7
