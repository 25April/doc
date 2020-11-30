//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��22��
//6.4  Huffman��
//����6.5��  ����Huffman�㷨���ַ�����������ѹ���ͽ�ѹ����

public class HuffmanTree_ex 
{
    public static void main(String[] args)
    {        
        String text="AAAABBBCDDBBAAA";                     //����6.4�� ����
        int[] weight6_28={7,5,1,2};                        //ͼ6.26ָ��Ȩֵ���ϣ�Ĭ���ַ���Ϊ"ABCD"
        HuffmanTree huffman = new HuffmanTree(weight6_28); //����Huffman��
        System.out.println(huffman.toString());            //���Huffman���Ľ������������ַ�����
        String compressed = huffman.encode(text);
        System.out.println("��"+text+"ѹ��Ϊ"+compressed+"��"+compressed.length()+"λ");
        System.out.println("��"+compressed+"����Ϊ"+huffman.decode(compressed));

        
        int[] weight6_34={5,29,7,8,14,23,3,11};            //ͼ6.34ָ��Ȩֵ���ϣ�Ĭ���ַ���Ϊ"ABCDEFGH"
        huffman = new HuffmanTree(weight6_34);             //����Huffman��
        System.out.println(huffman.toString());            //���Huffman���Ľ������������ַ�����
    }   
}
/*
�������н�����£�
Huffman���Ľ������:(7,6,-1,-1)��(5,5,-1,-1)��(1,4,-1,-1)��(2,4,-1,-1)��(3,5,2,3)��(8,6,4,1)��(15,-1,0,5)��
Huffman���룺 A��0��B��11��C��100��D��101��
��AAAABBBCDDBBAAAѹ��Ϊ00001111111001011011111000��26λ
��00001111111001011011111000����ΪAAAABBBCDDBBAAA

Huffman���Ľ������:(5,8,-1,-1)��(29,13,-1,-1)��(7,9,-1,-1)��(8,9,-1,-1)��(14,11,-1,-1)��(23,12,-1,-1)��(3,8,-1,-1)��(11,10,-1,-1)��(8,10,6,0)��(15,11,2,3)��(19,12,8,7)��(29,13,4,9)��(42,14,10,5)��(58,14,1,11)��(100,-1,12,13)��
Huffman���룺 A��0001��B��10��C��1110��D��1111��E��110��F��01��G��0000��H��001��



*/
//@author  Yeheya��2014-7-22
