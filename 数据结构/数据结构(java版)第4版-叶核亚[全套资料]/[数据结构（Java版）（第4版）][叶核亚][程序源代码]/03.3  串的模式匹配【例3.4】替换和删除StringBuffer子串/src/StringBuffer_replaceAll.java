//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��6��30��
//3.3   ����ģʽƥ��
//3.3.1 Brute-Force�㷨
//3.3.2 ģʽƥ��Ӧ��
//����3.4��  ��java.lang.StringBuffer�ַ��������滻��ɾ���Ӵ�������
    //��˼����3-5��

public class StringBuffer_replaceAll
{
    //��1���滻�Ӵ�
    //��target����������patternƥ����Ӵ�ȫ���滻��str�������滻���target��
    public static StringBuffer replaceAll(StringBuffer target, String pattern, String str)
    {
        int i=target.indexOf(pattern);
        while (i!=-1)
        {
            target.delete(i, i+pattern.length());
            target.insert(i, str);
            i=target.indexOf(pattern, i+str.length());
//            i=target.indexOf(pattern, i+1);            //��
        }
        return target;
    } 

    //��˼����3-5��
    //��target�����׸���patternƥ����Ӵ��滻��replacement�������滻���target��
    public static StringBuffer replaceFirst(StringBuffer target, String pattern, String replacement)
    {
        int i=target.indexOf(pattern);
        if(i!=-1)
        {
            target.delete(i, i+pattern.length());          //ɾ��i��i+pattern.length()-1���Ӵ�
            target.insert(i, replacement);                 //�ڵ�i���ַ�������replacement��
        }
        return target;
    } 

    //ɾ��target�����׸���patternƥ����Ӵ�������ɾ�����target��
    public static StringBuffer deleteFirst(StringBuffer target, String pattern)
    {
        int i=target.indexOf(pattern);
        if(i!=-1)
            target.delete(i, i+pattern.length()); 
        return target;
    }
    //ɾ��target����������patternƥ����Ӵ�������ɾ�����target��
    public static StringBuffer deleteAll(StringBuffer target, String pattern)
    {
        int i=target.indexOf(pattern);
        while (i!=-1)
        {
            target.delete(i, i+pattern.length());
            i=target.indexOf(pattern, i);
        }
        return target;
    }
    

    //����3.4��  ��2�� ɾ���Ӵ���ÿ�ַ��ƶ�һ��
    //ɾ��target����������patternƥ����Ӵ�������ɾ�����target��
    public static StringBuffer removeAll(StringBuffer target, String pattern)
    {
        int n=target.length(), m=pattern.length();
        int empty=target.indexOf(pattern), next=empty;     //emptyΪ�׸���patternƥ���Ӵ����
        while (next!=-1)                                   //ѭ��ÿ��ɾ��һ��ƥ���Ӵ�
        {
            int move=next+m;                               //moveΪ���ƶ��Ӵ����
            next = target.indexOf(pattern, move);          //nextΪ��move��ʼ���¸�ƥ���Ӵ����
            while (next>0 && move<next || next<0 && move<n)//��move��next-1֮���Ӵ���ǰ�ƶ���empty��
                target.setCharAt(empty++, target.charAt(move++));
        }
        if (empty!=-1)
            target.setLength(empty);                       //����target������Ϊempty        
        return target;
    }

    public static void main(String args[]) 
    {
        StringBuffer target = new StringBuffer("aaaa");    //��3.4��1���滻�Ӵ�
        String pattern="a", str="ab";
        System.out.println("replaceAll(\""+target+"\", \""+pattern+"\", \""+str+"\")=\""+
                replaceAll(target, pattern, str)+"\"");

    	target = new StringBuffer("ababccdefabcabcgh");    //ͼ3.13
        pattern="abc";
        System.out.println("removeAll(\""+target+"\", \""+pattern+"\")=\""+removeAll(target, pattern)+"\"");
        System.out.println("removeAll(\""+target+"\", \""+pattern+"\")=\""+removeAll(target, pattern)+"\"");
    }
}
/*
�������н�����£�
replaceAll("aaaa", "a", "ab")="abababab"                   //��3.4��1���滻�Ӵ�
removeAll("ababccdefabcabcgh", "abc")="abcdefgh"           //ͼ3.13
removeAll("abcdefgh", "abc")="defgh"


*/
/*
�������˵����ʵ����3-13���
1��replaceAll()����
       ���while��������£���pattern="a", replacement="ab"ʱ����ѭ����
    i=target.indexOf(pattern, i);
    ���while��������£���pattern="a", replacement="aab"ʱ����ѭ����
    i=target.indexOf(pattern, i+1);
    

    
*/

