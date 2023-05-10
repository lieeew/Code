package com.hspedu.furns.test;

/**
 * ClassName: PatchTest
 * Package: com.hspedu.furns.test
 *
 * @Author: leikooo
 * @Creat: 2023/5/9 - 10:28
 * @Description:
 */
public class PatchTest {
    public static void main(String[] args) {
        String filePath = "E:\\github\\IDEA_front\\jiaju_mall_sencond\\out\\artifacts\\jiaju_mall_sencond_war_exploded\\assets\\images\\product-image\\2023\\5\\9/04d82a0a-9582-4eb3-b55b-de301a0c9a5e1683598846129_编程真是一辈都学不完.png";
        String assetsPath = "assets\\";
        // 取出assets后面的路径
        int index = filePath.indexOf(assetsPath);
        System.out.println("index = " + index); // 这里什么意思
        String path = filePath.substring(index);
        // 将反斜杠替换为斜杠
        String finalPath = path.replace("\\", "/");
        System.out.println("filePath = " + finalPath);
    }
}
