//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��11��9��
//8.5.1   ����������
//����8.4��  ʹ�ö�����������ʾ��������򼯺ϡ�
//�����������Ĳ��롢���Ҳ�����

public class BinarySortTree_random��8_4
{
    //��ʵ��1-2������    
    //Integer[] randomIntegerDifferentSorted(int n, int size)	//����n�����������������

    //����n���������������������Χ��0��size��1�����ض���������
    public static BinarySortTree<Integer> random(int n, int size)
    {
        BinarySortTree<Integer> set = new BinarySortTree<Integer>(); //�����������洢����Ԫ��
        int i=0;
        while (i<n)
        {
            int key = (int)(Math.random()*size);
            System.out.print(key+" ");  
            if (set.add(key))                    //���һ��������������������ɹ�
               i++;
        }
        return set;                              //���ض���������
    }
    //���ܵ���addAll([])����ΪҪ������
    
    public static void main(String args[])
    {
        System.out.print("�ؼ������У�");
        BinarySortTree<Integer> set=random(10, 100);
        System.out.println("\n������������"+set.toString());  //�и��������������������������ؼ����������е�Ԫ������
        set.inorderPrevious();                     //�Է�����и����������������������н��Ԫ��
    }
}
/*
�������н�����£�
�ؼ������У�72 49 49 91 79 17 88 38 12 12 87 8 
������������[8 12 17 38 49 72 79 87 88 91 ]
[91 88 87 79 72 49 38 17 12 8 ]


�ؼ������У�63 32 22 69 55 31 45 66 34 54 
������������[22 31 32 34 45 54 55 63 66 69 ]
[69 66 63 55 54 45 34 32 31 22 ]
*/
//@author��Yeheya��2014-11-9
