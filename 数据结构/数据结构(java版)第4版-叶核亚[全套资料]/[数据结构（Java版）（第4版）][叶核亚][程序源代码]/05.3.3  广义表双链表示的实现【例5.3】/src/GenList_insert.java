//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��6��
//5.3   �����
//5.3.3   �����˫����ʾ��ʵ��
//����5.3��������˫����ʾ�������㷨��
//��1�� ���������Թ����Ĳ���

public class GenList_insert
{    
    public static void main(String args[])
    {
        String[] atoms={"a","b"};
        GenList<String> glist_L = new GenList<String>(atoms); //��ԭ�����鹹������L
        System.out.println("L="+glist_L.toString()+"��size="+glist_L.size()+"��depth="+glist_L.depth()); 
        
        GenList<String> glist_T = new GenList<String>();   //����չ����T
        glist_T.insert("c");                               //����ԭ��c
        glist_T.insert(glist_L);                           //β�����ӱ�L
        System.out.println("T="+glist_T.toString()+"��size="+glist_T.size()+"��depth="+glist_T.depth()); 
        
        GenList<String> glist_G = new GenList<String>();   //����չ����G  
        glist_G.insert("d");                               //����ԭ��d
        glist_G.insert(glist_L);                           //β�����ӱ�L
        glist_G.insert(glist_T);                           //β�����ӱ�T��glist_L��Ϊ�����ӱ�
        System.out.println("G="+glist_G.toString()+"��size="+glist_G.size()+"��depth="+glist_G.depth()); 
    }
}
/*
�������н�����£�
L=(a,b)��size=2��depth=1
T=(c,(a,b))��size=2��depth=2
G=(d,(a,b),(c,(a,b)))��size=3��depth=3

*/
//author��Yeheya��2014-10-6