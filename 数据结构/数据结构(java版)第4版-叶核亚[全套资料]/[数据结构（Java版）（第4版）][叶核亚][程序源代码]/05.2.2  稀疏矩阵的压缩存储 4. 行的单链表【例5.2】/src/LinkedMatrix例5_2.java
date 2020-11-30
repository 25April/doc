//�����ݽṹ��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2014��7��17��
//��5.2.2 ϡ������ѹ���洢
//4.  ϡ������еĵ�����
//����5.2��  ϡ�����Ĵ洢�����㣬�����еĵ�����
//��ʵ����5-3��

class LinkedMatrix��5_2
{
    public static void main(String args[])
    {
        //A
        Triple[] elemsa={new Triple(0,2,11), new Triple(0,4,17),
                         new Triple(1,1,20),
                         new Triple(3,0,19), new Triple(3,2,36), new Triple(3,5,28),
                         new Triple(4,2,50)};
        LinkedMatrix mata = new LinkedMatrix(5,6,elemsa);
        System.out.print("����5.2�� A ������Ԫ���еĵ�����\n"+mata.toString());
        mata.printMatrix();
        int i=3, j=5;
        System.out.println("MatrixA["+i+"]["+j+"]="+mata.get(i,j));
        mata.set(i,j,0);
        System.out.println("MatrixA["+i+"]["+j+"]="+mata.get(i,j));
        mata.set(i,j,18);
        System.out.println("MatrixA["+i+"]["+j+"]="+mata.get(i,j));
        mata.set(i,j,28);
        System.out.println("MatrixA["+i+"]["+j+"]="+mata.get(i,j));
//        mata.printMatrix();
       
        //B
        Triple[] elemsb={new Triple(0,2,-11), new Triple(0,4,-17),
                         new Triple(1,1,0),                //���洢ֵΪ0Ԫ��
                         new Triple(2,3,51),
                         new Triple(3,0,10),
                         new Triple(4,1,99)};
        LinkedMatrix matb = new LinkedMatrix(5,6,elemsb);
        System.out.print("\nB ������Ԫ���еĵ�����\n"+matb.toString());
        matb.printMatrix2();        
        
        //C=A��C+=B 
        LinkedMatrix matc = new LinkedMatrix(mata);        //��ȿ�������ʵ����5-3��
        System.out.println("\nC=A ������Ԫ���еĵ�����\n"+matc.toString());
        matc.addAll(matb);
        System.out.println("\nC=A��C+=B ������Ԫ���еĵ�����\n"+matc.toString());
        matc.printMatrix();
        
/*        //D=A+B
        LinkedMatrix matd = mata.union(matb);              //��ʵ����5-3��
        System.out.println("\nD=A+B ������Ԫ���еĵ�����\n"+matd.toString());
        matd.printMatrix();
        System.out.println("D.equals(C)��"+matd.equals(matc));
        
        LinkedMatrix mate = mata.transpose();              //��ʵ����5-3��
        System.out.println("\nA��ת�þ���  ��Ԫ���еĵ�����\n"+mate.toString());
        mate.printMatrix();*/
    }
}
/*
�������н�����£�
����5.2�� A ������Ԫ���еĵ�����
0 -> PolySinglyList((0,2,11),(0,4,17))
1 -> PolySinglyList((1,1,20))
2 -> PolySinglyList()
3 -> PolySinglyList((3,0,19),(3,2,36),(3,5,28))
4 -> PolySinglyList((4,2,50))
����LinkedMatrix��5��6����
   0   0  11   0  17   0
   0  20   0   0   0   0
   0   0   0   0   0   0
  19   0  36   0   0  28
   0   0  50   0   0   0
MatrixA[3][5]=28
MatrixA[3][5]=0
MatrixA[3][5]=18
MatrixA[3][5]=28

B ������Ԫ���еĵ�����
0 -> PolySinglyList((0,2,-11),(0,4,-17))
1 -> PolySinglyList()
2 -> PolySinglyList((2,3,51))
3 -> PolySinglyList((3,0,10))
4 -> PolySinglyList((4,1,99))
����LinkedMatrix��5��6����
   0   0 -11   0 -17   0
   0   0   0   0   0   0
   0   0   0  51   0   0
  10   0   0   0   0   0
   0  99   0   0   0   0

C=A ������Ԫ���еĵ�����
0 -> PolySinglyList((0,2,11),(0,4,17))
1 -> PolySinglyList((1,1,20))
2 -> PolySinglyList()
3 -> PolySinglyList((3,0,19),(3,2,36),(3,5,28))
4 -> PolySinglyList((4,2,50))


C=A��C+=B ������Ԫ���еĵ�����
0 -> PolySinglyList()
1 -> PolySinglyList((1,1,20))
2 -> PolySinglyList((2,3,51))
3 -> PolySinglyList((3,0,29),(3,2,36),(3,5,28))
4 -> PolySinglyList((4,1,99),(4,2,50))

����LinkedMatrix��5��6����
   0   0   0   0   0   0
   0  20   0   0   0   0
   0   0   0  51   0   0
  29   0  36   0   0  28
   0  99  50   0   0   0

D=A+B ������Ԫ���еĵ�����
0 -> PolySinglyList()
1 -> PolySinglyList((1,1,20))
2 -> PolySinglyList((2,3,51))
3 -> PolySinglyList((3,0,29),(3,2,36),(3,5,28))
4 -> PolySinglyList((4,1,99),(4,2,50))

����LinkedMatrix��5��6����
   0   0   0   0   0   0
   0  20   0   0   0   0
   0   0   0  51   0   0
  29   0  36   0   0  28
   0  99  50   0   0   0
D.equals(C)��true

A��ת�þ���  ��Ԫ���еĵ�����
0 -> PolySinglyList((0,3,19))
1 -> PolySinglyList((1,1,20))
2 -> PolySinglyList((2,0,11),(2,3,36),(2,4,50))
3 -> PolySinglyList()
4 -> PolySinglyList((4,0,17))
5 -> PolySinglyList((5,3,28))

����LinkedMatrix��6��5����
   0   0   0  19   0
   0  20   0   0   0
  11   0   0  36  50
   0   0   0   0   0
  17   0   0   0   0
   0   0   0  28   0

*/
//@author��Yeheya��2015-10-12
