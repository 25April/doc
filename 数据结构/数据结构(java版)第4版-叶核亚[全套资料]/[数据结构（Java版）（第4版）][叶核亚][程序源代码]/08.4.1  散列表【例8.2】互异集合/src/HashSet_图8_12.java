//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��14��
//8.4.1   ɢ�б�
//ͼ8.12  �Ľ�������ַ��ɢ�б�
//��������ַ��ɢ�б���������

public class HashSet_ͼ8_12 
{
    public static void main(String[] args) 
    {
//        Integer[] values1 ={0,10,20,30,40,50,60,70,80,90,100,110};   //����16��ͬjava.util.HashSet
//        Integer[] values1 ={0,10,20,30,40,50,60,70,80,90,100,110,160};   //����32��ͬjava.util.HashSet
        Integer[] values ={9,4,12,14,74,6,16,96, 10};         //ͼ8.12
        System.out.print("�ؼ������У� ");
        Array1.print(values);                              //����1.4
        HashSet<Integer> set = new HashSet<Integer>(10);   //�����ɢ�б�ɢ����������Ϊ10
        set.addAll(values);                                //����values����Ԫ��
//        System.out.println("set1="+set1.toString());
        set.printAll();
//    set1.add(null);                              //����ն����׳��쳣

        Integer key=100;                           //����ɾ�� 2015-6-1
        Integer find = set.remove(new Integer(key));
        System.out.println("\nɾ�� "+key+"�� "+(find!=null?"":"��")+"�ɹ�");
        if (find!=null)
        {
            System.out.println("set1="+set.toString());
            set.printAll();
        }
        set.printAll();
    }
}
/*
�������н�����£�
�ؼ������У�  9 4 12 14 74 6 16 96 10
ɢ�б�����=10��8��Ԫ�أ�hash(key)=key % 10��HashSet(12,4,14,74,6,16,96,9)
table[0]=()
table[1]=()
table[2]=(12)
table[3]=()
table[4]=(4,14,74)
table[5]=()
table[6]=(6,16,96)
table[7]=()
table[8]=()
table[9]=(9)
ASL�ɹ�=(1+1+2+3+1+2+3+1)/8 =14/8 =1.75

���10��ɢ�б�����=20��9��Ԫ�أ�hash(key)=key % 20��HashSet(4,6,9,10,12,14,74,16,96)
table[0]=()
table[1]=()
table[2]=()
table[3]=()
table[4]=(4)
table[5]=()
table[6]=(6)
table[7]=()
table[8]=()
table[9]=(9)
table[10]=(10)
table[11]=()
table[12]=(12)
table[13]=()
table[14]=(14,74)
table[15]=()
table[16]=(16,96)
table[17]=()
table[18]=()
table[19]=()
ASL�ɹ�=(1+1+1+1+1+1+2+1+2)/9 =11/9 =1.2222222222222223

ɾ�� 14�� �ɹ�
set1=HashSet(4,6,9,10,12,74,16,96)
ɢ�б�����=20��8��Ԫ�أ�hash(key)=key % 20��HashSet(4,6,9,10,12,74,16,96)
table[0]=()
table[1]=()
table[2]=()
table[3]=()
table[4]=(4)
table[5]=()
table[6]=(6)
table[7]=()
table[8]=()
table[9]=(9)
table[10]=(10)
table[11]=()
table[12]=(12)
table[13]=()
table[14]=(74)
table[15]=()
table[16]=(16,96)
table[17]=()
table[18]=()
table[19]=()
ASL�ɹ�=(1+1+1+1+1+1+1+2)/8 =9/8 =1.125

ɾ�� 100�� ���ɹ�
ɢ�б�����=20��9��Ԫ�أ�hash(key)=key % 20��HashSet(4,6,9,10,12,14,74,16,96)
table[0]=SinglyList()
table[1]=SinglyList()
table[2]=SinglyList()
table[3]=SinglyList()
table[4]=SinglyList(4)
table[5]=SinglyList()
table[6]=SinglyList(6)
table[7]=SinglyList()
table[8]=SinglyList()
table[9]=SinglyList(9)
table[10]=SinglyList(10)
table[11]=SinglyList()
table[12]=SinglyList(12)
table[13]=SinglyList()
table[14]=SinglyList(14,74)
table[15]=SinglyList()
table[16]=SinglyList(16,96)
table[17]=SinglyList()
table[18]=SinglyList()
table[19]=SinglyList()
ASL�ɹ�=(1+1+1+1+1+1+2+1+2)/9 =11/9 =1.2222222222222223

*/
//@author��Yeheya��2015-6-1

