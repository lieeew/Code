public class TestFor13 {
    public static void main(String[] arges){
//        ��Ǯ��ټ���
//        ����5��Ǯһֻ��ĸ��3��Ǯһֻ��С��3ֻһ��Ǯ��
//        ��100��Ǯ��һ��ֻ��,���й�����ĸ����С��������Ҫ�У��ʹ�����ĸ����С��Ҫ�����ֻ�պô���100��Ǯ��
        for(int x = 1;x <=100;x++){
            for(int y = 1;y <= 100;y++){
                for(int z =1;y <= 100;z++){
                    if(x +y + z == 100&&5*x + 3*y +z/3 ==100&&z%3==0){
                        System.out.println(x + "\t" + y +"\t" + z );
                    }
                }
            }

        }

    }
}