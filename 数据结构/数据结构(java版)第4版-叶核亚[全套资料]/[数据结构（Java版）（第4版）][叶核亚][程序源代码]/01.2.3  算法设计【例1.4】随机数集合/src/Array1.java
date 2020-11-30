//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��22�գ�JDK 8.11
//��1.2.3   �㷨���
//����1.4��  ���Դ洢����������ϡ�
//��8.2 ���ַ�����                 ��������������������㷨
//��9.1~9.4 ����                 ��������������������㷨

public class Array1 
{
    //����1.4��  ���Դ洢����������ϡ�
    public static void print(Object[] value)     //�����������Ԫ�أ���̬������ʱ�临�Ӷ�ΪO(n)
    {
/*        for (int i=0; i<value.length; i++)       //�������飬����ÿ��Ԫ�ؽ�һ��
            if (value[i]==null)
                System.out.print("null ");
            else
                System.out.print(" "+value[i].toString());//�������Ĭ��ִ����toString()����
*/
        
        for (Object obj : value)                 //��Ԫѭ����obj�������value����Ԫ�أ�����ͬ����
            System.out.print(obj==null ? "null " : " "+obj.toString());
        System.out.println();
    }
    
    //����n������������ظ�������Χ��0��size-1������������������
    public static Integer[] randomInteger(int n, int size)
    {
        Integer[] values = new Integer[n];       //java.lang.Integer��int���͵İ�װ��
        for (int i=0; i<values.length; i++)       //�������飬����ÿ��Ԫ�ؽ�һ��
//            values[i] = new Integer((int)(Math.random()*100));
            values[i] = (int)(Math.random()*size);   //Java�Զ���int������װ��Integer���󣬸�ֵ����
                        //java.lang.Math.random()��������һ��0��1֮��double���͵������
        return values;                                     //������������
    } 
    
    //8.2 ���ַ����ң� 9.1~9.4 ����
    public static void print(int[] value)                  //�������Ԫ��
    {
        for (int i=0; i<value.length; i++)
            System.out.print("  "+value[i]);
        System.out.println();
    }
    
    //9.1~9.4 ����
    public static int[] randomInt(int n, int size)            //����n���������������������
    {
        int value[] = new int[n];
        for (int i=0; i<value.length; i++)
            value[i] = (int)(Math.random()*size);           //����һ��0��size-1֮��������
        return value;                                      //����һ������
    }
    //û���õ�
    public static String toString(int[] value)             //��������Ԫ�أ�������ʡ��
    {
        String str="";
        for (int i=0; i<value.length; i++)
            str += " "+value[i];
        return str;
    }
}
//@author��Yeheya��2014-10-26

