//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��6��27��
//3.2.2   �����ַ�����
//����3.1��  String���Ĳ��롢ɾ��������

public class String_insert 
{
    public static void main(String args[])
    {
        //�� ���봮      ͼ3.5
        String s1="abcdef\0", s2="xyz";                    //û������'\0'
        int i=3;
        String s3=s1.substring(0,i)+s2+s1.substring(i);    //������s1����i������s2��Ĵ�
        System.out.println("insert(\""+s1+"\","+i+",\""+s2+"\")=\""+s3+"\"");

        s2=null;                                           //����"null"
        s3=s1.substring(0,i)+s2+s1.substring(i);           //������s1����i������s2��Ĵ�
        System.out.println("insert(\""+s1+"\","+i+",\""+s2+"\")=\""+s3+"\"");
        
        //�� ɾ���Ӵ�      ͼ3.6
        int begin=3, end=6;
        String s4=s3.substring(0, begin) + s3.substring(end); //ɾ��s���д�begin��end-1�����Ӵ�������ɾ����Ĵ���s������
        System.out.println("remove(\""+s3+"\","+i+","+(i+3)+")=\""+s4+"\"");
    }
}
/*
�������н�����£�
insert("abcdef",3,"xyz")="abcxyzdef"
insert("abcdef",3,"null")="abcnulldef"
remove("abcnulldef",3,6)="abcldef"
*/
//@author��Yeheya��2014-9-30    
