//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��14��
//8.3 �ֿ����
//����8.1�� �жϸ����ַ����Ƿ�ΪJava�ؼ��֡�
//��˼����8-2�����飬������

public class KeyWords_ͼ8_4  
{
    //�ؼ��ֱ�
    private static String[] keywords={"abstract","assert","boolean","break","byte","case","catch",
        "char","class","continue","default","do","double","else","extends","false","final","finally",
        "float","for","if","implements","import","instanceof","int","interface","long","native","new",
        "null","package","private","protected","public","return","short","static","super","switch",
        "synchronized","this","throw","throws","transient","true","try","void","volatile","while"};

    private static class IndexItem implements Comparable<IndexItem>  //�����˽���ڲ���
    {
        String first;                                      //�ؼ��ֵ�����ĸ
        int begin;                                         //����ĸ��ͬ�Ĺؼ��ֿ��������е���ʼ�±�
        public IndexItem(String first,int i)
        {
            this.first=first;
            begin=i; 
        }
        public String toString()                           //����������������ַ���
        {
            return "("+this.first+","+begin+")";
        }
        public int compareTo(IndexItem item)               //Լ������������Ƚϴ�С�Ĺ���ʵ��Comparable�ӿ�
        {
            return this.first.compareTo(item.first);       //������ĸ�Ƚϴ�С
        }
    }//�ڲ������

    private static IndexItem index[];                      //������
    static                                                 //��̬��ʼ��������������
    {
        index = new IndexItem[26];
        int i=0,j=0;
        for (i=0; i<index.length && j<keywords.length; i++)
        {
            char ch=keywords[j].charAt(0);
            index[i]=new IndexItem(ch+"",j);
            j++;
            while (j<keywords.length && keywords[j].charAt(0)==ch)
                j++;
        }
        
        System.out.print("index[]:");
        Array1.print(index);                        //����1.4
/*        for (i=0; i<index.length; i++)
            if (index[i]!=null)
                System.out.print(index[i].toString()+" ");
        System.out.println();*/
    }

    public static boolean isKeyword(String str)            //�ж�str�Ƿ�ΪJava�ؼ���
    {
        IndexItem item = new IndexItem(str.substring(0,1),-1);   //����ĸ��Ӧ��������
        int pos=SortedArray.binarySearch(index, item);               //�۰�������������������λ��
        int begin=index[pos].begin;                                //���������ҷ�Χ���½�
        int end=index[pos+1].begin-1;                           //���������ҷ�Χ���Ͻ�
        return SortedArray.binarySearch(keywords,begin,end,str)>=0;   //�۰��������ָ����Χ
    }
        
    public static void main(String[] args) 
    {                                            //Ĭ�����Ƚ��о�̬��ʼ��������������
        String str="final";
        System.out.println(str+(isKeyword(str)?"":"��")+"�ǹؼ���");
        str ="length";
        System.out.println(str+(isKeyword(str)?"":"��")+"�ǹؼ���");
    }
}

/*
�������н�����£�
index[]:(a,0) (b,2) (c,5) (d,10) (e,13) (f,15) (i,20) (l,26) (n,27) (p,30) (r,34) (s,35) (t,40) (v,46) (w,48) 
(t,40)? (f,15)? finally? false? final? final�ǹؼ���
(t,40)? (f,15)? (n,27)? (i,20)? (l,26)? long? length���ǹؼ���

*/

