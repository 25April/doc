//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��16��
//8.5.1   ����������
//ͼ8.15��ͼ8.17�������������Ĳ��롢���Һ�ɾ������������ASL�ɹ���

class BinarySortTree_ͼ8_16
{
    public static void main(String args[])
    {
    	//ͼ8.15��ͼ8.17�����롢����
        Integer[] values={54,18,81,99,36,12,12,76,57,6,66};  //ͼ8.15��a��
        BinarySortTree<Integer> bstree=new BinarySortTree<Integer>(values); //�������������
        System.out.print("ͼ8.15��");
        bstree.inorder();                                  //�и��������������������������ؼ����������е�Ԫ������
//        bstree.inorderPrevious();
        bstree.printASL();

        Integer key = 57;
        System.out.println("����"+key+"��"+(bstree.search(key)!=null?"":"��")+"�ɹ� ");
        key = 40;
        System.out.println("����"+key+"��"+(bstree.search(key)!=null?"":"��")+"�ɹ� ");
        
        System.out.print("\nͼ8.16��");
        System.out.print("����"+key+"��");
        bstree.add(key);                                   //����40��ͼ8.16
        bstree.inorder();                                  //�и������������������
        bstree.printASL();
       
        Integer[] delete={12,36,values[0]};                //ͼ8.20��a����b����ɾ��1�Ƚ�㣻ͼ8.20��c����ɾ������2�Ƚ��
        System.out.print("\nͼ8.20��ɾ��");
        for (Integer k : delete)
            System.out.print(bstree.remove(k)+"��");
        key = values[0];             
        System.out.print("����"+key+"��");
        bstree.add(key);
        bstree.inorder();
        bstree.printASL();
        
        while (bstree.root!=null)                          //ɾ������ɾ��ȫ�����
        {
            System.out.print("ɾ��"+bstree.removeRoot()+"��");
            bstree.inorder();
        }
    }
}
/*
�������н�����£�
ͼ8.15��[6 12 18 36 54 57 66 76 81 99 ]
ASL�ɹ�=(1*1+2*2+3*4+4*2+5*1)/10 =30/10 =3.0
����57���ɹ� 
����40�����ɹ� 

ͼ8.16������40��[6 12 18 36 40 54 57 66 76 81 99 ]
ASL�ɹ�=(1*1+2*2+3*4+4*3+5*1)/11 =34/11 =3.090909090909091

ͼ8.20��ɾ��12��36��54������54��[6 18 40 54 57 66 76 81 99 ]
ASL�ɹ�=(1*1+2*2+3*4+4*2)/9 =25/9 =2.7777777777777777
ɾ��57��[6 18 40 54 66 76 81 99 ]
ɾ��66��[6 18 40 54 76 81 99 ]
ɾ��76��[6 18 40 54 81 99 ]
ɾ��81��[6 18 40 54 99 ]
ɾ��99��[6 18 40 54 ]
ɾ��18��[6 40 54 ]
ɾ��40��[6 54 ]
ɾ��54��[6 ]
ɾ��6��[]

*/
//@author��Yeheya��2015-3-20
