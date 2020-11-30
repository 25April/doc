//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��15��
//8.4.2  ɢ��ӳ��
//����8.3��  ����ɢ��ӳ�䣬ͳ���ı��и��ַ��ĳ��ִ�����
//����ɢ��ӳ��洢��ָ��һ���ı���ͳ�Ƴ��ĸ��ַ�������ִ�����
//û�д���HuffmanTree

public class HashMap_charCount
{
    //ͳ��text�и��ַ��ĳ��ִ���������Map<String, Integer>ӳ�䣬���ַ�����������ӳ��
    public static Map<String, Integer> charCount(String text) 
    {
        System.out.println("text=\""+text+"\"");
        HashMap<String, Integer> map = new HashMap<String, Integer>(10);//����ɢ�б�����Ϊ10
//        Map<String, Integer> map = new TreeMap<String, Integer>();//Ĭ��Kʵ��Comparable< T>�ӿ�
        for (int i=0; i<text.length(); i++)                //����ַ����Ҽ���
        {
            String key = text.substring(i,i+1);            //���1���ַ�����Ϊ�ؼ���
            Integer value = map.get(key);                  //��ùؼ���key���ַ���ӳ���ֵ
            int count = value==null ? 0 : value.intValue();//ת����int����
            map.put(key, new Integer(count+1));            //���Ӽ������ؼ�����ͬʱ���滻ֵ
        }
        map.printAll();
        return map;
    }

    public static void main(String[] args) 
    {
//        String text="AAAABBBCDDBBAAA";                     //��6.4����
//        String text="CDAAAABBBDBBAAA";                     //��6.4���ݣ�ɢ�б�û���
//        String text="class Hash";                            //ͼ8.14����
        String text="public class";                            //ͼ8.1����
        System.out.println(charCount(text).toString());      //ͳ��text�и��ַ��ĳ��ִ���
    }
}
/* 
�������н�����£�
                               //ͼ8.14����
text="class Hash"
x=(s,2)��Ԫ���ظ���δ���롣
x=(a,2)��Ԫ���ظ���δ���롣
x=(s,3)��Ԫ���ظ���δ���롣
ɢ�б�����=10��7��Ԫ�أ�hash(key)=key % 10
table[0]=()
table[1]=()
table[2]=(( ,1),(H,1))
table[3]=()
table[4]=((h,1))
table[5]=((s,3))
table[6]=()
table[7]=((a,2))
table[8]=((l,1))
table[9]=((c,1))
HashSet(( ,1),(H,1),(h,1),(s,3),(a,2),(l,1),(c,1))


text="class Set"
x=(s,2)��Ԫ���ظ���δ���롣
ɢ�б�����=10��8��Ԫ�أ�hash(key)=key % 10
table[0]=()
table[1]=((e,1))
table[2]=(( ,1))
table[3]=((S,1))
table[4]=()
table[5]=((s,2))
table[6]=((t,1))
table[7]=((a,1))
table[8]=((l,1))
table[9]=((c,1))
HashSet((e,1),( ,1),(S,1),(s,2),(t,1),(a,1),(l,1),(c,1))


text=CDAAAABBBDBBAAA                             //��6.4����
ɢ�б�����=10��hash(key)=key % 10                     //����ɢ�б�����Ϊ10
table[0]=()
table[1]=()
table[2]=()
table[3]=()
table[4]=()
table[5]=((A,7))
table[6]=((B,5))
table[7]=((C,1))
table[8]=((D,2))
table[9]=()
HashSet((A,7),(B,5),(C,1),(D,2))


text="public class"                              //
x=(c,2)��Ԫ���ظ���δ���롣
x=(l,2)��Ԫ���ظ���δ���롣
ɢ�б�����=10��8��Ԫ�أ�hash(key)=key % 10
table[0]=()
table[1]=()
table[2]=((p,1),( ,1))
table[3]=()
table[4]=()
table[5]=((i,1))
table[6]=()
table[7]=((u,1),(a,1))
table[8]=((b,1),(l,2))
table[9]=((c,2))
���(s,1)
x=(s,2)��Ԫ���ظ���δ���롣
ɢ�б�����=20��9��Ԫ�أ�hash(key)=key % 20
table[0]=()
table[1]=()
table[2]=()
table[3]=()
table[4]=()
table[5]=((i,1))
table[6]=()
table[7]=()
table[8]=((l,2))
table[9]=()
table[10]=()
table[11]=()
table[12]=((p,1),( ,1))
table[13]=()
table[14]=()
table[15]=((s,2))
table[16]=()
table[17]=((u,1),(a,1))
table[18]=((b,1))
table[19]=((c,2))
HashSet((i,1),(l,2),(p,1),( ,1),(s,2),(u,1),(a,1),(b,1),(c,2))



 */
//@author��Yeheya��2014-10-20
