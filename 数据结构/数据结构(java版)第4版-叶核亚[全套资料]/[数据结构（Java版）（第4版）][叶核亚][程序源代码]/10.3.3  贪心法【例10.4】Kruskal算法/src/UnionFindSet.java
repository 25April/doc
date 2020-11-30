//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��11��2��
//10.3   �㷨��Ʋ���
//10.3.3   ̰�ķ�
//5.  Kruskal�㷨ʵ��
//��3�����鼯
public class UnionFindSet                        //���鼯��
{
    private int parent[];                        //��ָ������
    
    public UnionFindSet(int n)                   //������n��Ԫ�صĲ��鼯������ǰ���n������ɭ��               
    {
        this.parent = new int[n];
        for (int i=0; i<n; i++)                  //��ָ������Ԫ��ֵΪ-1����ʾÿ����ֻ��һ�����
            this.parent[i]=-1;
//Ҳ��        java.util.Arrays.fill(this.parent, -1);  //����������Ԫ��ֵ���Ϊ-1
    }

    //���Ҳ����ص�i��Ԫ���������ĸ��±ꡣ�㷨���Ÿ�ָ������Ѱ��ֱ����
    public int find(int i)
    {
        while (this.parent[i]>=0)                //��i���Ǹ�
            i=this.parent[i];                    //�ҵ�������±�
        return i;                                //���ظ�����±�
    }
    
    //���ϲ����㣬��i��j����ͬһ�����У���ϲ����i��j���ڵ�������������true�����򷵻�false
    //���Ȳ��Ҳ��ֱ𷵻ؽ��i��j�������ĸ�����������϶��һ������Ϊ��һ�����ĺ��ӽ��
    public boolean union(int i, int j)
    {
        int rooti=find(i), rootj=find(j);                  //rooti��rootj�ֱ��ý��i��j�������ĸ�
        if (rooti!=rootj)                                  //��i��j����ͬһ������ʱ����ϲ�i��j���ڵ�������
            if (parent[rooti]<=parent[rootj])              //��rooti���������������϶�
            {                                              //��j���ڵ����ϲ���i���ڵ���
                this.parent[rooti]+=this.parent[rootj];    //��������
                this.parent[rootj]=rooti;                  //��rootj��Ϊrooti�ĺ��ӣ�Ԫ��Ϊ������±�
            }
            else                                           //��i���ڵ����ϲ���j���ڵ���
            {
                this.parent[rootj]+=this.parent[rooti];
                this.parent[rooti]=rootj;                  //��rooti��Ϊrootj�ĺ��ӽ��
            }
        return rooti!=rootj;                               //���غϲ����״̬
    }
    
    public String toString()                     //���ز��鼯����Ԫ�أ���ʽΪ��(,)��
    {
        String str="(";
        if (this.parent.length>0)
            str += this.parent[0];
        for (int i=1; i<this.parent.length; i++)
            str += ", "+this.parent[i];
        return str+") ";
    }
    
    public static void main(String args[])
    {
        //������p263ͼ6.4
        UnionFindSet ufset = new UnionFindSet(10);          //���鼯
        ufset.union(0,6);
        ufset.union(0,7);
        ufset.union(0,8);
        ufset.union(1,4);
        ufset.union(1,9);        
        System.out.println("���鼯��"+ufset.toString());
        ufset.union(0,1);
        System.out.println("���鼯��"+ufset.toString());
    }    
/*
�������н�����£�
���鼯��(-4, -3, -1, -1, 1, -1, 0, 0, 0, 1) 
���鼯��(-7, 0, -1, -1, 1, -1, 0, 0, 0, 1) 
*/

    //���Ҳ�����Ԫ��i�������ĸ��±꣬ͬʱ�����۵�����ѹ��·����
    //�㷨���Ÿ�ָ������Ѱ��ֱ����������i����·���ϵ����н�㶼�ĳɸ��ĺ���
    public int collapsingFind(int i)
    {
        int root=i;
        while (this.parent[root]>=0)                       //�ҵ�i�������ĸ�����±�
            root=this.parent[root];
        while (root!=i && parent[i]!=root)                 //��i���Ǹ���i���Ǹ��ĺ���ʱ
        {
            int pa = parent[i];
            parent[i]=root;                                //��i��Ϊroot�ĺ��ӽ��
            i=pa;                                          //���ϵ�i�ĸ����
        }
        return root;                                       //���ظ�����±�
    }
}