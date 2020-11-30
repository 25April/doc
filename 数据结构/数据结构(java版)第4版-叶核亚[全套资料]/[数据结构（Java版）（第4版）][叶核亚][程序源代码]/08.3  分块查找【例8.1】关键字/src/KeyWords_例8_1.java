//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��14��
//8.3 �ֿ����
//����8.1�� ���������������ѯJava�ؼ��֡�
//�������飬ʹ������������

public class KeyWords_��8_1  
{
    //����ؼ��ֱ����򣩣�����
    private static String[] keywords={"abstract","assert","boolean","break","byte","case","catch",
        "char","class","continue","default","do","double","else","extends","false","final","finally",
        "float","for","if","implements","import","instanceof","int","interface","long","native","new",
        "null","package","private","protected","public","return","short","static","super","switch",
        "synchronized","this","throw","throws","transient","true","try","void","volatile","while"};

    private static class IndexItem implements Comparable<IndexItem>  //�����˽���ڲ���
    {
        char first;                                        //�ؼ��ֵ����ַ�
        int begin,end;                                     //���ַ���ͬ�Ĺؼ��ֿ��������е�ʼĩ�±�
        public IndexItem(char first, int begin, int end)
        {
            this.first = first;
            this.begin = begin;
            this.end = end;
        }
        public String toString()                           //����������������ַ���
        {
            return "("+this.first+","+begin+","+end+")";
        }
        public int compareTo(IndexItem item)               //������Ƚ���Ⱥʹ�С��ʵ��Comparable�ӿ�
        {
            return this.first - item.first;                //���Ƚ����ַ�
        }
    }//�ڲ������

    private static IndexItem[] index;                      //������
    static                                                 //����������������̬��ʼ���飬�����ʱִ��һ��
    {
        index = new IndexItem[23];
        for (int i=0, j=0; i<index.length && j<keywords.length; i++)
        {
            char ch=(char)('a'+i);                         //��һ�����ַ�
            if (keywords[j].charAt(0)>ch)
                index[i]=new IndexItem(ch, -1, -1);        //�����������ʾһ�������ڵĿ�
            else
            { 
                int begin = j++;
                while (j<keywords.length && keywords[j].charAt(0)==ch)//Ѱ����һ�����ַ���ͬ�Ĺؼ���
                    j++;
                index[i]=new IndexItem(ch, begin, j-1);    //�����������ʾһ�����ַ���ͬ�Ŀ�
            }
        }
        
        System.out.print("index[]:");
        Array1.print(index);                             //����������飬����1.4
    }
    
    public static boolean isKeyword(String str)            //�ж�str�Ƿ�ΪJava�ؼ���
    {
        int i = str.charAt(0)-'a';                         //���ַ���Ӧ�����������
        return i>=0 && i<index.length && index[i].begin!=-1 &&
            SortedArray.binarySearch(keywords, index[i].begin, index[i].end, str)>=0;
    }//���������ҷ�Χ���½�//���������ҷ�Χ���Ͻ�   //�۰���������ָ����Χ
 
    public static void main(String[] args) 
    {                                         //Ĭ�����Ƚ��о�̬��ʼ��������������
        String[] str={"and","final","length", "while","x"};
        for (int i=0; i<str.length; i++)
           System.out.println(str[i]+(isKeyword(str[i])?"":"��")+"�ǹؼ���");
    }
}

/*
�������н�����£�
index[]: (a,0,1) (b,2,4) (c,5,9) (d,10,12) (e,13,14) (f,15,19) (g,-1,-1) (h,-1,-1) (i,20,25) (j,-1,-1) (k,-1,-1) (l,26,26) (m,-1,-1) (n,27,29) (o,-1,-1) (p,30,33) (q,-1,-1) (r,34,34) (s,35,39) (t,40,45) (u,-1,-1) (v,46,47) (w,48,48)
abstract? assert? and���ǹؼ���
finally? false? final? final�ǹؼ���
long? length���ǹؼ���
while? while�ǹؼ���
x���ǹؼ���

*/

/*
�������˵�����£�
���ԣ���������˳���洢�ؼ��ֱ���β������Ҫ����˳���Ч�ʽϵ͡�������
*/
//@author��Yeheya��2014-8-14
