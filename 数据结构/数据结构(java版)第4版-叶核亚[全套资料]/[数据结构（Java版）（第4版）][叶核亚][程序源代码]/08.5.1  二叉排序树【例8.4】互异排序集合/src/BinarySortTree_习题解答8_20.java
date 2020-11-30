//�����ݽṹ��Java�棩����4�棩ϰ���𡷣����ߣ�Ҷ���ǣ�2015��3��20��
//8.5.1   ����������
//��ϰ����8-20�� �����������Ĳ����ɾ������������ASL�ɹ���

class BinarySortTree_ϰ����8_20
{
    public static void main(String args[])
    {
        Integer[] values={50,16,74,60,43,16,90,46,31,29,88,71,64,13,65};    //ϰ8-20
        BinarySortTree<Integer> bstree=new BinarySortTree<Integer>(values);
        bstree.inorder();
        bstree.printASL();
        
        Integer key = bstree.removeRoot();       
        System.out.print("\nɾ����"+key+"������"+key+"��");
        bstree.add(key);                                   //����ԭ��ֵ
        bstree.inorder(); 
        bstree.printASL();
    }
}
/*
�������н�����£�
[13 16 29 31 43 46 50 60 64 65 71 74 88 90 ]
ASL�ɹ�=(1*1+2*2+3*4+4*4+5*2+6*1)/14 =49/14 =3.5

ɾ����50������50��[13 16 29 31 43 46 50 60 64 65 71 74 88 90 ]
ASL�ɹ�=(1*1+2*2+3*4+4*4+5*3)/14 =48/14 =3.4285714285714284


*/
//@author��Yeheya��2015-3-20
