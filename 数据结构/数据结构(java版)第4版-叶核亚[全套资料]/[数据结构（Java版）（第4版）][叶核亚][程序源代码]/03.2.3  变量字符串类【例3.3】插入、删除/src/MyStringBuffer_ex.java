//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��6��29��
//3.2.3   �����ַ�����

//StringBuffer���Ĳ����ɾ�����������ظı��Ĵ�����Ų��ݴ�
//ͬStringBuffer_ex

public class MyStringBuffer_ex
{
    public static void main(String args[])
    {
        //1.  ��������ַ���
        MyStringBuffer sbuf = new MyStringBuffer(8);           //Ĭ��16
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
        sbuf.setLength(30);                      //�ӳ��ַ���������' '����������
        System.out.println("�ӳ���\""+sbuf+"\"��length()="+sbuf.length()+"��capacity()="+sbuf.capacity());
        sbuf.setLength(10);                      //�����ַ���
        System.out.println("���̣�\""+sbuf+"\"��length()="+sbuf.length()+"��capacity()="+sbuf.capacity());
        
        
    }
}
//@author��Yeheya��2014-10-3    
