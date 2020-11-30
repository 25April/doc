//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��6��
//5.3   �����
//5.3.3   �����˫����ʾ��ʵ��
//����5.3��������˫����ʾ�������㷨��
//��2�� �ɹ�����ʾ��������

public class GenList_String            //���﷨ͼ��������GenList<String>��
{
    private static int i=0;
    public static GenList<String> create(String gliststr)  //������gliststr��ʾ�����Ĺ����
    {
        i=0;
        return createsub(gliststr);
    }

    //���ش�gliststr[i]��ʼ���Ӵ��������ӹ�������ַ�����ʾԭ�ӣ��ݹ鷽��
    private static GenList<String> createsub(String gliststr)
    {
        i++;                                               //����'('
        GenList<String> glist = new GenList<String>();     //����չ����ֻ��ͷ���
        GenNode<String> p = glist.head;                    //ָ��ͷ���
        while (i<gliststr.length())
        {
            char ch=gliststr.charAt(i);
            switch (ch)
            {
                case ',':  i++; break;
                case '(': 
                {
                    p.next=new GenNode<String>();          //�����ӱ���
                    p = p.next; 
                    p.child = createsub(gliststr);         //�����ӱ��ݹ����
                    break;
                }
                case ')':  i++; return glist;
                default :                                  //���ַ�����ʾԭ��
                {
                    int j=i+1;
                    ch=gliststr.charAt(j);
                    while (ch!='(' && ch!=',' && ch!=')')
                        ch=gliststr.charAt(++j);
                    p.next=new GenNode<String>(gliststr.substring(i,j)); //�������
                    p = p.next; 
                    i=j;
                }
            }
        }
        return null;
    }
   
    public static void main(String args[])
    {
        String[] name={"empty","L","T","G","S"};           //��������
        String[] gliststr={"()",                           //���������
                           "(a,b)",
                           "(c,(a,b))",
                           "(d,(a,b),(c,(a,b)))",
                           "(and,(begin,end),(my,your,(his,her)))"};//�����Ԫ��ֵ���ַ���
        //����,������"�й�(����, �Ϻ�, ����(�Ͼ�, ����), �㽭(����))");
        for (int i=0; i<name.length; i++)
        {
            GenList<String> glist = create(gliststr[i]);   //��������
            System.out.println(name[i]+"="+glist.toString()+"��size="+glist.size()+ 
                               "��depth="+glist.depth()); 
        }      
    }
}
/*
�������н�����£�
empty=()��  size=0��depth=1
L=(a,b)��  size=2��depth=1
T=(c,(a,b))��  size=2��depth=2
G=(d,(a,b),(c,(a,b)))��  size=3��depth=3
S=(and,(begin,end),(my,your,(his,her)))��  size=3��depth=3


*/
//author��Yeheya��2014-10-6