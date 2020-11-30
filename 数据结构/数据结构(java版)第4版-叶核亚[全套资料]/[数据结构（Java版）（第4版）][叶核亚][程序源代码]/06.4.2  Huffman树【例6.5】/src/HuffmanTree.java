//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��22��
//6.4  Huffman��

public class HuffmanTree                                   //Huffman����
{
    private String charset;                                //�ַ�����
    private TriElement[] huftree;                          //��̬��������������
 
    //����Huffman����weightsָ��Ȩֵ���ϣ����鳤��ΪҶ�ӽ������Ĭ���ַ����ϴ�A��ʼ
    public HuffmanTree(int[] weights)
    {
        this.charset = "";
        for (int i=0; i<weights.length; i++)               //Ĭ���ַ������Ǵ�'A'��ʼ��weights.length���ַ�
            this.charset += (char)('A'+i);    
        
        int n = weights.length;                            //Ҷ�ӽ����
        this.huftree = new TriElement[2*n-1];              //n��Ҷ�ӵ�Huffman������2n-1�����
        for(int i=0; i<n; i++)                             //Huffman����ʼ��n��Ҷ�ӽ��
            this.huftree[i] = new TriElement(weights[i]);  //�����޸�ĸ��Ҷ�ӽ��

        for(int i=n; i<2*n-1; i++)                         //����n-1��2�Ƚ��
        {
            int min1=Integer.MAX_VALUE, min2=min1;         //��С�ʹ�СȨֵ����ֵΪ�������ֵ
            int x1=-1, x2=-1;                              //��С�ʹ�СȨֵ����±�
            for (int j=0; j<i; j++)                        //Ѱ�������޸�ĸ����СȨֵ����±�
                if (this.huftree[j].parent==-1)            //��j������޸�ĸ
                    if (this.huftree[j].data<min1)         //��j�����Ȩֵ��С
                    {
                        min2 = min1;                       //min2�ǵô�СȨֵ
                        x2 = x1;                           //x2�ǵô�СȨֵ����±�
                        min1 = this.huftree[j].data;       //min1�ǵ���СȨֵ
                        x1 = j;                            //x1�ǵ���СȨֵ����±�
                    }
                    else
                        if (this.huftree[j].data<min2)     //��j�����Ȩֵ��С
                        {
                            min2 = huftree[j].data; 
                            x2 = j;
                        }

            this.huftree[x1].parent = i;                   //�ϲ�����Ȩֵ��С��������������С
            this.huftree[x2].parent = i;
            this.huftree[i] = new TriElement(min1+min2, -1, x1, x2); //�����㣬ָ��ֵ����ĸ�����Һ���
        }
    }
    
    private String getCode(int i)                 //����charset��i���ַ���Huffman�����ַ���
    {
        int n=8;
        char hufcode[] = new char[n];                      //�����ַ������ݴ�Huffman����
        int child=i, parent=this.huftree[child].parent;
        for (i=n-1; parent!=-1; i--)                       //��Ҷ�������ֱ������㣬����洢����
        {
            hufcode[i] = (huftree[parent].left==child) ? '0' : '1';  //���Һ��ӱ���Ϊ0��1
            child = parent;
            parent = huftree[child].parent;        
        }                       
        return new String(hufcode,i+1,n-1-i);    //��hufcode�����i+1��ʼ��n-1-i���ַ����촮
    }

    public String toString()                     //����Huffman���Ľ������������ַ��ı����ַ���
    {
        String str="Huffman���Ľ������:";
        for (int i=0; i<this.huftree.length; i++)
            str += this.huftree[i].toString()+"��";
        str += "\nHuffman���룺 ";
        for (int i=0; i<this.charset.length(); i++)        //�������Ҷ�ӽ���Huffman����
            str+=this.charset.charAt(i)+"��"+getCode(i)+"��";
        return str;
    }

    //����ѹ������text���ַ�ת����Huffman����洢������ѹ���ַ���
    public String encode(String text)
    {
        String compressed="";                              //��ѹ�������ݣ����ַ�����ʾ
        for (int i=0; i<text.length(); i++) 
            compressed += getCode(text.charAt(i)-'A');     //Ĭ���ַ����Ǵ�A��ʼ��n���ַ�
        return compressed;
    }

    //���ݽ�ѹ������ѹ��compressed�е�0/1���н���Huffman���룬���������ַ���
    public String decode(String compressed)
    {
        String text="";
        int node=this.huftree.length-1;               //node����һ���Ӹ�����Ҷ�ӵ�·��
        for (int i=0; i<compressed.length(); i++) 
        {
            if (compressed.charAt(i)=='0')            //����0��1�ֱ�������Һ�����
                node = huftree[node].left;
            else
                node = huftree[node].right;
            if (huftree[node].isLeaf())               //����Ҷ�ӽ��
            {
                text += this.charset.charAt(node);    //���һ���ַ�
                node = this.huftree.length-1;         //node�ٴӸ���㿪ʼ
            }
        }
        return text;
    }
}

/*
�������˵�����¡�
��1��huftree����Ϊ�������ȡ�ɣ�����Ҫ����Ϊ˳�����Ϊֻ�в��룬û��ɾ�������ݵ����⡣
��2�����췽���У���������Сֵ����ʡ��min1��min2������û�г�ֵ���㷨�����������
��3��ֻ�ܲ���Ĭ���ַ����ϣ���֧�������������������ʱ��Ҫ����ָ���ַ���Ҫ��ʱ�䡣
    //����Huffman����charsetָ���ַ����ϣ�weights[]ָ��Ȩֵ���ϣ����鳤��ΪҶ�ӽ����
    public HuffmanTree(String charset, int[] weights)
    {
        if (charset==null)                       //Ĭ���ַ��������Ǵ�'A'��ʼ��weights.length���ַ�        
        {����
        }
        else
            this.charset = charset;                        //ָ���ַ�����

��4������ת���ɶ����ƣ�Ҫ��λ���㣬̫����Ҳ�ѣ���ת���ص㡣�γ������
��5����������С��ѡ����Сֵ����Ϊ����Ҫѡ����Сֵ��ͬʱ��Ҫ�ǵ���Сֵ����λ�ã����ܽ������ӹ�ϵ������С��ֻ��ѡ��Сֵ��
*/
//@author  Yeheya��2014-7-22