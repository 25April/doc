//�����ݽṹ��Java�棩����4�棩ϰ������ʵ��ָ���������ߣ�Ҷ���ǣ�2014��12��31�գ�JDK 8.25
//��2.3 ���Ա����ʽ�洢��ʵ��
//3. ��ͷ���ĵ�������
//��˼����2-8��ϰ���� �ϲ����ӵ�����
//����2.1��  ��������Ϊ���������뷵��ֵ�������ۡ�

public class SinglyList_addAll 
{
	public static void main(String args[])
    {
        //(1) ���ӣ�ǳ����������ӣ������
		String[] valuea={"a","b","c"}, valueb={"x","y"};
	    SinglyList<String> lista = new SinglyList<String>(valuea);
	    SinglyList<String> listb = new SinglyList<String>(valueb);
        System.out.println("lista="+lista.toString()+"\nlistb="+listb.toString());
        lista.addAll(listb);                      //2.15��a������lista֮������listb
        System.out.println("lista.concat(listb);");
        System.out.println("lista="+lista.toString()+"\nlistb="+listb.toString());
        listb.insert("z");
        System.out.println("listb.insert(\"z\");");
        System.out.println("lista="+lista.toString()+"\nlistb="+listb.toString());
        
/*        lista.append(listb);
        System.out.println("lista.append(listb);\nlista: "+lista.toString());
        System.out.println("listb: "+listb.toString());

        ExSinglyList<String> listc = new ExSinglyList<String>(listb);//���
	    System.out.println("listc: "+listc.toString());


	    listb.append("q");
	    System.out.println("listb.append(\"q\")\nlista: "+lista.toString());
	    System.out.println("listb: "+listb.toString());
	    
        //(2) �����ӱ������
        ExSinglyList<String> listsub = lista.sub(0,3);
        System.out.println("listsub = lista.sub(0,3);\nlistsub: "+listsub.toString());

*/
	}
}
/*
�������н�����£�    
        //(1)û������listΪ��
lista=ExSinglyList(a,b,c)
listb=ExSinglyList(x,y)
lista.concat(listb);
lista=ExSinglyList(a,b,c,x,y)
listb=ExSinglyList(x,y)
listb.insert("z");                                         //����������������
lista=ExSinglyList(a,b,c,x,y,z)
listb=ExSinglyList(x,y,z)

        //(2)û������listΪ��
lista=ExSinglyList(a,b,c)
listb=ExSinglyList(x,y)
lista.concat(listb);
lista=ExSinglyList(a,b,c,x,y)
listb=ExSinglyList()
listb.insert("z");                                         //��������listb�������������޹�
lista=ExSinglyList(a,b,c,x,y)
listb=ExSinglyList(z)

lista: (a,b,c)
listb: (x,y)
listc: (x,y)
lista.append(listb);
lista: (a,b,c,x,y)
listb: (x,y)
listb.append("z");
lista: (a,b,c,x,y)
listb: (x,y,z)
lista.concat(listb);
lista: (a,b,c,x,y,x,y,z)
listb: ()
listb.append("q")
lista: (a,b,c,x,y,x,y,z)
listb: (q)
listsub = lista.sub(0,3);
listsub: (a,b,c)
lista.search(listsub): a
��(a,b,c,x,y,x,y,z)��(x,y)ȫ���滻Ϊ(a,b,c)�Ľ����(a,b,c,a,b,c,a,b,c,z)
lista.replaceAll(listc, listsub);
lista: (a,b,c,a,b,c,a,b,c,z)
��(a,b,c,a,b,c,a,b,c,z)��(a,b,c)ȫ��ɾ���Ľ����(z)
lista.removeAll(listsub);
lista: (z)


*/