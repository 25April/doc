//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��15��
//8.5.2  ��ӳ��
//����8.5�����ö���������ӳ��洢��ͳ���ı��и��ַ��ĳ��ִ�����

public class TreeMap_charCount
{
    //ͳ��text�и��ַ��ĳ��ִ���������Map<String, Integer>��ӳ�䣬���ַ�����������ӳ�䣬
    //Ԫ�ذ��ؼ�����������
    public static Map<String, Integer> charCount(String text) 
    {
        System.out.print("text=\""+text+"\"\n�ַ�������ִ�����");
        Map<String,Integer> map = new TreeMap<String,Integer>();
        for (int i=0; i<text.length(); i++)                //����ַ����Ҽ������㷨ͬ��8.3
        {
            String key = text.substring(i,i+1);            //���1���ַ�����Ϊ�ؼ���
            Integer value = map.get(key);                  //��ùؼ���key���ַ���ӳ���ֵ
            int count = value==null ? 0 : value.intValue();//ת����int����
            map.put(key, new Integer(count+1));            //���Ӽ������ؼ�����ͬʱ���滻ֵ
        }
        return map;
    }

    public static void main(String[] args) 
    {
//        String text="AAAABBBCDDBBAAA";           //��6.4����
//        String text="CDAAAABBBDBBAAA";           //��6.4���ݣ�û���
        String text="public class";               //ͼ8.21����
//      String text="class HashSet";              //���ݣ�ͬC++��3�棩
        System.out.println(charCount(text).toString());
    }
}
/*
�������н�����£�
text="public class"                                //ͼ8.21����
�ַ�������ִ�����[( ,1) (a,1) (b,1) (c,2) (i,1) (l,2) (p,1) (s,2) (u,1) ]

text=CDAAAABBBDBBAAA                             //��6.4����
�ַ�������ִ�����(A,7) (B,5) (C,1) (D,2) 

text=class HashSet                           //ͼ8.12���ݣ�ͬC++��3�棩
�ַ�������ִ�����( ,1) (H,1) (S,1) (a,2) (c,1) (e,1) (h,1) (l,1) (s,3) (t,1) 

 */
//@author��Yeheya��2014-8-16
