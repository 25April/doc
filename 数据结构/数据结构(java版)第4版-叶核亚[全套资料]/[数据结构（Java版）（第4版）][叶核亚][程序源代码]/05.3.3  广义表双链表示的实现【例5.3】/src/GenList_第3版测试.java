//5.3   �����
//5.3.2   �����Ĵ洢�ṹ
//2.  ������˫����ʾ
//��3�桾��5.4��������˫����ʾ�������㷨��
//ʹ��GenList�࣬(1)��ԭ�����鹹������
public class GenList_��3�����
{    
    public static void main(String args[])
    {
        GenList<String> glist_empty = new GenList<String>();//����չ����		
        System.out.print("glist_empty��"+glist_empty.toString()+"��  size="+glist_empty.size()); 
        System.out.println("��depth="+glist_empty.depth()); 

        glist_empty.insert(0, new GenList<String>());      //�ձ��в���ձ�
        glist_empty.insert(new GenList<String>()); 
        System.out.print("glist��"+glist_empty.toString()+"��  size="+glist_empty.size()); 
        System.out.println("��depth="+glist_empty.depth()); 

        String[] gliststr_l = {"b","c","e"};
        GenList<String> glist_L = new GenList<String>(gliststr_l);//��ԭ�����鹹������
        glist_L.insert(0, "a");                            //ͷ����ԭ��
        glist_L.insert(3, "d");                            //�м����ԭ��
        glist_L.insert("f");                               //β����ԭ��
        System.out.print("glist_L��"+glist_L.toString()+"��  size="+glist_L.size()); 
        System.out.println("��depth="+glist_L.depth()); 
    
        String[] gliststr_t = {"o","p","q"};
        GenList<String> glist_T = new GenList<String>(gliststr_t);
        glist_T.insert(glist_L);                           //β�����ӱ�
        System.out.print("glist_T��"+glist_T.toString()+"��  size="+glist_T.size()); 
        System.out.println("��depth="+glist_T.depth()); 

        String[] gliststr_g = {"x","y","z"};
        GenList<String> glist_G = new GenList<String>(gliststr_g);
        glist_G.insert(glist_L);
        glist_G.insert(glist_T);                           //β�����ӱ�glist_L��Ϊ�����ӱ�
        System.out.print("glist_G��"+glist_G.toString()+"��  size="+glist_G.size()); 
        System.out.println("��depth="+glist_G.depth()); 
    }
}    
/*
�������н�����£�
glist_empty��()��  size=0��depth=1
glist��((),())��  size=2��depth=2
glist_L��(a,b,c,d,e,f)��  size=6��depth=1
glist_T��(o,p,q,(a,b,c,d,e,f))��  size=4��depth=2
glist_G��(x,y,z,(a,b,c,d,e,f),(o,p,q,(a,b,c,d,e,f)))��  size=5��depth=3

*/
//author��Yeheya��2014-10-6