//�����ݽṹ��Java�棩����4�棩ϰ���𡷣����ߣ�Ҷ���ǣ�2015��3��19��
//8.4.1   ɢ�б�
//��ϰ����8-12����������ַ��ɢ�б���������

public class HashSet_ϰ����8_12 
{
    public static void main(String[] args) 
    {
        Integer[] values ={16,75,60,43,54,90,46,31,27,88,64,50}; //��ϰ����8-12��
        System.out.print("�ؼ������У� ");
        Array1.print(values);                              //����1.4
        HashSet<Integer> set = new HashSet<Integer>(10);   //�����ɢ�б�ɢ����������Ϊ10
        set.addAll(values);                                //����values����Ԫ��
        set.printAll();
    }
}
/*
�������н�����£�
�ؼ������У�  16 75 60 43 54 90 46 31 27 88 64 50
ɢ�б�����=10��8��Ԫ�أ�hash(key)=key % 10��HashSet(60,90,31,43,54,75,16,46)
table[0]=(60,90)
table[1]=(31)
table[2]=()
table[3]=(43)
table[4]=(54)
table[5]=(75)
table[6]=(16,46)
table[7]=()
table[8]=()
table[9]=()
ASL�ɹ�=(1+2+1+1+1+1+1+2)/8 =10/8 =1.25

���27��ɢ�б�����=20��12��Ԫ�أ�hash(key)=key % 20��HashSet(60,43,64,46,27,88,90,50,31,54,75,16)
table[0]=(60)
table[1]=()
table[2]=()
table[3]=(43)
table[4]=(64)
table[5]=()
table[6]=(46)
table[7]=(27)
table[8]=(88)
table[9]=()
table[10]=(90,50)
table[11]=(31)
table[12]=()
table[13]=()
table[14]=(54)
table[15]=(75)
table[16]=(16)
table[17]=()
table[18]=()
table[19]=()
ASL�ɹ�=(1+1+1+1+1+1+1+2+1+1+1+1)/12 =13/12 =1.0833333333333333

*/
//@author��Yeheya��2015-3-19

