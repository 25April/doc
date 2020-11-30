//�����ݽṹ��Java�棩����4�棩ϰ���𡷣����ߣ�Ҷ���ǣ�2014��9��30�գ�JDK 8.25
//3.2.3   �����ַ�����
//��ʵ��3-11�� ��StringBuffer��������StringBuffer��û���������������ӹ��ܡ�

public class StringBuffer_trim 
{    
    // ���·�����ʲô�������н���������ģ�Ϊʲô����θ�����
    public static StringBuffer trim_error1(StringBuffer s) //��s�����пո�ɾ�������ز������s��
    {
        int n=s.length();
        for (int i=0; i<n; i++)
            if (s.charAt(i)==' ')
                s.delete(i, i+1); 
        return s;
    }
    //�������д��׳�StringIndexOutOfBoundsException�쳣��
    //���𡿴���ԭ��ÿɾ��һ���ո�i���ӣ���n--
    
    public static StringBuffer trim_error2(StringBuffer s)
    {
        int i=0, n=s.length();
        while (i<n)
            if (s.charAt(i)==' ')
                s.delete(i, i+1);
            else  i++;
        return s;
    }
    //�������д��׳�StringIndexOutOfBoundsException�쳣������ԭ��ÿɾ��һ���ո�n��1��

    //��s�����пո�ɾ�������ز������s��
    public synchronized static StringBuffer trim1(StringBuffer s)
    {
        int i=0;
        while (i<s.length())
            if (s.charAt(i)==' ')
            	s.deleteCharAt(i);
//                s.delete(i, i+1);
            else  i++;
        return s;
    }
    //������ȷ���㷨Ч�ʵ�
    
    //ϰ����
    //��s�����пո�ɾ�������ز������s�����ǿո��ַ���ǰ�ƶ�һ�Σ�O(n)
    public static StringBuffer trim2(StringBuffer s)
    {
        int i=0, j=0;
        while (i<s.length() && s.charAt(i)!=' ')           //i��ס��1���ո��±�
            i++;
        for (j=i; j<s.length(); j++)
            if (s.charAt(j)!=' ')
                s.setCharAt(i++, s.charAt(j));             //�ǿո��ַ���ǰ�ƶ����ո��ַ�λ��
//        s.setLength(i);                                    //���ô�����Ϊi
        return s;
    }
       
    public static void main(String args[])
    {
//        StringBuffer sbuf1 = new StringBuffer("  a  b  c  d  ");  //���ַ����������촮��������Ϊ4+16��û������'\0'

        //        StringBuffer sbuf2 = new StringBuffer(sbuf1);      //�������췽��
//        System.out.println("trim1(\""+sbuf1+"\")="+trim1(sbuf1));
//        System.out.println("trim2(\""+sbuf1+"\")="+trim2(sbuf1));

        StringBuffer str = new StringBuffer("   a bc d  e  f xyz");
        System.out.println("trim2(\""+str+"\")="+trim2(str));
    }
}
/*�������н�����£�
trim1("  a  b  c  d  ")= a b c d 
trim("  a  b  c  d  ")=abcd

trim2("   a bc d  e  f xyz")=abcdefxyz  e  f xyz           //û�����ô�����ʱ������ϰ����
trim2("   a bc d  e  f xyz")=abcdefxyz                      //��ȷ


*/

//@author��Yeheya��2015-2-5    

