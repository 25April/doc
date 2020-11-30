//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��6��25��
//3.2.2   �����ַ�����
//3.3   ����ģʽƥ��

public class MyString_ex
{
    public static void main(String args[])
    {
        //3.2.2   �����ַ�����
        //��1�� �����ַ���
   	    MyString s1 = new MyString();                      //����մ�""
        MyString s2 = new MyString("xyz");                 //��java.lang.String�ַ����������촮����
        System.out.println("s1=\""+s1.toString()+"\"");
        System.out.println("s2=\""+s2.toString()+"\"");

//        MyString s3 = "xyz";                             //�﷨�����ܽ�Stringת����MyString��û���Զ���װ����
//        MyString[] str = {"abc","xyz"};                  //�﷨�����ܽ�Stringת����MyString��û���Զ���װ����
        
        char[] letters={'a','b','c','d','e','f','g','h'};  //�ַ����飬ֻ��������ʱ��ֵ�����ܸ�ֵΪ"abcd"
        MyString s3 = new MyString(letters,0,8);           //���ַ����鹹�촮����
        System.out.println("s3=\""+s3.toString()+"\"");

        letters[0]='y';                                    //����Ԫ�ظ��ˣ��Դ�ûӰ��
        MyString s4 = new MyString(s3);                    //�������췽��
        System.out.println("s4=\""+s4.toString()+"\"");

        MyString s5=s2;                               //�������ø�ֵ       
        System.out.println("\""+s5.toString()+"\"==\""+s2.toString()+"\"? "+(s5==s2));
        System.out.println("\""+s3.toString()+"\"==\""+s4.toString()+"\"? "+(s3==s4));
        System.out.println("\""+s3.toString()+"\".equals(\""+s4.toString()+"\")? "+s3.equals(s4));
        System.out.println("\""+s3.toString()+"\".compareTo(\""+s4.toString()+"\")? "+s3.compareTo(s4));
        System.out.println("\""+s2.toString()+"\".equals(\""+s3.toString()+"\")? "+s2.equals(s3));
        System.out.println("\""+s2.toString()+"\".compareTo(\""+s3.toString()+"\")? "+s2.compareTo(s3));

        //��2�� ���Ӵ�
        MyString s=new MyString("abcdefgh");
        System.out.println(s.substring(2,5).toString());                //cde

        //��3�� ���Ӵ�
        MyString s6=new MyString("abcd"), s7=new MyString("xyz");
        System.out.println("s6.concat(s7)=\""+s6.concat(s7).toString()+"\""); //s1.concat(s2)="abcdxyz"
    }
}
/*
�������н�����£�
s1=""
s2="xyz"
s3="abcd"
s4="abcd"
"xyz"=="xyz"? true
"abcd"=="abcd"? false
"abcd".equals("abcd")? true
"abcd".compareTo("abcd")? 0
"xyz".equals("abcd")? false
"xyz".compareTo("abcd")? 23
"abcdxyz".startsWith("xyz")? true
"abcdxyz".endsWith("xyz")? true
"xyz".equalsIgnoreCase("XYZ")? true
"abcd".compareToIgnoreCase("ABCDEF")? -2

*/