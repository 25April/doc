//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��9��8�գ�JDK 8.25
//��2.2  ���Ա��˳��洢��ʵ��
//��2.2.3  ����˳���
//����2.4��  ������Ϣ�ķ���ͳ�ơ����Һ����������

public class SeqList_Student
{
    //����ͳ�����Ա�list��Ԫ����Ϣ���ֶ���Ϣ����grade���飬���ر���ͳ�ƽ��������
    public static int[] groupCount(SeqList<Student> list, int grade[])
//    public static int[] groupCount(SinglyList<Student> list, int grade[])
//    public static int[] groupCount(CirDoublyList<Student> list, int grade[])
    {
        int result[] = new int[grade.length];    //result���鱣��ͳ�ƽ��
        for (int i=0; i<list.size(); i++)
        {
            Student stu = list.get(i);           //���list�ĵ�i��Ԫ�أ��������ø�ֵ
            for (int j=0; j<grade.length-1; j++)
                if (stu.score>=grade[j] && stu.score<grade[j+1]) //�ж�stu��Χ
                {
                    result[j]++;
                    break;                       //�˳��ڲ�ѭ��
                }
        }
        return result;                           //����result����������õ�����
    }
    
    //������Ա�listԪ�ؼ�����ͳ�ƽ��
    public static void printCount(SeqList<Student> list, String titles[], int result[])
//    public static void printCount(SinglyList<Student> list, String titles[], int result[])
//    public static void printCount(CirDoublyList<Student> list, String titles[], int result[])
    {
        System.out.print("ѧ�����ϣ�"+list.toString()+"\n��"+list.size()+"�ˣ��ɼ�ͳ�ƣ�");
        for (int i=0; i<titles.length; i++)
            System.out.print(titles[i]+result[i]+"�ˣ�");
        System.out.println();        
    }
    
    public static void main(String args[])
    {
        Student group[]={new Student("����",85), new Student("����",75), new Student("��ǿ",90),
                         new Student("��С��",80),new Student("����ŵ",60),new Student("����",65)}; 
        SeqList<Student> lista = new SeqList<Student>(group);//����˳����������ṩ��ֵ
//        SinglyList<Student> lista = new SinglyList<Student>(group);//���죬�������ṩ��ֵ
//        CirDoublyList<Student> lista = new CirDoublyList<Student>(group);//���죬�������ṩ��ֵ
        lista.insert(new Student("��С��",70));               //β����
        
        int[] grade={0,60,70,80,90,100};                    //ָ���ֶ���Ϣ
        String[] titles={"������","����","�е�","����","����"};      //�ַ�������ָ����������
        int[] result = groupCount(lista, grade);            //����ͳ�ƣ����ش��ͳ�ƽ��������
        printCount(lista, titles, result);

        String name = "��С��";
        Student key = new Student(name,0);                  //key�������������������ң��Ƚ����
        System.out.println("\""+name+"\"�ĳɼ��ǣ�"+lista.get(lista.search(key)).score);
//        System.out.println("ɾ��"+lista.remove(key));
        
        SeqList<Student> slistb = new SortedSeqList<Student>(lista);//��˳���������˳�����ֵ����
//        SinglyList<Student> slistb = new SortedSinglyList<Student>(lista);//��˳���������˳���
//        CirDoublyList<Student> slistb = new SortedDoublyList<Student>(lista);//��˳���������˳���
        int score=70;
        key = new Student("����",score);                       //key�����ɼ����Ƚϴ�С�����ɼ����������
        slistb.insert(key);                //�����ڵ�ֵ���֮ǰ
        result = groupCount(slistb, grade);                //����ͳ�ƣ�slistb��������ʵ������ֵ����
        printCount(slistb, titles, result);                //slistb��������ʵ������ֵ����
        System.out.println("�ɼ�Ϊ"+score+"�ֵ�ѧ���ǣ�"+slistb.get(slistb.search(key)).name);
    }
}
/*
�������н�����£�
ѧ�����ϣ�SeqList((����,85), (����,75), (��ǿ,90), (��С��,80), (����ŵ,60), (����,65), (��С��,70)) 
��7�ˣ��ɼ�ͳ�ƣ�������0�ˣ�����2�ˣ��е�2�ˣ�����2�ˣ�����1�ˣ�
"��С��"�ĳɼ��ǣ�80                                               //���������ҡ���С�������ҵ�ǰһ��Ԫ��
ɾ��(��С��,80)
ѧ�����ϣ�SortedSeqList((����ŵ,60), (����,65), (��С��,70), (����,75), (����,85), (��ǿ,90)) 
��6�ˣ��ɼ�ͳ�ƣ�������0�ˣ�����2�ˣ��е�2�ˣ�����1�ˣ�����1�ˣ�
SortedSeqList.indexOf((,70),0)��(����ŵ,60)��(����,65)��(��С��,70)���ɼ�Ϊ70�ֵ�ѧ���ǣ���С��


//������������ѭ��˫����
ѧ�����ϣ�SinglyList((����,85),(����,75),(��ǿ,90),(��С��,80),(����ŵ,60),(����,65),(��С��,70))
��7�ˣ��ɼ�ͳ�ƣ�������0�ˣ�����2�ˣ��е�2�ˣ�����2�ˣ�����1�ˣ�
"��С��"�ĳɼ��ǣ�80
ɾ��(��С��,80)
ѧ�����ϣ�SortedSinglyList((����ŵ,60),(����,65),(����,70),(��С��,70),(����,75),(����,85),(��ǿ,90))
��7�ˣ��ɼ�ͳ�ƣ�������0�ˣ�����2�ˣ��е�3�ˣ�����1�ˣ�����1�ˣ�
�ɼ�Ϊ70�ֵ�ѧ���ǣ�����


*/
/*
2015��1��30�գ�У����
��һ���о�������˳���
    public static SeqList<Integer> groupCount(SeqList<Student> list, int grade[])


 * */
