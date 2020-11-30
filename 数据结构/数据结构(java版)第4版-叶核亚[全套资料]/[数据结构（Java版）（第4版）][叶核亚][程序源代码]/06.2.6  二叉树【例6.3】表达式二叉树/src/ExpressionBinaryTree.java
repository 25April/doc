//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��7��
//6.2.6   �������Ķ�������ʵ��
//����6.3��  �������ʽ��������������ʽֵ��

//���ʽ�������࣬�̳ж�������     
public class ExpressionBinaryTree extends BinaryTree<ExpData>
{
    public ExpressionBinaryTree()                          //����ն�����
    {
        super();
    }
    
    public ExpressionBinaryTree(String prefix)             //��ǰ׺���ʽprefix������ʽ������
    {
        this.root = createPrefix(prefix); 
    }

    private int i=0;                             //���ظ���������i�������i��˽��Ȩ�ޣ����಻�ɼ�
    //�Դ�prefix�ĵ�i���ַ���ʼ��ǰ׺���ʽ�Ӵ��������ӱ��ʽ���������������������ĸ���㣬�ݹ��㷨
    private BinaryNode<ExpData> createPrefix(String prefix)
    { 
        BinaryNode<ExpData> p=null;
        if (i<prefix.length())
        {
            char ch = prefix.charAt(i);
/*����            while (i<prefix.length() && ch==' ')           //��������ո�
            {
                i++;
                if (i<prefix.length())
                    ch = prefix.charAt(i);
            }*/
            if (ch>='0' && ch<='9')                        //���������ַ�
            {
                int value=0;      
                while (i<prefix.length() && ch!=' ')       //�������ַ���ת��Ϊ����ֵ���㷨ͬ��4.2
                {
                    value = value*10 + ch-'0';
                    i++;
                    if (i<prefix.length())
                        ch = prefix.charAt(i);
                }
                p = new BinaryNode<ExpData>(new ExpData(value,' '));//������ֵ��㣬Ҷ��
                i++;                                       //�����������һ���ո�
            }
            else                                           //�����������㣬2�Ƚ��
            {
                p = new BinaryNode<ExpData>(new ExpData(0,prefix.charAt(i)));
                i++;
                p.left = createPrefix(prefix);             //�������������ݹ����
                p.right = createPrefix(prefix);            //�������������ݹ����
            }
        }
        return p;
    }

    public int toValue()                                   //�����������ʽ����������ֵ
    {
        return this.toValue(this.root);
    }

    //������������������p���Ϊ����������p����value�洢���������ݹ��㷨
    private int toValue(BinaryNode<ExpData> p)
    {
        if (p==null)
            return 0;
        if (!p.isLeaf())
            switch (p.data.oper)                           //��Ҷ�ӽ�㣬����������ֱ����
            {
                case '+': p.data.value = toValue(p.left) + toValue(p.right); break;
                case '-': p.data.value = toValue(p.left) - toValue(p.right); break;
                case '*': p.data.value = toValue(p.left) * toValue(p.right); break;
                case '/': p.data.value = toValue(p.left) / toValue(p.right); //������������Ϊ0��Java���׳������쳣
            }
        return p.data.value;
    }
    //�̳��ȸ����и���������������������֧�ֲ����㡢ɾ������������ʡ��
    
    public static void main(String args[])
    {
    //"45+(10-15)*((25+35)/(60-40))-11"};  //ͼ6.21 ���ʽ��������

//        String prefix=" -  1 2  3";       //ǰ׺���ʽ���ݹ��㷨�����Զ����ַ���
        String prefix="-+45 *-10 15 /+25 35 -60 40 11";       //ͼ6.21 ǰ׺���ʽ���ݹ��㷨�����Զ����ַ���
        ExpressionBinaryTree expbitree1 = new ExpressionBinaryTree(prefix);//��ǰ׺���ʽprefix������ʽ������
        System.out.print("ǰ׺���ʽ��  ");  expbitree1.preorder(); //����ȸ������������
        System.out.print("��׺���ʽ��  ");  expbitree1.inorder();  //����и������������
        System.out.print("��׺���ʽ��  ");  expbitree1.postorder();//�����������������
//        System.out.println("size="+expbitree.size());
        System.out.println("value="+expbitree1.toValue());
    }
}
/*
�������н�����£�
                                                           //ͼ6.21 ���ʽ������
ǰ׺���ʽ��  - + 45 * - 10 15 / + 25 35 - 60 40 11 
��׺���ʽ��  45 + 10 - 15 * 25 + 35 / 60 - 40 - 11 
��׺���ʽ��  45 10 15 - 25 35 + 60 40 - / * + 11 - 
value=19
SeqStack (45) 
SeqStack (45, 10) 
SeqStack (45, 10, 15) 
SeqStack (45, -) 
SeqStack (45, -, 25) 
SeqStack (45, -, 25, 35) 
SeqStack (45, -, +) 
SeqStack (45, -, +, 60) 
SeqStack (45, -, +, 60, 40) 
SeqStack (45, -, +, -) 
SeqStack (45, -, /) 
SeqStack (45, *) 
SeqStack (+) 
SeqStack (+, 11) 
SeqStack (-) 
ǰ׺���ʽ��  - + 45 * - 10 15 / + 25 35 - 60 40 11 
��׺���ʽ��  45 + 10 - 15 * 25 + 35 / 60 - 40 - 11 
��׺���ʽ��  45 10 15 - 25 35 + 60 40 - / * + 11 - 


                                                           //��4.2 ��׺���ʽ
ǰ׺���ʽ��  - + 123 / * 10 + - 45 50 20 + * - 35 25 2 10 11 
��׺���ʽ��  123 + 10 * 45 - 50 + 20 / 35 - 25 * 2 + 10 - 11 
��׺���ʽ��  123 10 45 50 - 20 + * 35 25 - 2 * 10 + / + 11 - 
value=117

*/

//@author��Yeheya��2014-10-7
