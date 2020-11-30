//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2015��2��7��
//3.3.2   KMP�㷨

public class KMP 
{
//	private static int count=0;                            //���رȽϴ���
	private static int[] next;                             //ģʽ��pattern�Ľ���next����
	private static int[] nextk;                            //ģʽ��patternδ�Ľ���next����

    //����Ŀ�괮target���׸���ģʽ��patternƥ����Ӵ���ţ�ƥ��ʧ��ʱ����-1
    public static int indexOf(String target, String pattern)
    {
        return indexOf(target, pattern, 0);
    }
    
    //����Ŀ�괮target��begin��ʼ�׸���ģʽ��patternƥ����Ӵ���ţ�ƥ��ʧ��ʱ����-1��
    //0��begin<target.length()����begin�ݴ���begin<0����0��ʼ����begin���Խ�磬���Ҳ��ɹ���
    //��target��patternΪnull���׳��ն����쳣��
    public static int indexOf(String target, String pattern, int begin)
    {
        int n=target.length(), m=pattern.length();
        if (begin<0)                                       //��begin�ݴ���begin<0����0��ʼ
            begin = 0;
        if (n==0 || n<m || begin>=n)                       //��Ŀ�괮�ա��϶̻�beginԽ�磬����Ƚ�
            return -1;

        int count=0;                                       //���رȽϴ���
        nextk = getNextk(pattern);
        print(pattern);
        System.out.print("nextk[]: ");  print(nextk);
        next = getNext(pattern);                           //����ģʽ��pattern�Ľ���next����
        System.out.print("next[]:  ");  print(next);

        int i=begin, j=0;                                  //i��j�ֱ�ΪĿ�괮��ģʽ���Ƚ��ַ��±�
        while (i<n && j<m)
        {
            if(j!=-1) count++;
            if (j==-1 || target.charAt(i)==pattern.charAt(j))//����ǰ���ַ���ȣ�������ȽϺ����ַ�
            {
                if (j!=-1)
                    System.out.print("t"+i+"=p"+j+"��");
                i++;
                j++;
            }
            else                                           //�����´�ƥ�䣬Ŀ�괮�±�i������
            {
                System.out.println("t"+i+"!=p"+j+"��next["+j+"]="+next[j]);
                j=next[j];                                 //ģʽ���±�j�˻ص��´αȽ��ַ����
                if (n-i+1<m-j+1)                           //��Ŀ�괮ʣ���Ӵ��ĳ��Ȳ��������ٱȽϣ�   //�ȵ�3�����Ӵ˾�
                    break;
            }
        }
        System.out.println("\tKMP.count="+count);
        if (j==m)                                          //ƥ��ɹ�
            return i-j;                                    //����ƥ����Ӵ����
        return -1;                                         //ƥ��ʧ��
    }

    private static int[] getNextk(String pattern)          //����ģʽ��pattern��next����
    {
        int j=0, k=-1, next[]=new int[pattern.length()];
        next[0]=-1;
        while (j<pattern.length()-1)
            if (k==-1 || pattern.charAt(j)==pattern.charAt(k))
            {
                j++;
                k++;
                next[j]=k;                                 //�д��Ľ�
            }
            else k=next[k];
        return next;
    }

    private static int[] getNext(String pattern)           //����ģʽ��pattern�Ľ���next����
    {
        int j=0, k=-1, next[]=new int[pattern.length()];
        next[0]=-1;
        while (j<pattern.length()-1)
            if (k==-1 || pattern.charAt(j)==pattern.charAt(k))
            {
                j++;
                k++;
                if (pattern.charAt(j)!=pattern.charAt(k))  //�Ľ�֮��
                    next[j]=k;
                else
                    next[j]=next[k];  
            }
            else k=next[k];
        return next;
    }

    private static void print(int[] next)                  //���next[]����
    {
        for (int i=0; i<next.length; i++)
            System.out.print(String.format("%3d", next[i]));
        System.out.println();
    }
    private static void print(String pattern)
    {
        System.out.print("pattern: ");
        for (int i=0; i<pattern.length(); i++)
            System.out.print("  "+pattern.charAt(i));
        System.out.println();
    }

    public static void main(String args[]) 
    {
// 	      String target="abcabb", pattern="abb";             //ͼ3.14��a��  Ŀ�괮������
//        String target="aacabb", pattern="aab";             //ͼ3.14��b��  Ŀ�괮������
//        String target="abcdabcabbabcabc", pattern="abcabc"; //ͼ3.15��ͼ3.17
//        String target="abcabdabcabcaa", pattern="abcabdabcabcaa";  //��3-2����3-4
    	
//        String target="aababcd", pattern="abcd";           //ͼ3.11��BF����
//        String target="aaaaa", pattern="aab";              //������ͼ3.12(b)BF��ͼ3.18KMP

    	//ϰ����
//        String target="aaabaaaba", pattern="aaaa";           //ϰ3-9(2)BF��ϰͼ3.5~ϰͼ3.6
          String target="abcababcabababcababc", pattern="ababcababc"; //˼����3-6��ϰ����3-10(6)��ϰͼ3.7
        
        System.out.println("KMP.indexOf(\""+target+"\", \""+pattern+"\")="+KMP.indexOf(target, pattern));
    }
}

/*
�������н�����£�
pattern:   a  b  b
nextk[]:  -1  0  0
next[]:   -1  0  0
t0=p0��t1=p1��t2!=p2                                         //ƥ��3��
t2!=p0
t3=p0��t4=p1��t5=p2��
KMP.count=7
KMP.indexOf("abcabb", "abb")=3                             //ͼ3.14��a��  Ŀ�괮������


pattern:   a  a  b                                         //ͬ��3-5
nextk[]:  -1  0  1
next[]:   -1 -1  1
t0=p0��t1=p1��t2!=p2                                         //ƥ��4��
t2!=p1
t3=p0��t4!=p1
t5!=p0
KMP.count=7
KMP.indexOf("aacabb", "aab")=-1                            //ͼ3.14��b��  Ŀ�괮������


pattern:   a  b  c  a  b  c
nextk[]:  -1  0  0  0  1  2                                //��3-1
next[]:   -1  0  0 -1  0  0                                //��3-3
t0=p0��t1=p1��t2=p2��t3!=p3                                  //ƥ��4��
t4=p0��t5=p1��t6=p2��t7=p3��t8=p4��t9!=p5
t9!=p0
t10=p0��t11=p1��t12=p2��t13=p3��t14=p4��t15=p5��
KMP.count=17
KMP.indexOf("abcdabcabbabcabc", "abcabc")=10               //ͼ3.15��ͼ3.17


pattern:   a  b  c  a  b  d  a  b  c  a  b  c  a  a
nextk[]:  -1  0  0  0  1  2  0  1  2  3  4  5  3  4        //��3-2
next[]:   -1  0  0 -1  0  2 -1  0  0 -1  0  5 -1  4        //��3-4
KMP.count=14
KMP.indexOf("abcabdabcabcaa", "abcabdabcabcaa")=0


pattern:   a  b  c  d
nextk[]:  -1  0  0  0
next[]:   -1  0  0  0
t0=p0��t1!=p1                                               //KMPƥ��3�Σ�BFƥ��4��
t1=p0��t2=p1��t3!=p2
t3=p0��t4=p1��t5=p2��t6=p3��
KMP.count=9
KMP.indexOf("aababcd", "abcd")=3                           //ͼ3.11��BF����

pattern:   a  a  b                                         //��3-5
nextk[]:  -1  0  1
next[]:   -1 -1  1
t0=p0��t1=p1��t2!=p2                                        //KMPƥ��4�Σ�BFƥ��4��
t2=p1��t3!=p2
t3=p1��t4!=p2
	KMP.count=7
KMP.indexOf("aaaaa", "aab")=-1                             //������ͼ3.18��ƥ�䲻�ɹ����Ƚ�n+m��


pattern:   a  a  a  a                                      //ϰ����ϰ3-9(2)BF��ϰ��3-1
nextk[]:  -1  0  1  2
next[]:   -1 -1 -1 -1

t0=p0��t1=p1��t2=p2��t3!=p3��next[3]=2                         //ϰͼ3.5��ʹ��δ�Ľ���next���飩
t3!=p2��next[2]=1
t3!=p1��next[1]=0
t3!=p0��next[0]=-1
t4=p0��t5=p1��t6=p2��t7!=p3��next[3]=2
t7!=p2��next[2]=1
	KMP.count=12
KMP.indexOf("aaabaaaba", "aaaa")=-1

t0=p0��t1=p1��t2=p2��t3!=p3                                   //ϰͼ3.6��ʹ��δ�Ľ���next���飩
t4=p0��t5=p1��t6=p2��t7!=p3
	KMP.count=8
KMP.indexOf("aaabaaaba", "aaaa")=-1


pattern:   a  b  a  b  c  a  b  a  b  c                    //˼����3-6��ϰ����3-10(6)��ϰͼ3.7
nextk[]:  -1  0  0  1  2  0  1  2  3  4
next[]:   -1  0 -1  0  2 -1  0 -1  0  2
t0=p0��t1=p1��t2!=p2��next[2]=-1
t3=p0��t4=p1��t5=p2��t6=p3��t7=p4��t8=p5��t9=p6��t10=p7��t11=p8��t12!=p9��next[9]=2
t12=p2��t13=p3��t14=p4��t15=p5��t16=p6��t17=p7��t18=p8��t19=p9��	KMP.count=21
KMP.indexOf("abcababcabababcababc", "ababcababc")=10


*/
//@author��Yeheya��2015-2-26