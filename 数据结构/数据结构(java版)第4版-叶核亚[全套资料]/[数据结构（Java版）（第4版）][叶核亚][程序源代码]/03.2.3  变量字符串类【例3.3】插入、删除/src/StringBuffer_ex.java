//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��9��30��
//3.2.3   �����ַ�����
//����3.3��  StringBuffer���Ĳ��롢ɾ��������
//StringBuffer���Ĳ����ɾ�����������ظı��Ĵ�����Ų��ݴ�

public class StringBuffer_ex 
{    
    public static void main(String args[])
    {
        //1.  ��������ַ���
//        StringBuffer sbuf1 = new StringBuffer();           //Ĭ��16
//        sbuf1 = new StringBuffer("abcd");                  //���ַ����������촮��������Ϊ4+16��û������'\0'
        StringBuffer sbuf = new StringBuffer(8);
        System.out.println("�մ���\""+sbuf+"\"��length()="+sbuf.length()+"��capacity()="+sbuf.capacity());

        //2.  ���봮    ͼ3.9
        sbuf.insert(0, "abcdef");                          //���봮��û���õ�����ֵ
        System.out.println("���룬\""+sbuf+"\"��length()="+sbuf.length()+"��capacity()="+sbuf.capacity());
        
        String[] str = {"xy", null};
        int i=2;                                           //���i���ݴ��׳��쳣
        for (int j=0; j<str.length; j++)
            System.out.println("���룬\""+sbuf+"\".insert("+i+",\""+str[j]+"\")=\""+
                sbuf.insert(i,str[j])+"\"��length()="+sbuf.length()+"��capacity()="+sbuf.capacity());
//      sb1.append(null);                  //�������������������Object��String����ȷ

        //3.  ɾ���Ӵ�      ͼ3.10   
        int[] begin={2,4,2}, end={6,10,2};
        for (int j=0; j<begin.length; j++)
            System.out.println("ɾ����\""+sbuf+"\".delete("+begin[j]+","+end[j]+")=\""+
                sbuf.delete(begin[j],end[j])+"\"��length()="+sbuf.length()+"��capacity()="+sbuf.capacity());

        //���ô�����
        sbuf.setLength(30);                      //�ӳ��ַ���������'\0'����������
        System.out.println("�ӳ���\""+sbuf+"\"��length()="+sbuf.length()+"��capacity()="+sbuf.capacity());
        sbuf.setLength(10);                      //�����ַ���
        System.out.println("���̣�\""+sbuf+"\"��length()="+sbuf.length()+"��capacity()="+sbuf.capacity());
    
    }
}
/*��3.3 �������н�����£�
�մ���""��length()=0��capacity()=8
���룬"abcdef"��length()=6��capacity()=8
���룬"abcdef".insert(2,"xy")="abxycdef"��length()=8��capacity()=8
���룬"abxycdef".insert(2,"null")="abnullxycdef"��length()=12��capacity()=18    //��������
ɾ����"abnullxycdef".delete(2,6)="abxycdef"��length()=8��capacity()=18
ɾ����"abxycdef".delete(4,10)="abxy"��length()=4��capacity()=18           //ɾ������β
ɾ����"abxy".delete(2,2)="abxy"��length()=4��capacity()=18                //begin==end��û��ɾ�� 
*/

//@author��Yeheya��2014-10-28    

